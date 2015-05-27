package edu.fudan.langlab.domain.workflow.proxy;

import edu.fudan.langlab.domain.task.proxy.TaskProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("edu.fudan.langlab.domain.workflow.ProcessTask")
public class ProcessTaskProxy extends TaskProxy {
  public ProcessTaskProxy() {
    this.setClazzName("edu.fudan.langlab.domain.workflow.ProcessTask");
  }
}
