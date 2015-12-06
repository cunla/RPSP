angular.module('adminUI',['ngRoute']);
var app = angular.module('adminUI');
app.config(['$routeProvider',
      function($routeProvider) {
        $routeProvider.
          when('/rpsystems', {
            templateUrl: 'templates/rpsystems/rpsystems.html',
            controller: 'rpsystemsCtrl'
          }).
          when('/packages', {
            templateUrl: 'templates/packages/packages.html',
            controller: 'rpsystemsCtrl'
          }).
          otherwise({
            redirectTo: '/rpsystems'
          });
      }]);
