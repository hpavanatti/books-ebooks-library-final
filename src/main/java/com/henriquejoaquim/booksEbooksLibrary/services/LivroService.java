package com.henriquejoaquim.booksEbooksLibrary.services;

import com.henriquejoaquim.booksEbooksLibrary.model.Livro;
import com.henriquejoaquim.booksEbooksLibrary.utils.GenericDao;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class LivroService extends AbstractCrudService<Livro>{

    @Inject
    private GenericDao<Livro> dao;
    
    @Override
    protected GenericDao<Livro> getDao() {
        return dao;
    }
}
