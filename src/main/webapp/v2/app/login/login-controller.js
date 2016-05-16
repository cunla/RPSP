angular.module('login', ['pascalprecht.translate', 'locale'])
	.controller('loginController', ['$scope', '$http', function($scope, $http) {
		
		this.postForm = function() {
		
			var encodedString = 'username=' +
				encodeURIComponent(this.inputData.username) + 
				'@' + 
				encodeURIComponent(this.inputData.account) +
				'&password=' +
				encodeURIComponent(this.inputData.password)
				;
				
			$http({
				method: 'POST',
				url: '../../login-action',
				data: encodedString,
				headers: {'Content-Type': 'application/x-www-form-urlencoded'}
			})
			.success(function(data, status, headers, config) {
				console.log(data);
				if ( status == 200) {
					window.location.href = '/rpsp';
				} else {
					$scope.errorMsg = "Login not correct";
				}
			})
			.error(function(data, status, headers, config) {
				$scope.errorMsg = 'Login not correct';
			})
		}
		
	}]);


angular.module('login').run(['localeService', function(localeService){
	localeService.setLocale();
}]);



angular.module('login').config(function ($translateProvider) {
	  $translateProvider.useStaticFilesLoader({
	    prefix: '../../locales/locale-',
	    suffix: '.json'
	  });
	  
});