var app = angular.module('home');


app.controller('auditController', ['$scope', '$modal', '$modalInstance','auditService', function ($scope, $modal, $modalInstance, auditService) {
    $scope.pages = [];
    auditService.getAuditLog().then(function(res){
        $scope.audit = res;
        var page = $scope.audit.currentPage -2;
        $scope.showPreviousPages=(page>1);
        $scope.pages = [];
        while($scope.pages.length<5 && page<=$scope.audit.totalPages){
            if(page>0){
                $scope.pages.push(page);
            }
            ++page;
        }
        $scope.showNextPages=(page<=$scope.audit.totalPages);
    })

    $scope.previousPages=function(){
        var x = $scope.pages[0];
        $scope.pages = [];
        while($scope.pages.length<5 && x>0){
             if(x>0){
                $scope.pages.push(x);
             }
             --x;
        }
        $scope.showPreviousPages=(x>0);
        $scope.pages.sort(function(a, b){return a-b});
        x=$scope.pages.pop();
        $scope.pages.push(x);
        while($scope.pages.length<5 && x<=$scope.audit.totalPages){
            $scope.pages.push(++x);
        }
        $scope.showNextPages=(x<=$scope.audit.totalPages);
    }

     $scope.nextPages=function(){
        var x = $scope.pages.pop()+1;
        var low = x;
        $scope.showPreviousPages=(x>0);
        $scope.pages = [];
        while($scope.pages.length<5 && x<=$scope.audit.totalPages){
             if(x>0){
                $scope.pages.push(x);
             }
             ++x;
        }
        while($scope.pages.length<5 && low>1){
            $scope.pages.push(--low);
        }
        $scope.pages.sort(function(a, b){return a-b});
        $scope.showNextPages=(x<=$scope.audit.totalPages);
     }

    $scope.cancel = function(){
		$modalInstance.dismiss('cancel');
	};


}]);
