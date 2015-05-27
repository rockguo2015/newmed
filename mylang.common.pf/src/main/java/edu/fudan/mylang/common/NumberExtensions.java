package edu.fudan.mylang.common;

import com.google.common.base.Objects;

@SuppressWarnings("all")
public class NumberExtensions {
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
}
