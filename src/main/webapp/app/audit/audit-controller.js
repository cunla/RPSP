var app = angular.module('home');


app.controller('auditController', ['$scope', '$modal', '$modalInstance','auditService', function ($scope, $modal, $modalInstance, auditService) {

    auditService.getAuditLog().then(function(res){
        $scope.auditlog = res;
    })

    $scope.cancel = function(){
		$modalInstance.dismiss('cancel');
	};


}]);
