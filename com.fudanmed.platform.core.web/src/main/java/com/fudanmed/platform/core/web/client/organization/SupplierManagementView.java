package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCSupplierProxy;
import com.fudanmed.platform.core.web.client.organization.SupplierCriteriaForm;
import com.fudanmed.platform.core.web.client.organization.SupplierListGrid;
import com.fudanmed.platform.core.web.client.organization.SupplierManagementPresenterView;
import com.fudanmed.platform.core.web.shared.organization.UISupplier;
import com.fudanmed.platform.core.web.shared.organization.UISupplierCriteria;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.box.ConfirmMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.action.ActionExtensions;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.shared.common.pager.IPagedCriteria;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.action.SingleObjectActions;
import edu.fudan.langlab.gxt.client.widget.FramedPanel;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.PagedList;
import edu.fudan.langlab.security.client.Securities;
import edu.fudan.langlab.security.shared.IFunctionIdentifier;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class SupplierManagementView extends GWTAbstractView implements SupplierManagementPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(listGrid,criteriaForm),
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
  private SupplierListGrid listGrid;
  
  private PagedList<UISupplier,UISupplierCriteria> pagedList;
  
  @Inject
  private SupplierCriteriaForm criteriaForm;
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    final Function1<Void,UISupplierCriteria> _function = new Function1<Void,UISupplierCriteria>() {
        public UISupplierCriteria apply(final Void it) {
          UISupplierCriteria _value = SupplierManagementView.this.criteriaForm.getValue();
          return _value;
        }
      };
    final Procedure1<IPagedCriteria> _function_1 = new Procedure1<IPagedCriteria>() {
        public void apply(final IPagedCriteria it) {
          filterRequestRequestHandler.execute(((UISupplierCriteria) it));
          
        }
      };
    PagedList<UISupplier,UISupplierCriteria> _asPagedList = PagedList.<UISupplier, UISupplierCriteria>asPagedList(this.listGrid, _function, _function_1);
    this.pagedList = _asPagedList;
    final ActionContext<UISupplier> ac = ActionExtensions.<UISupplier>createActionContext(this.listGrid);
    final Procedure1<Void> _function_2 = new Procedure1<Void>() {
        public void apply(final Void it) {
          UISupplierCriteria _criteria = SupplierManagementView.this.pagedList.getCriteria();
          filterRequestRequestHandler.execute(_criteria);
          
        }
      };
    this.criteriaForm.setQueryRequest(_function_2);
    final Procedure1<SelectEvent> _function_3 = new Procedure1<SelectEvent>() {
        public void apply(final SelectEvent it) {createRequestRequestHandler.execute();
          
        }
      };
    final TextButton createButton = this.widgets.TextButton("\u65B0\u5EFA", _function_3);
    final Procedure1<SingleObjectActions> _function_4 = new Procedure1<SingleObjectActions>() {
        public void apply(final SingleObjectActions it) {
          final Procedure1<UISupplier> _function = new Procedure1<UISupplier>() {
              public void apply(final UISupplier selectedValue) {
                RCSupplierProxy _proxy = selectedValue.toProxy();
                modifyRequestRequestHandler.execute(_proxy);
                
              }
            };
          it.onExecute(_function);
        }
      };
    SingleObjectActions _onSingleObjectAction = SingleObjectActions.<UISupplier>onSingleObjectAction(ac, _function_4);
    final TextButton modifyButton = _onSingleObjectAction.asButtonRequester("\u4FEE\u6539");
    final Procedure1<SingleObjectActions> _function_5 = new Procedure1<SingleObjectActions>() {
        public void apply(final SingleObjectActions it) {
          final Procedure1<UISupplier> _function = new Procedure1<UISupplier>() {
              public void apply(final UISupplier selectedValue) {
                final Procedure1<Void> _function = new Procedure1<Void>() {
                    public void apply(final Void it) {
                      RCSupplierProxy _proxy = selectedValue.toProxy();
                      deleteRequestRequestHandler.execute(_proxy);
                      
                    }
                  };
                ConfirmMessageBox _ConfirmMessageBox = SupplierManagementView.this.widgets.ConfirmMessageBox("\u786E\u8BA4", "\u786E\u8BA4\u5220\u9664", _function);
                _ConfirmMessageBox.show();
              }
            };
          it.onExecute(_function);
        }
      };
    SingleObjectActions _onSingleObjectAction_1 = SingleObjectActions.<UISupplier>onSingleObjectAction(ac, _function_5);
    final TextButton deleteButton = _onSingleObjectAction_1.asButtonRequester("\u5220\u9664");
    FramedPanel _FramedPanel = this.widgets.FramedPanel("\u4F9B\u5E94\u5546\u7EF4\u62A4");
    final Procedure1<FramedPanel> _function_6 = new Procedure1<FramedPanel>() {
        public void apply(final FramedPanel it) {
          VerticalLayoutContainer _VLayout = SupplierManagementView.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                Widget _asWidget = SupplierManagementView.this.criteriaForm.asWidget();
                it.add(_asWidget);
                ContentPanel _asWidget_1 = SupplierManagementView.this.pagedList.asWidget();
                VerticalLayoutData _VLayoutData = SupplierManagementView.this.widgets.VLayoutData(1, 1);
                it.add(_asWidget_1, _VLayoutData);
              }
            };
          VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
          it.setWidget(_doubleArrow);
          final Procedure1<Void> _function_1 = new Procedure1<Void>() {
              public void apply(final Void v) {
                it.addButton(createButton);
              }
            };
          SupplierManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
            public IFunctionIdentifier apply() {
              return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.organization.SupplierManagementPresenter.createRequest" );
            }
          }.apply(), _function_1);
          final Procedure1<Void> _function_2 = new Procedure1<Void>() {
              public void apply(final Void v) {
                it.addButton(modifyButton);
              }
            };
          SupplierManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
            public IFunctionIdentifier apply() {
              return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.organization.SupplierManagementPresenter.modifyRequest" );
            }
          }.apply(), _function_2);
          final Procedure1<Void> _function_3 = new Procedure1<Void>() {
              public void apply(final Void v) {
                it.addButton(deleteButton);
              }
            };
          SupplierManagementView.this.securities.check(new Function0<IFunctionIdentifier>() {
            public IFunctionIdentifier apply() {
              return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.organization.SupplierManagementPresenter.deleteRequest" );
            }
          }.apply(), _function_3);
        }
      };
    FramedPanel _doubleArrow = ObjectExtensions.<FramedPanel>operator_doubleArrow(_FramedPanel, _function_6);
    this.con = _doubleArrow;
  }
  
  public void showResults(final IPagedResult<UISupplier> results) {
    this.pagedList.setResults(results);
  }
  
  public void refresh() {
    this.pagedList.refresh();
  }
  
  public void refreshNew(final RCSupplierProxy value) {
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          SupplierManagementView.this.pagedList.reveal(value);
        }
      };
    this.pagedList.refresh(_function);
  }
  
  private RequestHandler createRequestRequestHandler;
  
  public void createRequest(final RequestHandler requestHandler) {
    this.createRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCSupplierProxy> deleteRequestRequestHandler;
  
  public void deleteRequest(final RequestHandler1<RCSupplierProxy> requestHandler) {
    this.deleteRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<RCSupplierProxy> modifyRequestRequestHandler;
  
  public void modifyRequest(final RequestHandler1<RCSupplierProxy> requestHandler) {
    this.modifyRequestRequestHandler = requestHandler;
  }
  
  private RequestHandler1<UISupplierCriteria> filterRequestRequestHandler;
  
  public void filterRequest(final RequestHandler1<UISupplierCriteria> requestHandler) {
    this.filterRequestRequestHandler = requestHandler;
  }
}
