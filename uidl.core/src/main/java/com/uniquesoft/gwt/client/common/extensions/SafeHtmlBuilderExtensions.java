package com.uniquesoft.gwt.client.common.extensions;

import com.google.common.base.Objects;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

@SuppressWarnings("all")
public class SafeHtmlBuilderExtensions {
  public static SafeHtmlBuilder highlightIf(final SafeHtmlBuilder sb, final Object value, final Function1<? super Void,? extends Boolean> checker) {
    SafeHtmlBuilder _xifexpression = null;
    Boolean _apply = checker.apply(null);
    if ((_apply).booleanValue()) {
      String _string = value.toString();
      String _plus = ("<font color=\'red\'>" + _string);
      String _plus_1 = (_plus + "</font>");
      SafeHtmlBuilder _appendHtmlConstant = sb.appendHtmlConstant(_plus_1);
      _xifexpression = _appendHtmlConstant;
    } else {
      String _string_1 = value.toString();
      SafeHtmlBuilder _appendHtmlConstant_1 = sb.appendHtmlConstant(_string_1);
      _xifexpression = _appendHtmlConstant_1;
    }
    return _xifexpression;
  }
  
  public static String progressInfoNoMoreThan(final Integer first, final Integer second) {
    String _xifexpression = null;
    boolean _greaterThan = (first.compareTo(second) > 0);
    if (_greaterThan) {
      String _string = first.toString();
      String _plus = ("<font color=\'red\'>" + _string);
      String _plus_1 = (_plus + "</font>");
      _xifexpression = _plus_1;
    } else {
      String _xifexpression_1 = null;
      boolean _equals = Objects.equal(first, second);
      if (_equals) {
        String _string_1 = first.toString();
        String _plus_2 = ("<font color=\'green\'>" + _string_1);
        String _plus_3 = (_plus_2 + "</font>");
        _xifexpression_1 = _plus_3;
      } else {
        String _string_2 = first.toString();
        String _plus_4 = ("<B>" + _string_2);
        String _plus_5 = (_plus_4 + "</B>");
        _xifexpression_1 = _plus_5;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public static String progressInfo(final Integer first, final Integer second) {
    String _xifexpression = null;
    boolean _greaterEqualsThan = (first.compareTo(second) >= 0);
    if (_greaterEqualsThan) {
      String _string = first.toString();
      String _plus = ("<font color=\'green\'>" + _string);
      String _plus_1 = (_plus + "</font>");
      _xifexpression = _plus_1;
    } else {
      String _string_1 = first.toString();
      String _plus_2 = ("<B>" + _string_1);
      String _plus_3 = (_plus_2 + "</B>");
      _xifexpression = _plus_3;
    }
    return _xifexpression;
  }
  
  public static String progressInfoNoMoreThan(final Double f, final Double s) {
    String _xblockexpression = null;
    {
      double _multiply = ((f).doubleValue() * 100);
      final int first = Double.valueOf(_multiply).intValue();
      double _multiply_1 = ((s).doubleValue() * 100);
      final int second = Double.valueOf(_multiply_1).intValue();
      String _xifexpression = null;
      boolean _greaterThan = (first > second);
      if (_greaterThan) {
        String _string = f.toString();
        String _plus = ("<font color=\'red\'>" + _string);
        String _plus_1 = (_plus + "</font>");
        _xifexpression = _plus_1;
      } else {
        String _xifexpression_1 = null;
        boolean _equals = (first == second);
        if (_equals) {
          String _string_1 = f.toString();
          String _plus_2 = ("<font color=\'green\'>" + _string_1);
          String _plus_3 = (_plus_2 + "</font>");
          _xifexpression_1 = _plus_3;
        } else {
          String _string_2 = f.toString();
          String _plus_4 = ("<B>" + _string_2);
          String _plus_5 = (_plus_4 + "</B>");
          _xifexpression_1 = _plus_5;
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public static String progressInfoNoMoreThan(final Double f, final Double s, final String content) {
    String _xblockexpression = null;
    {
      double _multiply = ((f).doubleValue() * 100);
      final int first = Double.valueOf(_multiply).intValue();
      double _multiply_1 = ((s).doubleValue() * 100);
      final int second = Double.valueOf(_multiply_1).intValue();
      String _xifexpression = null;
      boolean _greaterThan = (first > second);
      if (_greaterThan) {
        String _plus = ("<font color=\'red\'>" + content);
        String _plus_1 = (_plus + "</font>");
        _xifexpression = _plus_1;
      } else {
        String _xifexpression_1 = null;
        boolean _equals = (first == second);
        if (_equals) {
          String _plus_2 = ("<font color=\'green\'>" + content);
          String _plus_3 = (_plus_2 + "</font>");
          _xifexpression_1 = _plus_3;
        } else {
          String _plus_4 = ("<B>" + content);
          String _plus_5 = (_plus_4 + "</B>");
          _xifexpression_1 = _plus_5;
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public static String progressInfoCountDown(final Double f, final Double s) {
    String _xblockexpression = null;
    {
      double _multiply = ((f).doubleValue() * 100);
      final int first = Double.valueOf(_multiply).intValue();
      double _multiply_1 = ((s).doubleValue() * 100);
      final int second = Double.valueOf(_multiply_1).intValue();
      String _xifexpression = null;
      boolean _lessThan = (first < second);
      if (_lessThan) {
        String _string = f.toString();
        String _plus = ("<font color=\'red\'>" + _string);
        String _plus_1 = (_plus + "</font>");
        _xifexpression = _plus_1;
      } else {
        String _xifexpression_1 = null;
        boolean _equals = (first == second);
        if (_equals) {
          String _string_1 = f.toString();
          String _plus_2 = ("<font color=\'green\'>" + _string_1);
          String _plus_3 = (_plus_2 + "</font>");
          _xifexpression_1 = _plus_3;
        } else {
          String _string_2 = f.toString();
          String _plus_4 = ("<B>" + _string_2);
          String _plus_5 = (_plus_4 + "</B>");
          _xifexpression_1 = _plus_5;
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public static String progressInfo(final Double f, final Double s) {
    String _xblockexpression = null;
    {
      double _multiply = ((f).doubleValue() * 100);
      final int first = Double.valueOf(_multiply).intValue();
      double _multiply_1 = ((s).doubleValue() * 100);
      final int second = Double.valueOf(_multiply_1).intValue();
      String _xifexpression = null;
      boolean _greaterEqualsThan = (first >= second);
      if (_greaterEqualsThan) {
        String _string = f.toString();
        String _plus = ("<font color=\'green\'>" + _string);
        String _plus_1 = (_plus + "</font>");
        _xifexpression = _plus_1;
      } else {
        String _string_1 = f.toString();
        String _plus_2 = ("<B>" + _string_1);
        String _plus_3 = (_plus_2 + "</B>");
        _xifexpression = _plus_3;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public static String hightlightIfLessThan(final Integer first, final Integer second) {
    String _xifexpression = null;
    boolean _lessThan = (first.compareTo(second) < 0);
    if (_lessThan) {
      String _string = first.toString();
      String _plus = ("<font color=\'red\'>" + _string);
      String _plus_1 = (_plus + "</font>");
      _xifexpression = _plus_1;
    } else {
      String _xifexpression_1 = null;
      boolean _equals = Objects.equal(first, second);
      if (_equals) {
        String _string_1 = first.toString();
        String _plus_2 = ("<font color=\'green\'>" + _string_1);
        String _plus_3 = (_plus_2 + "</font>");
        _xifexpression_1 = _plus_3;
      } else {
        String _string_2 = first.toString();
        String _plus_4 = ("<B>" + _string_2);
        String _plus_5 = (_plus_4 + "</B>");
        _xifexpression_1 = _plus_5;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public static String progressInfo(final Boolean finished) {
    String _xifexpression = null;
    if ((finished).booleanValue()) {
      _xifexpression = "<font color=\'green\'>\u5DF2\u5B8C\u6210</font>";
    } else {
      _xifexpression = "<B>\u672A\u5B8C\u6210</B>";
    }
    return _xifexpression;
  }
}
