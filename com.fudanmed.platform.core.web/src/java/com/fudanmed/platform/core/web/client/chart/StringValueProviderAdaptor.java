package com.fudanmed.platform.core.web.client.chart;

import com.sencha.gxt.core.client.ValueProvider;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

@SuppressWarnings("all")
public class StringValueProviderAdaptor<T extends Object, V extends Object> implements ValueProvider<T,String> {
  private IObjectFieldAccessor<T,V> accessor;
  
  private String path;
  
  private Function1<? super V,? extends String> nameProvider;
  
  public StringValueProviderAdaptor(final IObjectFieldAccessor<T,V> accessor, final String path, final Function1<? super V,? extends String> nameProvider) {
    this.path = path;
    this.accessor = accessor;
    this.nameProvider = nameProvider;
  }
  
  public String getPath() {
    return this.path;
  }
  
  public String getValue(final T object) {
    V _value = this.accessor.getValue(object);
    String _apply = this.nameProvider.apply(_value);
    return _apply;
  }
  
  public void setValue(final T object, final String value) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException();
    throw _unsupportedOperationException;
  }
}
