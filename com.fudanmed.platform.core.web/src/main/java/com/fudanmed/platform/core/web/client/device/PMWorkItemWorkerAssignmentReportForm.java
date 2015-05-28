package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.PMWorkItemEvaluateForm;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemEvaluate;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemWorkerAssignment;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FieldSet;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.BooleanValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.BooleanValueProviderFactory.CheckBoxItem;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory.DateItem;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextAreaItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.WidgetExtensions;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class PMWorkItemWorkerAssignmentReportForm extends GXTFormComponent<UIPMWorkItemWorkerAssignment> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public DateItem finishDate;
  
  public TextAreaItem finalComment;
  
  public CheckBoxItem reportWorkItemFinish;
  
  public TextAreaItem workItemFinishComment;
  
  public IValueProvider<UIPMWorkItemEvaluate> evaluate;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private BooleanValueProviderFactory booleanValueProviderFactory;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIPMWorkItemWorkerAssignment value = new UIPMWorkItemWorkerAssignment();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();finishDate = dateValueProviderFactory.createAsDateItem("finishDate","完工日期");
    widgetsRegistory.put("finishDate",finishDate);
    finalComment = stringValueProviderFactory.createAsTextAreaItem("finalComment","完工说明");
    widgetsRegistory.put("finalComment",finalComment);
    reportWorkItemFinish = booleanValueProviderFactory.createAsCheckBoxItem("reportWorkItemFinish","完工上报");
    widgetsRegistory.put("reportWorkItemFinish",reportWorkItemFinish);
    workItemFinishComment = stringValueProviderFactory.createAsTextAreaItem("workItemFinishComment","上报信息");
    widgetsRegistory.put("workItemFinishComment",workItemFinishComment);
    evaluate = defaultObjectSelectorFactory.createAsDelegateItem("evaluate","服务评价",this.evaluateForm);
    widgetsRegistory.put("evaluate",evaluate);
    if(evaluateForm instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
    							_initializerSupports.add((com.uniquesoft.gwt.client.common.async.IInitializerSupport)evaluateForm);
    						}if(con instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
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
  
  public UIPMWorkItemWorkerAssignment getValueAsNew() {
    UIPMWorkItemWorkerAssignment value = new UIPMWorkItemWorkerAssignment();
    value.setFinishDate(finishDate.getValue());
    value.setFinalComment(finalComment.getValue());
    value.setReportWorkItemFinish(reportWorkItemFinish.getValue());
    value.setWorkItemFinishComment(workItemFinishComment.getValue());
    value.setEvaluate(evaluate.getValue());
    return value;
  }
  
  public UIPMWorkItemWorkerAssignment doGetValue() {
    
    value.setFinishDate(finishDate.getValue());
    value.setFinalComment(finalComment.getValue());
    value.setReportWorkItemFinish(reportWorkItemFinish.getValue());
    value.setWorkItemFinishComment(workItemFinishComment.getValue());
    value.setEvaluate(evaluate.getValue());
    return value;
  }
  
  public UIPMWorkItemWorkerAssignment getValue(final UIPMWorkItemWorkerAssignment copyValue) {
    
    copyValue.setFinishDate(finishDate.getValue());
    copyValue.setFinalComment(finalComment.getValue());
    copyValue.setReportWorkItemFinish(reportWorkItemFinish.getValue());
    copyValue.setWorkItemFinishComment(workItemFinishComment.getValue());
    copyValue.setEvaluate(evaluate.getValue());
    return copyValue;
  }
  
  protected PMWorkItemWorkerAssignmentReportForm doSetValue(final UIPMWorkItemWorkerAssignment value) {
    this.value = value;
    finishDate.setValue(value.getFinishDate());
    finalComment.setValue(value.getFinalComment());
    reportWorkItemFinish.setValue(value.getReportWorkItemFinish());
    workItemFinishComment.setValue(value.getWorkItemFinishComment());
    evaluate.setValue(value.getEvaluate());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)finishDate,(ICanAsWidget)finalComment,(ICanAsWidget)reportWorkItemFinish,(ICanAsWidget)workItemFinishComment,(ICanAsWidget)evaluate
    					);
  }
  
  public Widget asWidget() {
    final Function1<Void,VerticalLayoutContainer> _function = new Function1<Void,VerticalLayoutContainer>() {
        public VerticalLayoutContainer apply(final Void it) {
          VerticalLayoutContainer _VLayout = PMWorkItemWorkerAssignmentReportForm.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                FieldLabel _asWidget = PMWorkItemWorkerAssignmentReportForm.this.finishDate.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget);
                FieldLabel _asWidget_1 = PMWorkItemWorkerAssignmentReportForm.this.finalComment.asWidget();
                final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                    public void apply(final FieldLabel it) {
                      it.setHeight(80);
                    }
                  };
                FieldLabel _doubleArrow = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget_1, _function);
                WidgetExtensions.<FieldLabel>addFill(it, _doubleArrow);
                FieldLabel _asWidget_2 = PMWorkItemWorkerAssignmentReportForm.this.reportWorkItemFinish.asWidget();
                final Procedure1<FieldLabel> _function_1 = new Procedure1<FieldLabel>() {
                    public void apply(final FieldLabel it) {
                      final Procedure1<Boolean> _function = new Procedure1<Boolean>() {
                          public void apply(final Boolean it) {
                            PMWorkItemWorkerAssignmentReportForm.this.refreshWorkItemFinishStatus();
                          }
                        };
                      PMWorkItemWorkerAssignmentReportForm.this.reportWorkItemFinish.addValueChangedListener(new ValueChangedListener<Boolean>() {
                          public void onValueChanged(Boolean value) {
                            _function.apply(value);
                          }
                      });
                    }
                  };
                FieldLabel _doubleArrow_1 = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget_2, _function_1);
                WidgetExtensions.<FieldLabel>addFill(it, _doubleArrow_1);
                FieldLabel _asWidget_3 = PMWorkItemWorkerAssignmentReportForm.this.workItemFinishComment.asWidget();
                final Procedure1<FieldLabel> _function_2 = new Procedure1<FieldLabel>() {
                    public void apply(final FieldLabel it) {
                      it.setHeight(80);
                    }
                  };
                FieldLabel _doubleArrow_2 = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget_3, _function_2);
                WidgetExtensions.<FieldLabel>addFill(it, _doubleArrow_2);
                FieldSet _FieldSet = PMWorkItemWorkerAssignmentReportForm.this.widgets.FieldSet("\u670D\u52A1\u8BC4\u4EF7");
                final Procedure1<FieldSet> _function_3 = new Procedure1<FieldSet>() {
                    public void apply(final FieldSet it) {
                      Widget _asWidget = PMWorkItemWorkerAssignmentReportForm.this.evaluateForm.asWidget();
                      it.setWidget(_asWidget);
                    }
                  };
                FieldSet _doubleArrow_3 = ObjectExtensions.<FieldSet>operator_doubleArrow(_FieldSet, _function_3);
                WidgetExtensions.<FieldSet>addFill(it, _doubleArrow_3);
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
  
  public void refreshWorkItemFinishStatus() {
    Boolean _value = this.reportWorkItemFinish.getValue();
    boolean _equals = ((_value).booleanValue() == false);
    if (_equals) {
      this.workItemFinishComment.setValue("");
      FieldLabel _asWidget = this.workItemFinishComment.asWidget();
      _asWidget.disable();
      this.evaluateForm.disableAll();
    } else {
      FieldLabel _asWidget_1 = this.workItemFinishComment.asWidget();
      _asWidget_1.enable();
      this.evaluateForm.enableAll();
    }
  }
  
  @Inject
  private PMWorkItemEvaluateForm evaluateForm;
  
  private Widget con;
}
