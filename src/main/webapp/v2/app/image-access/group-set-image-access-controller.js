var app = angular.module('home');


app.controller('groupSetImageAccessController', ['$scope', '$http', '$modal', '$modalInstance','vmStructureService', function ($scope, $http, $modal, $modalInstance, vmStructureService) {	
	
	$scope.vmGsAndCgFlatData = {};
	$scope.protectedSelectedIndex = -1;
	
	
	$scope.initData = function(){
		$scope.vmGsAndCgFlatData = vmStructureService.getCachedVmGsAndCgFlatData();
		$scope.protectedSelectedIndex = vmStructureService.getProtectedSelectedIndex();
		$scope.selectedCluster = $scope.vmGsAndCgFlatData[$scope.protectedSelectedIndex].consistencyGroups[0].replicaClusters[0];
		$scope.selectedCopy = $scope.selectedCluster.groupCopySettings[0];
		$scope.imageAccessType = 'latest';
		
		var isBookmarkImageAccessEnabled = false;
		var bookmarks = $scope.selectedCopy.bookmarks;		
		var length = bookmarks.length;
				
        for (var i = 0; i < length; i++) {
            var currBookmark = bookmarks[i];
            if(currBookmark.imageAccessEnabled == true){
            	$scope.selectedBookmark = currBookmark;
    	    	$scope.imageAccessType = 'bookmark';
    	    	isBookmarkImageAccessEnabled = true;
    	    	break;
            }
        }
        
        if(!isBookmarkImageAccessEnabled){
        	$scope.selectedBookmark = $scope.selectedCopy.bookmarks[0];
        }
 

	};
	   
	$scope.initData();
	
	
	$scope.imageAccess = function(){
	    	vmStructureService.groupSetImageAccess($scope.selectedCluster, $scope.selectedBookmark);  
	    	$scope.initData();
	}
	
	
	
	$scope.cancel = function(){
		$modalInstance.dismiss('cancel');
	}
	   
    
}]);