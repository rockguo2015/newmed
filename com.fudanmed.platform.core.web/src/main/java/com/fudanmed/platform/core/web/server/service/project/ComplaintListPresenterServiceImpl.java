package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCComplaint;
import com.fudanmed.platform.core.domain.RCRepairTask;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.web.client.project.ComplaintListPresenterService;
import com.fudanmed.platform.core.web.server.service.project.ComplaintMapper;
import com.fudanmed.platform.core.web.shared.project.UIComplaint;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.project.ComplaintListPresenterService")
@Transactional
public class ComplaintListPresenterServiceImpl extends BaseService implements ComplaintListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ComplaintMapper mapper;
  
  public Collection<UIComplaint> loadComplaintList(final RCRepairTaskProxy context) throws SessionTimeOutException, ValidationException {
    RCRepairTask _resolved= null;
    if(context!=null) _resolved=(com.fudanmed.platform.core.domain.RCRepairTask)com.uniquesoft.uidl.extensions.ModelObjects.resolve(context, entities);
    
    Collection<RCComplaint> _complaints =  _resolved.getComplaints();
    final Function1<RCComplaint,UIComplaint> _function = new Function1<RCComplaint,UIComplaint>() {
        public UIComplaint apply(final RCComplaint it) {
          UIComplaint _transform = ComplaintListPresenterServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIComplaint> _map = IterableExtensions.<RCComplaint, UIComplaint>map(_complaints, _function);
    Collection<UIComplaint> _unlazy = IterableExtensions2.<UIComplaint>unlazy(_map);
    return _unlazy;
  }
}
