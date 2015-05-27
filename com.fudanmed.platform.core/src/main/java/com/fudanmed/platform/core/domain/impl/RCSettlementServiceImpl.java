package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.common.RCSequenceService;
import com.fudanmed.platform.core.domain.RCRepairTask;
import com.fudanmed.platform.core.domain.RCSettlement;
import com.fudanmed.platform.core.domain.RCSettlementService;
import com.fudanmed.platform.core.domain.impl.RCSettlementImpl;
import edu.fudan.mylang.pf.BaseService;
import edu.fudan.mylang.utils.DateUtil;
import java.util.Collection;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.domain.RCSettlementService")
public class RCSettlementServiceImpl extends BaseService implements RCSettlementService {
  @Autowired
  private RCSequenceService sequenceService;
  
  public RCSettlement createSettlement(final Procedure1<? super RCSettlement> preInit) {RCSettlement rCSettlement=RCSettlementImpl.create(getObjectFactory());
    final Procedure1<RCSettlement> _function = new Procedure1<RCSettlement>() {
        public void apply(final RCSettlement it) {
          preInit.apply(it);
          String _nextSettlementSequence = RCSettlementServiceImpl.this.sequenceService.getNextSettlementSequence();
          it.setSid(_nextSettlementSequence);
          Date _now = DateUtil.now();
          it.setDate(_now);
        }
      };
    RCSettlement _doubleArrow = ObjectExtensions.<RCSettlement>operator_doubleArrow(rCSettlement, _function);
    return _doubleArrow;
  }
  
  public void cancelSettlement(final RCSettlement settlement) {
    Collection<RCRepairTask> _allItems = settlement.getAllItems();
    final Procedure1<RCRepairTask> _function = new Procedure1<RCRepairTask>() {
        public void apply(final RCRepairTask it) {
          it.cancelSettlement();
        }
      };
    IterableExtensions.<RCRepairTask>forEach(_allItems, _function);getObjectFactory().delete(settlement);
    
  }
  
  public void attachSettlementItems(final RCSettlement settlement, final Iterable<RCRepairTask> repairTasks) {
    final Procedure1<RCRepairTask> _function = new Procedure1<RCRepairTask>() {
        public void apply(final RCRepairTask it) {
          it.attachToSettlement(settlement);
        }
      };
    IterableExtensions.<RCRepairTask>forEach(repairTasks, _function);
    settlement.calculate();
  }
  
  public void detachSettlementItem(final RCSettlement settlement, final RCRepairTask repairTask) {
    repairTask.cancelSettlement();
    settlement.calculate();
  }
}
