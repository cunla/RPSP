'use strict';
(function(){
/**
 * @ngdoc overview
 * @name ngmaterialApp
 * @description
 * # ngmaterialApp
 *
 * Main module of the application.
 */
var app = angular
    .module('adminApp', [
        'ngAnimate',
        'ngAria',
        'ngCookies',
        'ngMessages',
        'ngResource',
        'ngRoute',
        'ngSanitize',
        'ngMaterial', 'ui.router', 'ngMdIcons','mdDataTable'
    ])
    .config(
        function ($stateProvider, $urlRouterProvider) {
            $stateProvider
                .state('login', {
                    url: "/login",
                    templateUrl: "views/login/login.html",
                    controller: 'LoginCtrl'
                })
                .state('app', {
                    url: "/app",
                    abstract: true,
                    templateUrl: "views/menu.html",
                    controller: 'MenuCtrl'
                })
                .state('app.tools', {
                    url: "/tools",
                    views: {
                        'menuContent': {
                            templateUrl: "views/tools/tools.html",
                            controller: 'MainCtrl'
                        }
                    }
                })
                .state('app.systems', {
                    url: "/systems",
                    views: {
                        'menuContent': {
                            templateUrl: "views/systems/systems.html",
                            controller: 'SystemsCtrl'
                        }
                    }
                })
                .state('app.packages', {
                    url: "/packages",
                    views: {
                        'menuContent': {
                            templateUrl: "views/packages/packages.html",
                            controller: 'PackagesCtrl'
                        }
                    }
                })
                .state('app.tenants', {
                    url: "/tenants",
                    views: {
                        'menuContent': {
                            templateUrl: "views/tenants/tenants.html",
                            controller: 'Tenants'
                        }
                    }
                })
                .state('app.users', {
                    url: "/users",
                    views: {
                        'menuContent': {
                            templateUrl: "views/users/users.html",
                            controller: 'MainCtrl'
                        }
                    }
                })
                .state('app.vms', {
                    url: "/vms",
                    views: {
                        'menuContent': {
                            templateUrl: "views/vms/vms.html",
                            controller: 'MainCtrl'
                        }
                    }
                })
            ;
            $urlRouterProvider.otherwise("/login");
        });

app.controller('MenuCtrl', ['$scope', '$location',
    function ($scope, $location) {
        $scope.goSystems = function () {
            $location.path('/app/systems');
        };
        $scope.goPackages = function () {
            $location.path('/app/packages');
        };
        $scope.goTenants = function () {
            $location.path('/app/tenants');
        };
        $scope.goUsers = function () {
            $location.path('/app/users');
        };
        $scope.goVms = function () {
            $location.path('/app/vms');
        };
        $scope.goTools = function () {
            $location.path('/app/tools');
        };
    }]);
app.controller('MainCtrl', ['$scope', '$location',
    function ($scope, $location) {

    }]);
})()
