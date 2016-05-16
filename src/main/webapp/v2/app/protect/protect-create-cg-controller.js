var app = angular.module('home');


app.controller('protectCreateCgController', ['$scope', '$http', '$modal', '$modalInstance', '$translate', '$filter', 'vmStructureService', 'vmId',
    function ($scope, $http, $modal, $modalInstance, $translate, $filter, vmStructureService, vmId) {

        $scope.vmStructureData = {};
        $scope.unprotectedVms = {};
        $scope.productionCluster = {};
        $scope.selectedReplicaCluster = {};
        $scope.selectedVms = {};
        $scope.cgName = '';
        $scope.replicationPolicy = {};
        $scope.enableReplication = true;
        $scope.selectedPackage = {};

        $scope.initData = function () {
            $scope.vmStructureData = vmStructureService.getCachedVmStructureData();
            $scope.unprotectedVms = $scope.vmStructureData.unprotectedVms;
            if (vmId) {
                for (i in $scope.unprotectedVms) {
                    if ($scope.unprotectedVms[i].id == vmId) {
                        $scope.selectedVms = [$scope.unprotectedVms[i]];
                    }
                }
            }
            $scope.productionCluster = $scope.vmStructureData.systemInfo.productionCluster;
            $scope.selectedReplicaCluster = $scope.vmStructureData.systemInfo.replicaClusters[0];
            $scope.selectedPackage = $scope.vmStructureData.systemInfo.packages[0];

        };

        $scope.initData();

        $scope.createCg = function () {
            vmStructureService.createCg($scope.cgName, $scope.productionCluster.id, $scope.selectedReplicaCluster.id,
                $scope.selectedVms, $scope.enableReplication, $scope.selectedPackage.id,
                $scope.backup, $scope.schedule
            );
            $modalInstance.dismiss('cancel');
        }

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        }


    }]);
