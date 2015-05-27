package com.uniquesoft.gwt.client.common.widgets.baregwt.component.dialog;

import com.uniquesoft.gwt.client.common.Presenter;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.dialog.Dialog;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.dialog.IManagableByDialog;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * this class is binded with com.uniquesoft.gwt.client.common.widgets.baregwt.component.dialog.IManagableByDialog.
 * we can see the connection in language com.uniquesoft.lang.gwtentity.scoping.featurecalls.UIExtensionClassNameProvider:
 * put("com.uniquesoft.gwt.client.common.widgets.baregwt.component.dialog.IManagableByDialog",newArrayList("com.uniquesoft.gwt.client.common.widgets.baregwt.component.dialog.DialogExtensions"))
 * In UIDL,can use it like this:
 * val p = gwtGridPresenter.get
 * p.asGWTDialog("List Grid")=>[
 * center
 * setWidth("800")
 * show
 * ]
 */
@SuppressWarnings("all")
public class DialogExtensions {
  public static Dialog asGWTDialog(final IManagableByDialog managableByDialog, final String title) {
    Dialog _xblockexpression = null;
    {
      Dialog _dialog = new Dialog(((Presenter) managableByDialog), title);
      Dialog dialog = _dialog;
      dialog.initialize();
      _xblockexpression = (dialog);
    }
    return _xblockexpression;
  }
  
  public static Dialog asGWTDialog(final IManagableByDialog managableByDialog, final String title, final Procedure1<? super Void> postAction) {
    Dialog _xblockexpression = null;
    {
      final Procedure1<Void> _function = new Procedure1<Void>() {
          public void apply(final Void it) {
            postAction.apply(null);
          }
        };
      Dialog _dialog = new Dialog(((Presenter) managableByDialog), title, _function);
      Dialog dialog = _dialog;
      dialog.initialize();
      _xblockexpression = (dialog);
    }
    return _xblockexpression;
  }
  
  public static Dialog asGWTInfoDialog(final IManagableByDialog managableByDialog, final String title) {
    Dialog _xblockexpression = null;
    {
      Dialog _dialog = new Dialog(((Presenter) managableByDialog), title);
      Dialog dialog = _dialog;
      dialog.setOkOnly(Boolean.valueOf(true));
      dialog.initialize();
      _xblockexpression = (dialog);
    }
    return _xblockexpression;
  }
}
