var app = angular.module('home');

app.service('vmStructureService', ['$http', function ($http) {	
	
	var vmStructureData = {};
	var vmGsAndCgFlatData = {};
	var totalVms = {};
	var protectedVms = {};
	var allData = {};
	
	
	this.getVmStructureData = function(){
			
		return $http.get('/rpsp/account-vms')
		    .then(function(response){
		    			    	
		        vmStructureData = response.data;
		        
		        //flatten the hierarchical data to be displayed in table
		        var vmGsAndCgFlatDataArr = new Array();
		        var topLevelContainers = vmStructureData.protectedVms;
		        var length = topLevelContainers.length;
		        for (var i = 0; i < length; i++) {
		            var currVmContainer = topLevelContainers[i];
		            vmGsAndCgFlatDataArr.push(currVmContainer);
		            if(currVmContainer.consistencyGroups != null){
		            	for(var j = 0; j < currVmContainer.consistencyGroups.length; j++){
		            		var currNestedCG = currVmContainer.consistencyGroups[j];
		            		currNestedCG.parent = currVmContainer.name;
		            		vmGsAndCgFlatDataArr.push(currNestedCG);
		            	}
		            }
		        }
		        var newCg = {};
		        newCg.id = 'new-section';
		        newCg.name = 'New ...';
		        vmGsAndCgFlatDataArr.push(newCg);
		        vmGsAndCgFlatData = vmGsAndCgFlatDataArr;
		        
		        //count protected vms
		        var protectedVmsCount = 0;
		        length = vmGsAndCgFlatDataArr.length;
		        for (var i = 0; i < length; i++) {
		            var currVmContainer = vmGsAndCgFlatDataArr[i];
		            if(currVmContainer.vms != null){
		            	protectedVmsCount += currVmContainer.vms.length;
		            }
		        }
		        
		        //count unprotected vms
		        var unprotectedVmsCount = 0;
		        if(vmStructureData.unprotectedVms != null){
		        	unprotectedVmsCount = vmStructureData.unprotectedVms.length;
		        }
		        else{
		        	vmStructureData.unprotectedVms = new Array();
		        	unprotectedVmsCount = 0;
		        }
		        
		        //summary
		        totalVms = protectedVmsCount + unprotectedVmsCount;
		        protectedVms = protectedVmsCount;
		        
		        allData.vmStructureData = vmStructureData;
		        allData.vmGsAndCgFlatData = vmGsAndCgFlatData;
		        allData.totalVms = totalVms;
		        allData.protectedVms = protectedVms;
		        
		        return allData;
		        
		    })		   
	};
	
	this.getCachedVmStructureData = function(){
	    	return vmStructureData;
	};
	
	this.getCachedVmGsAndCgFlatData = function(){
    	return vmGsAndCgFlatData;
    };
    
    this.getCachedProtectedVms = function(){
    	return protectedVms;
    };
    
    this.getCachedTotalVms = function(){
    	return totalVms;
    };
    
    
    
    
	   
    var protectedSelectedIndex = -1;
    var unprotectedSelectedIndex = -1;
    
    this.toggleSelect = function(ind, isProtected){
    	if(isProtected == true){
	        if( ind === protectedSelectedIndex ){
	            protectedSelectedIndex = -1;
	        } else{	        	
	            protectedSelectedIndex = ind;
	        }
	        unprotectedSelectedIndex = -1;
    	}
    	else{
	        if( ind === unprotectedSelectedIndex ){
	            unprotectedSelectedIndex = -1;
	        } else{
	            unprotectedSelectedIndex = ind;
	        }
	        protectedSelectedIndex = -1;
    	}
    };
    
    this.getProtectedSelectedIndex = function(){
    	return protectedSelectedIndex;
    };
    
    this.getUnprotectedSelectedIndex = function(){
    	return unprotectedSelectedIndex;
    };
    

    
    this.moveVm = function(vmId, sgId, actionType) {
    	
    	var url;

    	//this is protect
    	if(actionType == 'protect'){
	    	var unprotectedVms = vmStructureData.unprotectedVms;
	        for (var i = 0; i < unprotectedVms.length; i++) {
	 
	            var currVm = unprotectedVms[i];
	                 
	            if (currVm.id == vmId) {
	            	var allCgAndGs = vmGsAndCgFlatData;
	            	for (var j = 0; j < allCgAndGs.length; j++) {
	            		if(allCgAndGs[j].id == sgId){
	            			allCgAndGs[j].vms.push(currVm);
	            		}
	            	}
	 
	                unprotectedVms.splice(i, 1);
	                protectedVms += 1;
	            }
	        }
	        
	       /* url = '/rpsp/protect' + '?' + 'vmId=' + vmId + '&' + 'groupId=' + sgId;
	        $http.put(url)
	    	.success(function(data,status,headers,config){	        
	    	})*/
    	}
    	//this is unprotect
    	else{
    		var allCgAndGs = vmGsAndCgFlatData
    		for (var i = 0; i < allCgAndGs.length; i++) {
    			
    			//this is not group set
    			if(allCgAndGs[i].type == 'cg'){
	    			for (var j = 0; j < allCgAndGs[i].vms.length; j++) {
	    				
	    				var currVm = allCgAndGs[i].vms[j];
	    				
	            		if(currVm.id == vmId){
	            			vmStructureData.unprotectedVms.push(currVm);
	            			allCgAndGs[i].vms.splice(j, 1);
	            			protectedVms -= 1;
	            		}
	            	}
    			}
        	}
    		/*url = '/rpsp/unprotect' + '?' + 'vmId=' + vmId + '&' + 'groupId=' + sgId;
    		$http.delete(url)
        	.success(function(data,status,headers,config){	        
        	})*/
    	}
    	
    	console.log(url);
    	
    	
    };
    
    
    this.imageAccess = function(selectedCopy, imageAccessType, selectedSnapshot, selectedBookmark){
    	var currCg = vmGsAndCgFlatData[protectedSelectedIndex];
    	var cgId = currCg.id;
    	var replicaClusterId = selectedCopy.clusterId;
    	var copyId = selectedCopy.id;
    	var accessType = imageAccessType;
    	var url;
    	
    	if(selectedCopy.imageAccess == 'Disabled'){
    	   url = '/rpsp/image-access/enable' + '?' + 'clusterId=' + replicaClusterId + '&' + 'groupId=' + cgId + '&' + 'copyId=' + copyId;
    	   if(accessType == 'snapshot'){
    		   url += '&' + 'snapshotId=' + selectedSnapshot.id + '&' + 'timestamp=' + selectedSnapshot.originalClosingTimeStamp;
    	   }
    	   else if(accessType == 'bookmark'){
    		   url += '&' + 'snapshotId=' + selectedBookmark.id + '&' + 'timestamp=' + selectedBookmark.originalClosingTimeStamp;
    	   }
    	   this.updateImageAccessFlags(selectedCopy, imageAccessType, selectedSnapshot, selectedBookmark, true);
    	}
    	else{
    	   url = '/rpsp/image-access/disable' + '?' + 'clusterId=' + replicaClusterId + '&' + 'groupId=' + cgId + '&' + 'copyId=' + copyId;
    	   this.updateImageAccessFlags(selectedCopy, imageAccessType, selectedSnapshot, selectedBookmark, false);
    	}
    	
    	
    	//console.log(url);
    	   	
	    $http.put(url)
	    	.success(function(data,status,headers,config){	        
	    })
    	
    }
    
    
    
    this.updateImageAccessFlags = function(selectedCopy, imageAccessType, selectedSnapshot, selectedBookmark, isEnableAccess){
    	var serviceDataSelectedCopy = vmGsAndCgFlatData[protectedSelectedIndex].replicaClusters[0].groupCopySettings[selectedCopy.id];
    	
    	var currSnapshot = null;
    	
    	if(imageAccessType == 'snapshot'){
    		currSnapshot = this.locateSnapshot(serviceDataSelectedCopy.snapshots, selectedSnapshot);
    	}
    	else if(imageAccessType == 'bookmark'){
    		currSnapshot = this.locateSnapshot(serviceDataSelectedCopy.bookmarks, selectedBookmark);
    	}
    	
    	if(isEnableAccess == true){
    		serviceDataSelectedCopy.imageAccess = 'Enabled';
    		if(currSnapshot != null){
    			currSnapshot.imageAccessEnabled = true;
    		}
    	}
    	else{
    		serviceDataSelectedCopy.imageAccess = 'Disabled';
    		if(currSnapshot != null){
    			currSnapshot.imageAccessEnabled = false;
    		}
    	}
    };
    
    
    this.locateSnapshot = function(snapshots, snapshotToSearch){
    	var length = snapshots.length;
		
        for (var i = 0; i < length; i++) {
            var currSnapshot = snapshots[i];
            if(currSnapshot.id == snapshotToSearch.id){
            	return currSnapshot;
            }
        }
    };
    
            
    
}]);