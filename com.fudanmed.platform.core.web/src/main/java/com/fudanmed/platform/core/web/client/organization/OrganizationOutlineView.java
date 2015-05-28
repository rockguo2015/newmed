package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.OrganizationListGrid;
import com.fudanmed.platform.core.web.client.organization.OrganizationOutlinePresenterView;
import com.fudanmed.platform.core.web.client.organization.OrganizationOutlineTreeGrid;
import com.fudanmed.platform.core.web.client.tree.OrganizationTreeContentProvider;
import com.fudanmed.platform.core.web.shared.organization.UIOrganization;
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

public class OrganizationOutlineView extends GWTAbstractView implements OrganizationOutlinePresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(fullListGrid,simpleListGrid),
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
  
  @Inject
  private OrganizationListGrid fullListGrid;
  
  @Inject
  private OrganizationOutlineTreeGrid simpleListGrid;
  
  private GXTTreeGridComponent<UIOrganization> listGrid;
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    this.listGrid.asWidget();
    VerticalLayoutContainer _VLayout = this.widgets.VLayout();
    final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
        public void apply(final VerticalLayoutContainer it) {
          final Function2<UIOrganization,String,Boolean> _function = new Function2<UIOrganization,String,Boolean>() {
              public Boolean apply(final UIOrganization item, final String filter) {
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
          StoreFilterField<UIOrganization> _createFilter = ComponentExtensions.<UIOrganization>createFilter(OrganizationOutlineView.this.listGrid, _function);
          int _minus = (-1);
          VerticalLayoutData _VLayoutData = OrganizationOutlineView.this.widgets.VLayoutData(1, _minus);
          it.add(_createFilter, _VLayoutData);
          ContentPanel _ContentPanel = OrganizationOutlineView.this.widgets.ContentPanel();
          final Procedure1<ContentPanel> _function_1 = new Procedure1<ContentPanel>() {
              public void apply(final ContentPanel it) {
                SGrid<UIOrganization> _asWidget = OrganizationOutlineView.this.listGrid.asWidget();
                it.setWidget(_asWidget);
              }
            };
          ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function_1);
          VerticalLayoutData _VLayoutData_1 = OrganizationOutlineView.this.widgets.VLayoutData(1, 1);
          it.add(_doubleArrow, _VLayoutData_1);
        }
      };
    VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
    this.con = _doubleArrow;
  }
  
  public void showResults(final Collection<UIOrganization> results) {
    OrganizationTreeContentProvider _organizationTreeContentProvider = new OrganizationTreeContentProvider(results);
    this.listGrid.setContentProvider(_organizationTreeContentProvider);
  }
  
  public void updateOrganization(final UIOrganization org) {
    TreeStore<UIOrganization> _store = this.listGrid.getStore();
    _store.update(org);
  }
  
  public void deleteOrganization(final RCOrganizationProxy org) {
    TreeStore<UIOrganization> store = this.listGrid.getStore();
    int _hashCode = org.hashCode();
    String _string = Integer.valueOf(_hashCode).toString();
    UIOrganization _findModelWithKey = store.findModelWithKey(_string);
    store.remove(_findModelWithKey);
  }
  
  public void addOrganization(final UIOrganization org) {
    TreeStore store = this.listGrid.getStore();
    RCOrganizationProxy _parent = org.getParent();
    boolean _equals = Objects.equal(_parent, null);
    if (_equals) {
      store.add(org);
    } else {
      RCOrganizationProxy _parent_1 = org.getParent();
      int _hashCode = _parent_1.hashCode();
      String _string = Integer.valueOf(_hashCode).toString();
      Object parentInStore = store.findModelWithKey(_string);
      store.add(parentInStore, org);
    }
  }
  
  public ActionContext<UIOrganization> getActionContext() {
    ActionContext<UIOrganization> _createActionContext = ActionExtensions.<UIOrganization>createActionContext(this.listGrid);
    return _createActionContext;
  }
  
  public void select(final UIOrganization org) {
    this.listGrid.select(org);
  }
  
  public void asSimpleTree(final Boolean isSimple) {
    if ((isSimple).booleanValue()) {
      this.listGrid = this.simpleListGrid;
    } else {
      this.listGrid = this.fullListGrid;
    }
  }
}
