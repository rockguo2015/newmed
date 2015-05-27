package edu.fudan.langlab.gxt.client.component.grid;

import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;

public interface ICellRender<T> {
	void render(Context context, T value, SafeHtmlBuilder sb);
}
