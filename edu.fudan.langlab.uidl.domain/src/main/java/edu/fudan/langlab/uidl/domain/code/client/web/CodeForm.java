package edu.fudan.langlab.uidl.domain.code.client.web;

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
import edu.fudan.langlab.uidl.domain.code.shared.web.UICode;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CodeForm extends GXTFormComponent<UICode> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public TextItem codeid;
  
  public TextItem name;
  
  public CheckBoxItem inputNext;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  @Inject
  private BooleanValueProviderFactory booleanValueProviderFactory;
  
  private UICode value = new UICode();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();codeid = stringValueProviderFactory.createAsTextItem("codeid","代码");
    widgetsRegistory.put("codeid",codeid);
    name = stringValueProviderFactory.createAsTextItem("name","名称");
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
  
  public UICode getValueAsNew() {
    UICode value = new UICode();
    value.setCodeid(codeid.getValue());
    value.setName(name.getValue());
    value.setInputNext(inputNext.getValue());
    return value;
  }
  
  public UICode doGetValue() {
    
    value.setCodeid(codeid.getValue());
    value.setName(name.getValue());
    value.setInputNext(inputNext.getValue());
    return value;
  }
  
  public UICode getValue(final UICode copyValue) {
    
    copyValue.setCodeid(codeid.getValue());
    copyValue.setName(name.getValue());
    copyValue.setInputNext(inputNext.getValue());
    return copyValue;
  }
  
  protected CodeForm doSetValue(final UICode value) {
    this.value = value;
    codeid.setValue(value.getCodeid());
    name.setValue(value.getName());
    inputNext.setValue(value.getInputNext());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)codeid,(ICanAsWidget)name,(ICanAsWidget)inputNext
    					);
  }
  
  public VerticalLayoutContainer asWidget() {
    final Function1<Void,VerticalLayoutContainer> _function = new Function1<Void,VerticalLayoutContainer>() {
        public VerticalLayoutContainer apply(final Void it) {
          VerticalLayoutContainer _verticalLayoutContainer = new VerticalLayoutContainer();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                FieldLabel _asWidget = CodeForm.this.codeid.asWidget();
                ClientUi.operator_add(it, _asWidget);
                FieldLabel _asWidget_1 = CodeForm.this.name.asWidget();
                ClientUi.operator_add(it, _asWidget_1);
                FieldLabel _asWidget_2 = CodeForm.this.inputNext.asWidget();
                final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
                    public void apply(final FieldLabel it) {
                      CodeForm.this.inputNext.setValue(Boolean.valueOf(true));
                    }
                  };
                FieldLabel _doubleArrow = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget_2, _function);
                ClientUi.operator_add(it, _doubleArrow);
              }
            };
          VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_verticalLayoutContainer, _function);
          return _doubleArrow;
        }
      };
    VerticalLayoutContainer _lazy = ClientUi.<VerticalLayoutContainer>lazy(this.con, _function);
    VerticalLayoutContainer _con = this.con = _lazy;
    return _con;
  }
  
  private VerticalLayoutContainer con;
}
