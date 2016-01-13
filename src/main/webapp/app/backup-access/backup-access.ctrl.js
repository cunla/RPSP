(function () {
    angular.module('home')
        .controller('BackupAccess', ['$scope', '$modal', '$modalInstance', 'backupSrv', BackupAccess]);
    function BackupAccess($scope, $modal, $modalInstance, backupSrv) {

        $scope.cancel = function(){
            $modalInstance.dismiss('cancel');
        }
    }
})()
