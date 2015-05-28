package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.shared.device.UIDevicePMSpecificationCriteria;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class DevicePMSpecificationCriteriaForm extends GXTFormComponent<UIDevicePMSpecificationCriteria> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public TextItem sid;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIDevicePMSpecificationCriteria value = new UIDevicePMSpecificationCriteria();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();sid = stringValueProviderFactory.createAsTextItem("sid","设备编号");
    widgetsRegistory.put("sid",sid);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIDevicePMSpecificationCriteria getValueAsNew() {
    UIDevicePMSpecificationCriteria value = new UIDevicePMSpecificationCriteria();
    value.setSid(sid.getValue());
    return value;
  }
  
  public UIDevicePMSpecificationCriteria doGetValue() {
    
    value.setSid(sid.getValue());
    return value;
  }
  
  public UIDevicePMSpecificationCriteria getValue(final UIDevicePMSpecificationCriteria copyValue) {
    
    copyValue.setSid(sid.getValue());
    return copyValue;
  }
  
  protected DevicePMSpecificationCriteriaForm doSetValue(final UIDevicePMSpecificationCriteria value) {
    this.value = value;
    sid.setValue(value.getSid());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)sid
    					);
  }
}
