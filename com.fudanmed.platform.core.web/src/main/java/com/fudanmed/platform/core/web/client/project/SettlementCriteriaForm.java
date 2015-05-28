package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.shared.project.UISettlementCriteria;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class SettlementCriteriaForm extends GXTFormComponent<UISettlementCriteria> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  private UISettlementCriteria value = new UISettlementCriteria();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UISettlementCriteria getValueAsNew() {
    UISettlementCriteria value = new UISettlementCriteria();
    return value;
  }
  
  public UISettlementCriteria doGetValue() {
    
    return value;
  }
  
  public UISettlementCriteria getValue(final UISettlementCriteria copyValue) {
    
    return copyValue;
  }
  
  protected SettlementCriteriaForm doSetValue(final UISettlementCriteria value) {
    this.value = value;
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					);
  }
}
