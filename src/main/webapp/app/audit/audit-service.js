var app = angular.module('home');

app.service('auditService',['$http', function($http) {
     var size = 1000;
 	 this.getAuditLog = function(page,search) {
 		 return $http.get('app/audit/auditlog.sample.json')
		    .then(function(response){
                return response.data;
		    });
     };

     var convertJsonToCsv = function(json){
        var fields = Object.keys(json[0]);
        var csv = json.map(function(row){
         return fields.map(function(fieldName){
            return '"' + (row[fieldName] || '') + '"';
          });
        });
        csv.unshift(fields); // add header column
        console.log(csv.join('\r\n'));
     }

     this.getAuditLogAsCsv = function(page,search) {
         return $http.get('app/audit/auditlog.sample.json')
            .then(function(response){
                return convertJsonToCsv(response.data.log);
            });
     };

     this.getOther = function() {
   	  return 'Other!!!';
     };
   }
 ]);
