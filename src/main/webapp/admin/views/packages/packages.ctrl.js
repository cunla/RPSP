(function(){
    angular.module('adminApp')
        .controller('Packages', ['$scope', 'RPSP', Packages]);

    function Packages($scope, RPSP) {
        $scope.loading = true;
        RPSP.settings().then(function (res) {
            $scope.config = res.data.config;
            $scope.loading = false;
        })

    }
})()
