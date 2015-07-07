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


app.controller('vmStructureController', ['$scope', '$http', '$modal', '$translate', '$filter', 'vmStructureService', function ($scope, $http, $modal, $translate, $filter, vmStructureService) {	
	
	$scope.vmStructureData = {};
	$scope.vmGsAndCgFlatData = {};
	$scope.totalVms = {};
	$scope.protectedVms = {};
	$scope.loading = true;
	
	$scope.getVmStructureData = function(){
			vmStructureService.getVmStructureData().then(function(allData) {
		      $scope.vmStructureData = allData.vmStructureData;
		      $scope.vmGsAndCgFlatData = allData.vmGsAndCgFlatData;
		      $scope.totalVms = allData.totalVms;
		      $scope.protectedVms = allData.protectedVms;
		   })
		   .finally(function (res) {
			  $scope.loading = false;			  
		   })
	};
	   
	$scope.getVmStructureData();
	
	
	
	$scope.openImageAccessModal = function(){
		var modalInstance = $modal.open({
             templateUrl: 'app/image-access/image-access-modal.html',
             controller: 'imageAccessController',
             windowClass: 'image-access-modal'
         });
		
		modalInstance.result.then(function(){{}});
	};
	
	
	$scope.openRelevantProtectionModal = function(vmId, cgId){
		var params = {};
		params.vmId = vmId;
		params.cgId = cgId;
		var modalInstance;
		
		if(cgId !== undefined){
			modalInstance = $modal.open({
	             templateUrl: 'app/protect/protect-modal.html',
	             controller: 'protectController',
	             windowClass: 'protect-modal',
	             resolve: {
	                 modalParams : function () {
	                   return params;
	                 }
	             }
	         });
		}
		else{
			modalInstance = $modal.open({
	             templateUrl: 'app/unprotect/unprotect-modal.html',
	             controller: 'unprotectController',
	             windowClass: 'protect-modal',
	             resolve: {
	                 modalParams : function () {
	                   return params;
	                 }
	             }
	         });
		}
		
		modalInstance.result.finally(function(){
				$scope.vmStructureData = vmStructureService.getCachedVmStructureData();
		    	$scope.vmGsAndCgFlatData = vmStructureService.getCachedVmGsAndCgFlatData();
		    	$scope.totalVms = vmStructureService.getCachedTotalVms();
		    	$scope.protectedVms = vmStructureService.getCachedProtectedVms();
		});
		
		
	};
	
	
	$scope.openBookmarksModal = function(){
		var modalInstance = $modal.open({
             templateUrl: 'app/bookmarks/bookmarks-modal.html',
             controller: 'bookmarksController',
             windowClass: 'bookmarks-modal'
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
    
    
   $scope.getImageAccessIndicator = function(status){
	  
	   if(status != null || status !== undefined){
		   var $translate = $filter('translate');
		   var enabled = $translate('HOME.DR_TEST_ENABLED_MSG');
		   var disabled = $translate('HOME.DR_TEST_DISABLED_MSG');
		   return (status == 'Enabled' ? enabled : disabled);
	   }
	   return status;
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