package edu.fudan.langlab.uidl.domain.app.client.security;

import com.google.gwt.editor.client.HasEditorErrors;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.IHasSize;
import com.uniquesoft.gwt.client.common.widgets.IHasTitle;
import com.uniquesoft.gwt.client.common.widgets.Size;
import edu.fudan.langlab.gxt.client.component.form.Validations;
import edu.fudan.langlab.gxt.client.validation.ErrorNotifierViewer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import edu.fudan.langlab.uidl.domain.app.client.security.AppFunctionAssignmentForm;
import edu.fudan.langlab.uidl.domain.app.client.security.CreateOrUpdateAppFunctionAssignmentPresenterView;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIAppFunctionAssignment;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateOrUpdateAppFunctionAssignmentView extends ErrorNotifierViewer implements CreateOrUpdateAppFunctionAssignmentPresenterView, IHasSize, IHasTitle {
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
  private AppFunctionAssignmentForm form;
  
  public void initialize() {
    
    FieldLabel _asWidget = this.form.functions.asWidget();
    Widget _widget = _asWidget.getWidget();
    final Procedure1<Widget> _function = new Procedure1<Widget>() {
        public void apply(final Widget it) {
          it.setHeight("280");
        }
      };
    Widget _doubleArrow = ObjectExtensions.<Widget>operator_doubleArrow(_widget, _function);
    ClientUi.operator_add(this, _doubleArrow);
  }
  
  public UIAppFunctionAssignment getValue() {
    UIAppFunctionAssignment _value = this.form.getValue();
    return _value;
  }
  
  public HasEditorErrors mapField(final String errorKey) {
    HasEditorErrors _mapToErrorEditor = Validations.mapToErrorEditor(this.form, errorKey);
    return _mapToErrorEditor;
  }
  
  public void clearErrors() {
    Validations.clearErrors(this.form);
  }
  
  public void setValue(final UIAppFunctionAssignment value) {
    this.form.setValue(value);
  }
  
  public Size getSize() {
    Size _size = new Size(300, 400);
    return _size;
  }
  
  public String getTitle() {
    return "\u7CFB\u7EDF\u529F\u80FD";
  }
}
