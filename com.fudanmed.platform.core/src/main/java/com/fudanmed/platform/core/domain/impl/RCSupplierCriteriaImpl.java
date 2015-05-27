package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.domain.RCSupplier;
import com.fudanmed.platform.core.domain.RCSupplierCriteria;
import com.fudanmed.platform.core.domain.RCSupplierType;
import edu.fudan.mylang.pf.query.HQLBasedPagedQueryCriteria;
import org.hibernate.Query;

public class RCSupplierCriteriaImpl extends HQLBasedPagedQueryCriteria<RCSupplier> implements RCSupplierCriteria {
  private String info;
  
  public String getInfo() {
    return this.info;
  }
  
  public RCSupplierCriteria setInfo(final String info) {
    this.info = info;
    return this;			
    
  }
  
  private RCSupplierType type;
  
  public RCSupplierType getType() {
    return this.type;
  }
  
  public RCSupplierCriteria setType(final RCSupplierType type) {
    this.type = type;
    return this;			
    
  }
  
  protected String buildHQLFrom() {
    return " from com.fudanmed.platform.core.domain.impl.RCSupplierImpl this ";
  }
  
  protected String buildHQLBody() {
    String hql = "where 1 = 1 ";
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo()) ){
    	hql += " and ((((((((((((((this.code  LIKE :info) or (this.name  LIKE :info)) or (this.shortName  LIKE :info)) or (this.ename  LIKE :info)) or (this.spell  LIKE :info)) or (this.helpCode  LIKE :info)) or (this.enterpriseEnrolNum  LIKE :info)) or (this.workNo  LIKE :info)) or (this.legalPerson  LIKE :info)) or (this.aptitudeName  LIKE :info)) or (this.aptitudeNo  LIKE :info)) or (this.phone  LIKE :info)) or (this.email  LIKE :info)) or (this.address  LIKE :info))" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getType()) ){
    	hql += " and (this.type = :type)" ;
    }
    return hql;
    
  }
  
  public void initOrderBys() {
    
  }
  
  protected void fillParameter(final Query query) {
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo())){
    	query.setParameter("info",getInfo()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getType())){
    	query.setParameter("type",getType()) ;
    }			
    
  }
  
  protected Boolean isDistinct() {
    return false;
  }
  
  public RCSupplierCriteriaImpl() {
    initOrderBys();
  }
}
