package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLCheckOrganizationProxy;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverPatientCheckType;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectsSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectsSelectorFactory.CollectionListColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.IntegerValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.IntegerValueProviderFactory.IntegerColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class DeliverPatientCheckTypeListGrid extends GXTGridComponent<UIDeliverPatientCheckType> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIDeliverPatientCheckType> code;
  
  public StringColumn<UIDeliverPatientCheckType> name;
  
  public IntegerColumn<UIDeliverPatientCheckType> performence;
  
  public IntegerColumn<UIDeliverPatientCheckType> timeLimitation;
  
  public CollectionListColumn<UIDeliverPatientCheckType,DLCheckOrganizationProxy> checkOrganization;
  
  public StringColumn<UIDeliverPatientCheckType> comment;
  
  @Inject
  private DefaultObjectsSelectorFactory defaultObjectsSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  @Inject
  private IntegerValueProviderFactory integerValueProviderFactory;
  
  private UIDeliverPatientCheckType value = new UIDeliverPatientCheckType();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();code = stringValueProviderFactory.createAsStringColumn("code","代码",UIDeliverPatientCheckType.CodeAccessor);
    widgetsRegistory.put("code",code);
    name = stringValueProviderFactory.createAsStringColumn("name","名称",UIDeliverPatientCheckType.NameAccessor);
    widgetsRegistory.put("name",name);
    performence = integerValueProviderFactory.createAsIntegerColumn("performence","绩效系数",UIDeliverPatientCheckType.PerformenceAccessor);
    widgetsRegistory.put("performence",performence);
    timeLimitation = integerValueProviderFactory.createAsIntegerColumn("timeLimitation","时间限制(分钟)",UIDeliverPatientCheckType.TimeLimitationAccessor);
    widgetsRegistory.put("timeLimitation",timeLimitation);
    checkOrganization = defaultObjectsSelectorFactory.createAsStringColumn("checkOrganization","检查科室",UIDeliverPatientCheckType.CheckOrganizationAccessor);
    widgetsRegistory.put("checkOrganization",checkOrganization);
    comment = stringValueProviderFactory.createAsStringColumn("comment","特殊要求",UIDeliverPatientCheckType.CommentAccessor);
    widgetsRegistory.put("comment",comment);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIDeliverPatientCheckType getValueAsNew() {
    UIDeliverPatientCheckType value = new UIDeliverPatientCheckType();
    value.setCode(code.getValue());
    value.setName(name.getValue());
    value.setPerformence(performence.getValue());
    value.setTimeLimitation(timeLimitation.getValue());
    value.setCheckOrganization(checkOrganization.getValue());
    value.setComment(comment.getValue());
    return value;
  }
  
  public UIDeliverPatientCheckType doGetValue() {
    
    value.setCode(code.getValue());
    value.setName(name.getValue());
    value.setPerformence(performence.getValue());
    value.setTimeLimitation(timeLimitation.getValue());
    value.setCheckOrganization(checkOrganization.getValue());
    value.setComment(comment.getValue());
    return value;
  }
  
  public UIDeliverPatientCheckType getValue(final UIDeliverPatientCheckType copyValue) {
    
    copyValue.setCode(code.getValue());
    copyValue.setName(name.getValue());
    copyValue.setPerformence(performence.getValue());
    copyValue.setTimeLimitation(timeLimitation.getValue());
    copyValue.setCheckOrganization(checkOrganization.getValue());
    copyValue.setComment(comment.getValue());
    return copyValue;
  }
  
  protected DeliverPatientCheckTypeListGrid doSetValue(final UIDeliverPatientCheckType value) {
    this.value = value;
    code.setValue(value.getCode());
    name.setValue(value.getName());
    performence.setValue(value.getPerformence());
    timeLimitation.setValue(value.getTimeLimitation());
    checkOrganization.setValue(value.getCheckOrganization());
    comment.setValue(value.getComment());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)code,(ICanAsWidget)name,(ICanAsWidget)performence,(ICanAsWidget)timeLimitation,(ICanAsWidget)checkOrganization,(ICanAsWidget)comment
    					);
  }
}
