(function () {
    angular.module('adminApp')
        .controller('Users', ['$scope', 'RPSP', '$mdDialog', Users]);
    function Users($scope, RPSP, $mdDialog) {
        $scope.showDialog = showDialog;
        $scope.loading = true;
        $scope.changed = false;
        $scope.save = save;
        refresh();

        function showDialog(user) {
            $scope.changed = true;
            if (!user) {
                user = {};
            }
            $mdDialog.show({
                templateUrl: 'views/tenants/editUserDialog.html',
                locals: {
                    tenants: $scope.json.tenants,
                },
                controller: DialogController
            });
            function DialogController($scope, $mdDialog, tenants) {
                $scope.tenant = tenant;
                $scope.items = items;
                $scope.packages = packages;
                $scope.closeDialog = closeDialog;
                $scope.addUser = addUser;
                function addUser() {
                    $mdDialog.hide();
                    RPSP.changed = true;
                    if (!user.id) {
                        RPSP.addUser(user);
                    }
                }

                function closeDialog() {
                    $mdDialog.hide();
                }
            }
        }

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


    }
})()
