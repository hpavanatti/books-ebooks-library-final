package com.henriquejoaquim.booksEbooksLibrary.rest.resources;

import com.henriquejoaquim.booksEbooksLibrary.model.Social;
import com.henriquejoaquim.booksEbooksLibrary.rest.AbstractCrudResource;
import com.henriquejoaquim.booksEbooksLibrary.services.AbstractCrudService;
import com.henriquejoaquim.booksEbooksLibrary.services.SocialService;
import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("sociais")
public class SocialResource extends AbstractCrudResource<Social> {

    @Inject
    private SocialService service;

    @Override
    protected AbstractCrudService<Social> getService() {
        return service;
    }

}
