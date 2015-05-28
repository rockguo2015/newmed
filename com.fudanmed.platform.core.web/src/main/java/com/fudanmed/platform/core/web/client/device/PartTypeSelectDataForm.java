package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.warehouse.AllProductSpecificationContentProvider;
import com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationListView;
import com.fudanmed.platform.core.web.shared.device.UIPartTypeSelectData;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.SuggestionComboBoxSelector;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.WidgetExtensions;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class PartTypeSelectDataForm extends GXTFormComponent<UIPartTypeSelectData> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public SuggestionComboBoxSelector<UIProductSpecification> productSpec;
  
  @Inject
  public AllProductSpecificationContentProvider productSpecContentProvider;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  private UIPartTypeSelectData value = new UIPartTypeSelectData();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();productSpec = defaultObjectSelectorFactory.createAsSuggestionItem("productSpec","备件类型",this.productSpecificationListView);
    productSpec.setContentProvider(productSpecContentProvider);
    widgetsRegistory.put("productSpec",productSpec);
    if(productSpecificationListView instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
    							_initializerSupports.add((com.uniquesoft.gwt.client.common.async.IInitializerSupport)productSpecificationListView);
    						}IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIPartTypeSelectData getValueAsNew() {
    UIPartTypeSelectData value = new UIPartTypeSelectData();
    value.setProductSpec(productSpec.getValue());
    return value;
  }
  
  public UIPartTypeSelectData doGetValue() {
    
    value.setProductSpec(productSpec.getValue());
    return value;
  }
  
  public UIPartTypeSelectData getValue(final UIPartTypeSelectData copyValue) {
    
    copyValue.setProductSpec(productSpec.getValue());
    return copyValue;
  }
  
  protected PartTypeSelectDataForm doSetValue(final UIPartTypeSelectData value) {
    this.value = value;
    productSpec.setValue(value.getProductSpec());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)productSpec
    					);
  }
  
  public Widget createWidget() {
    VerticalLayoutContainer _VLayout = this.widgets.VLayout();
    final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
        public void apply(final VerticalLayoutContainer it) {
          FieldLabel _asWidget = PartTypeSelectDataForm.this.productSpec.asWidget();
          WidgetExtensions.<FieldLabel>addFill(it, _asWidget);
        }
      };
    VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
    return _doubleArrow;
  }
  
  @Inject
  private ProductSpecificationListView productSpecificationListView;
}
