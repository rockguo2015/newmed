package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.shared.project.WorkItemOutsourceData;
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

public class WorkItemOutsourceDataForm extends GXTFormComponent<WorkItemOutsourceData> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public DateItem finishDate;
  
  public TimeItem finishTime;
  
  public TextAreaItem comment;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private WorkItemOutsourceData value = new WorkItemOutsourceData();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();finishDate = dateValueProviderFactory.createAsDateItem("finishDate","外协日期");
    widgetsRegistory.put("finishDate",finishDate);
    finishTime = dateValueProviderFactory.createAsTimeItem("finishTime","外协时间");
    widgetsRegistory.put("finishTime",finishTime);
    comment = stringValueProviderFactory.createAsTextAreaItem("comment","维修说明");
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
  
  public WorkItemOutsourceData getValueAsNew() {
    WorkItemOutsourceData value = new WorkItemOutsourceData();
    value.setFinishDate(finishDate.getValue());
    value.setFinishTime(finishTime.getValue());
    value.setComment(comment.getValue());
    return value;
  }
  
  public WorkItemOutsourceData doGetValue() {
    
    value.setFinishDate(finishDate.getValue());
    value.setFinishTime(finishTime.getValue());
    value.setComment(comment.getValue());
    return value;
  }
  
  public WorkItemOutsourceData getValue(final WorkItemOutsourceData copyValue) {
    
    copyValue.setFinishDate(finishDate.getValue());
    copyValue.setFinishTime(finishTime.getValue());
    copyValue.setComment(comment.getValue());
    return copyValue;
  }
  
  protected WorkItemOutsourceDataForm doSetValue(final WorkItemOutsourceData value) {
    this.value = value;
    finishDate.setValue(value.getFinishDate());
    finishTime.setValue(value.getFinishTime());
    comment.setValue(value.getComment());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)finishDate,(ICanAsWidget)finishTime,(ICanAsWidget)comment
    					);
  }
  
  public Widget asWidget() {
    final Function1<Void,VerticalLayoutContainer> _function = new Function1<Void,VerticalLayoutContainer>() {
        public VerticalLayoutContainer apply(final Void it) {
          VerticalLayoutContainer _VLayout = WorkItemOutsourceDataForm.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                FieldLabel _asWidget = WorkItemOutsourceDataForm.this.finishDate.asWidget();
                int _minus = (-1);
                VerticalLayoutData _VLayoutData = WorkItemOutsourceDataForm.this.widgets.VLayoutData(1, _minus);
                it.add(_asWidget, _VLayoutData);
                FieldLabel _asWidget_1 = WorkItemOutsourceDataForm.this.finishTime.asWidget();
                int _minus_1 = (-1);
                VerticalLayoutData _VLayoutData_1 = WorkItemOutsourceDataForm.this.widgets.VLayoutData(1, _minus_1);
                it.add(_asWidget_1, _VLayoutData_1);
                FieldLabel _asWidget_2 = WorkItemOutsourceDataForm.this.comment.asWidget();
                VerticalLayoutData _VLayoutData_2 = WorkItemOutsourceDataForm.this.widgets.VLayoutData(366, 80);
                it.add(_asWidget_2, _VLayoutData_2);
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
