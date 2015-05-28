package com.fudanmed.platform.core.web.server.service.deliver;

import com.fudanmed.platform.core.deliver.DLDeliverMaterialCategory;
import com.fudanmed.platform.core.web.client.deliver.DeliverMaterialCategoryListPresenterService;
import com.fudanmed.platform.core.web.server.service.deliver.DeliverMaterialCategoryMapper;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverMaterialCategory;
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

@Service("com.fudanmed.platform.core.web.client.deliver.DeliverMaterialCategoryListPresenterService")
@Transactional
public class DeliverMaterialCategoryListPresenterServiceImpl extends BaseService implements DeliverMaterialCategoryListPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private DeliverMaterialCategoryMapper mapper;
  
  public Collection<UIDeliverMaterialCategory> loadDeliverMaterialCategoryList() throws SessionTimeOutException, ValidationException {
    Collection<DLDeliverMaterialCategory> _all = this.entities.<DLDeliverMaterialCategory>all(DLDeliverMaterialCategory.class);
    final Function1<DLDeliverMaterialCategory,UIDeliverMaterialCategory> _function = new Function1<DLDeliverMaterialCategory,UIDeliverMaterialCategory>() {
        public UIDeliverMaterialCategory apply(final DLDeliverMaterialCategory it) {
          UIDeliverMaterialCategory _transform = DeliverMaterialCategoryListPresenterServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIDeliverMaterialCategory> _map = IterableExtensions.<DLDeliverMaterialCategory, UIDeliverMaterialCategory>map(_all, _function);
    List<UIDeliverMaterialCategory> _list = IterableExtensions.<UIDeliverMaterialCategory>toList(_map);
    return _list;
  }
}
