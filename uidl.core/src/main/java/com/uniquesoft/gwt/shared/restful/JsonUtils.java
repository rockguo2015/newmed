package com.uniquesoft.gwt.shared.restful;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONValue;

public class JsonUtils {
	public static Iterable<JSONValue> asIterable(JSONArray jsonarray) {
		return new JsonIterable(jsonarray);
	}
}