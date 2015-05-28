package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLInHospitalLocation;
import com.fudanmed.platform.core.deliver.DLInHospitalLocationDAO;
import com.fudanmed.platform.core.deliver.proxy.DLInHospitalLocationProxy;
import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateInHospitalLocationPresenterService;
import com.fudanmed.platform.core.web.server.service.deliver.InHospitalLocationMapper;
import com.fudanmed.platform.core.web.shared.deliver.UIInHospitalLocation;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateInHospitalLocationPresenterService")
@Transactional
public class CreateOrUpdateInHospitalLocationPresenterServiceImpl extends BaseService implements CreateOrUpdateInHospitalLocationPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private InHospitalLocationMapper mapper;
  
  @Autowired
  private DLInHospitalLocationDAO dao;
  
  public UIInHospitalLocation loadValue(final DLInHospitalLocationProxy pvalue) throws SessionTimeOutException, ValidationException {
    DLInHospitalLocation _resolved= null;
    if(pvalue!=null) _resolved=(com.fudanmed.platform.core.deliver.DLInHospitalLocation)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIInHospitalLocation _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIInHospitalLocation uivalue) throws SessionTimeOutException, ValidationException {
    DLInHospitalLocation _resolved= null;
    if(uivalue!=null) _resolved=(com.fudanmed.platform.core.deliver.DLInHospitalLocation)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    this.mapper.transform(uivalue,  _resolved);
  }
  
  public void createValue(final UIInHospitalLocation uivalue) throws SessionTimeOutException, ValidationException {
    final Procedure1<DLInHospitalLocation> _function = new Procedure1<DLInHospitalLocation>() {
        public void apply(final DLInHospitalLocation it) {
          CreateOrUpdateInHospitalLocationPresenterServiceImpl.this.mapper.transform(uivalue, it);
        }
      };
    this.dao.create(_function);
  }
}
