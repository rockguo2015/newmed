package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.shared.project.WorkItemMisDispatchingData;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.BooleanValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.BooleanValueProviderFactory.CheckBoxItem;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory.DateItem;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory.TimeItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextAreaItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class WorkItemMisDispatchingDataForm extends GXTFormComponent<WorkItemMisDispatchingData> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public DateItem finishDate;
  
  public TimeItem finishTime;
  
  public TextAreaItem comment;
  
  public CheckBoxItem alsoReport;
  
  public TextAreaItem reportComment;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private BooleanValueProviderFactory booleanValueProviderFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private WorkItemMisDispatchingData value = new WorkItemMisDispatchingData();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();finishDate = dateValueProviderFactory.createAsDateItem("finishDate","完工[串单]日期");
    widgetsRegistory.put("finishDate",finishDate);
    finishTime = dateValueProviderFactory.createAsTimeItem("finishTime","完工[串单]时间");
    widgetsRegistory.put("finishTime",finishTime);
    comment = stringValueProviderFactory.createAsTextAreaItem("comment","维修说明");
    widgetsRegistory.put("comment",comment);
    alsoReport = booleanValueProviderFactory.createAsCheckBoxItem("alsoReport","串单上报");
    widgetsRegistory.put("alsoReport",alsoReport);
    reportComment = stringValueProviderFactory.createAsTextAreaItem("reportComment","上报信息");
    widgetsRegistory.put("reportComment",reportComment);
    if(con instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
    							_initializerSupports.add((com.uniquesoft.gwt.client.common.async.IInitializerSupport)con);
    						}IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public WorkItemMisDispatchingData getValueAsNew() {
    WorkItemMisDispatchingData value = new WorkItemMisDispatchingData();
    value.setFinishDate(finishDate.getValue());
    value.setFinishTime(finishTime.getValue());
    value.setComment(comment.getValue());
    value.setAlsoReport(alsoReport.getValue());
    value.setReportComment(reportComment.getValue());
    return value;
  }
  
  public WorkItemMisDispatchingData doGetValue() {
    
    value.setFinishDate(finishDate.getValue());
    value.setFinishTime(finishTime.getValue());
    value.setComment(comment.getValue());
    value.setAlsoReport(alsoReport.getValue());
    value.setReportComment(reportComment.getValue());
    return value;
  }
  
  public WorkItemMisDispatchingData getValue(final WorkItemMisDispatchingData copyValue) {
    
    copyValue.setFinishDate(finishDate.getValue());
    copyValue.setFinishTime(finishTime.getValue());
    copyValue.setComment(comment.getValue());
    copyValue.setAlsoReport(alsoReport.getValue());
    copyValue.setReportComment(reportComment.getValue());
    return copyValue;
  }
  
  protected WorkItemMisDispatchingDataForm doSetValue(final WorkItemMisDispatchingData value) {
    this.value = value;
    finishDate.setValue(value.getFinishDate());
    finishTime.setValue(value.getFinishTime());
    comment.setValue(value.getComment());
    alsoReport.setValue(value.getAlsoReport());
    reportComment.setValue(value.getReportComment());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)finishDate,(ICanAsWidget)finishTime,(ICanAsWidget)comment,(ICanAsWidget)alsoReport,(ICanAsWidget)reportComment
    					);
  }
  
  public Widget asWidget() {
    final Function1<Void,VerticalLayoutContainer> _function = new Function1<Void,VerticalLayoutContainer>() {
        public VerticalLayoutContainer apply(final Void it) {
          VerticalLayoutContainer _VLayout = WorkItemMisDispatchingDataForm.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                FieldLabel _asWidget = WorkItemMisDispatchingDataForm.this.finishDate.asWidget();
                int _minus = (-1);
                VerticalLayoutData _VLayoutData = WorkItemMisDispatchingDataForm.this.widgets.VLayoutData(1, _minus);
                it.add(_asWidget, _VLayoutData);
                FieldLabel _asWidget_1 = WorkItemMisDispatchingDataForm.this.finishTime.asWidget();
                int _minus_1 = (-1);
                VerticalLayoutData _VLayoutData_1 = WorkItemMisDispatchingDataForm.this.widgets.VLayoutData(1, _minus_1);
                it.add(_asWidget_1, _VLayoutData_1);
                FieldLabel _asWidget_2 = WorkItemMisDispatchingDataForm.this.comment.asWidget();
                VerticalLayoutData _VLayoutData_2 = WorkItemMisDispatchingDataForm.this.widgets.VLayoutData(366, 80);
                it.add(_asWidget_2, _VLayoutData_2);
                FieldLabel _asWidget_3 = WorkItemMisDispatchingDataForm.this.alsoReport.asWidget();
                int _minus_2 = (-1);
                VerticalLayoutData _VLayoutData_3 = WorkItemMisDispatchingDataForm.this.widgets.VLayoutData(120, _minus_2);
                it.add(_asWidget_3, _VLayoutData_3);
                FieldLabel _asWidget_4 = WorkItemMisDispatchingDataForm.this.reportComment.asWidget();
                VerticalLayoutData _VLayoutData_4 = WorkItemMisDispatchingDataForm.this.widgets.VLayoutData(366, 80);
                it.add(_asWidget_4, _VLayoutData_4);
              }
            };
          VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
          return _doubleArrow;
        }
      };
    Widget _lazy = ClientUi.<Widget>lazy(this.con, _function);
    Widget _con = this.con = _lazy;
    return _con;
  }
  
  private Widget con;
}
