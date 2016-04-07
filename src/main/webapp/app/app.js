(function () {
    var app = angular.module('home',
        ['pascalprecht.translate', 'locale', 'ui.bootstrap', 'btorfs.multiselect', 'tableSort', 'ngRoute', 'rzModule']);
    angular.module('home')
        .run(['localeService', function (localeService) {
            localeService.setLocale();
        }]);


    angular.module('home')
        .config(function ($translateProvider) {

            $translateProvider.useStaticFilesLoader({
                prefix: 'locales/locale-',
                suffix: '.json'
            });
            $translateProvider.preferredLanguage('en_US');
        });
})()
