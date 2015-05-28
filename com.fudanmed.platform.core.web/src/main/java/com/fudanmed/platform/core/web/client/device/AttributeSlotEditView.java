package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.entityextension.proxy.RCAttributeSlotProxy;
import com.fudanmed.platform.core.web.client.device.AttributeSlotEditPresenterView;
import com.fudanmed.platform.core.web.client.device.AttributeSlotTreeListPresenter;
import com.fudanmed.platform.core.web.client.device.AttributeSlotTreeListPresenterView;
import com.fudanmed.platform.core.web.shared.device.UIAttributeSlot;
import com.google.common.base.Objects;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.box.ConfirmMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.info.Info;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.IHasSize;
import com.uniquesoft.gwt.client.common.widgets.IHasTitle;
import com.uniquesoft.gwt.client.common.widgets.Size;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.action.SingleObjectActions;
import edu.fudan.langlab.gxt.client.widget.ContentPanel;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class AttributeSlotEditView extends GWTAbstractView implements AttributeSlotEditPresenterView, IHasTitle, IHasSize {
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
  
  public String getTitle() {
    return "定义扩展技术参数";
  }
  
  public Size getSize() {
    return new com.uniquesoft.gwt.client.common.widgets.Size(800,500);
  }
  
  private AttributeSlotTreeListPresenter attributeSlotTreeListPresenter;
  
  public void setAttributeSlotTreeListPresenter(final AttributeSlotTreeListPresenter attributeSlotTreeListPresenter) {
    this.attributeSlotTreeListPresenter = attributeSlotTreeListPresenter;
  }
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    ContentPanel _ContentPanel = this.widgets.ContentPanel();
    final Procedure1<ContentPanel> _function = new Procedure1<ContentPanel>() {
        public void apply(final ContentPanel it) {
          AttributeSlotTreeListPresenterView _view = AttributeSlotEditView.this.attributeSlotTreeListPresenter.getView();
          Widget _asWidget = _view.asWidget();
          it.setWidget(_asWidget);
          AttributeSlotTreeListPresenterView _view_1 = AttributeSlotEditView.this.attributeSlotTreeListPresenter.getView();
          final ActionContext<UIAttributeSlot> ac = _view_1.getActionContext();
          final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
              public void apply(final SelectEvent it) {
                Iterable<UIAttributeSlot> _selectedObjects = ac.getSelectedObjects();
                final UIAttributeSlot selected = _selectedObjects==null?(UIAttributeSlot)null:IterableExtensions.<UIAttributeSlot>head(_selectedObjects);
                boolean _and = false;
                boolean _notEquals = (!Objects.equal(selected, null));
                if (!_notEquals) {
                  _and = false;
                } else {
                  Boolean _isPrimary = selected.getIsPrimary();
                  _and = (_notEquals && (_isPrimary).booleanValue());
                }
                if (_and) {
                  Info.display("\u9519\u8BEF", "\u8BE5\u57FA\u672C\u53C2\u6570\u4E0B\u65E0\u6CD5\u5EFA\u7ACB\u57FA\u672C\u53C2\u6570");
                } else {
                  Iterable<UIAttributeSlot> _selectedObjects_1 = ac.getSelectedObjects();
                  UIAttributeSlot _head = _selectedObjects_1==null?(UIAttributeSlot)null:IterableExtensions.<UIAttributeSlot>head(_selectedObjects_1);
                  RCAttributeSlotProxy _proxy = _head==null?(RCAttributeSlotProxy)null:_head.toProxy();
                  newParameterRequestRequestHandler.execute(_proxy);
                  
                }
              }
            };
          TextButton _TextButton = AttributeSlotEditView.this.widgets.TextButton("\u65B0\u5EFA\u57FA\u672C\u53C2\u6570", _function);
          it.addButton(_TextButton);
          final Procedure1<SelectEvent> _function_1 = new Procedure1<SelectEvent>() {
              public void apply(final SelectEvent it) {
                Iterable<UIAttributeSlot> _selectedObjects = ac.getSelectedObjects();
                final UIAttributeSlot selected = _selectedObjects==null?(UIAttributeSlot)null:IterableExtensions.<UIAttributeSlot>head(_selectedObjects);
                boolean _and = false;
                boolean _notEquals = (!Objects.equal(selected, null));
                if (!_notEquals) {
                  _and = false;
                } else {
                  Boolean _isPrimary = selected.getIsPrimary();
                  _and = (_notEquals && (_isPrimary).booleanValue());
                }
                if (_and) {
                  Info.display("\u9519\u8BEF", "\u8BE5\u57FA\u672C\u53C2\u6570\u65E0\u6CD5\u5EFA\u7ACB\u590D\u5408\u53C2\u6570");
                } else {
                  Iterable<UIAttributeSlot> _selectedObjects_1 = ac.getSelectedObjects();
                  UIAttributeSlot _head = _selectedObjects_1==null?(UIAttributeSlot)null:IterableExtensions.<UIAttributeSlot>head(_selectedObjects_1);
                  RCAttributeSlotProxy _proxy = _head==null?(RCAttributeSlotProxy)null:_head.toProxy();
                  newCategoryRequestRequestHandler.execute(_proxy);
                  
                }
              }
            };
          TextButton _TextButton_1 = AttributeSlotEditView.this.widgets.TextButton("\u65B0\u5EFA\u590D\u5408\u53C2\u6570", _function_1);
          it.addButton(_TextButton_1);
          final Procedure1<SingleObjectActions> _function_2 = new Procedure1<SingleObjectActions>() {
              public void apply(final SingleObjectActions it) {
                final Procedure1<UIAttributeSlot> _function = new Procedure1<UIAttributeSlot>() {
                    public void apply(final UIAttributeSlot slot) {
                      final Procedure1<Void> _function = new Procedure1<Void>() {
                          public void apply(final Void it) {
                            RCAttributeSlotProxy _proxy = slot.toProxy();
                            deleteAttributeRequestRequestHandler.execute(_proxy);
                            
                          }
                        };
                      ConfirmMessageBox _ConfirmMessageBox = AttributeSlotEditView.this.widgets.ConfirmMessageBox("\u786E\u8BA4", "\u6240\u6709\u5173\u8054\u8BBE\u5907\u4E2D\u7684\u53C2\u6570\u90FD\u5C06\u88AB\u5220\u9664!", _function);
                      _ConfirmMessageBox.show();
                    }
                  };
                it.onExecute(_function);
              }
            };
          SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UIAttributeSlot>onSingleObjectAction(ac, _function_2);
          TextButton _asButtonRequester = _onSingleObjectAction.asButtonRequester("\u5220\u9664\u53C2\u6570");
          it.addButton(_asButtonRequester);
        }
      };
    ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function);
    this.con = _doubleArrow;
  }
  
  private RequestHandler1<RCAttributeSlotProxy> newParameterRequestRequestHandler;
  
  public void newParameterRequest(final RequestHandler1<RCAttributeSlotProxy> requestHandler) {
    this.newParameterRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCAttributeSlotProxy> newCategoryRequestRequestHandler;
  
  public void newCategoryRequest(final RequestHandler1<RCAttributeSlotProxy> requestHandler) {
    this.newCategoryRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCAttributeSlotProxy> deleteAttributeRequestRequestHandler;
  
  public void deleteAttributeRequest(final RequestHandler1<RCAttributeSlotProxy> requestHandler) {
    this.deleteAttributeRequestRequestHandler = requestHandler;
  }
}
