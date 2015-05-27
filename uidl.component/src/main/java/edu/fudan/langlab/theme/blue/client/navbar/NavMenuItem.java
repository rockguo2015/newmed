package edu.fudan.langlab.theme.blue.client.navbar;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.sencha.gxt.core.client.dom.XDOM;
import com.sencha.gxt.core.client.dom.XElement;
import com.sencha.gxt.widget.core.client.Component;

public class NavMenuItem extends Component implements HasClickHandlers {

	public interface NavMenuItemAppearance {
		void render(SafeHtmlBuilder markupBuilder);

		public void setTitle(XElement element, String title);

		void selected(XElement element);

		void unselected(XElement element);
	}

	final NavMenuItemAppearance appearance;

	public NavMenuItem(String title) {
		this.appearance = GWT.create(NavMenuItemAppearance.class);
		SafeHtmlBuilder markupBuilder = new SafeHtmlBuilder();
		appearance.render(markupBuilder);
		
		setElement(XDOM.create(markupBuilder.toSafeHtml()));
		setText(title);
	}

	public void setText(String title) {
		appearance.setTitle(getElement(), title);
	}

	public void selected() {
		appearance.selected(getElement());
	}

	public void unselected(){
		appearance.unselected(getElement());
	}
	@Override
	public HandlerRegistration addClickHandler(ClickHandler handler) {
		return addDomHandler(handler, ClickEvent.getType());
	}
}
