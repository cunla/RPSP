(function(){
    angular.module('adminApp')
        .controller('PackagesCtrl', ['$scope', 'RPSP', '$mdDialog', PackagesCtrl]);

    function PackagesCtrl($scope, RPSP, $mdDialog) {
        $scope.loading = true;
        $scope.showDialog=showDialog;        
        $scope.config = {};
        $scope.showError = {};
              
        
        RPSP.settings().then(function (res) {
            $scope.config = res.data;
            $scope.loading = false;
        })   
        
        
        $scope.save = function() {
        	RPSP.save().then(function(response){	
        		$scope.config = response.data;
    		})
    		.catch(function(response){	
    			$scope.showError = true;
    		});
        }
        
        
        function showDialog(currPackage) {
        	
        	var editMode = true;
        	
    	    if (!currPackage) {
    		    currPackage = {};
    		    editMode = false;
            }
    	    
            var parentEl = angular.element(document.body);
            $mdDialog.show({
                templateUrl: 'views/packages/newPackageDialog.html',
                locals: {
                    config: $scope.config,
                    RPSP : RPSP
                },
                controller: DialogController
            });
            
         
            
            
            function DialogController($scope, $mdDialog, config, RPSP) {
                
                $scope.locateEntry = function (type, val, parentElem) {
                	var res = {};
                    if(type == 'system'){
                    	for(var i = 0; i < parentElem.length; i++){
                    		if(parentElem[i].name == val){
                    			res = parentElem[i];
                    		}
                    	}
                    }
                    else if(type == 'cluster'){
                    	for(var i = 0; i < parentElem.length; i++){
                    		if(parentElem[i].clusterIdStr == val){
                    			res = parentElem[i];
                    		}
                    	}
                    }
                    else if(type == 'datacenter' || type == 'esxCluster' 
                    			|| type == 'datastore' || type == 'esx'){
                    	for(var i = 0; i < parentElem.length; i++){
                    		if(parentElem[i].id == val){
                    			res = parentElem[i];
                    		}
                    	}
                    }
                  
                    return res;
                }
                
                $scope.config = config;  
                if (editMode) {
                		                             
	                $scope.packageName = currPackage.name;                
	                $scope.displayName = currPackage.displayName;
	                $scope.selectedSystem = $scope.locateEntry('system', currPackage.systemName, $scope.config.systems);
	                
	                //source
	                $scope.selectedProdCluster = $scope.locateEntry('cluster', currPackage.sourceClusterIdStr, 
	                		                                 $scope.selectedSystem.clusters);
	                
	                $scope.selectedSourceDataCenter = $scope.locateEntry('datacenter', currPackage.sourceDataCenterId, 
	                		                                 $scope.selectedProdCluster.vcenterConfig.relatedDatacenters);
	                
	                
	                $scope.selectedSourceEsxCluster = $scope.locateEntry('esxCluster', currPackage.sourceEsxClusterId, 
                            $scope.selectedSourceDataCenter.esxClustersConfig);
	                
	                $scope.selectedSourceDatastore = $scope.locateEntry('datastore', currPackage.sourceDatastoreId, 
                            $scope.selectedSourceDataCenter.datastores);
	                
	                
	                
	                //target
	                $scope.selectedReplicaCluster = $scope.locateEntry('cluster', currPackage.targetClusterIdStr, 
                            $scope.selectedSystem.clusters);
	                
	                $scope.selectedTargetDataCenter = $scope.locateEntry('datacenter', currPackage.targetDataCenterId, 
                            $scope.selectedReplicaCluster.vcenterConfig.relatedDatacenters);
	                
	                $scope.selectedTargetEsxCluster = $scope.locateEntry('esxCluster', currPackage.targetEsxClusterId, 
                            $scope.selectedTargetDataCenter.esxClustersConfig);
	                
	                $scope.selectedTargetEsx = $scope.locateEntry('esx', currPackage.targetEsxId, 
                            $scope.selectedTargetEsxCluster.esxConfigs);
	                
	                $scope.selectedTargetDatastore = $scope.locateEntry('esx', currPackage.targetDatastoreId, 
                            $scope.selectedTargetEsx.relatedDatastores);
	                
	                $scope.testNetworkId = currPackage.testNetworkId;
	                $scope.rpo = currPackage.rpo;
	                $scope.description = currPackage.description;
                }
                
             
            

                $scope.closeDialog = function () {
                    $mdDialog.hide();
                }
                
                $scope.addPackage = function () {
                    $mdDialog.hide();
                    
                    currPackage.systemId = $scope.selectedSystem.id;
                    currPackage.systemName = $scope.selectedSystem.name;
                    currPackage.name = $scope.packageName;
                    currPackage.displayName = $scope.displayName;
                    
                    currPackage.description = $scope.description;
                    currPackage.rpo = $scope.rpo;
                    currPackage.testNetworkId = $scope.testNetworkId;
                    
                    currPackage.sourceClusterIdStr = $scope.selectedProdCluster.clusterIdStr;
                    currPackage.sourceClusterName = $scope.selectedProdCluster.friendlyName;
                    currPackage.sourceVcId = $scope.selectedProdCluster.vcenterConfig.id;
                    currPackage.sourceVcName = $scope.selectedProdCluster.vcenterConfig.name;
                    currPackage.sourceDataCenterId = $scope.selectedSourceDataCenter.id;
                    currPackage.sourceDataCenterName = $scope.selectedSourceDataCenter.name;
                    currPackage.sourceEsxClusterId = $scope.selectedSourceEsxCluster.id;
                    currPackage.sourceEsxClusterName = $scope.selectedSourceEsxCluster.name;
                    currPackage.sourceEsxId = $scope.selectedSourceEsxCluster.esxConfigs[0].id;
                    currPackage.sourceEsxName = $scope.selectedSourceEsxCluster.esxConfigs[0].name;
                    currPackage.sourceDatastoreId = $scope.selectedSourceDatastore.id;
                    currPackage.sourceDatastoreName = $scope.selectedSourceDatastore.name;
                    
                    currPackage.targetClusterIdStr = $scope.selectedReplicaCluster.clusterIdStr;
                    currPackage.targetClusterName = $scope.selectedReplicaCluster.friendlyName;
                    currPackage.targetVcId = $scope.selectedReplicaCluster.vcenterConfig.id;
                    currPackage.targetVcName = $scope.selectedReplicaCluster.vcenterConfig.name;
                    currPackage.targetDataCenterId = $scope.selectedTargetDataCenter.id;
                    currPackage.targetDataCenterName = $scope.selectedTargetDataCenter.name;
                    currPackage.targetEsxClusterId = $scope.selectedTargetEsxCluster.id;
                    currPackage.targetEsxClusterName = $scope.selectedTargetEsxCluster.name;
                    currPackage.targetEsxId = $scope.selectedTargetEsx.id;
                    currPackage.targetEsxName = $scope.selectedTargetEsx.name;
                    currPackage.targetDatastoreId = $scope.selectedTargetDatastore.id;
                    currPackage.targetDatastoreName = $scope.selectedTargetDatastore.name;
                    
                    
                    if (!editMode) {
                    	RPSP.addPackage(currPackage);
                    }
                }
            }
        }

    }
})()
