var app = angular.module('home');


app.controller('protectCreateCgController', ['$scope', '$http', '$modal', '$modalInstance', '$translate', '$filter','vmStructureService', 'vmId',
    function ($scope, $http, $modal, $modalInstance, $translate, $filter, vmStructureService, vmId) {

	$scope.vmStructureData = {};
	$scope.unprotectedVms = {};
	$scope.productionCluster = {};
	$scope.selectedReplicaCluster = {};
	$scope.selectedVms = {};
	$scope.cgName = '';
	$scope.replicationPolicy = {};
	$scope.enableReplication = true;
	$scope.rpoData = {};

	$scope.initData = function(){
		$scope.vmStructureData = vmStructureService.getCachedVmStructureData();
		$scope.unprotectedVms = $scope.vmStructureData.unprotectedVms;
        if(vmId){
		    for(i in $scope.unprotectedVms){
		        if($scope.unprotectedVms[i].id == vmId){
		            $scope.selectedVms=[$scope.unprotectedVms[i]];
		        }
		    }
		}
		$scope.productionCluster = $scope.vmStructureData.systemInfo.productionCluster;
		$scope.selectedReplicaCluster = $scope.vmStructureData.systemInfo.replicaClusters[0];

		var $translate = $filter('translate');
		var tierOne = $translate('PROTECT-UNPROTECT.RPO_TIER_1_MSG');
		var tierTwo = $translate('PROTECT-UNPROTECT.RPO_TIER_2_MSG');
		var tierThree = $translate('PROTECT-UNPROTECT.RPO_TIER_3_MSG');


		$scope.rpoData = [{"val" : tierOne, "rawVal" : 15},
			                  {"val" : tierTwo, "rawVal" : 30},
			                  {"val" : tierThree, "rawVal" : 45}];

		$scope.selectedRpo = $scope.rpoData[0];
	};

	$scope.initData();


	$scope.createCg = function(){
    	vmStructureService.createCg($scope.cgName, $scope.productionCluster.id, $scope.selectedReplicaCluster.id, $scope.selectedVms, $scope.enableReplication, $scope.selectedRpo.rawVal);
    	$modalInstance.dismiss('cancel');
	}


	$scope.cancel = function(){
		$modalInstance.dismiss('cancel');
	}


	$scope.getRpoVal = function(val){
		   var res = 15;
		   if(val != null && val !== undefined){

			   var $translate = $filter('translate');

			   if(val == $translate('PROTECT-UNPROTECT.RPO_TIER_1_MSG')){
				   res = 15
			   }
			   else if(val == $translate('PROTECT-UNPROTECT.RPO_TIER_2_MSG')){
				   res = 30;
			   }
			   else{
				   res = 45;
			   }
		   }
		   return res;
	  };


}]);
