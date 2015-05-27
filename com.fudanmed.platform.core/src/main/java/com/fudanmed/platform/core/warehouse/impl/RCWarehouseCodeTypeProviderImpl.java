package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.warehouse.impl.RCInStoreTypeImpl;
import com.fudanmed.platform.core.warehouse.impl.RCProduceSpecificationUnitImpl;
import edu.fudan.langlab.domain.code.CodeType;
import edu.fudan.langlab.domain.code.CodeTypeProvider;
import edu.fudan.mylang.pf.BaseService;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.warehouse.RCWarehouseCodeTypeProvider")
public class RCWarehouseCodeTypeProviderImpl extends BaseService implements CodeTypeProvider {
  public Collection<CodeType> getCodeTypes() {
    CodeType _codeType = new CodeType("\u8BA1\u91CF\u5355\u4F4D", RCProduceSpecificationUnitImpl.class);
    CodeType _codeType_1 = new CodeType("\u5165\u5E93\u7C7B\u578B", RCInStoreTypeImpl.class);
    ArrayList<CodeType> _newArrayList = CollectionLiterals.<CodeType>newArrayList(_codeType, _codeType_1);
    return _newArrayList;
  }
}
