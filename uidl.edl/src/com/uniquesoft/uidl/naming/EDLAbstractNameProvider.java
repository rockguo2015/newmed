package com.uniquesoft.uidl.naming;

import com.uniquesoft.uidl.naming.INameProvider;
import edu.fudan.mylang.pf.IModelObject;
import edu.fudan.mylang.pf.INamedModelObject;
import java.util.Arrays;

@SuppressWarnings("all")
public abstract class EDLAbstractNameProvider implements INameProvider {
  public String getName(final Object entity) {
    String _doGetName = this.doGetName(entity);
    return _doGetName;
  }
  
  protected String _doGetName(final IModelObject entity) {
    String _xifexpression = null;
    if ((entity instanceof INamedModelObject)) {
      String _entityName = ((INamedModelObject) entity).getEntityName();
      _xifexpression = _entityName;
    } else {
      Class<? extends Object> _class = entity.getClass();
      String _name = _class.getName();
      String _plus = (_name + "[");
      Long _id = entity.getId();
      String _string = _id.toString();
      String _plus_1 = (_plus + _string);
      String _plus_2 = (_plus_1 + "]");
      _xifexpression = _plus_2;
    }
    return _xifexpression;
  }
  
  protected String _doGetName(final Object entity) {
    String _string = entity==null?(String)null:entity.toString();
    return _string;
  }
  
  public String doGetName(final Object entity) {
    if (entity instanceof IModelObject) {
      return _doGetName((IModelObject)entity);
    } else if (entity != null) {
      return _doGetName(entity);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(entity).toString());
    }
  }
}
