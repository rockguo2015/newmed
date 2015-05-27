package com.uniquesoft.gwt.client.common.extensions;

import com.google.common.base.Objects;
import com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class ObjectSelectionProviders {
  public static <T extends Object> T getOnlySelected(final ObjectSelectionProvider<T> op) {
    Iterable<T> objects = op.getSelectedObjects();
    boolean _or = false;
    boolean _equals = Objects.equal(objects, null);
    if (_equals) {
      _or = true;
    } else {
      int _size = IterableExtensions.size(objects);
      boolean _notEquals = (_size != 1);
      _or = (_equals || _notEquals);
    }
    if (_or) {
      return null;
    } else {
      Iterable<T> _selectedObjects = op.getSelectedObjects();
      final Function1<T,Boolean> _function = new Function1<T,Boolean>() {
          public Boolean apply(final T it) {
            return Boolean.valueOf(true);
          }
        };
      return IterableExtensions.<T>findFirst(_selectedObjects, _function);
    }
  }
  
  public static <T extends Object> void forOnlySelected(final ObjectSelectionProvider<T> op, final Procedure1<? super T> processor) {
    Iterable<T> objects = op.getSelectedObjects();
    boolean _or = false;
    boolean _equals = Objects.equal(objects, null);
    if (_equals) {
      _or = true;
    } else {
      int _size = IterableExtensions.size(objects);
      boolean _notEquals = (_size != 1);
      _or = (_equals || _notEquals);
    }
    if (_or) {
      return;
    } else {
      Iterable<T> _selectedObjects = op.getSelectedObjects();
      final Function1<T,Boolean> _function = new Function1<T,Boolean>() {
          public Boolean apply(final T it) {
            return Boolean.valueOf(true);
          }
        };
      T _findFirst = IterableExtensions.<T>findFirst(_selectedObjects, _function);
      processor.apply(_findFirst);
    }
  }
  
  public static <T extends Object> Boolean isOnlySelectedAnd(final ObjectSelectionProvider<T> op, final Function1<? super T,? extends Boolean> p) {
    Iterable<T> objects = op.getSelectedObjects();
    boolean _or = false;
    boolean _equals = Objects.equal(objects, null);
    if (_equals) {
      _or = true;
    } else {
      int _size = IterableExtensions.size(objects);
      boolean _notEquals = (_size != 1);
      _or = (_equals || _notEquals);
    }
    if (_or) {
      return Boolean.valueOf(false);
    }
    Iterable<T> _selectedObjects = op.getSelectedObjects();
    final Function1<T,Boolean> _function = new Function1<T,Boolean>() {
        public Boolean apply(final T it) {
          return Boolean.valueOf(true);
        }
      };
    T _findFirst = IterableExtensions.<T>findFirst(_selectedObjects, _function);
    return p.apply(_findFirst);
  }
}
