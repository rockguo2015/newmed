package edu.fudan.langlab.uidl.domain.app.server.service.security;

import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.domain.security.Role;
import edu.fudan.langlab.domain.security.proxy.RoleProxy;
import edu.fudan.langlab.uidl.domain.app.client.security.CreateOrUpdateRolePresenterService;
import edu.fudan.langlab.uidl.domain.app.server.service.security.RoleMapper;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIRole;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("edu.fudan.langlab.uidl.domain.app.client.security.CreateOrUpdateRolePresenterService")
@Transactional
public class CreateOrUpdateRolePresenterServiceImpl extends BaseService implements CreateOrUpdateRolePresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RoleMapper mapper;
  
  public UIRole loadValue(final RoleProxy pvalue) throws SessionTimeOutException, ValidationException {
    Role _resolved= null;
    if(pvalue!=null) _resolved=(edu.fudan.langlab.domain.security.Role)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UIRole _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UIRole uivalue) throws SessionTimeOutException, ValidationException {
    Role _resolved= null;
    if(uivalue!=null) _resolved=(edu.fudan.langlab.domain.security.Role)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    this.mapper.transform(uivalue,  _resolved);
  }
  
  public void createValue(final UIRole uivalue) throws SessionTimeOutException, ValidationException {
    Role value = this.entities.<Role>create(Role.class);
    this.mapper.transform(uivalue, value);
  }
}
