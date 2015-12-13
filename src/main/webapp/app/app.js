var app = angular.module('home',
    ['pascalprecht.translate', 'locale', 'ui.bootstrap', 'btorfs.multiselect','tableSort','ngRoute']);
app.run(['localeService', function(localeService){
	localeService.setLocale();
}]);


app.config(function ($translateProvider) {

  $translateProvider.useStaticFilesLoader({
    prefix: 'locales/locale-',
    suffix: '.json'
  });
  $translateProvider.preferredLanguage('en_US');
});
