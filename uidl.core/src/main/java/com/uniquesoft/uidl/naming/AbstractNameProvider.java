package com.uniquesoft.uidl.naming;

import com.uniquesoft.uidl.naming.INameProvider;

@SuppressWarnings("all")
public abstract class AbstractNameProvider implements INameProvider {
  public String getName(final Object entity) {
    String _doGetName = this.doGetName(entity);
    return _doGetName;
  }
  
  protected String _doGetName(final Object entity) {
    Class<? extends Object> _class = entity.getClass();
    String _name = _class.getName();
    String _plus = (_name + "[");
    int _hashCode = entity.hashCode();
    String _string = Integer.valueOf(_hashCode).toString();
    String _plus_1 = (_plus + _string);
    String _plus_2 = (_plus_1 + "]");
    return _plus_2;
  }
  
  public String doGetName(final Object entity) {
    {
      return _doGetName(entity);
    }
  }
}
