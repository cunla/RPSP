angular.module('home', [])
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