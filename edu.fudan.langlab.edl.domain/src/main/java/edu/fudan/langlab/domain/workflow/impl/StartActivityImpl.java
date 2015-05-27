package edu.fudan.langlab.domain.workflow.impl;

import edu.fudan.langlab.domain.workflow.BusinessProcess;
import edu.fudan.langlab.domain.workflow.StartActivity;
import edu.fudan.langlab.domain.workflow.impl.ActivityImpl;
import edu.fudan.langlab.domain.workflow.proxy.StartActivityProxy;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("STARTACTIVITY_TYPE")
public class StartActivityImpl extends ActivityImpl implements StartActivity {
  public StartActivityImpl() {
    super();
  }
  
  public StartActivityImpl(final BusinessProcess bp) {
    super( bp);
    
  }
  
  public String description() {
    BusinessProcess _bp = this.getBp();
    String _processName = _bp.getProcessName();
    String _plus = ("\u542F\u52A8\u6D41\u7A0B:" + _processName);
    return _plus;
  }
  
  public void doFinish() {
  }
  
  public static StartActivity create(final BusinessProcess bp, final IObjectFactory objectFactory) {
    edu.fudan.langlab.domain.workflow.StartActivity startActivity = new edu.fudan.langlab.domain.workflow.impl.StartActivityImpl(
    	bp
    );
    objectFactory.create(startActivity);
    return startActivity;			
    
  }
  
  public StartActivityProxy toProxy() {
    edu.fudan.langlab.domain.workflow.proxy.StartActivityProxy proxy = new edu.fudan.langlab.domain.workflow.proxy.StartActivityProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
