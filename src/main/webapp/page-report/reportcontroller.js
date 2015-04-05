	scotchApp.controller('reportController', function($scope, $http, $location, $anchorScroll) {
	    $scope.reportData = [];
	    $scope.reportErrors = [];
	    var now = new Date();
	    $scope.year = now.getFullYear();
        $scope.quarter = Math.floor((now.getMonth() + 3) / 3);
        if($scope.quarter > 1){
           --$scope.quarter;
        }else{
            $scope.quarter = 4;
            --$scope.year;
        }
        $scope.requestReport = function(year, quarter){
           $http.get('report/quarterReport/'+year+'/'+quarter)
           .success(function(data,status,headers,config){
               $scope.reportData = data.reportLines;
               $scope.reportErrors = data.errors;
           })
           .error(function(data, status, headers, config){
                alert('Error fetching report data');
           });
        };
        $scope.requestReport($scope.year,$scope.quarter);
        $scope.scrollTo = function(id) {
             $location.hash(id);
             $anchorScroll();
          }
	});

