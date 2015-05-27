package com.fudanmed.platform.core.entityextension;

import com.fudanmed.platform.core.entityextension.RCCustomizableType;
import com.fudanmed.platform.core.entityextension.impl.RCCustomizableTypeCriteriaImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;

@QueryImplementation(implementBy = RCCustomizableTypeCriteriaImpl.class)
public interface RCCustomizableTypeCriteria extends IPagedCriteria<RCCustomizableType> {
}
