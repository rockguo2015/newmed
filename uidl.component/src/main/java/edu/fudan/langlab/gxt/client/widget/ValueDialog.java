package edu.fudan.langlab.gxt.client.widget;

import com.google.common.base.Objects;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.Dialog;
import com.sencha.gxt.widget.core.client.Dialog.PredefinedButton;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.uniquesoft.gwt.client.common.widgets.Size;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueProvider;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class ValueDialog<T extends Object> {
  private Procedure1<? super T> valueProcessor;
  
  private IValueProvider<T> valueProvider;
  
  public ValueDialog(final IValueProvider<T> valueProvider, final Procedure1<? super T> valueProcessor) {
    this.valueProvider = valueProvider;
    this.valueProcessor = valueProcessor;
  }
  
  public void show(final String title, final Size size) {
    Dialog _dialog = new Dialog();
    final Dialog dialog = _dialog;
    dialog.setPredefinedButtons(PredefinedButton.OK, PredefinedButton.CANCEL);
    dialog.setModal(true);
    Object _asWidget = this.valueProvider.asWidget();
    dialog.add(((Widget) _asWidget));
    String _name = PredefinedButton.CANCEL.name();
    TextButton _buttonById = dialog.getButtonById(_name);
    final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
        public void apply(final SelectEvent it) {
          dialog.hide();
        }
      };
    _buttonById.addSelectHandler(new SelectHandler() {
        public void onSelect(SelectEvent event) {
          _function.apply(event);
        }
    });
    String _name_1 = PredefinedButton.OK.name();
    TextButton _buttonById_1 = dialog.getButtonById(_name_1);
    final Procedure1<SelectEvent> _function_1 = new Procedure1<SelectEvent>() {
        public void apply(final SelectEvent it) {
          boolean _notEquals = (!Objects.equal(ValueDialog.this.valueProcessor, null));
          if (_notEquals) {
            T _value = ValueDialog.this.valueProvider.getValue();
            ValueDialog.this.valueProcessor.apply(_value);
          }
          dialog.hide();
        }
      };
    _buttonById_1.addSelectHandler(new SelectHandler() {
        public void onSelect(SelectEvent event) {
          _function_1.apply(event);
        }
    });
    dialog.show();
  }
}
