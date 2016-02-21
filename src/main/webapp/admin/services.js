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
            addTenant: addTenant,
            testNewSystem: testNewSystem
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
            var url = '/rpsp/internal-data';
            return $http.get(url);
            //return $q(function (resolve, reject) {
            //    setTimeout(function () {
            //        $http.get('data/settings.json').then(function (res) {
            //            json = res.data;
            //            resolve(res);
            //        });
            //    }, 1000);
            //});
        }

        function testNewSystem(system) {
            var url = '/rpsp/app/rest/testSystem';
            return $http.post(url, system);
        }

        function settings() {
            var url = '/rpsp/internal-data';
            return $q(function (resolve, reject) {
                $http.get(url).then(function (res) {
                    json = res.data;
                    resolve(res);
                });
            });
        }

        function current() {
            return json;
        }
    }
})()
