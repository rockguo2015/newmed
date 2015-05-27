package edu.fudan.langlab.domain.task.proxy;

import edu.fudan.langlab.domain.task.proxy.TaskProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("edu.fudan.langlab.domain.task.NormalTask")
public class NormalTaskProxy extends TaskProxy {
  public NormalTaskProxy() {
    this.setClazzName("edu.fudan.langlab.domain.task.NormalTask");
  }
}
