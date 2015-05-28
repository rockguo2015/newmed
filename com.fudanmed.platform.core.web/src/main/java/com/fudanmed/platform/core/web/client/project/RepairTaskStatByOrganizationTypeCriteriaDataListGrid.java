package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatByOrganizationTypeCriteriaData;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectSelectorFactory.StringValueColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class RepairTaskStatByOrganizationTypeCriteriaDataListGrid extends GXTGridComponent<UIRepairTaskStatByOrganizationTypeCriteriaData> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIRepairTaskStatByOrganizationTypeCriteriaData> fullPathReportOrg;
  
  public StringValueColumn<UIRepairTaskStatByOrganizationTypeCriteriaData,Long> cnt;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIRepairTaskStatByOrganizationTypeCriteriaData value = new UIRepairTaskStatByOrganizationTypeCriteriaData();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();fullPathReportOrg = stringValueProviderFactory.createAsStringColumn("fullPathReportOrg","报修部门",UIRepairTaskStatByOrganizationTypeCriteriaData.FullPathReportOrgAccessor);
    widgetsRegistory.put("fullPathReportOrg",fullPathReportOrg);
    cnt = defaultObjectSelectorFactory.createAsDefaultColumn("cnt","数量",UIRepairTaskStatByOrganizationTypeCriteriaData.CntAccessor,Integer.valueOf(60));
    widgetsRegistory.put("cnt",cnt);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIRepairTaskStatByOrganizationTypeCriteriaData getValueAsNew() {
    UIRepairTaskStatByOrganizationTypeCriteriaData value = new UIRepairTaskStatByOrganizationTypeCriteriaData();
    value.setFullPathReportOrg(fullPathReportOrg.getValue());
    value.setCnt(cnt.getValue());
    return value;
  }
  
  public UIRepairTaskStatByOrganizationTypeCriteriaData doGetValue() {
    
    value.setFullPathReportOrg(fullPathReportOrg.getValue());
    value.setCnt(cnt.getValue());
    return value;
  }
  
  public UIRepairTaskStatByOrganizationTypeCriteriaData getValue(final UIRepairTaskStatByOrganizationTypeCriteriaData copyValue) {
    
    copyValue.setFullPathReportOrg(fullPathReportOrg.getValue());
    copyValue.setCnt(cnt.getValue());
    return copyValue;
  }
  
  protected RepairTaskStatByOrganizationTypeCriteriaDataListGrid doSetValue(final UIRepairTaskStatByOrganizationTypeCriteriaData value) {
    this.value = value;
    fullPathReportOrg.setValue(value.getFullPathReportOrg());
    cnt.setValue(value.getCnt());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)fullPathReportOrg,(ICanAsWidget)cnt
    					);
  }
}
