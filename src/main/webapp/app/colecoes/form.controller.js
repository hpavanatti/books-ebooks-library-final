(function () {
    'use strict'

    angular.module('app')
        .controller('ColecaoFormController', ColecaoFormController);

    ColecaoFormController.$inject = [
        'ColecaoService',
        '$state',
        '$stateParams',
        'DialogBuilder',
        'AutorService',
        'LivroService',
        'GeneroService'
    ];

    function ColecaoFormController(ColecaoService, $state, $stateParams, DialogBuilder, AutorService, LivroService, GeneroService) {

        var vm = this;
        vm.registro = {
            criacao: new Date(),
            itens: []
        };
        vm.error = {};
        vm.titulo = 'Nova Coleção';
        
        vm.autores = [];
        vm.livros = [];
        vm.generos = [];
        
        vm.salvar = salvar;
        
        vm.itemOriginal = null;
        vm.registroItem = {};

        vm.excluirItem = excluirItem;
        vm.editarItem = editarItem;
        vm.salvarItem = salvarItem;
        vm.novoItem = novoItem;

        AutorService.findAllOver()
            .then(function (data) {
                vm.autores = data;
            });

        LivroService.findAllOver()
            .then(function (data) {
                vm.livros = data;
            });

        GeneroService.findAllOver()
            .then(function (data) {
                vm.generos = data;
            });

        if ($stateParams.id) {
            ColecaoService.findById($stateParams.id)
                .then(function (data) {
                    vm.registro = data;
                    vm.registro.itens = vm.registro.itens || [];
                    vm.titulo = 'Editando Coleção';
                });
        }

        function salvar() {
            if (!vm.registro.id) {
                ColecaoService.insert(vm.registro)
                    .then(function (dado) {
                        DialogBuilder.message('Registro incluído com sucesso!');
                        $state.go('colecoesList');
                    })
                    .catch(function (error) {
                        vm.error = error.data;
                    });
            } else {
                ColecaoService.update(vm.registro)
                    .then(function (dado) {
                        DialogBuilder.message('Registro alterado com sucesso!');
                        $state.go('colecoesList');
                    })
                    .catch(function (error) {
                        vm.error = error.data;
                    });
            }
        }

        function novoItem() {
            vm.itemOriginal = null;
            vm.registroItem = {};
        }

        function editarItem(selecionado) {
            vm.itemOriginal = selecionado;
            angular.copy(selecionado, vm.registroItem);
        }

        function salvarItem() {
            var index = vm.registro.itens.indexOf(vm.itemOriginal);
            if (index != -1) {
                vm.registro.itens[index] = vm.registroItem;
            } else {
                vm.registro.itens.push(vm.registroItem);
            }
            vm.itemOriginal = null;
            vm.registroItem = {};
        }

        function excluirItem(selecionado) {
            var index = vm.registro.itens.indexOf(selecionado);
            vm.registro.itens.splice(index, 1);
        }

    }
})();