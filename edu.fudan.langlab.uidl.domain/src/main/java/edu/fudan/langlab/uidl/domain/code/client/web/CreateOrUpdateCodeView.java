package edu.fudan.langlab.uidl.domain.code.client.web;

import com.google.gwt.editor.client.HasEditorErrors;
import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.gxt.client.component.form.Validations;
import edu.fudan.langlab.gxt.client.validation.ErrorNotifierViewer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import edu.fudan.langlab.uidl.domain.code.client.web.CodeForm;
import edu.fudan.langlab.uidl.domain.code.client.web.CreateOrUpdateCodePresenterView;
import edu.fudan.langlab.uidl.domain.code.shared.web.UICode;

public class CreateOrUpdateCodeView extends ErrorNotifierViewer implements CreateOrUpdateCodePresenterView {
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
  private CodeForm form;
  
  public void initialize() {
    
    VerticalLayoutContainer _asWidget = this.form.asWidget();
    VerticalLayoutContainer _DialogContent = this.widgets.DialogContent(_asWidget);
    ClientUi.operator_add(this, _DialogContent);
  }
  
  public UICode getValue() {
    UICode _value = this.form.getValue();
    return _value;
  }
  
  public HasEditorErrors mapField(final String errorKey) {
    HasEditorErrors _mapToErrorEditor = Validations.mapToErrorEditor(this.form, errorKey);
    return _mapToErrorEditor;
  }
  
  public void setValue(final UICode shop) {
    this.form.setValue(shop);
    FieldLabel _asWidget = this.form.inputNext.asWidget();
    _asWidget.hide();
  }
}
