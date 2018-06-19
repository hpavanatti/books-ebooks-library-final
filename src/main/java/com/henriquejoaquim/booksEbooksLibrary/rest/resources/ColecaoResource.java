package com.henriquejoaquim.booksEbooksLibrary.rest.resources;

import com.henriquejoaquim.booksEbooksLibrary.model.Colecao;
import com.henriquejoaquim.booksEbooksLibrary.rest.AbstractCrudResource;
import com.henriquejoaquim.booksEbooksLibrary.services.AbstractCrudService;
import com.henriquejoaquim.booksEbooksLibrary.services.ColecaoService;
import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("colecoes")
public class ColecaoResource extends AbstractCrudResource<Colecao> {

    @Inject
    private ColecaoService service;
    
    @Override
    protected AbstractCrudService<Colecao> getService() {
        return service;
    }
    
}
