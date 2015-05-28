package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceProxy;
import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.measure.CreateMeasureValueCommand;
import com.fudanmed.platform.core.web.client.measure.DeleteMeasureValueCommand;
import com.fudanmed.platform.core.web.client.measure.MeasureDeviceListPresenter;
import com.fudanmed.platform.core.web.client.measure.MeasureDeviceListPresenterView;
import com.fudanmed.platform.core.web.client.measure.MeasureDeviceTypeListPresenter;
import com.fudanmed.platform.core.web.client.measure.MeasureDeviceTypeListPresenterView;
import com.fudanmed.platform.core.web.client.measure.MeasureDeviceValueManagementPresenterView;
import com.fudanmed.platform.core.web.client.measure.MeasureValueQueryListDispatcher;
import com.fudanmed.platform.core.web.client.measure.ModifyMeasureValueCommand;
import com.fudanmed.platform.core.web.shared.measure.UIMeasureDevice;
import com.fudanmed.platform.core.web.shared.measure.UIMeasureDeviceType;
import com.google.common.base.Function;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.IPresenterContainer;
import com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider.SelectionChangedListener;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.widget.ContentPanel;
import edu.fudan.langlab.gxt.client.widget.FramedPanel;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class MeasureDeviceValueManagementView extends GWTAbstractView implements MeasureDeviceValueManagementPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(createMeasureValueCommand,modifyMeasureValueCommand,deleteMeasureValueCommand,dispatcher),
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
  
  private MeasureDeviceTypeListPresenter measureDeviceTypeListPresenter;
  
  public void setMeasureDeviceTypeListPresenter(final MeasureDeviceTypeListPresenter measureDeviceTypeListPresenter) {
    this.measureDeviceTypeListPresenter = measureDeviceTypeListPresenter;
  }
  
  private MeasureDeviceListPresenter measureDeviceListPresenter;
  
  public void setMeasureDeviceListPresenter(final MeasureDeviceListPresenter measureDeviceListPresenter) {
    this.measureDeviceListPresenter = measureDeviceListPresenter;
  }
  
  @Inject
  private CreateMeasureValueCommand createMeasureValueCommand;
  
  @Inject
  private ModifyMeasureValueCommand modifyMeasureValueCommand;
  
  @Inject
  private DeleteMeasureValueCommand deleteMeasureValueCommand;
  
  @Inject
  private MeasureValueQueryListDispatcher dispatcher;
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    MeasureDeviceTypeListPresenterView _view = this.measureDeviceTypeListPresenter.getView();
    ActionContext<UIMeasureDeviceType> _actionContext = _view.getActionContext();
    final Function1<UIMeasureDeviceType,RCMeasureDeviceTypeProxy> _function = new Function1<UIMeasureDeviceType,RCMeasureDeviceTypeProxy>() {
        public RCMeasureDeviceTypeProxy apply(final UIMeasureDeviceType it) {
          RCMeasureDeviceTypeProxy _proxy = it.toProxy();
          return _proxy;
        }
      };
    final ActionContext<RCMeasureDeviceTypeProxy> deviceTypeAc = _actionContext.<RCMeasureDeviceTypeProxy>adapt(new Function<UIMeasureDeviceType,RCMeasureDeviceTypeProxy>() {
        public RCMeasureDeviceTypeProxy apply(UIMeasureDeviceType input) {
          return _function.apply(input);
        }
    });
    MeasureDeviceListPresenterView _view_1 = this.measureDeviceListPresenter.getView();
    ActionContext<UIMeasureDevice> _actionContext_1 = _view_1.getActionContext();
    final Function1<UIMeasureDevice,RCMeasureDeviceProxy> _function_1 = new Function1<UIMeasureDevice,RCMeasureDeviceProxy>() {
        public RCMeasureDeviceProxy apply(final UIMeasureDevice it) {
          RCMeasureDeviceProxy _proxy = it.toProxy();
          return _proxy;
        }
      };
    final ActionContext<RCMeasureDeviceProxy> deviceAc = _actionContext_1.<RCMeasureDeviceProxy>adapt(new Function<UIMeasureDevice,RCMeasureDeviceProxy>() {
        public RCMeasureDeviceProxy apply(UIMeasureDevice input) {
          return _function_1.apply(input);
        }
    });
    FramedPanel _FramedPanel = this.widgets.FramedPanel("\u6284\u8868");
    final Procedure1<FramedPanel> _function_2 = new Procedure1<FramedPanel>() {
        public void apply(final FramedPanel it) {
          HorizontalLayoutContainer _HLayout = MeasureDeviceValueManagementView.this.widgets.HLayout();
          final Procedure1<HorizontalLayoutContainer> _function = new Procedure1<HorizontalLayoutContainer>() {
              public void apply(final HorizontalLayoutContainer it) {
                VerticalLayoutContainer _VLayout = MeasureDeviceValueManagementView.this.widgets.VLayout();
                final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
                    public void apply(final VerticalLayoutContainer it) {
                      MeasureDeviceTypeListPresenterView _view = MeasureDeviceValueManagementView.this.measureDeviceTypeListPresenter.getView();
                      Widget _asWidget = _view.asWidget();
                      VerticalLayoutData _VLayoutData = MeasureDeviceValueManagementView.this.widgets.VLayoutData(1, 0.4);
                      it.add(_asWidget, _VLayoutData);
                      MeasureDeviceListPresenterView _view_1 = MeasureDeviceValueManagementView.this.measureDeviceListPresenter.getView();
                      Widget _asWidget_1 = _view_1.asWidget();
                      VerticalLayoutData _VLayoutData_1 = MeasureDeviceValueManagementView.this.widgets.VLayoutData(1, 0.6);
                      it.add(_asWidget_1, _VLayoutData_1);
                    }
                  };
                VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
                HorizontalLayoutData _HLayoutData = MeasureDeviceValueManagementView.this.widgets.HLayoutData(0.3, 1);
                it.add(_doubleArrow, _HLayoutData);
                ContentPanel _ContentPanel = MeasureDeviceValueManagementView.this.widgets.ContentPanel();
                final Procedure1<ContentPanel> _function_1 = new Procedure1<ContentPanel>() {
                    public void apply(final ContentPanel it) {
                      IPresenterContainer _PresenterContainer = MeasureDeviceValueManagementView.this.widgets.PresenterContainer();
                      IPresenterContainer _container = MeasureDeviceValueManagementView.this.dispatcher.container = _PresenterContainer;
                      Widget _asWidget = _container.asWidget();
                      it.setWidget(_asWidget);
                      it.addCommand(deviceAc, MeasureDeviceValueManagementView.this.createMeasureValueCommand);
                    }
                  };
                ContentPanel _doubleArrow_1 = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function_1);
                HorizontalLayoutData _HLayoutData_1 = MeasureDeviceValueManagementView.this.widgets.HLayoutData(0.7, 1);
                it.add(_doubleArrow_1, _HLayoutData_1);
                final Procedure1<Iterable<RCMeasureDeviceProxy>> _function_2 = new Procedure1<Iterable<RCMeasureDeviceProxy>>() {
                    public void apply(final Iterable<RCMeasureDeviceProxy> it) {
                      RCMeasureDeviceProxy _head = IterableExtensions.<RCMeasureDeviceProxy>head(it);
                      MeasureDeviceValueManagementView.this.dispatcher.execute(_head);
                    }
                  };
                deviceAc.addSelectionChangedListener(new SelectionChangedListener<RCMeasureDeviceProxy>() {
                    public void selectionChanged(Iterable<RCMeasureDeviceProxy> selections) {
                      _function_2.apply(selections);
                    }
                });
              }
            };
          HorizontalLayoutContainer _doubleArrow = ObjectExtensions.<HorizontalLayoutContainer>operator_doubleArrow(_HLayout, _function);
          it.setWidget(_doubleArrow);
        }
      };
    FramedPanel _doubleArrow = ObjectExtensions.<FramedPanel>operator_doubleArrow(_FramedPanel, _function_2);
    this.con = _doubleArrow;
  }
}
