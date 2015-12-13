var HEADER_NAME = 'RPSP-Handle-Errors-Generically';
var specificallyHandleInProgress = false;
var app = angular.module('home');
app
    .controller('errorController', ['$scope', '$modalInstance', 'modalParams',
        function ($scope, $modalInstance, modalParams) {
            $scope.error = modalParams.data;
            $scope.cancel = function () {
                $modalInstance.dismiss('cancel');
            }
        }]);
(function () {

    var showError = function (error) {
        var display = JSON.stringify(error.data);
        alert(display);
        //var $injector = angular.injector(['app']);
        //var $modal = $injector.get('$modal');
        //$modal.open({
        //    templateUrl: 'app/error-modal.html',
        //    controller: 'errorController',
        //    windowClass: 'error-modal',
        //    resolve: {
        //        modalParams : function () {
        //            return error;
        //        }
        //    }
        //});
    };
    var httpInterceptor = function ($provide, $httpProvider) {


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
    };
    app.config(httpInterceptor);
}());
