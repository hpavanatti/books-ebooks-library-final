package com.henriquejoaquim.booksEbooksLibrary.services;

import com.henriquejoaquim.booksEbooksLibrary.model.Genero;
import com.henriquejoaquim.booksEbooksLibrary.utils.GenericDao;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class GeneroService extends AbstractCrudService<Genero> {
    
    @Inject
    private GenericDao<Genero> dao;

    @Override
    protected GenericDao<Genero> getDao() {
        return dao;
    }
    
}
