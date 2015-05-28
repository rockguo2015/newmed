package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.web.client.organization.OnsiteLocationOutlinePresenterView;
import com.fudanmed.platform.core.web.client.organization.OnsitePositionListGrid;
import com.fudanmed.platform.core.web.client.organization.OnsitePositionSimpleTreeGrid;
import com.fudanmed.platform.core.web.client.tree.OnsitePositionTreeContentProvider;
import com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition;
import com.google.common.base.Objects;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.data.shared.TreeStore;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.form.StoreFilterField;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.action.ActionExtensions;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.component.treegrid.GXTTreeGridComponent;
import edu.fudan.langlab.gxt.client.component.treegrid.SGrid;
import edu.fudan.langlab.gxt.client.widget.ComponentExtensions;
import edu.fudan.langlab.gxt.client.widget.ContentPanel;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class OnsiteLocationOutlineView extends GWTAbstractView implements OnsiteLocationOutlinePresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(fullListGrid,simpleGrid),
    	new com.uniquesoft.gwt.client.common.async.IPostInitializeAction(){
    
    	public void initializeFinished(Void v) {
    		initialize();
    		postInitialize.initializeFinished(null);
    	}
    });
    
  }
  
  @Inject
  private Securities securities;
  
  @Inject
  private EventBus eventBus;
  
  private Widget con;
  
  @Inject
  private OnsitePositionListGrid fullListGrid;
  
  @Inject
  private OnsitePositionSimpleTreeGrid simpleGrid;
  
  private GXTTreeGridComponent<UIOnsitePosition> listGrid;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    this.listGrid.asWidget();
    VerticalLayoutContainer _VLayout = this.widgets.VLayout();
    final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
        public void apply(final VerticalLayoutContainer it) {
          final Function2<UIOnsitePosition,String,Boolean> _function = new Function2<UIOnsitePosition,String,Boolean>() {
              public Boolean apply(final UIOnsitePosition item, final String filter) {
                boolean _or = false;
                String _name = item.getName();
                boolean _contains = _name.contains(filter);
                if (_contains) {
                  _or = true;
                } else {
                  boolean _and = false;
                  String _simplePy = item.getSimplePy();
                  boolean _notEquals = (!Objects.equal(_simplePy, null));
                  if (!_notEquals) {
                    _and = false;
                  } else {
                    String _simplePy_1 = item.getSimplePy();
                    boolean _contains_1 = _simplePy_1.contains(filter);
                    _and = (_notEquals && _contains_1);
                  }
                  _or = (_contains || _and);
                }
                return Boolean.valueOf(_or);
              }
            };
          StoreFilterField<UIOnsitePosition> _createFilter = ComponentExtensions.<UIOnsitePosition>createFilter(OnsiteLocationOutlineView.this.listGrid, _function);
          int _minus = (-1);
          VerticalLayoutData _VLayoutData = OnsiteLocationOutlineView.this.widgets.VLayoutData(1, _minus);
          it.add(_createFilter, _VLayoutData);
          ContentPanel _ContentPanel = OnsiteLocationOutlineView.this.widgets.ContentPanel();
          final Procedure1<ContentPanel> _function_1 = new Procedure1<ContentPanel>() {
              public void apply(final ContentPanel it) {
                SGrid<UIOnsitePosition> _asWidget = OnsiteLocationOutlineView.this.listGrid.asWidget();
                it.setWidget(_asWidget);
              }
            };
          ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function_1);
          VerticalLayoutData _VLayoutData_1 = OnsiteLocationOutlineView.this.widgets.VLayoutData(1, 1);
          it.add(_doubleArrow, _VLayoutData_1);
        }
      };
    VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
    this.con = _doubleArrow;
  }
  
  public void showResults(final Collection<UIOnsitePosition> results) {
    OnsitePositionTreeContentProvider _onsitePositionTreeContentProvider = new OnsitePositionTreeContentProvider(results);
    this.listGrid.setContentProvider(_onsitePositionTreeContentProvider);
  }
  
  public void updateOnsitePosition(final UIOnsitePosition org) {
    TreeStore<UIOnsitePosition> _store = this.listGrid.getStore();
    _store.update(org);
  }
  
  public void deleteOnsitePosition(final RCOnsitePositionProxy org) {
    TreeStore<UIOnsitePosition> store = this.listGrid.getStore();
    int _hashCode = org.hashCode();
    String _string = Integer.valueOf(_hashCode).toString();
    UIOnsitePosition _findModelWithKey = store.findModelWithKey(_string);
    store.remove(_findModelWithKey);
  }
  
  public void addOnsitePosition(final UIOnsitePosition org) {
    TreeStore store = this.listGrid.getStore();
    RCOnsitePositionProxy _parent = org.getParent();
    boolean _equals = Objects.equal(_parent, null);
    if (_equals) {
      store.add(org);
    } else {
      RCOnsitePositionProxy _parent_1 = org.getParent();
      int _hashCode = _parent_1.hashCode();
      String _string = Integer.valueOf(_hashCode).toString();
      Object parentInStore = store.findModelWithKey(_string);
      store.add(parentInStore, org);
    }
  }
  
  public ActionContext<UIOnsitePosition> getActionContext() {
    ActionContext<UIOnsitePosition> _createActionContext = ActionExtensions.<UIOnsitePosition>createActionContext(this.listGrid);
    return _createActionContext;
  }
  
  public void setAsSimpleTree(final Boolean isSimple) {
    if ((isSimple).booleanValue()) {
      this.listGrid = this.simpleGrid;
    } else {
      this.listGrid = this.fullListGrid;
    }
  }
}
