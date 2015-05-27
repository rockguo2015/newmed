package com.uniquesoft.gwt.shared.extensions;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

@SuppressWarnings("all")
public class IterableExtensions2 {
  public static <T extends Object> Collection<T> unlazy(final Iterable<T> iterable) {
    ArrayList<T> _xblockexpression = null;
    {
      final ArrayList<T> result = CollectionLiterals.<T>newArrayList();
      final Procedure1<T> _function = new Procedure1<T>() {
          public void apply(final T it) {
            result.add(it);
          }
        };
      IterableExtensions.<T>forEach(iterable, _function);
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  public static <T extends Object> void forEachWithIndex(final Iterable<T> iterables, final Procedure2<? super T,? super Long> action) {
    Long index = Long.valueOf(0l);
    for (final T element : iterables) {
      {
        action.apply(element, index);
        long _plus = ((index).longValue() + 1);
        index = Long.valueOf(_plus);
      }
    }
  }
  
  public static <T extends Object> T getOnlySelected(final Iterable<T> iterables) {
    T _xifexpression = null;
    boolean _or = false;
    boolean _equals = Objects.equal(iterables, null);
    if (_equals) {
      _or = true;
    } else {
      int _size = IterableExtensions.size(iterables);
      boolean _notEquals = (_size != 1);
      _or = (_equals || _notEquals);
    }
    if (_or) {
      _xifexpression = null;
    } else {
      T _head = IterableExtensions.<T>head(iterables);
      _xifexpression = _head;
    }
    return _xifexpression;
  }
  
  public static <T extends Object> void forOnlySelected(final Iterable<T> iterables, final Procedure1<? super T> processor) {
    boolean _or = false;
    boolean _equals = Objects.equal(iterables, null);
    if (_equals) {
      _or = true;
    } else {
      int _size = IterableExtensions.size(iterables);
      boolean _notEquals = (_size != 1);
      _or = (_equals || _notEquals);
    }
    if (_or) {
      return;
    } else {
      T _head = IterableExtensions.<T>head(iterables);
      processor.apply(_head);
    }
  }
  
  public static <T extends Object> void forEachWithValidation(final Iterable<T> datas, final Procedure1<? super T> processor) {
    final ArrayList<ValidationErrorItem> errors = CollectionLiterals.<ValidationErrorItem>newArrayList();
    final Procedure2<T,Long> _function = new Procedure2<T,Long>() {
        public void apply(final T value, final Long index) {
          try {
            processor.apply(value);
          } catch (final Throwable _t) {
            if (_t instanceof ValidationException) {
              final ValidationException e = (ValidationException)_t;
              Collection<ValidationErrorItem> _errors = e.getErrors();
              Iterables.<ValidationErrorItem>addAll(errors, _errors);
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
        }
      };
    IterableExtensions2.<T>forEachWithIndex(datas, _function);
    int _size = errors.size();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      ValidationException _validationException = new ValidationException(errors);
      throw _validationException;
    }
  }
}
