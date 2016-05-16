var app = angular.module('home');


app.controller('failoverAlertController', ['$scope', '$http', '$modal', '$modalInstance', '$window','vmStructureService', function ($scope, $http, $modal, $modalInstance, $window, vmStructureService) {	
	
	$scope.cancel = function(){
		$modalInstance.dismiss('cancel');
	}
	
	
	$scope.openAlertModal = function(){
		var modalInstance = $modal.open({
             templateUrl: 'app/failover/failover-alert-modal.html',
             controller: 'failoverAlertController',
             windowClass: 'image-access-modal'
         });
		
		modalInstance.result.then(function(){{}});
	};
	   
    
}]);