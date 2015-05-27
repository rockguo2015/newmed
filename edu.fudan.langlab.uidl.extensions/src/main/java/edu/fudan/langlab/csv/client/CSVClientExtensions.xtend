package edu.fudan.langlab.csv.client

import com.google.gwt.core.client.GWT
import com.google.gwt.user.client.Window

class CSVClientExtensions {
	def static void doDownload(String uuid){
		var url = GWT::getModuleBaseURL() + "service/csvFileDownloader?uuid=" + uuid;
		com::google::gwt::user::client::Window::open(url, "_blank", "");							
	}
	
//	def static void showErrors(Throwable caught){
//		val sb = new StringBuffer
//		val c = caught as CSVValidationException
//		c.errors.forEach[line,items|
//			items.forEach[item|
//				val keyList = item.keys.filter[!nullOrEmpty].map[c.getTitle(it)].join(',')
//				val title = if(keyList.nullOrEmpty) "" else keyList+":"
//				sb.append(line+":"+title+item.message)
//				sb.append("<br>")
//			]
//		]
//		var mb = new MessageBox("数据错误,请修改后重新导入",sb.toString)
//		mb.show
//	}
	

}