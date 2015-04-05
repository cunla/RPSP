// create the controller and inject Angular's $scope
	scotchApp.controller('configController', function($scope, $http, usSpinnerService, $rootScope) {
		// create a message to display in our view
		$scope.message = 'Everyone come and see how good I look!';
		$scope.newSystem = {};
		$scope.loadSystems = function(){
		    usSpinnerService.spin('spinner-1');
		    $http.get('systems')
		    .success(function(data,status,headers,config){
		        $scope.systems = (data._embedded != null )? data._embedded.systems : null;
		        usSpinnerService.stop('spinner-1');
		    })
		    .error(function(data, status, headers, config){
		         usSpinnerService.stop('spinner-1');
            	alert('Error loading System \n'+JSON.stringify(data));
            })
		};
		$scope.addSystem = function(){
		    usSpinnerService.spin('spinner-1');
		    $http.post('app/rest/addSystem',$scope.newSystem)
		    .success(function(data, status, headers, config){
		        $scope.newSystem = {};
		        $scope.systems = data;
		         usSpinnerService.stop('spinner-1');
		    })
		    .error(function(data, status, headers, config){
		        usSpinnerService.stop('spinner-1');
		        alert('Error saving System \n'+data.message);
		    });
		};
		$scope.deleteSystem = function(system){
		    $http.delete('systems/'+system.id)
		    .success(function(data, status, headers, config){
		        $scope.loadSystems();
		    })
		    .error(function(data, status, headers, config){
		        alert('Error deleting system');
		    })
		};
		$scope.testSystem = function(system){
			usSpinnerService.spin('spinner-1');
		    $http.get('app/rest/testSystem/'+system.id)
		    .success(function(data, status, headers, config){
		        $scope.systems=data;
		        usSpinnerService.stop('spinner-1');
            })
            .error(function(data, status, headers, config){
                usSpinnerService.stop('spinner-1');
                alert('Error testing system\n'+data.message);
            })
		};
		$scope.updateCluster = function(systemId, cluster){
		     $http.put('app/rest/updateClusterForSystem/'+systemId, cluster)
            .success(function(data, status, headers, config){
                loadSystems();
            })
            .error(function(data, status, headers, config){
                alert('Error testing system\n'+data.message);
            })
		};
		$scope.updateSystem = function(system){
             $http.put('systems/'+system.id, system)
            .success(function(data, status, headers, config){
                $scope.loadSystems();
            })
            .error(function(data, status, headers, config){
                alert('Error testing system\n'+data.message);
            })
        };
        $rootScope.$on('us-spinner:spin', function(event, key) {
		  $scope.spinneractive = true;
		});

		$rootScope.$on('us-spinner:stop', function(event, key) {
		  $scope.spinneractive = false;
		});
		$scope.loadSystems();

		
	});

