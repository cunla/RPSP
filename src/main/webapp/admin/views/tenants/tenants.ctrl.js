(function () {
    angular.module('adminApp')
        .controller('Tenants', ['$scope', 'RPSP', '$mdDialog', Tenants]);
    function Tenants($scope, RPSP, $mdDialog) {
        $scope.showDialog = showDialog;
        $scope.loading = true;
        $scope.changed = false;
        refresh();

        function save() {
            RPSP.save($scope.json).then(function (res) {
                $scope.changed = false;
            })
        }

        function refresh() {
            RPSP.settings().then(function (res) {
                $scope.config = RPSP.current();
                $scope.loading = false;
                $scope.json = RPSP.current();
            });
        }

        function showDialog(tenant) {
            $scope.changed = true;
            if (!tenant) {
                tenant = {};
            }
            var parentEl = angular.element(document.body);
            $mdDialog.show({
                templateUrl: 'views/tenants/editTenantDialog.html',
                locals: {
                    items: $scope.items,
                    tenant: tenant
                },
                controller: DialogController
            });
            function DialogController($scope, $mdDialog, items, tenant) {
                $scope.tenant = tenant;
                $scope.items = items;
                $scope.closeDialog = closeDialog;
                $scope.addTenant = addTenant;
                function addTenant() {
                    if (!tenant.id) {
                        RPSP.addTenant(tenant);
                    }
                }

                function closeDialog() {
                    $mdDialog.hide();
                }
            }
        }
    }
})()
