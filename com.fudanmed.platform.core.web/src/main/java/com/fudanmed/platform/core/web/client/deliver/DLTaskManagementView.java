package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.DLTaskManagementPresenterView;
import com.fudanmed.platform.core.web.client.deliver.TaskQueryListPresenter;
import com.fudanmed.platform.core.web.client.deliver.TaskQueryListPresenterView;
import com.fudanmed.platform.core.web.shared.deliver.UITask;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.widget.FramedPanel;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DLTaskManagementView extends GWTAbstractView implements DLTaskManagementPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    initialize();
    postInitialize.initializeFinished(null);
    
  }
  
  @Inject
  private Securities securities;
  
  @Inject
  private EventBus eventBus;
  
  private TaskQueryListPresenter queryListPresenter;
  
  public void setQueryListPresenter(final TaskQueryListPresenter queryListPresenter) {
    this.queryListPresenter = queryListPresenter;
  }
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    TaskQueryListPresenterView _view = this.queryListPresenter.getView();
    final ActionContext<UITask> ac = _view.getActionContext();
    FramedPanel _FramedPanel = this.widgets.FramedPanel("\u8FD0\u9001\u4EFB\u52A1\u6E05\u5355");
    final Procedure1<FramedPanel> _function = new Procedure1<FramedPanel>() {
        public void apply(final FramedPanel it) {
          TaskQueryListPresenterView _view = DLTaskManagementView.this.queryListPresenter.getView();
          Widget _asWidget = _view.asWidget();
          it.setWidget(_asWidget);
        }
      };
    FramedPanel _doubleArrow = ObjectExtensions.<FramedPanel>operator_doubleArrow(_FramedPanel, _function);
    this.con = _doubleArrow;
  }
}
