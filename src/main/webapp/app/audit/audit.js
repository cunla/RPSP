var app = angular.module('home');


app.controller('auditController', ['$scope', '$http', '$modal', '$modalInstance','vmStructureService', function ($scope, $http, $modal, $modalInstance, vmStructureService) {


    $scope.cancel = function(){
		$modalInstance.dismiss('cancel');
	};


}]);
