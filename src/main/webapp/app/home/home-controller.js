angular.module('home',  ['pascalprecht.translate', 'locale'])
  .controller('homeController', ['$scope', '$http', function($scope, $http) {   
	  $scope.currentUser = {};	  
	  $scope.getCurrentUser = function(){
		    $http.get('users/current-user')
		    .success(function(data,status,headers,config){
		        $scope.currentUser = data;
		    })		   
	   };
	   $scope.getCurrentUser();
}])


angular.module('home').controller('vmStructureController', ['$scope', '$http', function ($scope, $http) {
	
	$scope.vmStructureData = {};
	$scope.vmGsAndCgFlatData = {};
	$scope.totalVms = {};
	$scope.protectedVms = {};
	
	$scope.getVmStructureData = function(){
		    $http.get('/rpsp/account-vms/id')
		    .success(function(data,status,headers,config){
		        $scope.vmStructureData = data;
		        
		        //flatten the hierarchical data to be displayed in table
		        var vmGsAndCgFlatDataArr = new Array();
		        var topLevelContainers = $scope.vmStructureData.protectedVms;
		        var length = topLevelContainers.length;
		        for (var i = 0; i < length; i++) {
		            var currVmContainer = topLevelContainers[i];
		            vmGsAndCgFlatDataArr.push(currVmContainer);
		            if(currVmContainer.consistencyGroups != null){
		            	for(var j = 0; j < currVmContainer.consistencyGroups.length; j++){
		            		var currNestedCG = currVmContainer.consistencyGroups[j];
		            		currNestedCG.parent = currVmContainer.name;
		            		vmGsAndCgFlatDataArr.push(currNestedCG);
		            	}
		            }
		        }
		        $scope.vmGsAndCgFlatData = vmGsAndCgFlatDataArr;
		        
		        //count protected vms
		        var protectedVmsCount = 0;
		        length = vmGsAndCgFlatDataArr.length;
		        for (var i = 0; i < length; i++) {
		            var currVmContainer = vmGsAndCgFlatDataArr[i];
		            if(currVmContainer.vms != null){
		            	protectedVmsCount += currVmContainer.vms.length;
		            }
		        }
		        
		        //count unprotected vms
		        var unprotectedVmsCount = 0;
		        if($scope.vmStructureData.unprotectedVms != null){
		        	unprotectedVmsCount = $scope.vmStructureData.unprotectedVms.length;
		        }
		        
		        //summary
		        $scope.totalVms = protectedVmsCount + unprotectedVmsCount;
		        $scope.protectedVms = protectedVmsCount;
		        
		        
		        
		    })		   
	};
	   
	$scope.getVmStructureData();
	
    
    $scope.selectedIndex = -1;
    $scope.toggleSelect = function(ind){
        if( ind === $scope.selectedIndex ){
            $scope.selectedIndex = -1;
        } else{
            $scope.selectedIndex = ind;
        }
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