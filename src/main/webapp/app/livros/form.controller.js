(function () {
    'use strict'

    angular.module('app')
        .controller('LivroFormController', LivroFormController);

    LivroFormController.$inject = ['LivroService', '$state', '$stateParams', 'DialogBuilder'];

    function LivroFormController(LivroService, $state, $stateParams, DialogBuilder) {

        var vm = this;
        vm.registro = {};
        vm.error = {};
        vm.titulo = 'Novo Livro';

        vm.salvar = salvar;

        if ($stateParams.id) {
            LivroService.findById($stateParams.id)
                .then(function (data) {
                    vm.registro = data;
                    vm.titulo = 'Editando Livro';
                });
        }

        function salvar() {
            if (!vm.registro.id) {
                LivroService.insert(vm.registro)
                    .then(function (dado) {
                        DialogBuilder.message('Registro inserido com sucesso!');
                        $state.go("livrosList");
                    })
                    .catch(function (error) {
                        vm.error = error.data;
                    });
            } else {
                LivroService.update(vm.registro)
                    .then(function (dado) {
                        DialogBuilder.message('Registro alterado com sucesso!');
                        $state.go("livrosList");
                    })
                    .catch(function (error) {
                        vm.error = error.data;
                    });
            }
        }
    }
})();