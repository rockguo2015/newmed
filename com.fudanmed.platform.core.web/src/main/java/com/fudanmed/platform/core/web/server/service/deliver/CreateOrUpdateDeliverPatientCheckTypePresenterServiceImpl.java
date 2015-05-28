package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLDeliverPatientCheckCategory;
import com.fudanmed.platform.core.deliver.DLDeliverPatientCheckType;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckCategoryProxy;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckTypeProxy;
import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateDeliverPatientCheckTypePresenterService;
import com.fudanmed.platform.core.web.server.service.deliver.DeliverPatientCheckTypeMapper;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverPatientCheckType;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateDeliverPatientCheckTypePresenterService")
@Transactional
public class CreateOrUpdateDeliverPatientCheckTypePresenterServiceImpl extends BaseService implements CreateOrUpdateDeliverPatientCheckTypePresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private DeliverPatientCheckTypeMapper mapper;
  
  public UIDeliverPatientCheckType loadValue(final DLDeliverPatientCheckTypeProxy pvalue) throws SessionTimeOutException, ValidationException {
    DLDeliverPatientCheckType _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.deliver.DLDeliverPatientCheckType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIDeliverPatientCheckType _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIDeliverPatientCheckType uivalue) throws SessionTimeOutException, ValidationException {
    DLDeliverPatientCheckType _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.deliver.DLDeliverPatientCheckType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    this.mapper.transform(uivalue,  _resolved);
  }
  
  public void createValue(final UIDeliverPatientCheckType uivalue, final DLDeliverPatientCheckCategoryProxy parent) throws SessionTimeOutException, ValidationException {
    DLDeliverPatientCheckCategory _resolved= null;
    if(parent!=null) _resolved=(com.fudanmed.platform.core.deliver.DLDeliverPatientCheckCategory)com.uniquesoft.uidl.extensions.ModelObjects.resolve(parent, entities);
    
    final Procedure1<DLDeliverPatientCheckType> _function = new Procedure1<DLDeliverPatientCheckType>() {
        public void apply(final DLDeliverPatientCheckType it) {
          CreateOrUpdateDeliverPatientCheckTypePresenterServiceImpl.this.mapper.transform(uivalue, it);
        }
      };
     _resolved.createCheckType(_function);
  }
}
