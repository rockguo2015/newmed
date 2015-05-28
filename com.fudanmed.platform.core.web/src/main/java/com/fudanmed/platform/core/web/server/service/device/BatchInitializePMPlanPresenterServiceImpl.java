package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.device.RCDevice;
import com.fudanmed.platform.core.device.RCDeviceCriteria;
import com.fudanmed.platform.core.device.pm.RCDevicePMSpecificationDAO;
import com.fudanmed.platform.core.web.client.device.BatchInitializePMPlanPresenterService;
import com.fudanmed.platform.core.web.server.service.device.BatchInitializePMPlanDataValidator;
import com.fudanmed.platform.core.web.server.service.device.DeviceCriteriaMapper;
import com.fudanmed.platform.core.web.shared.device.BatchInitializePMPlanData;
import com.fudanmed.platform.core.web.shared.device.UIDeviceCriteria;
import com.uniquesoft.gwt.server.common.pager.PagedQueries;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import com.uniquesoft.uidl.validation.Validates;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.device.BatchInitializePMPlanPresenterService")
@Transactional
public class BatchInitializePMPlanPresenterServiceImpl extends BaseService implements BatchInitializePMPlanPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private BatchInitializePMPlanDataValidator validator;
  
  @Autowired
  private RCDevicePMSpecificationDAO dao;
  
  @Autowired
  private DeviceCriteriaMapper criteriaMapper;
  
  public void init4Device(final UIDeviceCriteria deviceCriteria, final BatchInitializePMPlanData data) throws SessionTimeOutException, ValidationException {
    Validates.<BatchInitializePMPlanData>validateWith(data, this.validator);
    RCDeviceCriteria c = PagedQueries.createPagedCriteria(deviceCriteria, RCDeviceCriteria.class, this.criteriaMapper, this.entities);
    Collection<RCDevice> _list = c.list();
    final Procedure1<RCDevice> _function = new Procedure1<RCDevice>() {
        public void apply(final RCDevice it) {
          Date _fromDate = data.getFromDate();
          Integer _year = data.getYear();
          BatchInitializePMPlanPresenterServiceImpl.this.dao.batchInitializePMPlanUptoYear(it, _fromDate, _year);
        }
      };
    IterableExtensions.<RCDevice>forEach(_list, _function);
  }
}
