package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.RCDeviceType;
import com.fudanmed.platform.core.device.RCDeviceTypeCategory;
import com.fudanmed.platform.core.device.RCDeviceTypeCategoryDAO;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.device.DeviceCategoryAndTypeListPresenterService;
import com.fudanmed.platform.core.web.shared.device.UIDeviceCategoryAndType;
import com.fudanmed.platform.core.web.shared.device.UIDeviceCategoryOrTypeType;
import com.google.common.base.Objects;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.DeviceCategoryAndTypeListPresenterService")
@Transactional
public class DeviceCategoryAndTypeListPresenterServiceImpl extends BaseService implements DeviceCategoryAndTypeListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private RCDeviceTypeCategoryDAO categoryDao;
  
  public Collection<UIDeviceCategoryAndType> loadCategories() throws SessionTimeOutException, ValidationException {
    ArrayList<UIDeviceCategoryAndType> _xblockexpression = null;
    {
      final ArrayList<UIDeviceCategoryAndType> results = CollectionLiterals.<UIDeviceCategoryAndType>newArrayList();
      Collection<RCDeviceTypeCategory> _allRootCategories = this.categoryDao.allRootCategories();
      final Procedure1<RCDeviceTypeCategory> _function = new Procedure1<RCDeviceTypeCategory>() {
          public void apply(final RCDeviceTypeCategory category) {
            RCDeviceTypeCategoryProxy _proxy = category.toProxy();
            DeviceCategoryAndTypeListPresenterServiceImpl.this.loadCategories(null, _proxy, results);
          }
        };
      IterableExtensions.<RCDeviceTypeCategory>forEach(_allRootCategories, _function);
      _xblockexpression = (results);
    }
    return _xblockexpression;
  }
  
  public GWTNamedEntity loadCategoryOrType(final UIDeviceCategoryAndType categoryOrType) throws SessionTimeOutException, ValidationException {
    GWTNamedEntity _switchResult = null;
    UIDeviceCategoryOrTypeType _type = categoryOrType.getType();
    final UIDeviceCategoryOrTypeType _switchValue = _type;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_switchValue,UIDeviceCategoryOrTypeType.type)) {
        _matched=true;
        Long _id = categoryOrType.getId();
        RCDeviceType _get = this.entities.<RCDeviceType>get(RCDeviceType.class, _id);
        RCDeviceTypeProxy _proxy = _get.toProxy();
        _switchResult = _proxy;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,UIDeviceCategoryOrTypeType.category)) {
        _matched=true;
        Long _id_1 = categoryOrType.getId();
        RCDeviceTypeCategory _get_1 = this.entities.<RCDeviceTypeCategory>get(RCDeviceTypeCategory.class, _id_1);
        RCDeviceTypeCategoryProxy _proxy_1 = _get_1.toProxy();
        _switchResult = _proxy_1;
      }
    }
    return _switchResult;
  }
  
  public void loadCategories(final UIDeviceCategoryAndType parent, final RCDeviceTypeCategoryProxy pcategory, final Collection<UIDeviceCategoryAndType> results) throws SessionTimeOutException, ValidationException {
    RCDeviceTypeCategory _resolved= null;
    if(pcategory!=null) _resolved=(com.fudanmed.platform.core.device.RCDeviceTypeCategory)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pcategory, entities);
    
    final RCDeviceTypeCategory category =  _resolved;
    UIDeviceCategoryAndType _uIDeviceCategoryAndType = new UIDeviceCategoryAndType();
    final Procedure1<UIDeviceCategoryAndType> _function = new Procedure1<UIDeviceCategoryAndType>() {
        public void apply(final UIDeviceCategoryAndType categoryAndType) {
          Long _id = category.getId();
          categoryAndType.setId(_id);
          categoryAndType.setType(UIDeviceCategoryOrTypeType.category);
          String _entityName = category.getEntityName();
          categoryAndType.setName(_entityName);
          categoryAndType.setParent(parent);
          Collection<RCDeviceType> _deviceTypes = category.getDeviceTypes();
          final Procedure1<RCDeviceType> _function = new Procedure1<RCDeviceType>() {
              public void apply(final RCDeviceType deviceType) {
                UIDeviceCategoryAndType _uIDeviceCategoryAndType = new UIDeviceCategoryAndType();
                final Procedure1<UIDeviceCategoryAndType> _function = new Procedure1<UIDeviceCategoryAndType>() {
                    public void apply(final UIDeviceCategoryAndType it) {
                      Long _id = deviceType.getId();
                      it.setId(_id);
                      it.setType(UIDeviceCategoryOrTypeType.type);
                      String _entityName = deviceType.getEntityName();
                      it.setName(_entityName);
                      it.setParent(categoryAndType);
                    }
                  };
                UIDeviceCategoryAndType _doubleArrow = ObjectExtensions.<UIDeviceCategoryAndType>operator_doubleArrow(_uIDeviceCategoryAndType, _function);
                results.add(_doubleArrow);
              }
            };
          IterableExtensions.<RCDeviceType>forEach(_deviceTypes, _function);
        }
      };
    final UIDeviceCategoryAndType result = ObjectExtensions.<UIDeviceCategoryAndType>operator_doubleArrow(_uIDeviceCategoryAndType, _function);
    results.add(result);
    Collection<RCDeviceTypeCategory> _subCategories = category.getSubCategories();
    final Procedure1<RCDeviceTypeCategory> _function_1 = new Procedure1<RCDeviceTypeCategory>() {
        public void apply(final RCDeviceTypeCategory it) {
          RCDeviceTypeCategoryProxy _proxy = it.toProxy();
          DeviceCategoryAndTypeListPresenterServiceImpl.this.loadCategories(result, _proxy, results);
        }
      };
    IterableExtensions.<RCDeviceTypeCategory>forEach(_subCategories, _function_1);
  }
}
