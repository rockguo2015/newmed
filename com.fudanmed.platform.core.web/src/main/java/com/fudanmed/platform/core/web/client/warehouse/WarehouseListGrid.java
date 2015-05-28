package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIWarehouse;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.factory.BooleanValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.BooleanValueProviderFactory.BooleanColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectsSelectorFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.DefaultObjectsSelectorFactory.CollectionListColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory;
import edu.fudan.langlab.gxt.client.component.grid.factory.StringValueProviderFactory.StringColumn;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import java.util.Map;

public class WarehouseListGrid extends GXTGridComponent<UIWarehouse> implements IInitializerSupport {
  @Inject
  private IWidgetFactory widgets;
  
  public StringColumn<UIWarehouse> name;
  
  public StringColumn<UIWarehouse> location;
  
  public BooleanColumn<UIWarehouse> isMajor;
  
  public CollectionListColumn<UIWarehouse,RCEmployeeProxy> storeManager;
  
  public CollectionListColumn<UIWarehouse,RCMaintenanceTeamProxy> relatedTeams;
  
  @Inject
  private DefaultObjectsSelectorFactory defaultObjectsSelectorFactory;
  
  @Inject
  private StringValueProviderFactory stringValueProviderFactory;
  
  @Inject
  private BooleanValueProviderFactory booleanValueProviderFactory;
  
  private UIWarehouse value = new UIWarehouse();
  
  private Map<String,ICanAsWidget> widgetsRegistory = com.google.common.collect.Maps.newHashMap();
  
  public ICanAsWidget getWidget(final String key) {
    return widgetsRegistory.get(key);
  }
  
  public void initialize(final IPostInitializeAction handler) {
    java.util.Collection<com.uniquesoft.gwt.client.common.async.IInitializerSupport> _initializerSupports = com.google.common.collect.Lists.newArrayList();name = stringValueProviderFactory.createAsStringColumn("name","名称",UIWarehouse.NameAccessor);
    widgetsRegistory.put("name",name);
    location = stringValueProviderFactory.createAsStringColumn("location","位置",UIWarehouse.LocationAccessor);
    widgetsRegistory.put("location",location);
    isMajor = booleanValueProviderFactory.createAsBooleanColumn("isMajor","主仓库",UIWarehouse.IsMajorAccessor);
    widgetsRegistory.put("isMajor",isMajor);
    storeManager = defaultObjectsSelectorFactory.createAsStringColumn("storeManager","仓库管理员",UIWarehouse.StoreManagerAccessor);
    widgetsRegistory.put("storeManager",storeManager);
    relatedTeams = defaultObjectsSelectorFactory.createAsStringColumn("relatedTeams","关联班组",UIWarehouse.RelatedTeamsAccessor);
    widgetsRegistory.put("relatedTeams",relatedTeams);
    IPostInitializeAction postAction = new IPostInitializeAction() {
    								
    								@Override
    								public void initializeFinished(Void v) {
    									initializeComponent();
    									handler.initializeFinished(null);
    									
    								}
    							};
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(_initializerSupports, postAction);
  }
  
  public UIWarehouse getValueAsNew() {
    UIWarehouse value = new UIWarehouse();
    value.setName(name.getValue());
    value.setLocation(location.getValue());
    value.setIsMajor(isMajor.getValue());
    value.setStoreManager(storeManager.getValue());
    value.setRelatedTeams(relatedTeams.getValue());
    return value;
  }
  
  public UIWarehouse doGetValue() {
    
    value.setName(name.getValue());
    value.setLocation(location.getValue());
    value.setIsMajor(isMajor.getValue());
    value.setStoreManager(storeManager.getValue());
    value.setRelatedTeams(relatedTeams.getValue());
    return value;
  }
  
  public UIWarehouse getValue(final UIWarehouse copyValue) {
    
    copyValue.setName(name.getValue());
    copyValue.setLocation(location.getValue());
    copyValue.setIsMajor(isMajor.getValue());
    copyValue.setStoreManager(storeManager.getValue());
    copyValue.setRelatedTeams(relatedTeams.getValue());
    return copyValue;
  }
  
  protected WarehouseListGrid doSetValue(final UIWarehouse value) {
    this.value = value;
    name.setValue(value.getName());
    location.setValue(value.getLocation());
    isMajor.setValue(value.getIsMajor());
    storeManager.setValue(value.getStoreManager());
    relatedTeams.setValue(value.getRelatedTeams());
    valueUpdated(value);return this;
  }
  
  public Iterable<ICanAsWidget> getAllProperties() {
    return com.google.common.collect.Lists.newArrayList(
    					(ICanAsWidget)name,(ICanAsWidget)location,(ICanAsWidget)isMajor,(ICanAsWidget)storeManager,(ICanAsWidget)relatedTeams
    					);
  }
}
