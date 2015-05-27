package edu.fudan.langlab.domain.workflow;

import com.google.gwt.user.client.rpc.IsSerializable;
import edu.fudan.langlab.domain.workflow.BusinessProcess;

public interface IHasProcess extends IsSerializable {
  public abstract BusinessProcess getProcess();
  
  public abstract Object toProxy();
}
