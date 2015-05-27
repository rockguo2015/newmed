package edu.fudan.langlab.client.csv;

import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.shared.csv.UIErrorItem;
import java.util.Map;

public class ErrorItemListGrid extends GXTGridComponent<UIErrorItem> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIErrorItem> errorTitle;
  
  public StringColumn<UIErrorItem> errorMessage;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  private UIErrorItem value = new UIErrorItem();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();errorTitle = stringValueProviderFactory.createAsStringColumn("errorTitle","标题／位置",UIErrorItem.ErrorTitleAccessor);
    widgetsRegistory.put("errorTitle",errorTitle);
    errorMessage = stringValueProviderFactory.createAsStringColumn("errorMessage","信息",UIErrorItem.ErrorMessageAccessor);
    widgetsRegistory.put("errorMessage",errorMessage);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIErrorItem getValueAsNew() {
    UIErrorItem value = new UIErrorItem();
    value.setErrorTitle(errorTitle.getValue());
    value.setErrorMessage(errorMessage.getValue());
    return value;
  }
  
  public UIErrorItem doGetValue() {
    
    value.setErrorTitle(errorTitle.getValue());
    value.setErrorMessage(errorMessage.getValue());
    return value;
  }
  
  public UIErrorItem getValue(final UIErrorItem copyValue) {
    
    copyValue.setErrorTitle(errorTitle.getValue());
    copyValue.setErrorMessage(errorMessage.getValue());
    return copyValue;
  }
  
  protected ErrorItemListGrid doSetValue(final UIErrorItem value) {
    this.value = value;
    errorTitle.setValue(value.getErrorTitle());
    errorMessage.setValue(value.getErrorMessage());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)errorTitle,(ICanAsWidget)errorMessage
    					);
  }
}
