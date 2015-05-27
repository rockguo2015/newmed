package edu.fudan.langlab.gxt.client.widget;

import com.google.gwt.user.client.ui.Widget;
import com.uniquesoft.gwt.client.common.Presenter;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.shared.IGWTEntity;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.Commands;
import edu.fudan.langlab.gxt.client.widget.ContentPanel;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class TabPanel extends com.sencha.gxt.widget.core.client.TabPanel {
  private Commands commands;
  
  private IWidgetFactory widgets;
  
  public TabPanel(final Commands commands, final IWidgetFactory widgets) {
    super();
    this.widgets = widgets;
    this.commands = commands;
  }
  
  public <T extends IGWTEntity> ContentPanel add(final ActionContext<T> context, final IContextConsumer<T> contextConsumer, final String title) {
    ContentPanel _xblockexpression = null;
    {
      ContentPanel _contentPanel = new ContentPanel(this.commands, this.widgets);
      final Procedure1<ContentPanel> _function = new Procedure1<ContentPanel>() {
          public void apply(final ContentPanel it) {
            contextConsumer.setContext(context);
            Viewer _view = ((Presenter) contextConsumer).getView();
            Widget _asWidget = _view.asWidget();
            it.setWidget(_asWidget);
          }
        };
      final ContentPanel contentPanel = ObjectExtensions.<ContentPanel>operator_doubleArrow(_contentPanel, _function);
      this.add(contentPanel, title);
      _xblockexpression = (contentPanel);
    }
    return _xblockexpression;
  }
}
