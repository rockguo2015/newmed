package com.fudanmed.platform.core.web.server.service.common;

import com.fudanmed.platform.core.web.client.common.ServerSideTimeService;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.common.ServerSideTimeService")
@Transactional
public class ServerSideTimeServiceImpl extends BaseService implements ServerSideTimeService {
  @Autowired
  private IObjectFactory entities;
  
  public Date getTime() throws SessionTimeOutException, ValidationException {
    Date _date = new Date();
    return _date;
  }
}
