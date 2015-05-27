package com.lanmon.business.shared.event;

import com.lanmon.business.shared.event.GWTEventType;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import com.uniquesoft.gwt.shared.datatype.File;
import java.util.Date;

public class GWTEvent extends GWTEntity {
  private GWTEventType type;
  
  public GWTEventType getType() {
    return this.type;
  }
  
  public void setType(final GWTEventType type) {
    this.type = type;
  }
  
  public final static String P_Type = "type";
  
  public static IObjectFieldAccessor<GWTEvent,GWTEventType> TypeAccessor = new IObjectFieldAccessor<GWTEvent,GWTEventType>(){
    				public GWTEventType getValue(GWTEvent object){
    					return object.getType();
    				}
    				public void setValue(GWTEvent object,GWTEventType value){
    					object.setType(value);
    				}
    			};
  
  private String note;
  
  public String getNote() {
    return this.note;
  }
  
  public void setNote(final String note) {
    this.note = note;
  }
  
  public final static String P_Note = "note";
  
  public static IObjectFieldAccessor<GWTEvent,String> NoteAccessor = new IObjectFieldAccessor<GWTEvent,String>(){
    				public String getValue(GWTEvent object){
    					return object.getNote();
    				}
    				public void setValue(GWTEvent object,String value){
    					object.setNote(value);
    				}
    			};
  
  private Date eventDate;
  
  public Date getEventDate() {
    return this.eventDate;
  }
  
  public void setEventDate(final Date eventDate) {
    this.eventDate = eventDate;
  }
  
  public final static String P_EventDate = "eventDate";
  
  public static IObjectFieldAccessor<GWTEvent,Date> EventDateAccessor = new IObjectFieldAccessor<GWTEvent,Date>(){
    				public Date getValue(GWTEvent object){
    					return object.getEventDate();
    				}
    				public void setValue(GWTEvent object,Date value){
    					object.setEventDate(value);
    				}
    			};
  
  private GWTNamedEntity eventAuthor;
  
  public GWTNamedEntity getEventAuthor() {
    return this.eventAuthor;
  }
  
  public void setEventAuthor(final GWTNamedEntity eventAuthor) {
    this.eventAuthor = eventAuthor;
  }
  
  public final static String P_EventAuthor = "eventAuthor";
  
  public static IObjectFieldAccessor<GWTEvent,GWTNamedEntity> EventAuthorAccessor = new IObjectFieldAccessor<GWTEvent,GWTNamedEntity>(){
    				public GWTNamedEntity getValue(GWTEvent object){
    					return object.getEventAuthor();
    				}
    				public void setValue(GWTEvent object,GWTNamedEntity value){
    					object.setEventAuthor(value);
    				}
    			};
  
  private GWTNamedEntity customer;
  
  public GWTNamedEntity getCustomer() {
    return this.customer;
  }
  
  public void setCustomer(final GWTNamedEntity customer) {
    this.customer = customer;
  }
  
  public final static String P_Customer = "customer";
  
  public static IObjectFieldAccessor<GWTEvent,GWTNamedEntity> CustomerAccessor = new IObjectFieldAccessor<GWTEvent,GWTNamedEntity>(){
    				public GWTNamedEntity getValue(GWTEvent object){
    					return object.getCustomer();
    				}
    				public void setValue(GWTEvent object,GWTNamedEntity value){
    					object.setCustomer(value);
    				}
    			};
  
  private File attachment;
  
  public File getAttachment() {
    return this.attachment;
  }
  
  public void setAttachment(final File attachment) {
    this.attachment = attachment;
  }
  
  public final static String P_Attachment = "attachment";
  
  public static IObjectFieldAccessor<GWTEvent,File> AttachmentAccessor = new IObjectFieldAccessor<GWTEvent,File>(){
    				public File getValue(GWTEvent object){
    					return object.getAttachment();
    				}
    				public void setValue(GWTEvent object,File value){
    					object.setAttachment(value);
    				}
    			};
  
  private Boolean hasAttachment;
  
  public Boolean getHasAttachment() {
    return this.hasAttachment;
  }
  
  public void setHasAttachment(final Boolean hasAttachment) {
    this.hasAttachment = hasAttachment;
  }
  
  public final static String P_HasAttachment = "hasAttachment";
  
  public static IObjectFieldAccessor<GWTEvent,Boolean> HasAttachmentAccessor = new IObjectFieldAccessor<GWTEvent,Boolean>(){
    				public Boolean getValue(GWTEvent object){
    					return object.getHasAttachment();
    				}
    				public void setValue(GWTEvent object,Boolean value){
    					object.setHasAttachment(value);
    				}
    			};
}
