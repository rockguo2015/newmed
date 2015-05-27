package edu.fudan.mylang.common;

import com.google.common.base.Objects;

@SuppressWarnings("all")
public class StringExtensions {
  public static String nullsafe(final String value) {
    String _xifexpression = null;
    boolean _equals = Objects.equal(value, null);
    if (_equals) {
      _xifexpression = "";
    } else {
      _xifexpression = value;
    }
    return _xifexpression;
  }
  
  public static String toSqlLike(final String value) {
    String _xifexpression = null;
    boolean _equals = Objects.equal(value, null);
    if (_equals) {
      _xifexpression = "%";
    } else {
      String _plus = ("%" + value);
      String _plus_1 = (_plus + "%");
      _xifexpression = _plus_1;
    }
    return _xifexpression;
  }
}
