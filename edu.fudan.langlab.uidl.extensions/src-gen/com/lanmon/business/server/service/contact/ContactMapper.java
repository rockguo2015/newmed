package com.lanmon.business.server.service.contact;

import com.google.common.base.Objects;
import com.lanmon.business.shared.contact.GWTContact;
import com.lanmon.workflow.business.ContactInfo;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.lanmon.business.server.service.contact.ContactMapper")
public class ContactMapper extends AbstractEntityMapper<GWTContact,ContactInfo> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public ContactInfo loadEntityById(final Long id) {
    return entities.get(ContactInfo.class,id);
  }
  
  public ContactInfo create() {
    return entities.create(ContactInfo.class);
  }
  
  public void copyToEntity(final GWTContact from, final ContactInfo to) {
    to.setCustomer(convertService.toValue(com.lanmon.workflow.business.Customer.class,from.getCustomer()));
    to.setName(convertService.toValue(java.lang.String.class,from.getName()));
    to.setType(convertService.toValue(com.lanmon.workflow.business.ContactCode.class,from.getType()));
    to.setPhone(convertService.toValue(java.lang.String.class,from.getPhone()));
    copyToCust(from,to);
    
  }
  
  protected void copyToCust(final GWTContact _gwt, final ContactInfo _entity) {
    String _email = _gwt.getEmail();
    String _email_1 = _entity.getEmail();
    boolean _notEquals = (!Objects.equal(_email, _email_1));
    if (_notEquals) {
      Date _date = new Date();
      _entity.setEmailUpdateDate(_date);
      String _email_2 = _gwt.getEmail();
      _entity.setEmail(_email_2);
    }
  }
  
  public GWTContact copyFromEntity(final GWTContact result, final ContactInfo entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setCustomer(convertService.toValue(com.uniquesoft.gwt.shared.GWTNamedEntity.class,entity.getCustomer()));
    result.setName(convertService.toValue(java.lang.String.class,entity.getName()));
    result.setType(convertService.toValue(com.uniquesoft.gwt.shared.GWTNamedEntity.class,entity.getType()));
    result.setPhone(convertService.toValue(java.lang.String.class,entity.getPhone()));
    buildFromCust(result,entity);
    return result;
    
  }
  
  public GWTContact buildFrom(final ContactInfo entity) {
    if(entity==null) return null;
    com.lanmon.business.shared.contact.GWTContact result = new com.lanmon.business.shared.contact.GWTContact();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  protected void buildFromCust(final GWTContact _gwt, final ContactInfo _entity) {
    String _email = _entity.getEmail();
    _gwt.setEmail(_email);
  }
  
  public Class<?> getUIClass() {
    return GWTContact.class;
  }
  
  public Class<?> getEntityClass() {
    return ContactInfo.class;
  }
}
