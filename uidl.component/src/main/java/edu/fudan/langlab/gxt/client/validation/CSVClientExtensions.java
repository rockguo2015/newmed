package edu.fudan.langlab.gxt.client.validation;

import com.sencha.gxt.widget.core.client.box.MessageBox;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import edu.fudan.langlab.csv.shared.CSVValidationException;
import java.util.Collection;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.MapExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class CSVClientExtensions {
  public static void showErrors(final Throwable caught) {
    StringBuffer _stringBuffer = new StringBuffer();
    final StringBuffer sb = _stringBuffer;
    final CSVValidationException c = ((CSVValidationException) caught);
    Map<Integer,Collection<ValidationErrorItem>> _errors = c.getErrors();
    final Procedure2<Integer,Collection<ValidationErrorItem>> _function = new Procedure2<Integer,Collection<ValidationErrorItem>>() {
        public void apply(final Integer line, final Collection<ValidationErrorItem> items) {
          final Procedure1<ValidationErrorItem> _function = new Procedure1<ValidationErrorItem>() {
              public void apply(final ValidationErrorItem item) {
                Collection<String> _keys = item.getKeys();
                final Function1<String,Boolean> _function = new Function1<String,Boolean>() {
                    public Boolean apply(final String it) {
                      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(it);
                      boolean _not = (!_isNullOrEmpty);
                      return Boolean.valueOf(_not);
                    }
                  };
                Iterable<String> _filter = IterableExtensions.<String>filter(_keys, _function);
                final Function1<String,String> _function_1 = new Function1<String,String>() {
                    public String apply(final String it) {
                      String _title = c.getTitle(it);
                      return _title;
                    }
                  };
                Iterable<String> _map = IterableExtensions.<String, String>map(_filter, _function_1);
                final String keyList = IterableExtensions.join(_map, ",");
                String _xifexpression = null;
                boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(keyList);
                if (_isNullOrEmpty) {
                  _xifexpression = "";
                } else {
                  String _plus = (keyList + ":");
                  _xifexpression = _plus;
                }
                final String title = _xifexpression;
                String _plus_1 = (line + ":");
                String _plus_2 = (_plus_1 + title);
                String _message = item.getMessage();
                String _plus_3 = (_plus_2 + _message);
                sb.append(_plus_3);
                sb.append("<br>");
              }
            };
          IterableExtensions.<ValidationErrorItem>forEach(items, _function);
        }
      };
    MapExtensions.<Integer, Collection<ValidationErrorItem>>forEach(_errors, _function);
    String _string = sb.toString();
    MessageBox _messageBox = new MessageBox("\u6570\u636E\u9519\u8BEF,\u8BF7\u4FEE\u6539\u540E\u91CD\u65B0\u5BFC\u5165", _string);
    MessageBox mb = _messageBox;
    mb.show();
  }
}
