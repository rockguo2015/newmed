package edu.fudan.langlab.gxt.client.action;

import com.google.common.base.Objects;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.action.BaseAction;
import com.uniquesoft.gwt.client.common.action.MutilObjectAction;
import edu.fudan.langlab.gxt.client.action.ButtonRequester;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class MultiObjectActions<VT extends Object> extends BaseAction<VT> implements MutilObjectAction<VT> {
  private ActionContext actionContext;
  
  private Iterable<VT> selectedObjects;
  
  public static <VT extends Object> MultiObjectActions onMultiObjectAction(final ActionContext<VT> actionContext, final Procedure1<? super MultiObjectActions> init) {
    MultiObjectActions<VT> _xblockexpression = null;
    {
      MultiObjectActions<VT> _multiObjectActions = new MultiObjectActions<VT>();
      MultiObjectActions<VT> x = _multiObjectActions;
      x.actionContext = actionContext;
      init.apply(x);
      _xblockexpression = (x);
    }
    return _xblockexpression;
  }
  
  private Procedure1<? super Iterable<VT>> onExecute;
  
  private Function1<? super Void,? extends Boolean> doCheckenable;
  
  public Procedure1<? super Iterable<VT>> onExecute(final Procedure1<? super Iterable<VT>> action) {
    Procedure1<? super Iterable<VT>> _onExecute = this.onExecute = action;
    return _onExecute;
  }
  
  public Function1<? super Void,? extends Boolean> onCheckEnable(final Function1<? super Void,? extends Boolean> checkenable) {
    Function1<? super Void,? extends Boolean> _doCheckenable = this.doCheckenable = checkenable;
    return _doCheckenable;
  }
  
  public void execute() {
    this.onExecute.apply(this.selectedObjects);
  }
  
  public boolean checkEnable() {
    boolean _xifexpression = false;
    boolean _equals = Objects.equal(this.doCheckenable, null);
    if (_equals) {
      _xifexpression = true;
    } else {
      Boolean _apply = this.doCheckenable.apply(null);
      _xifexpression = _apply;
    }
    return _xifexpression;
  }
  
  public void setSelectedObject(final Iterable<VT> selectedObjects) {
    this.selectedObjects = selectedObjects;
  }
  
  public TextButton asButtonRequester(final String name) {
    TextButton _xblockexpression = null;
    {
      ButtonRequester _buttonRequester = new ButtonRequester(name);
      ButtonRequester requester = _buttonRequester;
      this.actionContext.registerAction(requester, this);
      TextButton _asWidget = requester.asWidget();
      final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
          public void apply(final TextButton it) {
            it.setWidth(75);
          }
        };
      TextButton _doubleArrow = ObjectExtensions.<TextButton>operator_doubleArrow(_asWidget, _function);
      _xblockexpression = (_doubleArrow);
    }
    return _xblockexpression;
  }
}
