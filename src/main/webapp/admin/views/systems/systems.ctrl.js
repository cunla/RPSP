(function () {
    angular.module('adminApp')
        .controller('SystemsCtrl', ['$scope', 'RPSP', '$mdDialog', SystemsCtrl])
    function SystemsCtrl($scope, RPSP, $mdDialog) {
        $scope.menuOpen = false;
        $scope.showDialog = showDialog;
        $scope.testSystem = testSystem;
        $scope.save = save;
        $scope.loading = true;
        $scope.changed = false;
        refresh();


        function save() {
            RPSP.save($scope.json).then(function (res) {
                $scope.changed = false;
            })
        }

        function refresh() {
            RPSP.settings().then(function (res) {
                $scope.config = RPSP.current();
                $scope.loading = false;
                $scope.json = RPSP.current();
            });
        }

        function showDialog(system) {
            $scope.changed = true;
            if (!system) {
                system = {};
            }
            var parentEl = angular.element(document.body);
            $mdDialog.show({
                templateUrl: 'views/systems/newSystemDialog.html',
                locals: {
                    items: $scope.items,
                    system: system
                },
                controller: DialogController
            });
            function DialogController($scope, $mdDialog, items, system) {
                $scope.system = system;
                $scope.items = items;
                $scope.closeDialog = closeDialog;
                $scope.testSystem = testSys;
                $scope.addSystem = addSystem;
                function addSystem() {
                    if (!system.id) {
                        RPSP.addSystem(system);
                    }
                }

                function testSys() {
                    RPSP.testSystem(system.id).then(function (data) {
                        system.testing = false;
                    })
                }

                function closeDialog() {
                    $mdDialog.hide();
                }
            }
        }

        function testSystem(system) {
            system.testing = true;
            RPSP.testSystem(system.id).then(function (data) {
                system.testing = false;
            })
        }
    }
})()
