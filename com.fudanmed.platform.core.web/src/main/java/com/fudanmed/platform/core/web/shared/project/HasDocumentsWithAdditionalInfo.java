package com.fudanmed.platform.core.web.shared.project;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import edu.fudan.langlab.domain.document.proxy.IHasDocumentsProxy;

public class HasDocumentsWithAdditionalInfo implements IsSerializable {
  private IHasDocumentsProxy value;
  
  public IHasDocumentsProxy getValue() {
    return this.value;
  }
  
  public void setValue(final IHasDocumentsProxy value) {
    this.value = value;
  }
  
  public final static String P_Value = "value";
  
  public static IObjectFieldAccessor<HasDocumentsWithAdditionalInfo,IHasDocumentsProxy> ValueAccessor = new IObjectFieldAccessor<HasDocumentsWithAdditionalInfo,IHasDocumentsProxy>(){
    				public edu.fudan.langlab.domain.document.proxy.IHasDocumentsProxy getValue(HasDocumentsWithAdditionalInfo object){
    					return object.getValue();
    				}
    				public void setValue(HasDocumentsWithAdditionalInfo object,edu.fudan.langlab.domain.document.proxy.IHasDocumentsProxy value){
    					object.setValue(value);
    				}
    			};
  
  private Boolean hasDocuments;
  
  public Boolean getHasDocuments() {
    return this.hasDocuments;
  }
  
  public void setHasDocuments(final Boolean hasDocuments) {
    this.hasDocuments = hasDocuments;
  }
  
  public final static String P_HasDocuments = "hasDocuments";
  
  public static IObjectFieldAccessor<HasDocumentsWithAdditionalInfo,Boolean> HasDocumentsAccessor = new IObjectFieldAccessor<HasDocumentsWithAdditionalInfo,Boolean>(){
    				public Boolean getValue(HasDocumentsWithAdditionalInfo object){
    					return object.getHasDocuments();
    				}
    				public void setValue(HasDocumentsWithAdditionalInfo object,Boolean value){
    					object.setHasDocuments(value);
    				}
    			};
}
