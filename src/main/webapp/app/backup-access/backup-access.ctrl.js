(function () {
    angular.module('home')
        .controller('BackupAccess', ['$scope', '$modal', '$modalInstance', 'backupSrv', 'vmName', BackupAccess]);
    function BackupAccess($scope, $modal, $modalInstance, backupSrv, vmName) {
        $scope.vmName = vmName;
        $scope.status = "Disabled";

        backupSrv.backupsList(vmName).then(function (res) {
            $scope.backups = res.data;
        })

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        }
    }
})()
