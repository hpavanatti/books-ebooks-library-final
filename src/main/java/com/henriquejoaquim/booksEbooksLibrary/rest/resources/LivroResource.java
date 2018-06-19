package com.henriquejoaquim.booksEbooksLibrary.rest.resources;

import com.henriquejoaquim.booksEbooksLibrary.model.Livro;
import com.henriquejoaquim.booksEbooksLibrary.rest.AbstractCrudResource;
import com.henriquejoaquim.booksEbooksLibrary.services.AbstractCrudService;
import com.henriquejoaquim.booksEbooksLibrary.services.LivroService;
import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("livros")
public class LivroResource extends AbstractCrudResource<Livro> {

    @Inject
    private LivroService service;
    
    @Override
    protected AbstractCrudService<Livro> getService() {
        return service;
    }
    
}
