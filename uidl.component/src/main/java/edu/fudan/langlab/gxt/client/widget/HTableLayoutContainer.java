package edu.fudan.langlab.gxt.client.widget;

import com.google.gwt.user.client.ui.Widget;
import edu.fudan.langlab.gxt.client.widget.HTMLTagsExt;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTD;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTR;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTable;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class HTableLayoutContainer extends PlainHTMLTable {
  public HTableLayoutContainer() {
    this.setWidth("100%");
  }
  
  public PlainHTMLTR add(final Iterable<? extends Widget> children) {
    PlainHTMLTR _tr = HTMLTagsExt.tr(this);
    final Procedure1<PlainHTMLTR> _function = new Procedure1<PlainHTMLTR>() {
        public void apply(final PlainHTMLTR ptr) {
          final Procedure1<Widget> _function = new Procedure1<Widget>() {
              public void apply(final Widget child) {
                PlainHTMLTD _td = HTMLTagsExt.td(ptr);
                final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
                    public void apply(final PlainHTMLTD it) {
                      it.add(child);
                    }
                  };
                ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_td, _function);
              }
            };
          IterableExtensions.forEach(children, _function);
        }
      };
    PlainHTMLTR _doubleArrow = ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_tr, _function);
    return _doubleArrow;
  }
}
