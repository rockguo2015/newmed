package com.fudanmed.platform.core.entityextension.impl;

import com.fudanmed.platform.core.entityextension.RCCustomizableType;
import com.fudanmed.platform.core.entityextension.RCCustomizableTypeCriteria;
import edu.fudan.mylang.pf.query.HQLBasedPagedQueryCriteria;
import org.hibernate.Query;

public class RCCustomizableTypeCriteriaImpl extends HQLBasedPagedQueryCriteria<RCCustomizableType> implements RCCustomizableTypeCriteria {
  protected String buildHQLFrom() {
    return " from com.fudanmed.platform.core.entityextension.impl.RCCustomizableTypeImpl this ";
  }
  
  protected String buildHQLBody() {
    String hql = "where 1 = 1 ";
    return hql;
    
  }
  
  public void initOrderBys() {
    
  }
  
  protected void fillParameter(final Query query) {
    
  }
  
  protected Boolean isDistinct() {
    return false;
  }
  
  public RCCustomizableTypeCriteriaImpl() {
    initOrderBys();
  }
}
