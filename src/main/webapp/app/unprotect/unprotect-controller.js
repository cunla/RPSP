var app = angular.module('home');


app.controller('unprotectController', ['$scope', '$http', '$modal', '$modalInstance','vmStructureService','modalParams',  function ($scope, $http, $modal, $modalInstance, vmStructureService, modalParams) {	
	
	$scope.vmGsAndCgFlatData = {};
	$scope.vmStructureData = {};
	$scope.protectedSelectedIndex = -1;
	$scope.vmId = {};
	$scope.cgId = {};
	$scope.vmName = {};
	$scope.cgName = {};
	$scope.vmIsCritical = {};
	$scope.vmSequenceNumber = {};

	
	
	$scope.locateVmInfo = function(vmId, vmGsAndCgFlatData){
		var res;
	    for(var i = 0; i < vmGsAndCgFlatData.length; i++){
	    	if(vmGsAndCgFlatData[i].type == 'cg'){
	    		for(var j = 0; j < vmGsAndCgFlatData[i].vms.length; j++){
	    			var currVm = vmGsAndCgFlatData[i].vms[j];
	    			if(currVm.id == vmId){
	    				res = currVm;
	    			}
	    		}
	    	}
	    }
	    return res;
	};
	
	
	
	$scope.locateParentCgInfo = function(vmId, vmGsAndCgFlatData){
		var res;
	    for(var i = 0; i < vmGsAndCgFlatData.length; i++){
	    	if(vmGsAndCgFlatData[i].type == 'cg'){
	    		for(var j = 0; j < vmGsAndCgFlatData[i].vms.length; j++){
	    			var currVm = vmGsAndCgFlatData[i].vms[j];
	    			if(currVm.id == vmId){
	    				res = vmGsAndCgFlatData[i];
	    			}
	    		}
	    	}
	    }
	    return res;
	};
	
	
	
	$scope.locateParentCgIndex = function(vmId, vmGsAndCgFlatData){
		var res;
	    for(var i = 0; i < vmGsAndCgFlatData.length; i++){
	    	if(vmGsAndCgFlatData[i].type == 'cg'){
	    		for(var j = 0; j < vmGsAndCgFlatData[i].vms.length; j++){
	    			var currVm = vmGsAndCgFlatData[i].vms[j];
	    			if(currVm.id == vmId){
	    				res = i;
	    			}
	    		}
	    	}
	    }
	    return res;
	};
	
	
	$scope.initData = function(){
		$scope.vmGsAndCgFlatData = vmStructureService.getCachedVmGsAndCgFlatData();
		$scope.vmStructureData = vmStructureService.getCachedVmStructureData();
		$scope.vmId = modalParams.vmId;
		var vmInfo = $scope.locateVmInfo($scope.vmId, $scope.vmGsAndCgFlatData);
		$scope.vmName = vmInfo.name;	
		$scope.isCriticalVm = vmInfo.critical;
		$scope.selectedSequenceNumber = vmInfo.sequenceNumber + 1;
		var cgInfo = $scope.locateParentCgInfo($scope.vmId, $scope.vmGsAndCgFlatData);
		$scope.cgId = cgInfo.id;
		$scope.cgName = cgInfo.name;
		$scope.protectedSelectedIndex = $scope.locateParentCgIndex($scope.vmId, $scope.vmGsAndCgFlatData);	
		$scope.selectedCopy = $scope.vmGsAndCgFlatData[$scope.protectedSelectedIndex].replicaClusters[0].groupCopySettings[0];
	};
	
	   
	$scope.initData();
	
	
	
	$scope.moveVm = function(){
	    vmStructureService.moveVm($scope.vmId, $scope.cgId, $scope.selectedSequenceNumber, $scope.isCriticalVm, 'unprotect');
	    $modalInstance.dismiss('cancel');
	}


	$scope.cancel = function(){
		$modalInstance.dismiss('cancel');
	}
		   
    
}]);



angular.module('home').run(['localeService', function(localeService){
	localeService.setLocale();
}]);


angular.module('home').config(function ($translateProvider) {

  $translateProvider.useStaticFilesLoader({
    prefix: 'locales/locale-',
    suffix: '.json'
  });
  
});