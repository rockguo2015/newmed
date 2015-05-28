package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLCheckOrganizationProxy;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckCategoryProxy;
import com.fudanmed.platform.core.web.client.deliver.CheckOrganizationContentProvider;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverPatientCheckType;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectsSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DualListMultiSelector;
import edu.fudan.langlab.gxt.client.component.form.factory.IntegerValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.IntegerValueProviderFactory.IntegerItem;
import edu.fudan.langlab.gxt.client.component.form.factory.ReadonlyItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextAreaItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.WidgetExtensions;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DeliverPatientCheckTypeForm extends GXTFormComponent<UIDeliverPatientCheckType> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public ReadonlyItem<DLDeliverPatientCheckCategoryProxy> category;
  
  public TextItem code;
  
  public TextItem name;
  
  public IntegerItem performence;
  
  public IntegerItem timeLimitation;
  
  public DualListMultiSelector<DLCheckOrganizationProxy> checkOrganization;
  
  @Inject
  public CheckOrganizationContentProvider checkOrganizationContentProvider;
  
  public TextAreaItem comment;
  
  @Inject
  private IntegerValueProviderFactory integerValueProviderFactory;
  
  @Inject
  private DefaultObjectsSelectorFactory defaultObjectsSelectorFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIDeliverPatientCheckType value = new UIDeliverPatientCheckType();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();category = defaultObjectSelectorFactory.createAsReadonlyItem("category","类别");
    widgetsRegistory.put("category",category);
    code = stringValueProviderFactory.createAsTextItem("code","代码");
    widgetsRegistory.put("code",code);
    name = stringValueProviderFactory.createAsTextItem("name","名称");
    widgetsRegistory.put("name",name);
    performence = integerValueProviderFactory.createAsIntegerItem("performence","绩效系数");
    widgetsRegistory.put("performence",performence);
    timeLimitation = integerValueProviderFactory.createAsIntegerItem("timeLimitation","时间限制(分钟)");
    widgetsRegistory.put("timeLimitation",timeLimitation);
    checkOrganization = defaultObjectsSelectorFactory.createAsDualListItem("checkOrganization","检查科室");
    _initializerSupports.add(checkOrganizationContentProvider);
    checkOrganization.setContentProvider(checkOrganizationContentProvider);
    widgetsRegistory.put("checkOrganization",checkOrganization);
    comment = stringValueProviderFactory.createAsTextAreaItem("comment","特殊要求");
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
    value.setCategory(category.getValue());
    value.setCode(code.getValue());
    value.setName(name.getValue());
    value.setPerformence(performence.getValue());
    value.setTimeLimitation(timeLimitation.getValue());
    value.setCheckOrganization(checkOrganization.getValue());
    value.setComment(comment.getValue());
    return value;
  }
  
  public UIDeliverPatientCheckType doGetValue() {
    
    value.setCategory(category.getValue());
    value.setCode(code.getValue());
    value.setName(name.getValue());
    value.setPerformence(performence.getValue());
    value.setTimeLimitation(timeLimitation.getValue());
    value.setCheckOrganization(checkOrganization.getValue());
    value.setComment(comment.getValue());
    return value;
  }
  
  public UIDeliverPatientCheckType getValue(final UIDeliverPatientCheckType copyValue) {
    
    copyValue.setCategory(category.getValue());
    copyValue.setCode(code.getValue());
    copyValue.setName(name.getValue());
    copyValue.setPerformence(performence.getValue());
    copyValue.setTimeLimitation(timeLimitation.getValue());
    copyValue.setCheckOrganization(checkOrganization.getValue());
    copyValue.setComment(comment.getValue());
    return copyValue;
  }
  
  protected DeliverPatientCheckTypeForm doSetValue(final UIDeliverPatientCheckType value) {
    this.value = value;
    category.setValue(value.getCategory());
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
    					(ICanAsWidget)category,(ICanAsWidget)code,(ICanAsWidget)name,(ICanAsWidget)performence,(ICanAsWidget)timeLimitation,(ICanAsWidget)checkOrganization,(ICanAsWidget)comment
    					);
  }
  
  public Widget createWidget() {
    VerticalLayoutContainer _VLayout = this.widgets.VLayout();
    final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
        public void apply(final VerticalLayoutContainer it) {
          FieldLabel _asWidget = DeliverPatientCheckTypeForm.this.category.asWidget();
          WidgetExtensions.<FieldLabel>addFill(it, _asWidget);
          FieldLabel _asWidget_1 = DeliverPatientCheckTypeForm.this.code.asWidget();
          WidgetExtensions.<FieldLabel>addFill(it, _asWidget_1);
          FieldLabel _asWidget_2 = DeliverPatientCheckTypeForm.this.name.asWidget();
          WidgetExtensions.<FieldLabel>addFill(it, _asWidget_2);
          FieldLabel _asWidget_3 = DeliverPatientCheckTypeForm.this.performence.asWidget();
          WidgetExtensions.<FieldLabel>addFill(it, _asWidget_3);
          FieldLabel _asWidget_4 = DeliverPatientCheckTypeForm.this.timeLimitation.asWidget();
          WidgetExtensions.<FieldLabel>addFill(it, _asWidget_4);
          FieldLabel _asWidget_5 = DeliverPatientCheckTypeForm.this.checkOrganization.asWidget();
          WidgetExtensions.<FieldLabel>addFill(it, _asWidget_5);
          FieldLabel _asWidget_6 = DeliverPatientCheckTypeForm.this.comment.asWidget();
          final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
              public void apply(final FieldLabel it) {
                it.setHeight(80);
              }
            };
          FieldLabel _doubleArrow = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget_6, _function);
          WidgetExtensions.<FieldLabel>addFill(it, _doubleArrow);
        }
      };
    VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
    return _doubleArrow;
  }
}
