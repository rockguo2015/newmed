package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLDeliverMaterialCategory;
import com.fudanmed.platform.core.deliver.DLDeliverMaterialType;
import com.fudanmed.platform.core.deliver.DLDeliverMaterialTypeCriteria;
import edu.fudan.mylang.common.HierarchyExtensions;
import edu.fudan.mylang.common.StringExtensions;
import edu.fudan.mylang.pf.query.HQLBasedPagedQueryCriteria;
import org.hibernate.Query;

public class DLDeliverMaterialTypeCriteriaImpl extends HQLBasedPagedQueryCriteria<DLDeliverMaterialType> implements DLDeliverMaterialTypeCriteria {
  private String info;
  
  public String getInfo() {
    return this.info;
  }
  
  public DLDeliverMaterialTypeCriteria setInfo(final String info) {
    this.info = info;
    return this;			
    
  }
  
  private DLDeliverMaterialCategory category;
  
  public DLDeliverMaterialCategory getCategory() {
    return this.category;
  }
  
  public DLDeliverMaterialTypeCriteria setCategory(final DLDeliverMaterialCategory category) {
    this.category = category;
    return this;			
    
  }
  
  private String idPath;
  
  public String getIdPath() {
    return this.idPath;
  }
  
  public DLDeliverMaterialTypeCriteria setIdPath(final String idPath) {
    this.idPath = idPath;
    return this;			
    
  }
  
  public void postInitialize() {
    String _idPath = HierarchyExtensions.getIdPath(this.category);
    String _sqlLike = StringExtensions.toSqlLike(_idPath);
    this.idPath = _sqlLike;
  }
  
  protected String buildHQLFrom() {
    return " from com.fudanmed.platform.core.deliver.impl.DLDeliverMaterialTypeImpl this ";
  }
  
  protected String buildHQLBody() {
    String hql = "where 1 = 1 ";
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getIdPath()) ){
    	hql += " and (this.category.fullIdPath  LIKE :idPath)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo()) ){
    	hql += " and (((this.code  LIKE :info) or (this.name  LIKE :info)) or (this.simplePy  LIKE :info))" ;
    }
    return hql;
    
  }
  
  public void initOrderBys() {
    
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
  
  public DLDeliverMaterialTypeCriteriaImpl() {
    initOrderBys();
  }
}
