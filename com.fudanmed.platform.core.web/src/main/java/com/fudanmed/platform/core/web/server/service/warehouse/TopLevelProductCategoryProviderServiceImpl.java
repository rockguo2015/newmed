package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductCategory;
import com.fudanmed.platform.core.warehouse.RCProductCategoryDAO;
import com.fudanmed.platform.core.warehouse.proxy.RCProductCategoryProxy;
import com.fudanmed.platform.core.web.client.warehouse.TopLevelProductCategoryProviderService;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import com.uniquesoft.uidl.contentprovider.BaseContentProviderService;
import com.uniquesoft.uidl.transform.IConvertService;
import com.uniquesoft.uidl.transform.ProxyContentProviderMapper;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("com.fudanmed.platform.core.web.client.warehouse.TopLevelProductCategoryProviderService")
@Transactional
public class TopLevelProductCategoryProviderServiceImpl extends BaseContentProviderService implements TopLevelProductCategoryProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private ProxyContentProviderMapper<RCProductCategory> mapper;
  
  @Autowired
  private RCProductCategoryDAO dao;
  
  public Collection<RCProductCategoryProxy> load() {
    return com.google.common.collect.Lists
    		.newArrayList(com.google.common.collect.Iterables.transform(
    				doLoad(),
    				new com.google.common.base.Function<RCProductCategory, RCProductCategoryProxy>() {
    					@Override
    					public  RCProductCategoryProxy apply( RCProductCategory input) {
    						return input.toProxy();
    					}
    				}));
    
  }
  
  public Collection<RCProductCategory> doLoad() {
    Iterable<RCProductCategory> _allToplevelCategories = this.dao.getAllToplevelCategories();
    Collection<RCProductCategory> _unlazy = IterableExtensions2.<RCProductCategory>unlazy(_allToplevelCategories);
    return _unlazy;
  }
}
