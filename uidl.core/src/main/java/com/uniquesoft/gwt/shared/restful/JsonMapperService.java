package com.uniquesoft.gwt.shared.restful;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONValue;
import com.uniquesoft.gwt.shared.restful.JsonUtils;
import com.uniquesoft.gwt.shared.restful.map.JsonMapper;
import java.util.Arrays;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class JsonMapperService {
  public <T extends Object> Iterable<T> toCollectionValue(final JSONValue value, final JsonMapper<T> mapper) {
    JSONArray _isArray = value.isArray();
    Iterable<JSONValue> _asIterable = JsonUtils.asIterable(_isArray);
    final Function1<JSONValue,T> _function = new Function1<JSONValue,T>() {
        public T apply(final JSONValue it) {
          T _fromJson = mapper.fromJson(it);
          return _fromJson;
        }
      };
    Iterable<T> _map = IterableExtensions.<JSONValue, T>map(_asIterable, _function);
    return _map;
  }
  
  public <T extends Object> T toValue(final JSONValue value, final JsonMapper<T> mapper) {
    T _fromJson = mapper.fromJson(value);
    return _fromJson;
  }
  
  protected String _toString(final Object value) {
    String _string = value.toString();
    return _string;
  }
  
  protected String _toString(final Integer value) {
    String _string = value.toString();
    return _string;
  }
  
  protected String _toString(final Date value) {
    String _string = value.toString();
    return _string;
  }
  
  public String toString(final Object value) {
    if (value instanceof Integer) {
      return _toString((Integer)value);
    } else if (value instanceof Date) {
      return _toString((Date)value);
    } else if (value != null) {
      return _toString(value);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(value).toString());
    }
  }
}
