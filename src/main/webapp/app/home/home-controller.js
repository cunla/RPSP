var app = angular.module('home',  ['pascalprecht.translate', 'locale', 'ui.bootstrap']);


app.controller('homeController', ['$scope', '$http', 'userService', function($scope, $http, userService) {   
	
	  $scope.currentUser = {};
	  $scope.welcomeData = {};
	  
	  $scope.getCurrentUser = function(){		  
		  userService.getUserData().then(function(allData) {
		      $scope.currentUser = allData.currentUser;
		      $scope.welcomeData = allData.welcomeData;
		   });
		   
	   };
	   
	   $scope.getCurrentUser();
}])


app.controller('vmStructureController', ['$scope', '$http', '$modal', 'vmStructureService', function ($scope, $http, $modal, vmStructureService) {	
	
	$scope.vmStructureData = {};
	$scope.vmGsAndCgFlatData = {};
	$scope.totalVms = {};
	$scope.protectedVms = {};
	
	$scope.getVmStructureData = function(){
			vmStructureService.getVmStructureData().then(function(allData) {
		      $scope.vmStructureData = allData.vmStructureData;
		      $scope.vmGsAndCgFlatData = allData.vmGsAndCgFlatData;
		      $scope.totalVms = allData.totalVms;
		      $scope.protectedVms = allData.protectedVms;
		   });
	};
	   
	$scope.getVmStructureData();
	
	
	
	$scope.openImageAccessModal = function(){
		var modalInstance = $modal.open({
             templateUrl: 'app/image-access/image-access-modal.html',
             controller: 'imageAccessController'
         });
		
		modalInstance.result.then(function(){{}});
	};
	
	
    
    $scope.protectedSelectedIndex = -1;
    $scope.unprotectedSelectedIndex = -1;
    
    $scope.toggleSelect = function(ind, isProtected){
    	
    	vmStructureService.toggleSelect(ind, isProtected);
    	$scope.protectedSelectedIndex = vmStructureService.getProtectedSelectedIndex();
    	$scope.unprotectedSelectedIndex = vmStructureService.getUnprotectedSelectedIndex();
    };
    
    
    $scope.isActionApplicable = function(){
    	var res;    	
    	if($scope.protectedSelectedIndex != -1){
    		var entityType = $scope.vmGsAndCgFlatData[$scope.protectedSelectedIndex].type;
    		if(entityType == 'cg' || entityType == 'gs'){
				res = true;
			}
    	}
    	else{
    		res = false;
    	}
    	return res;
    };
    
    
    
    $scope.moveVm = function(vmId, sgId) {
    	vmStructureService.moveVm(vmId, sgId);
    	$scope.vmStructureData = vmStructureService.getCachedVmStructureData();
    	$scope.vmGsAndCgFlatData = vmStructureService.getCachedVmGsAndCgFlatData();
        $scope.$apply();
    };
        
    
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