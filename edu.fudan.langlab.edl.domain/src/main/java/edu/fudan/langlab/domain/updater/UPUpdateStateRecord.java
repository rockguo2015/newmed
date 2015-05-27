package edu.fudan.langlab.domain.updater;

import edu.fudan.langlab.domain.updater.impl.UPUpdateStateRecordImpl;
import edu.fudan.langlab.domain.updater.proxy.UPUpdateStateRecordProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import java.util.Date;

@EntityImplementation(implementBy = UPUpdateStateRecordImpl.class)
public interface UPUpdateStateRecord extends IModelObject {
  public abstract String getUpgrader();
  
  public abstract UPUpdateStateRecord setUpgrader(final String upgrader);
  
  public abstract String getFromVersionTag();
  
  public abstract UPUpdateStateRecord setFromVersionTag(final String fromVersionTag);
  
  public abstract String getUpdaterTag();
  
  public abstract UPUpdateStateRecord setUpdaterTag(final String updaterTag);
  
  public abstract Date getUpdateDate();
  
  public abstract UPUpdateStateRecord setUpdateDate(final Date updateDate);
  
  public abstract UPUpdateStateRecordProxy toProxy();
}
