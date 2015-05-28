package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy;
import com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationDetailPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationDetailPresenterView;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ProductSpecificationDetailPresenter extends WorkbenchAbstractPresenter<ProductSpecificationDetailPresenterView> {
  @Inject
  protected ProductSpecificationDetailPresenterServiceAsync _service;
  
  @Inject
  public ProductSpecificationDetailPresenter(final ProductSpecificationDetailPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void setup(final Procedure1<? super ProductSpecificationDetailPresenter> postInit) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          postInit.apply(ProductSpecificationDetailPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setDetailInfo(final RCProductSpecificationProxy detail) {
    
    final Procedure1<UIProductSpecification> _function = new Procedure1<UIProductSpecification>() {
        public void apply(final UIProductSpecification it) {
          getView().showDetail(it);
          
        }
      };
    AsyncCallback<UIProductSpecification> _onSuccess = this.<UIProductSpecification>onSuccess(_function);
    _service.loadDetail(detail, _onSuccess);
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
