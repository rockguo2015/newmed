package com.fudanmed.platform.core.web.client.chart;

import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ListStore;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class PercentLabelProvider<T extends Object> implements ValueProvider<T,String> {
  private ListStore<T> store;
  
  private ValueProvider<T,String> labelProvider;
  
  private ValueProvider<T,? extends Number> valueProvider;
  
  public PercentLabelProvider(final ListStore<T> store, final ValueProvider<T,String> labelProvider, final ValueProvider<T,? extends Number> valueProvider) {
    this.store = store;
    this.labelProvider = labelProvider;
    this.valueProvider = valueProvider;
  }
  
  public String getPath() {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-generated function stub");
    throw _unsupportedOperationException;
  }
  
  public String getValue(final T value) {
    String _xblockexpression = null;
    {
      List<T> _all = this.store.getAll();
      final Function1<T,Number> _function = new Function1<T,Number>() {
          public Number apply(final T it) {
            Number _value = PercentLabelProvider.this.valueProvider.getValue(it);
            return _value;
          }
        };
      List<Number> _map = ListExtensions.<T, Number>map(_all, _function);
      final Function2<Number,Number,Double> _function_1 = new Function2<Number,Number,Double>() {
          public Double apply(final Number n1, final Number n2) {
            double _doubleValue = n1.doubleValue();
            double _doubleValue_1 = n2.doubleValue();
            double _plus = (_doubleValue + _doubleValue_1);
            return Double.valueOf(_plus);
          }
        };
      Number _reduce = IterableExtensions.<Number>reduce(_map, _function_1);
      final double totalScore = _reduce.doubleValue();
      int _xifexpression = (int) 0;
      boolean _equals = (totalScore == 0d);
      if (_equals) {
        _xifexpression = 0;
      } else {
        Number _value = this.valueProvider.getValue(value);
        double _doubleValue = _value.doubleValue();
        double _divide = (_doubleValue / totalScore);
        double _multiply = (_divide * 100);
        double _plus = (_multiply + 0.5);
        int _intValue = Double.valueOf(_plus).intValue();
        _xifexpression = _intValue;
      }
      final int p = _xifexpression;
      String _value_1 = this.labelProvider.getValue(value);
      String _plus_1 = (_value_1 + "[");
      Number _value_2 = this.valueProvider.getValue(value);
      String _string = _value_2.toString();
      String _plus_2 = (_plus_1 + _string);
      String _plus_3 = (_plus_2 + "/");
      String _string_1 = Integer.valueOf(p).toString();
      String _plus_4 = (_plus_3 + _string_1);
      String _plus_5 = (_plus_4 + "%]");
      _xblockexpression = (_plus_5);
    }
    return _xblockexpression;
  }
  
  public void setValue(final T object, final String value) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-generated function stub");
    throw _unsupportedOperationException;
  }
}
