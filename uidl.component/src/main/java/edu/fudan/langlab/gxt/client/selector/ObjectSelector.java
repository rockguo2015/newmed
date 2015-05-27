package edu.fudan.langlab.gxt.client.selector;

import com.google.common.base.Objects;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.Dialog;
import com.sencha.gxt.widget.core.client.Dialog.PredefinedButton;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.uniquesoft.gwt.client.common.Presenter;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.selector.IHasObjectSelectionProvider;
import com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider;
import com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider.SelectionChangedListener;
import edu.fudan.langlab.gxt.client.selector.ObjectsSelector;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class ObjectSelector<T extends Object> {
  private Procedure1<? super T> action;
  
  private IHasObjectSelectionProvider<T> presenter;
  
  private T selectedObject;
  
  public ObjectSelector(final IHasObjectSelectionProvider<T> presenter, final Procedure1<? super T> action) {
    this.action = action;
    this.presenter = presenter;
  }
  
  public Dialog asDialog(final int width, final int height) {
    Dialog _dialog = new Dialog();
    final Procedure1<Dialog> _function = new Procedure1<Dialog>() {
        public void apply(final Dialog dialog) {
          dialog.setWidth(width);
          dialog.setHeight(height);
          dialog.setPredefinedButtons(PredefinedButton.OK, PredefinedButton.CANCEL);
          dialog.setModal(true);
          Viewer _view = ((Presenter) ObjectSelector.this.presenter).getView();
          Widget _asWidget = _view.asWidget();
          dialog.add(_asWidget);
          String _name = PredefinedButton.CANCEL.name();
          TextButton _buttonById = dialog.getButtonById(_name);
          final Procedure1<TextButton> _function = new Procedure1<TextButton>() {
              public void apply(final TextButton it) {
                final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                    public void apply(final SelectEvent it) {
                      boolean _isActivated = ((Presenter) ObjectSelector.this.presenter).getIsActivated();
                      if (_isActivated) {
                        ((Presenter) ObjectSelector.this.presenter).deactivate();
                      }
                      dialog.hide();
                    }
                  };
                it.addSelectHandler(new SelectHandler() {
                    public void onSelect(SelectEvent event) {
                      _function.apply(event);
                    }
                });
              }
            };
          ObjectExtensions.<TextButton>operator_doubleArrow(_buttonById, _function);
          ObjectSelectionProvider<T> _selectionProvider = ObjectSelector.this.presenter.getSelectionProvider();
          final Procedure1<Iterable<T>> _function_1 = new Procedure1<Iterable<T>>() {
              public void apply(final Iterable<T> it) {
                T _head = IterableExtensions.<T>head(it);
                ObjectSelector.this.selectedObject = _head;
              }
            };
          _selectionProvider.addSelectionChangedListener(new SelectionChangedListener<T>() {
              public void selectionChanged(Iterable<T> selections) {
                _function_1.apply(selections);
              }
          });
          String _name_1 = PredefinedButton.OK.name();
          TextButton _buttonById_1 = dialog.getButtonById(_name_1);
          final Procedure1<TextButton> _function_2 = new Procedure1<TextButton>() {
              public void apply(final TextButton it) {
                final Procedure1<SelectEvent> _function = new Procedure1<SelectEvent>() {
                    public void apply(final SelectEvent it) {
                      boolean _notEquals = (!Objects.equal(ObjectSelector.this.selectedObject, null));
                      if (_notEquals) {
                        ObjectSelector.this.action.apply(ObjectSelector.this.selectedObject);
                      }
                      boolean _isActivated = ((Presenter) ObjectSelector.this.presenter).getIsActivated();
                      if (_isActivated) {
                        ((Presenter) ObjectSelector.this.presenter).deactivate();
                      }
                      dialog.hide();
                    }
                  };
                it.addSelectHandler(new SelectHandler() {
                    public void onSelect(SelectEvent event) {
                      _function.apply(event);
                    }
                });
              }
            };
          ObjectExtensions.<TextButton>operator_doubleArrow(_buttonById_1, _function_2);
        }
      };
    Dialog _doubleArrow = ObjectExtensions.<Dialog>operator_doubleArrow(_dialog, _function);
    return _doubleArrow;
  }
  
  public static <T extends Object> Dialog asSelector(final IHasObjectSelectionProvider<T> selectionProvider, final String title, final int width, final int height, final Procedure1<? super T> action) {
    ObjectSelector<T> _objectSelector = new ObjectSelector<T>(selectionProvider, action);
    Dialog _asDialog = _objectSelector.asDialog(width, height);
    final Procedure1<Dialog> _function = new Procedure1<Dialog>() {
        public void apply(final Dialog it) {
          it.setTitle(title);
        }
      };
    Dialog _doubleArrow = ObjectExtensions.<Dialog>operator_doubleArrow(_asDialog, _function);
    return _doubleArrow;
  }
  
  public static <T extends Object> Dialog asMultiSelector(final IHasObjectSelectionProvider<T> selectionProvider, final String title, final int width, final int height, final Procedure1<? super Iterable<T>> action) {
    ObjectsSelector<T> _objectsSelector = new ObjectsSelector<T>(selectionProvider, action);
    Dialog _asDialog = _objectsSelector.asDialog(width, height);
    final Procedure1<Dialog> _function = new Procedure1<Dialog>() {
        public void apply(final Dialog it) {
          it.setTitle(title);
        }
      };
    Dialog _doubleArrow = ObjectExtensions.<Dialog>operator_doubleArrow(_asDialog, _function);
    return _doubleArrow;
  }
}
