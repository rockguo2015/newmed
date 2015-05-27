package edu.fudan.langlab.uidl.domain.app.client.login;

import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.PasswordItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.uidl.domain.app.shared.login.ULoginData;
import java.util.Map;

public class UILoginForm extends GXTFormComponent<ULoginData> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public TextItem userid;
  
  public PasswordItem passwd;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private ULoginData value = new ULoginData();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();userid = stringValueProviderFactory.createAsTextItem("userid","用户名");
    widgetsRegistory.put("userid",userid);
    passwd = stringValueProviderFactory.createAsPasswordItem("passwd","密码");
    widgetsRegistory.put("passwd",passwd);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public ULoginData getValueAsNew() {
    ULoginData value = new ULoginData();
    value.setUserid(userid.getValue());
    value.setPasswd(passwd.getValue());
    return value;
  }
  
  public ULoginData doGetValue() {
    
    value.setUserid(userid.getValue());
    value.setPasswd(passwd.getValue());
    return value;
  }
  
  public ULoginData getValue(final ULoginData copyValue) {
    
    copyValue.setUserid(userid.getValue());
    copyValue.setPasswd(passwd.getValue());
    return copyValue;
  }
  
  protected UILoginForm doSetValue(final ULoginData value) {
    this.value = value;
    userid.setValue(value.getUserid());
    passwd.setValue(value.getPasswd());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)userid,(ICanAsWidget)passwd
    					);
  }
}
