(function () {

    angular.module('app', [
        'ui.router'
    ]);

    angular.module('app').config(AppConfig);

    AppConfig.$inject = ['$stateProvider'];

    function AppConfig($stateProvider) {
        $stateProvider
            .state({
                name: 'autoresList',
                url: '/autores',
                templateUrl: '/views/autores/list.html',
                controller: 'AutorListController',
                controllerAs: 'vm'
            })
            .state({
                name: 'autoresNovo',
                url: '/autores/novo',
                templateUrl: '/views/autores/form.html',
                controller: 'AutorFormController',
                controllerAs: 'vm'
            })
            .state({
                name: 'autoresEditar',
                url: '/autores/{id}',
                templateUrl: '/views/autores/form.html',
                controller: 'AutorFormController',
                controllerAs: 'vm'
            })
            .state({
                name: 'livrosList',
                url: '/livros',
                templateUrl: '/views/livros/list.html',
                controller: 'LivroListController',
                controllerAs: 'vm'
            })
            .state({
                name: 'livrosNovo',
                url: '/livros/novo',
                templateUrl: '/views/livros/form.html',
                controller: 'LivroFormController',
                controllerAs: 'vm'
            })
            .state({
                name: 'livrosEditar',
                url: '/livros/{id}',
                templateUrl: '/views/livros/form.html',
                controller: 'LivroFormController',
                controllerAs: 'vm'
            })
            .state({
                name: 'colecoesList',
                url: '/colecoes',
                templateUrl: '/views/colecoes/list.html',
                controller: 'ColecaoListController',
                controllerAs: 'vm'
            })
            .state({
                name: 'colecoesNovo',
                url: '/colecoes/novo',
                templateUrl: '/views/colecoes/form.html',
                controller: 'ColecaoFormController',
                controllerAs: 'vm'
            })
            .state({
                name: 'colecoesEditar',
                url: '/colecoes/{id}',
                templateUrl: '/views/colecoes/form.html',
                controller: 'ColecaoFormController',
                controllerAs: 'vm'
            })
            .state({
                name: 'generosList',
                url: '/generos',
                templateUrl: '/views/generos/list.html',
                controller: 'GeneroListController',
                controllerAs: 'vm'
            })
            .state({
                name: 'generosNovo',
                url: '/generos/novo',
                templateUrl: '/views/generos/form.html',
                controller: 'GeneroFormController',
                controllerAs: 'vm'
            })
            .state({
                name: 'generosEditar',
                url: '/generos/{id}',
                templateUrl: '/views/generos/form.html',
                controller: 'GeneroFormController',
                controllerAs: 'vm'
            })
            .state({
                name: 'sociaisList',
                url: '/sociais',
                templateUrl: '/views/sociais/list.html',
                controller: 'SocialListController',
                controllerAs: 'vm'
            })
            .state({
                name: 'sociaisNovo',
                url: '/sociais/novo',
                templateUrl: '/views/sociais/form.html',
                controller: 'SocialFormController',
                controllerAs: 'vm'
            })
            .state({
                name: 'sociaisEditar',
                url: '/sociais/{id}',
                templateUrl: '/views/sociais/form.html',
                controller: 'SocialFormController',
                controllerAs: 'vm'
            });
    }
})();