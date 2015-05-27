package edu.fudan.langlab.gxt.client.widget;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasWidgets;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;

public class HTMLTags {

	public static FlowPanel DIV() {
		return new FlowPanel();
	}
	
	public  static FlowPanel div(HasWidgets container) {
		FlowPanel result = DIV();
		container.add(result);
		return result;
	}
	public static HTML P(String content) {
		return new HTML(content);
	}
	public static HTML p(HasWidgets container,String content) {
		HTML result = P(content);
		container.add(result);
		return result;
	}

	public static PlainHTMLTable TABLE(){
		return new PlainHTMLTable();
	}
	
	public static PlainHTMLTable table(HasWidgets container){
		PlainHTMLTable result = TABLE();
		container.add(result);
		return result;
	}
	
	public static PlainHTMLTR TR(){
		return new PlainHTMLTR();
	}
	
	public static PlainHTMLTR tr(HasWidgets container){
		PlainHTMLTR result = TR();
		container.add(result);
		return result;
	}
	
	public static PlainHTMLTD TD(){
		return new PlainHTMLTD();
	}
	
	public static PlainHTMLTD td(HasWidgets container){
		PlainHTMLTD result = TD();
		container.add(result);
		return result;
	}
	
	public static FramedPanel framedPanel(HasWidgets container, String title){
		FramedPanel result = new FramedPanel();
		result.setHeadingText(title);
		container.add(result);
		return result;
	}
	
//	public static void west(BorderLayoutContainer borderLayout, int width, (void) => Widget widgetProvider){
//		
//	}

}
