app.controller('groupSetController', ['$scope', '$http', '$modal', '$modalInstance','vmStructureService', function ($scope, $http, $modal, $modalInstance, vmStructureService) {	

	
	$scope.vmGsAndCgFlatData = {};
	$scope.protectedSelectedIndex = -1;
	$scope.consistencyType = 'app-consistency';
	$scope.groupName = {};
	$scope.groupType = {};
	
	
	$scope.initData = function(){
		$scope.vmGsAndCgFlatData = vmStructureService.getCachedVmGsAndCgFlatData();
		$scope.protectedSelectedIndex = vmStructureService.getProtectedSelectedIndex();
		var currGroup = $scope.vmGsAndCgFlatData[$scope.protectedSelectedIndex];
		$scope.groupName = currGroup.name;
		
		if(currGroup.type == 'gs'){
			$scope.groupType = 'Group Set';
		}
		else{
			$scope.groupType = 'Consistency Group';
		}
		
	};
	   
	$scope.initData();
	
	
	
	$scope.createGroupSet= function(){  
	    	$modalInstance.close($scope.groupSetName);
	};
	
	
	
	$scope.cancel = function(){
		$modalInstance.dismiss('cancel');
	};
	   
    
}]);