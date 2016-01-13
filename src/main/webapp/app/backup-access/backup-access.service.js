(function () {
    angular.module('home')
        .service('backupSrv', ['$http', backupSrv]);
    function backupSrv($http) {
        return {
            backupsList: backupsList,
            enableBackup: enableBackup,
            disableBackup: disableBackup
        }

        function backupsList(vmName) {
            return $http.get("backup/" + vmName + "/list")
        }

        function enableBackup(vmName, backupName) {
            return $http.get("/backup/" + vmName + "/disable/" + backupName);
        }

        function disableBackup(vmName, backupName) {
            return $http.get("/backup/" + vmName + "/disable/" + backupName);
        }
    }
})()
