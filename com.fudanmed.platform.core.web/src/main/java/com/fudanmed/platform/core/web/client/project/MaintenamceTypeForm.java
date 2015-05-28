package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy;
import com.fudanmed.platform.core.web.shared.project.UIMaintenamceType;
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
import edu.fudan.langlab.gxt.client.component.form.factory.DefaultObjectSelectorFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.ReadonlyItem;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.WidgetExtensions;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class MaintenamceTypeForm extends GXTFormComponent<UIMaintenamceType> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public TextItem code;
  
  public TextItem name;
  
  public ReadonlyItem<RCMaintenamceTypeProxy> parent;
  
  public CheckBoxItem inputNext;
  
  @Inject
  private DefaultObjectSelectorFactory defaultObjectSelectorFactory;
  
  @Inject
  private BooleanValueProviderFactory booleanValueProviderFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIMaintenamceType value = new UIMaintenamceType();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();code = stringValueProviderFactory.createAsTextItem("code","类别代码");
    widgetsRegistory.put("code",code);
    name = stringValueProviderFactory.createAsTextItem("name","类别名称");
    widgetsRegistory.put("name",name);
    parent = defaultObjectSelectorFactory.createAsReadonlyItem("parent","父类型");
    widgetsRegistory.put("parent",parent);
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
  
  public UIMaintenamceType getValueAsNew() {
    UIMaintenamceType value = new UIMaintenamceType();
    value.setCode(code.getValue());
    value.setName(name.getValue());
    value.setParent(parent.getValue());
    value.setInputNext(inputNext.getValue());
    return value;
  }
  
  public UIMaintenamceType doGetValue() {
    
    value.setCode(code.getValue());
    value.setName(name.getValue());
    value.setParent(parent.getValue());
    value.setInputNext(inputNext.getValue());
    return value;
  }
  
  public UIMaintenamceType getValue(final UIMaintenamceType copyValue) {
    
    copyValue.setCode(code.getValue());
    copyValue.setName(name.getValue());
    copyValue.setParent(parent.getValue());
    copyValue.setInputNext(inputNext.getValue());
    return copyValue;
  }
  
  protected MaintenamceTypeForm doSetValue(final UIMaintenamceType value) {
    this.value = value;
    code.setValue(value.getCode());
    name.setValue(value.getName());
    parent.setValue(value.getParent());
    inputNext.setValue(value.getInputNext());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)code,(ICanAsWidget)name,(ICanAsWidget)parent,(ICanAsWidget)inputNext
    					);
  }
  
  public Widget asWidget() {
    final Function1<Void,VerticalLayoutContainer> _function = new Function1<Void,VerticalLayoutContainer>() {
        public VerticalLayoutContainer apply(final Void it) {
          VerticalLayoutContainer _VLayout = MaintenamceTypeForm.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                FieldLabel _asWidget = MaintenamceTypeForm.this.parent.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget);
                FieldLabel _asWidget_1 = MaintenamceTypeForm.this.code.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_1);
                FieldLabel _asWidget_2 = MaintenamceTypeForm.this.name.asWidget();
                WidgetExtensions.<FieldLabel>addFill(it, _asWidget_2);
                FieldLabel _asWidget_3 = MaintenamceTypeForm.this.inputNext.asWidget();
                final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                    public void apply(final FieldLabel it) {
                      MaintenamceTypeForm.this.inputNext.setValue(Boolean.valueOf(true));
                    }
                  };
                FieldLabel _doubleArrow = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget_3, _function);
                it.add(_doubleArrow);
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
