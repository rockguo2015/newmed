package com.uniquesoft.gwt.shared.extensions;

import com.google.common.base.Objects;
import com.google.gwt.i18n.client.NumberFormat;
import com.uniquesoft.gwt.shared.extensions.SequenceGenerator;

@SuppressWarnings("all")
public class NumberExtensions {
  public static SequenceGenerator sequence(final Integer start) {
    SequenceGenerator _sequenceGenerator = new SequenceGenerator(start);
    return _sequenceGenerator;
  }
  
  public static Integer nullsafe(final Integer value) {
    int _xifexpression = (int) 0;
    boolean _equals = Objects.equal(value, null);
    if (_equals) {
      _xifexpression = 0;
    } else {
      _xifexpression = value;
    }
    return Integer.valueOf(_xifexpression);
  }
  
  public static Double nullsafe(final Double value) {
    double _xifexpression = (double) 0;
    boolean _equals = Objects.equal(value, null);
    if (_equals) {
      _xifexpression = 0d;
    } else {
      _xifexpression = value;
    }
    return Double.valueOf(_xifexpression);
  }
  
  public static Float nullsafe(final Float value) {
    float _xifexpression = (float) 0;
    boolean _equals = Objects.equal(value, null);
    if (_equals) {
      _xifexpression = 0f;
    } else {
      _xifexpression = value;
    }
    return Float.valueOf(_xifexpression);
  }
  
  public static Double asCurrency(final Double c) {
    double _multiply = ((c).doubleValue() * 100);
    double _floor = Math.floor(_multiply);
    double _divide = (_floor / 100);
    return Double.valueOf(_divide);
  }
  
  public static String asCurrencyString(final Double amount) {
    String _xifexpression = null;
    boolean _or = false;
    boolean _equals = Objects.equal(amount, null);
    if (_equals) {
      _or = true;
    } else {
      boolean _equals_1 = ((amount).doubleValue() == 0);
      _or = (_equals || _equals_1);
    }
    if (_or) {
      _xifexpression = "--";
    } else {
      NumberFormat _format = NumberFormat.getFormat("#,###.00");
      String _format_1 = _format.format(amount);
      _xifexpression = _format_1;
    }
    return _xifexpression;
  }
  
  public static String asBareCurrencyString(final Double amount) {
    String _xifexpression = null;
    boolean _or = false;
    boolean _equals = Objects.equal(amount, null);
    if (_equals) {
      _or = true;
    } else {
      boolean _equals_1 = ((amount).doubleValue() == 0);
      _or = (_equals || _equals_1);
    }
    if (_or) {
      _xifexpression = "--";
    } else {
      NumberFormat _format = NumberFormat.getFormat("#,###");
      String _format_1 = _format.format(amount);
      _xifexpression = _format_1;
    }
    return _xifexpression;
  }
  
  public static String asPercentString(final Double amount) {
    String _xifexpression = null;
    boolean _or = false;
    boolean _equals = Objects.equal(amount, null);
    if (_equals) {
      _or = true;
    } else {
      boolean _equals_1 = ((amount).doubleValue() == 0);
      _or = (_equals || _equals_1);
    }
    if (_or) {
      _xifexpression = "--";
    } else {
      NumberFormat _format = NumberFormat.getFormat("###");
      double _multiply = ((amount).doubleValue() * 100);
      long _round = Math.round(_multiply);
      String _format_1 = _format.format(_round);
      String _plus = (_format_1 + "%");
      _xifexpression = _plus;
    }
    return _xifexpression;
  }
}
