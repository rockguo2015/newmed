package edu.fudan.langlab.gxt.client.validation;

import com.google.common.base.Objects;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multiset;
import com.google.gwt.editor.client.EditorError;
import com.google.gwt.editor.client.HasEditorErrors;
import com.sencha.gxt.widget.core.client.form.error.DefaultEditorError;
import com.sencha.gxt.widget.core.client.info.Info;
import com.uniquesoft.gwt.client.common.GWTAbstractView;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import java.util.Collection;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public abstract class ErrorNotifierViewer extends GWTAbstractView implements ViewerWithValidation {
  public void clearErrors() {
  }
  
  public HasEditorErrors mapField(final String errorKey) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException();
    throw _unsupportedOperationException;
  }
  
  public void showValidationErrors(final Collection<ValidationErrorItem> errors) {
    this.clearErrors();
    final ArrayListMultimap<HasEditorErrors,EditorError> mm = ArrayListMultimap.<HasEditorErrors, EditorError>create();
    final Function1<String,HasEditorErrors> _function = new Function1<String,HasEditorErrors>() {
        public HasEditorErrors apply(final String it) {
          HasEditorErrors _mapField = ErrorNotifierViewer.this.mapField(it);
          return _mapField;
        }
      };
    final Function1<? super String,? extends HasEditorErrors> fieldMapper = _function;
    final Procedure1<ValidationErrorItem> _function_1 = new Procedure1<ValidationErrorItem>() {
        public void apply(final ValidationErrorItem item) {
          Collection<String> _keys = item.getKeys();
          final Procedure1<String> _function = new Procedure1<String>() {
              public void apply(final String it) {
                final HasEditorErrors field = fieldMapper.apply(it);
                boolean _equals = Objects.equal(field, null);
                if (_equals) {
                  String _messageWithTitle = item.getMessageWithTitle();
                  Info.display("\u6570\u636E\u6821\u9A8C\u9519\u8BEF", _messageWithTitle);
                } else {
                  String _message = item.getMessage();
                  DefaultEditorError _defaultEditorError = new DefaultEditorError(field, _message, null);
                  mm.put(field, _defaultEditorError);
                }
              }
            };
          IterableExtensions.<String>forEach(_keys, _function);
        }
      };
    IterableExtensions.<ValidationErrorItem>forEach(errors, _function_1);
    Multiset<HasEditorErrors> _keys = mm.keys();
    final Procedure1<HasEditorErrors> _function_2 = new Procedure1<HasEditorErrors>() {
        public void apply(final HasEditorErrors it) {
          List<EditorError> _get = mm.get(it);
          it.showErrors(_get);
        }
      };
    IterableExtensions.<HasEditorErrors>forEach(_keys, _function_2);
  }
}
