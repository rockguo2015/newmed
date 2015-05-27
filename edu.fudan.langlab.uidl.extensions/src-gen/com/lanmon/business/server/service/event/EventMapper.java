package com.lanmon.business.server.service.event;

import com.google.common.base.Objects;
import com.lanmon.business.server.service.event.EventValidator;
import com.lanmon.business.shared.event.GWTEvent;
import com.lanmon.workflow.business.Customer;
import com.lanmon.workflow.business.Event;
import com.uniquesoft.gwt.shared.datatype.File;
import com.uniquesoft.uidl.transform.AbstractEntityMapper;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.langlab.datatypes.FileAttachment;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.lanmon.business.server.service.event.EventMapper")
public class EventMapper extends AbstractEntityMapper<GWTEvent,Event> {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  public Event loadEntityById(final Long id) {
    return entities.get(Event.class,id);
  }
  
  public Event create() {
    return entities.create(Event.class);
  }
  
  @Autowired
  private EventValidator validator;
  
  public void copyToEntity(final GWTEvent from, final Event to) {
    java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator.validate(from);
    if(errors.size()!=0)throw new com.uniquesoft.gwt.shared.validation.ValidationException(errors);					
    to.setEventAuthor(convertService.toValue(com.lanmon.workflow.business.Employee.class,from.getEventAuthor()));
    to.setEventDate(convertService.toValue(java.util.Date.class,from.getEventDate()));
    to.setNote(convertService.toValue(java.lang.String.class,from.getNote()));
    to.setType(convertService.toValue(com.lanmon.workflow.business.EventType.class,from.getType()));
    copyToCust(from,to);
    
  }
  
  protected void copyToCust(final GWTEvent _gwt, final Event _entity) {
    File _attachment = _gwt.getAttachment();
    String _fileName = _attachment.getFileName();
    boolean _notEquals = (!Objects.equal(_fileName, null));
    if (_notEquals) {
      File _attachment_1 = _gwt.getAttachment();
      FileAttachment _value = this.convertService.<File, FileAttachment>toValue(FileAttachment.class, _attachment_1);
      _entity.setAttachment(_value);
    }
    Customer _customer = _entity.getCustomer();
    Date _date = new Date();
    _customer.setLastUpdate(_date);
  }
  
  public GWTEvent copyFromEntity(final GWTEvent result, final Event entity) {
    if(entity==null) return null;
    result.setId(entity.getId());
    result.setEventAuthor(convertService.toValue(com.uniquesoft.gwt.shared.GWTNamedEntity.class,entity.getEventAuthor()));
    result.setEventDate(convertService.toValue(java.util.Date.class,entity.getEventDate()));
    result.setNote(convertService.toValue(java.lang.String.class,entity.getNote()));
    result.setType(convertService.toValue(com.lanmon.business.shared.event.GWTEventType.class,entity.getType()));
    result.setCustomer(convertService.toValue(com.uniquesoft.gwt.shared.GWTNamedEntity.class,entity.getCustomer()));
    buildFromCust(result,entity);
    return result;
    
  }
  
  public GWTEvent buildFrom(final Event entity) {
    if(entity==null) return null;
    com.lanmon.business.shared.event.GWTEvent result = new com.lanmon.business.shared.event.GWTEvent();
    copyFromEntity(result,entity);	
    return result;
    
  }
  
  protected void buildFromCust(final GWTEvent _gwt, final Event _entity) {
    FileAttachment _attachment = _entity.getAttachment();
    String _title = _attachment==null?(String)null:_attachment.getTitle();
    boolean _notEquals = (!Objects.equal(_title, null));
    _gwt.setHasAttachment(Boolean.valueOf(_notEquals));
    FileAttachment _attachment_1 = _entity.getAttachment();
    File _value = this.convertService.<FileAttachment, File>toValue(File.class, _attachment_1);
    _gwt.setAttachment(_value);
  }
  
  public Class<?> getUIClass() {
    return GWTEvent.class;
  }
  
  public Class<?> getEntityClass() {
    return Event.class;
  }
}
