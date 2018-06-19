(function () {
    'use strict'

    angular.module('app')
        .controller('SocialFormController', SocialFormController);

        SocialFormController.$inject = ['SocialService', '$state', '$stateParams', 'DialogBuilder'];

    function SocialFormController(SocialService, $state, $stateParams, DialogBuilder) {

        var vm = this;
        vm.registro = {};
        vm.error = {};
        vm.titulo = 'Nova Rede Social';

        vm.salvar = salvar;

        if ($stateParams.id) {
            SocialService.findById($stateParams.id)
                .then(function (data) {
                    vm.registro = data;
                    vm.titulo = 'Editando Rede Social';
                });
        }

        function salvar() {
            if (!vm.registro.id) {
                SocialService.insert(vm.registro)
                    .then(function (dado) {
                        DialogBuilder.message('Registro inserido com sucesso!');
                        $state.go("sociaisList");
                    })
                    .catch(function (error) {
                        vm.error = error.data;
                    });
            } else {
                SocialService.update(vm.registro)
                    .then(function (dado) {
                        DialogBuilder.message('Registro alterado com sucesso!');
                        $state.go("sociaisList");
                    })
                    .catch(function (error) {
                        vm.error = error.data;
                    });
            }
        }
    }
})();