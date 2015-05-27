package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.warehouse.RCStockTakingList;
import com.fudanmed.platform.core.warehouse.RCStockTakingRecord;
import com.fudanmed.platform.core.warehouse.RCStockTakingService;
import com.fudanmed.platform.core.warehouse.RCStockTakingStatus;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.impl.RCStockTakingListImpl;
import com.fudanmed.platform.core.warehouse.impl.RCStockTakingStatusImpl;
import com.uniquesoft.uidl.validation.Validates;
import edu.fudan.mylang.common.ObjectExtensions2;
import edu.fudan.mylang.pf.BaseService;
import edu.fudan.mylang.pf.IGenericQuery;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.warehouse.RCStockTakingService")
public class RCStockTakingServiceImpl extends BaseService implements RCStockTakingService {
  public RCStockTakingStatus getStockTakingStatus(final RCWarehouse warehouse) {
    IGenericQuery<RCStockTakingStatus> query=getObjectFactory().createGenericQuery(RCStockTakingStatus.class,"select s from com.fudanmed.platform.core.warehouse.impl.RCStockTakingStatusImpl as s   where (s.warehouse = :warehouse) and  s.active = 1      ").setParameter("warehouse",warehouse);
    RCStockTakingStatus _uniqueResult = query.uniqueResult();
    final Function1<Void,RCStockTakingStatus> _function = new Function1<Void,RCStockTakingStatus>() {
        public RCStockTakingStatus apply(final Void it) {RCStockTakingStatus rCStockTakingStatus=RCStockTakingStatusImpl.create(getObjectFactory());
          final Procedure1<RCStockTakingStatus> _function = new Procedure1<RCStockTakingStatus>() {
              public void apply(final RCStockTakingStatus it) {
                it.setWarehouse(warehouse);
                it.setIsInStockTaking(Boolean.valueOf(false));
              }
            };
          RCStockTakingStatus _doubleArrow = ObjectExtensions.<RCStockTakingStatus>operator_doubleArrow(rCStockTakingStatus, _function);
          return _doubleArrow;
        }
      };
    RCStockTakingStatus _withDefault = ObjectExtensions2.<RCStockTakingStatus>withDefault(_uniqueResult, _function);
    return _withDefault;
  }
  
  public Boolean canPerformStockOperation(final RCWarehouse warehouse) {
    RCStockTakingStatus _stockTakingStatus = this.getStockTakingStatus(warehouse);
    Boolean _isInStockTaking = _stockTakingStatus.getIsInStockTaking();
    boolean _not = (!_isInStockTaking);
    return Boolean.valueOf(_not);
  }
  
  /**
   * 开始盘点时生成盘点单
   */
  public RCStockTakingList startStockTaking(final Function1<? super RCStockTakingList,? extends RCStockTakingList> preInit) {RCStockTakingList rCStockTakingList=RCStockTakingListImpl.create(getObjectFactory());
    final Procedure1<RCStockTakingList> _function = new Procedure1<RCStockTakingList>() {
        public void apply(final RCStockTakingList it) {
          preInit.apply(it);
          RCWarehouse _warehouse = it.getWarehouse();
          Boolean _canPerformStockOperation = RCStockTakingServiceImpl.this.canPerformStockOperation(_warehouse);
          Validates.Assert((_canPerformStockOperation).booleanValue(), "\u6B63\u5728\u76D8\u70B9\u4E2D");
          RCEmployee _operator = it.getOperator();
          it.initializeStockTakingItems(_operator);
          RCWarehouse _warehouse_1 = it.getWarehouse();
          RCStockTakingStatus _stockTakingStatus = RCStockTakingServiceImpl.this.getStockTakingStatus(_warehouse_1);
          _stockTakingStatus.setIsInStockTaking(Boolean.valueOf(true));
        }
      };
    RCStockTakingList _doubleArrow = ObjectExtensions.<RCStockTakingList>operator_doubleArrow(rCStockTakingList, _function);
    return _doubleArrow;
  }
  
  public void commitStockTaking(final RCStockTakingList stockTakingList, final RCEmployee operator) {
    RCWarehouse _warehouse = stockTakingList.getWarehouse();
    RCStockTakingStatus _stockTakingStatus = this.getStockTakingStatus(_warehouse);
    _stockTakingStatus.setIsInStockTaking(Boolean.valueOf(false));
    RCStockTakingRecord _createStockTakingRecord = stockTakingList.createStockTakingRecord();
    final Procedure1<RCStockTakingRecord> _function = new Procedure1<RCStockTakingRecord>() {
        public void apply(final RCStockTakingRecord it) {
          it.commit(operator);
        }
      };
    ObjectExtensions.<RCStockTakingRecord>operator_doubleArrow(_createStockTakingRecord, _function);
  }
  
  public void cancelStockTaking(final RCStockTakingList stockTakingList) {
    RCWarehouse _warehouse = stockTakingList.getWarehouse();
    RCStockTakingStatus _stockTakingStatus = this.getStockTakingStatus(_warehouse);
    _stockTakingStatus.setIsInStockTaking(Boolean.valueOf(false));getObjectFactory().delete(stockTakingList);
    
  }
}
