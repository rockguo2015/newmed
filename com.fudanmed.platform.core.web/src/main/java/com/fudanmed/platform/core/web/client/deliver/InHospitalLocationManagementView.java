package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLInHospitalLocationProxy;
import com.fudanmed.platform.core.web.client.deliver.CreateInHospitalLocationCommand;
import com.fudanmed.platform.core.web.client.deliver.DeleteInHospitalLocationCommand;
import com.fudanmed.platform.core.web.client.deliver.InHospitalLocationManagementPresenterView;
import com.fudanmed.platform.core.web.client.deliver.InHospitalLocationQueryListPresenter;
import com.fudanmed.platform.core.web.client.deliver.InHospitalLocationQueryListPresenterView;
import com.fudanmed.platform.core.web.client.deliver.UpdateInHospitalLocationCommand;
import com.fudanmed.platform.core.web.shared.deliver.UIInHospitalLocation;
import com.google.common.base.Function;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.widget.FramedPanel;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class InHospitalLocationManagementView extends GWTAbstractView implements InHospitalLocationManagementPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(createInHospitalLocationCommand,updateInHospitalLocationCommand,deleteInHospitalLocationCommand),
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
  
  private InHospitalLocationQueryListPresenter queryListPresenter;
  
  public void setQueryListPresenter(final InHospitalLocationQueryListPresenter queryListPresenter) {
    this.queryListPresenter = queryListPresenter;
  }
  
  @Inject
  private CreateInHospitalLocationCommand createInHospitalLocationCommand;
  
  @Inject
  private UpdateInHospitalLocationCommand updateInHospitalLocationCommand;
  
  @Inject
  private DeleteInHospitalLocationCommand deleteInHospitalLocationCommand;
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    InHospitalLocationQueryListPresenterView _view = this.queryListPresenter.getView();
    ActionContext<UIInHospitalLocation> _actionContext = _view.getActionContext();
    final Function1<UIInHospitalLocation,DLInHospitalLocationProxy> _function = new Function1<UIInHospitalLocation,DLInHospitalLocationProxy>() {
        public DLInHospitalLocationProxy apply(final UIInHospitalLocation it) {
          DLInHospitalLocationProxy _proxy = it.toProxy();
          return _proxy;
        }
      };
    final ActionContext<DLInHospitalLocationProxy> ac = _actionContext.<DLInHospitalLocationProxy>adapt(new Function<UIInHospitalLocation,DLInHospitalLocationProxy>() {
        public DLInHospitalLocationProxy apply(UIInHospitalLocation input) {
          return _function.apply(input);
        }
    });
    FramedPanel _FramedPanel = this.widgets.FramedPanel("\u75C5\u533A\u4FE1\u606F\u7EF4\u62A4");
    final Procedure1<FramedPanel> _function_1 = new Procedure1<FramedPanel>() {
        public void apply(final FramedPanel it) {
          InHospitalLocationQueryListPresenterView _view = InHospitalLocationManagementView.this.queryListPresenter.getView();
          Widget _asWidget = _view.asWidget();
          it.setWidget(_asWidget);
          it.addCommand(InHospitalLocationManagementView.this.createInHospitalLocationCommand);
          it.addCommand(ac, InHospitalLocationManagementView.this.updateInHospitalLocationCommand);
          it.addCommand(ac, InHospitalLocationManagementView.this.deleteInHospitalLocationCommand);
        }
      };
    FramedPanel _doubleArrow = ObjectExtensions.<FramedPanel>operator_doubleArrow(_FramedPanel, _function_1);
    this.con = _doubleArrow;
  }
}
