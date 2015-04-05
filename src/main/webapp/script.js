
	// create the module and name it scotchApp
	var scotchApp = angular.module('scotchApp', ['tableSort','ngRoute',"xeditable",'angularSpinner']);

	// configure our routes
	scotchApp
	.config(function($routeProvider) {
		$routeProvider
			.when('/', {
				templateUrl : 'page-report/report.html',
				controller  : 'reportController'
			})
			.when('/config', {
				templateUrl : 'page-config/config.html',
				controller  : 'configController'
			})
			.when('/help', {
            				templateUrl : 'page-help/help.html'
            			})
			.when('/alldata', {
            				templateUrl : 'page-alldata/alldata.html',
            				controller  : 'alldataController'
            			})

	})
	.run(function(editableOptions, editableThemes) {
           // set `default` theme
           editableOptions.theme = 'bs3';          
    });

