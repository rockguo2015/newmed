package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMWorkItemPresenterView;
import com.fudanmed.platform.core.web.client.device.DevicePMPlan4ConfirmListGrid;
import com.fudanmed.platform.core.web.client.device.PMWorkItemForm;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMPlan;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItem;
import com.google.gwt.editor.client.HasEditorErrors;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.form.FieldSet;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.IHasSize;
import com.uniquesoft.gwt.client.common.widgets.IHasTitle;
import com.uniquesoft.gwt.client.common.widgets.Size;
import edu.fudan.langlab.gxt.client.component.form.Validations;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.validation.ErrorNotifierViewer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateOrUpdatePMWorkItemView extends ErrorNotifierViewer implements CreateOrUpdatePMWorkItemPresenterView, IHasSize, IHasTitle {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(form,devicePlanList),
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
  private PMWorkItemForm form;
  
  @Inject
  private DevicePMPlan4ConfirmListGrid devicePlanList;
  
  public void initialize() {
    
    VerticalLayoutContainer _VLayout = this.widgets.VLayout();
    final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
        public void apply(final VerticalLayoutContainer it) {
          FieldSet _FieldSet = CreateOrUpdatePMWorkItemView.this.widgets.FieldSet("\u8BBE\u5907PM\u8BA1\u5212\u6E05\u5355");
          final Procedure1<FieldSet> _function = new Procedure1<FieldSet>() {
              public void apply(final FieldSet it) {
                SGroupingGrid<UIDevicePMPlan> _asWidget = CreateOrUpdatePMWorkItemView.this.devicePlanList.asWidget();
                it.setWidget(_asWidget);
              }
            };
          FieldSet _doubleArrow = ObjectExtensions.<FieldSet>operator_doubleArrow(_FieldSet, _function);
          VerticalLayoutData _VLayoutData = CreateOrUpdatePMWorkItemView.this.widgets.VLayoutData(1, 280, 10);
          it.add(_doubleArrow, _VLayoutData);
          Widget _asWidget = CreateOrUpdatePMWorkItemView.this.form.asWidget();
          int _minus = (-1);
          VerticalLayoutData _VLayoutData_1 = CreateOrUpdatePMWorkItemView.this.widgets.VLayoutData(1, _minus, 10);
          it.add(_asWidget, _VLayoutData_1);
        }
      };
    VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
    ClientUi.operator_add(this, _doubleArrow);
  }
  
  public UIPMWorkItem getValue() {
    UIPMWorkItem _value = this.form.getValue();
    return _value;
  }
  
  public HasEditorErrors mapField(final String errorKey) {
    HasEditorErrors _mapToErrorEditor = Validations.mapToErrorEditor(this.form, errorKey);
    return _mapToErrorEditor;
  }
  
  public void clearErrors() {
    Validations.clearErrors(this.form);
  }
  
  public void setValue(final UIPMWorkItem value) {
    this.form.setValue(value);
  }
  
  public Size getSize() {
    Size _size = new Size(800, 550);
    return _size;
  }
  
  public String getTitle() {
    return "PM\u4EFB\u52A1\u5355";
  }
  
  public void setDevicePlans(final Collection<UIDevicePMPlan> plans) {
    this.devicePlanList.setObjects(plans);
  }
}
