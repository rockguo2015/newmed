package edu.fudan.langlab.domain.updater.impl;

import com.google.common.base.Objects;
import edu.fudan.langlab.domain.updater.UPSystemUpdateStatus;
import edu.fudan.langlab.domain.updater.UPUpdateStateRecord;
import edu.fudan.langlab.domain.updater.UpdateServie;
import edu.fudan.langlab.domain.updater.impl.UPSystemUpdateStatusImpl;
import edu.fudan.langlab.domain.updater.impl.UPUpdateStateRecordImpl;
import edu.fudan.mylang.common.ObjectExtensions2;
import edu.fudan.mylang.pf.BaseService;
import edu.fudan.mylang.pf.IGenericQuery;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.stereotype.Service;

@Service("edu.fudan.langlab.domain.updater.UpdateServie")
public class UpdateServieImpl extends BaseService implements UpdateServie {
  public UPSystemUpdateStatus getSystemUpdateStatus() {IGenericQuery<UPSystemUpdateStatus> query=getObjectFactory().createGenericQuery(UPSystemUpdateStatus.class,"select s from edu.fudan.langlab.domain.updater.impl.UPSystemUpdateStatusImpl as s   where  s.active = 1      ");
    UPSystemUpdateStatus _uniqueResult = query.uniqueResult();
    final Function1<Void,UPSystemUpdateStatus> _function = new Function1<Void,UPSystemUpdateStatus>() {
        public UPSystemUpdateStatus apply(final Void it) {UPSystemUpdateStatus uPSystemUpdateStatus=UPSystemUpdateStatusImpl.create(getObjectFactory());
          final Procedure1<UPSystemUpdateStatus> _function = new Procedure1<UPSystemUpdateStatus>() {
              public void apply(final UPSystemUpdateStatus it) {
                it.setCurVersion("V_0_0");
              }
            };
          UPSystemUpdateStatus _doubleArrow = ObjectExtensions.<UPSystemUpdateStatus>operator_doubleArrow(uPSystemUpdateStatus, _function);
          return _doubleArrow;
        }
      };
    UPSystemUpdateStatus _withDefault = ObjectExtensions2.<UPSystemUpdateStatus>withDefault(_uniqueResult, _function);
    return _withDefault;
  }
  
  public Boolean canPerformUpdate(final String upgrader, final String fromVersion, final String updaterTag) {
    boolean _xblockexpression = false;
    {
      UPSystemUpdateStatus _systemUpdateStatus = this.getSystemUpdateStatus();
      final String curVersion = _systemUpdateStatus.getCurVersion();
      boolean _equals = curVersion.equals(fromVersion);
      boolean _not = (!_equals);
      if (_not) {
        return Boolean.valueOf(false);
      }
      IGenericQuery<UPUpdateStateRecord> query=getObjectFactory().createGenericQuery(UPUpdateStateRecord.class,"select u from edu.fudan.langlab.domain.updater.impl.UPUpdateStateRecordImpl as u   where (((u.upgrader = :upgrader) and (u.fromVersionTag = :fromVersion)) and (u.updaterTag = :updaterTag)) and  u.active = 1      ").setParameter("upgrader",upgrader).setParameter("fromVersion",fromVersion).setParameter("updaterTag",updaterTag);
      UPUpdateStateRecord _uniqueResult = query.uniqueResult();
      final boolean result = Objects.equal(_uniqueResult, null);
      String _plus = ("check update " + upgrader);
      String _plus_1 = (_plus + ".");
      String _plus_2 = (_plus_1 + updaterTag);
      String _plus_3 = (_plus_2 + ":");
      String _plus_4 = (_plus_3 + Boolean.valueOf(result));
      InputOutput.<String>println(_plus_4);
      _xblockexpression = (result);
    }
    return Boolean.valueOf(_xblockexpression);
  }
  
  public void updaterCommited(final String upgrader, final String fromVersion, final String updaterTag) {UPUpdateStateRecord uPUpdateStateRecord=UPUpdateStateRecordImpl.create(getObjectFactory());
    final Procedure1<UPUpdateStateRecord> _function = new Procedure1<UPUpdateStateRecord>() {
        public void apply(final UPUpdateStateRecord it) {
          it.setUpgrader(upgrader);
          it.setFromVersionTag(fromVersion);
          it.setUpdaterTag(updaterTag);
          Date _date = new Date();
          it.setUpdateDate(_date);
        }
      };
    ObjectExtensions.<UPUpdateStateRecord>operator_doubleArrow(uPUpdateStateRecord, _function);
  }
  
  public void upgraderCommited(final String fromVersion, final String toVersion) {
    UPSystemUpdateStatus _systemUpdateStatus = this.getSystemUpdateStatus();
    final Procedure1<UPSystemUpdateStatus> _function = new Procedure1<UPSystemUpdateStatus>() {
        public void apply(final UPSystemUpdateStatus it) {
          String _curVersion = it.getCurVersion();
          boolean _equals = Objects.equal(_curVersion, fromVersion);
          if (_equals) {
            it.setCurVersion(toVersion);
          }
        }
      };
    ObjectExtensions.<UPSystemUpdateStatus>operator_doubleArrow(_systemUpdateStatus, _function);
  }
}
