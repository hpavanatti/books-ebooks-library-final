package com.henriquejoaquim.booksEbooksLibrary.rest.resources;

import com.henriquejoaquim.booksEbooksLibrary.model.Autor;
import com.henriquejoaquim.booksEbooksLibrary.rest.AbstractCrudResource;
import com.henriquejoaquim.booksEbooksLibrary.services.AbstractCrudService;
import com.henriquejoaquim.booksEbooksLibrary.services.AutorService;
import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("autores")
public class AutorResource extends AbstractCrudResource<Autor> {

    @Inject
    private AutorService service;

    @Override
    protected AbstractCrudService<Autor> getService() {
        return service;
    }

}
