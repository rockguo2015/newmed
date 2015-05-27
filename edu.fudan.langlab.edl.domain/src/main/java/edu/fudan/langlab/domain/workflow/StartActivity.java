package edu.fudan.langlab.domain.workflow;

import edu.fudan.langlab.domain.workflow.Activity;
import edu.fudan.langlab.domain.workflow.impl.StartActivityImpl;
import edu.fudan.langlab.domain.workflow.proxy.StartActivityProxy;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = StartActivityImpl.class)
public interface StartActivity extends Activity {
  public abstract String description();
  
  public abstract void doFinish();
  
  public abstract StartActivityProxy toProxy();
}
