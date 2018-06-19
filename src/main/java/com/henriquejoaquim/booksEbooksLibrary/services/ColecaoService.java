package com.henriquejoaquim.booksEbooksLibrary.services;

import com.henriquejoaquim.booksEbooksLibrary.model.Colecao;
import com.henriquejoaquim.booksEbooksLibrary.utils.GenericDao;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class ColecaoService extends AbstractCrudService<Colecao> {

    @Inject
    private GenericDao<Colecao> dao;
    
    @Override
    protected GenericDao<Colecao> getDao() {
        return dao;
    }
}
