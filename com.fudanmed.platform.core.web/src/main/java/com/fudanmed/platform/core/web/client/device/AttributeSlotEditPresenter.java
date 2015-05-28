package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.entityextension.proxy.RCAttributeSlotProxy;
import com.fudanmed.platform.core.entityextension.proxy.RCExtensiableEntityProxy;
import com.fudanmed.platform.core.web.client.device.AttributeSlotEditPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.AttributeSlotEditPresenterView;
import com.fudanmed.platform.core.web.client.device.AttributeSlotTreeListPresenter;
import com.fudanmed.platform.core.web.client.device.CreateCompositeTypePresenter;
import com.fudanmed.platform.core.web.client.device.CreatePrimaryTypePresenter;
import com.google.common.base.Objects;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class AttributeSlotEditPresenter extends WorkbenchAbstractPresenter<AttributeSlotEditPresenterView> {
  @Inject
  protected AttributeSlotEditPresenterServiceAsync _service;
  
  @Inject
  public AttributeSlotEditPresenter(final AttributeSlotEditPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public AttributeSlotTreeListPresenter initPart(final AttributeSlotTreeListPresenter part) {
    this.registerPart(part);
    this.getView().setAttributeSlotTreeListPresenter(part);
    return part;
    
  }
  
  @Inject
  private AttributeSlotTreeListPresenter attributeSlotTreeListPresenter;
  
  @Inject
  private Provider<CreatePrimaryTypePresenter> createPrimaryTypePresenter;
  
  @Inject
  private Provider<CreateCompositeTypePresenter> createCompositeTypePresenter;
  
  private RCExtensiableEntityProxy extensiableEntity;
  
  public void setup(final RCExtensiableEntityProxy extensiableEntity, final IPresenterInitiazerNotifier<AttributeSlotEditPresenter> _notifier) {
    
    this.extensiableEntity = extensiableEntity;
    AttributeSlotTreeListPresenter _initPart = this.initPart(this.attributeSlotTreeListPresenter);
    final Procedure1<AttributeSlotTreeListPresenter> _function = new Procedure1<AttributeSlotTreeListPresenter>() {
        public void apply(final AttributeSlotTreeListPresenter it) {
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {_notifier.done(AttributeSlotEditPresenter.this);
              }
            };
          AttributeSlotEditPresenter.this.activate(new IPostInitializeAction() {
              public void initializeFinished(Void v) {
                _function.apply(v);
              }
          });
        }
      };
    _initPart.setup(extensiableEntity, new IPresenterInitiazerNotifier<AttributeSlotTreeListPresenter>() {
        public void done(AttributeSlotTreeListPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  public void view_newParameterRequestExecution(final RCAttributeSlotProxy slot) {
    
    boolean _equals = Objects.equal(slot, null);
    if (_equals) {
      CreatePrimaryTypePresenter _get = this.createPrimaryTypePresenter.get();
      final Procedure1<CreatePrimaryTypePresenter> _function = new Procedure1<CreatePrimaryTypePresenter>() {
          public void apply(final CreatePrimaryTypePresenter it) {
            eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
            
          }
        };
      _get.setup4ExtensiableEntity(this.extensiableEntity, _function);
    } else {
      CreatePrimaryTypePresenter _get_1 = this.createPrimaryTypePresenter.get();
      final Procedure1<CreatePrimaryTypePresenter> _function_1 = new Procedure1<CreatePrimaryTypePresenter>() {
          public void apply(final CreatePrimaryTypePresenter it) {
            eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
            
          }
        };
      _get_1.setup4CompositeSlot(slot, _function_1);
    }
  }
  
  public void view_deleteAttributeRequestExecution(final RCAttributeSlotProxy slot) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.AttributeSlotDeletedEvent(slot));
          
        }
      };
    AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
    _service.deleteSlotAttribute(slot, _onSuccess);
  }
  
  public void view_newCategoryRequestExecution(final RCAttributeSlotProxy slot) {
    
    boolean _equals = Objects.equal(slot, null);
    if (_equals) {
      CreateCompositeTypePresenter _get = this.createCompositeTypePresenter.get();
      final Procedure1<CreateCompositeTypePresenter> _function = new Procedure1<CreateCompositeTypePresenter>() {
          public void apply(final CreateCompositeTypePresenter it) {
            eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
            
          }
        };
      _get.setup4ExtensiableEntity(this.extensiableEntity, _function);
    } else {
      CreateCompositeTypePresenter _get_1 = this.createCompositeTypePresenter.get();
      final Procedure1<CreateCompositeTypePresenter> _function_1 = new Procedure1<CreateCompositeTypePresenter>() {
          public void apply(final CreateCompositeTypePresenter it) {
            eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
            
          }
        };
      _get_1.setup4CompositeSlot(slot, _function_1);
    }
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().newParameterRequest(new RequestHandler1<RCAttributeSlotProxy>(){
    			
    			public void execute(RCAttributeSlotProxy slot){
    				view_newParameterRequestExecution(slot);
    			}
    			
    		});
    getView().deleteAttributeRequest(new RequestHandler1<RCAttributeSlotProxy>(){
    			
    			public void execute(RCAttributeSlotProxy slot){
    				view_deleteAttributeRequestExecution(slot);
    			}
    			
    		});
    getView().newCategoryRequest(new RequestHandler1<RCAttributeSlotProxy>(){
    			
    			public void execute(RCAttributeSlotProxy slot){
    				view_newCategoryRequestExecution(slot);
    			}
    			
    		});
    
  }
}
