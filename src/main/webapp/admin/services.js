app.service('RPSP', ['$http',
    function ($http) {
        return {
            settings: function () {
                //$timeout(function () {
                return $http.get('data/settings.json');
                //}, 1000);
            }
        }
    }]);
