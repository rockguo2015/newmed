package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.domain.RCDirtyRecord;
import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.RCReporterDirtyRecord;
import com.fudanmed.platform.core.domain.RCTaskDirtyManager;
import com.fudanmed.platform.core.domain.impl.RCDirtyRecordImpl;
import com.fudanmed.platform.core.domain.impl.RCReporterDirtyRecordImpl;
import com.google.common.base.Objects;
import edu.fudan.mylang.pf.BaseService;
import edu.fudan.mylang.pf.IGenericQuery;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.domain.RCTaskDirtyManager")
public class RCTaskDirtyManagerImpl extends BaseService implements RCTaskDirtyManager {
  public RCDirtyRecord getDirtyRecord(final RCMaintenanceTeam team) {
    RCDirtyRecord _xblockexpression = null;
    {
      IGenericQuery<RCDirtyRecord> query=getObjectFactory().createGenericQuery(RCDirtyRecord.class,"select dr from com.fudanmed.platform.core.domain.impl.RCDirtyRecordImpl as dr   where (dr.team = :team) and  dr.active = 1      ").setParameter("team",team);
      RCDirtyRecord result = query.uniqueResult();
      boolean _equals = Objects.equal(result, null);
      if (_equals) {RCDirtyRecord rCDirtyRecord=RCDirtyRecordImpl.create(getObjectFactory());
        final Procedure1<RCDirtyRecord> _function = new Procedure1<RCDirtyRecord>() {
            public void apply(final RCDirtyRecord it) {
              it.setTeam(team);
              it.setIsDirty4Team(Boolean.valueOf(false));
              it.setIsDirty4Scheduler(Boolean.valueOf(false));
            }
          };
        RCDirtyRecord _doubleArrow = ObjectExtensions.<RCDirtyRecord>operator_doubleArrow(rCDirtyRecord, _function);
        result = _doubleArrow;
      }
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  public RCReporterDirtyRecord getReporterDirtyRecord() {
    RCReporterDirtyRecord _xblockexpression = null;
    {IGenericQuery<RCReporterDirtyRecord> query=getObjectFactory().createGenericQuery(RCReporterDirtyRecord.class,"select dr from com.fudanmed.platform.core.domain.impl.RCReporterDirtyRecordImpl as dr   where  dr.active = 1      ");
      RCReporterDirtyRecord result = query.uniqueResult();
      boolean _equals = Objects.equal(result, null);
      if (_equals) {RCReporterDirtyRecord rCReporterDirtyRecord=RCReporterDirtyRecordImpl.create(getObjectFactory());
        final Procedure1<RCReporterDirtyRecord> _function = new Procedure1<RCReporterDirtyRecord>() {
            public void apply(final RCReporterDirtyRecord it) {
              it.setIsDirty(Boolean.valueOf(false));
            }
          };
        RCReporterDirtyRecord _doubleArrow = ObjectExtensions.<RCReporterDirtyRecord>operator_doubleArrow(rCReporterDirtyRecord, _function);
        result = _doubleArrow;
      }
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  public Boolean checkDirty(final RCMaintenanceTeam team) {
    RCDirtyRecord _dirtyRecord = this.getDirtyRecord(team);
    Boolean _isDirty4Team = _dirtyRecord.getIsDirty4Team();
    return _isDirty4Team;
  }
  
  public void refreshed(final RCMaintenanceTeam team) {
    RCDirtyRecord _dirtyRecord = this.getDirtyRecord(team);
    _dirtyRecord.refreshed4Team();
  }
  
  public void notifyTeam(final RCMaintenanceTeam team) {
    RCDirtyRecord _dirtyRecord = this.getDirtyRecord(team);
    _dirtyRecord.notify4Team();
  }
  
  public void notifyScheduler(final RCMaintenanceTeam team) {
    RCDirtyRecord _dirtyRecord = this.getDirtyRecord(team);
    _dirtyRecord.notify4Scheduler();
  }
  
  public void notifyReported() {
    RCReporterDirtyRecord _reporterDirtyRecord = this.getReporterDirtyRecord();
    _reporterDirtyRecord.setIsDirty(Boolean.valueOf(true));
  }
  
  public Boolean checkDirty() {
    boolean _or = false;IGenericQuery<RCDirtyRecord> query=getObjectFactory().createGenericQuery(RCDirtyRecord.class,"select dr from com.fudanmed.platform.core.domain.impl.RCDirtyRecordImpl as dr   where  dr.active = 1      ");
    Collection<RCDirtyRecord> _list = query.list();
    final Function1<RCDirtyRecord,Boolean> _function = new Function1<RCDirtyRecord,Boolean>() {
        public Boolean apply(final RCDirtyRecord it) {
          Boolean _isDirty4Scheduler = it.getIsDirty4Scheduler();
          return _isDirty4Scheduler;
        }
      };
    boolean _exists = IterableExtensions.<RCDirtyRecord>exists(_list, _function);
    if (_exists) {
      _or = true;
    } else {
      RCReporterDirtyRecord _reporterDirtyRecord = this.getReporterDirtyRecord();
      Boolean _isDirty = _reporterDirtyRecord.getIsDirty();
      _or = (_exists || (_isDirty).booleanValue());
    }
    return Boolean.valueOf(_or);
  }
  
  public void refreshed() {IGenericQuery<RCDirtyRecord> query=getObjectFactory().createGenericQuery(RCDirtyRecord.class,"select dr from com.fudanmed.platform.core.domain.impl.RCDirtyRecordImpl as dr   where  dr.active = 1      ");
    Collection<RCDirtyRecord> _list = query.list();
    final Procedure1<RCDirtyRecord> _function = new Procedure1<RCDirtyRecord>() {
        public void apply(final RCDirtyRecord it) {
          it.refreshed4Scheduler();
        }
      };
    IterableExtensions.<RCDirtyRecord>forEach(_list, _function);
    RCReporterDirtyRecord _reporterDirtyRecord = this.getReporterDirtyRecord();
    _reporterDirtyRecord.setIsDirty(Boolean.valueOf(false));
  }
}
