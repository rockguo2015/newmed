package edu.fudan.langlab.csv.server;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.uniquesoft.gwt.shared.datatype.File;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.csv.server.mapper.ICSVMapper;
import edu.fudan.langlab.csv.shared.CSVValidationException;
import edu.fudan.langlab.csv.shared.IValidationResultAcceptor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure3;

@SuppressWarnings("all")
public class CSVUploader<T extends Object> {
  /**
   * file.importWith(csvMapper)[onSuccess[]]
   */
  public static <M extends Object> void importWith(final File f, final ICSVMapper<M> csvMapper, final Procedure1<? super CSVUploader<M>> initializer) {
    try {
      CSVUploader<M> _cSVUploader = new CSVUploader<M>();
      CSVUploader<M> uploader = _cSVUploader;
      uploader.csvMapper = csvMapper;
      initializer.apply(uploader);
      String _fullPathName = f.getFullPathName();
      uploader.doUpload(_fullPathName);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static <M extends Object> Procedure1<? super M> onCommitEach(final CSVUploader<M> uploader, final Procedure1<? super M> commitEach) {
    Procedure1<? super M> _commitEach = uploader.commitEach = commitEach;
    return _commitEach;
  }
  
  public static <M extends Object> Procedure1<? super Collection<M>> onCommitAll(final CSVUploader<M> uploader, final Procedure1<? super Collection<M>> commitAll) {
    Procedure1<? super Collection<M>> _commitAll = uploader.commitAll = commitAll;
    return _commitAll;
  }
  
  public static Procedure1<? super Map<Integer,Collection<ValidationErrorItem>>> onFailure(final CSVUploader<? extends Object> uploader, final Procedure1<? super Map<Integer,Collection<ValidationErrorItem>>> failure) {
    Procedure1<? super Map<Integer,Collection<ValidationErrorItem>>> _failure = uploader.failure = failure;
    return _failure;
  }
  
  public static <M extends Object> Procedure3<? super Collection<M>,? super M,? super Procedure2<? super String,? super String>> onPrecommitValidator(final CSVUploader<M> uploader, final Procedure3<? super Collection<M>,? super M,? super Procedure2<? super String,? super String>> precommitValidator) {
    Procedure3<? super Collection<M>,? super M,? super Procedure2<? super String,? super String>> _precommitValidator = uploader.precommitValidator = precommitValidator;
    return _precommitValidator;
  }
  
  private ICSVMapper<T> csvMapper;
  
  private Procedure1<? super Collection<T>> commitAll;
  
  private Procedure3<? super Collection<T>,? super T,? super Procedure2<? super String,? super String>> precommitValidator;
  
  private Procedure1<? super T> commitEach;
  
  private Procedure1<? super Map<Integer,Collection<ValidationErrorItem>>> failure;
  
  private Map<Integer,Collection<ValidationErrorItem>> errors = new Function0<Map<Integer,Collection<ValidationErrorItem>>>() {
    public Map<Integer,Collection<ValidationErrorItem>> apply() {
      LinkedHashMap<Integer,Collection<ValidationErrorItem>> _newLinkedHashMap = CollectionLiterals.<Integer, Collection<ValidationErrorItem>>newLinkedHashMap();
      return _newLinkedHashMap;
    }
  }.apply();
  
  public void doUpload(final String csvPath) throws IOException {
    FileReader _fileReader = new FileReader(csvPath);
    BufferedReader _bufferedReader = new BufferedReader(_fileReader);
    BufferedReader reader = _bufferedReader;
    reader.readLine();
    int lineIndex = 1;
    String curLine = reader.readLine();
    final ArrayList<T> result = CollectionLiterals.<T>newArrayList();
    boolean _notEquals = (!Objects.equal(curLine, null));
    boolean _while = _notEquals;
    while (_while) {
      {
        final ArrayList<ValidationErrorItem> errorsInThisLine = CollectionLiterals.<ValidationErrorItem>newArrayList();
        try {
          final Procedure1<ValidationErrorItem> _function = new Procedure1<ValidationErrorItem>() {
              public void apply(final ValidationErrorItem it) {
                errorsInThisLine.add(it);
              }
            };
          T _fromString = this.csvMapper.fromString(curLine, new IValidationResultAcceptor() {
              public void accept(ValidationErrorItem errorItem) {
                _function.apply(errorItem);
              }
          });
          result.add(((T) _fromString));
        } catch (final Throwable _t) {
          if (_t instanceof ValidationException) {
            final ValidationException e = (ValidationException)_t;
            int _plus = (lineIndex + 1);
            Collection<ValidationErrorItem> _errors = e.getErrors();
            this.errors.put(Integer.valueOf(_plus), _errors);
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
        int _size = errorsInThisLine.size();
        boolean _notEquals_1 = (_size != 0);
        if (_notEquals_1) {
          int _plus_1 = (lineIndex + 1);
          this.errors.put(Integer.valueOf(_plus_1), errorsInThisLine);
        }
        String _readLine = reader.readLine();
        curLine = _readLine;
        int _plus_2 = (lineIndex + 1);
        lineIndex = _plus_2;
      }
      boolean _notEquals_1 = (!Objects.equal(curLine, null));
      _while = _notEquals_1;
    }
    boolean _notEquals_1 = (!Objects.equal(this.precommitValidator, null));
    if (_notEquals_1) {
      final Procedure2<T,Long> _function = new Procedure2<T,Long>() {
          public void apply(final T it, final Long index) {
            final ArrayList<ValidationErrorItem> errorsInThisLine = CollectionLiterals.<ValidationErrorItem>newArrayList();
            final Procedure2<String,String> _function = new Procedure2<String,String>() {
                public void apply(final String key, final String message) {
                  ValidationErrorItem _validationErrorItem = new ValidationErrorItem(message, key);
                  errorsInThisLine.add(_validationErrorItem);
                }
              };
            CSVUploader.this.precommitValidator.apply(result, it, _function);
            int _size = errorsInThisLine.size();
            boolean _notEquals = (_size != 0);
            if (_notEquals) {
              int _intValue = index.intValue();
              int _plus = (_intValue + 1);
              CSVUploader.this.errors.put(Integer.valueOf(_plus), errorsInThisLine);
            }
          }
        };
      IterableExtensions2.<T>forEachWithIndex(result, _function);
    }
    int _size = this.errors.size();
    boolean _notEquals_2 = (_size != 0);
    if (_notEquals_2) {
      boolean _notEquals_3 = (!Objects.equal(this.failure, null));
      if (_notEquals_3) {
        this.failure.apply(this.errors);
      } else {
        Collection<Collection<ValidationErrorItem>> _values = this.errors.values();
        Iterable<ValidationErrorItem> _flatten = Iterables.<ValidationErrorItem>concat(_values);
        final Function1<ValidationErrorItem,Collection<String>> _function_1 = new Function1<ValidationErrorItem,Collection<String>>() {
            public Collection<String> apply(final ValidationErrorItem it) {
              Collection<String> _keys = it.getKeys();
              return _keys;
            }
          };
        Iterable<Collection<String>> _map = IterableExtensions.<ValidationErrorItem, Collection<String>>map(_flatten, _function_1);
        Iterable<String> _flatten_1 = Iterables.<String>concat(_map);
        Set<String> _set = IterableExtensions.<String>toSet(_flatten_1);
        final Function1<String,String> _function_2 = new Function1<String,String>() {
            public String apply(final String it) {
              String _title4Key = CSVUploader.this.csvMapper.getTitle4Key(it);
              return _title4Key;
            }
          };
        Map<String,String> keyTitleMap = IterableExtensions.<String, String>toInvertedMap(_set, _function_2);
        CSVValidationException _cSVValidationException = new CSVValidationException(keyTitleMap, this.errors);
        throw _cSVValidationException;
      }
    } else {
      boolean _notEquals_4 = (!Objects.equal(this.commitEach, null));
      if (_notEquals_4) {
        final Procedure2<T,Long> _function_3 = new Procedure2<T,Long>() {
            public void apply(final T it, final Long index) {
              try {
                CSVUploader.this.commitEach.apply(it);
              } catch (final Throwable _t) {
                if (_t instanceof ValidationException) {
                  final ValidationException e = (ValidationException)_t;
                  int _intValue = index.intValue();
                  int _plus = (_intValue + 1);
                  Collection<ValidationErrorItem> _errors = e.getErrors();
                  CSVUploader.this.errors.put(Integer.valueOf(_plus), _errors);
                } else {
                  throw Exceptions.sneakyThrow(_t);
                }
              }
            }
          };
        IterableExtensions2.<T>forEachWithIndex(result, _function_3);
        int _size_1 = this.errors.size();
        boolean _notEquals_5 = (_size_1 != 0);
        if (_notEquals_5) {
          boolean _notEquals_6 = (!Objects.equal(this.failure, null));
          if (_notEquals_6) {
            this.failure.apply(this.errors);
          } else {
            Collection<Collection<ValidationErrorItem>> _values_1 = this.errors.values();
            Iterable<ValidationErrorItem> _flatten_2 = Iterables.<ValidationErrorItem>concat(_values_1);
            final Function1<ValidationErrorItem,Collection<String>> _function_4 = new Function1<ValidationErrorItem,Collection<String>>() {
                public Collection<String> apply(final ValidationErrorItem it) {
                  Collection<String> _keys = it.getKeys();
                  return _keys;
                }
              };
            Iterable<Collection<String>> _map_1 = IterableExtensions.<ValidationErrorItem, Collection<String>>map(_flatten_2, _function_4);
            Iterable<String> _flatten_3 = Iterables.<String>concat(_map_1);
            Set<String> _set_1 = IterableExtensions.<String>toSet(_flatten_3);
            final Function1<String,String> _function_5 = new Function1<String,String>() {
                public String apply(final String it) {
                  String _title4Key = CSVUploader.this.csvMapper.getTitle4Key(it);
                  return _title4Key;
                }
              };
            Map<String,String> keyTitleMap_1 = IterableExtensions.<String, String>toInvertedMap(_set_1, _function_5);
            CSVValidationException _cSVValidationException_1 = new CSVValidationException(keyTitleMap_1, this.errors);
            throw _cSVValidationException_1;
          }
        }
      }
    }
    boolean _and = false;
    int _size_2 = this.errors.size();
    boolean _equals = (_size_2 == 0);
    if (!_equals) {
      _and = false;
    } else {
      boolean _notEquals_7 = (!Objects.equal(this.commitAll, null));
      _and = (_equals && _notEquals_7);
    }
    if (_and) {
      this.commitAll.apply(result);
    }
  }
}
