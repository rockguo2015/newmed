package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCWorkItemStatusAccessor;
import com.fudanmed.platform.core.domain.RCWorkItemTask;
import com.fudanmed.platform.core.domain.RCWorkItemTaskDAO;
import com.fudanmed.platform.core.domain.RCWorkItemTaskStatus;
import edu.fudan.mylang.pf.BaseDAOService;
import edu.fudan.mylang.pf.IGenericQuery;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.domain.RCWorkItemTaskDAO")
public class RCWorkItemTaskDAOImpl extends BaseDAOService<RCWorkItemTask> implements RCWorkItemTaskDAO {
  public Boolean workerIsBusy(final RCEmployee employee) {
    boolean _xblockexpression = false;
    {
      final RCWorkItemTaskStatus processingStatus = RCWorkItemStatusAccessor.getProcessing();
      IGenericQuery<Long> query=getObjectFactory().createGenericQuery(Long.class,"select count(worker) from com.fudanmed.platform.core.domain.impl.RCWorkItemTaskImpl as e left join  e.workers as worker   where ((e.Status = :processingStatus) and (worker = :employee)) and  e.active = 1      ").setParameter("processingStatus",processingStatus).setParameter("employee",employee);
      Long _uniqueResult = query.uniqueResult();
      boolean _notEquals = ((_uniqueResult).longValue() != 0);
      _xblockexpression = (_notEquals);
    }
    return Boolean.valueOf(_xblockexpression);
  }
}
