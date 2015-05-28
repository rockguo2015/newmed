package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.shared.project.UIRepairEvaluate;
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
import edu.fudan.langlab.gxt.client.component.form.factory.IntegerValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.IntegerValueProviderFactory.ScoreItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextAreaItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class RepairEvaluateForm extends GXTFormComponent<UIRepairEvaluate> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public ScoreItem arrivalTimeValue;
  
  public ScoreItem serviceAttitudeValue;
  
  public ScoreItem frequencyProblemValue;
  
  public ScoreItem repairQualityValue;
  
  public TextAreaItem comment;
  
  @Inject
  private IntegerValueProviderFactory integerValueProviderFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIRepairEvaluate value = new UIRepairEvaluate();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();arrivalTimeValue = integerValueProviderFactory.createAsScoreItem("arrivalTimeValue","到达及时性",Integer.valueOf(5));
    widgetsRegistory.put("arrivalTimeValue",arrivalTimeValue);
    serviceAttitudeValue = integerValueProviderFactory.createAsScoreItem("serviceAttitudeValue","服务态度",Integer.valueOf(5));
    widgetsRegistory.put("serviceAttitudeValue",serviceAttitudeValue);
    frequencyProblemValue = integerValueProviderFactory.createAsScoreItem("frequencyProblemValue","同一问题频率",Integer.valueOf(5));
    widgetsRegistory.put("frequencyProblemValue",frequencyProblemValue);
    repairQualityValue = integerValueProviderFactory.createAsScoreItem("repairQualityValue","维修质量",Integer.valueOf(5));
    widgetsRegistory.put("repairQualityValue",repairQualityValue);
    comment = stringValueProviderFactory.createAsTextAreaItem("comment","评语");
    widgetsRegistory.put("comment",comment);
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
  
  public UIRepairEvaluate getValueAsNew() {
    UIRepairEvaluate value = new UIRepairEvaluate();
    value.setArrivalTimeValue(arrivalTimeValue.getValue());
    value.setServiceAttitudeValue(serviceAttitudeValue.getValue());
    value.setFrequencyProblemValue(frequencyProblemValue.getValue());
    value.setRepairQualityValue(repairQualityValue.getValue());
    value.setComment(comment.getValue());
    return value;
  }
  
  public UIRepairEvaluate doGetValue() {
    
    value.setArrivalTimeValue(arrivalTimeValue.getValue());
    value.setServiceAttitudeValue(serviceAttitudeValue.getValue());
    value.setFrequencyProblemValue(frequencyProblemValue.getValue());
    value.setRepairQualityValue(repairQualityValue.getValue());
    value.setComment(comment.getValue());
    return value;
  }
  
  public UIRepairEvaluate getValue(final UIRepairEvaluate copyValue) {
    
    copyValue.setArrivalTimeValue(arrivalTimeValue.getValue());
    copyValue.setServiceAttitudeValue(serviceAttitudeValue.getValue());
    copyValue.setFrequencyProblemValue(frequencyProblemValue.getValue());
    copyValue.setRepairQualityValue(repairQualityValue.getValue());
    copyValue.setComment(comment.getValue());
    return copyValue;
  }
  
  protected RepairEvaluateForm doSetValue(final UIRepairEvaluate value) {
    this.value = value;
    arrivalTimeValue.setValue(value.getArrivalTimeValue());
    serviceAttitudeValue.setValue(value.getServiceAttitudeValue());
    frequencyProblemValue.setValue(value.getFrequencyProblemValue());
    repairQualityValue.setValue(value.getRepairQualityValue());
    comment.setValue(value.getComment());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)arrivalTimeValue,(ICanAsWidget)serviceAttitudeValue,(ICanAsWidget)frequencyProblemValue,(ICanAsWidget)repairQualityValue,(ICanAsWidget)comment
    					);
  }
  
  public Widget asWidget() {
    final Function1<Void,VerticalLayoutContainer> _function = new Function1<Void,VerticalLayoutContainer>() {
        public VerticalLayoutContainer apply(final Void it) {
          VerticalLayoutContainer _VLayout = RepairEvaluateForm.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                RepairEvaluateForm.this.arrivalTimeValue.setValue(Integer.valueOf(4));
                RepairEvaluateForm.this.serviceAttitudeValue.setValue(Integer.valueOf(5));
                RepairEvaluateForm.this.frequencyProblemValue.setValue(Integer.valueOf(5));
                RepairEvaluateForm.this.repairQualityValue.setValue(Integer.valueOf(5));
                FieldLabel _asWidget = RepairEvaluateForm.this.arrivalTimeValue.asWidget();
                int _minus = (-1);
                VerticalLayoutData _VLayoutData = RepairEvaluateForm.this.widgets.VLayoutData(300, _minus);
                it.add(_asWidget, _VLayoutData);
                FieldLabel _asWidget_1 = RepairEvaluateForm.this.serviceAttitudeValue.asWidget();
                int _minus_1 = (-1);
                VerticalLayoutData _VLayoutData_1 = RepairEvaluateForm.this.widgets.VLayoutData(300, _minus_1);
                it.add(_asWidget_1, _VLayoutData_1);
                FieldLabel _asWidget_2 = RepairEvaluateForm.this.frequencyProblemValue.asWidget();
                int _minus_2 = (-1);
                VerticalLayoutData _VLayoutData_2 = RepairEvaluateForm.this.widgets.VLayoutData(300, _minus_2);
                it.add(_asWidget_2, _VLayoutData_2);
                FieldLabel _asWidget_3 = RepairEvaluateForm.this.repairQualityValue.asWidget();
                int _minus_3 = (-1);
                VerticalLayoutData _VLayoutData_3 = RepairEvaluateForm.this.widgets.VLayoutData(300, _minus_3);
                it.add(_asWidget_3, _VLayoutData_3);
                FieldLabel _asWidget_4 = RepairEvaluateForm.this.comment.asWidget();
                VerticalLayoutData _VLayoutData_4 = RepairEvaluateForm.this.widgets.VLayoutData(1, 160);
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
