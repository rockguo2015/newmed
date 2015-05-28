package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLInHospitalLocationCriteria;
import com.fudanmed.platform.core.web.shared.deliver.UIInHospitalLocationCriteria;
import com.uniquesoft.uidl.transform.AbstractDataTypeMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.deliver.InHospitalLocationCriteriaMapper")
public class InHospitalLocationCriteriaMapper extends AbstractDataTypeMapper<UIInHospitalLocationCriteria,DLInHospitalLocationCriteria> {
  @Autowired
  private IConvertService convertService;
  
  public void copyToEntity(final UIInHospitalLocationCriteria from, final DLInHospitalLocationCriteria to) {
    to.setInfo(convertService.toValue(java.lang.String.class,from.getInfo()));
    
  }
  
  public UIInHospitalLocationCriteria copyFromEntity(final UIInHospitalLocationCriteria result, final DLInHospitalLocationCriteria entity) {
    if(entity==null) return null;
    result.setInfo(convertService.toValue(java.lang.String.class,entity.getInfo()));
    return result;
    
  }
  
  public UIInHospitalLocationCriteria buildFrom(final DLInHospitalLocationCriteria entity) {
    if(entity==null) return null;
    com.fudanmed.platform.core.web.shared.deliver.UIInHospitalLocationCriteria result = new com.fudanmed.platform.core.web.shared.deliver.UIInHospitalLocationCriteria();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  public Class<?> getUIClass() {
    return UIInHospitalLocationCriteria.class;
  }
  
  public Class<?> getEntityClass() {
    return DLInHospitalLocationCriteria.class;
  }
}
