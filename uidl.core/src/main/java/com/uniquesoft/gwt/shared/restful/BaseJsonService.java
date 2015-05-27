package com.uniquesoft.gwt.shared.restful;

import java.util.Collection;
import java.util.Map;

import org.eclipse.xtext.xbase.lib.Pair;

import com.google.common.collect.Maps;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestBuilder.Method;
import com.google.inject.Inject;

public class BaseJsonService {

	@Inject
	private JsonMapperService jsonMapperService;

	protected String buildGetURL(String paramURL, Map<String, String> params) {
		String result = paramURL;
		for (String param : params.keySet()) {
			result = result
					.replaceAll("\\{" + param + "\\}", params.get(param));
		}
		return result;
	}

	protected RequestBuilder createRequestBuilder(Method method,
			Collection<Pair<String, Object>> params, String url) {
		Map<String, String> hashParams = Maps.newHashMap();
		for (Pair<String, Object> param : params) {
			hashParams.put(param.getKey(),
					jsonMapperService.toString(param.getValue()));
		}
		return new RequestBuilder(method, buildGetURL(url,
				hashParams));
	}
}
