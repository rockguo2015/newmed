package com.fudanmed.platform.core.web.client.chart;

import com.sencha.gxt.core.client.ValueProvider;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

@SuppressWarnings("all")
public class ProvideWrapper<T extends Object, V extends Object> implements ValueProvider<T,V> {
  private Function1<? super T,? extends V> provider;
  
  public ProvideWrapper(final Function1<? super T,? extends V> provider) {
    this.provider = provider;
  }
  
  public String getPath() {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-generated function stub");
    throw _unsupportedOperationException;
  }
  
  public V getValue(final T object) {
    V _apply = this.provider.apply(object);
    return _apply;
  }
  
  public void setValue(final T object, final V value) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-generated function stub");
    throw _unsupportedOperationException;
  }
}
