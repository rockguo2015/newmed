package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductSummarySnapshot;
import com.fudanmed.platform.core.warehouse.RCProductSummarySnapshotCriteria;
import com.fudanmed.platform.core.warehouse.RCProductSummarySnapshotDAO;
import com.fudanmed.platform.core.warehouse.RCProductSummarySnapshotStatCriteria;
import com.fudanmed.platform.core.warehouse.RCProductSummarySnapshotStatCriteriaData;
import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageSummary;
import com.fudanmed.platform.core.warehouse.proxy.RCProductWarehouseStorageSummaryProxy;
import com.fudanmed.platform.core.web.client.warehouse.ProductSummarySnapshotQueryListPresenterService;
import com.fudanmed.platform.core.web.server.service.warehouse.ProductSummarySnapshotCriteriaMapper;
import com.fudanmed.platform.core.web.server.service.warehouse.ProductSummarySnapshotStatCriteriaDataMapper;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSummarySnapshotCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSummarySnapshotStatCriteriaData;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.uniquesoft.gwt.server.common.pager.PagedQueries;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.DateUtil;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.warehouse.ProductSummarySnapshotQueryListPresenterService")
@Transactional
public class ProductSummarySnapshotQueryListPresenterServiceImpl extends BaseService implements ProductSummarySnapshotQueryListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProductSummarySnapshotCriteriaMapper criteriaMapper;
  
  @Autowired
  private ProductSummarySnapshotStatCriteriaDataMapper mapper;
  
  @Autowired
  private RCProductSummarySnapshotDAO dao;
  
  public IPagedResult<UIProductSummarySnapshotStatCriteriaData> filter(final UIProductSummarySnapshotCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    IPagedResult<UIProductSummarySnapshotStatCriteriaData> _xblockexpression = null;
    {
      RCProductSummarySnapshotCriteria c = PagedQueries.createPagedCriteria(uicriteria, RCProductSummarySnapshotCriteria.class, this.criteriaMapper, this.entities);
      RCProductSummarySnapshotStatCriteria _createStatCriteria = c.createStatCriteria(RCProductSummarySnapshotStatCriteria.class);
      final Function1<RCProductSummarySnapshotStatCriteriaData,UIProductSummarySnapshotStatCriteriaData> _function = new Function1<RCProductSummarySnapshotStatCriteriaData,UIProductSummarySnapshotStatCriteriaData>() {
          public UIProductSummarySnapshotStatCriteriaData apply(final RCProductSummarySnapshotStatCriteriaData it) {
            UIProductSummarySnapshotStatCriteriaData _transform = ProductSummarySnapshotQueryListPresenterServiceImpl.this.mapper.transform(it);
            return _transform;
          }
        };
      IPagedResult<UIProductSummarySnapshotStatCriteriaData> _listAndTransform = PagedQueries.<UIProductSummarySnapshotStatCriteriaData, RCProductSummarySnapshotStatCriteriaData>listAndTransform(_createStatCriteria, new Function<RCProductSummarySnapshotStatCriteriaData,UIProductSummarySnapshotStatCriteriaData>() {
          public UIProductSummarySnapshotStatCriteriaData apply(RCProductSummarySnapshotStatCriteriaData input) {
            return _function.apply(input);
          }
      });
      final Procedure1<IPagedResult<UIProductSummarySnapshotStatCriteriaData>> _function_1 = new Procedure1<IPagedResult<UIProductSummarySnapshotStatCriteriaData>>() {
          public void apply(final IPagedResult<UIProductSummarySnapshotStatCriteriaData> it) {
            final Procedure1<UIProductSummarySnapshotStatCriteriaData> _function = new Procedure1<UIProductSummarySnapshotStatCriteriaData>() {
                public void apply(final UIProductSummarySnapshotStatCriteriaData item) {
                  Date _dateFrom = uicriteria.getDateFrom();
                  boolean _notEquals = (!Objects.equal(_dateFrom, null));
                  if (_notEquals) {
                    Date _dateFrom_1 = uicriteria.getDateFrom();
                    RCProductWarehouseStorageSummaryProxy _storageSummary = item.getStorageSummary();
                    RCProductWarehouseStorageSummary _resolved= null;
                    if(_storageSummary!=null) _resolved=(com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageSummary)com.uniquesoft.uidl.extensions.ModelObjects.resolve(_storageSummary, entities);
                    
                    RCProductSummarySnapshot _findLastSnapshot = ProductSummarySnapshotQueryListPresenterServiceImpl.this.dao.findLastSnapshot(_dateFrom_1,  _resolved);
                    final Procedure1<RCProductSummarySnapshot> _function = new Procedure1<RCProductSummarySnapshot>() {
                        public void apply(final RCProductSummarySnapshot it) {
                          Integer _quantity = it.getQuantity();
                          long _longValue = _quantity.longValue();
                          item.setStartQuantity(Long.valueOf(_longValue));
                          Double _amount = it.getAmount();
                          item.setStartAmount(_amount);
                        }
                      };
                    ObjectExtensions.<RCProductSummarySnapshot>operator_doubleArrow(_findLastSnapshot, _function);
                  } else {
                    item.setStartQuantity(Long.valueOf(0l));
                    item.setStartAmount(Double.valueOf(0d));
                  }
                  Date _xifexpression = null;
                  Date _dateTo = uicriteria.getDateTo();
                  boolean _notEquals_1 = (!Objects.equal(_dateTo, null));
                  if (_notEquals_1) {
                    Date _dateTo_1 = uicriteria.getDateTo();
                    _xifexpression = _dateTo_1;
                  } else {
                    Date _day = DateUtil.today();
                    _xifexpression = _day;
                  }
                  final Date finishDate = _xifexpression;
                  Date _addDays = DateUtil.addDays(finishDate, 1);
                  RCProductWarehouseStorageSummaryProxy _storageSummary_1 = item.getStorageSummary();
                  RCProductWarehouseStorageSummary _resolved_1= null;
                  if(_storageSummary_1!=null) _resolved_1=(com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageSummary)com.uniquesoft.uidl.extensions.ModelObjects.resolve(_storageSummary_1, entities);
                  
                  RCProductSummarySnapshot _findLastSnapshot_1 = ProductSummarySnapshotQueryListPresenterServiceImpl.this.dao.findLastSnapshot(_addDays,  _resolved_1);
                  final Procedure1<RCProductSummarySnapshot> _function_1 = new Procedure1<RCProductSummarySnapshot>() {
                      public void apply(final RCProductSummarySnapshot it) {
                        Integer _quantity = it.getQuantity();
                        long _longValue = _quantity.longValue();
                        item.setFinishQuantity(Long.valueOf(_longValue));
                        Double _amount = it.getAmount();
                        item.setFinishAmount(_amount);
                      }
                    };
                  ObjectExtensions.<RCProductSummarySnapshot>operator_doubleArrow(_findLastSnapshot_1, _function_1);
                }
              };
            IterableExtensions.<UIProductSummarySnapshotStatCriteriaData>forEach(it, _function);
          }
        };
      IPagedResult<UIProductSummarySnapshotStatCriteriaData> _doubleArrow = ObjectExtensions.<IPagedResult<UIProductSummarySnapshotStatCriteriaData>>operator_doubleArrow(_listAndTransform, _function_1);
      _xblockexpression = (_doubleArrow);
    }
    return _xblockexpression;
  }
}
