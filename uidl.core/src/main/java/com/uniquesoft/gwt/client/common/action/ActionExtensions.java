package com.uniquesoft.gwt.client.common.action;

import com.google.common.base.Objects;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.widgets.ObjectListView;
import com.uniquesoft.gwt.client.common.widgets.ObjectListView.ContentChangedListener;
import com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class ActionExtensions {
  public static <V extends Object> ActionContext<V> createActionContext(final ObjectSelectionProvider<V> objectSelectionProvider) {
    ActionContext<V> _actionContext = new ActionContext<V>(objectSelectionProvider);
    return _actionContext;
  }
  
  public static <V extends Object> ActionContext<V> createActionContext(final ObjectListView<V> objectListView) {
    ActionContext<V> _xblockexpression = null;
    {
      ActionContext<V> _actionContext = new ActionContext<V>(objectListView);
      final ActionContext<V> ac = _actionContext;
      final Procedure1<Iterable<V>> _function = new Procedure1<Iterable<V>>() {
          public void apply(final Iterable<V> it) {
            ac.updateStates();
          }
        };
      objectListView.addContentChangedListener(new ContentChangedListener<V>() {
          public void contentChanged(Iterable<V> contents) {
            _function.apply(contents);
          }
      });
      _xblockexpression = (ac);
    }
    return _xblockexpression;
  }
  
  public static <V extends Object> Boolean singleSelectedAnd(final ObjectSelectionProvider<V> objectListView, final Function1<? super V,? extends Boolean> andOperation) {
    Boolean _xblockexpression = null;
    {
      boolean _or = false;
      Iterable<V> _selectedObjects = objectListView.getSelectedObjects();
      boolean _equals = Objects.equal(_selectedObjects, null);
      if (_equals) {
        _or = true;
      } else {
        Iterable<V> _selectedObjects_1 = objectListView.getSelectedObjects();
        int _size = IterableExtensions.size(_selectedObjects_1);
        boolean _notEquals = (_size != 1);
        _or = (_equals || _notEquals);
      }
      if (_or) {
        return Boolean.valueOf(false);
      }
      Iterable<V> _selectedObjects_2 = objectListView.getSelectedObjects();
      final Function1<V,Boolean> _function = new Function1<V,Boolean>() {
          public Boolean apply(final V it) {
            return Boolean.valueOf(true);
          }
        };
      V _findFirst = IterableExtensions.<V>findFirst(_selectedObjects_2, _function);
      Boolean _apply = andOperation.apply(_findFirst);
      _xblockexpression = (_apply);
    }
    return _xblockexpression;
  }
}
