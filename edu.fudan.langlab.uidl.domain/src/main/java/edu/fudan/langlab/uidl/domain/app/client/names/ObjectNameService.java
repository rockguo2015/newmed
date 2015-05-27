package edu.fudan.langlab.uidl.domain.app.client.names;

import com.uniquesoft.gwt.shared.GWTNamedEntity;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIAppFunction;
import edu.fudan.langlab.uidl.domain.code.shared.web.UICodeType;
import java.util.Arrays;
import java.util.Date;

@SuppressWarnings("all")
public class ObjectNameService extends edu.fudan.langlab.common.client.names.ObjectNameService {
  protected String _internalGetId(final UICodeType o) {
    String _className = o.getClassName();
    return _className;
  }
  
  protected String _internalGetName(final UICodeType o) {
    String _name = o.getName();
    return _name;
  }
  
  protected String _internalGetId(final UIAppFunction function) {
    Long _id = function.getId();
    String _string = _id.toString();
    return _string;
  }
  
  protected String _internalGetName(final UIAppFunction function) {
    String _name = function.getName();
    return _name;
  }
  
  public String internalGetId(final Object o) {
    if (o instanceof GWTNamedEntity) {
      return _internalGetId((GWTNamedEntity)o);
    } else if (o instanceof UIAppFunction) {
      return _internalGetId((UIAppFunction)o);
    } else if (o instanceof UICodeType) {
      return _internalGetId((UICodeType)o);
    } else if (o instanceof Boolean) {
      return _internalGetId((Boolean)o);
    } else if (o instanceof Enum) {
      return _internalGetId((Enum)o);
    } else if (o != null) {
      return _internalGetId(o);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(o).toString());
    }
  }
  
  public String internalGetName(final Object o) {
    if (o instanceof GWTNamedEntity) {
      return _internalGetName((GWTNamedEntity)o);
    } else if (o instanceof UIAppFunction) {
      return _internalGetName((UIAppFunction)o);
    } else if (o instanceof UICodeType) {
      return _internalGetName((UICodeType)o);
    } else if (o instanceof Boolean) {
      return _internalGetName((Boolean)o);
    } else if (o instanceof Enum) {
      return _internalGetName((Enum)o);
    } else if (o instanceof Date) {
      return _internalGetName((Date)o);
    } else if (o != null) {
      return _internalGetName(o);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(o).toString());
    }
  }
}
