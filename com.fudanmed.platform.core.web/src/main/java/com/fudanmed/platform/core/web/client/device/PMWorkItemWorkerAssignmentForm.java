package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.web.client.device.PMWorkItemEvaluateForm;
import com.fudanmed.platform.core.web.client.organization.AllOrgEmployeeContentProvider;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemWorkerAssignment;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import com.uniquesoft.gwt.shared.DateUtil;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.BooleanValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.BooleanValueProviderFactory.CheckBoxItem;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory.DateItem;
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectsSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.DualListMultiSelector;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextAreaItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.WidgetExtensions;
import java.util.Date;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class PMWorkItemWorkerAssignmentForm extends GXTFormComponent<UIPMWorkItemWorkerAssignment> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public DualListMultiSelector<RCEmployeeProxy> workers;
  
  @Inject
  public AllOrgEmployeeContentProvider workersContentProvider;
  
  public DateItem assignDate;
  
  public TextAreaItem comment;
  
  public CheckBoxItem print;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private BooleanValueProviderFactory booleanValueProviderFactory;
  
  @Inject
  private DefaultObjectsSelectorFactory defaultObjectsSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIPMWorkItemWorkerAssignment value = new UIPMWorkItemWorkerAssignment();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();workers = defaultObjectsSelectorFactory.createAsDualListItem("workers","工程师");
    workers.setContentProvider(workersContentProvider);
    widgetsRegistory.put("workers",workers);
    assignDate = dateValueProviderFactory.createAsDateItem("assignDate","派工日期");
    widgetsRegistory.put("assignDate",assignDate);
    comment = stringValueProviderFactory.createAsTextAreaItem("comment","派工说明");
    widgetsRegistory.put("comment",comment);
    print = booleanValueProviderFactory.createAsCheckBoxItem("print","打印PM工单");
    widgetsRegistory.put("print",print);
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
    value.setWorkers(workers.getValue());
    value.setAssignDate(assignDate.getValue());
    value.setComment(comment.getValue());
    value.setPrint(print.getValue());
    return value;
  }
  
  public UIPMWorkItemWorkerAssignment doGetValue() {
    
    value.setWorkers(workers.getValue());
    value.setAssignDate(assignDate.getValue());
    value.setComment(comment.getValue());
    value.setPrint(print.getValue());
    return value;
  }
  
  public UIPMWorkItemWorkerAssignment getValue(final UIPMWorkItemWorkerAssignment copyValue) {
    
    copyValue.setWorkers(workers.getValue());
    copyValue.setAssignDate(assignDate.getValue());
    copyValue.setComment(comment.getValue());
    copyValue.setPrint(print.getValue());
    return copyValue;
  }
  
  protected PMWorkItemWorkerAssignmentForm doSetValue(final UIPMWorkItemWorkerAssignment value) {
    this.value = value;
    workers.setValue(value.getWorkers());
    assignDate.setValue(value.getAssignDate());
    comment.setValue(value.getComment());
    print.setValue(value.getPrint());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)workers,(ICanAsWidget)assignDate,(ICanAsWidget)comment,(ICanAsWidget)print
    					);
  }
  
  public Widget asWidget() {
    final Function1<Void,VerticalLayoutContainer> _function = new Function1<Void,VerticalLayoutContainer>() {
        public VerticalLayoutContainer apply(final Void it) {
          VerticalLayoutContainer _VLayout = PMWorkItemWorkerAssignmentForm.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                FieldLabel _asWidget = PMWorkItemWorkerAssignmentForm.this.assignDate.asWidget();
                final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                    public void apply(final FieldLabel it) {
                      Date _day = DateUtil.today();
                      PMWorkItemWorkerAssignmentForm.this.assignDate.setValue(_day);
                    }
                  };
                FieldLabel _doubleArrow = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget, _function);
                WidgetExtensions.<FieldLabel>addFill(it, _doubleArrow);
                FieldLabel _asWidget_1 = PMWorkItemWorkerAssignmentForm.this.workers.asWidget();
                final Procedure1<FieldLabel> _function_1 = new Procedure1<FieldLabel>() {
                    public void apply(final FieldLabel it) {
                      it.setHeight(100);
                    }
                  };
                FieldLabel _doubleArrow_1 = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget_1, _function_1);
                WidgetExtensions.<FieldLabel>addFill(it, _doubleArrow_1);
                FieldLabel _asWidget_2 = PMWorkItemWorkerAssignmentForm.this.comment.asWidget();
                final Procedure1<FieldLabel> _function_2 = new Procedure1<FieldLabel>() {
                    public void apply(final FieldLabel it) {
                      it.setHeight(80);
                    }
                  };
                FieldLabel _doubleArrow_2 = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget_2, _function_2);
                WidgetExtensions.<FieldLabel>addFill(it, _doubleArrow_2);
                FieldLabel _asWidget_3 = PMWorkItemWorkerAssignmentForm.this.print.asWidget();
                final Procedure1<FieldLabel> _function_3 = new Procedure1<FieldLabel>() {
                    public void apply(final FieldLabel it) {
                      it.setWidth(80);
                    }
                  };
                FieldLabel _doubleArrow_3 = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget_3, _function_3);
                ClientUi.operator_add(it, _doubleArrow_3);
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
  
  @Inject
  private PMWorkItemEvaluateForm evaluateForm;
  
  private Widget con;
}
