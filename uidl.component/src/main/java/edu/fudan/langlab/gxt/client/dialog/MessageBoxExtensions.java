package edu.fudan.langlab.gxt.client.dialog;

import com.google.gwt.event.shared.HandlerRegistration;
import com.sencha.gxt.widget.core.client.Component;
import com.sencha.gxt.widget.core.client.Dialog;
import com.sencha.gxt.widget.core.client.Dialog.PredefinedButton;
import com.sencha.gxt.widget.core.client.box.MessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.HideEvent;
import com.sencha.gxt.widget.core.client.event.HideEvent.HideHandler;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class MessageBoxExtensions {
  public static HandlerRegistration addConfirmHandler(final MessageBox messageBox, final Procedure1<? super Void> handler) {
    final Procedure1<HideEvent> _function = new Procedure1<HideEvent>() {
        public void apply(final HideEvent event) {
          Component _source = event.getSource();
          TextButton _hideButton = ((Dialog) _source).getHideButton();
          String buttonID = _hideButton.getItemId();
          boolean _or = false;
          String _name = PredefinedButton.YES.name();
          boolean _equals = buttonID.equals(_name);
          if (_equals) {
            _or = true;
          } else {
            String _name_1 = PredefinedButton.OK.name();
            boolean _equals_1 = buttonID.equals(_name_1);
            _or = (_equals || _equals_1);
          }
          if (_or) {
            handler.apply(null);
          }
        }
      };
    HandlerRegistration _addHideHandler = messageBox.addHideHandler(new HideHandler() {
        public void onHide(HideEvent event) {
          _function.apply(event);
        }
    });
    return _addHideHandler;
  }
}
