package edu.fudan.langlab.uidl.domain.code.server.service.web;

import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.domain.code.Code;
import edu.fudan.langlab.domain.code.CodeService;
import edu.fudan.langlab.domain.code.CodeType;
import edu.fudan.langlab.domain.code.proxy.CodeProxy;
import edu.fudan.langlab.uidl.domain.code.client.web.CodeManagementPresenterService;
import edu.fudan.langlab.uidl.domain.code.server.service.web.CodeMapper;
import edu.fudan.langlab.uidl.domain.code.shared.web.UICode;
import edu.fudan.langlab.uidl.domain.code.shared.web.UICodeCriteria;
import edu.fudan.langlab.uidl.domain.code.shared.web.UICodeType;
import edu.fudan.mylang.pf.IObjectFactory;
import java.util.Collection;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("edu.fudan.langlab.uidl.domain.code.client.web.CodeManagementPresenterService")
@Transactional
public class CodeManagementPresenterServiceImpl extends BaseService implements CodeManagementPresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private CodeMapper mapper;
  
  @Autowired
  private CodeService codeService;
  
  public Collection<UICode> filter(final UICodeCriteria uicriteria) throws SessionTimeOutException, ValidationException {
    List<UICode> _xblockexpression = null;
    {
      UICodeType _codeType = uicriteria.getCodeType();
      String _className = _codeType.getClassName();
      CodeType codeType = this.codeService.findCodeType(_className);
      Collection<Code> _allCodes = codeType.getAllCodes(this.entities);
      final Function1<Code,UICode> _function = new Function1<Code,UICode>() {
          public UICode apply(final Code it) {
            UICode _transform = CodeManagementPresenterServiceImpl.this.mapper.transform(it);
            return _transform;
          }
        };
      Iterable<UICode> _map = IterableExtensions.<Code, UICode>map(_allCodes, _function);
      List<UICode> _list = IterableExtensions.<UICode>toList(_map);
      _xblockexpression = (_list);
    }
    return _xblockexpression;
  }
  
  public void delete(final CodeProxy value) throws SessionTimeOutException, ValidationException {
    Code _resolved= null;
    if(value!=null) _resolved=(edu.fudan.langlab.domain.code.Code)com.uniquesoft.uidl.extensions.ModelObjects.resolve(value, entities);
    
    this.codeService.deleteCode( _resolved);
  }
}
