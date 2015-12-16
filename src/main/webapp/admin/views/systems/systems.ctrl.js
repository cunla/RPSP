app.controller('SystemsCtrl', ['$scope', 'RPSP',
    function ($scope, RPSP) {
        $scope.loading = true;
        RPSP.settings().then(function (res) {
            $scope.config = res.data.config;
            $scope.loading = false;
        })

    }]);
