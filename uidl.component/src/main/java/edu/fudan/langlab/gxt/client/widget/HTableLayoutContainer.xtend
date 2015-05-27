package edu.fudan.langlab.gxt.client.widget

import static extension edu.fudan.langlab.gxt.client.widget.HTMLTagsExt.*
import com.google.gwt.user.client.ui.Widget

class HTableLayoutContainer extends PlainHTMLTable{
	
	new(){
		width = "100%"
	}
	def add(Iterable<? extends Widget> children){
		this.tr=>[ptr|
			children.forEach[child|
				ptr.td=>[add(child)]
			]
		]
	}
	
}