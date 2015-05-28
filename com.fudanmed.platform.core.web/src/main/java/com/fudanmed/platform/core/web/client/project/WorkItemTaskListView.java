package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.WorkItemTaskListGrid;
import com.fudanmed.platform.core.web.client.project.WorkItemTaskListPresenterView;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemTask;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.action.ActionExtensions;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class WorkItemTaskListView extends GWTAbstractView implements WorkItemTaskListPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(listGrid),
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
  private WorkItemTaskListGrid listGrid;
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    VerticalLayoutContainer _VLayout = this.widgets.VLayout();
    final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
        public void apply(final VerticalLayoutContainer it) {
          SGroupingGrid<UIWorkItemTask> _asWidget = WorkItemTaskListView.this.listGrid.asWidget();
          VerticalLayoutData _VLayoutData = WorkItemTaskListView.this.widgets.VLayoutData(1, 1);
          it.add(_asWidget, _VLayoutData);
        }
      };
    VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
    this.con = _doubleArrow;
  }
  
  public ActionContext<UIWorkItemTask> getActionContext() {
    ActionContext<UIWorkItemTask> _createActionContext = ActionExtensions.<UIWorkItemTask>createActionContext(this.listGrid);
    return _createActionContext;
  }
  
  public void showResults(final Collection<UIWorkItemTask> results) {
    
    final Function1<UIWorkItemTask,Date> _function = new Function1<UIWorkItemTask,Date>() {
        public Date apply(final UIWorkItemTask it) {
          Date _dateTime = it.getDateTime();
          return _dateTime;
        }
      };
    List<UIWorkItemTask> _sortBy = IterableExtensions.<UIWorkItemTask, Date>sortBy(results, _function);
    List<UIWorkItemTask> _reverse = ListExtensions.<UIWorkItemTask>reverse(_sortBy);
    this.listGrid.setObjects(_reverse);
  }
}
