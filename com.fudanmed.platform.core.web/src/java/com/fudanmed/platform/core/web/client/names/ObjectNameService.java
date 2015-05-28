package com.fudanmed.platform.core.web.client.names;

import com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy;
import com.fudanmed.platform.core.web.shared.device.UIDevice;
import com.fudanmed.platform.core.web.shared.project.UIFaultType;
import com.fudanmed.platform.core.web.shared.project.UIWorker;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecificationSummary;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorage;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummary;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIAppFunction;
import edu.fudan.langlab.uidl.domain.code.shared.web.UICodeType;
import java.util.Arrays;
import java.util.Date;

@SuppressWarnings("all")
public class ObjectNameService extends edu.fudan.langlab.uidl.domain.app.client.names.ObjectNameService {
  protected String _internalGetId(final UIWorker o) {
    Long _id = o.getId();
    String _string = _id.toString();
    return _string;
  }
  
  protected String _internalGetName(final UIWorker o) {
    String _name = o.getName();
    return _name;
  }
  
  protected String _internalGetId(final UIFaultType o) {
    Long _id = o.getId();
    String _string = _id.toString();
    return _string;
  }
  
  protected String _internalGetName(final UIFaultType o) {
    String _name = o.getName();
    return _name;
  }
  
  protected String _internalGetId(final UIProductWarehouseStorage o) {
    Long _id = o.getId();
    String _string = _id.toString();
    return _string;
  }
  
  protected String _internalGetName(final UIProductWarehouseStorage o) {
    String _name = o.getName();
    String _plus = (_name + " \u6761\u7801\u7F16\u53F7:");
    String _productSpecsSid = o.getProductSpecsSid();
    String _plus_1 = (_plus + _productSpecsSid);
    String _plus_2 = (_plus_1 + " \u89C4\u683C\u578B\u53F7\uFF1A");
    String _typeDesc = o.getTypeDesc();
    String _plus_3 = (_plus_2 + _typeDesc);
    String _plus_4 = (_plus_3 + " \u751F\u4EA7\u6279\u53F7\uFF1A");
    String _sid = o.getSid();
    String _plus_5 = (_plus_4 + _sid);
    return _plus_5;
  }
  
  protected String _internalGetId(final UIProductSpecificationSummary o) {
    RCProductSpecificationProxy _productSpec = o.getProductSpec();
    Long _id = _productSpec.getId();
    String _string = _id.toString();
    return _string;
  }
  
  protected String _internalGetName(final UIProductSpecificationSummary o) {
    RCProductSpecificationProxy _productSpec = o.getProductSpec();
    String _name = _productSpec.getName();
    String _plus = (_name + " \u6761\u7801\u7F16\u53F7:");
    String _sid = o.getSid();
    String _plus_1 = (_plus + _sid);
    String _plus_2 = (_plus_1 + " \u89C4\u683C\u578B\u53F7\uFF1A");
    String _typeDesc = o.getTypeDesc();
    String _plus_3 = (_plus_2 + _typeDesc);
    return _plus_3;
  }
  
  protected String _internalGetId(final UIProductWarehouseStorageSummary o) {
    Long _id = o.getId();
    String _string = _id.toString();
    return _string;
  }
  
  protected String _internalGetName(final UIProductWarehouseStorageSummary o) {
    String _name = o.getName();
    String _plus = (_name + " \u6761\u7801\u7F16\u53F7:");
    String _productSpecsSid = o.getProductSpecsSid();
    String _plus_1 = (_plus + _productSpecsSid);
    String _plus_2 = (_plus_1 + " \u89C4\u683C\u578B\u53F7\uFF1A");
    String _typeDesc = o.getTypeDesc();
    String _plus_3 = (_plus_2 + _typeDesc);
    return _plus_3;
  }
  
  protected String _internalGetId(final UIProductSpecification o) {
    Long _id = o.getId();
    String _string = _id.toString();
    return _string;
  }
  
  protected String _internalGetName(final UIProductSpecification o) {
    String _name = o.getName();
    String _plus = (_name + "(");
    String _materialId = o.getMaterialId();
    String _plus_1 = (_plus + _materialId);
    String _plus_2 = (_plus_1 + ")");
    return _plus_2;
  }
  
  protected String _internalGetId(final UIDevice o) {
    Long _id = o.getId();
    String _string = _id.toString();
    return _string;
  }
  
  protected String _internalGetName(final UIDevice o) {
    String _sid = o.getSid();
    String _plus = (_sid + "\u540D\u79F0:");
    String _name = o.getName();
    String _plus_1 = (_plus + _name);
    return _plus_1;
  }
  
  protected String _internalGetId(final GWTNamedEntity o) {
    Long _id = o.getId();
    String _string = _id.toString();
    return _string;
  }
  
  protected String _internalGetName(final GWTNamedEntity o) {
    String _name = o.getName();
    return _name;
  }
  
  public String internalGetId(final Object o) {
    if (o instanceof UIDevice) {
      return _internalGetId((UIDevice)o);
    } else if (o instanceof UIFaultType) {
      return _internalGetId((UIFaultType)o);
    } else if (o instanceof UIWorker) {
      return _internalGetId((UIWorker)o);
    } else if (o instanceof UIProductSpecification) {
      return _internalGetId((UIProductSpecification)o);
    } else if (o instanceof UIProductWarehouseStorage) {
      return _internalGetId((UIProductWarehouseStorage)o);
    } else if (o instanceof UIProductWarehouseStorageSummary) {
      return _internalGetId((UIProductWarehouseStorageSummary)o);
    } else if (o instanceof GWTNamedEntity) {
      return _internalGetId((GWTNamedEntity)o);
    } else if (o instanceof UIAppFunction) {
      return _internalGetId((UIAppFunction)o);
    } else if (o instanceof UIProductSpecificationSummary) {
      return _internalGetId((UIProductSpecificationSummary)o);
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
    if (o instanceof UIDevice) {
      return _internalGetName((UIDevice)o);
    } else if (o instanceof UIFaultType) {
      return _internalGetName((UIFaultType)o);
    } else if (o instanceof UIWorker) {
      return _internalGetName((UIWorker)o);
    } else if (o instanceof UIProductSpecification) {
      return _internalGetName((UIProductSpecification)o);
    } else if (o instanceof UIProductWarehouseStorage) {
      return _internalGetName((UIProductWarehouseStorage)o);
    } else if (o instanceof UIProductWarehouseStorageSummary) {
      return _internalGetName((UIProductWarehouseStorageSummary)o);
    } else if (o instanceof GWTNamedEntity) {
      return _internalGetName((GWTNamedEntity)o);
    } else if (o instanceof UIAppFunction) {
      return _internalGetName((UIAppFunction)o);
    } else if (o instanceof UIProductSpecificationSummary) {
      return _internalGetName((UIProductSpecificationSummary)o);
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
