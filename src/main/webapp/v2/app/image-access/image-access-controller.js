var app = angular.module('home');


app.controller('imageAccessController', ['$scope', '$http', '$modal', '$modalInstance','vmStructureService', function ($scope, $http, $modal, $modalInstance, vmStructureService) {	
	
	$scope.vmGsAndCgFlatData = {};
	$scope.protectedSelectedIndex = -1;
	
	
	$scope.initData = function(){
		$scope.vmGsAndCgFlatData = vmStructureService.getCachedVmGsAndCgFlatData();
		$scope.protectedSelectedIndex = vmStructureService.getProtectedSelectedIndex();
		$scope.selectedCopy = $scope.vmGsAndCgFlatData[$scope.protectedSelectedIndex].replicaClusters[0].groupCopySettings[0];
		$scope.imageAccessType = 'latest';
		
		var isBookmarkImageAccessEnabled = false;
		var isSnapshotImageAccessEnabled = false;
		var bookmarks = $scope.selectedCopy.bookmarks;		
		var length = bookmarks.length;
				
        for (var i = 0; i < length; i++) {
            var currBookmark = bookmarks[i];
            if(currBookmark.imageAccessEnabled == true){
            	$scope.selectedBookmark = currBookmark;
    	    	$scope.imageAccessType = 'bookmark';
    	    	isBookmarkImageAccessEnabled = true;
    	    	break;
            }
        }
        
        if(!isBookmarkImageAccessEnabled){
        	$scope.selectedBookmark = $scope.selectedCopy.bookmarks[0];
        }
               
        
        if(!isBookmarkImageAccessEnabled){
        	var snapshots = $scope.selectedCopy.snapshots;
        	length = snapshots.length;
			
            for (var i = 0; i < length; i++) {
                var currSnapshot = snapshots[i];
                if(currSnapshot.imageAccessEnabled == true){
                	$scope.selectedSnapshot = currSnapshot;
        	    	$scope.imageAccessType = 'snapshot';
        	    	isSnapshotImageAccessEnabled = true;
        	    	break;
                }
            }
        }
        
            
        if(!isSnapshotImageAccessEnabled){
        	$scope.selectedSnapshot = $scope.vmGsAndCgFlatData[$scope.protectedSelectedIndex].replicaClusters[0].groupCopySettings[0].snapshots[0];
        }

	};
	   
	$scope.initData();
	
	
	$scope.imageAccess = function(){
	    	vmStructureService.imageAccess($scope.selectedCopy, $scope.imageAccessType, $scope.selectedSnapshot, $scope.selectedBookmark);  
	    	$scope.initData();
	}
	
	
/*	$scope.isActionApplicable = function(){
    	var res = false;  
    	
    	if($scope.selectedCopy.imageAccess == 'Enabled' || Object.keys($scope.imageAccessType).length != 0){
    		res = true; 
    	}
    	
    	return res;
    };*/
	
	
	$scope.cancel = function(){
		$modalInstance.dismiss('cancel');
	}
	   
    
}]);