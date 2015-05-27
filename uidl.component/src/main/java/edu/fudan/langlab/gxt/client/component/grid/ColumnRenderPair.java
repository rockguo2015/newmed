package edu.fudan.langlab.gxt.client.component.grid;

import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridColumn;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

@SuppressWarnings("all")
public class ColumnRenderPair<T extends Object> {
  public GXTGridColumn<T,? extends Object> column;
  
  public Procedure2<? super SafeHtmlBuilder,? super Object> render;
  
  public ColumnRenderPair(final GXTGridColumn<T,? extends Object> column, final Procedure2<? super SafeHtmlBuilder,? super Object> render) {
    this.column = column;
    this.render = render;
  }
}
