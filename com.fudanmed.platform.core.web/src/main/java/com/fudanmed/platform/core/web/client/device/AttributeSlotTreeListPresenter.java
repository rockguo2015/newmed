package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.entityextension.proxy.RCAttributeSlotProxy;
import com.fudanmed.platform.core.entityextension.proxy.RCExtensiableEntityProxy;
import com.fudanmed.platform.core.web.client.device.AttributeSlotTreeListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.AttributeSlotTreeListPresenterView;
import com.fudanmed.platform.core.web.client.device.DateValueEditorPresenter;
import com.fudanmed.platform.core.web.client.device.NumberValueEditorPresenter;
import com.fudanmed.platform.core.web.client.device.RangeValueEditorPresenter;
import com.fudanmed.platform.core.web.client.device.StringValueEditorPresenter;
import com.fudanmed.platform.core.web.shared.device.UIAttributeSlot;
import com.fudanmed.platform.core.web.shared.device.UIPrimaryTypeEnum;
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

public class AttributeSlotTreeListPresenter extends WorkbenchAbstractPresenter<AttributeSlotTreeListPresenterView> {
  @Inject
  protected AttributeSlotTreeListPresenterServiceAsync _service;
  
  @Inject
  public AttributeSlotTreeListPresenter(final AttributeSlotTreeListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private RCExtensiableEntityProxy context;
  
  @Inject
  private Provider<NumberValueEditorPresenter> numberValueEditorPresenter;
  
  @Inject
  private Provider<RangeValueEditorPresenter> rangeValueEditorPresenter;
  
  @Inject
  private Provider<StringValueEditorPresenter> stringValueEditorPresenter;
  
  @Inject
  private Provider<DateValueEditorPresenter> dateValueEditorPresenter;
  
  public void setup(final IPresenterInitiazerNotifier<AttributeSlotTreeListPresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(AttributeSlotTreeListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup(final RCExtensiableEntityProxy context, final IPresenterInitiazerNotifier<AttributeSlotTreeListPresenter> _notifier) {
    
    this.context = context;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          AttributeSlotTreeListPresenter.this.refresh();_notifier.done(AttributeSlotTreeListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setExtensiableEntity(final RCExtensiableEntityProxy context) {
    
    this.context = context;
    this.refresh();
  }
  
  public void view_editSlotValueRequestExecution(final UIAttributeSlot slot) {
    
    UIPrimaryTypeEnum _typeEnum = slot.getTypeEnum();
    final UIPrimaryTypeEnum _switchValue = _typeEnum;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_switchValue,UIPrimaryTypeEnum.number)) {
        _matched=true;
        NumberValueEditorPresenter _get = this.numberValueEditorPresenter.get();
        RCAttributeSlotProxy _proxy = slot.toProxy();
        final Procedure1<NumberValueEditorPresenter> _function = new Procedure1<NumberValueEditorPresenter>() {
            public void apply(final NumberValueEditorPresenter it) {
              getView().activateEditor(it);
              
            }
          };
        _get.setup4Number(_proxy, _function);
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,UIPrimaryTypeEnum.numberWithUnit)) {
        _matched=true;
        NumberValueEditorPresenter _get_1 = this.numberValueEditorPresenter.get();
        RCAttributeSlotProxy _proxy_1 = slot.toProxy();
        final Procedure1<NumberValueEditorPresenter> _function_1 = new Procedure1<NumberValueEditorPresenter>() {
            public void apply(final NumberValueEditorPresenter it) {
              getView().activateEditor(it);
              
            }
          };
        _get_1.setup4NumberWithUnit(_proxy_1, _function_1);
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,UIPrimaryTypeEnum.range)) {
        _matched=true;
        RangeValueEditorPresenter _get_2 = this.rangeValueEditorPresenter.get();
        RCAttributeSlotProxy _proxy_2 = slot.toProxy();
        final Procedure1<RangeValueEditorPresenter> _function_2 = new Procedure1<RangeValueEditorPresenter>() {
            public void apply(final RangeValueEditorPresenter it) {
              getView().activateEditor(it);
              
            }
          };
        _get_2.setup(_proxy_2, _function_2);
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,UIPrimaryTypeEnum.string)) {
        _matched=true;
        StringValueEditorPresenter _get_3 = this.stringValueEditorPresenter.get();
        RCAttributeSlotProxy _proxy_3 = slot.toProxy();
        final Procedure1<StringValueEditorPresenter> _function_3 = new Procedure1<StringValueEditorPresenter>() {
            public void apply(final StringValueEditorPresenter it) {
              getView().activateEditor(it);
              
            }
          };
        _get_3.setup(_proxy_3, _function_3);
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,UIPrimaryTypeEnum.date)) {
        _matched=true;
        DateValueEditorPresenter _get_4 = this.dateValueEditorPresenter.get();
        RCAttributeSlotProxy _proxy_4 = slot.toProxy();
        final Procedure1<DateValueEditorPresenter> _function_4 = new Procedure1<DateValueEditorPresenter>() {
            public void apply(final DateValueEditorPresenter it) {
              getView().activateEditor(it);
              
            }
          };
        _get_4.setup(_proxy_4, _function_4);
      }
    }
    if (!_matched) {getView().deactivateEditor();
      
    }
  }
  
  public void refresh() {
    
    boolean _notEquals = (!Objects.equal(this.context, null));
    if (_notEquals) {
      final Procedure1<Collection<UIAttributeSlot>> _function = new Procedure1<Collection<UIAttributeSlot>>() {
          public void apply(final Collection<UIAttributeSlot> items) {
            getView().setResults(items);
            
          }
        };
      AsyncCallback<Collection<UIAttributeSlot>> _onSuccess = this.<Collection<UIAttributeSlot>>onSuccess(_function);
      _service.loadAttributeSlotList(this.context, _onSuccess);
    }
  }
  
  public void _eventbus_AttributeSlotAdded(final UIAttributeSlot slot) {
    
    this.refresh();
  }
  
  public void _eventbus_AttributeSlotChanged(final UIAttributeSlot slot) {
    
    getView().updateSlot(slot);
    
  }
  
  public void _eventbus_AttributeSlotDeleted(final RCAttributeSlotProxy slot) {
    
    this.refresh();
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().editSlotValueRequest(new RequestHandler1<UIAttributeSlot>(){
    			
    			public void execute(UIAttributeSlot slot){
    				view_editSlotValueRequestExecution(slot);
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.device.AttributeSlotAddedEvent.__type__, new com.fudanmed.platform.core.web.client.device.AttributeSlotAddedHandler(){
    public void AttributeSlotAdded(com.fudanmed.platform.core.web.shared.device.UIAttributeSlot slot){
    	_eventbus_AttributeSlotAdded(slot);
    }
    }));
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.device.AttributeSlotChangedEvent.__type__, new com.fudanmed.platform.core.web.client.device.AttributeSlotChangedHandler(){
    public void AttributeSlotChanged(com.fudanmed.platform.core.web.shared.device.UIAttributeSlot slot){
    	_eventbus_AttributeSlotChanged(slot);
    }
    }));
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.device.AttributeSlotDeletedEvent.__type__, new com.fudanmed.platform.core.web.client.device.AttributeSlotDeletedHandler(){
    public void AttributeSlotDeleted(com.fudanmed.platform.core.entityextension.proxy.RCAttributeSlotProxy slot){
    	_eventbus_AttributeSlotDeleted(slot);
    }
    }));
    
  }
}
