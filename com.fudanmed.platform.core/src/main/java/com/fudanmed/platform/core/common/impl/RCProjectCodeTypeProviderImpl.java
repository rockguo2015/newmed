package com.fudanmed.platform.core.common.impl;

import com.fudanmed.platform.core.common.impl.RCCredentialTypeImpl;
import com.fudanmed.platform.core.common.impl.RCFaultEmergencyLevelImpl;
import com.fudanmed.platform.core.common.impl.RCFaultLevelImpl;
import com.fudanmed.platform.core.common.impl.RCFaultReportSourceImpl;
import com.fudanmed.platform.core.common.impl.RCMaterialBrandImpl;
import com.fudanmed.platform.core.common.impl.RCOutStockTypeImpl;
import com.fudanmed.platform.core.common.impl.RCWorkTypeImpl;
import edu.fudan.langlab.domain.code.CodeType;
import edu.fudan.langlab.domain.code.CodeTypeProvider;
import edu.fudan.mylang.pf.BaseService;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.common.RCProjectCodeTypeProvider")
public class RCProjectCodeTypeProviderImpl extends BaseService implements CodeTypeProvider {
  public Collection<CodeType> getCodeTypes() {
    CodeType _codeType = new CodeType("\u6545\u969C\u98CE\u9669\u7B49\u7EA7", RCFaultLevelImpl.class);
    CodeType _codeType_1 = new CodeType("\u6545\u969C\u62A5\u4FEE\u6765\u6E90", RCFaultReportSourceImpl.class);
    CodeType _codeType_2 = new CodeType("\u6545\u969C\u7D27\u6025\u5EA6", RCFaultEmergencyLevelImpl.class);
    CodeType _codeType_3 = new CodeType("\u5DE5\u79CD", RCWorkTypeImpl.class);
    CodeType _codeType_4 = new CodeType("\u51FA\u5E93\u7C7B\u578B", RCOutStockTypeImpl.class);
    CodeType _codeType_5 = new CodeType("\u8BC1\u4E66\u7C7B\u522B", RCCredentialTypeImpl.class);
    CodeType _codeType_6 = new CodeType("\u6750\u6599\u54C1\u724C", RCMaterialBrandImpl.class);
    ArrayList<CodeType> _newArrayList = CollectionLiterals.<CodeType>newArrayList(_codeType, _codeType_1, _codeType_2, _codeType_3, _codeType_4, _codeType_5, _codeType_6);
    return _newArrayList;
  }
}
