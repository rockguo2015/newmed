package edu.fudan.langlab.domain.workflow.impl;

import edu.fudan.langlab.domain.workflow.ActivityNodeDef;
import edu.fudan.langlab.domain.workflow.BusinessProcess;
import edu.fudan.langlab.domain.workflow.ForkStatus;
import edu.fudan.langlab.domain.workflow.ProcessTask;
import edu.fudan.langlab.domain.workflow.Token;
import edu.fudan.langlab.domain.workflow.impl.BusinessProcessImpl;
import edu.fudan.langlab.domain.workflow.impl.ForkStatusImpl;
import edu.fudan.langlab.domain.workflow.proxy.TokenProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IGenericQuery;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import java.util.List;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("TOKEN_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "token")
public class TokenImpl extends BaseModelObject implements Token {
  public TokenImpl() {
    super();
  }
  
  public TokenImpl(final ActivityNodeDef targetActivity, final BusinessProcess bp) {
    super();
    this.targetActivity = targetActivity;;
    this.bp = bp;
  }
  
  @JoinColumn(name = "bp_id")
  @ManyToOne(targetEntity = BusinessProcessImpl.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private BusinessProcess bp;
  
  public BusinessProcess getBp() {
    return this.bp;
  }
  
  public Token setBp(final BusinessProcess bp) {
    this.bp = bp;
    return this;			
    
  }
  
  @Embedded
  @AttributeOverrides(value = { @AttributeOverride(name = "activityId", column = @Column(name = "targetActivity_activityId") ), @AttributeOverride(name = "description", column = @Column(name = "targetActivity_description") ), @AttributeOverride(name = "workaround", column = @Column(name = "targetActivity_workaround") ) } )
  @AssociationOverrides(value = { } )
  private ActivityNodeDef targetActivity = edu.fudan.langlab.domain.workflow.ActivityNodeDef.create();
  
  public ActivityNodeDef getTargetActivity() {
    return this.targetActivity;
  }
  
  public Token setTargetActivity(final ActivityNodeDef targetActivity) {
    this.targetActivity = targetActivity;
    return this;			
    
  }
  
  @ManyToMany(targetEntity = ForkStatusImpl.class)
  @JoinTable(name = "m2m_token_forkjoinpoints", joinColumns = @JoinColumn(name = "token_id") , inverseJoinColumns = @JoinColumn(name = "forkStatus_inv_id") )
  private Collection<ForkStatus> forkJoinPoints = new java.util.ArrayList<edu.fudan.langlab.domain.workflow.ForkStatus>();;
  
  public Collection<ForkStatus> getForkJoinPoints() {
    return this.forkJoinPoints;
  }
  
  public Token setForkJoinPoints(final Iterable<ForkStatus> forkJoinPoints) {
    removeAllForkJoinPoints();
    for(ForkStatus ca : forkJoinPoints){
    	addtoForkJoinPoints(ca);
    }
    return this;		
    
  }
  
  public Token addtoForkJoinPoints(final ForkStatus forkStatus) {
    this.forkJoinPoints.add(forkStatus);
    return this;
    
  }
  
  public Token removeAllForkJoinPoints() {
    this.forkJoinPoints.clear();
    return this;	
    
  }
  
  public Token removeFromForkJoinPoints(final ForkStatus forkStatus) {
    this.forkJoinPoints.remove(forkStatus);
    return this;
    
  }
  
  @ElementCollection
  private Collection<String> decisionMergePoints = new java.util.ArrayList<java.lang.String>();;
  
  public Collection<String> getDecisionMergePoints() {
    return this.decisionMergePoints;
  }
  
  public Token setDecisionMergePoints(final Iterable<String> decisionMergePoints) {
    removeAllDecisionMergePoints();
    for(String ca : decisionMergePoints){
    	addtoDecisionMergePoints(ca);
    }
    return this;		
    
  }
  
  public Token addtoDecisionMergePoints(final String string) {
    this.decisionMergePoints.add(string);
    return this;
    
  }
  
  public Token removeAllDecisionMergePoints() {
    this.decisionMergePoints.clear();
    return this;	
    
  }
  
  public Token removeFromDecisionMergePoints(final String string) {
    this.decisionMergePoints.remove(string);
    return this;
    
  }
  
  public ProcessTask getProcessTask() {
    IGenericQuery<ProcessTask> query=getObjectFactory().createGenericQuery(ProcessTask.class,"select pt from edu.fudan.langlab.domain.workflow.impl.ProcessTaskImpl as pt   where (pt.token = :this) and  pt.active = 1      ").setParameter("this",this);
    ProcessTask _uniqueResult = query.uniqueResult();
    return _uniqueResult;
  }
  
  public void pushMergePoint(final String activityId) {
    this.decisionMergePoints.add(activityId);
    /*TokenImpl;*/
  }
  
  public String popMergePoint() {
    String _xblockexpression = null;
    {
      int _size = this.decisionMergePoints.size();
      int _minus = (_size - 1);
      String result = ((List<String>) this.decisionMergePoints).get(_minus);
      int _size_1 = this.decisionMergePoints.size();
      int _minus_1 = (_size_1 - 1);
      this.decisionMergePoints.remove(Integer.valueOf(_minus_1));
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  public ForkStatus peekForkPoint() {
    int _size = this.forkJoinPoints.size();
    int _minus = (_size - 1);
    ForkStatus _get = ((List<ForkStatus>) this.forkJoinPoints).get(_minus);
    return _get;
  }
  
  public ForkStatus popForkPoint() {
    ForkStatus _xblockexpression = null;
    {
      int _size = this.forkJoinPoints.size();
      int _minus = (_size - 1);
      ForkStatus result = ((List<ForkStatus>) this.forkJoinPoints).get(_minus);
      this.forkJoinPoints.remove(result);getObjectFactory().delete(result);
      
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  public ForkStatus pushForkPoint(final String joinPoint) {
    ForkStatus _xblockexpression = null;
    {ForkStatus forkStatus=ForkStatusImpl.create(joinPoint,getObjectFactory());
      ForkStatus result = forkStatus;
      this.forkJoinPoints.add(result);
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  public Token cloneWith(final String newActivityId) {
    ActivityNodeDef _activityDef = this.bp.getActivityDef(newActivityId);Token token=TokenImpl.create(_activityDef,this.bp,getObjectFactory());
    final Procedure1<Token> _function = new Procedure1<Token>() {
        public void apply(final Token newToken) {
          final Procedure1<ForkStatus> _function = new Procedure1<ForkStatus>() {
              public void apply(final ForkStatus it) {
                Collection<ForkStatus> _forkJoinPoints = newToken.getForkJoinPoints();
                _forkJoinPoints.add(it);
              }
            };
          IterableExtensions.<ForkStatus>forEach(TokenImpl.this.forkJoinPoints, _function);
          final Procedure1<String> _function_1 = new Procedure1<String>() {
              public void apply(final String it) {
                Collection<String> _decisionMergePoints = newToken.getDecisionMergePoints();
                _decisionMergePoints.add(it);
              }
            };
          IterableExtensions.<String>forEach(TokenImpl.this.decisionMergePoints, _function_1);
        }
      };
    Token _doubleArrow = ObjectExtensions.<Token>operator_doubleArrow(token, _function);
    return _doubleArrow;
  }
  
  public static Token create(final ActivityNodeDef targetActivity, final BusinessProcess bp, final IObjectFactory objectFactory) {
    edu.fudan.langlab.domain.workflow.Token token = new edu.fudan.langlab.domain.workflow.impl.TokenImpl(
    	targetActivity,bp
    );
    objectFactory.create(token);
    return token;			
    
  }
  
  public TokenProxy toProxy() {
    edu.fudan.langlab.domain.workflow.proxy.TokenProxy proxy = new edu.fudan.langlab.domain.workflow.proxy.TokenProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
