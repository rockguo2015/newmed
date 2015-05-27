package edu.fudan.langlab.theme.blue.client.navbar;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.CssResource.ImportedWithPrefix;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.sencha.gxt.core.client.dom.XElement;

import edu.fudan.langlab.theme.blue.client.navbar.NavMenuItem.NavMenuItemAppearance;

public class NavMenuItemBaseAppearance implements NavMenuItemAppearance {
	public interface NavMenuItemResources extends ClientBundle {

		@Source("nav_bts.png")
		ImageResource nav_bts();

		@Source("nav_bt.jpg")
		ImageResource nav_bt();

		@Source("nav_select.png")
		ImageResource nav_select();
		
		@Source("nav0.png")
		ImageResource nav_header();

		@Source("NavMenuItem.css")
		NavMenuItemStyle style();
	}

	@ImportedWithPrefix("uidl-NavMenuItem")
	public interface NavMenuItemStyle extends CssResource {

		String menuStyle();

		String menuStyleSelected();

		String titleStyle();

		String titleStyleSelected();

		String leadImage();

		String leadImageSelected();

		String tailImageSelected();
	}

	private final NavMenuItemResources resource;

	public NavMenuItemBaseAppearance() {
		resource = GWT.create(NavMenuItemResources.class);
		resource.style().ensureInjected();
	}

	private XElement getLeadSpan(XElement parent) {
		return XElement.as(parent.getChild(0));
	}

	private XElement getAnchor(XElement parent) {
		return XElement.as(parent.getChild(1));
	}

	private XElement getTailSpan(XElement parent) {
		return XElement.as(parent.getChild(2));
	}

	@Override
	public void render(SafeHtmlBuilder markupBuilder) {
		markupBuilder.appendHtmlConstant("<dl class='"
				+ resource.style().menuStyle() + "'><span class='"
				+ resource.style().leadImage() + "'></span><a href='#' class='"
				+ resource.style().titleStyle() + "'></a><span></span></dl>");
	}

	@Override
	public void setTitle(XElement element, String title) {
		getAnchor(element).setInnerText(title);
	}

	@Override
	public void selected(XElement element) {
		element.addClassName(resource.style().menuStyleSelected());
		this.getLeadSpan(element).addClassName(
				resource.style().leadImageSelected());
		this.getAnchor(element).addClassName(
				resource.style().titleStyleSelected());
		this.getTailSpan(element).addClassName(
				resource.style().tailImageSelected());
	}

	@Override
	public void unselected(XElement element) {
		element.removeClassName(resource.style().menuStyleSelected());
		this.getLeadSpan(element).removeClassName(
				resource.style().leadImageSelected());

		this.getAnchor(element).removeClassName(
				resource.style().titleStyleSelected());
		this.getTailSpan(element).removeClassName(
				resource.style().tailImageSelected());
	}

}
