package com.uniquesoft.gwt.shared.restful;

import java.util.Iterator;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONValue;

public class JsonIterable implements Iterable<JSONValue> {

	private JSONArray jsonarray;

	public JsonIterable(JSONArray jsonarray) {
		this.jsonarray = jsonarray;
	}

	@Override
	public Iterator<JSONValue> iterator() {
		return new Iterator<JSONValue>() {

			int index = 0;

			@Override
			public boolean hasNext() {
				return index < jsonarray.size();
			}

			@Override
			public JSONValue next() {
				return jsonarray.get(index++);
			}

			@Override
			public void remove() {
			}
		};
	}

}