(function(){
    angular.module('adminApp')
        .controller('PackagesCtrl', ['$scope', 'RPSP', '$mdDialog', PackagesCtrl]);

    function PackagesCtrl($scope, RPSP, $mdDialog) {
        $scope.loading = true;
        $scope.showDialog=showDialog;        
        $scope.config = {};
              
        
        RPSP.settings().then(function (res) {
            $scope.config = res.data;
            $scope.loading = false;
        })   
        
        
        $scope.save = function() {
        	var url = '/rpsp/internal-data';
        	var data = $scope.config;
        	/*$http.post(url, data).
	        success(function (data, status, headers, config) {
	        });*/
        }
        
        
        function showDialog($event) {
            var parentEl = angular.element(document.body);
            $mdDialog.show({
                templateUrl: 'views/packages/newPackageDialog.html',
                locals: {
                    config: $scope.config
                },
                controller: DialogController
            });
            function DialogController($scope, $mdDialog, config) {
                $scope.config = config;
                $scope.selectedSystem = $scope.config.systems[0];
                $scope.closeDialog = function () {
                    $mdDialog.hide();
                }
                
                $scope.addPackage = function () {
                    $mdDialog.hide();
                    var newPackage = {};
                    
                    newPackage.systemId = $scope.selectedSystem.id;
                    newPackage.systemName = $scope.selectedSystem.name;
                    newPackage.name = $scope.packageName;
                    newPackage.displayName = $scope.displayName;
                    
                    newPackage.description = $scope.description;
                    newPackage.rpo = $scope.rpo;
                    
                    newPackage.sourceClusterId = $scope.selectedProdCluster.id;
                    newPackage.sourceClusterName = $scope.selectedProdCluster.friendlyName;
                    newPackage.sourceVcId = $scope.selectedProdCluster.vcenterConfig.name;
                    newPackage.sourceDataCenterId = $scope.selectedSourceDataCenter.id;
                    newPackage.sourceEsxClusterId = $scope.selectedSourceEsxCluster.id;
                    newPackage.sourceEsxClusterName = $scope.selectedSourceEsxCluster.name;
                    newPackage.sourceEsxId = $scope.selectedSourceEsxCluster.esxConfigs[0].id;
                    newPackage.sourceDatastoreId = $scope.selectedSourceDatastore.id;
                    newPackage.sourceDatastoreName = $scope.selectedSourceDatastore.name;
                    
                    newPackage.targetClusterId = $scope.selectedReplicaCluster.id;
                    newPackage.targetClusterName = $scope.selectedReplicaCluster.friendlyName;
                    newPackage.targetVcId = $scope.selectedReplicaCluster.vcenterConfig.name;
                    newPackage.targetDataCenterId = $scope.selectedTargetDataCenter.id;
                    newPackage.targetEsxClusterId = $scope.selectedTargetDataCenter.esxClustersConfig[0].id;
                    newPackage.targetEsxId = $scope.selectedTargetEsx.id;
                    newPackage.targetEsxName = $scope.selectedTargetEsx.name;
                    newPackage.targetDatastoreId = $scope.selectedTargetDatastore.id;
                    newPackage.targetDatastoreName = $scope.selectedTargetDatastore.name;
                    newPackage.testNetworkId = 'Test Network';
                    
                    if($scope.config.packages == undefined){
                    	$scope.config.packages = new Array();
                    }
                    $scope.config.packages.push(newPackage);
                }
            }
        }

    }
})()
