package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCSettlement;
import com.fudanmed.platform.core.domain.impl.RCSettlementCriteriaImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;

@QueryImplementation(implementBy = RCSettlementCriteriaImpl.class)
public interface RCSettlementCriteria extends IPagedCriteria<RCSettlement> {
}
