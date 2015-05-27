package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.impl.DLDeliverEmergencyImpl;
import com.fudanmed.platform.core.deliver.impl.DLPatientDeliverMethodImpl;
import edu.fudan.langlab.domain.code.CodeType;
import edu.fudan.langlab.domain.code.CodeTypeProvider;
import edu.fudan.mylang.pf.BaseService;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.deliver.RCDeliverCodeTypeProvider")
public class RCDeliverCodeTypeProviderImpl extends BaseService implements CodeTypeProvider {
  public Collection<CodeType> getCodeTypes() {
    CodeType _codeType = new CodeType("\u8FD0\u9001\u7D27\u6025\u5EA6", DLDeliverEmergencyImpl.class);
    CodeType _codeType_1 = new CodeType("\u8FD0\u9001\u65B9\u5F0F", DLPatientDeliverMethodImpl.class);
    ArrayList<CodeType> _newArrayList = CollectionLiterals.<CodeType>newArrayList(_codeType, _codeType_1);
    return _newArrayList;
  }
}
