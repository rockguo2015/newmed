package edu.fudan.langlab.gxt.client.widget;

import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FieldSet;
import com.sencha.gxt.widget.core.client.form.FormPanel.LabelAlign;

@SuppressWarnings("all")
public class WidgetExtensions {
  public static <T extends Widget> T addFill(final VerticalLayoutContainer vcontainer, final T widget) {
    T _xblockexpression = null;
    {
      int _minus = (-10);
      int _minus_1 = (-1);
      VerticalLayoutData _verticalLayoutData = new VerticalLayoutData(_minus, _minus_1);
      vcontainer.add(widget, _verticalLayoutData);
      _xblockexpression = (widget);
    }
    return _xblockexpression;
  }
  
  public static Widget withBorder(final Widget widget) {
    ContentPanel _xblockexpression = null;
    {
      ContentPanel _contentPanel = new ContentPanel();
      final ContentPanel result = _contentPanel;
      result.setHeaderVisible(false);
      result.setWidget(widget);
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  public static Widget withFieldSet(final Widget widget, final String title) {
    FieldSet _xblockexpression = null;
    {
      FieldSet _fieldSet = new FieldSet();
      final FieldSet fieldSet = _fieldSet;
      fieldSet.setHeadingText(title);
      fieldSet.setWidget(widget);
      _xblockexpression = (fieldSet);
    }
    return _xblockexpression;
  }
  
  public static FieldLabel alignTop(final FieldLabel label) {
    FieldLabel _xblockexpression = null;
    {
      label.setLabelAlign(LabelAlign.TOP);
      _xblockexpression = (label);
    }
    return _xblockexpression;
  }
}
