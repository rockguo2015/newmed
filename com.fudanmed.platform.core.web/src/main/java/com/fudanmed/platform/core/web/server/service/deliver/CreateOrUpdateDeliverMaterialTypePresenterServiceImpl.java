package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLDeliverMaterialCategory;
import com.fudanmed.platform.core.deliver.DLDeliverMaterialType;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialCategoryProxy;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialTypeProxy;
import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateDeliverMaterialTypePresenterService;
import com.fudanmed.platform.core.web.server.service.deliver.DeliverMaterialTypeMapper;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverMaterialType;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateDeliverMaterialTypePresenterService")
@Transactional
public class CreateOrUpdateDeliverMaterialTypePresenterServiceImpl extends BaseService implements CreateOrUpdateDeliverMaterialTypePresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private DeliverMaterialTypeMapper mapper;
  
  public UIDeliverMaterialType loadValue(final DLDeliverMaterialTypeProxy pvalue) throws SessionTimeOutException, ValidationException {
    DLDeliverMaterialType _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.deliver.DLDeliverMaterialType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIDeliverMaterialType _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIDeliverMaterialType uivalue) throws SessionTimeOutException, ValidationException {
    DLDeliverMaterialType _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.deliver.DLDeliverMaterialType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    this.mapper.transform(uivalue,  _resolved);
  }
  
  public void createValue(final UIDeliverMaterialType uivalue, final DLDeliverMaterialCategoryProxy parent) throws SessionTimeOutException, ValidationException {
    DLDeliverMaterialCategory _resolved= null;
    if(parent!=null) _resolved=(com.fudanmed.platform.core.deliver.DLDeliverMaterialCategory)com.uniquesoft.uidl.extensions.ModelObjects.resolve(parent, entities);
    
    final Procedure1<DLDeliverMaterialType> _function = new Procedure1<DLDeliverMaterialType>() {
        public void apply(final DLDeliverMaterialType it) {
          CreateOrUpdateDeliverMaterialTypePresenterServiceImpl.this.mapper.transform(uivalue, it);
        }
      };
     _resolved.createMaterialType(_function);
  }
}
