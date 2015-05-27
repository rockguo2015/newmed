package edu.fudan.langlab.gxt.client.component.propertyview;

import com.google.gwt.user.client.ui.Label;
import com.sencha.gxt.core.client.dom.ScrollSupport;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.uniquesoft.gwt.client.common.widgets.component.BaseComponent;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer;

import edu.fudan.langlab.gxt.client.component.propertyview.factory.AbstractPropertyItem;
import edu.fudan.langlab.gxt.client.component.propertyview.factory.IPropertyItem;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTD;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTR;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTable;

public abstract class GXTPropertyView<T> extends BaseComponent<T> implements
		IValueViewer<T> {
	public abstract ICanAsWidget getWidget(String key);

	@Override
	public VerticalLayoutContainer asWidget() {
		VerticalLayoutContainer container = new VerticalLayoutContainer();
		container.setScrollMode(ScrollSupport.ScrollMode.AUTOY);
		PlainHTMLTable result = new PlainHTMLTable();
		container.add(result, new VerticalLayoutData(1, -1));
		result.setAttribute("style",
				"border-collapse:collapse;border: 1px solid #D3D3D3;font-size:12");
		Iterable<ICanAsWidget> items = getAllProperties();
		int cols = getCols();
		int count = 0;
		PlainHTMLTR tr = new PlainHTMLTR();
		tr.setAttribute("style", "border: 1px solid #D3D3D3;");
		tr.setHeight("25");
		for (ICanAsWidget widget : items) {
			IPropertyItem<T> item = (IPropertyItem<T>) widget;
			if (count == cols * 2) {
				result.add(tr);
				tr = new PlainHTMLTR();
				tr.setAttribute("style", "border: 1px solid #D3D3D3;");
				tr.setHeight("25");
				count = 0;
			}
			PlainHTMLTD nameTD = new PlainHTMLTD();
			PlainHTMLTD valueTD = new PlainHTMLTD();
			nameTD.add(new Label(item.getName()));
			valueTD.add(item.asWidget());
			if (item.getColspan() > 1)
				valueTD.setAttribute("colspan",
						String.valueOf(item.getColspan() * 2 - 1));
			nameTD.setAttribute(
					"style",
					"background:#F0F8FF;border: 1px solid #D3D3D3;padding:2px 5px 2px 20px;width:100px");
			valueTD.setAttribute("style",
					"border: 1px solid #D3D3D3;padding:2px 20px 2px 5px;");
			tr.add(nameTD);
			tr.add(valueTD);
			count += item.getColspan() * 2;
		}
		result.add(tr);
		return container;
	}

	public Integer getCols() {
		return 1;
	}
}
