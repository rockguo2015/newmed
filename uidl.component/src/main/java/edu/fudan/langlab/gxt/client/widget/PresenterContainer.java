package edu.fudan.langlab.gxt.client.widget;

import com.google.common.base.Objects;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.ResizeContainer;
import com.sencha.gxt.widget.core.client.container.SimpleContainer;
import com.uniquesoft.gwt.client.common.Presenter;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.IPresenterContainer;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class PresenterContainer implements IPresenterContainer {
  private SimpleContainer container = new Function0<SimpleContainer>() {
    public SimpleContainer apply() {
      SimpleContainer _simpleContainer = new SimpleContainer();
      return _simpleContainer;
    }
  }.apply();
  
  private Presenter activePresenter;
  
  public void showActivatedPresenter(final String title, final Presenter p) {
    boolean _notEquals = (!Objects.equal(this.activePresenter, null));
    if (_notEquals) {
      this.activePresenter.deactivate();
      Viewer _view = this.activePresenter.getView();
      Widget _asWidget = _view.asWidget();
      _asWidget.removeFromParent();
    }
    this.activePresenter = p;
    Viewer _view_1 = this.activePresenter.getView();
    final Widget w = _view_1.asWidget();
    ContentPanel _contentPanel = new ContentPanel();
    final Procedure1<ContentPanel> _function = new Procedure1<ContentPanel>() {
        public void apply(final ContentPanel result) {
          result.setBodyBorder(false);
          String _plus = ("<span style=\'font-size:12px;\'>" + title);
          String _plus_1 = (_plus + "</span>");
          result.setHeadingHtml(_plus_1);
          result.setWidget(w);
        }
      };
    ContentPanel c = ObjectExtensions.<ContentPanel>operator_doubleArrow(_contentPanel, _function);
    this.container.setWidget(c);
    if ((w instanceof ResizeContainer)) {
      ((ResizeContainer) w).forceLayout();
    }
    this.container.forceLayout();
  }
  
  public void showActivatedPresenter(final Presenter p) {
    boolean _notEquals = (!Objects.equal(this.activePresenter, null));
    if (_notEquals) {
      this.activePresenter.deactivate();
      Viewer _view = this.activePresenter.getView();
      Widget _asWidget = _view.asWidget();
      _asWidget.removeFromParent();
    }
    this.activePresenter = p;
    Viewer _view_1 = this.activePresenter.getView();
    Widget w = _view_1.asWidget();
    this.container.setWidget(w);
    if ((w instanceof ResizeContainer)) {
      ((ResizeContainer) w).forceLayout();
    }
    this.container.forceLayout();
  }
  
  public void showPresenter(final Presenter p) {
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
        }
      };
    this.showPresenter(p, _function);
  }
  
  public void showPresenter(final Presenter p, final Procedure1<? super Void> postInitializer) {
    boolean _notEquals = (!Objects.equal(this.activePresenter, null));
    if (_notEquals) {
      this.activePresenter.deactivate();
      Viewer _view = this.activePresenter.getView();
      Widget _asWidget = _view.asWidget();
      _asWidget.removeFromParent();
    }
    this.activePresenter = p;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          Viewer _view = PresenterContainer.this.activePresenter.getView();
          Widget w = _view.asWidget();
          PresenterContainer.this.container.setWidget(w);
          if ((w instanceof ResizeContainer)) {
            ((ResizeContainer) w).forceLayout();
          }
          PresenterContainer.this.container.forceLayout();
          postInitializer.apply(null);
        }
      };
    this.activePresenter.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public Widget asWidget() {
    return this.container;
  }
  
  public void destory() {
    boolean _notEquals = (!Objects.equal(this.activePresenter, null));
    if (_notEquals) {
      this.activePresenter.deactivate();
    }
  }
  
  public void clear() {
    boolean _notEquals = (!Objects.equal(this.activePresenter, null));
    if (_notEquals) {
      this.activePresenter.deactivate();
      Viewer _view = this.activePresenter.getView();
      Widget _asWidget = _view.asWidget();
      _asWidget.removeFromParent();
    }
    this.activePresenter = null;
  }
}
