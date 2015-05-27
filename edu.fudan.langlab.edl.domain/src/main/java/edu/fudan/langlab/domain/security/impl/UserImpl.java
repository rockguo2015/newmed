package edu.fudan.langlab.domain.security.impl;

import edu.fudan.langlab.domain.security.User;
import edu.fudan.langlab.domain.security.proxy.UserProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("USER_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "user")
public class UserImpl extends BaseModelObject implements User {
  public UserImpl() {
    super();
  }
  
  private String userid;
  
  public String getUserid() {
    return this.userid;
  }
  
  public User setUserid(final String userid) {
    this.userid = userid;
    return this;			
    
  }
  
  private String passwd;
  
  public String getPasswd() {
    return this.passwd;
  }
  
  public User setPasswd(final String passwd) {
    this.passwd = passwd;
    return this;			
    
  }
  
  public String getEntityName() {
    return this.userid;
  }
  
  public static User create(final IObjectFactory objectFactory) {
    edu.fudan.langlab.domain.security.User user = new edu.fudan.langlab.domain.security.impl.UserImpl(
    );
    objectFactory.create(user);
    return user;			
    
  }
  
  public UserProxy toProxy() {
    edu.fudan.langlab.domain.security.proxy.UserProxy proxy = new edu.fudan.langlab.domain.security.proxy.UserProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
