package com.uniquesoft.gwt.shared.restful

import com.google.gwt.json.client.JSONValue
import java.util.Date

import static extension com.uniquesoft.gwt.shared.restful.JsonUtils.*
import com.uniquesoft.gwt.shared.restful.map.JsonMapper

class JsonMapperService {
	def <T> Iterable<T> toCollectionValue(JSONValue value, JsonMapper<T> mapper){
		value.isArray.asIterable.map[mapper.fromJson(it)]
	}
	
	def <T> T toValue(JSONValue value, JsonMapper<T> mapper){
		mapper.fromJson(value)
	}
	
	def dispatch String toString(Object value){
		value.toString
	}
	
	def dispatch String toString(Integer value){
		value.toString
	}
	
	def dispatch String toString(Date value){
		value.toString
	}
}