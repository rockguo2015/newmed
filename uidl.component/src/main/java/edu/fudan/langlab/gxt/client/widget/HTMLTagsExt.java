package edu.fudan.langlab.gxt.client.widget;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
import com.sencha.gxt.widget.core.client.container.MarginData;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTD;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTR;
import edu.fudan.langlab.gxt.client.widget.PlainHTMLTable;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class HTMLTagsExt {
  public static FlowPanel DIV() {
    FlowPanel _flowPanel = new FlowPanel();
    return _flowPanel;
  }
  
  public static FlowPanel div(final HasWidgets container) {
    FlowPanel _DIV = HTMLTagsExt.DIV();
    final Procedure1<FlowPanel> _function = new Procedure1<FlowPanel>() {
        public void apply(final FlowPanel it) {
          container.add(it);
        }
      };
    FlowPanel _doubleArrow = ObjectExtensions.<FlowPanel>operator_doubleArrow(_DIV, _function);
    return _doubleArrow;
  }
  
  public static HTML P(final String content) {
    HTML _hTML = new HTML(content);
    return _hTML;
  }
  
  public static HTML p(final HasWidgets container, final String content) {
    HTML _P = HTMLTagsExt.P(content);
    final Procedure1<HTML> _function = new Procedure1<HTML>() {
        public void apply(final HTML it) {
          container.add(it);
        }
      };
    HTML _doubleArrow = ObjectExtensions.<HTML>operator_doubleArrow(_P, _function);
    return _doubleArrow;
  }
  
  public static HTML HTML(final HasWidgets container, final String content) {
    HTML _P = HTMLTagsExt.P(content);
    final Procedure1<HTML> _function = new Procedure1<HTML>() {
        public void apply(final HTML it) {
          container.add(it);
        }
      };
    HTML _doubleArrow = ObjectExtensions.<HTML>operator_doubleArrow(_P, _function);
    return _doubleArrow;
  }
  
  public static PlainHTMLTable TABLE() {
    PlainHTMLTable _plainHTMLTable = new PlainHTMLTable();
    final Procedure1<PlainHTMLTable> _function = new Procedure1<PlainHTMLTable>() {
        public void apply(final PlainHTMLTable it) {
          it.setWidth("100%");
        }
      };
    PlainHTMLTable _doubleArrow = ObjectExtensions.<PlainHTMLTable>operator_doubleArrow(_plainHTMLTable, _function);
    return _doubleArrow;
  }
  
  public static PlainHTMLTable table(final HasWidgets container) {
    PlainHTMLTable _TABLE = HTMLTagsExt.TABLE();
    final Procedure1<PlainHTMLTable> _function = new Procedure1<PlainHTMLTable>() {
        public void apply(final PlainHTMLTable it) {
          container.add(it);
        }
      };
    PlainHTMLTable _doubleArrow = ObjectExtensions.<PlainHTMLTable>operator_doubleArrow(_TABLE, _function);
    return _doubleArrow;
  }
  
  public static PlainHTMLTR tr(final HasWidgets container) {
    PlainHTMLTR _plainHTMLTR = new PlainHTMLTR();
    final Procedure1<PlainHTMLTR> _function = new Procedure1<PlainHTMLTR>() {
        public void apply(final PlainHTMLTR it) {
          container.add(it);
        }
      };
    PlainHTMLTR _doubleArrow = ObjectExtensions.<PlainHTMLTR>operator_doubleArrow(_plainHTMLTR, _function);
    return _doubleArrow;
  }
  
  public static PlainHTMLTD td(final HasWidgets container) {
    PlainHTMLTD _plainHTMLTD = new PlainHTMLTD();
    final Procedure1<PlainHTMLTD> _function = new Procedure1<PlainHTMLTD>() {
        public void apply(final PlainHTMLTD it) {
          container.add(it);
        }
      };
    PlainHTMLTD _doubleArrow = ObjectExtensions.<PlainHTMLTD>operator_doubleArrow(_plainHTMLTD, _function);
    return _doubleArrow;
  }
  
  public static FramedPanel framedPanel(final HasWidgets container, final String title) {
    FramedPanel _framedPanel = new FramedPanel();
    final Procedure1<FramedPanel> _function = new Procedure1<FramedPanel>() {
        public void apply(final FramedPanel it) {
          it.setHeadingText(title);
          container.add(it);
        }
      };
    FramedPanel _doubleArrow = ObjectExtensions.<FramedPanel>operator_doubleArrow(_framedPanel, _function);
    return _doubleArrow;
  }
  
  public static void west(final BorderLayoutContainer borderLayout, final int width, final Function1<? super Void,? extends Widget> widgetProvider) {
    Widget _apply = widgetProvider.apply(null);
    BorderLayoutData _borderLayoutData = new BorderLayoutData(width);
    final Procedure1<BorderLayoutData> _function = new Procedure1<BorderLayoutData>() {
        public void apply(final BorderLayoutData it) {
          it.setSplit(true);
          it.setCollapsible(true);
          it.setCollapseHidden(true);
          it.setCollapseMini(true);
        }
      };
    BorderLayoutData _doubleArrow = ObjectExtensions.<BorderLayoutData>operator_doubleArrow(_borderLayoutData, _function);
    borderLayout.setWestWidget(_apply, _doubleArrow);
  }
  
  public static void north(final BorderLayoutContainer borderLayout, final Function1<? super Void,? extends Widget> widgetProvider) {
    ContentPanel _contentPanel = new ContentPanel();
    final Procedure1<ContentPanel> _function = new Procedure1<ContentPanel>() {
        public void apply(final ContentPanel it) {
          Widget _apply = widgetProvider.apply(null);
          it.setWidget(_apply);
        }
      };
    ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_contentPanel, _function);
    BorderLayoutData _borderLayoutData = new BorderLayoutData();
    final Procedure1<BorderLayoutData> _function_1 = new Procedure1<BorderLayoutData>() {
        public void apply(final BorderLayoutData it) {
          it.setSplit(true);
          it.setCollapsible(true);
          it.setCollapseHidden(true);
          it.setCollapseMini(true);
        }
      };
    BorderLayoutData _doubleArrow_1 = ObjectExtensions.<BorderLayoutData>operator_doubleArrow(_borderLayoutData, _function_1);
    borderLayout.setNorthWidget(_doubleArrow, _doubleArrow_1);
  }
  
  public static void south(final BorderLayoutContainer borderLayout, final double width, final Function1<? super Void,? extends Widget> widgetProvider) {
    Widget _apply = widgetProvider.apply(null);
    BorderLayoutData _borderLayoutData = new BorderLayoutData(width);
    final Procedure1<BorderLayoutData> _function = new Procedure1<BorderLayoutData>() {
        public void apply(final BorderLayoutData it) {
          it.setSplit(true);
          it.setCollapsible(true);
          it.setCollapseMini(true);
        }
      };
    BorderLayoutData _doubleArrow = ObjectExtensions.<BorderLayoutData>operator_doubleArrow(_borderLayoutData, _function);
    borderLayout.setSouthWidget(_apply, _doubleArrow);
  }
  
  public static void center(final BorderLayoutContainer borderLayout, final Function1<? super Void,? extends Widget> widgetProvider) {
    MarginData _marginData = new MarginData();
    MarginData centerData = _marginData;
    Margins _margins = new Margins(0, 0, 0, 0);
    centerData.setMargins(_margins);
    Widget _apply = widgetProvider.apply(null);
    borderLayout.setCenterWidget(_apply, centerData);
  }
}
