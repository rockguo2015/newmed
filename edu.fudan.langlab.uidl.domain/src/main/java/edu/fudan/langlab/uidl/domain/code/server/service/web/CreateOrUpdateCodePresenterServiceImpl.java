package edu.fudan.langlab.uidl.domain.code.server.service.web;

import com.uniquesoft.gwt.server.service.common.BaseService;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import com.uniquesoft.uidl.transform.IConvertService;
import edu.fudan.langlab.domain.code.Code;
import edu.fudan.langlab.domain.code.CodeService;
import edu.fudan.langlab.domain.code.CodeType;
import edu.fudan.langlab.domain.code.events.CodeEventsManager;
import edu.fudan.langlab.domain.code.proxy.CodeProxy;
import edu.fudan.langlab.uidl.domain.code.client.web.CreateOrUpdateCodePresenterService;
import edu.fudan.langlab.uidl.domain.code.server.service.web.CodeMapper;
import edu.fudan.langlab.uidl.domain.code.shared.web.UICode;
import edu.fudan.langlab.uidl.domain.code.shared.web.UICodeType;
import edu.fudan.mylang.pf.IObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("edu.fudan.langlab.uidl.domain.code.client.web.CreateOrUpdateCodePresenterService")
@Transactional
public class CreateOrUpdateCodePresenterServiceImpl extends BaseService implements CreateOrUpdateCodePresenterService {
  @Autowired
  private IObjectFactory entities;
  
  @Autowired
  private CodeMapper mapper;
  
  @Autowired
  private IConvertService convertService;
  
  @Autowired
  private CodeService codeService;
  
  @Autowired
  private CodeEventsManager eventsManager;
  
  public UICode loadValue(final CodeProxy pvalue) throws SessionTimeOutException, ValidationException {
    Code _resolved= null;
    if(pvalue!=null) _resolved=(edu.fudan.langlab.domain.code.Code)com.uniquesoft.uidl.extensions.ModelObjects.resolve(pvalue, entities);
    
    UICode _transform = this.mapper.transform( _resolved);
    return _transform;
  }
  
  public void updateValue(final UICode uivalue) throws SessionTimeOutException, ValidationException {
    Code _resolved= null;
    if(uivalue!=null) _resolved=(edu.fudan.langlab.domain.code.Code)com.uniquesoft.uidl.extensions.ModelObjects.resolve(uivalue, entities);
    
    this.mapper.transform(uivalue,  _resolved);
  }
  
  public void createValue(final UICodeType uiCodeType, final UICode uivalue) throws SessionTimeOutException, ValidationException {
    String _className = uiCodeType.getClassName();
    CodeType codeType = this.codeService.findCodeType(_className);
    Code _createCode = this.codeService.createCode(codeType);
    this.mapper.transform(uivalue, _createCode);
  }
}
