(function () {
    'use strict'

    angular.module('app')
        .controller('AutorFormController', AutorFormController);

        AutorFormController.$inject = ['AutorService', '$state', '$stateParams', 'DialogBuilder', 'SocialService'];

    function AutorFormController(AutorService, $state, $stateParams, DialogBuilder, SocialService) {

        var vm = this;
        vm.registro = {};
        vm.error = {};
        vm.titulo = 'Novo Autor';

        vm.sociais = [];

        vm.salvar = salvar;

        SocialService.findAllOver()
        .then(function (data) {
            vm.sociais = data;
        });

        if ($stateParams.id) {
            AutorService.findById($stateParams.id)
                .then(function (data) {
                    vm.registro = data;
                    vm.titulo = 'Editando Autor';
                });
        }

        function salvar() {
            if (!vm.registro.id) {
                AutorService.insert(vm.registro)
                    .then(function (dado) {
                        DialogBuilder.message('Registro inserido com sucesso!');
                        $state.go("autoresList");
                    })
                    .catch(function (error) {
                        vm.error = error.data;
                    });
            } else {
                AutorService.update(vm.registro)
                    .then(function (dado) {
                        DialogBuilder.message('Registro alterado com sucesso!');
                        $state.go("autoresList");
                    })
                    .catch(function (error) {
                        vm.error = error.data;
                    });
            }
        }
    }
})();