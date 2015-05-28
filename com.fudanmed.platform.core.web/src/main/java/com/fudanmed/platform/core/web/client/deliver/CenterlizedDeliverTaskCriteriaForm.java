package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.web.client.deliver.UITaskSourceTypeContentProvider;
import com.fudanmed.platform.core.web.client.organization.AllEmployeesAsyncContentProvider;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTaskCriteria;
import com.fudanmed.platform.core.web.shared.deliver.UITaskSourceType;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory.DateItem;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.RadioButtonSelector;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;
import edu.fudan.langlab.gxt.client.component.form.factory.SuggestionComboBoxSelector;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class CenterlizedDeliverTaskCriteriaForm extends GXTFormComponent<UICenterlizedDeliverTaskCriteria> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public TextItem sid;
  
  public DateItem createTimeFrom;
  
  public DateItem createTimeTo;
  
  public SuggestionComboBoxSelector<RCEmployeeProxy> performer;
  
  @Inject
  public AllEmployeesAsyncContentProvider performerContentProvider;
  
  public RadioButtonSelector<UITaskSourceType> taskSourceType;
  
  @Inject
  public UITaskSourceTypeContentProvider taskSourceTypeContentProvider;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UICenterlizedDeliverTaskCriteria value = new UICenterlizedDeliverTaskCriteria();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();sid = stringValueProviderFactory.createAsTextItem("sid","任务编号");
    widgetsRegistory.put("sid",sid);
    createTimeFrom = dateValueProviderFactory.createAsDateItem("createTimeFrom","开始时间");
    widgetsRegistory.put("createTimeFrom",createTimeFrom);
    createTimeTo = dateValueProviderFactory.createAsDateItem("createTimeTo","结束时间");
    widgetsRegistory.put("createTimeTo",createTimeTo);
    performer = defaultObjectSelectorFactory.createAsSuggestionItem("performer","运送人");
    performer.setContentProvider(performerContentProvider);
    widgetsRegistory.put("performer",performer);
    taskSourceType = defaultObjectSelectorFactory.createAsRadioGroupItem("taskSourceType","任务来源");
    taskSourceType.setContentProvider(taskSourceTypeContentProvider);
    widgetsRegistory.put("taskSourceType",taskSourceType);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UICenterlizedDeliverTaskCriteria getValueAsNew() {
    UICenterlizedDeliverTaskCriteria value = new UICenterlizedDeliverTaskCriteria();
    value.setSid(sid.getValue());
    value.setCreateTimeFrom(createTimeFrom.getValue());
    value.setCreateTimeTo(createTimeTo.getValue());
    value.setPerformer(performer.getValue());
    value.setTaskSourceType(taskSourceType.getValue());
    return value;
  }
  
  public UICenterlizedDeliverTaskCriteria doGetValue() {
    
    value.setSid(sid.getValue());
    value.setCreateTimeFrom(createTimeFrom.getValue());
    value.setCreateTimeTo(createTimeTo.getValue());
    value.setPerformer(performer.getValue());
    value.setTaskSourceType(taskSourceType.getValue());
    return value;
  }
  
  public UICenterlizedDeliverTaskCriteria getValue(final UICenterlizedDeliverTaskCriteria copyValue) {
    
    copyValue.setSid(sid.getValue());
    copyValue.setCreateTimeFrom(createTimeFrom.getValue());
    copyValue.setCreateTimeTo(createTimeTo.getValue());
    copyValue.setPerformer(performer.getValue());
    copyValue.setTaskSourceType(taskSourceType.getValue());
    return copyValue;
  }
  
  protected CenterlizedDeliverTaskCriteriaForm doSetValue(final UICenterlizedDeliverTaskCriteria value) {
    this.value = value;
    sid.setValue(value.getSid());
    createTimeFrom.setValue(value.getCreateTimeFrom());
    createTimeTo.setValue(value.getCreateTimeTo());
    performer.setValue(value.getPerformer());
    taskSourceType.setValue(value.getTaskSourceType());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)sid,(ICanAsWidget)createTimeFrom,(ICanAsWidget)createTimeTo,(ICanAsWidget)performer,(ICanAsWidget)taskSourceType
    					);
  }
}
