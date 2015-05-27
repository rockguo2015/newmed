package com.fudanmed.platform.core.device.pm.impl;

import com.fudanmed.platform.core.device.pm.impl.RCDevicePMTypeImpl;
import edu.fudan.langlab.domain.code.CodeType;
import edu.fudan.langlab.domain.code.CodeTypeProvider;
import edu.fudan.mylang.pf.BaseService;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.device.pm.RCDevicePMCodeTypeProvider")
public class RCDevicePMCodeTypeProviderImpl extends BaseService implements CodeTypeProvider {
  public Collection<CodeType> getCodeTypes() {
    CodeType _codeType = new CodeType("\u7EF4\u4FEE\u7C7B\u522B", RCDevicePMTypeImpl.class);
    ArrayList<CodeType> _newArrayList = CollectionLiterals.<CodeType>newArrayList(_codeType);
    return _newArrayList;
  }
}
