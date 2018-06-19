package com.henriquejoaquim.booksEbooksLibrary.services;

import com.henriquejoaquim.booksEbooksLibrary.model.Autor;
import com.henriquejoaquim.booksEbooksLibrary.utils.GenericDao;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class AutorService extends AbstractCrudService<Autor> {
    
    @Inject
    private GenericDao<Autor> dao;

    @Override
    protected GenericDao<Autor> getDao() {
        return dao;
    }
    
}
