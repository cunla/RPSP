var app = angular.module('home');


app.controller('imageAccessController', ['$scope', '$http', '$modal', '$modalInstance','vmStructureService', function ($scope, $http, $modal, $modalInstance, vmStructureService) {	
	
	$scope.vmGsAndCgFlatData = {};
	$scope.protectedSelectedIndex = -1;
	
	$scope.initData = function(){
		$scope.vmGsAndCgFlatData = vmStructureService.getCachedVmGsAndCgFlatData();
		$scope.protectedSelectedIndex = vmStructureService.getProtectedSelectedIndex();
		
		if($scope.vmGsAndCgFlatData[$scope.protectedSelectedIndex].type == 'cg'){
	    	$scope.selectedCopy = $scope.vmGsAndCgFlatData[$scope.protectedSelectedIndex].replicaClusters[0].groupCopySettings[0];
	    	$scope.selectedSnapshot = $scope.vmGsAndCgFlatData[$scope.protectedSelectedIndex].replicaClusters[0].groupCopySettings[0].snapshots[0];
	    	$scope.selectedBookmark = $scope.vmGsAndCgFlatData[$scope.protectedSelectedIndex].replicaClusters[0].groupCopySettings[0].bookmarks[0];
	    	$scope.imageAccessType = {};
    	}
    	else{
    		$scope.selectedCopy = {};
	    	$scope.selectedSnapshot = {};
	    	$scope.selectedBookmark = {};
	    	$scope.imageAccessType = {};
    	}
	};
	   
	$scope.initData();
	
	
	$scope.imageAccess = function(){
	    	vmStructureService.imageAccess($scope.selectedCopy, $scope.imageAccessType, $scope.selectedSnapshot, $scope.selectedBookmark);    	
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