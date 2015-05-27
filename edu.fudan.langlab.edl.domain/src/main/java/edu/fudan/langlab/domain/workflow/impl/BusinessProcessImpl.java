package edu.fudan.langlab.domain.workflow.impl;

import edu.fudan.langlab.domain.workflow.Activity;
import edu.fudan.langlab.domain.workflow.ActivityNodeDef;
import edu.fudan.langlab.domain.workflow.BusinessProcess;
import edu.fudan.langlab.domain.workflow.ProcessManager;
import edu.fudan.langlab.domain.workflow.Token;
import edu.fudan.langlab.domain.workflow.impl.ActivityImpl;
import edu.fudan.langlab.domain.workflow.impl.TokenImpl;
import edu.fudan.langlab.domain.workflow.proxy.BusinessProcessProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.hibernate.annotations.DiscriminatorOptions;
import org.springframework.beans.factory.BeanFactory;

@Entity
@DiscriminatorValue("BUSINESSPROCESS_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "businessprocess")
public abstract class BusinessProcessImpl extends BaseModelObject implements BusinessProcess {
  public BusinessProcessImpl() {
    super();
  }
  
  @OneToMany(targetEntity = ActivityImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "bp")
  private Collection<Activity> activities = new java.util.ArrayList<edu.fudan.langlab.domain.workflow.Activity>();;
  
  public Collection<Activity> getActivities() {
    return this.activities;
  }
  
  public Activity createAndAddtoActivities() {
    getActivities().size();
    edu.fudan.langlab.domain.workflow.Activity activity = new edu.fudan.langlab.domain.workflow.impl.ActivityImpl(this);
    getObjectFactory().create(activity);
    getActivities().add(activity);
    return activity;
    
  }
  
  public BusinessProcess removeAllActivities() {
    for(Activity obj : this.activities){
    	getObjectFactory().delete(obj);
    }
    this.activities.clear();
    return this;	
    
  }
  
  public BusinessProcess removeFromActivities(final Activity activity) {
    this.activities.remove(activity);
    getObjectFactory().delete(activity);
    return this;
    
  }
  
  @OneToMany(targetEntity = TokenImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "bp")
  private Collection<Token> tokens = new java.util.ArrayList<edu.fudan.langlab.domain.workflow.Token>();;
  
  public Collection<Token> getTokens() {
    return this.tokens;
  }
  
  public Token createAndAddtoTokens(final ActivityNodeDef targetActivity) {
    getTokens().size();
    edu.fudan.langlab.domain.workflow.Token token = new edu.fudan.langlab.domain.workflow.impl.TokenImpl(targetActivity,this);
    getObjectFactory().create(token);
    getTokens().add(token);
    return token;
    
  }
  
  public BusinessProcess removeAllTokens() {
    for(Token obj : this.tokens){
    	getObjectFactory().delete(obj);
    }
    this.tokens.clear();
    return this;	
    
  }
  
  public BusinessProcess removeFromTokens(final Token token) {
    this.tokens.remove(token);
    getObjectFactory().delete(token);
    return this;
    
  }
  
  private Boolean isFinished = Boolean.valueOf(false);
  
  public Boolean getIsFinished() {
    return this.isFinished;
  }
  
  public BusinessProcess setIsFinished(final Boolean isFinished) {
    this.isFinished = isFinished;
    return this;			
    
  }
  
  private Date startDate;
  
  public Date getStartDate() {
    return this.startDate;
  }
  
  public BusinessProcess setStartDate(final Date startDate) {
    this.startDate = startDate;
    return this;			
    
  }
  
  public ProcessManager getProcessManager() {
    BeanFactory _beanFactory = this.getBeanFactory();
    ProcessManager _bean = _beanFactory.<ProcessManager>getBean(ProcessManager.class);
    return _bean;
  }
  
  public String getProcessId() {
    Class<? extends Object> _class = this.getClass();
    String _string = _class.toString();
    String _plus = (_string + ".");
    Long _id = this.getId();
    String _plus_1 = (_plus + _id);
    return _plus_1;
  }
  
  public void finish() {
    this.isFinished = Boolean.valueOf(true);
    final Procedure1<Token> _function = new Procedure1<Token>() {
        public void apply(final Token it) {
          ProcessManager _processManager = BusinessProcessImpl.this.getProcessManager();
          _processManager.deleteToken(it);
        }
      };
    IterableExtensions.<Token>forEach(this.tokens, _function);
  }
  
  public void systemExecute() {
    boolean stateChanged = false;
    boolean _dowhile = false;
    do {
      {
        ProcessManager _processManager = this.getProcessManager();
        boolean _kenPresent = _processManager.tokenPresent(this, "__end__");
        if (_kenPresent) {
          this.finish();
          return;
        }
        boolean __systemExecute = this._systemExecute();
        stateChanged = __systemExecute;
      }
      _dowhile = stateChanged;
    } while(_dowhile);
  }
  
  public String getEntityName() {
    String _processName = this.getProcessName();
    return _processName;
  }
  
  public String getStatusSummary() {
    String _xifexpression = null;
    int _size = this.tokens.size();
    boolean _equals = (_size == 0);
    if (_equals) {
      _xifexpression = "\u6D41\u7A0B\u5DF2\u7ED3\u675F";
    } else {
      final Function1<Token,String> _function = new Function1<Token,String>() {
          public String apply(final Token it) {
            ActivityNodeDef _targetActivity = it.getTargetActivity();
            String _description = _targetActivity.getDescription();
            return _description;
          }
        };
      Iterable<String> _map = IterableExtensions.<Token, String>map(this.tokens, _function);
      String _join = IterableExtensions.join(_map, ",");
      _xifexpression = _join;
    }
    return _xifexpression;
  }
  
  public BusinessProcessProxy toProxy() {
    edu.fudan.langlab.domain.workflow.proxy.BusinessProcessProxy proxy = new edu.fudan.langlab.domain.workflow.proxy.BusinessProcessProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
