package edu.fudan.langlab.domain.task.proxy;

import com.uniquesoft.gwt.shared.GWTNamedEntity;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("edu.fudan.langlab.domain.task.Task")
public class TaskProxy extends GWTNamedEntity {
  public TaskProxy() {
    this.setClazzName("edu.fudan.langlab.domain.task.Task");
  }
}
