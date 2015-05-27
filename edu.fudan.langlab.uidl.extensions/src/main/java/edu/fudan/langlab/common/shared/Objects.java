package edu.fudan.langlab.common.shared;

import org.eclipse.xtext.xbase.lib.Functions.Function1;

@SuppressWarnings("all")
public class Objects {
  public static <T extends Object> Boolean satisfy(final T object, final Function1<? super T,? extends Boolean> predicate) {
    boolean _equals = com.google.common.base.Objects.equal(object, null);
    if (_equals) {
      return Boolean.valueOf(false);
    }
    return predicate.apply(object);
  }
  
  public static <T extends Object> T nullsafe(final T value, final Function1<? super Void,? extends T> creator) {
    T _xifexpression = null;
    boolean _equals = com.google.common.base.Objects.equal(value, null);
    if (_equals) {
      T _apply = creator.apply(null);
      _xifexpression = _apply;
    } else {
      _xifexpression = value;
    }
    return _xifexpression;
  }
}
