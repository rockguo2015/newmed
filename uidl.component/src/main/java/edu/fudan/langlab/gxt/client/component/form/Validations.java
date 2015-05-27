package edu.fudan.langlab.gxt.client.component.form;

import com.google.common.base.Objects;
import com.google.gwt.editor.client.EditorError;
import com.google.gwt.editor.client.HasEditorErrors;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueProvider;
import edu.fudan.langlab.gxt.client.component.form.GXTFormComponent;
import edu.fudan.langlab.gxt.client.component.form.factory.ComponentDelegateValueProvider;
import java.util.ArrayList;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class Validations {
  public static HasEditorErrors mapToErrorEditor(final GXTFormComponent form, final String errorKey) {
    String head = errorKey;
    String tail = "";
    int _indexOf = errorKey.indexOf(".");
    boolean _greaterThan = (_indexOf > 0);
    if (_greaterThan) {
      int _indexOf_1 = errorKey.indexOf(".");
      String _substring = errorKey.substring(0, _indexOf_1);
      head = _substring;
      int _indexOf_2 = errorKey.indexOf(".");
      int _plus = (_indexOf_2 + 1);
      String _substring_1 = errorKey.substring(_plus);
      tail = _substring_1;
    }
    try {
      ICanAsWidget widget = form.getWidget(head);
      boolean _equals = Objects.equal(widget, null);
      if (_equals) {
        return null;
      } else {
        if ((widget instanceof ComponentDelegateValueProvider)) {
          IValueProvider _deletate = ((ComponentDelegateValueProvider) widget).getDeletate();
          return Validations.mapToErrorEditor(((GXTFormComponent) _deletate), tail);
        } else {
          Object _asWidget = widget.asWidget();
          Widget _widget = ((FieldLabel) _asWidget).getWidget();
          return ((HasEditorErrors) _widget);
        }
      }
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        RuntimeException _runtimeException = new RuntimeException(e);
        throw _runtimeException;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public static void clearErrors(final GXTFormComponent form) {
    Iterable<ICanAsWidget> _allProperties = form.getAllProperties();
    final Procedure1<ICanAsWidget> _function = new Procedure1<ICanAsWidget>() {
        public void apply(final ICanAsWidget it) {
          final Object w = it.asWidget();
          boolean _and = false;
          boolean _and_1 = false;
          boolean _notEquals = (!Objects.equal(w, null));
          if (!_notEquals) {
            _and_1 = false;
          } else {
            _and_1 = (_notEquals && (w instanceof FieldLabel));
          }
          if (!_and_1) {
            _and = false;
          } else {
            Widget _widget = ((FieldLabel) w).getWidget();
            _and = (_and_1 && (_widget instanceof HasEditorErrors));
          }
          if (_and) {
            Widget _widget_1 = ((FieldLabel) w).getWidget();
            ArrayList<EditorError> _newArrayList = CollectionLiterals.<EditorError>newArrayList();
            ((HasEditorErrors) _widget_1).showErrors(_newArrayList);
          }
        }
      };
    IterableExtensions.<ICanAsWidget>forEach(_allProperties, _function);
  }
}
