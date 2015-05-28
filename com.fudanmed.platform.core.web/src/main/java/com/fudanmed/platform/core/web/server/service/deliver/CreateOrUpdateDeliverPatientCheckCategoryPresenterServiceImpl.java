package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLDeliverPatientCheckCategory;
import com.fudanmed.platform.core.deliver.DLDeliverPatientCheckCategoryDAO;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckCategoryProxy;
import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateDeliverPatientCheckCategoryPresenterService;
import com.fudanmed.platform.core.web.server.service.deliver.DeliverPatientCheckCategoryMapper;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverPatientCheckCategory;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateDeliverPatientCheckCategoryPresenterService")
@Transactional
public class CreateOrUpdateDeliverPatientCheckCategoryPresenterServiceImpl extends BaseService implements CreateOrUpdateDeliverPatientCheckCategoryPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private DeliverPatientCheckCategoryMapper mapper;
  
  @Autowired
  private DLDeliverPatientCheckCategoryDAO dao;
  
  public UIDeliverPatientCheckCategory loadValue(final DLDeliverPatientCheckCategoryProxy pvalue) throws SessionTimeOutException, ValidationException {
    DLDeliverPatientCheckCategory _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.deliver.DLDeliverPatientCheckCategory)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIDeliverPatientCheckCategory _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIDeliverPatientCheckCategory uivalue) throws SessionTimeOutException, ValidationException {
    DLDeliverPatientCheckCategory _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.deliver.DLDeliverPatientCheckCategory)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    final DLDeliverPatientCheckCategory value =  _resolved;
    final Procedure1<DLDeliverPatientCheckCategory> _function = new Procedure1<DLDeliverPatientCheckCategory>() {
        public void apply(final DLDeliverPatientCheckCategory it) {
          CreateOrUpdateDeliverPatientCheckCategoryPresenterServiceImpl.this.mapper.transform(uivalue, value);
        }
      };
    value.update(_function);
  }
  
  public void createValue(final DLDeliverPatientCheckCategoryProxy parent, final UIDeliverPatientCheckCategory uivalue) throws SessionTimeOutException, ValidationException {
    DLDeliverPatientCheckCategory _resolved= null;
    if(parent!=null) _resolved=(com.fudanmed.platform.core.deliver.DLDeliverPatientCheckCategory)com.uniquesoft.uidl.extensions.ModelObjects.resolve(parent, entities);
    
    final Procedure1<DLDeliverPatientCheckCategory> _function = new Procedure1<DLDeliverPatientCheckCategory>() {
        public void apply(final DLDeliverPatientCheckCategory it) {
          CreateOrUpdateDeliverPatientCheckCategoryPresenterServiceImpl.this.mapper.transform(uivalue, it);
        }
      };
    this.dao.create( _resolved, _function);
  }
}
