package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMTypeProxy;
import com.fudanmed.platform.core.web.client.device.PMDefaultIntervalAssociationEditListGrid;
import com.fudanmed.platform.core.web.client.device.RCDevicePMTypeContentProvider;
import com.fudanmed.platform.core.web.shared.device.UIPMDefaultIntervalAssociation;
import com.fudanmed.platform.core.web.shared.device.UIPMDeviceTypeEntry;
import com.google.common.base.Function;
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
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectsSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectsSelectorFactory.ListGridBasedItemsProvider;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.WidgetExtensions;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class PMDeviceTypeEntryForm extends GXTFormComponent<UIPMDeviceTypeEntry> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public ComboBoxSelector<RCDevicePMTypeProxy> pmType;
  
  @Inject
  public RCDevicePMTypeContentProvider pmTypeContentProvider;
  
  public ListGridBasedItemsProvider<UIPMDefaultIntervalAssociation> intervals;
  
  @Inject
  private DefaultObjectsSelectorFactory defaultObjectsSelectorFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  private UIPMDeviceTypeEntry value = new UIPMDeviceTypeEntry();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();pmType = defaultObjectSelectorFactory.createAsComboBoxItem("pmType","选择维修类别");
    _initializerSupports.add(pmTypeContentProvider);
    pmType.setContentProvider(pmTypeContentProvider);
    widgetsRegistory.put("pmType",pmType);
    intervals = defaultObjectsSelectorFactory.createAsListGridBasedItem("intervals","维修周期",this.listGrid);
    widgetsRegistory.put("intervals",intervals);
    if(listGrid instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
    							_initializerSupports.add((com.uniquesoft.gwt.client.common.async.IInitializerSupport)listGrid);
    						}IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIPMDeviceTypeEntry getValueAsNew() {
    UIPMDeviceTypeEntry value = new UIPMDeviceTypeEntry();
    value.setPmType(pmType.getValue());
    value.setIntervals(intervals.getValue());
    return value;
  }
  
  public UIPMDeviceTypeEntry doGetValue() {
    
    value.setPmType(pmType.getValue());
    value.setIntervals(intervals.getValue());
    return value;
  }
  
  public UIPMDeviceTypeEntry getValue(final UIPMDeviceTypeEntry copyValue) {
    
    copyValue.setPmType(pmType.getValue());
    copyValue.setIntervals(intervals.getValue());
    return copyValue;
  }
  
  protected PMDeviceTypeEntryForm doSetValue(final UIPMDeviceTypeEntry value) {
    this.value = value;
    pmType.setValue(value.getPmType());
    intervals.setValue(value.getIntervals());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)pmType,(ICanAsWidget)intervals
    					);
  }
  
  public Widget createWidget() {
    VerticalLayoutContainer _VLayout = this.widgets.VLayout();
    final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
        public void apply(final VerticalLayoutContainer it) {
          FieldLabel _asWidget = PMDeviceTypeEntryForm.this.pmType.asWidget();
          WidgetExtensions.<FieldLabel>addFill(it, _asWidget);
          FieldLabel _asWidget_1 = PMDeviceTypeEntryForm.this.intervals.asWidget();
          final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
              public void apply(final FieldLabel it) {
                it.setHeight(100);
                final Function1<Void,UIPMDefaultIntervalAssociation> _function = new Function1<Void,UIPMDefaultIntervalAssociation>() {
                    public UIPMDefaultIntervalAssociation apply(final Void it) {
                      UIPMDefaultIntervalAssociation _uIPMDefaultIntervalAssociation = new UIPMDefaultIntervalAssociation();
                      final Procedure1<UIPMDefaultIntervalAssociation> _function = new Procedure1<UIPMDefaultIntervalAssociation>() {
                          public void apply(final UIPMDefaultIntervalAssociation it) {
                            RCDevicePMTypeProxy _value = PMDeviceTypeEntryForm.this.pmType.getValue();
                            it.setType(_value);
                            it.setIntervalInDays(Integer.valueOf(0));
                          }
                        };
                      UIPMDefaultIntervalAssociation _doubleArrow = ObjectExtensions.<UIPMDefaultIntervalAssociation>operator_doubleArrow(_uIPMDefaultIntervalAssociation, _function);
                      return _doubleArrow;
                    }
                  };
                PMDeviceTypeEntryForm.this.intervals.setObjectCreater(new Function<Void,UIPMDefaultIntervalAssociation>() {
                    public UIPMDefaultIntervalAssociation apply(Void input) {
                      return _function.apply(input);
                    }
                });
              }
            };
          FieldLabel _doubleArrow = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget_1, _function);
          WidgetExtensions.<FieldLabel>addFill(it, _doubleArrow);
        }
      };
    VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
    return _doubleArrow;
  }
  
  @Inject
  private PMDefaultIntervalAssociationEditListGrid listGrid;
}
