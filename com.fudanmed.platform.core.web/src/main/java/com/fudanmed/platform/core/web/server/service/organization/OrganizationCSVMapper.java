package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.web.shared.organization.UIOrganization;
import edu.fudan.langlab.csv.server.mapper.ICSVMapper;
import edu.fudan.langlab.csv.server.mapper.IMapperFactory;
import edu.fudan.langlab.csv.shared.IValidationResultAcceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.organization.OrganizationCSVMapper")
public class OrganizationCSVMapper implements ICSVMapper<UIOrganization> {
  public String toHeader() {
    java.util.ArrayList<String> headers = com.google.common.collect.Lists.newArrayList("代码","名称","所属机构","所属位置" );
    return org.eclipse.xtext.xbase.lib.IterableExtensions.join(headers,",");
  }
  
  public String getTitle4Key(final String key) {
    if("code".equals(key)) return "代码";
    if("name".equals(key)) return "名称";
    if("parentCode".equals(key)) return "所属机构";
    if("positionCodes".equals(key)) return "所属位置";
    return "";
    
  }
  
  @Autowired
  private IMapperFactory mapperFactory;
  
  public String toString(final UIOrganization data) {
    java.util.ArrayList<String> values = com.google.common.collect.Lists.newArrayList(
    mapperFactory.getStringMapper().toString(data.getCode()),
    mapperFactory.getStringMapper().toString(data.getName()),
    mapperFactory.getStringMapper().toString(data.getParentCode()),
    mapperFactory.getStringMapper().toString(data.getPositionCodes())
    					);
    
    return org.eclipse.xtext.xbase.lib.IterableExtensions.join(values,",");
  }
  
  public UIOrganization fromString(final String data, final IValidationResultAcceptor acceptor) {
    UIOrganization result = new UIOrganization();
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
    			result.setParentCode(
    				mapperFactory.getStringMapper().fromString(
    					values[i].trim(),new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("parentCode",acceptor)
    				)
    			);
    			break;
    		case 3:
    			result.setPositionCodes(
    				mapperFactory.getStringMapper().fromString(
    					values[i].trim(),new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("positionCodes",acceptor)
    				)
    			);
    			break;
    	}
    }
    return result;
  }
}
