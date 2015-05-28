package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLDeliverMaterialCategory;
import com.fudanmed.platform.core.deliver.DLDeliverMaterialCategoryDAO;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialCategoryProxy;
import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateDeliverMaterialCategoryPresenterService;
import com.fudanmed.platform.core.web.server.service.deliver.DeliverMaterialCategoryMapper;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverMaterialCategory;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateDeliverMaterialCategoryPresenterService")
@Transactional
public class CreateOrUpdateDeliverMaterialCategoryPresenterServiceImpl extends BaseService implements CreateOrUpdateDeliverMaterialCategoryPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private DeliverMaterialCategoryMapper mapper;
  
  @Autowired
  private DLDeliverMaterialCategoryDAO dao;
  
  public UIDeliverMaterialCategory loadValue(final DLDeliverMaterialCategoryProxy pvalue) throws SessionTimeOutException, ValidationException {
    DLDeliverMaterialCategory _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.deliver.DLDeliverMaterialCategory)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIDeliverMaterialCategory _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIDeliverMaterialCategory uivalue) throws SessionTimeOutException, ValidationException {
    DLDeliverMaterialCategory _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.deliver.DLDeliverMaterialCategory)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    this.mapper.transform(uivalue,  _resolved);
  }
  
  public void createValue(final DLDeliverMaterialCategoryProxy parent, final UIDeliverMaterialCategory uivalue) throws SessionTimeOutException, ValidationException {
    DLDeliverMaterialCategory _resolved= null;
    if(parent!=null) _resolved=(com.fudanmed.platform.core.deliver.DLDeliverMaterialCategory)com.uniquesoft.uidl.extensions.ModelObjects.resolve(parent, entities);
    
    final Procedure1<DLDeliverMaterialCategory> _function = new Procedure1<DLDeliverMaterialCategory>() {
        public void apply(final DLDeliverMaterialCategory it) {
          CreateOrUpdateDeliverMaterialCategoryPresenterServiceImpl.this.mapper.transform(uivalue, it);
        }
      };
    this.dao.create( _resolved, _function);
  }
}
