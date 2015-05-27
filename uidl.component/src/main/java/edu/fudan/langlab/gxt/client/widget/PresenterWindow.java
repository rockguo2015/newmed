package edu.fudan.langlab.gxt.client.widget;

import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.Header;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.event.HideEvent;
import com.sencha.gxt.widget.core.client.event.HideEvent.HideHandler;
import com.uniquesoft.gwt.client.common.Presenter;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.IHasSize;
import com.uniquesoft.gwt.client.common.widgets.IHasTitle;
import com.uniquesoft.gwt.client.common.widgets.Size;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class PresenterWindow {
  private Presenter<? extends Viewer> presenter;
  
  private Window window;
  
  public PresenterWindow(final Presenter<? extends Viewer> p) {
    this.presenter = p;
  }
  
  public void showWindow() {
    Window _window = new Window();
    final Procedure1<Window> _function = new Procedure1<Window>() {
        public void apply(final Window it) {
          it.setModal(true);
          it.setResizable(false);
          it.setMaximizable(false);
        }
      };
    Window _doubleArrow = ObjectExtensions.<Window>operator_doubleArrow(_window, _function);
    this.window = _doubleArrow;
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {
          Viewer _view = PresenterWindow.this.presenter.getView();
          Widget _asWidget = _view.asWidget();
          PresenterWindow.this.window.setWidget(_asWidget);
          Viewer _view_1 = PresenterWindow.this.presenter.getView();
          if ((_view_1 instanceof IHasSize)) {
            Viewer _view_2 = PresenterWindow.this.presenter.getView();
            Size size = ((IHasSize) _view_2).getSize();
            int _height = size.getHeight();
            boolean _notEquals = (_height != 0);
            if (_notEquals) {
              int _height_1 = size.getHeight();
              PresenterWindow.this.window.setHeight(_height_1);
            }
            int _width = size.getWidth();
            boolean _notEquals_1 = (_width != 0);
            if (_notEquals_1) {
              int _width_1 = size.getWidth();
              PresenterWindow.this.window.setWidth(_width_1);
            }
          } else {
            PresenterWindow.this.window.maximize();
          }
          Viewer _view_3 = PresenterWindow.this.presenter.getView();
          if ((_view_3 instanceof IHasTitle)) {
            Viewer _view_4 = PresenterWindow.this.presenter.getView();
            String _title = ((IHasTitle) _view_4).getTitle();
            PresenterWindow.this.window.setHeadingText(_title);
          }
        }
      };
    this.presenter.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function_1.apply(v);
        }
    });
    final Procedure1<HideEvent> _function_2 = new Procedure1<HideEvent>() {
        public void apply(final HideEvent it) {
          PresenterWindow.this.presenter.deactivate();
        }
      };
    this.window.addHideHandler(new HideHandler() {
        public void onHide(HideEvent event) {
          _function_2.apply(event);
        }
    });
    this.window.show();
  }
  
  public void showActivatedWindow() {
    Window _window = new Window();
    final Procedure1<Window> _function = new Procedure1<Window>() {
        public void apply(final Window it) {
          it.setModal(true);
          it.setResizable(false);
          it.setMaximizable(false);
        }
      };
    Window _doubleArrow = ObjectExtensions.<Window>operator_doubleArrow(_window, _function);
    this.window = _doubleArrow;
    Viewer _view = this.presenter.getView();
    Widget _asWidget = _view.asWidget();
    this.window.setWidget(_asWidget);
    Viewer _view_1 = this.presenter.getView();
    if ((_view_1 instanceof IHasSize)) {
      Viewer _view_2 = this.presenter.getView();
      Size size = ((IHasSize) _view_2).getSize();
      int _height = size.getHeight();
      boolean _notEquals = (_height != 0);
      if (_notEquals) {
        int _height_1 = size.getHeight();
        this.window.setHeight(_height_1);
      }
      int _width = size.getWidth();
      boolean _notEquals_1 = (_width != 0);
      if (_notEquals_1) {
        int _width_1 = size.getWidth();
        this.window.setWidth(_width_1);
      }
    }
    Viewer _view_3 = this.presenter.getView();
    if ((_view_3 instanceof IHasTitle)) {
      Viewer _view_4 = this.presenter.getView();
      String _title = ((IHasTitle) _view_4).getTitle();
      this.window.setHeadingText(_title);
    } else {
      Header _header = this.window.getHeader();
      _header.setVisible(false);
    }
    final Procedure1<HideEvent> _function_1 = new Procedure1<HideEvent>() {
        public void apply(final HideEvent it) {
          PresenterWindow.this.presenter.deactivate();
        }
      };
    this.window.addHideHandler(new HideHandler() {
        public void onHide(HideEvent event) {
          _function_1.apply(event);
        }
    });
    this.window.show();
    Viewer _view_5 = this.presenter.getView();
    boolean _not = (!(_view_5 instanceof IHasSize));
    if (_not) {
      this.window.maximize();
    }
  }
}
