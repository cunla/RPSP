app.service('userService', ['$http', function($http) {
  return {
    getUserData: function() {
      return $http.get('../users/current-user')
        .then(function(response) {
        var allData = {};
        var currentUser = {};
        var welcomeData = {};
        var data = response.data;
        currentUser = response.data;
        var account;
        var user;
        if (data.account == null) {
          welcomeData = data.login;
        } else {
          if (data.account.label != null) {
            account = data.account.label;
          } else {
            account = data.account.name;
          }
          user = data.firstName + ' ' + data.lastName;
          welcomeData = user + '@' + account;
        }

        allData.welcomeData = welcomeData;
        allData.currentUser = currentUser;

        return allData;
      })
    },
    getAdminData: function() {
      return $http.get('app/admin-data.json').then(function(res) {
        return res.data;
      });
    }
  }
}]);
