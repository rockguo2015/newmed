package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMTypeProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceProxy;
import com.fudanmed.platform.core.web.client.device.RCDevicePMTypeContentProvider;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMSpecification;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.ComboBoxSelector;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.IntegerValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.IntegerValueProviderFactory.IntegerItem;
import edu.fudan.langlab.gxt.client.component.form.factory.ReadonlyItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextAreaItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DevicePMSpecificationForm extends GXTFormComponent<UIDevicePMSpecification> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public ReadonlyItem<RCDeviceProxy> device;
  
  public ComboBoxSelector<RCDevicePMTypeProxy> pmType;
  
  @Inject
  public RCDevicePMTypeContentProvider pmTypeContentProvider;
  
  public IntegerItem intervalInDays;
  
  public TextAreaItem description;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private IntegerValueProviderFactory integerValueProviderFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIDevicePMSpecification value = new UIDevicePMSpecification();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();device = defaultObjectSelectorFactory.createAsReadonlyItem("device","维保设备");
    widgetsRegistory.put("device",device);
    pmType = defaultObjectSelectorFactory.createAsComboBoxItem("pmType","维保类别");
    _initializerSupports.add(pmTypeContentProvider);
    pmType.setContentProvider(pmTypeContentProvider);
    widgetsRegistory.put("pmType",pmType);
    intervalInDays = integerValueProviderFactory.createAsIntegerItem("intervalInDays","维保周期(天)");
    widgetsRegistory.put("intervalInDays",intervalInDays);
    description = stringValueProviderFactory.createAsTextAreaItem("description","维保内容");
    widgetsRegistory.put("description",description);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIDevicePMSpecification getValueAsNew() {
    UIDevicePMSpecification value = new UIDevicePMSpecification();
    value.setDevice(device.getValue());
    value.setPmType(pmType.getValue());
    value.setIntervalInDays(intervalInDays.getValue());
    value.setDescription(description.getValue());
    return value;
  }
  
  public UIDevicePMSpecification doGetValue() {
    
    value.setDevice(device.getValue());
    value.setPmType(pmType.getValue());
    value.setIntervalInDays(intervalInDays.getValue());
    value.setDescription(description.getValue());
    return value;
  }
  
  public UIDevicePMSpecification getValue(final UIDevicePMSpecification copyValue) {
    
    copyValue.setDevice(device.getValue());
    copyValue.setPmType(pmType.getValue());
    copyValue.setIntervalInDays(intervalInDays.getValue());
    copyValue.setDescription(description.getValue());
    return copyValue;
  }
  
  protected DevicePMSpecificationForm doSetValue(final UIDevicePMSpecification value) {
    this.value = value;
    device.setValue(value.getDevice());
    pmType.setValue(value.getPmType());
    intervalInDays.setValue(value.getIntervalInDays());
    description.setValue(value.getDescription());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)device,(ICanAsWidget)pmType,(ICanAsWidget)intervalInDays,(ICanAsWidget)description
    					);
  }
  
  public Widget createWidget() {
    VerticalLayoutContainer _VLayout = this.widgets.VLayout();
    final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
        public void apply(final VerticalLayoutContainer it) {
          FieldLabel _asWidget = DevicePMSpecificationForm.this.device.asWidget();
          int _minus = (-1);
          VerticalLayoutData _VLayoutData = DevicePMSpecificationForm.this.widgets.VLayoutData(1, _minus);
          it.add(_asWidget, _VLayoutData);
          FieldLabel _asWidget_1 = DevicePMSpecificationForm.this.pmType.asWidget();
          int _minus_1 = (-1);
          VerticalLayoutData _VLayoutData_1 = DevicePMSpecificationForm.this.widgets.VLayoutData(1, _minus_1);
          it.add(_asWidget_1, _VLayoutData_1);
          FieldLabel _asWidget_2 = DevicePMSpecificationForm.this.intervalInDays.asWidget();
          int _minus_2 = (-1);
          VerticalLayoutData _VLayoutData_2 = DevicePMSpecificationForm.this.widgets.VLayoutData(1, _minus_2);
          it.add(_asWidget_2, _VLayoutData_2);
          FieldLabel _asWidget_3 = DevicePMSpecificationForm.this.description.asWidget();
          VerticalLayoutData _VLayoutData_3 = DevicePMSpecificationForm.this.widgets.VLayoutData(525, 160);
          it.add(_asWidget_3, _VLayoutData_3);
        }
      };
    VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
    return _doubleArrow;
  }
}
