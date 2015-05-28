package com.fudanmed.platform.core.web.server.service.measure;

import com.fudanmed.platform.core.measure.RCMeasureDeviceType;
import com.fudanmed.platform.core.measure.RCMeasureDeviceTypeDAO;
import com.fudanmed.platform.core.web.client.measure.MeasureDeviceTypeListPresenterService;
import com.fudanmed.platform.core.web.server.service.measure.MeasureDeviceTypeMapper;
import com.fudanmed.platform.core.web.shared.measure.UIMeasureDeviceType;
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

@Service("com.fudanmed.platform.core.web.client.measure.MeasureDeviceTypeListPresenterService")
@Transactional
public class MeasureDeviceTypeListPresenterServiceImpl extends BaseService implements MeasureDeviceTypeListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private MeasureDeviceTypeMapper mapper;
  
  @Autowired
  private RCMeasureDeviceTypeDAO dao;
  
  public Collection<UIMeasureDeviceType> loadMeasureDeviceTypeList() throws SessionTimeOutException, ValidationException {
    Collection<RCMeasureDeviceType> _allMeasureDeviceTypes = this.dao.getAllMeasureDeviceTypes();
    final Function1<RCMeasureDeviceType,UIMeasureDeviceType> _function = new Function1<RCMeasureDeviceType,UIMeasureDeviceType>() {
        public UIMeasureDeviceType apply(final RCMeasureDeviceType it) {
          UIMeasureDeviceType _transform = MeasureDeviceTypeListPresenterServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIMeasureDeviceType> _map = IterableExtensions.<RCMeasureDeviceType, UIMeasureDeviceType>map(_allMeasureDeviceTypes, _function);
    Collection<UIMeasureDeviceType> _unlazy = IterableExtensions2.<UIMeasureDeviceType>unlazy(_map);
    return _unlazy;
  }
}
