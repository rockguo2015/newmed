package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.web.shared.organization.UIChangePasswdData;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.PasswordItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.WidgetExtensions;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ChangePasswdDataForm extends GXTFormComponent<UIChangePasswdData> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public PasswordItem orgPasswd;
  
  public PasswordItem newPasswd;
  
  public PasswordItem newPasswdAgain;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIChangePasswdData value = new UIChangePasswdData();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();orgPasswd = stringValueProviderFactory.createAsPasswordItem("orgPasswd","原密码");
    widgetsRegistory.put("orgPasswd",orgPasswd);
    newPasswd = stringValueProviderFactory.createAsPasswordItem("newPasswd","新密码");
    widgetsRegistory.put("newPasswd",newPasswd);
    newPasswdAgain = stringValueProviderFactory.createAsPasswordItem("newPasswdAgain","新密码");
    widgetsRegistory.put("newPasswdAgain",newPasswdAgain);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIChangePasswdData getValueAsNew() {
    UIChangePasswdData value = new UIChangePasswdData();
    value.setOrgPasswd(orgPasswd.getValue());
    value.setNewPasswd(newPasswd.getValue());
    value.setNewPasswdAgain(newPasswdAgain.getValue());
    return value;
  }
  
  public UIChangePasswdData doGetValue() {
    
    value.setOrgPasswd(orgPasswd.getValue());
    value.setNewPasswd(newPasswd.getValue());
    value.setNewPasswdAgain(newPasswdAgain.getValue());
    return value;
  }
  
  public UIChangePasswdData getValue(final UIChangePasswdData copyValue) {
    
    copyValue.setOrgPasswd(orgPasswd.getValue());
    copyValue.setNewPasswd(newPasswd.getValue());
    copyValue.setNewPasswdAgain(newPasswdAgain.getValue());
    return copyValue;
  }
  
  protected ChangePasswdDataForm doSetValue(final UIChangePasswdData value) {
    this.value = value;
    orgPasswd.setValue(value.getOrgPasswd());
    newPasswd.setValue(value.getNewPasswd());
    newPasswdAgain.setValue(value.getNewPasswdAgain());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)orgPasswd,(ICanAsWidget)newPasswd,(ICanAsWidget)newPasswdAgain
    					);
  }
  
  public Widget createWidget() {
    VerticalLayoutContainer _VLayout = this.widgets.VLayout();
    final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
        public void apply(final VerticalLayoutContainer it) {
          FieldLabel _asWidget = ChangePasswdDataForm.this.orgPasswd.asWidget();
          WidgetExtensions.<FieldLabel>addFill(it, _asWidget);
          FieldLabel _asWidget_1 = ChangePasswdDataForm.this.newPasswd.asWidget();
          WidgetExtensions.<FieldLabel>addFill(it, _asWidget_1);
          FieldLabel _asWidget_2 = ChangePasswdDataForm.this.newPasswdAgain.asWidget();
          WidgetExtensions.<FieldLabel>addFill(it, _asWidget_2);
        }
      };
    VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
    return _doubleArrow;
  }
}
