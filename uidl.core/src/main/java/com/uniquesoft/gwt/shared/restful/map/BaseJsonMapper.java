package com.uniquesoft.gwt.shared.restful.map;

import com.google.gwt.json.client.JSONObject;

public abstract class BaseJsonMapper<T> implements JsonMapper<T> {
	@Override
	public T fromJson(String key, JSONObject object) {
		return fromJson(object.get(key));
	}
	@Override
	public String toString(String key, T value) {
		return key + ":" + toString(value);
	}
}
