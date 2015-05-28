package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.measure.DeviceListDispatcher;
import com.fudanmed.platform.core.web.client.measure.MeasureDeviceListPresenter;
import com.fudanmed.platform.core.web.client.measure.MeasureDeviceManagementPresenterView;
import com.fudanmed.platform.core.web.client.measure.MeasureDeviceTypeListPresenter;
import com.fudanmed.platform.core.web.client.measure.MeasureDeviceTypeListPresenterView;
import com.fudanmed.platform.core.web.shared.measure.UIMeasureDeviceType;
import com.google.common.base.Function;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.IPresenterContainer;
import com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider.SelectionChangedListener;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.widget.FramedPanel;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class MeasureDeviceManagementView extends GWTAbstractView implements MeasureDeviceManagementPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(dispatcher),
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
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  private IPresenterContainer deviceListEditorContainer;
  
  @Inject
  private DeviceListDispatcher dispatcher;
  
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
    FramedPanel _FramedPanel = this.widgets.FramedPanel("\u6284\u8868\u8BBE\u5907\u7EF4\u62A4");
    final Procedure1<FramedPanel> _function_1 = new Procedure1<FramedPanel>() {
        public void apply(final FramedPanel it) {
          HorizontalLayoutContainer _HLayout = MeasureDeviceManagementView.this.widgets.HLayout();
          final Procedure1<HorizontalLayoutContainer> _function = new Procedure1<HorizontalLayoutContainer>() {
              public void apply(final HorizontalLayoutContainer it) {
                MeasureDeviceTypeListPresenterView _view = MeasureDeviceManagementView.this.measureDeviceTypeListPresenter.getView();
                Widget _asWidget = _view.asWidget();
                HorizontalLayoutData _HLayoutData = MeasureDeviceManagementView.this.widgets.HLayoutData(0.4, 1);
                it.add(_asWidget, _HLayoutData);
                IPresenterContainer _PresenterContainer = MeasureDeviceManagementView.this.widgets.PresenterContainer();
                IPresenterContainer _deviceListEditorContainer = MeasureDeviceManagementView.this.deviceListEditorContainer = _PresenterContainer;
                Widget _asWidget_1 = _deviceListEditorContainer.asWidget();
                HorizontalLayoutData _HLayoutData_1 = MeasureDeviceManagementView.this.widgets.HLayoutData(0.6, 1);
                it.add(_asWidget_1, _HLayoutData_1);
                MeasureDeviceManagementView.this.dispatcher.container = MeasureDeviceManagementView.this.deviceListEditorContainer;
                final Procedure1<Iterable<RCMeasureDeviceTypeProxy>> _function = new Procedure1<Iterable<RCMeasureDeviceTypeProxy>>() {
                    public void apply(final Iterable<RCMeasureDeviceTypeProxy> it) {
                      RCMeasureDeviceTypeProxy _head = IterableExtensions.<RCMeasureDeviceTypeProxy>head(it);
                      MeasureDeviceManagementView.this.dispatcher.execute(_head);
                    }
                  };
                deviceTypeAc.addSelectionChangedListener(new SelectionChangedListener<RCMeasureDeviceTypeProxy>() {
                    public void selectionChanged(Iterable<RCMeasureDeviceTypeProxy> selections) {
                      _function.apply(selections);
                    }
                });
              }
            };
          HorizontalLayoutContainer _doubleArrow = ObjectExtensions.<HorizontalLayoutContainer>operator_doubleArrow(_HLayout, _function);
          it.setWidget(_doubleArrow);
        }
      };
    FramedPanel _doubleArrow = ObjectExtensions.<FramedPanel>operator_doubleArrow(_FramedPanel, _function_1);
    this.con = _doubleArrow;
  }
}
