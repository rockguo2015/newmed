package edu.fudan.langlab.gxt.client.action;

import com.google.common.base.Objects;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.action.BaseAction;
import com.uniquesoft.gwt.client.common.action.Requester;
import com.uniquesoft.gwt.client.common.action.SingleObjectAction;
import com.uniquesoft.gwt.shared.GWTEntity;
import edu.fudan.langlab.gxt.client.action.ButtonRequester;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class SingleObjectActions<VT extends Object> extends BaseAction<VT> implements SingleObjectAction<VT> {
  public static <VT extends GWTEntity> SingleObjectAction onExecuteDo(final Procedure1<? super VT> onExecute) {
    SingleObjectActions<VT> _xblockexpression = null;
    {
      SingleObjectActions<VT> _singleObjectActions = new SingleObjectActions<VT>();
      SingleObjectActions<VT> x = _singleObjectActions;
      x.onExecute(onExecute);
      _xblockexpression = (x);
    }
    return _xblockexpression;
  }
  
  public static <VT extends Object> SingleObjectActions onSingleObjectAction(final ActionContext<VT> actionContext, final Procedure1<? super SingleObjectActions> init) {
    SingleObjectActions<VT> _xblockexpression = null;
    {
      SingleObjectActions<VT> _singleObjectActions = new SingleObjectActions<VT>();
      SingleObjectActions<VT> x = _singleObjectActions;
      x.actionContext = actionContext;
      init.apply(x);
      _xblockexpression = (x);
    }
    return _xblockexpression;
  }
  
  private ActionContext actionContext;
  
  private VT selectedObject;
  
  private Procedure1<? super VT> onExecute;
  
  private Function1<? super Void,? extends Boolean> doCheckenable;
  
  public Procedure1<? super VT> onExecute(final Procedure1<? super VT> action) {
    Procedure1<? super VT> _onExecute = this.onExecute = action;
    return _onExecute;
  }
  
  public Function1<? super Void,? extends Boolean> onCheckEnable(final Function1<? super Void,? extends Boolean> checkenable) {
    Function1<? super Void,? extends Boolean> _doCheckenable = this.doCheckenable = checkenable;
    return _doCheckenable;
  }
  
  public void execute() {
    this.onExecute.apply(this.selectedObject);
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
  
  public void setSelectedObject(final VT selectedObject) {
    this.selectedObject = selectedObject;
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
  
  public void attachOnRequester(final Requester requester) {
    this.actionContext.registerAction(requester, this);
  }
}
