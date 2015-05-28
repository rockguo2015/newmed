package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.common.proxy.RCFaultLevelProxy;
import com.fudanmed.platform.core.web.client.organization.UIStandardColorContentProvider;
import com.fudanmed.platform.core.web.shared.organization.UIFaultLevelColorAdaptor;
import com.fudanmed.platform.core.web.shared.organization.UIStandardColor;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.ComboBoxSelector;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.ReadonlyItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.WidgetExtensions;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class FaultLevelColorAdaptorForm extends GXTFormComponent<UIFaultLevelColorAdaptor> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public ReadonlyItem<RCFaultLevelProxy> faultLevel;
  
  public ComboBoxSelector<UIStandardColor> color;
  
  @Inject
  public UIStandardColorContentProvider colorContentProvider;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  private UIFaultLevelColorAdaptor value = new UIFaultLevelColorAdaptor();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();faultLevel = defaultObjectSelectorFactory.createAsReadonlyItem("faultLevel","风险等级");
    widgetsRegistory.put("faultLevel",faultLevel);
    color = defaultObjectSelectorFactory.createAsComboBoxItem("color","提示颜色");
    color.setContentProvider(colorContentProvider);
    widgetsRegistory.put("color",color);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIFaultLevelColorAdaptor getValueAsNew() {
    UIFaultLevelColorAdaptor value = new UIFaultLevelColorAdaptor();
    value.setFaultLevel(faultLevel.getValue());
    value.setColor(color.getValue());
    return value;
  }
  
  public UIFaultLevelColorAdaptor doGetValue() {
    
    value.setFaultLevel(faultLevel.getValue());
    value.setColor(color.getValue());
    return value;
  }
  
  public UIFaultLevelColorAdaptor getValue(final UIFaultLevelColorAdaptor copyValue) {
    
    copyValue.setFaultLevel(faultLevel.getValue());
    copyValue.setColor(color.getValue());
    return copyValue;
  }
  
  protected FaultLevelColorAdaptorForm doSetValue(final UIFaultLevelColorAdaptor value) {
    this.value = value;
    faultLevel.setValue(value.getFaultLevel());
    color.setValue(value.getColor());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)faultLevel,(ICanAsWidget)color
    					);
  }
  
  public Widget createWidget() {
    VerticalLayoutContainer _VLayout = this.widgets.VLayout();
    final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
        public void apply(final VerticalLayoutContainer it) {
          FieldLabel _asWidget = FaultLevelColorAdaptorForm.this.faultLevel.asWidget();
          WidgetExtensions.<FieldLabel>addFill(it, _asWidget);
          FieldLabel _asWidget_1 = FaultLevelColorAdaptorForm.this.color.asWidget();
          WidgetExtensions.<FieldLabel>addFill(it, _asWidget_1);
        }
      };
    VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
    return _doubleArrow;
  }
}
