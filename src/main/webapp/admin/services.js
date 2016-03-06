(function () {
    angular.module('adminApp')
        .service('RPSP', ['$http', '$q', RPSP]);
    function RPSP($http, $q) {
        var json = {};
        var changed = false;
        return {
            settings: settings,
            current: current,
            testSystem: testSystem,
            save: save,
            addSystem: addSystem,
            addPackage: addPackage,
            addTenant: addTenant,
            testNewSystem: testNewSystem,
            login: login,
            addUser: addUser,
            changed: changed
        }

        function login(username, password) {
            var encodedString = 'username=' +
                encodeURIComponent(username) +
                    //'@' +
                    //encodeURIComponent(this.inputData.account) +
                '&password=' +
                encodeURIComponent(password);
            return $http({
                method: 'POST',
                url: '../login-action',
                data: encodedString,
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            });
        };


        function addUser(user) {
            changed = true;
            json.users.push(user);
        }

        function addTenant(tenant) {
            changed = true;
            json.tenants.push(tenant);
        }

        function addSystem(system) {
            changed = true;
            json.systems.push(system);
        }

        function addPackage(pckg) {
            changed = true;
            json.packages.push(pckg);
        }

        function save() {
            var url = '/rpsp/internal-data';
            return $http.post(url, json).then(function (response) {
                var status = response.status;
                if (status == 201) {
                    json = response.data;
                    changed = false;
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
                    changed = false;
                    resolve(res);
                });
            });
        }

        function current() {
            return json;
        }
    }
})()
