'use strict';

/**
 * @ngdoc function
 * @name ngmaterialApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the ngmaterialApp
 */
angular.module('adminApp')
    .controller('ToolsCtrl', function ($scope) {
        $scope.awesomeThings = [
            'HTML5 Boilerplate',
            'AngularJS',
            'Angular Material',
            'Karma',
            'Angular UI Router',
            'Sample Login Screen'
        ];
    });
