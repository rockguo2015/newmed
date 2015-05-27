package edu.fudan.langlab.csv.shared;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.csv.shared.CSVValidationException;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class CSVValidationExtensions {
  public static <T extends Object> void forEachWithCVSValidation(final Iterable<T> datas, final Procedure1<? super T> processor, final Function1<? super String,? extends String> keyTitleMapper) {
    final Map<Integer,Collection<ValidationErrorItem>> errors = CollectionLiterals.<Integer, Collection<ValidationErrorItem>>newHashMap();
    final Procedure2<T,Long> _function = new Procedure2<T,Long>() {
        public void apply(final T value, final Long index) {
          try {
            processor.apply(value);
          } catch (final Throwable _t) {
            if (_t instanceof ValidationException) {
              final ValidationException e = (ValidationException)_t;
              long _plus = ((index).longValue() + 1);
              int _intValue = Long.valueOf(_plus).intValue();
              Collection<ValidationErrorItem> _errors = e.getErrors();
              errors.put(Integer.valueOf(_intValue), _errors);
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
        }
      };
    IterableExtensions2.<T>forEachWithIndex(datas, _function);
    Collection<Collection<ValidationErrorItem>> _values = errors.values();
    Iterable<ValidationErrorItem> _flatten = Iterables.<ValidationErrorItem>concat(_values);
    final Function1<ValidationErrorItem,Collection<String>> _function_1 = new Function1<ValidationErrorItem,Collection<String>>() {
        public Collection<String> apply(final ValidationErrorItem it) {
          Collection<String> _keys = it.getKeys();
          return _keys;
        }
      };
    Iterable<Collection<String>> _map = IterableExtensions.<ValidationErrorItem, Collection<String>>map(_flatten, _function_1);
    Iterable<String> _flatten_1 = Iterables.<String>concat(_map);
    final Function1<String,Boolean> _function_2 = new Function1<String,Boolean>() {
        public Boolean apply(final String it) {
          boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(it);
          boolean _not = (!_isNullOrEmpty);
          return Boolean.valueOf(_not);
        }
      };
    Iterable<String> _filter = IterableExtensions.<String>filter(_flatten_1, _function_2);
    Set<String> _set = IterableExtensions.<String>toSet(_filter);
    final Function1<String,String> _function_3 = new Function1<String,String>() {
        public String apply(final String it) {
          String _xblockexpression = null;
          {
            final String result = keyTitleMapper.apply(it);
            String _xifexpression = null;
            boolean _equals = Objects.equal(result, null);
            if (_equals) {
              _xifexpression = it;
            } else {
              _xifexpression = result;
            }
            _xblockexpression = (_xifexpression);
          }
          return _xblockexpression;
        }
      };
    Map<String,String> keyTitleMap = IterableExtensions.<String, String>toInvertedMap(_set, _function_3);
    int _size = errors.size();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      CSVValidationException _cSVValidationException = new CSVValidationException(keyTitleMap, errors);
      throw _cSVValidationException;
    }
  }
}
