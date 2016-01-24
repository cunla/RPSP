(function () {
    angular.module('adminApp')
        .service('RPSP', ['$http', '$q', RPSP]);
    function RPSP($http, $q) {
        var json = {};
        return {
            settings: settings,
            current: current
        }

        function settings() {
            return $q(function (resolve, reject) {
                setTimeout(function () {
                    $http.get('data/settings.json').then(function (res) {
                        json = res.data;
                        resolve(res);
                    });
                }, 1);
            });
        }

        function current() {
            return json;
        }
    }
})()
