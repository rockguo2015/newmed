package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLDeliverPatientCheckCategory;
import com.fudanmed.platform.core.deliver.DLDeliverPatientCheckCategoryDAO;
import com.fudanmed.platform.core.web.client.deliver.DeliverPatientCheckCategoryListPresenterService;
import com.fudanmed.platform.core.web.server.service.deliver.DeliverPatientCheckCategoryMapper;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverPatientCheckCategory;
import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.deliver.DeliverPatientCheckCategoryListPresenterService")
@Transactional
public class DeliverPatientCheckCategoryListPresenterServiceImpl extends BaseService implements DeliverPatientCheckCategoryListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private DeliverPatientCheckCategoryMapper mapper;
  
  @Autowired
  private DLDeliverPatientCheckCategoryDAO dao;
  
  public Collection<UIDeliverPatientCheckCategory> loadDeliverPatientCheckCategoryList() throws SessionTimeOutException, ValidationException {
    Collection<DLDeliverPatientCheckCategory> _findAll = this.dao.findAll();
    final Function1<DLDeliverPatientCheckCategory,UIDeliverPatientCheckCategory> _function = new Function1<DLDeliverPatientCheckCategory,UIDeliverPatientCheckCategory>() {
        public UIDeliverPatientCheckCategory apply(final DLDeliverPatientCheckCategory it) {
          UIDeliverPatientCheckCategory _transform = DeliverPatientCheckCategoryListPresenterServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIDeliverPatientCheckCategory> _map = IterableExtensions.<DLDeliverPatientCheckCategory, UIDeliverPatientCheckCategory>map(_findAll, _function);
    List<UIDeliverPatientCheckCategory> _list = IterableExtensions.<UIDeliverPatientCheckCategory>toList(_map);
    return _list;
  }
}
