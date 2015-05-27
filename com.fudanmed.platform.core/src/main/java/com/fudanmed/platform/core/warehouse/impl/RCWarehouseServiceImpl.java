package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.common.RCSequenceService;
import com.fudanmed.platform.core.warehouse.RCOutStockRecord;
import com.fudanmed.platform.core.warehouse.RCProductEntry;
import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCProductSpecificationSummary;
import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageSummary;
import com.fudanmed.platform.core.warehouse.RCStockTakingRecord;
import com.fudanmed.platform.core.warehouse.RCTransferRecord;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import com.fudanmed.platform.core.warehouse.RCWarehouseService;
import com.fudanmed.platform.core.warehouse.RCWorkItemOutStockRecord;
import com.fudanmed.platform.core.warehouse.RCWorkItemReturnStockRecord;
import com.fudanmed.platform.core.warehouse.RCWorkItemStorage;
import com.fudanmed.platform.core.warehouse.impl.RCOutStockRecordImpl;
import com.fudanmed.platform.core.warehouse.impl.RCProductWarehouseStorageSummaryImpl;
import com.fudanmed.platform.core.warehouse.impl.RCStockTakingRecordImpl;
import com.fudanmed.platform.core.warehouse.impl.RCTransferRecordImpl;
import com.fudanmed.platform.core.warehouse.impl.RCWorkItemOutStockRecordImpl;
import com.fudanmed.platform.core.warehouse.impl.RCWorkItemReturnStockRecordImpl;
import edu.fudan.mylang.common.ObjectExtensions2;
import edu.fudan.mylang.pf.BaseService;
import edu.fudan.mylang.pf.IGenericQuery;
import java.util.Collection;
import java.util.HashMap;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.warehouse.RCWarehouseService")
public class RCWarehouseServiceImpl extends BaseService implements RCWarehouseService {
  @Autowired
  private RCSequenceService sequenceService;
  
  public RCWarehouse getMajorWarehouse() {
    IGenericQuery<RCWarehouse> query=getObjectFactory().createGenericQuery(RCWarehouse.class,"select wh from com.fudanmed.platform.core.warehouse.impl.RCWarehouseImpl as wh   where (wh.isMajor = true) and  wh.active = 1      ");
    RCWarehouse _uniqueResult = query.uniqueResult();
    return _uniqueResult;
  }
  
  public Collection<RCWarehouse> getSubWarehouses() {
    IGenericQuery<RCWarehouse> query=getObjectFactory().createGenericQuery(RCWarehouse.class,"select wh from com.fudanmed.platform.core.warehouse.impl.RCWarehouseImpl as wh   where (wh.isMajor <> true) and  wh.active = 1      ");
    Collection<RCWarehouse> _list = query.list();
    return _list;
  }
  
  public RCProductWarehouseStorageSummary findOrCreateSummaryData(final RCWarehouse store, final RCProductSpecification productSpec) {
    IGenericQuery<RCProductWarehouseStorageSummary> query=getObjectFactory().createGenericQuery(RCProductWarehouseStorageSummary.class,"select s from com.fudanmed.platform.core.warehouse.impl.RCProductWarehouseStorageSummaryImpl as s   where ((s.productSpec = :productSpec) and (s.store = :store)) and  s.active = 1      ").setParameter("productSpec",productSpec).setParameter("store",store);
    RCProductWarehouseStorageSummary _uniqueResult = query.uniqueResult();
    final Function1<Void,RCProductWarehouseStorageSummary> _function = new Function1<Void,RCProductWarehouseStorageSummary>() {
        public RCProductWarehouseStorageSummary apply(final Void it) {RCProductWarehouseStorageSummary rCProductWarehouseStorageSummary=RCProductWarehouseStorageSummaryImpl.create(getObjectFactory());
          final Procedure1<RCProductWarehouseStorageSummary> _function = new Procedure1<RCProductWarehouseStorageSummary>() {
              public void apply(final RCProductWarehouseStorageSummary it) {
                it.setStore(store);
                it.setProductSpec(productSpec);
                it.setQuantity(Integer.valueOf(0));
                it.setAmount(Double.valueOf(0d));
              }
            };
          RCProductWarehouseStorageSummary _doubleArrow = ObjectExtensions.<RCProductWarehouseStorageSummary>operator_doubleArrow(rCProductWarehouseStorageSummary, _function);
          return _doubleArrow;
        }
      };
    RCProductWarehouseStorageSummary _withDefault = ObjectExtensions2.<RCProductWarehouseStorageSummary>withDefault(_uniqueResult, _function);
    return _withDefault;
  }
  
  public RCTransferRecord createTransferRecord(final Procedure1<? super RCTransferRecord> preinit) {RCTransferRecord rCTransferRecord=RCTransferRecordImpl.create(getObjectFactory());
    final Procedure1<RCTransferRecord> _function = new Procedure1<RCTransferRecord>() {
        public void apply(final RCTransferRecord it) {
          preinit.apply(it);
          String _nextTransferSequence = RCWarehouseServiceImpl.this.sequenceService.getNextTransferSequence();
          it.setSid(_nextTransferSequence);
        }
      };
    RCTransferRecord _doubleArrow = ObjectExtensions.<RCTransferRecord>operator_doubleArrow(rCTransferRecord, _function);
    return _doubleArrow;
  }
  
  public RCWorkItemOutStockRecord createWorkItemOutStockRecord(final Procedure1<? super RCWorkItemOutStockRecord> preinit) {RCWorkItemOutStockRecord rCWorkItemOutStockRecord=RCWorkItemOutStockRecordImpl.create(getObjectFactory());
    final Procedure1<RCWorkItemOutStockRecord> _function = new Procedure1<RCWorkItemOutStockRecord>() {
        public void apply(final RCWorkItemOutStockRecord it) {
          preinit.apply(it);
          String _nextWorkitemOutStockSequence = RCWarehouseServiceImpl.this.sequenceService.getNextWorkitemOutStockSequence();
          it.setSid(_nextWorkitemOutStockSequence);
        }
      };
    RCWorkItemOutStockRecord _doubleArrow = ObjectExtensions.<RCWorkItemOutStockRecord>operator_doubleArrow(rCWorkItemOutStockRecord, _function);
    return _doubleArrow;
  }
  
  public RCWorkItemReturnStockRecord createWorkItemReturnStockRecord(final Procedure1<? super RCWorkItemReturnStockRecord> preinit) {RCWorkItemReturnStockRecord rCWorkItemReturnStockRecord=RCWorkItemReturnStockRecordImpl.create(getObjectFactory());
    final Procedure1<RCWorkItemReturnStockRecord> _function = new Procedure1<RCWorkItemReturnStockRecord>() {
        public void apply(final RCWorkItemReturnStockRecord it) {
          preinit.apply(it);
          String _nextWorkitemReturnStockSequence = RCWarehouseServiceImpl.this.sequenceService.getNextWorkitemReturnStockSequence();
          it.setSid(_nextWorkitemReturnStockSequence);
        }
      };
    RCWorkItemReturnStockRecord _doubleArrow = ObjectExtensions.<RCWorkItemReturnStockRecord>operator_doubleArrow(rCWorkItemReturnStockRecord, _function);
    return _doubleArrow;
  }
  
  public RCOutStockRecord createOutStockRecord(final Procedure1<? super RCOutStockRecord> preinit) {RCOutStockRecord rCOutStockRecord=RCOutStockRecordImpl.create(getObjectFactory());
    final Procedure1<RCOutStockRecord> _function = new Procedure1<RCOutStockRecord>() {
        public void apply(final RCOutStockRecord it) {
          preinit.apply(it);
          String _nextOutStockSequence = RCWarehouseServiceImpl.this.sequenceService.getNextOutStockSequence();
          it.setSid(_nextOutStockSequence);
        }
      };
    RCOutStockRecord _doubleArrow = ObjectExtensions.<RCOutStockRecord>operator_doubleArrow(rCOutStockRecord, _function);
    return _doubleArrow;
  }
  
  public RCStockTakingRecord createStockTakingRecord(final Procedure1<? super RCStockTakingRecord> preinit) {RCStockTakingRecord rCStockTakingRecord=RCStockTakingRecordImpl.create(getObjectFactory());
    final Procedure1<RCStockTakingRecord> _function = new Procedure1<RCStockTakingRecord>() {
        public void apply(final RCStockTakingRecord it) {
          preinit.apply(it);
          String _nextStockTakingSequence = RCWarehouseServiceImpl.this.sequenceService.getNextStockTakingSequence();
          it.setSid(_nextStockTakingSequence);
        }
      };
    RCStockTakingRecord _doubleArrow = ObjectExtensions.<RCStockTakingRecord>operator_doubleArrow(rCStockTakingRecord, _function);
    return _doubleArrow;
  }
  
  public Collection<RCProductSpecificationSummary> getProductSpecificationSummary(final Collection<RCWorkItemStorage> workItemStorages) {
    Collection<RCProductSpecificationSummary> _xblockexpression = null;
    {
      final HashMap<RCProductSpecification,RCProductSpecificationSummary> result = CollectionLiterals.<RCProductSpecification, RCProductSpecificationSummary>newHashMap();
      final Procedure1<RCWorkItemStorage> _function = new Procedure1<RCWorkItemStorage>() {
          public void apply(final RCWorkItemStorage workItemStorage) {
            RCProductEntry _productEntry = workItemStorage.getProductEntry();
            RCProductSpecification _productSpec = _productEntry.getProductSpec();
            RCProductSpecificationSummary _get = result.get(_productSpec);
            final Function1<Void,RCProductSpecificationSummary> _function = new Function1<Void,RCProductSpecificationSummary>() {
                public RCProductSpecificationSummary apply(final Void it) {
                  RCProductSpecificationSummary _rCProductSpecificationSummary = new RCProductSpecificationSummary();
                  final Procedure1<RCProductSpecificationSummary> _function = new Procedure1<RCProductSpecificationSummary>() {
                      public void apply(final RCProductSpecificationSummary it) {
                        RCProductEntry _productEntry = workItemStorage.getProductEntry();
                        RCProductSpecification _productSpec = _productEntry.getProductSpec();
                        it.setProductSpec(_productSpec);
                        it.setQuantity(Integer.valueOf(0));
                      }
                    };
                  RCProductSpecificationSummary _doubleArrow = ObjectExtensions.<RCProductSpecificationSummary>operator_doubleArrow(_rCProductSpecificationSummary, _function);
                  final Procedure1<RCProductSpecificationSummary> _function_1 = new Procedure1<RCProductSpecificationSummary>() {
                      public void apply(final RCProductSpecificationSummary it) {
                        RCProductEntry _productEntry = workItemStorage.getProductEntry();
                        RCProductSpecification _productSpec = _productEntry.getProductSpec();
                        result.put(_productSpec, it);
                      }
                    };
                  RCProductSpecificationSummary _doubleArrow_1 = ObjectExtensions.<RCProductSpecificationSummary>operator_doubleArrow(_doubleArrow, _function_1);
                  return _doubleArrow_1;
                }
              };
            RCProductSpecificationSummary _withDefault = ObjectExtensions2.<RCProductSpecificationSummary>withDefault(_get, _function);
            final Procedure1<RCProductSpecificationSummary> _function_1 = new Procedure1<RCProductSpecificationSummary>() {
                public void apply(final RCProductSpecificationSummary it) {
                  Integer _quantity = it.getQuantity();
                  Integer _quantity_1 = workItemStorage.getQuantity();
                  int _plus = ((_quantity).intValue() + (_quantity_1).intValue());
                  it.setQuantity(Integer.valueOf(_plus));
                }
              };
            ObjectExtensions.<RCProductSpecificationSummary>operator_doubleArrow(_withDefault, _function_1);
          }
        };
      IterableExtensions.<RCWorkItemStorage>forEach(workItemStorages, _function);
      Collection<RCProductSpecificationSummary> _values = result.values();
      _xblockexpression = (_values);
    }
    return _xblockexpression;
  }
}
