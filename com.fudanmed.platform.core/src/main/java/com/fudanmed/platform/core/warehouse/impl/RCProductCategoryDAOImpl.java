package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.warehouse.RCProductCategory;
import com.fudanmed.platform.core.warehouse.RCProductCategoryDAO;
import edu.fudan.mylang.pf.BaseService;
import edu.fudan.mylang.pf.IGenericQuery;
import java.util.Collection;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.warehouse.RCProductCategoryDAO")
public class RCProductCategoryDAOImpl extends BaseService implements RCProductCategoryDAO {
  public RCProductCategory findByCode(final String code) {
    IGenericQuery<RCProductCategory> query=getObjectFactory().createGenericQuery(RCProductCategory.class,"select p from com.fudanmed.platform.core.warehouse.impl.RCProductCategoryImpl as p   where (p.code = :code) and  p.active = 1      ").setParameter("code",code);
    RCProductCategory _uniqueResult = query.uniqueResult();
    return _uniqueResult;
  }
  
  public Iterable<RCProductCategory> getAllToplevelCategories() {
    IGenericQuery<RCProductCategory> query=getObjectFactory().createGenericQuery(RCProductCategory.class,"select p from com.fudanmed.platform.core.warehouse.impl.RCProductCategoryImpl as p   where (p.parent IS   NULL ) and  p.active = 1      ");
    Collection<RCProductCategory> _list = query.list();
    return _list;
  }
}
