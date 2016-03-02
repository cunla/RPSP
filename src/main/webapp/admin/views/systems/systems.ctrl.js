(function () {
    angular.module('adminApp')
        .controller('SystemsCtrl', ['$scope', 'RPSP', '$mdDialog', SystemsCtrl])
    function SystemsCtrl($scope, RPSP, $mdDialog) {
        $scope.menuOpen = false;
        $scope.showDialog = showDialog;
        $scope.testSystem = testSystem;
        $scope.save = save;
        $scope.loading = true;
        //$scope.changed = false;
        refresh();


        function save() {
            RPSP.save($scope.json).then(function (res) {
                $scope.changed = RPSP.changed;
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
            RPSP.changed = true;
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
                $scope.system.isDrttc = ($scope.system.isDrttc == true);
                $scope.items = items;
                $scope.closeDialog = closeDialog;
                $scope.testSystem = testSys;
                $scope.addSystem = addSystem;
                function addSystem() {
                    RPSP.addSystem($scope.system);
                    $mdDialog.hide();
                }

                function testSys() {
                    $scope.system.testing = true;
                    RPSP.testNewSystem(system).then(function (res) {
                        $scope.system = res.data;
                        $scope.system.testing = false;
                    }, function error(res) {
                        alert("Couldn't access system " + system.ip);
                        $scope.system.testing = false;
                    })

                }

                function closeDialog() {
                    $mdDialog.hide();
                }
            }
        }

        function testSystem(system) {
            system.testing = true;
            if (system.id) {
                RPSP.testSystem(system.id).then(function (res) {
                    system = res.data;
                    system.testing = false;
                });
            } else {
                RPSP.testNewSystem(system).then(function (res) {
                    system = res.data;
                    system.testing = false;
                });
            }
        }
    }
})()
