(function () {
    angular.module('home')
        .service('backupSrv', ['$http', backupSrv]);
    function backupSrv($http) {
        return {
            backupsList: backupsList,
            enableBackup: enableBackup,
            disableBackup: disableBackup,
            vmStatus: vmStatus
        }

        function vmStatus(vmName) {
            return $http.get("backup/" + vmName + "/status");
        }

        function backupsList(vmName) {
            return $http.get("backup/" + vmName + "/list")
        }

        function enableBackup(vmName, backupName) {
            return $http.get("backup/" + vmName + "/enable/" + backupName);
        }

        function disableBackup(vmName, backupName) {
            return $http.get("backup/" + vmName + "/disable/" + backupName);
        }
    }
})()
