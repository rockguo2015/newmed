package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition;
import edu.fudan.langlab.csv.server.mapper.ICSVMapper;
import edu.fudan.langlab.csv.server.mapper.IMapperFactory;
import edu.fudan.langlab.csv.shared.IValidationResultAcceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.organization.OnsitePositionCSVMapper")
public class OnsitePositionCSVMapper implements ICSVMapper<UIOnsitePosition> {
  public String toHeader() {
    java.util.ArrayList<String> headers = com.google.common.collect.Lists.newArrayList("位置代码","位置名称","联系电话","所属位置" );
    return org.eclipse.xtext.xbase.lib.IterableExtensions.join(headers,",");
  }
  
  public String getTitle4Key(final String key) {
    if("code".equals(key)) return "位置代码";
    if("name".equals(key)) return "位置名称";
    if("phone".equals(key)) return "联系电话";
    if("parentCode".equals(key)) return "所属位置";
    return "";
    
  }
  
  @Autowired
  private IMapperFactory mapperFactory;
  
  public String toString(final UIOnsitePosition data) {
    java.util.ArrayList<String> values = com.google.common.collect.Lists.newArrayList(
    mapperFactory.getStringMapper().toString(data.getCode()),
    mapperFactory.getStringMapper().toString(data.getName()),
    mapperFactory.getStringMapper().toString(data.getPhone()),
    mapperFactory.getStringMapper().toString(data.getParentCode())
    					);
    
    return org.eclipse.xtext.xbase.lib.IterableExtensions.join(values,",");
  }
  
  public UIOnsitePosition fromString(final String data, final IValidationResultAcceptor acceptor) {
    UIOnsitePosition result = new UIOnsitePosition();
    String[] values = data.split(",");
    for(int i=0;i<values.length;i++){
    	switch(i){
    		case 0:
    			result.setCode(
    				mapperFactory.getStringMapper().fromString(
    					values[i].trim(),new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("code",acceptor)
    				)
    			);
    			break;
    		case 1:
    			result.setName(
    				mapperFactory.getStringMapper().fromString(
    					values[i].trim(),new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("name",acceptor)
    				)
    			);
    			break;
    		case 2:
    			result.setPhone(
    				mapperFactory.getStringMapper().fromString(
    					values[i].trim(),new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("phone",acceptor)
    				)
    			);
    			break;
    		case 3:
    			result.setParentCode(
    				mapperFactory.getStringMapper().fromString(
    					values[i].trim(),new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("parentCode",acceptor)
    				)
    			);
    			break;
    	}
    }
    return result;
  }
}
