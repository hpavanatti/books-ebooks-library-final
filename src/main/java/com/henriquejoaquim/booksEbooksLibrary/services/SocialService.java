package com.henriquejoaquim.booksEbooksLibrary.services;

import com.henriquejoaquim.booksEbooksLibrary.model.Social;
import com.henriquejoaquim.booksEbooksLibrary.utils.GenericDao;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class SocialService extends AbstractCrudService<Social> {
    
    @Inject
    private GenericDao<Social> dao;

    @Override
    protected GenericDao<Social> getDao() {
        return dao;
    }
    
}
