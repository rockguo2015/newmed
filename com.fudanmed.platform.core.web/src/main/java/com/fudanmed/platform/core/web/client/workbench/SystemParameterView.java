package com.fudanmed.platform.core.web.client.workbench;

import com.fudanmed.platform.core.web.client.workbench.SystemParameterDetailForm;
import com.fudanmed.platform.core.web.client.workbench.SystemParameterPresenterView;
import com.fudanmed.platform.core.web.shared.workbench.UISystemParameter;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.widget.FramedPanel;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import edu.fudan.langlab.security.shared.IFunctionIdentifier;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class SystemParameterView extends GWTAbstractView implements SystemParameterPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(form),
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
  
  private Widget con;
  
  @Inject
  private SystemParameterDetailForm form;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    FramedPanel _FramedPanel = this.widgets.FramedPanel("\u7CFB\u7EDF\u53C2\u6570\u8BBE\u7F6E");
    final Procedure1<FramedPanel> _function = new Procedure1<FramedPanel>() {
        public void apply(final FramedPanel it) {
          VerticalLayoutContainer _asWidget = SystemParameterView.this.form.asWidget();
          it.setWidget(_asWidget);
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void v) {
                final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                    public void apply(final SelectEvent it) {modifyParameterRequestRequestHandler.execute();
                      
                    }
                  };
                TextButton _TextButton = SystemParameterView.this.widgets.TextButton("\u4FEE\u6539", _function);
                it.addButton(_TextButton);
              }
            };
          SystemParameterView.this.securities.check(new Function0<IFunctionIdentifier>() {
            public IFunctionIdentifier apply() {
              return new edu.fudan.langlab.security.shared.FunctionIdentifier( "com.fudanmed.platform.core.web.client.workbench.SystemParameterPresenter.modifyParameterRequest" );
            }
          }.apply(), _function);
        }
      };
    FramedPanel _doubleArrow = ObjectExtensions.<FramedPanel>operator_doubleArrow(_FramedPanel, _function);
    this.con = _doubleArrow;
  }
  
  public void showParameter(final UISystemParameter value) {
    
    this.form.setValue(value);
  }
  
  private RequestHandler modifyParameterRequestRequestHandler;
  
  public void modifyParameterRequest(final RequestHandler requestHandler) {
    this.modifyParameterRequestRequestHandler = requestHandler;
  }
}
