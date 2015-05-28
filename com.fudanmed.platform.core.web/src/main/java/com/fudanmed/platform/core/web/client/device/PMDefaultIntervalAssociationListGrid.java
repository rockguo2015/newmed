package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMTypeProxy;
import com.fudanmed.platform.core.web.shared.device.UIPMDefaultIntervalAssociation;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import com.uniquesoft.gwt.shared.extensions.StringExtensions;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory.StringValueColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.IntegerValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.IntegerValueProviderFactory.IntegerColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

public class PMDefaultIntervalAssociationListGrid extends GXTGridComponent<UIPMDefaultIntervalAssociation> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringValueColumn<UIPMDefaultIntervalAssociation,RCDevicePMTypeProxy> type;
  
  public IntegerColumn<UIPMDefaultIntervalAssociation> intervalInDays;
  
  public StringColumn<UIPMDefaultIntervalAssociation> description;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  @Inject
  private IntegerValueProviderFactory integerValueProviderFactory;
  
  private UIPMDefaultIntervalAssociation value = new UIPMDefaultIntervalAssociation();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();type = defaultObjectSelectorFactory.createAsDefaultColumn("type","维保类别",UIPMDefaultIntervalAssociation.TypeAccessor);
    widgetsRegistory.put("type",type);
    intervalInDays = integerValueProviderFactory.createAsIntegerColumn("intervalInDays","默认维保周期",UIPMDefaultIntervalAssociation.IntervalInDaysAccessor);
    widgetsRegistory.put("intervalInDays",intervalInDays);
    description = stringValueProviderFactory.createAsStringColumn("description","维保内容",UIPMDefaultIntervalAssociation.DescriptionAccessor);
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
  
  public UIPMDefaultIntervalAssociation getValueAsNew() {
    UIPMDefaultIntervalAssociation value = new UIPMDefaultIntervalAssociation();
    value.setType(type.getValue());
    value.setIntervalInDays(intervalInDays.getValue());
    value.setDescription(description.getValue());
    return value;
  }
  
  public UIPMDefaultIntervalAssociation doGetValue() {
    
    value.setType(type.getValue());
    value.setIntervalInDays(intervalInDays.getValue());
    value.setDescription(description.getValue());
    return value;
  }
  
  public UIPMDefaultIntervalAssociation getValue(final UIPMDefaultIntervalAssociation copyValue) {
    
    copyValue.setType(type.getValue());
    copyValue.setIntervalInDays(intervalInDays.getValue());
    copyValue.setDescription(description.getValue());
    return copyValue;
  }
  
  protected PMDefaultIntervalAssociationListGrid doSetValue(final UIPMDefaultIntervalAssociation value) {
    this.value = value;
    type.setValue(value.getType());
    intervalInDays.setValue(value.getIntervalInDays());
    description.setValue(value.getDescription());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)type,(ICanAsWidget)intervalInDays,(ICanAsWidget)description
    					);
  }
  
  public void initializeComponent() {
    final Procedure2<UIPMDefaultIntervalAssociation,SafeHtmlBuilder> _function = new Procedure2<UIPMDefaultIntervalAssociation,SafeHtmlBuilder>() {
        public void apply(final UIPMDefaultIntervalAssociation value, final SafeHtmlBuilder sb) {
          String _description = value.getDescription();
          String _nullsafe = StringExtensions.nullsafe(_description);
          sb.appendEscapedLines(_nullsafe);
        }
      };
    this.withExpander(_function);
  }
}
