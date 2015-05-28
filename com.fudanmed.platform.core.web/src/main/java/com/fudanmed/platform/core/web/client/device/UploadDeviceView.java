package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.DeviceListGrid;
import com.fudanmed.platform.core.web.client.device.DeviceUploadForm;
import com.fudanmed.platform.core.web.client.device.UploadDevicePresenterView;
import com.fudanmed.platform.core.web.shared.device.DeviceUploadData;
import com.fudanmed.platform.core.web.shared.device.UIDevice;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.IHasSize;
import com.uniquesoft.gwt.client.common.widgets.IHasTitle;
import com.uniquesoft.gwt.client.common.widgets.Size;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;
import com.uniquesoft.gwt.shared.datatype.File;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import edu.fudan.langlab.gxt.client.component.form.FormViewerImpl;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.WidgetExtensions;
import edu.fudan.langlab.security.client.Securities;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class UploadDeviceView extends FormViewerImpl<DeviceUploadData> implements UploadDevicePresenterView, IHasTitle, IHasSize {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(listGrid,form),
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
  private DeviceUploadForm form;
  
  public DeviceUploadForm doGetFormComponent() {
    return form;
  }
  
  public String getTitle() {
    return "设备导入";
  }
  
  public Size getSize() {
    return new com.uniquesoft.gwt.client.common.widgets.Size(800,430);
  }
  
  @Inject
  private DeviceListGrid listGrid;
  
  public void initialize() {
    
    VerticalLayoutContainer _VLayout = this.widgets.VLayout();
    final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
        public void apply(final VerticalLayoutContainer it) {
          Widget _asWidget = UploadDeviceView.this.form.asWidget();
          final Procedure1<Widget> _function = new Procedure1<Widget>() {
              public void apply(final Widget it) {
                final Procedure1<File> _function = new Procedure1<File>() {
                    public void apply(final File it) {fileUploadedRequestHandler.execute();
                      
                    }
                  };
                UploadDeviceView.this.form.file.addValueChangedListener(new ValueChangedListener<File>() {
                    public void onValueChanged(File value) {
                      _function.apply(value);
                    }
                });
              }
            };
          Widget _doubleArrow = ObjectExtensions.<Widget>operator_doubleArrow(_asWidget, _function);
          WidgetExtensions.<Widget>addFill(it, _doubleArrow);
          SGroupingGrid<UIDevice> _asWidget_1 = UploadDeviceView.this.listGrid.asWidget();
          VerticalLayoutData _VLayoutData = UploadDeviceView.this.widgets.VLayoutData(1, 350);
          it.add(_asWidget_1, _VLayoutData);
        }
      };
    VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
    ClientUi.operator_add(this, _doubleArrow);
  }
  
  public void setPreviewValues(final Collection<UIDevice> objects) {
    this.listGrid.setObjects(objects);
  }
  
  public Collection<UIDevice> getPreviewValues() {
    Iterable<UIDevice> _objects = this.listGrid.getObjects();
    Collection<UIDevice> _unlazy = IterableExtensions2.<UIDevice>unlazy(_objects);
    return _unlazy;
  }
  
  private RequestHandler fileUploadedRequestHandler;
  
  public void fileUploaded(final RequestHandler requestHandler) {
    this.fileUploadedRequestHandler = requestHandler;
  }
}
