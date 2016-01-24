angular.module('adminApp')
    .controller('LoginCtrl', ['$scope', '$mdSidenav', '$location', '$mdDialog',
        function ($scope, $mdSidenav, $location, $mdDialog) {
            $scope.user = {};
            var alert;
            $scope.goHome = function () {
                $location.path('/app/systems');
            };
            $scope.login = function (user) {
                $scope.user = user;
                if ($scope.loginForm.$valid) {
                    $scope.goHome();
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

        }]);
