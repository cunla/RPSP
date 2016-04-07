(function () {
    'use strict';

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
        var fileInput = $('#files');

        function doImport() {
            if (!window.FileReader) {
                alert('Your browser is not supported');
                return false;
            }
            var input = fileInput.get(0);

            // Create a reader object
            var reader = new FileReader();
            if (input.files.length) {
                var textFile = input.files[0];
                // Read the file
                reader.readAsText(textFile);
                // When it's loaded, process it
                $(reader).on('load', function (e) {
                    var file = e.target.result;
                    if (file && file.length) {
                        console.log(file);
                        RPSP.setJson(file);
                        $scope.json = RPSP.current();
                        RPSP.save();
                    }
                });
            } else {
                alert('Please upload a file before continuing')
            }

        }
    }
})()
