var app = angular.module('home');


app.controller('protectCreateCgController', ['$scope', '$http', '$modal', '$modalInstance','vmStructureService', function ($scope, $http, $modal, $modalInstance, vmStructureService) {	
	
	$scope.vmStructureData = {};
	$scope.options = {};
	$scope.selection = {};
	
	
	$scope.initData = function(){
		$scope.vmStructureData = vmStructureService.getCachedVmStructureData();
		$scope.options = $scope.vmStructureData.unprotectedVms;
		$scope.selectedCluster = $scope.vmStructureData.systemInfo.replicaClusters[0];
	};
	   
	$scope.initData();
	
	
	$scope.cancel = function(){
		$modalInstance.dismiss('cancel');
	}
	   
    
}]);