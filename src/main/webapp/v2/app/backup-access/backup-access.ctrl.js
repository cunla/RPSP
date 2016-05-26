(function () {
    angular.module('home')
        .controller('BackupAccess', ['$scope', '$modal', '$modalInstance', 'backupSrv', 'vmName', BackupAccess]);
    function BackupAccess($scope, $modal, $modalInstance, backupSrv, vmName) {
        $scope.vmName = vmName;
        $scope.enabled = false;
        $scope.selectedBackup = "";

        backupSrv.backupsList(vmName).then(function (res) {
            $scope.backups = res.data;
        })

        backupSrv.vmStatus(vmName).then(function (res) {
            if (res.data.length > 0) {
                $scope.enabled = true;
                $scope.selectedBackup = res.data[0].replace("_restore", "");
            }
        })

        $scope.imageAccess = imageAccess;
        $scope.cancel = cancel;

        function imageAccess() {
            if ($scope.enabled) {
                backupSrv.disableBackup($scope.vmName, $scope.selectedBackup);
            } else {
                backupSrv.enableBackup($scope.vmName, $scope.selectedBackup);
            }
        }

        function cancel() {
            $modalInstance.dismiss('cancel');
        }
    }
})()
