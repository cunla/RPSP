var app = angular.module('home');

app.service('auditService',['$http', function($http) {
 	 this.getAuditLog = function(page,search) {
 		 return $http.get('app/audit/auditlog.sample.json')
		    .then(function(response){
                return response.data;
		    })
     };

     this.getOther = function() {
   	  return 'Other!!!';
     };
   }
 ]);
