package edu.fudan.langlab.gxt.client.validation

import com.sencha.gxt.widget.core.client.box.MessageBox
import edu.fudan.langlab.csv.shared.CSVValidationException

class CSVClientExtensions {

	
	def static void showErrors(Throwable caught){
		val sb = new StringBuffer
		val c = caught as CSVValidationException
		c.errors.forEach[line,items|
			items.forEach[item|
				val keyList = item.keys.filter[!nullOrEmpty].map[c.getTitle(it)].join(',')
				val title = if(keyList.nullOrEmpty) "" else keyList+":"
				sb.append(line+":"+title+item.message)
				sb.append("<br>")
			]
		]
		var mb = new MessageBox("数据错误,请修改后重新导入",sb.toString)
		mb.show
	}
	

}