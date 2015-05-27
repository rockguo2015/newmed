package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.warehouse.RCProductSummarySnapshot;
import com.fudanmed.platform.core.warehouse.RCProductSummarySnapshotDAO;
import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageSummary;
import com.fudanmed.platform.core.warehouse.impl.RCProductSummarySnapshotImpl;
import com.google.common.base.Objects;
import edu.fudan.mylang.pf.BaseDAOService;
import edu.fudan.mylang.pf.IGenericQuery;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.warehouse.RCProductSummarySnapshotDAO")
public class RCProductSummarySnapshotDAOImpl extends BaseDAOService<RCProductSummarySnapshot> implements RCProductSummarySnapshotDAO {
  public RCProductSummarySnapshot createOrFindSnapshot(final Date date, final RCProductWarehouseStorageSummary storageSummary, final Procedure1<? super RCProductSummarySnapshot> init) {
    RCProductSummarySnapshot _xblockexpression = null;
    {
      final RCProductSummarySnapshot lastSnapshot = this.findLastSnapshot(date, storageSummary);
      IGenericQuery<RCProductSummarySnapshot> query=getObjectFactory().createGenericQuery(RCProductSummarySnapshot.class,"select e from com.fudanmed.platform.core.warehouse.impl.RCProductSummarySnapshotImpl as e   where ((e.storageSummary = :storageSummary) and (e.date = :date)) and  e.active = 1      ").setParameter("storageSummary",storageSummary).setParameter("date",date);
      RCProductSummarySnapshot result = query.uniqueResult();
      boolean _equals = Objects.equal(result, null);
      if (_equals) {RCProductSummarySnapshot rCProductSummarySnapshot=RCProductSummarySnapshotImpl.create(getObjectFactory());
        final Procedure1<RCProductSummarySnapshot> _function = new Procedure1<RCProductSummarySnapshot>() {
            public void apply(final RCProductSummarySnapshot it) {
              it.setStorageSummary(storageSummary);
              it.setDate(date);
              Integer _quantity = lastSnapshot.getQuantity();
              it.setQuantity(_quantity);
              Double _amount = lastSnapshot.getAmount();
              it.setAmount(_amount);
            }
          };
        RCProductSummarySnapshot _doubleArrow = ObjectExtensions.<RCProductSummarySnapshot>operator_doubleArrow(rCProductSummarySnapshot, _function);
        result = _doubleArrow;
      }
      init.apply(result);
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  public RCProductSummarySnapshot findLastSnapshot(final Date date, final RCProductWarehouseStorageSummary storageSummary) {
    RCProductSummarySnapshot _xblockexpression = null;
    {
      IGenericQuery<RCProductSummarySnapshot> query=getObjectFactory().createGenericQuery(RCProductSummarySnapshot.class,"select e from com.fudanmed.platform.core.warehouse.impl.RCProductSummarySnapshotImpl as e   where ((e.storageSummary = :storageSummary) and (e.date < :date)) and  e.active = 1  order by e.date DESC    ").setParameter("storageSummary",storageSummary).setParameter("date",date);
      IGenericQuery<RCProductSummarySnapshot> _setMaxResults = query.setMaxResults(1);
      RCProductSummarySnapshot result = _setMaxResults.uniqueResult();
      RCProductSummarySnapshot _xifexpression = null;
      boolean _equals = Objects.equal(result, null);
      if (_equals) {
        RCProductSummarySnapshotImpl _rCProductSummarySnapshotImpl = new RCProductSummarySnapshotImpl();
        final Procedure1<RCProductSummarySnapshotImpl> _function = new Procedure1<RCProductSummarySnapshotImpl>() {
            public void apply(final RCProductSummarySnapshotImpl it) {
              it.setQuantity(Integer.valueOf(0));
              it.setAmount(Double.valueOf(0d));
            }
          };
        RCProductSummarySnapshotImpl _doubleArrow = ObjectExtensions.<RCProductSummarySnapshotImpl>operator_doubleArrow(_rCProductSummarySnapshotImpl, _function);
        _xifexpression = _doubleArrow;
      } else {
        _xifexpression = result;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
}
