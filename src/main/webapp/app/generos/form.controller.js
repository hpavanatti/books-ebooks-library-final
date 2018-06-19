(function () {
    'use strict'

    angular.module('app')
        .controller('GeneroFormController', GeneroFormController);

        GeneroFormController.$inject = ['GeneroService', '$state', '$stateParams', 'DialogBuilder'];

    function GeneroFormController(GeneroService, $state, $stateParams, DialogBuilder) {

        var vm = this;
        vm.registro = {};
        vm.error = {};
        vm.titulo = 'Novo Gênero';

        vm.salvar = salvar;

        if ($stateParams.id) {
            GeneroService.findById($stateParams.id)
                .then(function (data) {
                    vm.registro = data;
                    vm.titulo = 'Editando Gênero';
                });
        }

        function salvar() {
            if (!vm.registro.id) {
                GeneroService.insert(vm.registro)
                    .then(function (dado) {
                        DialogBuilder.message('Registro inserido com sucesso!');
                        $state.go("generosList");
                    })
                    .catch(function (error) {
                        vm.error = error.data;
                    });
            } else {
                GeneroService.update(vm.registro)
                    .then(function (dado) {
                        DialogBuilder.message('Registro alterado com sucesso!');
                        $state.go("generosList");
                    })
                    .catch(function (error) {
                        vm.error = error.data;
                    });
            }
        }
    }
})();