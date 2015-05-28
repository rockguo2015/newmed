package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.shared.device.UIDevicePMPlan;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory.DateItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.WidgetExtensions;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DeivcePMPlanForm extends GXTFormComponent<UIDevicePMPlan> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public DateItem planDate;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  private UIDevicePMPlan value = new UIDevicePMPlan();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();planDate = dateValueProviderFactory.createAsDateItem("planDate","PM计划日期");
    widgetsRegistory.put("planDate",planDate);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIDevicePMPlan getValueAsNew() {
    UIDevicePMPlan value = new UIDevicePMPlan();
    value.setPlanDate(planDate.getValue());
    return value;
  }
  
  public UIDevicePMPlan doGetValue() {
    
    value.setPlanDate(planDate.getValue());
    return value;
  }
  
  public UIDevicePMPlan getValue(final UIDevicePMPlan copyValue) {
    
    copyValue.setPlanDate(planDate.getValue());
    return copyValue;
  }
  
  protected DeivcePMPlanForm doSetValue(final UIDevicePMPlan value) {
    this.value = value;
    planDate.setValue(value.getPlanDate());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)planDate
    					);
  }
  
  public Widget createWidget() {
    VerticalLayoutContainer _VLayout = this.widgets.VLayout();
    final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
        public void apply(final VerticalLayoutContainer it) {
          FieldLabel _asWidget = DeivcePMPlanForm.this.planDate.asWidget();
          WidgetExtensions.<FieldLabel>addFill(it, _asWidget);
        }
      };
    VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
    return _doubleArrow;
  }
}
