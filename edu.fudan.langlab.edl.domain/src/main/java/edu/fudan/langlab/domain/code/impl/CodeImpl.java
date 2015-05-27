package edu.fudan.langlab.domain.code.impl;

import edu.fudan.langlab.domain.code.Code;
import edu.fudan.langlab.domain.code.proxy.CodeProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("CODE_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "code")
public class CodeImpl extends BaseModelObject implements Code {
  public CodeImpl() {
    super();
  }
  
  private String codeid;
  
  public String getCodeid() {
    return this.codeid;
  }
  
  public Code setCodeid(final String codeid) {
    this.codeid = codeid;
    return this;			
    
  }
  
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public Code setName(final String name) {
    this.name = name;
    return this;			
    
  }
  
  public String getEntityName() {
    return this.name;
  }
  
  public static Code create(final IObjectFactory objectFactory) {
    edu.fudan.langlab.domain.code.Code code = new edu.fudan.langlab.domain.code.impl.CodeImpl(
    );
    objectFactory.create(code);
    return code;			
    
  }
  
  public CodeProxy toProxy() {
    edu.fudan.langlab.domain.code.proxy.CodeProxy proxy = new edu.fudan.langlab.domain.code.proxy.CodeProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
