package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverOrganizationProxy;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.web.client.organization.AllDeliverEmployeeContentProvider;
import com.fudanmed.platform.core.web.client.organization.AllDeliverOrganizationContentProvider;
import com.fudanmed.platform.core.web.shared.deliver.DeliverTaskDispatchData;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.ComboBoxSelector;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectsSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DualListMultiSelector;
import edu.fudan.langlab.gxt.client.widget.HTMLTagsExt;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTD;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTR;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTable;
import edu.fudan.langlab.gxt.client.widget.WidgetExtensions;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DeliverTaskDispatchDataForm extends GXTFormComponent<DeliverTaskDispatchData> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public ComboBoxSelector<DLDeliverOrganizationProxy> deliverOrg;
  
  @Inject
  public AllDeliverOrganizationContentProvider deliverOrgContentProvider;
  
  public DualListMultiSelector<RCEmployeeProxy> haulier;
  
  @Inject
  public AllDeliverEmployeeContentProvider haulierContentProvider;
  
  @Inject
  private DefaultObjectsSelectorFactory defaultObjectsSelectorFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  private DeliverTaskDispatchData value = new DeliverTaskDispatchData();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();deliverOrg = defaultObjectSelectorFactory.createAsComboBoxItem("deliverOrg","运送部门");
    _initializerSupports.add(deliverOrgContentProvider);
    deliverOrg.setContentProvider(deliverOrgContentProvider);
    widgetsRegistory.put("deliverOrg",deliverOrg);
    haulier = defaultObjectsSelectorFactory.createAsRequiredDualListItem("haulier","派送人员");
    haulier.setContentProvider(haulierContentProvider);
    widgetsRegistory.put("haulier",haulier);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public DeliverTaskDispatchData getValueAsNew() {
    DeliverTaskDispatchData value = new DeliverTaskDispatchData();
    value.setDeliverOrg(deliverOrg.getValue());
    value.setHaulier(haulier.getValue());
    return value;
  }
  
  public DeliverTaskDispatchData doGetValue() {
    
    value.setDeliverOrg(deliverOrg.getValue());
    value.setHaulier(haulier.getValue());
    return value;
  }
  
  public DeliverTaskDispatchData getValue(final DeliverTaskDispatchData copyValue) {
    
    copyValue.setDeliverOrg(deliverOrg.getValue());
    copyValue.setHaulier(haulier.getValue());
    return copyValue;
  }
  
  protected DeliverTaskDispatchDataForm doSetValue(final DeliverTaskDispatchData value) {
    this.value = value;
    deliverOrg.setValue(value.getDeliverOrg());
    haulier.setValue(value.getHaulier());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)deliverOrg,(ICanAsWidget)haulier
    					);
  }
  
  public Widget createWidget() {
    VerticalLayoutContainer _VLayout = this.widgets.VLayout();
    final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
        public void apply(final VerticalLayoutContainer it) {
          FieldLabel _asWidget = DeliverTaskDispatchDataForm.this.deliverOrg.asWidget();
          it.add(_asWidget);
          PlainHTMLTable _TABLE = HTMLTagsExt.TABLE();
          final Procedure1<PlainHTMLTable> _function = new Procedure1<PlainHTMLTable>() {
              public void apply(final PlainHTMLTable it) {
                PlainHTMLTR _tr = HTMLTagsExt.tr(it);
                final Procedure1<PlainHTMLTR> _function = new Procedure1<PlainHTMLTR>() {
                    public void apply(final PlainHTMLTR it) {
                      PlainHTMLTD _td = HTMLTagsExt.td(it);
                      final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                          public void apply(final PlainHTMLTD it) {
                            it.setColSpan(2);
                            FieldLabel _asWidget = DeliverTaskDispatchDataForm.this.haulier.asWidget();
                            final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                                public void apply(final FieldLabel it) {
                                  it.setWidth(500);
                                }
                              };
                            FieldLabel _doubleArrow = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget, _function);
                            ClientUi.operator_add(it, _doubleArrow);
                          }
                        };
                      ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
                    }
                  };
                ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr, _function);
              }
            };
          PlainHTMLTable _doubleArrow = ObjectExtensions.<PlainHTMLTable>operator_doubleArrow(_TABLE, _function);
          WidgetExtensions.<PlainHTMLTable>addFill(it, _doubleArrow);
          final Procedure1<DLDeliverOrganizationProxy> _function_1 = new Procedure1<DLDeliverOrganizationProxy>() {
              public void apply(final DLDeliverOrganizationProxy it) {
                final Procedure1<Void> _function = new Procedure1<Void>() {
                    public void apply(final Void it) {
                    }
                  };
                DeliverTaskDispatchDataForm.this.haulierContentProvider.load(it, _function);
              }
            };
          DeliverTaskDispatchDataForm.this.deliverOrg.addValueChangedListener(new ValueChangedListener<DLDeliverOrganizationProxy>() {
              public void onValueChanged(DLDeliverOrganizationProxy value) {
                _function_1.apply(value);
              }
          });
        }
      };
    VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
    return _doubleArrow;
  }
}
