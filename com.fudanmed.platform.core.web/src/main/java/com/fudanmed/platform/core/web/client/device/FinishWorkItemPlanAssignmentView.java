package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.FinishWorkItemPlanAssignmentPresenterView;
import com.fudanmed.platform.core.web.client.device.WorkItemPlanAssignmentFinishDataForm;
import com.fudanmed.platform.core.web.shared.device.UIWorkItemPlanAssignmentFinishData;
import com.google.gwt.editor.client.HasEditorErrors;
import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.IHasSize;
import com.uniquesoft.gwt.client.common.widgets.IHasTitle;
import com.uniquesoft.gwt.client.common.widgets.Size;
import edu.fudan.langlab.gxt.client.component.form.Validations;
import edu.fudan.langlab.gxt.client.validation.ErrorNotifierViewer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.WidgetExtensions;
import edu.fudan.langlab.security.client.Securities;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class FinishWorkItemPlanAssignmentView extends ErrorNotifierViewer implements FinishWorkItemPlanAssignmentPresenterView, IHasSize, IHasTitle {
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
  
  public Size getSize() {
    return new com.uniquesoft.gwt.client.common.widgets.Size(400,250);
  }
  
  public String getTitle() {
    return "PM维保记录";
  }
  
  @Inject
  private WorkItemPlanAssignmentFinishDataForm form;
  
  public void initialize() {
    
    VerticalLayoutContainer _VLayout = this.widgets.VLayout();
    final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
        public void apply(final VerticalLayoutContainer it) {
          FieldLabel _asWidget = FinishWorkItemPlanAssignmentView.this.form.finished.asWidget();
          WidgetExtensions.<FieldLabel>addFill(it, _asWidget);
          FieldLabel _asWidget_1 = FinishWorkItemPlanAssignmentView.this.form.comment.asWidget();
          final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
              public void apply(final FieldLabel it) {
                it.setWidth(400);
                it.setHeight(100);
              }
            };
          FieldLabel _doubleArrow = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget_1, _function);
          WidgetExtensions.<FieldLabel>addFill(it, _doubleArrow);
        }
      };
    VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
    VerticalLayoutContainer _DialogContent = this.widgets.DialogContent(_doubleArrow);
    ClientUi.operator_add(this, _DialogContent);
  }
  
  public UIWorkItemPlanAssignmentFinishData getValue() {
    UIWorkItemPlanAssignmentFinishData _value = this.form.getValue();
    return _value;
  }
  
  public HasEditorErrors mapField(final String errorKey) {
    HasEditorErrors _mapToErrorEditor = Validations.mapToErrorEditor(this.form, errorKey);
    return _mapToErrorEditor;
  }
  
  public void clearErrors() {
    Validations.clearErrors(this.form);
  }
  
  public void setValue(final UIWorkItemPlanAssignmentFinishData value) {
    this.form.setValue(value);
  }
}
