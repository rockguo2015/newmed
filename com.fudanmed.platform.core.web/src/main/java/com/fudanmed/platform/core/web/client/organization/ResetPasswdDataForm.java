package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.web.shared.organization.UIResetPasswdData;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.WidgetExtensions;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ResetPasswdDataForm extends GXTFormComponent<UIResetPasswdData> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public TextItem newPasswd;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIResetPasswdData value = new UIResetPasswdData();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();newPasswd = stringValueProviderFactory.createAsTextItem("newPasswd","新密码");
    widgetsRegistory.put("newPasswd",newPasswd);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIResetPasswdData getValueAsNew() {
    UIResetPasswdData value = new UIResetPasswdData();
    value.setNewPasswd(newPasswd.getValue());
    return value;
  }
  
  public UIResetPasswdData doGetValue() {
    
    value.setNewPasswd(newPasswd.getValue());
    return value;
  }
  
  public UIResetPasswdData getValue(final UIResetPasswdData copyValue) {
    
    copyValue.setNewPasswd(newPasswd.getValue());
    return copyValue;
  }
  
  protected ResetPasswdDataForm doSetValue(final UIResetPasswdData value) {
    this.value = value;
    newPasswd.setValue(value.getNewPasswd());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)newPasswd
    					);
  }
  
  public Widget createWidget() {
    VerticalLayoutContainer _VLayout = this.widgets.VLayout();
    final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
        public void apply(final VerticalLayoutContainer it) {
          FieldLabel _asWidget = ResetPasswdDataForm.this.newPasswd.asWidget();
          WidgetExtensions.<FieldLabel>addFill(it, _asWidget);
        }
      };
    VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
    return _doubleArrow;
  }
}
