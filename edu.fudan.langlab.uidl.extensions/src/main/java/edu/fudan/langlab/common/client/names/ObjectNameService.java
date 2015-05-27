package edu.fudan.langlab.common.client.names;

import com.google.common.base.Objects;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.name.IObjectNameProvider;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import java.util.Arrays;
import java.util.Date;

@SuppressWarnings("all")
public class ObjectNameService implements IObjectNameProvider {
  public String getId(final Object o) {
    boolean _equals = Objects.equal(o, null);
    if (_equals) {
      return null;
    } else {
      return this.internalGetId(o);
    }
  }
  
  public String getName(final Object o) {
    String _xifexpression = null;
    boolean _equals = Objects.equal(o, null);
    if (_equals) {
      return "";
    } else {
      String _xblockexpression = null;
      {
        String n = this.internalGetName(o);
        String _xifexpression_1 = null;
        boolean _equals_1 = Objects.equal(n, null);
        if (_equals_1) {
          _xifexpression_1 = "";
        } else {
          _xifexpression_1 = n;
        }
        _xblockexpression = (_xifexpression_1);
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  protected String _internalGetId(final Object o) {
    int _hashCode = o.hashCode();
    String _string = Integer.valueOf(_hashCode).toString();
    String _plus = ("_OBJ_ID_" + _string);
    return _plus;
  }
  
  protected String _internalGetId(final GWTNamedEntity o) {
    Long _id = o.getId();
    String _plus = ("_OBJ_ID_" + _id);
    return _plus;
  }
  
  protected String _internalGetId(final Boolean o) {
    String _string = o.toString();
    String _plus = ("_OBJ_ID_" + _string);
    return _plus;
  }
  
  protected String _internalGetName(final Object o) {
    String _string = o.toString();
    return _string;
  }
  
  protected String _internalGetName(final GWTNamedEntity o) {
    String _name = o.getName();
    return _name;
  }
  
  protected String _internalGetId(final Enum enumObject) {
    String _name = enumObject.name();
    return _name;
  }
  
  protected String _internalGetName(final Enum enumObject) {
    String _string = enumObject.toString();
    return _string;
  }
  
  protected String _internalGetName(final Boolean o) {
    String _xifexpression = null;
    if ((o).booleanValue()) {
      _xifexpression = "\u662F";
    } else {
      _xifexpression = "\u5426";
    }
    return _xifexpression;
  }
  
  protected String _internalGetName(final Date value) {
    String _xifexpression = null;
    boolean _equals = Objects.equal(value, null);
    if (_equals) {
      return "";
    } else {
      DateTimeFormat _format = DateTimeFormat.getFormat("yy/MM/dd");
      String _format_1 = _format.format(value);
      _xifexpression = _format_1;
    }
    return _xifexpression;
  }
  
  public void initialize(final IPostInitializeAction postInitialize) {
    postInitialize.initializeFinished(null);
  }
  
  public String internalGetId(final Object o) {
    if (o instanceof GWTNamedEntity) {
      return _internalGetId((GWTNamedEntity)o);
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
