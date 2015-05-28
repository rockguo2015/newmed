package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.web.client.organization.ResetPasswdDataForm;
import com.fudanmed.platform.core.web.client.organization.ResetPasswdPresenterView;
import com.fudanmed.platform.core.web.shared.organization.UIResetPasswdData;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FileUploadField;
import com.sencha.gxt.widget.core.client.form.FormPanel;
import com.sencha.gxt.widget.core.client.form.FormPanel.Encoding;
import com.sencha.gxt.widget.core.client.form.FormPanel.Method;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.IHasSize;
import com.uniquesoft.gwt.client.common.widgets.IHasTitle;
import com.uniquesoft.gwt.client.common.widgets.Size;
import edu.fudan.langlab.gxt.client.component.form.FormViewerImpl;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ResetPasswdView extends FormViewerImpl<UIResetPasswdData> implements ResetPasswdPresenterView, IHasTitle, IHasSize {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(form),
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
  private ResetPasswdDataForm form;
  
  public ResetPasswdDataForm doGetFormComponent() {
    return form;
  }
  
  public String getTitle() {
    return "重置密码";
  }
  
  public Size getSize() {
    return new com.uniquesoft.gwt.client.common.widgets.Size(250,200);
  }
  
  public void initialize() {
    
    Widget _asWidget = this.form.asWidget();
    ClientUi.operator_add(this, _asWidget);
    FormPanel _formPanel = new FormPanel();
    final FormPanel formPanel = _formPanel;
    formPanel.setAction("/fudanmedcoreweb/restservice/upload");
    formPanel.setEncoding(Encoding.MULTIPART);
    formPanel.setMethod(Method.POST);
    FileUploadField _fileUploadField = new FileUploadField();
    final FileUploadField file = _fileUploadField;
    file.setName("uploadedfile");
    VerticalLayoutContainer _VLayout = this.widgets.VLayout();
    final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
        public void apply(final VerticalLayoutContainer it) {
          FieldLabel _fieldLabel = new FieldLabel(file, "File");
          it.add(_fieldLabel);
          final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
              public void apply(final SelectEvent it) {
                formPanel.submit();
              }
            };
          TextButton _TextButton = ResetPasswdView.this.widgets.TextButton("submit", _function);
          it.add(_TextButton);
        }
      };
    VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
    formPanel.add(_doubleArrow);
    ClientUi.operator_add(this, formPanel);
  }
  
  public void setDefaultNewPasswd(final String newPasswd) {
    this.form.newPasswd.setValue(newPasswd);
  }
}
