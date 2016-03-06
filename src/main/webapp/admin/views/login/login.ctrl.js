(function () {
    angular.module('adminApp')
        .controller('LoginCtrl', ['$scope', '$mdSidenav', '$location', '$mdDialog', 'RPSP', LoginCtrl]);
    function LoginCtrl($scope, $mdSidenav, $location, $mdDialog, RPSP) {
        $scope.user = {};
        var alert;
        $scope.goHome = function () {
            $location.path('/app/systems');
        };
        $scope.login = function (user) {
            $scope.user = user;
            if ($scope.loginForm.$valid) {
                RPSP.login(user.email, user.password).then(function (res) {
                    if (res.status == 200) {
                        window.location.href = '/rpsp/admin/index.html';
                    }
                }, function (res) {
                    showAlert();
                })
            } else {
                showAlert();
            }

        }

        function showAlert() {
            alert = $mdDialog.alert()
                .title('Oops!')
                .content('Please provide a valid User and Password.')
                .ok('Close');
            $mdDialog
                .show(alert)
                .finally(function () {
                    alert = undefined;

                });
        }

    };
})();
