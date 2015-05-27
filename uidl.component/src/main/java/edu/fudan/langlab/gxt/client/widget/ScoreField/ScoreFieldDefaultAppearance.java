package edu.fudan.langlab.gxt.client.widget.ScoreField;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.sencha.gxt.core.client.dom.XElement;
import com.sencha.gxt.core.client.resources.StyleInjectorHelper;

import edu.fudan.langlab.gxt.client.widget.ScoreField.ScoreFieldCell.ScoreFieldAppearance;


public class ScoreFieldDefaultAppearance implements ScoreFieldAppearance {
	private ScoreFieldResources res;
	private ScoreFieldStyle style;
	  protected XElement lastParent;

	public interface ScoreFieldResources extends ClientBundle {
		@Source({ "ScoreField.css" })
		ScoreFieldStyle css();

		ImageResource star();

		ImageResource star_select();

	}

	public interface ScoreFieldStyle extends CssResource {
		
		String select();

		String noselect();
	}

	public ScoreFieldDefaultAppearance() {
		this(GWT.<ScoreFieldResources> create(ScoreFieldResources.class));
	}

	public ScoreFieldDefaultAppearance(ScoreFieldResources resources) {
		this.res = resources;
		this.style = res.css();
		StyleInjectorHelper.ensureInjected(this.style, true);
	}

	@Override
	public XElement getInputElement(Element parent) {
		lastParent = parent.<XElement> cast();
		return parent.<XElement> cast();
	}

	@Override
	public void onEmpty(Element parent, boolean empty) {
	}

	@Override
	public void onFocus(Element parent, boolean focus) {
	}

	@Override
	public void onValid(Element parent, boolean valid) {
	}

	@Override
	public void setReadOnly(Element parent, boolean readonly) {
	}

	@Override
	public void onSelect(XElement parent, int score) {
		try{
		Element child = parent.childElement("a");
		while (child != null) {
			int id = Integer.parseInt(child.getId());
			if (id <= score) {
				child.removeClassName(style.noselect());
				child.addClassName(style.select());
			} else {
				child.removeClassName(style.select());
				child.addClassName(style.noselect());
			}
			child = child.getNextSiblingElement();
		}
		}catch(Exception e ){
			//DO Nothing
		}

	}

	@Override
	public void initStars(SafeHtmlBuilder sb, int maxStars, int stars) {
		for (int i = 1; i <= maxStars; i++) {
			sb.appendHtmlConstant("<a class='" + ((i<=stars)?this.style.select():this.style.noselect())
					+ "' id='" + i + "'></a>");
		}
	}

}
