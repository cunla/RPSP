'use strict';
(function () {
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
            'ngMaterial', 'ui.router', 'ngMdIcons', 'mdDataTable'
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
                                controller: 'ToolsCtrl'
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
                                controller: 'Users'
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

    app.controller('MenuCtrl', ['$scope', '$location', '$mdDialog', 'RPSP','$state', menuCtrl]);

    function menuCtrl($scope, $location, $mdDialog, RPSP, $state) {
        $scope.activeState = $state.current.name;
        $scope.go = go;
        function go(path) {
            if (RPSP.changed()) {
                showConfirm();
            } else {
                $location.path(path);
            }
        }

        function showConfirm() {
            var confirm = $mdDialog.confirm()
                .title('Changes were made')
                .textContent('Would you like to save changes?')
                .ariaLabel('Save changes dialog')
                //.targetEvent(ev)
                .ok('Save changes')
                .cancel('Forget changes');
            $mdDialog.show(confirm).then(function () {
                RPSP.save();
                $location.path(path);
            }, function () {//Cancel
                RPSP.settings();
            });
        };
    };

    app.controller('MainCtrl', ['$scope', '$location',
        function ($scope, $location) {

        }]);
})()
