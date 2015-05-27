package com.fudanmed.platform.core.device.impl;

import com.fudanmed.platform.core.device.impl.RCAcquireTypeImpl;
import com.fudanmed.platform.core.device.impl.RCDeviceIndicatorImpl;
import com.fudanmed.platform.core.device.impl.RCDeviceUsageTypeImpl;
import edu.fudan.langlab.domain.code.CodeType;
import edu.fudan.langlab.domain.code.CodeTypeProvider;
import edu.fudan.mylang.pf.BaseService;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.device.RCDeviceCodeTypeProvider")
public class RCDeviceCodeTypeProviderImpl extends BaseService implements CodeTypeProvider {
  public Collection<CodeType> getCodeTypes() {
    CodeType _codeType = new CodeType("\u8BBE\u5907\u6807\u8BC6", RCDeviceIndicatorImpl.class);
    CodeType _codeType_1 = new CodeType("\u4F7F\u7528\u72B6\u51B5", RCDeviceUsageTypeImpl.class);
    CodeType _codeType_2 = new CodeType("\u589E\u7F6E\u65B9\u5F0F", RCAcquireTypeImpl.class);
    ArrayList<CodeType> _newArrayList = CollectionLiterals.<CodeType>newArrayList(_codeType, _codeType_1, _codeType_2);
    return _newArrayList;
  }
}
