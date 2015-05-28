package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.shared.project.WorkItemCancelPendData;
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
import edu.fudan.langlab.gxt.client.component.form.factory.DoubleValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DoubleValueProviderFactory.DoubleItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextAreaItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class WorkItemCancelPendDataForm extends GXTFormComponent<WorkItemCancelPendData> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public DateItem finishDate;
  
  public TimeItem finishTime;
  
  public TextAreaItem comment;
  
  public CheckBoxItem alsoReport;
  
  public TextAreaItem reportComment;
  
  public TextItem deviceSid;
  
  public DoubleItem price;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private DoubleValueProviderFactory doubleValueProviderFactory;
  
  @Inject
  private BooleanValueProviderFactory booleanValueProviderFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private WorkItemCancelPendData value = new WorkItemCancelPendData();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();finishDate = dateValueProviderFactory.createAsDateItem("finishDate","完工日期");
    widgetsRegistory.put("finishDate",finishDate);
    finishTime = dateValueProviderFactory.createAsTimeItem("finishTime","完工时间");
    widgetsRegistory.put("finishTime",finishTime);
    comment = stringValueProviderFactory.createAsTextAreaItem("comment","维修说明");
    widgetsRegistory.put("comment",comment);
    alsoReport = booleanValueProviderFactory.createAsCheckBoxItem("alsoReport","完工上报");
    widgetsRegistory.put("alsoReport",alsoReport);
    reportComment = stringValueProviderFactory.createAsTextAreaItem("reportComment","上报信息");
    widgetsRegistory.put("reportComment",reportComment);
    deviceSid = stringValueProviderFactory.createAsTextItem("deviceSid","设备编号");
    widgetsRegistory.put("deviceSid",deviceSid);
    price = doubleValueProviderFactory.createAsDoubleItem("price","工时费");
    widgetsRegistory.put("price",price);
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
  
  public WorkItemCancelPendData getValueAsNew() {
    WorkItemCancelPendData value = new WorkItemCancelPendData();
    value.setFinishDate(finishDate.getValue());
    value.setFinishTime(finishTime.getValue());
    value.setComment(comment.getValue());
    value.setAlsoReport(alsoReport.getValue());
    value.setReportComment(reportComment.getValue());
    value.setDeviceSid(deviceSid.getValue());
    value.setPrice(price.getValue());
    return value;
  }
  
  public WorkItemCancelPendData doGetValue() {
    
    value.setFinishDate(finishDate.getValue());
    value.setFinishTime(finishTime.getValue());
    value.setComment(comment.getValue());
    value.setAlsoReport(alsoReport.getValue());
    value.setReportComment(reportComment.getValue());
    value.setDeviceSid(deviceSid.getValue());
    value.setPrice(price.getValue());
    return value;
  }
  
  public WorkItemCancelPendData getValue(final WorkItemCancelPendData copyValue) {
    
    copyValue.setFinishDate(finishDate.getValue());
    copyValue.setFinishTime(finishTime.getValue());
    copyValue.setComment(comment.getValue());
    copyValue.setAlsoReport(alsoReport.getValue());
    copyValue.setReportComment(reportComment.getValue());
    copyValue.setDeviceSid(deviceSid.getValue());
    copyValue.setPrice(price.getValue());
    return copyValue;
  }
  
  protected WorkItemCancelPendDataForm doSetValue(final WorkItemCancelPendData value) {
    this.value = value;
    finishDate.setValue(value.getFinishDate());
    finishTime.setValue(value.getFinishTime());
    comment.setValue(value.getComment());
    alsoReport.setValue(value.getAlsoReport());
    reportComment.setValue(value.getReportComment());
    deviceSid.setValue(value.getDeviceSid());
    price.setValue(value.getPrice());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)finishDate,(ICanAsWidget)finishTime,(ICanAsWidget)comment,(ICanAsWidget)alsoReport,(ICanAsWidget)reportComment,(ICanAsWidget)deviceSid,(ICanAsWidget)price
    					);
  }
  
  public Widget asWidget() {
    final Function1<Void,VerticalLayoutContainer> _function = new Function1<Void,VerticalLayoutContainer>() {
        public VerticalLayoutContainer apply(final Void it) {
          VerticalLayoutContainer _VLayout = WorkItemCancelPendDataForm.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                FieldLabel _asWidget = WorkItemCancelPendDataForm.this.finishDate.asWidget();
                int _minus = (-1);
                VerticalLayoutData _VLayoutData = WorkItemCancelPendDataForm.this.widgets.VLayoutData(1, _minus);
                it.add(_asWidget, _VLayoutData);
                FieldLabel _asWidget_1 = WorkItemCancelPendDataForm.this.finishTime.asWidget();
                int _minus_1 = (-1);
                VerticalLayoutData _VLayoutData_1 = WorkItemCancelPendDataForm.this.widgets.VLayoutData(1, _minus_1);
                it.add(_asWidget_1, _VLayoutData_1);
                FieldLabel _asWidget_2 = WorkItemCancelPendDataForm.this.deviceSid.asWidget();
                int _minus_2 = (-1);
                VerticalLayoutData _VLayoutData_2 = WorkItemCancelPendDataForm.this.widgets.VLayoutData(1, _minus_2);
                it.add(_asWidget_2, _VLayoutData_2);
                FieldLabel _asWidget_3 = WorkItemCancelPendDataForm.this.price.asWidget();
                int _minus_3 = (-1);
                VerticalLayoutData _VLayoutData_3 = WorkItemCancelPendDataForm.this.widgets.VLayoutData(1, _minus_3);
                it.add(_asWidget_3, _VLayoutData_3);
                FieldLabel _asWidget_4 = WorkItemCancelPendDataForm.this.comment.asWidget();
                VerticalLayoutData _VLayoutData_4 = WorkItemCancelPendDataForm.this.widgets.VLayoutData(366, 80);
                it.add(_asWidget_4, _VLayoutData_4);
                FieldLabel _asWidget_5 = WorkItemCancelPendDataForm.this.alsoReport.asWidget();
                int _minus_4 = (-1);
                VerticalLayoutData _VLayoutData_5 = WorkItemCancelPendDataForm.this.widgets.VLayoutData(120, _minus_4);
                it.add(_asWidget_5, _VLayoutData_5);
                FieldLabel _asWidget_6 = WorkItemCancelPendDataForm.this.reportComment.asWidget();
                VerticalLayoutData _VLayoutData_6 = WorkItemCancelPendDataForm.this.widgets.VLayoutData(366, 80);
                it.add(_asWidget_6, _VLayoutData_6);
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
