var app = angular.module('home');


app.controller('protectController', ['$scope', '$http', '$modal', '$modalInstance','vmStructureService','modalParams',  function ($scope, $http, $modal, $modalInstance, vmStructureService, modalParams) {	
	
	$scope.vmGsAndCgFlatData = {};
	$scope.vmStructureData = {};
	$scope.protectedSelectedIndex = -1;
	$scope.vmId = {};
	$scope.cgId = {};
	$scope.vmName = {};
	$scope.cgName = {};

	
	
	$scope.initData = function(){
		$scope.vmGsAndCgFlatData = vmStructureService.getCachedVmGsAndCgFlatData();
		$scope.vmStructureData = vmStructureService.getCachedVmStructureData();
		$scope.vmId = $scope.vmStructureData.unprotectedVms[modalParams.vmIndex].id;
		$scope.cgId = $scope.vmGsAndCgFlatData[modalParams.cgIndex].id;
		$scope.vmName = $scope.vmStructureData.unprotectedVms[modalParams.vmIndex].name;
		$scope.cgName = $scope.vmGsAndCgFlatData[modalParams.cgIndex].name;
		$scope.protectedSelectedIndex = modalParams.cgIndex;		
		$scope.selectedCopy = $scope.vmGsAndCgFlatData[$scope.protectedSelectedIndex].replicaClusters[0].groupCopySettings[0];
	};
	   
	$scope.initData();
	
	
	$scope.moveVm = function(){
		    vmStructureService.moveVm($scope.vmId, $scope.cgId);
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