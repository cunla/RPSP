(function () {
    angular.module('adminApp')
        .controller('Users', ['$scope', 'RPSP', '$mdDialog', '$window', Users]);
    function Users($scope, RPSP, $mdDialog, $window) {
        $scope.showDialog = showDialog;
        $scope.loading = true;
        $scope.changed = false;
        $scope.config = {};
        $scope.deleteUser = deleteUser;
        $scope.save = save;
        refresh();

        function deleteUser(user) {
            var confirm = $mdDialog.confirm()
                .title('Would you like to delete user?')
                .textContent('User ' + user.login + ' will be deleted.')
                .ariaLabel('User deletion confirmation')
                .ok('Delete!')
                .cancel('Cancel');
            $mdDialog.show(confirm).then(function () {
                var i = 0;
                for (; i < $scope.config.users.length; ++i) {
                    if ($scope.config.users[i] == user) {
                        break;
                    }
                }
                console.log("delete user " + user.login + " with index " + i);
                $scope.config.users.splice(i, 1);
                RPSP.save($scope.config).then(function (res) {
                    $window.location.reload();
                });
            }, function () {
                console.log("Cancelled user deletion");
            });
        }

        function showDialog(user) {
            $scope.changed = true;
            if (!user) {
                user = {};
            }
            $mdDialog.show({
                templateUrl: 'views/users/editUserDialog.html',
                locals: {
                    tenants: $scope.config.tenants,
                },
                controller: DialogController
            });
            function DialogController($scope, $mdDialog, tenants) {
                user.username = user.login ? user.login.split('@')[0] : "";
                $scope.user = user;
                $scope.tenants = tenants;
                $scope.closeDialog = closeDialog;
                $scope.addUser = addUser;
                function addUser() {
                    user.login = user.username + "@" + user.tenantName;
                    user.fullName = user.firstName + ' ' + user.lastName;
                    $mdDialog.hide();
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
            RPSP.save($scope.config).then(function (res) {
            })
        }

        function refresh() {
            RPSP.settings().then(function (res) {
                $scope.config = RPSP.current();
                $scope.loading = false;
                // $scope.json = RPSP.current();
            });
        }


    }
})()
