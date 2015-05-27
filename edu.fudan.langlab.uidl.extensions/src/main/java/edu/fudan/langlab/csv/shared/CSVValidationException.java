package edu.fudan.langlab.csv.shared;

import java.util.Collection;
import java.util.Map;

import com.google.common.collect.Maps;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;

public class CSVValidationException extends RuntimeException implements
		IsSerializable {

	private static final long serialVersionUID = 1L;

	private Map<String, String> keyTitleMap = Maps.newHashMap();

	private Map<Integer, Collection<ValidationErrorItem>> errors = Maps
			.newHashMap();
	public CSVValidationException(){
		
	}
	public CSVValidationException(Map<String, String> keyTitleMap) {
		this.keyTitleMap = keyTitleMap;
	}

	public CSVValidationException(Map<String, String> keyTitleMap,
			Map<Integer, Collection<ValidationErrorItem>> errors) {
		this.keyTitleMap = keyTitleMap;
		this.errors = errors;
	}

	public Map<Integer, Collection<ValidationErrorItem>> getErrors() {
		return errors;
	}

	public String getTitle(String key){
		return keyTitleMap.get(key);
	}
}
