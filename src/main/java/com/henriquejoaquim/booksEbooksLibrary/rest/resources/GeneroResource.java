package com.henriquejoaquim.booksEbooksLibrary.rest.resources;

import com.henriquejoaquim.booksEbooksLibrary.model.Genero;
import com.henriquejoaquim.booksEbooksLibrary.rest.AbstractCrudResource;
import com.henriquejoaquim.booksEbooksLibrary.services.AbstractCrudService;
import com.henriquejoaquim.booksEbooksLibrary.services.GeneroService;
import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("generos")
public class GeneroResource extends AbstractCrudResource<Genero> {

    @Inject
    private GeneroService service;

    @Override
    protected AbstractCrudService<Genero> getService() {
        return service;
    }

}
