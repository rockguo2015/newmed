package edu.fudan.langlab.domain.security.impl;

import com.google.common.base.Objects;
import edu.fudan.langlab.domain.security.AppFunction;
import edu.fudan.langlab.domain.security.proxy.AppFunctionProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IGenericQuery;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("APPFUNCTION_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "appfunction")
public class AppFunctionImpl extends BaseModelObject implements AppFunction {
  public AppFunctionImpl() {
    super();
  }
  
  private String parentFunctionId;
  
  public String getParentFunctionId() {
    return this.parentFunctionId;
  }
  
  public AppFunction setParentFunctionId(final String parentFunctionId) {
    this.parentFunctionId = parentFunctionId;
    return this;			
    
  }
  
  private String functionId;
  
  public String getFunctionId() {
    return this.functionId;
  }
  
  public AppFunction setFunctionId(final String functionId) {
    this.functionId = functionId;
    return this;			
    
  }
  
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public AppFunction setName(final String name) {
    this.name = name;
    return this;			
    
  }
  
  public AppFunction getParent() {
    IGenericQuery<AppFunction> query=getObjectFactory().createGenericQuery(AppFunction.class,"select f from edu.fudan.langlab.domain.security.impl.AppFunctionImpl as f   where (f.functionId = :parentFunctionId) and  f.active = 1      ").setParameter("parentFunctionId",parentFunctionId);
    AppFunction _uniqueResult = query.uniqueResult();
    return _uniqueResult;
  }
  
  public Collection<AppFunction> getFunctionsFromPath() {
    ArrayList<AppFunction> _xblockexpression = null;
    {
      final ArrayList<AppFunction> result = CollectionLiterals.<AppFunction>newArrayList();
      AppFunction curFunction = this;
      boolean _notEquals = (!Objects.equal(curFunction, null));
      boolean _while = _notEquals;
      while (_while) {
        {
          result.add(curFunction);
          AppFunction _parent = curFunction.getParent();
          curFunction = _parent;
        }
        boolean _notEquals_1 = (!Objects.equal(curFunction, null));
        _while = _notEquals_1;
      }
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  public Collection<AppFunction> getSubFunctions() {
    ArrayList<AppFunction> _newArrayList = CollectionLiterals.<AppFunction>newArrayList();
    Collection<AppFunction> _collectSubFunctions = this.collectSubFunctions(_newArrayList);
    return _collectSubFunctions;
  }
  
  public Collection<AppFunction> collectSubFunctions(final Collection<AppFunction> result) {
    Collection<AppFunction> _xblockexpression = null;
    {
      IGenericQuery<AppFunction> query=getObjectFactory().createGenericQuery(AppFunction.class,"select f from edu.fudan.langlab.domain.security.impl.AppFunctionImpl as f   where (f.parentFunctionId = :functionId) and  f.active = 1      ").setParameter("functionId",functionId);
      final Collection<AppFunction> directChildren = query.list();
      result.addAll(directChildren);
      final Procedure1<AppFunction> _function = new Procedure1<AppFunction>() {
          public void apply(final AppFunction it) {
            it.collectSubFunctions(result);
          }
        };
      IterableExtensions.<AppFunction>forEach(directChildren, _function);
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  public String getEntityName() {
    return this.name;
  }
  
  public static AppFunction create(final IObjectFactory objectFactory) {
    edu.fudan.langlab.domain.security.AppFunction appFunction = new edu.fudan.langlab.domain.security.impl.AppFunctionImpl(
    );
    objectFactory.create(appFunction);
    return appFunction;			
    
  }
  
  public AppFunctionProxy toProxy() {
    edu.fudan.langlab.domain.security.proxy.AppFunctionProxy proxy = new edu.fudan.langlab.domain.security.proxy.AppFunctionProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
