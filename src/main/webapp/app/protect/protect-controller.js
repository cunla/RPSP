var app = angular.module('home');


app.controller('protectController', ['$scope', '$http', '$modal', '$modalInstance','vmStructureService','modalParams',  function ($scope, $http, $modal, $modalInstance, vmStructureService, modalParams) {	
	
	$scope.vmGsAndCgFlatData = {};
	$scope.vmStructureData = {};
	$scope.protectedSelectedIndex = -1;
	$scope.vmId = {};
	$scope.cgId = {};
	$scope.vmName = {};
	$scope.cgName = {};

	
	
	$scope.locateVmInfo = function(vmId, vmStructureData){
		var res;
	    for(var i = 0; i < vmStructureData.unprotectedVms.length; i++){
	    	if(vmStructureData.unprotectedVms[i].id == vmId){
	    		res = vmStructureData.unprotectedVms[i];
	    	}
	    }
	    return res;
	};
	
	
	
	$scope.locateCgInfo = function(cgId, vmGsAndCgFlatData){
		var res;
	    for(var i = 0; i < vmGsAndCgFlatData.length; i++){
	    	if(vmGsAndCgFlatData[i].id == cgId){
	    		res = vmGsAndCgFlatData[i];
	    	}
	    }
	    return res;
	};
	
	
	
	$scope.locateCgIndex = function(cgId, vmGsAndCgFlatData){
		var res;
	    for(var i = 0; i < vmGsAndCgFlatData.length; i++){
	    	if(vmGsAndCgFlatData[i].id == cgId){
	    		res = i
	    	}
	    }
	    return res;
	};
	
	
	$scope.initData = function(){
		$scope.vmGsAndCgFlatData = vmStructureService.getCachedVmGsAndCgFlatData();
		$scope.vmStructureData = vmStructureService.getCachedVmStructureData();
		$scope.vmId = modalParams.vmId;
		$scope.cgId = modalParams.cgId;
		var vmInfo = $scope.locateVmInfo($scope.vmId, $scope.vmStructureData);
		$scope.vmName = vmInfo.name;
		var cgInfo = $scope.locateCgInfo($scope.cgId, $scope.vmGsAndCgFlatData);
		$scope.cgName = cgInfo.name;
		$scope.protectedSelectedIndex = $scope.locateCgIndex($scope.cgId, $scope.vmGsAndCgFlatData);	
		$scope.selectedCopy = $scope.vmGsAndCgFlatData[$scope.protectedSelectedIndex].replicaClusters[0].groupCopySettings[0];
		$scope.selectedSequenceNumber = 3;
		$scope.isCriticalVm = true;
	};
	
	   
	$scope.initData();
	
	
	
	$scope.moveVm = function(){
	    vmStructureService.moveVm($scope.vmId, $scope.cgId, $scope.selectedSequenceNumber - 1, $scope.isCriticalVm,'protect');
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