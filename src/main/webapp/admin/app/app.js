'use strict';

/**
 * @ngdoc overview
 * @name ngmaterialApp
 * @description
 * # ngmaterialApp
 *
 * Main module of the application.
 */
var app=angular
    .module('adminApp', [
        'ngAnimate',
        'ngAria',
        'ngCookies',
        'ngMessages',
        'ngResource',
        'ngRoute',
        'ngSanitize',
        'ngTouch',
        'ngMaterial', 'ui.router', 'ngMdIcons'
    ])
    .config(
    function ($stateProvider, $urlRouterProvider, $mdThemingProvider) {


        /*
         var customBlueMap = 		$mdThemingProvider.extendPalette('light-blue', {
         'contrastDefaultColor': 'light',
         'contrastDarkColors': ['50'],
         '50': 'ffffff'
         });
         $mdThemingProvider.definePalette('customBlue', customBlueMap);
         $mdThemingProvider.theme('default')
         .primaryPalette('customBlue', {
         'default': '500',
         'hue-1': '50'
         })
         .accentPalette('pink');
         $mdThemingProvider.theme('input', 'default')
         .primaryPalette('grey');

         */

        $stateProvider
            .state('login', {
                url: "/login",
                templateUrl: "views/login/login.html",
                controller: 'AppCtrl'
            })
            .state('app', {
                url: "/app",
                abstract: true,
                templateUrl: "views/menu.html",
                controller: 'AppCtrl'
            })
            .state('app.main', {
                url: "/main",
                views: {
                    'menuContent': {
                        templateUrl: "views/main.html",
                        controller: 'MainCtrl'
                    }
                }
            })
            .state('app.about', {
                url: "/about",
                views: {
                    'menuContent': {
                        templateUrl: "views/about.html",
                        controller: 'AboutCtrl'
                    }
                }
            })

        ;

        //
        // For any unmatched url, redirect to /state1
        $urlRouterProvider.otherwise("/login");


    })
