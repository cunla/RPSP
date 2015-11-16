var app = angular.module('home');


app.controller('protectCreateCgController', ['$scope', '$http', '$modal', '$modalInstance','vmStructureService', function ($scope, $http, $modal, $modalInstance, vmStructureService) {	
	
	$scope.vmStructureData = {};
	$scope.unprotectedVms = {};
	$scope.productionCluster = {};
	$scope.selectedReplicaCluster = {};
	$scope.selectedVms = {};
	$scope.cgName = '';
	$scope.replicationPolicy = {};
	$scope.enableReplication = true;
	
	
	
	$scope.initData = function(){
		$scope.vmStructureData = vmStructureService.getCachedVmStructureData();
		$scope.unprotectedVms = $scope.vmStructureData.unprotectedVms;
		$scope.productionCluster = $scope.vmStructureData.systemInfo.productionCluster;
		$scope.selectedReplicaCluster = $scope.vmStructureData.systemInfo.replicaClusters[0];
	};
	   
	$scope.initData();
	
	
	$scope.createCg = function(){
    	vmStructureService.createCg($scope.cgName, $scope.productionCluster.id, $scope.selectedReplicaCluster.id, $scope.selectedVms, $scope.enableReplication);
    	$modalInstance.dismiss('cancel');
	}
	
	
	$scope.cancel = function(){
		$modalInstance.dismiss('cancel');
	}
	   
    
}]);