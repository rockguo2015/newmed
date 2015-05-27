package edu.fudan.langlab.gxt.client.widget;

import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareMultiObjectCommand;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.client.common.command.BaseSimpleCommand;
import com.uniquesoft.gwt.shared.IGWTEntity;
import edu.fudan.langlab.gxt.client.action.ButtonRequester;
import edu.fudan.langlab.gxt.client.action.MultiObjectActions;
import edu.fudan.langlab.gxt.client.action.SingleObjectActions;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class Commands implements IInitializerSupport {
  @Inject
  private Securities securities;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    postInitialize.initializeFinished(null);
  }
  
  public <T extends Object> void asButton(final IWidgetFactory widgets, final BaseSimpleCommand command, final Procedure1<? super TextButton> acceptor) {
    boolean _requireCheck = command.requireCheck();
    String _actionId = command.getActionId();
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          String _title = command.getTitle();
          final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
              public void apply(final SelectEvent it) {
                command.execute();
              }
            };
          final TextButton button = widgets.TextButton(_title, _function);
          acceptor.apply(button);
        }
      };
    this.securities.check(_requireCheck, _actionId, _function);
  }
  
  public <T extends Object> void asButton(final BaseContextAwareSingleObjectCommand<T> contextAwareAction, final Procedure1<? super TextButton> acceptor) {
    boolean _requireCheck = contextAwareAction.requireCheck();
    String _actionId = contextAwareAction.getActionId();
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          ActionContext<? extends T> _context = contextAwareAction.getContext();
          final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
              public void apply(final SingleObjectActions it) {
                final Procedure1<T> _function = new Procedure1<T>() {
                    public void apply(final T value) {
                      contextAwareAction.execute(value);
                    }
                  };
                it.onExecute(_function);
                final Function1<Void,Boolean> _function_1 = new Function1<Void,Boolean>() {
                    public Boolean apply(final Void it) {
                      ActionContext<? extends T> _context = contextAwareAction.getContext();
                      Iterable<? extends T> _selectedObjects = _context.getSelectedObjects();
                      T _head = IterableExtensions.head(_selectedObjects);
                      boolean _checkEnable = contextAwareAction.checkEnable(_head);
                      return Boolean.valueOf(_checkEnable);
                    }
                  };
                it.onCheckEnable(_function_1);
              }
            };
          SingleObjectActions _onSingleObjectAction = SingleObjectActions.onSingleObjectAction(_context, _function);
          String _title = contextAwareAction.getTitle();
          final TextButton button = _onSingleObjectAction.asButtonRequester(_title);
          acceptor.apply(button);
        }
      };
    this.securities.check(_requireCheck, _actionId, _function);
  }
  
  public <T extends IGWTEntity> void asButton(final ActionContext<T> actionContext, final BaseContextAwareSingleObjectCommand<T> contextAwareAction, final Procedure1<? super TextButton> acceptor) {
    contextAwareAction.setContext(actionContext);
    final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
        public void apply(final TextButton btn) {
          acceptor.apply(btn);
        }
      };
    this.<T>asButton(contextAwareAction, _function);
  }
  
  public <T extends Object> void asButton(final Function0<? extends T> valueProvider, final BaseContextAwareSingleObjectCommand<T> contextAwareAction, final Procedure1<? super TextButton> acceptor) {
    boolean _requireCheck = contextAwareAction.requireCheck();
    String _actionId = contextAwareAction.getActionId();
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          contextAwareAction.setValueProvider(valueProvider);
          String _title = contextAwareAction.getTitle();
          ButtonRequester _buttonRequester = new ButtonRequester(_title);
          final Procedure1<ButtonRequester> _function = new Procedure1<ButtonRequester>() {
              public void apply(final ButtonRequester it) {
                final Procedure0 _function = new Procedure0() {
                    public void apply() {
                      T _apply = valueProvider.apply();
                      contextAwareAction.execute(_apply);
                    }
                  };
                it.setRequestHandler(new RequestHandler() {
                    public void execute() {
                      _function.apply();
                    }
                });
              }
            };
          final ButtonRequester req = ObjectExtensions.<ButtonRequester>operator_doubleArrow(_buttonRequester, _function);
          TextButton _asWidget = req.asWidget();
          acceptor.apply(_asWidget);
        }
      };
    this.securities.check(_requireCheck, _actionId, _function);
  }
  
  public <T extends Object> void asButton(final ActionContext<T> actionContext, final BaseContextAwareSingleObjectCommand<T> contextAwareAction, final String name, final Procedure1<? super TextButton> acceptor) {
    boolean _requireCheck = contextAwareAction.requireCheck();
    String _actionId = contextAwareAction.getActionId();
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          contextAwareAction.setContext(actionContext);
          ActionContext<? extends T> _context = contextAwareAction.getContext();
          final Procedure1<SingleObjectActions> _function = new Procedure1<SingleObjectActions>() {
              public void apply(final SingleObjectActions it) {
                final Procedure1<T> _function = new Procedure1<T>() {
                    public void apply(final T value) {
                      contextAwareAction.execute(value);
                    }
                  };
                it.onExecute(_function);
              }
            };
          SingleObjectActions _onSingleObjectAction = SingleObjectActions.onSingleObjectAction(_context, _function);
          final TextButton button = _onSingleObjectAction.asButtonRequester(name);
          acceptor.apply(button);
        }
      };
    this.securities.check(_requireCheck, _actionId, _function);
  }
  
  public <T extends Object> void asButton(final ActionContext<T> actionContext, final BaseContextAwareMultiObjectCommand<T> contextAwareAction, final Procedure1<? super TextButton> acceptor) {
    String _actionId = contextAwareAction.getActionId();
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          contextAwareAction.setContext(actionContext);
          ActionContext<? extends T> _context = contextAwareAction.getContext();
          final Procedure1<MultiObjectActions> _function = new Procedure1<MultiObjectActions>() {
              public void apply(final MultiObjectActions it) {
                final Procedure1<Iterable<T>> _function = new Procedure1<Iterable<T>>() {
                    public void apply(final Iterable<T> value) {
                      contextAwareAction.execute(value);
                    }
                  };
                it.onExecute(_function);
                final Function1<Void,Boolean> _function_1 = new Function1<Void,Boolean>() {
                    public Boolean apply(final Void it) {
                      ActionContext<? extends T> _context = contextAwareAction.getContext();
                      Iterable<? extends T> _selectedObjects = _context.getSelectedObjects();
                      boolean _checkEnable = contextAwareAction.checkEnable(((Iterable<T>) _selectedObjects));
                      return Boolean.valueOf(_checkEnable);
                    }
                  };
                it.onCheckEnable(_function_1);
              }
            };
          MultiObjectActions _onMultiObjectAction = MultiObjectActions.onMultiObjectAction(_context, _function);
          String _title = contextAwareAction.getTitle();
          final TextButton button = _onMultiObjectAction.asButtonRequester(_title);
          acceptor.apply(button);
        }
      };
    this.securities.check(_actionId, _function);
  }
}
