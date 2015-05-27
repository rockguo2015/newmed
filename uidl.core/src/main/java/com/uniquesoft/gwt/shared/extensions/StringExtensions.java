package com.uniquesoft.gwt.shared.extensions;

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
  
  public static String asRightAlignText(final String value) {
    String _plus = ("<span style=\'text-align:right\'>" + value);
    String _plus_1 = (_plus + "</span>");
    return _plus_1;
  }
  
  public static String abbreviate(final String str, final int maxWidth) {
    return StringExtensions.abbreviate(str, 0, maxWidth);
  }
  
  public static String abbreviate(final String str, final int _offset, final int maxWidth) {
    int offset = _offset;
    boolean _equals = Objects.equal(str, null);
    if (_equals) {
      return null;
    }
    boolean _lessThan = (maxWidth < 4);
    if (_lessThan) {
      IllegalArgumentException _illegalArgumentException = new IllegalArgumentException("Minimum abbreviation width is 4");
      throw _illegalArgumentException;
    }
    int _length = str.length();
    boolean _lessEqualsThan = (_length <= maxWidth);
    if (_lessEqualsThan) {
      return str;
    }
    int _length_1 = str.length();
    boolean _greaterThan = (offset > _length_1);
    if (_greaterThan) {
      int _length_2 = str.length();
      offset = _length_2;
    }
    int _length_3 = str.length();
    int _minus = (_length_3 - offset);
    int _minus_1 = (maxWidth - 3);
    boolean _lessThan_1 = (_minus < _minus_1);
    if (_lessThan_1) {
      int _length_4 = str.length();
      int _minus_2 = (maxWidth - 3);
      int _minus_3 = (_length_4 - _minus_2);
      offset = _minus_3;
    }
    boolean _lessEqualsThan_1 = (offset <= 4);
    if (_lessEqualsThan_1) {
      int _minus_4 = (maxWidth - 3);
      String _substring = str.substring(0, _minus_4);
      return (_substring + "...");
    }
    boolean _lessThan_2 = (maxWidth < 7);
    if (_lessThan_2) {
      IllegalArgumentException _illegalArgumentException_1 = new IllegalArgumentException("Minimum abbreviation width with offset is 7");
      throw _illegalArgumentException_1;
    }
    int _minus_5 = (maxWidth - 3);
    int _plus = (offset + _minus_5);
    int _length_5 = str.length();
    boolean _lessThan_3 = (_plus < _length_5);
    if (_lessThan_3) {
      String _substring_1 = str.substring(offset);
      int _minus_6 = (maxWidth - 3);
      String _abbreviate = StringExtensions.abbreviate(_substring_1, _minus_6);
      return ("..." + _abbreviate);
    }
    int _length_6 = str.length();
    int _minus_7 = (maxWidth - 3);
    int _minus_8 = (_length_6 - _minus_7);
    String _substring_2 = str.substring(_minus_8);
    return ("..." + _substring_2);
  }
}
