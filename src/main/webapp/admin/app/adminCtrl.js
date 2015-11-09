app.controller('adminCtrl', [ 'userService','$scope', function (userService,$scope) {
    userService.getAdminData().then(function(res){
        $scope.data=res;
    })

}])
