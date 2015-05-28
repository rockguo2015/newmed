package com.fudanmed.platform.core.web.server.jsonservice;

import com.fudanmed.platform.core.web.server.jsonservice.JSONServiceException;
import com.google.common.base.Objects;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.json.JSONObject;

@SuppressWarnings("all")
public class JSONUtil {
  public static JSONObject success(final Procedure1<? super JSONObject> initReturn) {
    try {
      JSONObject _jSONObject = new JSONObject();
      JSONObject _put = _jSONObject.put("message", 1);
      JSONObject _put_1 = _put.put("description", "success");
      JSONObject _jSONObject_1 = new JSONObject();
      final Procedure1<JSONObject> _function = new Procedure1<JSONObject>() {
          public void apply(final JSONObject it) {
            initReturn.apply(it);
          }
        };
      JSONObject _doubleArrow = ObjectExtensions.<JSONObject>operator_doubleArrow(_jSONObject_1, _function);
      JSONObject _put_2 = _put_1.put("data", _doubleArrow);
      return _put_2;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static JSONObject success(final Collection<JSONObject> datas) {
    try {
      JSONObject _jSONObject = new JSONObject();
      JSONObject _put = _jSONObject.put("message", 1);
      JSONObject _put_1 = _put.put("description", "success");
      JSONObject _put_2 = _put_1.put("data", datas);
      return _put_2;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static JSONObject fail(final String message) {
    try {
      JSONObject _jSONObject = new JSONObject();
      int _minus = (-3);
      JSONObject _put = _jSONObject.put("message", _minus);
      JSONObject _put_1 = _put.put("description", message);
      return _put_1;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static JSONObject fatal(final String message) {
    try {
      JSONObject _jSONObject = new JSONObject();
      int _minus = (-1);
      JSONObject _put = _jSONObject.put("message", _minus);
      JSONObject _put_1 = _put.put("description", message);
      return _put_1;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static Integer toInteger(final String intStr) {
    int _xblockexpression = (int) 0;
    {
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(intStr);
      if (_isNullOrEmpty) {
        return null;
      }
      int _xtrycatchfinallyexpression = (int) 0;
      try {
        int _parseInt = Integer.parseInt(intStr);
        _xtrycatchfinallyexpression = _parseInt;
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception e = (Exception)_t;
          String _plus = ("\u6574\u6570\u683C\u5F0F\u9519\u8BEF:" + intStr);
          JSONServiceException _jSONServiceException = new JSONServiceException(_plus);
          throw _jSONServiceException;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = (_xtrycatchfinallyexpression);
    }
    return Integer.valueOf(_xblockexpression);
  }
  
  public static Long toLong(final String intStr) {
    long _xblockexpression = (long) 0;
    {
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(intStr);
      if (_isNullOrEmpty) {
        return null;
      }
      long _xtrycatchfinallyexpression = (long) 0;
      try {
        long _parseLong = Long.parseLong(intStr);
        _xtrycatchfinallyexpression = _parseLong;
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception e = (Exception)_t;
          String _plus = ("\u6574\u6570\u683C\u5F0F\u9519\u8BEF:" + intStr);
          JSONServiceException _jSONServiceException = new JSONServiceException(_plus);
          throw _jSONServiceException;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = (_xtrycatchfinallyexpression);
    }
    return Long.valueOf(_xblockexpression);
  }
  
  public static Double toDouble(final String doubleValue) {
    double _xblockexpression = (double) 0;
    {
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(doubleValue);
      if (_isNullOrEmpty) {
        return null;
      }
      double _xtrycatchfinallyexpression = (double) 0;
      try {
        double _parseDouble = Double.parseDouble(doubleValue);
        _xtrycatchfinallyexpression = _parseDouble;
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception e = (Exception)_t;
          String _plus = ("\u6570\u503C\u683C\u5F0F\u9519\u8BEF:" + doubleValue);
          JSONServiceException _jSONServiceException = new JSONServiceException(_plus);
          throw _jSONServiceException;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = (_xtrycatchfinallyexpression);
    }
    return Double.valueOf(_xblockexpression);
  }
  
  public static Date toDate(final String date) {
    Date _xblockexpression = null;
    {
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(date);
      if (_isNullOrEmpty) {
        return null;
      }
      Date _xtrycatchfinallyexpression = null;
      try {
        SimpleDateFormat _simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date _parse = _simpleDateFormat.parse(date);
        _xtrycatchfinallyexpression = _parse;
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception e = (Exception)_t;
          String _plus = ("\u65E5\u671F\u683C\u5F0F\u9519\u8BEF(YYYY-MM-DD):" + date);
          JSONServiceException _jSONServiceException = new JSONServiceException(_plus);
          throw _jSONServiceException;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = (_xtrycatchfinallyexpression);
    }
    return _xblockexpression;
  }
  
  public static Date toTime(final String time) {
    Date _xblockexpression = null;
    {
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(time);
      if (_isNullOrEmpty) {
        return null;
      }
      Date _xtrycatchfinallyexpression = null;
      try {
        Date _xblockexpression_1 = null;
        {
          final String[] segs = time.split("T");
          SimpleDateFormat _simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
          String _get = ((List<String>)Conversions.doWrapArray(segs)).get(0);
          final Date datePart = _simpleDateFormat.parse(_get);
          SimpleDateFormat _simpleDateFormat_1 = new SimpleDateFormat("HH-mm-ss");
          String _get_1 = ((List<String>)Conversions.doWrapArray(segs)).get(1);
          final Date timePart = _simpleDateFormat_1.parse(_get_1);
          int _hours = timePart.getHours();
          datePart.setHours(_hours);
          int _seconds = timePart.getSeconds();
          datePart.setMinutes(_seconds);
          int _seconds_1 = timePart.getSeconds();
          datePart.setSeconds(_seconds_1);
          _xblockexpression_1 = (datePart);
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception e = (Exception)_t;
          String _plus = ("\u65F6\u95F4\u683C\u5F0F\u9519\u8BEF(YYYY-MM-DDTHH-MM-SS):" + time);
          JSONServiceException _jSONServiceException = new JSONServiceException(_plus);
          throw _jSONServiceException;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = (_xtrycatchfinallyexpression);
    }
    return _xblockexpression;
  }
  
  public static String toDateString(final Date date) {
    String _xblockexpression = null;
    {
      boolean _equals = Objects.equal(date, null);
      if (_equals) {
        return "";
      }
      SimpleDateFormat _simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
      String _format = _simpleDateFormat.format(date);
      _xblockexpression = (_format);
    }
    return _xblockexpression;
  }
  
  public static String toDateTimeString(final Date date) {
    String _xblockexpression = null;
    {
      boolean _equals = Objects.equal(date, null);
      if (_equals) {
        return "";
      }
      SimpleDateFormat _simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
      final String datePart = _simpleDateFormat.format(date);
      SimpleDateFormat _simpleDateFormat_1 = new SimpleDateFormat("HH-mm-ss");
      final String timePart = _simpleDateFormat_1.format(date);
      String _plus = (datePart + "T");
      String _plus_1 = (_plus + timePart);
      _xblockexpression = (_plus_1);
    }
    return _xblockexpression;
  }
}
