package edu.fudan.langlab.domain.organization.impl;

import edu.fudan.langlab.domain.organization.Party;
import edu.fudan.langlab.domain.organization.proxy.PartyProxy;
import edu.fudan.mylang.pf.BaseModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.DiscriminatorOptions;

@Entity
@DiscriminatorValue("PARTY_TYPE")
@DiscriminatorOptions(force = true)
@DiscriminatorColumn(length = 64)
@Table(name = "party")
public class PartyImpl extends BaseModelObject implements Party {
  public PartyImpl() {
    super();
  }
  
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public Party setName(final String name) {
    this.name = name;
    return this;			
    
  }
  
  private String phone;
  
  public String getPhone() {
    return this.phone;
  }
  
  public Party setPhone(final String phone) {
    this.phone = phone;
    return this;			
    
  }
  
  private String email;
  
  public String getEmail() {
    return this.email;
  }
  
  public Party setEmail(final String email) {
    this.email = email;
    return this;			
    
  }
  
  private String address;
  
  public String getAddress() {
    return this.address;
  }
  
  public Party setAddress(final String address) {
    this.address = address;
    return this;			
    
  }
  
  private String simplePy;
  
  public String getSimplePy() {
    return this.simplePy;
  }
  
  public Party setSimplePy(final String simplePy) {
    this.simplePy = simplePy;
    return this;			
    
  }
  
  public String getEntityName() {
    return this.name;
  }
  
  public String getNameField() {
    return "name";
  }
  
  public static Party create(final IObjectFactory objectFactory) {
    edu.fudan.langlab.domain.organization.Party party = new edu.fudan.langlab.domain.organization.impl.PartyImpl(
    );
    objectFactory.create(party);
    return party;			
    
  }
  
  public PartyProxy toProxy() {
    edu.fudan.langlab.domain.organization.proxy.PartyProxy proxy = new edu.fudan.langlab.domain.organization.proxy.PartyProxy();
    proxy.setId(this.getId());
    if(this instanceof edu.fudan.mylang.pf.INamedModelObject){
    	proxy.setName(((edu.fudan.mylang.pf.INamedModelObject)this).getEntityName());
    }
    return proxy;
    
  }
}
