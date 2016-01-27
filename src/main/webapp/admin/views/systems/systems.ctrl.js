(function () {
    angular.module('adminApp')
        .controller('SystemsCtrl', ['$scope', 'RPSP', '$mdDialog', SystemsCtrl])
    function SystemsCtrl($scope, RPSP, $mdDialog) {
        $scope.menuOpen=false;
        $scope.showDialog = showDialog;
        $scope.loading = true;
        refresh();

        function refresh() {
            RPSP.settings().then(function (res) {
                $scope.config = res.data;
                $scope.loading = false;
                $scope.json = RPSP.current();
            });
        }

        function showDialog($event) {
            var parentEl = angular.element(document.body);
            $mdDialog.show({
                templateUrl: 'views/systems/newSystemDialog.html',
                locals: {
                    items: $scope.items
                },
                controller: DialogController
            });
            function DialogController($scope, $mdDialog, items) {
                $scope.items = items;
                $scope.closeDialog = function () {
                    $mdDialog.hide();
                }
            }
        }
    }
})()
