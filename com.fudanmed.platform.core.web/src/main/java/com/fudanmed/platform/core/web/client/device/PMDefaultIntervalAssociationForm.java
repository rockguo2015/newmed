package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMTypeProxy;
import com.fudanmed.platform.core.web.client.device.RCDevicePMTypeContentProvider;
import com.fudanmed.platform.core.web.shared.device.UIPMDefaultIntervalAssociation;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.ComboBoxSelector;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.IntegerValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.IntegerValueProviderFactory.IntegerItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextAreaItem;
import edu.fudan.langlab.gxt.client.widget.HTMLTagsExt;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTD;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTR;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTable;
import edu.fudan.langlab.gxt.client.widget.WidgetExtensions;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class PMDefaultIntervalAssociationForm extends GXTFormComponent<UIPMDefaultIntervalAssociation> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public ComboBoxSelector<RCDevicePMTypeProxy> type;
  
  @Inject
  public RCDevicePMTypeContentProvider typeContentProvider;
  
  public IntegerItem intervalInDays;
  
  public TextAreaItem description;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private IntegerValueProviderFactory integerValueProviderFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIPMDefaultIntervalAssociation value = new UIPMDefaultIntervalAssociation();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();type = defaultObjectSelectorFactory.createAsComboBoxItem("type","维保类别");
    _initializerSupports.add(typeContentProvider);
    type.setContentProvider(typeContentProvider);
    widgetsRegistory.put("type",type);
    intervalInDays = integerValueProviderFactory.createAsIntegerItem("intervalInDays","默认维保周期");
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
  
  protected PMDefaultIntervalAssociationForm doSetValue(final UIPMDefaultIntervalAssociation value) {
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
  
  public Widget createWidget() {
    VerticalLayoutContainer _VLayout = this.widgets.VLayout();
    final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
        public void apply(final VerticalLayoutContainer it) {
          PlainHTMLTable _TABLE = HTMLTagsExt.TABLE();
          final Procedure1<PlainHTMLTable> _function = new Procedure1<PlainHTMLTable>() {
              public void apply(final PlainHTMLTable it) {
                PlainHTMLTR _tr = HTMLTagsExt.tr(it);
                final Procedure1<PlainHTMLTR> _function = new Procedure1<PlainHTMLTR>() {
                    public void apply(final PlainHTMLTR it) {
                      PlainHTMLTD _td = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            FieldLabel _asWidget = PMDefaultIntervalAssociationForm.this.type.asWidget();
                            ClientUi.operator_add(it, _asWidget);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                      PlainHTMLTD _td_1 = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function_1 = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            FieldLabel _asWidget = PMDefaultIntervalAssociationForm.this.intervalInDays.asWidget();
                            ClientUi.operator_add(it, _asWidget);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td_1, _function_1);
                    }
                  };
                ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr, _function);
              }
            };
          PlainHTMLTable _doubleArrow = ObjectExtensions.<PlainHTMLTable>operator_doubleArrow(_TABLE, _function);
          WidgetExtensions.<PlainHTMLTable>addFill(it, _doubleArrow);
          FieldLabel _asWidget = PMDefaultIntervalAssociationForm.this.description.asWidget();
          final Procedure1<FieldLabel> _function_1 = new Procedure1<FieldLabel>() {
              public void apply(final FieldLabel it) {
                it.setHeight(300);
              }
            };
          FieldLabel _doubleArrow_1 = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget, _function_1);
          WidgetExtensions.<FieldLabel>addFill(it, _doubleArrow_1);
        }
      };
    VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
    return _doubleArrow;
  }
}
