package edu.fudan.langlab.gxt.client.dialog;

import com.sencha.gxt.widget.core.client.Header;
import com.uniquesoft.gwt.client.common.CommitablePresenter;
import com.uniquesoft.gwt.client.common.Presenter;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.widgets.IHasSize;
import com.uniquesoft.gwt.client.common.widgets.IHasTitle;
import com.uniquesoft.gwt.client.common.widgets.Size;
import edu.fudan.langlab.gxt.client.dialog.GXTDialog;

@SuppressWarnings("all")
public class DialogPresenterExtensions {
  public static GXTDialog asDialog(final CommitablePresenter dialogPresenter) {
    GXTDialog _xblockexpression = null;
    {
      GXTDialog _gXTDialog = new GXTDialog(dialogPresenter);
      GXTDialog result = _gXTDialog;
      final Viewer view = ((Presenter) dialogPresenter).getView();
      if ((view instanceof IHasTitle)) {
        String _title = ((IHasTitle) view).getTitle();
        result.setHeadingText(_title);
      }
      if ((view instanceof IHasSize)) {
        Viewer _view = ((Presenter) dialogPresenter).getView();
        Size size = ((IHasSize) _view).getSize();
        int _width = size.getWidth();
        result.setWidth(_width);
        int _height = size.getHeight();
        result.setHeight(_height);
      }
      result.show();
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  public static GXTDialog asActivatedDialog(final CommitablePresenter dialogPresenter) {
    GXTDialog _xblockexpression = null;
    {
      GXTDialog _gXTDialog = new GXTDialog(dialogPresenter, true);
      GXTDialog result = _gXTDialog;
      final Viewer view = ((Presenter) dialogPresenter).getView();
      if ((view instanceof IHasTitle)) {
        String _title = ((IHasTitle) view).getTitle();
        result.setHeadingText(_title);
      } else {
        Header _header = result.getHeader();
        _header.setVisible(false);
      }
      if ((view instanceof IHasSize)) {
        Viewer _view = ((Presenter) dialogPresenter).getView();
        Size size = ((IHasSize) _view).getSize();
        int _width = size.getWidth();
        result.setWidth(_width);
        int _height = size.getHeight();
        result.setHeight(_height);
      }
      result.show();
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  public static GXTDialog asDialog(final CommitablePresenter dialogPresenter, final String title) {
    GXTDialog _xblockexpression = null;
    {
      GXTDialog _gXTDialog = new GXTDialog(dialogPresenter);
      GXTDialog result = _gXTDialog;
      result.setHeadingText(title);
      Viewer _view = ((Presenter) dialogPresenter).getView();
      if ((_view instanceof IHasSize)) {
        Viewer _view_1 = ((Presenter) dialogPresenter).getView();
        Size size = ((IHasSize) _view_1).getSize();
        int _width = size.getWidth();
        result.setWidth(_width);
        int _height = size.getHeight();
        result.setHeight(_height);
      }
      result.show();
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  public static GXTDialog asDialog(final CommitablePresenter dialogPresenter, final String title, final Integer width) {
    GXTDialog _xblockexpression = null;
    {
      GXTDialog _gXTDialog = new GXTDialog(dialogPresenter);
      GXTDialog result = _gXTDialog;
      result.setHeadingText(title);
      result.setWidth((width).intValue());
      result.show();
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  public static GXTDialog asDialog(final CommitablePresenter dialogPresenter, final String title, final Integer width, final Integer height) {
    GXTDialog _xblockexpression = null;
    {
      GXTDialog _gXTDialog = new GXTDialog(dialogPresenter);
      GXTDialog result = _gXTDialog;
      result.setHeadingText(title);
      result.setWidth((width).intValue());
      result.setHeight((height).intValue());
      result.show();
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
}
