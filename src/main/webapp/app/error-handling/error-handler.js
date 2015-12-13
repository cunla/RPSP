var app = angular.module('home');
app
    .controller('errorController', ['$scope', '$modalInstance', 'modalParams',
        function ($scope, $modalInstance, modalParams) {
            $scope.error = modalParams.data;
            $scope.cancel = function () {
                $modalInstance.dismiss('cancel');
            }
        }]);
app
    .config(function ($provide, $httpProvider) {
        var showError = function (error) {
            var data = error.data;
            var display = JSON.stringify(data);
            display = display.replace(/\\r\\n\\t/g,"\n");
            alert(display);
        };
        $provide.factory('httpInterceptor', function ($q) {
            return {
                response: function (response) {
                    return response || $q.when(response);
                },
                responseError: function (rejection) {
                    showError(rejection);
                    return $q.reject(rejection);
                }
            };
        });
        $httpProvider.interceptors.push('httpInterceptor');
    });
