(function () {
    angular.module('adminApp')
        .controller('SystemsCtrl', ['$scope', 'RPSP', SystemsCtrl]);
    function SystemsCtrl($scope, RPSP) {
        $scope.loading = true;
        RPSP.settings().then(function (res) {
            $scope.config = res.data.config;
            $scope.loading = false;
            $scope.json = RPSP.current();
        })
    }
})()
