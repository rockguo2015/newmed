package com.uniquesoft.gwt.shared.extensions;

import com.google.common.base.Objects;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class ObjectExtensions2 {
  public static <T extends Object> T withDefault(final T value, final Function1<? super Void,? extends T> creator) {
    T _xifexpression = null;
    boolean _equals = Objects.equal(value, null);
    if (_equals) {
      T _apply = creator.apply(null);
      _xifexpression = _apply;
    } else {
      _xifexpression = value;
    }
    return _xifexpression;
  }
  
  public static <T extends Object> void ifNotNull(final T value, final Procedure1<? super T> action) {
    boolean _equals = Objects.equal(value, null);
    if (_equals) {
      action.apply(value);
    }
  }
}
