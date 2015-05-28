package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.AllOrganizationContentProvider;
import com.fudanmed.platform.core.web.shared.project.UIReportCriteria;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.BooleanValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.BooleanValueProviderFactory.CheckBoxItem;
import edu.fudan.langlab.gxt.client.component.form.factory.ComboBoxSelector;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class ReportCriteriaForm extends GXTFormComponent<UIReportCriteria> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public TextItem comment;
  
  public CheckBoxItem includeFinishedTask4Reporter;
  
  public ComboBoxSelector<RCOrganizationProxy> reportOrg;
  
  @Inject
  public AllOrganizationContentProvider reportOrgContentProvider;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private BooleanValueProviderFactory booleanValueProviderFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIReportCriteria value = new UIReportCriteria();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();comment = stringValueProviderFactory.createAsTextItem("comment","报修信息关键字");
    widgetsRegistory.put("comment",comment);
    includeFinishedTask4Reporter = booleanValueProviderFactory.createAsCheckBoxItem("includeFinishedTask4Reporter","含已完工任务");
    widgetsRegistory.put("includeFinishedTask4Reporter",includeFinishedTask4Reporter);
    reportOrg = defaultObjectSelectorFactory.createAsComboBoxItem("reportOrg","reportOrg");
    _initializerSupports.add(reportOrgContentProvider);
    reportOrg.setContentProvider(reportOrgContentProvider);
    widgetsRegistory.put("reportOrg",reportOrg);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIReportCriteria getValueAsNew() {
    UIReportCriteria value = new UIReportCriteria();
    value.setComment(comment.getValue());
    value.setIncludeFinishedTask4Reporter(includeFinishedTask4Reporter.getValue());
    value.setReportOrg(reportOrg.getValue());
    return value;
  }
  
  public UIReportCriteria doGetValue() {
    
    value.setComment(comment.getValue());
    value.setIncludeFinishedTask4Reporter(includeFinishedTask4Reporter.getValue());
    value.setReportOrg(reportOrg.getValue());
    return value;
  }
  
  public UIReportCriteria getValue(final UIReportCriteria copyValue) {
    
    copyValue.setComment(comment.getValue());
    copyValue.setIncludeFinishedTask4Reporter(includeFinishedTask4Reporter.getValue());
    copyValue.setReportOrg(reportOrg.getValue());
    return copyValue;
  }
  
  protected ReportCriteriaForm doSetValue(final UIReportCriteria value) {
    this.value = value;
    comment.setValue(value.getComment());
    includeFinishedTask4Reporter.setValue(value.getIncludeFinishedTask4Reporter());
    reportOrg.setValue(value.getReportOrg());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)comment,(ICanAsWidget)includeFinishedTask4Reporter,(ICanAsWidget)reportOrg
    					);
  }
}
