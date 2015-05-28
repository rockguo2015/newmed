package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.InitializePMPlanDataForm;
import com.fudanmed.platform.core.web.client.device.InitializePMPlanPresenterView;
import com.fudanmed.platform.core.web.shared.device.InitializePMPlanData;
import com.google.gwt.editor.client.HasEditorErrors;
import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
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
import java.util.Date;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class InitializePMPlanView extends ErrorNotifierViewer implements InitializePMPlanPresenterView, IHasSize, IHasTitle {
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
  private InitializePMPlanDataForm form;
  
  public void initialize() {
    
    VerticalLayoutContainer _VLayout = this.widgets.VLayout();
    final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
        public void apply(final VerticalLayoutContainer it) {
          FieldLabel _asWidget = InitializePMPlanView.this.form.fromDate.asWidget();
          int _minus = (-1);
          VerticalLayoutData _VLayoutData = InitializePMPlanView.this.widgets.VLayoutData(1, _minus, 10);
          it.add(_asWidget, _VLayoutData);
          FieldLabel _asWidget_1 = InitializePMPlanView.this.form.year.asWidget();
          int _minus_1 = (-1);
          VerticalLayoutData _VLayoutData_1 = InitializePMPlanView.this.widgets.VLayoutData(1, _minus_1, 10);
          it.add(_asWidget_1, _VLayoutData_1);
        }
      };
    VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
    ClientUi.operator_add(this, _doubleArrow);
  }
  
  public HasEditorErrors mapField(final String errorKey) {
    HasEditorErrors _mapToErrorEditor = Validations.mapToErrorEditor(this.form, errorKey);
    return _mapToErrorEditor;
  }
  
  public void clearErrors() {
    Validations.clearErrors(this.form);
  }
  
  public Size getSize() {
    Size _size = new Size(300, 200);
    return _size;
  }
  
  public String getTitle() {
    return "\u751F\u6210PM\u8BA1\u5212";
  }
  
  public InitializePMPlanData getValue() {
    InitializePMPlanData _value = this.form.getValue();
    return _value;
  }
  
  public void setDefaultFromDate(final Date date) {
    this.form.fromDate.setValue(date);
  }
}
