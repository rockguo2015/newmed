package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialCategoryProxy;
import com.fudanmed.platform.core.web.client.deliver.DeliverMaterialCategoryListPresenter;
import com.fudanmed.platform.core.web.client.deliver.DeliverMaterialCategoryListPresenterView;
import com.fudanmed.platform.core.web.client.deliver.DeliverMaterialCategoryManagementPresenterView;
import com.fudanmed.platform.core.web.client.deliver.DeliverMaterialTypeQueryListPresenter;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverMaterialCategory;
import com.google.common.base.Function;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DeliverMaterialCategoryManagementPresenter extends WorkbenchAbstractPresenter<DeliverMaterialCategoryManagementPresenterView> {
  @Inject
  public DeliverMaterialCategoryManagementPresenter(final DeliverMaterialCategoryManagementPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public DeliverMaterialCategoryListPresenter initPart(final DeliverMaterialCategoryListPresenter part) {
    this.registerPart(part);
    this.getView().setQueryListPresenter(part);
    return part;
    
  }
  
  @Inject
  private DeliverMaterialCategoryListPresenter queryListPresenter;
  
  public DeliverMaterialTypeQueryListPresenter initPart(final DeliverMaterialTypeQueryListPresenter part) {
    this.registerPart(part);
    this.getView().setDeliverMaterialTypeQueryListPresenter(part);
    return part;
    
  }
  
  @Inject
  private DeliverMaterialTypeQueryListPresenter deliverMaterialTypeQueryListPresenter;
  
  public void setup(final IPresenterInitiazerNotifier<DeliverMaterialCategoryManagementPresenter> _notifier) {
    
    DeliverMaterialCategoryListPresenter _initPart = this.initPart(this.queryListPresenter);
    final Procedure1<DeliverMaterialCategoryListPresenter> _function = new Procedure1<DeliverMaterialCategoryListPresenter>() {
        public void apply(final DeliverMaterialCategoryListPresenter it) {
          DeliverMaterialTypeQueryListPresenter _initPart = DeliverMaterialCategoryManagementPresenter.this.initPart(DeliverMaterialCategoryManagementPresenter.this.deliverMaterialTypeQueryListPresenter);
          DeliverMaterialCategoryListPresenterView _view = DeliverMaterialCategoryManagementPresenter.this.queryListPresenter.getView();
          ActionContext<UIDeliverMaterialCategory> _actionContext = _view.getActionContext();
          final Function1<UIDeliverMaterialCategory,DLDeliverMaterialCategoryProxy> _function = new Function1<UIDeliverMaterialCategory,DLDeliverMaterialCategoryProxy>() {
              public DLDeliverMaterialCategoryProxy apply(final UIDeliverMaterialCategory it) {
                DLDeliverMaterialCategoryProxy _proxy = it.toProxy();
                return _proxy;
              }
            };
          ActionContext<DLDeliverMaterialCategoryProxy> _adapt = _actionContext.<DLDeliverMaterialCategoryProxy>adapt(new Function<UIDeliverMaterialCategory,DLDeliverMaterialCategoryProxy>() {
              public DLDeliverMaterialCategoryProxy apply(UIDeliverMaterialCategory input) {
                return _function.apply(input);
              }
          });
          final Procedure1<DeliverMaterialTypeQueryListPresenter> _function_1 = new Procedure1<DeliverMaterialTypeQueryListPresenter>() {
              public void apply(final DeliverMaterialTypeQueryListPresenter it) {
                final Procedure1<Void> _function = new Procedure1<Void>() {
                    public void apply(final Void it) {_notifier.done(DeliverMaterialCategoryManagementPresenter.this);
                    }
                  };
                DeliverMaterialCategoryManagementPresenter.this.activate(new IPostInitializeAction() {
                    public void initializeFinished(Void v) {
                      _function.apply(v);
                    }
                });
              }
            };
          _initPart.setup(_adapt, new IPresenterInitiazerNotifier<DeliverMaterialTypeQueryListPresenter>() {
              public void done(DeliverMaterialTypeQueryListPresenter presenter) {
                _function_1.apply(presenter);
              }
          });
        }
      };
    _initPart.setup(new IPresenterInitiazerNotifier<DeliverMaterialCategoryListPresenter>() {
        public void done(DeliverMaterialCategoryListPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    
  }
}
