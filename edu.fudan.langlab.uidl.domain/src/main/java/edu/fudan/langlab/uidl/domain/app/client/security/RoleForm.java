package edu.fudan.langlab.uidl.domain.app.client.security;

import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.BooleanValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.BooleanValueProviderFactory.CheckBoxItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.WidgetExtensions;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIRole;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class RoleForm extends GXTFormComponent<UIRole> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public TextItem roleId;
  
  public TextItem name;
  
  public CheckBoxItem inputNext;
  
  @Inject
  private BooleanValueProviderFactory booleanValueProviderFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIRole value = new UIRole();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();roleId = stringValueProviderFactory.createAsTextItem("roleId","角色代码");
    widgetsRegistory.put("roleId",roleId);
    name = stringValueProviderFactory.createAsTextItem("name","角色名称");
    widgetsRegistory.put("name",name);
    inputNext = booleanValueProviderFactory.createAsCheckBoxItem("inputNext","继续输入");
    widgetsRegistory.put("inputNext",inputNext);
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
  
  public UIRole getValueAsNew() {
    UIRole value = new UIRole();
    value.setRoleId(roleId.getValue());
    value.setName(name.getValue());
    value.setInputNext(inputNext.getValue());
    return value;
  }
  
  public UIRole doGetValue() {
    
    value.setRoleId(roleId.getValue());
    value.setName(name.getValue());
    value.setInputNext(inputNext.getValue());
    return value;
  }
  
  public UIRole getValue(final UIRole copyValue) {
    
    copyValue.setRoleId(roleId.getValue());
    copyValue.setName(name.getValue());
    copyValue.setInputNext(inputNext.getValue());
    return copyValue;
  }
  
  protected RoleForm doSetValue(final UIRole value) {
    this.value = value;
    roleId.setValue(value.getRoleId());
    name.setValue(value.getName());
    inputNext.setValue(value.getInputNext());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)roleId,(ICanAsWidget)name,(ICanAsWidget)inputNext
    					);
  }
  
  public Widget asWidget() {
    final Function1<Void,VerticalLayoutContainer> _function = new Function1<Void,VerticalLayoutContainer>() {
        public VerticalLayoutContainer apply(final Void it) {
          VerticalLayoutContainer _VLayout = RoleForm.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                FieldLabel _asWidget = RoleForm.this.roleId.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget);
                FieldLabel _asWidget_1 = RoleForm.this.name.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_1);
                FieldLabel _asWidget_2 = RoleForm.this.inputNext.asWidget();
                final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                    public void apply(final FieldLabel it) {
                      RoleForm.this.inputNext.setValue(Boolean.valueOf(true));
                    }
                  };
                FieldLabel _doubleArrow = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget_2, _function);
                WidgetExtensions.<FieldLabel>addFill(it, _doubleArrow);
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
