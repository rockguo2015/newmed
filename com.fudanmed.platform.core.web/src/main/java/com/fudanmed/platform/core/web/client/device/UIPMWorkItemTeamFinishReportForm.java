package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.PMWorkItemEvaluateForm;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemEvaluate;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemTeamFinishReportData;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FieldSet;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueProvider;
import com.uniquesoft.gwt.shared.DateUtil;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory.DateItem;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextAreaItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.WidgetExtensions;
import java.util.Date;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class UIPMWorkItemTeamFinishReportForm extends GXTFormComponent<UIPMWorkItemTeamFinishReportData> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public DateItem finishDate;
  
  public TextAreaItem comment;
  
  public IValueProvider<UIPMWorkItemEvaluate> evaluate;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIPMWorkItemTeamFinishReportData value = new UIPMWorkItemTeamFinishReportData();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();finishDate = dateValueProviderFactory.createAsDateItem("finishDate","完成日期");
    widgetsRegistory.put("finishDate",finishDate);
    comment = stringValueProviderFactory.createAsTextAreaItem("comment","上报信息");
    widgetsRegistory.put("comment",comment);
    evaluate = defaultObjectSelectorFactory.createAsDelegateItem("evaluate","服务评价",this.evaluateForm);
    widgetsRegistory.put("evaluate",evaluate);
    if(evaluateForm instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
    							_initializerSupports.add((com.uniquesoft.gwt.client.common.async.IInitializerSupport)evaluateForm);
    						}IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIPMWorkItemTeamFinishReportData getValueAsNew() {
    UIPMWorkItemTeamFinishReportData value = new UIPMWorkItemTeamFinishReportData();
    value.setFinishDate(finishDate.getValue());
    value.setComment(comment.getValue());
    value.setEvaluate(evaluate.getValue());
    return value;
  }
  
  public UIPMWorkItemTeamFinishReportData doGetValue() {
    
    value.setFinishDate(finishDate.getValue());
    value.setComment(comment.getValue());
    value.setEvaluate(evaluate.getValue());
    return value;
  }
  
  public UIPMWorkItemTeamFinishReportData getValue(final UIPMWorkItemTeamFinishReportData copyValue) {
    
    copyValue.setFinishDate(finishDate.getValue());
    copyValue.setComment(comment.getValue());
    copyValue.setEvaluate(evaluate.getValue());
    return copyValue;
  }
  
  protected UIPMWorkItemTeamFinishReportForm doSetValue(final UIPMWorkItemTeamFinishReportData value) {
    this.value = value;
    finishDate.setValue(value.getFinishDate());
    comment.setValue(value.getComment());
    evaluate.setValue(value.getEvaluate());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)finishDate,(ICanAsWidget)comment,(ICanAsWidget)evaluate
    					);
  }
  
  public Widget createWidget() {
    VerticalLayoutContainer _VLayout = this.widgets.VLayout();
    final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
        public void apply(final VerticalLayoutContainer it) {
          FieldLabel _asWidget = UIPMWorkItemTeamFinishReportForm.this.finishDate.asWidget();
          final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
              public void apply(final FieldLabel it) {
                Date _day = DateUtil.today();
                UIPMWorkItemTeamFinishReportForm.this.finishDate.setValue(_day);
              }
            };
          FieldLabel _doubleArrow = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget, _function);
          WidgetExtensions.<FieldLabel>addFill(it, _doubleArrow);
          FieldLabel _asWidget_1 = UIPMWorkItemTeamFinishReportForm.this.comment.asWidget();
          final Procedure1<FieldLabel> _function_1 = new Procedure1<FieldLabel>() {
              public void apply(final FieldLabel it) {
                it.setHeight(80);
              }
            };
          FieldLabel _doubleArrow_1 = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget_1, _function_1);
          WidgetExtensions.<FieldLabel>addFill(it, _doubleArrow_1);
          FieldSet _FieldSet = UIPMWorkItemTeamFinishReportForm.this.widgets.FieldSet("\u670D\u52A1\u8BC4\u4EF7");
          final Procedure1<FieldSet> _function_2 = new Procedure1<FieldSet>() {
              public void apply(final FieldSet it) {
                Widget _asWidget = UIPMWorkItemTeamFinishReportForm.this.evaluateForm.asWidget();
                it.setWidget(_asWidget);
              }
            };
          FieldSet _doubleArrow_2 = ObjectExtensions.<FieldSet>operator_doubleArrow(_FieldSet, _function_2);
          WidgetExtensions.<FieldSet>addFill(it, _doubleArrow_2);
        }
      };
    VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
    return _doubleArrow;
  }
  
  @Inject
  private PMWorkItemEvaluateForm evaluateForm;
}
