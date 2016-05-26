var app = angular.module('home');

app.service('auditService',['$http', function($http) {
     var size = 1000;
 	 this.getAuditLog = function(page,search) {
 	    var url = '../app/audit/log?page='+page+"&pageSize="+size;
 	    if(search){
 	        url+="&query="+search;
 	    }
 		return $http.get(url).then(function(response){
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
          var url = 'app/audit/log?page='+page+"&pageSize="+size;
          if(search){
              url+="&query="+search;
          }
          return $http.get(url).then(function(response){
               return convertJsonToCsv(response.data);
          });
     };

//     this.getOther = function() {
//   	  return 'Other!!!';
//     };
   }
 ]);
