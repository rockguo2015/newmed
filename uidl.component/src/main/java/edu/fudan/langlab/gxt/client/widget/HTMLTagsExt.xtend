package edu.fudan.langlab.gxt.client.widget

import com.google.gwt.user.client.ui.FlowPanel
import com.google.gwt.user.client.ui.HasWidgets
import com.google.gwt.user.client.ui.HTML
import com.sencha.gxt.widget.core.client.FramedPanel
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer
import com.google.gwt.user.client.ui.Widget
import com.sencha.gxt.widget.core.client.container.MarginData
import com.sencha.gxt.core.client.util.Margins
import com.sencha.gxt.widget.core.client.ContentPanel

class HTMLTagsExt {
	def static FlowPanel DIV(){
		new FlowPanel
	}
	
	def static FlowPanel div(HasWidgets container){
		DIV=>[
			container.add(it)
		]
	}
	
	def static HTML P(String content){
		new HTML(content)
	}
	
	def static HTML p(HasWidgets container, String content){
		P(content)=>[
			container.add(it)
		]
	}
	
	def static HTML(HasWidgets container, String content){
		P(content)=>[
			container.add(it)
		]
	}
	
	def static PlainHTMLTable TABLE(){
		new PlainHTMLTable=>[
			width="100%"
		]
	}
	
	def static PlainHTMLTable table(HasWidgets container){
		TABLE=>[
			container.add(it)
		]
	}
	
	
	def static PlainHTMLTR tr(HasWidgets container){
		new PlainHTMLTR=>[
			container.add(it)
		]
	}
	
	def static PlainHTMLTD td(HasWidgets container){
		new PlainHTMLTD=>[
			container.add(it)
		]
	}
	
	def static com.sencha.gxt.widget.core.client.FramedPanel framedPanel(HasWidgets container, String title){
		new com.sencha.gxt.widget.core.client.FramedPanel=>[
			headingText = title
			container.add(it)
		]
	}
	
	def static void west(BorderLayoutContainer borderLayout, int width, (void)=>Widget widgetProvider){
		borderLayout.setWestWidget(
			widgetProvider.apply(null),
			new BorderLayoutContainer$BorderLayoutData(width)=>[
				setSplit(true)
				setCollapsible(true)
				setCollapseHidden(true)
				setCollapseMini(true)
			]
		)
	}
	
	def static void north(BorderLayoutContainer borderLayout, (void)=>Widget widgetProvider){
		borderLayout.setNorthWidget(
			new com.sencha.gxt.widget.core.client.ContentPanel=>[
				widget = widgetProvider.apply(null)
			],
			new BorderLayoutContainer$BorderLayoutData=>[
				setSplit(true)
				setCollapsible(true)
				setCollapseHidden(true)
				setCollapseMini(true)
			])
		
	}
	def static void south(BorderLayoutContainer borderLayout, double width,(void)=>Widget widgetProvider){
		
		borderLayout.setSouthWidget(widgetProvider.apply(null),
			new BorderLayoutContainer$BorderLayoutData(width)=>[
				setSplit(true)
				setCollapsible(true)
//				setCollapseHidden(true)
				setCollapseMini(true)
			])
		
	}
	
	
	
	def static void center(BorderLayoutContainer borderLayout, (void)=>Widget widgetProvider){
		var MarginData centerData = new MarginData();
		centerData.setMargins(new Margins(0, 0, 0, 0));
		
		borderLayout.setCenterWidget(widgetProvider.apply(null),centerData)
	}
}