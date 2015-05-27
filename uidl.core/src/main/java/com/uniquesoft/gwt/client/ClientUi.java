package com.uniquesoft.gwt.client;

import com.google.common.base.Objects;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.uniquesoft.gwt.client.common.GWTAbstractView;
import java.util.Arrays;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class ClientUi {
  public static <T extends Object> T with(final T obj, final Procedure1<? super T> init) {
    init.apply(obj);
    return obj;
  }
  
  public static <T extends Object> T lazy(final T o, final Function1<? super Void,? extends T> init) {
    T _xblockexpression = null;
    {
      boolean _notEquals = (!Objects.equal(o, null));
      if (_notEquals) {
        return o;
      }
      T _apply = init.apply(null);
      _xblockexpression = (_apply);
    }
    return _xblockexpression;
  }
  
  public static void operator_add(final HasWidgets it, final Widget widget) {
    it.add(widget);
  }
  
  public static void operator_add(final ComplexPanel it, final Widget widget) {
    it.add(widget);
  }
  
  public static void operator_add(final GWTAbstractView it, final Widget widget) {
    it.addWidget(widget);
  }
  
  public static boolean isNullOrEmpty(final Object object) {
    boolean _equals = Objects.equal(object, null);
    if (_equals) {
      return true;
    } else {
      return ClientUi.doIsNullOrEmptyCheck(object);
    }
  }
  
  protected static boolean _doIsNullOrEmptyCheck(final String s) {
    boolean _or = false;
    boolean _equals = Objects.equal(s, null);
    if (_equals) {
      _or = true;
    } else {
      String _trim = s.trim();
      int _length = _trim.length();
      boolean _equals_1 = (_length == 0);
      _or = (_equals || _equals_1);
    }
    return _or;
  }
  
  protected static boolean _doIsNullOrEmptyCheck(final Object object) {
    return Objects.equal(object, null);
  }
  
  protected static boolean _doIsNullOrEmptyCheck(final Enum<? extends Object> enumValue) {
    return Objects.equal(enumValue, null);
  }
  
  public static boolean doIsNullOrEmptyCheck(final Object enumValue) {
    if (enumValue instanceof Enum) {
      return _doIsNullOrEmptyCheck((Enum<? extends Object>)enumValue);
    } else if (enumValue instanceof String) {
      return _doIsNullOrEmptyCheck((String)enumValue);
    } else if (enumValue != null) {
      return _doIsNullOrEmptyCheck(enumValue);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(enumValue).toString());
    }
  }
}
