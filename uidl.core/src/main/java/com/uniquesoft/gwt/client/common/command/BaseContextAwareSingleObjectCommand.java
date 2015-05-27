package com.uniquesoft.gwt.client.common.command;

import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.command.BaseCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import com.uniquesoft.gwt.shared.command.IValueConsumer;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

@SuppressWarnings("all")
public abstract class BaseContextAwareSingleObjectCommand<T extends Object> extends BaseCommand implements IContextConsumer<T>, IValueConsumer<T> {
  private ActionContext<? extends T> actionContext;
  
  public ActionContext<? extends T> getContext() {
    return this.actionContext;
  }
  
  public void setContext(final ActionContext<T> actionContext) {
    this.actionContext = actionContext;
  }
  
  private Function0<? extends T> valueProvider;
  
  public Function0<? extends T> getValueProvider() {
    return this.valueProvider;
  }
  
  public void setValueProvider(final Function0<? extends T> valueProvider) {
    this.valueProvider = valueProvider;
  }
  
  public abstract void execute(final T value);
  
  public boolean checkEnable(final T value) {
    return true;
  }
}
