package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.entityextension.RCCustomizableType;
import com.fudanmed.platform.core.entityextension.RCCustomizableTypeCriteria;
import com.fudanmed.platform.core.entityextension.RCNumberWithUnitType;
import com.fudanmed.platform.core.entityextension.RCRangeTypeDAO;
import com.fudanmed.platform.core.entityextension.proxy.RCCustomizableTypeProxy;
import com.fudanmed.platform.core.entityextension.proxy.RCNumberWithUnitTypeProxy;
import com.fudanmed.platform.core.web.client.device.NumberWithUnitTypeManagementPresenterService;
import com.fudanmed.platform.core.web.server.service.device.CustomizableTypeCriteriaMapper;
import com.fudanmed.platform.core.web.server.service.device.CustomizableTypeMapper;
import com.fudanmed.platform.core.web.shared.device.UICustomizableType;
import com.fudanmed.platform.core.web.shared.device.UICustomizableTypeCriteria;
import com.google.common.base.Function;
import com.uniquesoft.gwt.server.common.pager.PagedQueries;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.NumberWithUnitTypeManagementPresenterService")
@Transactional
public class NumberWithUnitTypeManagementPresenterServiceImpl extends BaseService implements NumberWithUnitTypeManagementPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private CustomizableTypeCriteriaMapper criteriaMapper;
  
  @Autowired
  private CustomizableTypeMapper mapper;
  
  @Autowired
  private RCRangeTypeDAO rangeTypeDAO;
  
  public IPagedResult<UICustomizableType> filter(final UICustomizableTypeCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    IPagedResult<UICustomizableType> _xblockexpression = null;
    {
      RCCustomizableTypeCriteria c = PagedQueries.createPagedCriteria(uicriteria, RCCustomizableTypeCriteria.class, this.criteriaMapper, this.entities);
      final Function1<RCCustomizableType,UICustomizableType> _function = new Function1<RCCustomizableType,UICustomizableType>() {
          public UICustomizableType apply(final RCCustomizableType it) {
            UICustomizableType _apply = NumberWithUnitTypeManagementPresenterServiceImpl.this.mapper.apply(it);
            return _apply;
          }
        };
      IPagedResult<UICustomizableType> _listAndTransform = PagedQueries.<UICustomizableType, RCCustomizableType>listAndTransform(c, new Function<RCCustomizableType,UICustomizableType>() {
          public UICustomizableType apply(RCCustomizableType input) {
            return _function.apply(input);
          }
      });
      _xblockexpression = (_listAndTransform);
    }
    return _xblockexpression;
  }
  
  public Boolean rangeTypeCreated(final RCNumberWithUnitTypeProxy baseType) throws SessionTimeOutException, ValidationException {
    RCNumberWithUnitType _resolved= null;
    if(baseType!=null) _resolved=(com.fudanmed.platform.core.entityextension.RCNumberWithUnitType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(baseType, entities);
    
    Boolean _rangeTypeCreated = this.rangeTypeDAO.rangeTypeCreated( _resolved);
    return _rangeTypeCreated;
  }
  
  public void createRangeType(final RCNumberWithUnitTypeProxy baseType) throws SessionTimeOutException, ValidationException {
    RCNumberWithUnitType _resolved= null;
    if(baseType!=null) _resolved=(com.fudanmed.platform.core.entityextension.RCNumberWithUnitType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(baseType, entities);
    
    this.rangeTypeDAO.create( _resolved);
  }
  
  public void delete(final RCCustomizableTypeProxy value) throws SessionTimeOutException, ValidationException {
    RCCustomizableType _resolved= null;
    if(value!=null) _resolved=(com.fudanmed.platform.core.entityextension.RCCustomizableType)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    this.entities.delete( _resolved);
  }
}
