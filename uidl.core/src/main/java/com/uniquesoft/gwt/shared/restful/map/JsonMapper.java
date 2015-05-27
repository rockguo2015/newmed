package com.uniquesoft.gwt.shared.restful.map;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public interface JsonMapper<T> {

	T fromJson(JSONValue value);

	T fromJson(String key, JSONObject object);
	
	String toString(T value);
	
	String toString(String key, T value);

}