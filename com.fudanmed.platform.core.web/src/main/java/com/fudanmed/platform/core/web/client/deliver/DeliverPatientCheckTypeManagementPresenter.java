package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckCategoryProxy;
import com.fudanmed.platform.core.web.client.deliver.DeliverPatientCheckCategoryListPresenter;
import com.fudanmed.platform.core.web.client.deliver.DeliverPatientCheckCategoryListPresenterView;
import com.fudanmed.platform.core.web.client.deliver.DeliverPatientCheckTypeManagementPresenterView;
import com.fudanmed.platform.core.web.client.deliver.DeliverPatientCheckTypeQueryListPresenter;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverPatientCheckCategory;
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

public class DeliverPatientCheckTypeManagementPresenter extends WorkbenchAbstractPresenter<DeliverPatientCheckTypeManagementPresenterView> {
  @Inject
  public DeliverPatientCheckTypeManagementPresenter(final DeliverPatientCheckTypeManagementPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public DeliverPatientCheckCategoryListPresenter initPart(final DeliverPatientCheckCategoryListPresenter part) {
    this.registerPart(part);
    this.getView().setCategoryQueryListPresenter(part);
    return part;
    
  }
  
  @Inject
  private DeliverPatientCheckCategoryListPresenter categoryQueryListPresenter;
  
  public DeliverPatientCheckTypeQueryListPresenter initPart(final DeliverPatientCheckTypeQueryListPresenter part) {
    this.registerPart(part);
    this.getView().setDeliverPatientCheckTypeQueryListPresenter(part);
    return part;
    
  }
  
  @Inject
  private DeliverPatientCheckTypeQueryListPresenter deliverPatientCheckTypeQueryListPresenter;
  
  public void setup(final IPresenterInitiazerNotifier<DeliverPatientCheckTypeManagementPresenter> _notifier) {
    
    DeliverPatientCheckCategoryListPresenter _initPart = this.initPart(this.categoryQueryListPresenter);
    final Procedure1<DeliverPatientCheckCategoryListPresenter> _function = new Procedure1<DeliverPatientCheckCategoryListPresenter>() {
        public void apply(final DeliverPatientCheckCategoryListPresenter it) {
          DeliverPatientCheckTypeQueryListPresenter _initPart = DeliverPatientCheckTypeManagementPresenter.this.initPart(DeliverPatientCheckTypeManagementPresenter.this.deliverPatientCheckTypeQueryListPresenter);
          DeliverPatientCheckCategoryListPresenterView _view = DeliverPatientCheckTypeManagementPresenter.this.categoryQueryListPresenter.getView();
          ActionContext<UIDeliverPatientCheckCategory> _actionContext = _view.getActionContext();
          final Function1<UIDeliverPatientCheckCategory,DLDeliverPatientCheckCategoryProxy> _function = new Function1<UIDeliverPatientCheckCategory,DLDeliverPatientCheckCategoryProxy>() {
              public DLDeliverPatientCheckCategoryProxy apply(final UIDeliverPatientCheckCategory it) {
                DLDeliverPatientCheckCategoryProxy _proxy = it.toProxy();
                return _proxy;
              }
            };
          ActionContext<DLDeliverPatientCheckCategoryProxy> _adapt = _actionContext.<DLDeliverPatientCheckCategoryProxy>adapt(new Function<UIDeliverPatientCheckCategory,DLDeliverPatientCheckCategoryProxy>() {
              public DLDeliverPatientCheckCategoryProxy apply(UIDeliverPatientCheckCategory input) {
                return _function.apply(input);
              }
          });
          final Procedure1<DeliverPatientCheckTypeQueryListPresenter> _function_1 = new Procedure1<DeliverPatientCheckTypeQueryListPresenter>() {
              public void apply(final DeliverPatientCheckTypeQueryListPresenter it) {
                final Procedure1<Void> _function = new Procedure1<Void>() {
                    public void apply(final Void it) {_notifier.done(DeliverPatientCheckTypeManagementPresenter.this);
                    }
                  };
                DeliverPatientCheckTypeManagementPresenter.this.activate(new IPostInitializeAction() {
                    public void initializeFinished(Void v) {
                      _function.apply(v);
                    }
                });
              }
            };
          _initPart.setup(_adapt, new IPresenterInitiazerNotifier<DeliverPatientCheckTypeQueryListPresenter>() {
              public void done(DeliverPatientCheckTypeQueryListPresenter presenter) {
                _function_1.apply(presenter);
              }
          });
        }
      };
    _initPart.setup(new IPresenterInitiazerNotifier<DeliverPatientCheckCategoryListPresenter>() {
        public void done(DeliverPatientCheckCategoryListPresenter presenter) {
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
