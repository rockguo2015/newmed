package edu.fudan.langlab.uidl.domain.code.server.service.web;

import com.uniquesoft.uidl.contentprovider.BaseContentProviderService;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.langlab.domain.code.CodeService;
import edu.fudan.langlab.domain.code.CodeType;
import edu.fudan.langlab.uidl.domain.code.client.web.UICodeTypeContentProviderService;
import edu.fudan.langlab.uidl.domain.code.shared.web.UICodeType;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("edu.fudan.langlab.uidl.domain.code.client.web.UICodeTypeContentProviderService")
@Transactional
public class UICodeTypeContentProviderServiceImpl extends BaseContentProviderService implements UICodeTypeContentProviderService {
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private CodeService codeService;
  
  public Collection<UICodeType> load() {
    return doLoad();
  }
  
  public Collection<UICodeType> doLoad() {
    Collection<CodeType> _allCodeTypes = this.codeService.getAllCodeTypes();
    final Function1<CodeType,UICodeType> _function = new Function1<CodeType,UICodeType>() {
        public UICodeType apply(final CodeType codeType) {
          UICodeType _uICodeType = new UICodeType();
          final Procedure1<UICodeType> _function = new Procedure1<UICodeType>() {
              public void apply(final UICodeType it) {
                String _name = codeType.getName();
                it.setName(_name);
                String _className = codeType.getClassName();
                it.setClassName(_className);
              }
            };
          UICodeType _doubleArrow = ObjectExtensions.<UICodeType>operator_doubleArrow(_uICodeType, _function);
          return _doubleArrow;
        }
      };
    Iterable<UICodeType> _map = IterableExtensions.<CodeType, UICodeType>map(_allCodeTypes, _function);
    List<UICodeType> _list = IterableExtensions.<UICodeType>toList(_map);
    return _list;
  }
}
