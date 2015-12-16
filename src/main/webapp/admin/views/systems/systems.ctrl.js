app.controller('SystemsCtrl', ['$scope', 'RPSP',
    function ($scope, RPSP) {
        $scope.loading = true;
        RPSP.settings().then(function (res) {
            $scope.settings = res.data;
            $scope.loading = false;
        })

    }]);
