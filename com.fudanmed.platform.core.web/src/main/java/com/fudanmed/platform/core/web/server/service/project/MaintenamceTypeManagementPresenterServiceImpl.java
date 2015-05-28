package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCFaultType;
import com.fudanmed.platform.core.domain.RCMaintenamceType;
import com.fudanmed.platform.core.domain.proxy.RCFaultTypeProxy;
import com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy;
import com.fudanmed.platform.core.web.client.project.MaintenamceTypeManagementPresenterService;
import com.fudanmed.platform.core.web.server.service.project.FaultTypeMapper;
import com.fudanmed.platform.core.web.server.service.project.MaintenamceTypeMapper;
import com.fudanmed.platform.core.web.shared.project.UIFaultType;
import com.fudanmed.platform.core.web.shared.project.UIMaintenamceType;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.project.MaintenamceTypeManagementPresenterService")
@Transactional
public class MaintenamceTypeManagementPresenterServiceImpl extends BaseService implements MaintenamceTypeManagementPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private MaintenamceTypeMapper mapper;
  
  @Autowired
  private FaultTypeMapper faultTypeMapper;
  
  public Collection<UIMaintenamceType> loadAllMaintenamceType() throws SessionTimeOutException, ValidationException {
    Collection<RCMaintenamceType> _all = this.entities.<RCMaintenamceType>all(RCMaintenamceType.class);
    final Function1<RCMaintenamceType,UIMaintenamceType> _function = new Function1<RCMaintenamceType,UIMaintenamceType>() {
        public UIMaintenamceType apply(final RCMaintenamceType it) {
          UIMaintenamceType _transform = MaintenamceTypeManagementPresenterServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIMaintenamceType> _map = IterableExtensions.<RCMaintenamceType, UIMaintenamceType>map(_all, _function);
    Collection<UIMaintenamceType> _unlazy = IterableExtensions2.<UIMaintenamceType>unlazy(_map);
    return _unlazy;
  }
  
  public void delete(final RCMaintenamceTypeProxy value) throws SessionTimeOutException, ValidationException {
    RCMaintenamceType _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.domain.RCMaintenamceType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    this.entities.delete( _resolved);
  }
  
  public UIMaintenamceType getValue(final RCMaintenamceTypeProxy org) throws SessionTimeOutException, ValidationException {
    RCMaintenamceType _resolved= null;
    if(org!=null) _resolved=(com.fudanmed.platform.core.domain.RCMaintenamceType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(org, entities);
    
    UIMaintenamceType _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public Collection<UIFaultType> loadItems(final RCMaintenamceTypeProxy value) throws SessionTimeOutException, ValidationException {
    RCMaintenamceType _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.domain.RCMaintenamceType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    Collection<RCFaultType> _allSubFaultTypes =  _resolved.getAllSubFaultTypes();
    final Function1<RCFaultType,UIFaultType> _function = new Function1<RCFaultType,UIFaultType>() {
        public UIFaultType apply(final RCFaultType it) {
          UIFaultType _transform = MaintenamceTypeManagementPresenterServiceImpl.this.faultTypeMapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIFaultType> _map = IterableExtensions.<RCFaultType, UIFaultType>map(_allSubFaultTypes, _function);
    Collection<UIFaultType> _unlazy = IterableExtensions2.<UIFaultType>unlazy(_map);
    return _unlazy;
  }
  
  public void deleteChild(final RCFaultTypeProxy child) throws SessionTimeOutException, ValidationException {
    RCFaultType _resolved= null;
    if(child!=null) _resolved=(com.fudanmed.platform.core.domain.RCFaultType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(child, entities);
    
    this.entities.delete( _resolved);
  }
}
