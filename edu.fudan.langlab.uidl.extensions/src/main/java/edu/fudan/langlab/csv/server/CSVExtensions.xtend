package edu.fudan.langlab.csv.server

import java.util.UUID
import com.uniquesoft.gwt.server.service.common.HttpAware
import java.util.Collection

class CSVExtensions {
	def static <T> String csvPrepare(HttpAware httpAware, String fileTitle, Class<?> mapperClass, Collection<T> data){
		var uuid = UUID::randomUUID.toString
		httpAware.request.session.setAttribute(uuid, new DownloadParameter(fileTitle,data,mapperClass))
		uuid
	}
}