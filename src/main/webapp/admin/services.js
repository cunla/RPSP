app.service('RPSP', ['$http', '$q',
    function ($http, $q) {
        return {
            settings: function () {
                return $q(function (resolve, reject) {
                    setTimeout(function () {
                        $http.get('data/settings.json').then(function (res) {
                            resolve(res);
                        });
                    }, 1000);
                });
            }
        }
    }]);
