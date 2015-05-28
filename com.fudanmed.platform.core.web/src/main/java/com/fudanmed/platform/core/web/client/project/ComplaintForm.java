package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.common.ServerSideTimeServiceAsync;
import com.fudanmed.platform.core.web.shared.project.UIComplaint;
import com.google.gwt.user.client.rpc.AsyncCallback;
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
import edu.fudan.langlab.gxt.client.component.form.factory.DateValueProviderFactory.DateReadonlyItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextAreaItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Date;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ComplaintForm extends GXTFormComponent<UIComplaint> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public DateReadonlyItem date;
  
  public TextAreaItem contents;
  
  @Inject
  private DateValueProviderFactory dateValueProviderFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIComplaint value = new UIComplaint();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();date = dateValueProviderFactory.createAsReadonlyItem("date","投诉日期");
    widgetsRegistory.put("date",date);
    contents = stringValueProviderFactory.createAsTextAreaItem("contents","投诉内容");
    widgetsRegistory.put("contents",contents);
    if(timeService instanceof com.uniquesoft.gwt.client.common.async.IInitializerSupport){
    							_initializerSupports.add((com.uniquesoft.gwt.client.common.async.IInitializerSupport)timeService);
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
  
  public UIComplaint getValueAsNew() {
    UIComplaint value = new UIComplaint();
    value.setDate(date.getValue());
    value.setContents(contents.getValue());
    return value;
  }
  
  public UIComplaint doGetValue() {
    
    value.setDate(date.getValue());
    value.setContents(contents.getValue());
    return value;
  }
  
  public UIComplaint getValue(final UIComplaint copyValue) {
    
    copyValue.setDate(date.getValue());
    copyValue.setContents(contents.getValue());
    return copyValue;
  }
  
  protected ComplaintForm doSetValue(final UIComplaint value) {
    this.value = value;
    date.setValue(value.getDate());
    contents.setValue(value.getContents());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)date,(ICanAsWidget)contents
    					);
  }
  
  public Widget asWidget() {
    final Function1<Void,VerticalLayoutContainer> _function = new Function1<Void,VerticalLayoutContainer>() {
        public VerticalLayoutContainer apply(final Void it) {
          VerticalLayoutContainer _VLayout = ComplaintForm.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                FieldLabel _asWidget = ComplaintForm.this.date.asWidget();
                final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                    public void apply(final FieldLabel it) {
                      final Procedure1<Date> _function = new Procedure1<Date>() {
                          public void apply(final Date it) {
                            ComplaintForm.this.date.setValue(it);
                          }
                        };
                      AsyncCallback<Date> _onSuccess = ComplaintForm.this.<Date>onSuccess(_function);
                      ComplaintForm.this.timeService.getTime(_onSuccess);
                    }
                  };
                FieldLabel _doubleArrow = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget, _function);
                int _minus = (-1);
                VerticalLayoutData _VLayoutData = ComplaintForm.this.widgets.VLayoutData(1, _minus);
                it.add(_doubleArrow, _VLayoutData);
                FieldLabel _asWidget_1 = ComplaintForm.this.contents.asWidget();
                VerticalLayoutData _VLayoutData_1 = ComplaintForm.this.widgets.VLayoutData(1, 80);
                it.add(_asWidget_1, _VLayoutData_1);
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
  private ServerSideTimeServiceAsync timeService;
  
  private Widget con;
}
