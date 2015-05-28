package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCProductSpecificationCriteria;
import com.fudanmed.platform.core.web.client.warehouse.AllProductSpecificationContentProviderService;
import com.fudanmed.platform.core.web.server.service.warehouse.ProductSpecificationMapper;
import com.fudanmed.platform.core.web.shared.warehouse.AllProductSpecificationContentProviderCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.google.common.base.Function;
import com.uniquesoft.gwt.server.common.pager.PagedQueries;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.uidl.contentprovider.BaseContentProviderService;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.warehouse.AllProductSpecificationContentProviderService")
@Transactional
public class AllProductSpecificationContentProviderServiceImpl extends BaseContentProviderService implements AllProductSpecificationContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProductSpecificationMapper mapper;
  
  public Collection<UIProductSpecification> load(final AllProductSpecificationContentProviderCriteria filter) {
    return doLoad(filter);
  }
  
  public Collection<UIProductSpecification> doLoad(final AllProductSpecificationContentProviderCriteria filter) {
    RCProductSpecificationCriteria _createPagedCriteria = PagedQueries.createPagedCriteria(filter, RCProductSpecificationCriteria.class, this.entities);
    final Procedure1<RCProductSpecificationCriteria> _function = new Procedure1<RCProductSpecificationCriteria>() {
        public void apply(final RCProductSpecificationCriteria it) {
          String _name = filter.getName();
          it.setInfo(_name);
        }
      };
    RCProductSpecificationCriteria _doubleArrow = ObjectExtensions.<RCProductSpecificationCriteria>operator_doubleArrow(_createPagedCriteria, _function);
    final Function1<RCProductSpecification,UIProductSpecification> _function_1 = new Function1<RCProductSpecification,UIProductSpecification>() {
        public UIProductSpecification apply(final RCProductSpecification it) {
          UIProductSpecification _transform = AllProductSpecificationContentProviderServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    IPagedResult<UIProductSpecification> _listAndTransform = PagedQueries.<UIProductSpecification, RCProductSpecification>listAndTransform(_doubleArrow, new Function<RCProductSpecification,UIProductSpecification>() {
        public UIProductSpecification apply(RCProductSpecification input) {
          return _function_1.apply(input);
        }
    });
    return _listAndTransform;
  }
}
