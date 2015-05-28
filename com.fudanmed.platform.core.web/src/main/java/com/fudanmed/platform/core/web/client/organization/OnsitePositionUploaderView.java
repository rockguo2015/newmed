package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.web.client.common.CommonUploadForm;
import com.fudanmed.platform.core.web.client.organization.OnsitePositionUploaderPresenterView;
import com.google.gwt.editor.client.HasEditorErrors;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.IHasSize;
import com.uniquesoft.gwt.client.common.widgets.IHasTitle;
import com.uniquesoft.gwt.client.common.widgets.Size;
import com.uniquesoft.gwt.shared.datatype.File;
import edu.fudan.langlab.gxt.client.component.form.Validations;
import edu.fudan.langlab.gxt.client.validation.ErrorNotifierViewer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;

public class OnsitePositionUploaderView extends ErrorNotifierViewer implements OnsitePositionUploaderPresenterView, IHasSize, IHasTitle {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(uploadForm),
    	new com.uniquesoft.gwt.client.common.async.IPostInitializeAction(){
    
    	public void initializeFinished(Void v) {
    		initialize();
    		postInitialize.initializeFinished(null);
    	}
    });
    
  }
  
  @Inject
  private Securities securities;
  
  @Inject
  private EventBus eventBus;
  
  @Inject
  private CommonUploadForm uploadForm;
  
  public void initialize() {
    
    Widget _asWidget = this.uploadForm.asWidget();
    ClientUi.operator_add(this, _asWidget);
  }
  
  public File getFile() {
    File _value = this.uploadForm.file.getValue();
    return _value;
  }
  
  public HasEditorErrors mapField(final String errorKey) {
    HasEditorErrors _mapToErrorEditor = Validations.mapToErrorEditor(this.uploadForm, errorKey);
    return _mapToErrorEditor;
  }
  
  public Size getSize() {
    Size _size = new Size(400, 150);
    return _size;
  }
  
  public String getTitle() {
    return "\u4F4D\u7F6E\u4FE1\u606F\u5BFC\u5165";
  }
}
