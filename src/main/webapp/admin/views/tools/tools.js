(function () {
    'use strict';

    /**
     * @ngdoc function
     * @name ngmaterialApp.controller:AboutCtrl
     * @description
     * # AboutCtrl
     * Controller of the ngmaterialApp
     */
    angular.module('adminApp')
        .config(['$compileProvider',
            function ($compileProvider) {
                $compileProvider.aHrefSanitizationWhitelist(/^s*(https?|ftp|blob|mailto|chrome-extension):/);
                // pre-Angularv1.2 use urlSanizationWhitelist()
            }
        ])
        .controller('ToolsCtrl', ['RPSP', '$scope', ToolsCtrl]);
    function ToolsCtrl(RPSP, $scope) {
        RPSP.settings().then(function (res) {
            $scope.json = RPSP.current();
            var jsonStr = JSON.stringify($scope.settings);
            $scope.settingsLink =
                window.URL.createObjectURL(new Blob([jsonStr], {type: "application/json"}));

        });

        $scope.import = doImport;

        function doImport() {

        }
    }
})()
