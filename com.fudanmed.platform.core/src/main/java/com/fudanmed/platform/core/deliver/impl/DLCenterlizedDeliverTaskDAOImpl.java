package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.common.RCSequenceService;
import com.fudanmed.platform.core.deliver.DLCenterlizedDeliverTask;
import com.fudanmed.platform.core.deliver.DLCenterlizedDeliverTaskDAO;
import com.fudanmed.platform.core.deliver.DLPatientCheckDeliver;
import com.fudanmed.platform.core.deliver.events.DLCenterlizedDeliverTaskEventsManager;
import com.fudanmed.platform.core.deliver.impl.DLCenterlizedDeliverTaskImpl;
import edu.fudan.mylang.pf.BaseDAOService;
import edu.fudan.mylang.utils.DateUtil;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.deliver.DLCenterlizedDeliverTaskDAO")
public class DLCenterlizedDeliverTaskDAOImpl extends BaseDAOService<DLCenterlizedDeliverTask> implements DLCenterlizedDeliverTaskDAO {
  @Autowired
  private DLCenterlizedDeliverTaskEventsManager eventsManager;
  
  @Autowired
  private RCSequenceService sequenceService;
  
  public DLCenterlizedDeliverTask createPatientCheckDeliverTask(final DLPatientCheckDeliver deliver, final Procedure1<? super DLCenterlizedDeliverTask> init) {DLCenterlizedDeliverTask dLCenterlizedDeliverTask=DLCenterlizedDeliverTaskImpl.create(getObjectFactory());
    final Procedure1<DLCenterlizedDeliverTask> _function = new Procedure1<DLCenterlizedDeliverTask>() {
        public void apply(final DLCenterlizedDeliverTask it) {
          it.setSubject(deliver);
          Date _now = DateUtil.now();
          it.setCreateTime(_now);
          String _nextCenterilzedTaskSequence = DLCenterlizedDeliverTaskDAOImpl.this.sequenceService.getNextCenterilzedTaskSequence();
          it.setSid(_nextCenterilzedTaskSequence);
          init.apply(it);
          it.start();
          DLCenterlizedDeliverTaskDAOImpl.this.eventsManager.fireCreated(it);
        }
      };
    DLCenterlizedDeliverTask _doubleArrow = ObjectExtensions.<DLCenterlizedDeliverTask>operator_doubleArrow(dLCenterlizedDeliverTask, _function);
    return _doubleArrow;
  }
  
  public void delete(final DLCenterlizedDeliverTask value) {getObjectFactory().delete(value);
    
    this.eventsManager.fireDeleted(value);
  }
  
  public void update(final DLCenterlizedDeliverTask value, final Procedure1<? super DLCenterlizedDeliverTask> updater) {
    updater.apply(value);
    this.eventsManager.fireUpdateded(value);
  }
}
