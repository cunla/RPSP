(function () {
    angular.module('adminApp')
        .service('RPSP', ['$http', '$q', RPSP]);
    function RPSP($http, $q) {
        var json = {};
        return {
            settings: settings,
            current: current,
            testSystem: testSystem,
            save: save,
            addSystem: addSystem,
            addPackage: addPackage,
            addTenant: addTenant
        }

        function addTenant(tenant) {
            json.tenants.push(tenant);
        }

        function addSystem(system) {
            json.systems.push(system);
        }

        function addPackage(pckg) {
            json.packages.push(pckg);
        }

        function save() {
            var url = '/rpsp/internal-data';
            return $http.post(url, json).then(function (response) {
                var status = response.status;
                if (status == 201) {
                    json = response.data;
                }

                return response;
            });
        }

        function testSystem(systemId) {
            return $q(function (resolve, reject) {
                setTimeout(function () {
                    $http.get('data/settings.json').then(function (res) {
                        json = res.data;
                        resolve(res);
                    });
                }, 1000);
            });
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
