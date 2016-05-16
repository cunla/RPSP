angular.module('locale',  ['pascalprecht.translate']);

angular.module('locale').service('localeService', function($http, $translate){
	
	this.setLocale = function(){ 
		  $http.get('/rpsp/locale')
		    .success(function(data,status,headers,config){
		    	var locale = headers('Accept-Language');
		    	if(locale == 'en' || locale == 'en_US'){
					locale = 'en_US';
		    	}
		    	else if(locale == 'de' ||  locale == 'de_DE'){
						locale = 'de_DE';
				}
				else{
					locale = 'en_US';
				} 
		    	$translate.use(locale);
		    })
		    
		    
	}
	
});
