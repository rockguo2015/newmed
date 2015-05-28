package com.fudanmed.platform.core.web.shared.device;

import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import com.uniquesoft.gwt.shared.datatype.ActionColumn;
import com.uniquesoft.gwt.shared.datatype.File;
import edu.fudan.langlab.domain.document.proxy.DocumentStorageProxy;
import java.util.Date;

public class UIDocumentStorage extends GWTEntity {
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public void setName(final String name) {
    this.name = name;
  }
  
  public final static String P_Name = "name";
  
  public static IObjectFieldAccessor<UIDocumentStorage,String> NameAccessor = new IObjectFieldAccessor<UIDocumentStorage,String>(){
    				public String getValue(UIDocumentStorage object){
    					return object.getName();
    				}
    				public void setValue(UIDocumentStorage object,String value){
    					object.setName(value);
    				}
    			};
  
  private Date uploadTime;
  
  public Date getUploadTime() {
    return this.uploadTime;
  }
  
  public void setUploadTime(final Date uploadTime) {
    this.uploadTime = uploadTime;
  }
  
  public final static String P_UploadTime = "uploadTime";
  
  public static IObjectFieldAccessor<UIDocumentStorage,Date> UploadTimeAccessor = new IObjectFieldAccessor<UIDocumentStorage,Date>(){
    				public java.util.Date getValue(UIDocumentStorage object){
    					return object.getUploadTime();
    				}
    				public void setValue(UIDocumentStorage object,java.util.Date value){
    					object.setUploadTime(value);
    				}
    			};
  
  private ActionColumn download;
  
  public ActionColumn getDownload() {
    return this.download;
  }
  
  public void setDownload(final ActionColumn download) {
    this.download = download;
  }
  
  public final static String P_Download = "download";
  
  public static IObjectFieldAccessor<UIDocumentStorage,ActionColumn> DownloadAccessor = new IObjectFieldAccessor<UIDocumentStorage,ActionColumn>(){
    				public com.uniquesoft.gwt.shared.datatype.ActionColumn getValue(UIDocumentStorage object){
    					return object.getDownload();
    				}
    				public void setValue(UIDocumentStorage object,com.uniquesoft.gwt.shared.datatype.ActionColumn value){
    					object.setDownload(value);
    				}
    			};
  
  private String fileName;
  
  public String getFileName() {
    return this.fileName;
  }
  
  public void setFileName(final String fileName) {
    this.fileName = fileName;
  }
  
  public final static String P_FileName = "fileName";
  
  public static IObjectFieldAccessor<UIDocumentStorage,String> FileNameAccessor = new IObjectFieldAccessor<UIDocumentStorage,String>(){
    				public String getValue(UIDocumentStorage object){
    					return object.getFileName();
    				}
    				public void setValue(UIDocumentStorage object,String value){
    					object.setFileName(value);
    				}
    			};
  
  private String contentType;
  
  public String getContentType() {
    return this.contentType;
  }
  
  public void setContentType(final String contentType) {
    this.contentType = contentType;
  }
  
  public final static String P_ContentType = "contentType";
  
  public static IObjectFieldAccessor<UIDocumentStorage,String> ContentTypeAccessor = new IObjectFieldAccessor<UIDocumentStorage,String>(){
    				public String getValue(UIDocumentStorage object){
    					return object.getContentType();
    				}
    				public void setValue(UIDocumentStorage object,String value){
    					object.setContentType(value);
    				}
    			};
  
  private File content;
  
  public File getContent() {
    return this.content;
  }
  
  public void setContent(final File content) {
    this.content = content;
  }
  
  public final static String P_Content = "content";
  
  public static IObjectFieldAccessor<UIDocumentStorage,File> ContentAccessor = new IObjectFieldAccessor<UIDocumentStorage,File>(){
    				public com.uniquesoft.gwt.shared.datatype.File getValue(UIDocumentStorage object){
    					return object.getContent();
    				}
    				public void setValue(UIDocumentStorage object,com.uniquesoft.gwt.shared.datatype.File value){
    					object.setContent(value);
    				}
    			};
  
  public DocumentStorageProxy toProxy() {
    return (DocumentStorageProxy)super.toProxy();
    
  }
}
