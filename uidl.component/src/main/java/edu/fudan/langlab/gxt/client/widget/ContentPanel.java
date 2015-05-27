package edu.fudan.langlab.gxt.client.widget;

import com.sencha.gxt.widget.core.client.button.TextButton;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareMultiObjectCommand;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.client.common.command.BaseSimpleCommand;
import edu.fudan.langlab.gxt.client.widget.Commands;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class ContentPanel extends com.sencha.gxt.widget.core.client.ContentPanel {
  private Commands commands;
  
  private IWidgetFactory widgets;
  
  public ContentPanel(final Commands commands, final IWidgetFactory widgets) {
    super();
    this.widgets = widgets;
    this.commands = commands;
  }
  
  public void addCommand(final ActionContext ac, final BaseContextAwareSingleObjectCommand command) {
    final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
        public void apply(final TextButton it) {
          ContentPanel.this.addButton(it);
        }
      };
    this.commands.asButton(ac, command, _function);
  }
  
  public void addCommand(final ActionContext ac, final BaseContextAwareSingleObjectCommand command, final String title) {
    final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
        public void apply(final TextButton it) {
          ContentPanel.this.addButton(it);
        }
      };
    this.commands.asButton(ac, command, title, _function);
  }
  
  public <T extends Object> void addCommand(final Function0<? extends T> valueProvider, final BaseContextAwareSingleObjectCommand<T> command) {
    final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
        public void apply(final TextButton it) {
          ContentPanel.this.addButton(it);
        }
      };
    this.commands.<T>asButton(valueProvider, command, _function);
  }
  
  public <T extends Object> void addCommand(final BaseContextAwareSingleObjectCommand<T> command) {
    final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
        public void apply(final TextButton it) {
          ContentPanel.this.addButton(it);
        }
      };
    this.commands.<T>asButton(command, _function);
  }
  
  public void addCommand(final ActionContext ac, final BaseContextAwareMultiObjectCommand command) {
    final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
        public void apply(final TextButton it) {
          ContentPanel.this.addButton(it);
        }
      };
    this.commands.asButton(ac, command, _function);
  }
  
  public void addSimpleCommand(final BaseSimpleCommand command) {
    final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
        public void apply(final TextButton it) {
          ContentPanel.this.addButton(it);
        }
      };
    this.commands.asButton(this.widgets, command, _function);
  }
}
