var HEADER_NAME = 'RPSP-Handle-Errors-Generically';
var specificallyHandleInProgress = false;
var app = angular.module('home');
app.controller('errorController',['$scope','$modalInstance','modalParams', function($scope,$modalInstance,modalParams){


	$scope.cancel = function(){
		$modalInstance.dismiss('cancel');
	}
}]);
