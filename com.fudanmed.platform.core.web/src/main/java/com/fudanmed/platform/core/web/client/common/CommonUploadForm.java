package com.fudanmed.platform.core.web.client.common;

import com.fudanmed.platform.core.web.shared.common.CommonUploadParam;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.FileValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.form.factory.FileValueProviderFactory.FileItem;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CommonUploadForm extends GXTFormComponent<CommonUploadParam> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public FileItem file;
  
  @Inject
  private FileValueProviderFactory fileValueProviderFactory;
  
  private CommonUploadParam value = new CommonUploadParam();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();file = fileValueProviderFactory.createAsFileItem("file","上传文件");
    widgetsRegistory.put("file",file);
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
  
  public CommonUploadParam getValueAsNew() {
    CommonUploadParam value = new CommonUploadParam();
    value.setFile(file.getValue());
    return value;
  }
  
  public CommonUploadParam doGetValue() {
    
    value.setFile(file.getValue());
    return value;
  }
  
  public CommonUploadParam getValue(final CommonUploadParam copyValue) {
    
    copyValue.setFile(file.getValue());
    return copyValue;
  }
  
  protected CommonUploadForm doSetValue(final CommonUploadParam value) {
    this.value = value;
    file.setValue(value.getFile());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)file
    					);
  }
  
  public Widget asWidget() {
    final Function1<Void,VerticalLayoutContainer> _function = new Function1<Void,VerticalLayoutContainer>() {
        public VerticalLayoutContainer apply(final Void it) {
          VerticalLayoutContainer _VLayout = CommonUploadForm.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                FieldLabel _asWidget = CommonUploadForm.this.file.asWidget();
                ClientUi.operator_add(it, _asWidget);
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
