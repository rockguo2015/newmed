package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLInHospitalPatient;
import com.fudanmed.platform.core.deliver.DLInHospitalPatientCriteria;
import edu.fudan.mylang.pf.query.HQLBasedPagedQueryCriteria;
import org.hibernate.Query;

public class DLInHospitalPatientCriteriaImpl extends HQLBasedPagedQueryCriteria<DLInHospitalPatient> implements DLInHospitalPatientCriteria {
  private String info;
  
  public String getInfo() {
    return this.info;
  }
  
  public DLInHospitalPatientCriteria setInfo(final String info) {
    this.info = info;
    return this;			
    
  }
  
  protected String buildHQLFrom() {
    return " from com.fudanmed.platform.core.deliver.impl.DLInHospitalPatientImpl this ";
  }
  
  protected String buildHQLBody() {
    String hql = "where 1 = 1 ";
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo()) ){
    	hql += " and (((this.sid  LIKE :info) or (this.name  LIKE :info)) or (this.simplePy  LIKE :info))" ;
    }
    return hql;
    
  }
  
  public void initOrderBys() {
    
  }
  
  protected void fillParameter(final Query query) {
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo())){
    	query.setParameter("info",getInfo()) ;
    }			
    
  }
  
  protected Boolean isDistinct() {
    return false;
  }
  
  public DLInHospitalPatientCriteriaImpl() {
    initOrderBys();
  }
}
