package com.uniquesoft.gwt.client.common.command;

import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.command.BaseCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public abstract class BaseContextAwareMultiObjectCommand<T extends Object> extends BaseCommand implements IContextConsumer<T> {
  private ActionContext<? extends T> actionContext;
  
  public ActionContext<? extends T> getContext() {
    return this.actionContext;
  }
  
  public void setContext(final ActionContext<T> actionContext) {
    this.actionContext = actionContext;
  }
  
  public abstract void execute(final Iterable<T> value);
  
  public boolean checkEnable(final Iterable<T> value) {
    int _size = IterableExtensions.size(value);
    boolean _greaterThan = (_size > 0);
    return _greaterThan;
  }
}
