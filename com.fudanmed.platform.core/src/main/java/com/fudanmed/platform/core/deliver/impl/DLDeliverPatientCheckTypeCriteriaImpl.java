package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLDeliverPatientCheckCategory;
import com.fudanmed.platform.core.deliver.DLDeliverPatientCheckType;
import com.fudanmed.platform.core.deliver.DLDeliverPatientCheckTypeCriteria;
import edu.fudan.mylang.common.HierarchyExtensions;
import edu.fudan.mylang.common.StringExtensions;
import edu.fudan.mylang.pf.query.HQLBasedPagedQueryCriteria;
import org.hibernate.Query;

public class DLDeliverPatientCheckTypeCriteriaImpl extends HQLBasedPagedQueryCriteria<DLDeliverPatientCheckType> implements DLDeliverPatientCheckTypeCriteria {
  private String info;
  
  public String getInfo() {
    return this.info;
  }
  
  public DLDeliverPatientCheckTypeCriteria setInfo(final String info) {
    this.info = info;
    return this;			
    
  }
  
  private DLDeliverPatientCheckCategory category;
  
  public DLDeliverPatientCheckCategory getCategory() {
    return this.category;
  }
  
  public DLDeliverPatientCheckTypeCriteria setCategory(final DLDeliverPatientCheckCategory category) {
    this.category = category;
    return this;			
    
  }
  
  private String idPath;
  
  public String getIdPath() {
    return this.idPath;
  }
  
  public DLDeliverPatientCheckTypeCriteria setIdPath(final String idPath) {
    this.idPath = idPath;
    return this;			
    
  }
  
  public void postInitialize() {
    String _idPath = HierarchyExtensions.getIdPath(this.category);
    String _sqlLike = StringExtensions.toSqlLike(_idPath);
    this.idPath = _sqlLike;
  }
  
  protected String buildHQLFrom() {
    return " from com.fudanmed.platform.core.deliver.impl.DLDeliverPatientCheckTypeImpl this ";
  }
  
  protected String buildHQLBody() {
    String hql = "where 1 = 1 ";
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo()) ){
    	hql += " and (((this.code  LIKE :info) or (this.name  LIKE :info)) or (this.simplePy  LIKE :info))" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getIdPath()) ){
    	hql += " and (this.category.fullIdPath  LIKE :idPath)" ;
    }
    return hql;
    
  }
  
  public void initOrderBys() {
    addOrder("this.code",edu.fudan.mylang.pf.query.OrderItem.ASC);
  }
  
  protected void fillParameter(final Query query) {
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo())){
    	query.setParameter("info",getInfo()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getIdPath())){
    	query.setParameter("idPath",getIdPath()) ;
    }			
    
  }
  
  protected Boolean isDistinct() {
    return false;
  }
  
  public DLDeliverPatientCheckTypeCriteriaImpl() {
    initOrderBys();
  }
}
