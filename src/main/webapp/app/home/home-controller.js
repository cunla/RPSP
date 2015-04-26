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


angular.module('home').run(['localeService', function(localeService){
	localeService.setLocale();
}]);


angular.module('home').config(function ($translateProvider) {

  $translateProvider.useStaticFilesLoader({
    prefix: 'locales/locale-',
    suffix: '.json'
  });
  
});