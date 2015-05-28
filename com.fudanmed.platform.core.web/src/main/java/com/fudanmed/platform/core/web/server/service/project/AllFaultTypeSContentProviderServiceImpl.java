package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.domain.RCFaultType;
import com.fudanmed.platform.core.domain.RCFaultTypeContentProviderCriteria;
import com.fudanmed.platform.core.web.client.project.AllFaultTypeSContentProviderService;
import com.fudanmed.platform.core.web.server.service.project.FaultTypeMapper;
import com.fudanmed.platform.core.web.shared.project.AllFaultTypeSContentProviderCriteria;
import com.fudanmed.platform.core.web.shared.project.UIFaultType;
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

@Service("com.fudanmed.platform.core.web.client.project.AllFaultTypeSContentProviderService")
@Transactional
public class AllFaultTypeSContentProviderServiceImpl extends BaseContentProviderService implements AllFaultTypeSContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private FaultTypeMapper mapper;
  
  public Collection<UIFaultType> load(final AllFaultTypeSContentProviderCriteria filter) {
    return doLoad(filter);
  }
  
  public Collection<UIFaultType> doLoad(final AllFaultTypeSContentProviderCriteria filter) {
    RCFaultTypeContentProviderCriteria _createPagedCriteria = PagedQueries.createPagedCriteria(filter, RCFaultTypeContentProviderCriteria.class, this.entities);
    final Procedure1<RCFaultTypeContentProviderCriteria> _function = new Procedure1<RCFaultTypeContentProviderCriteria>() {
        public void apply(final RCFaultTypeContentProviderCriteria it) {
          String _name = filter.getName();
          it.setName(_name);
        }
      };
    RCFaultTypeContentProviderCriteria _doubleArrow = ObjectExtensions.<RCFaultTypeContentProviderCriteria>operator_doubleArrow(_createPagedCriteria, _function);
    final Function1<RCFaultType,UIFaultType> _function_1 = new Function1<RCFaultType,UIFaultType>() {
        public UIFaultType apply(final RCFaultType it) {
          UIFaultType _transform = AllFaultTypeSContentProviderServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    IPagedResult<UIFaultType> _listAndTransform = PagedQueries.<UIFaultType, RCFaultType>listAndTransform(_doubleArrow, new Function<RCFaultType,UIFaultType>() {
        public UIFaultType apply(RCFaultType input) {
          return _function_1.apply(input);
        }
    });
    return _listAndTransform;
  }
}
