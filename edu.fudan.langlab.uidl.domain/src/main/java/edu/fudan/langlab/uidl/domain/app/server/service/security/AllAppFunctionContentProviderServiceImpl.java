package edu.fudan.langlab.uidl.domain.app.server.service.security;

import com.uniquesoft.uidl.contentprovider.BaseContentProviderService;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.langlab.domain.security.AppFunction;
import edu.fudan.langlab.uidl.domain.app.client.security.AllAppFunctionContentProviderService;
import edu.fudan.langlab.uidl.domain.app.server.service.security.AppFunctionMapper;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIAppFunction;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("edu.fudan.langlab.uidl.domain.app.client.security.AllAppFunctionContentProviderService")
@Transactional
public class AllAppFunctionContentProviderServiceImpl extends BaseContentProviderService implements AllAppFunctionContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private AppFunctionMapper mapper;
  
  public Collection<UIAppFunction> load() {
    return doLoad();
  }
  
  public Collection<UIAppFunction> doLoad() {
    Collection<AppFunction> _all = this.entities.<AppFunction>all(AppFunction.class);
    final Function1<AppFunction,UIAppFunction> _function = new Function1<AppFunction,UIAppFunction>() {
        public UIAppFunction apply(final AppFunction it) {
          UIAppFunction _transform = AllAppFunctionContentProviderServiceImpl.this.mapper.transform(it);
          return _transform;
        }
      };
    Iterable<UIAppFunction> _map = IterableExtensions.<AppFunction, UIAppFunction>map(_all, _function);
    List<UIAppFunction> _list = IterableExtensions.<UIAppFunction>toList(_map);
    return _list;
  }
}
