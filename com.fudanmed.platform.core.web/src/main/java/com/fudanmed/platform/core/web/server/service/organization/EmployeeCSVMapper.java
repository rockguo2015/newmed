package com.fudanmed.platform.core.web.server.service.organization;

import com.fudanmed.platform.core.web.server.service.organization.EmployeeCSVMapperOrganization;
import com.fudanmed.platform.core.web.shared.organization.UIEmployee;
import edu.fudan.langlab.csv.server.mapper.ICSVMapper;
import edu.fudan.langlab.csv.server.mapper.IMapperFactory;
import edu.fudan.langlab.csv.shared.IValidationResultAcceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.organization.EmployeeCSVMapper")
public class EmployeeCSVMapper implements ICSVMapper<UIEmployee> {
  @Autowired
  private EmployeeCSVMapperOrganization organizationMapper;
  
  public String toHeader() {
    java.util.ArrayList<String> headers = com.google.common.collect.Lists.newArrayList("工号","姓名","手机","宅电","工作电话","电子邮件","地址","所属机构" );
    return org.eclipse.xtext.xbase.lib.IterableExtensions.join(headers,",");
  }
  
  public String getTitle4Key(final String key) {
    if("eid".equals(key)) return "工号";
    if("name".equals(key)) return "姓名";
    if("mobil".equals(key)) return "手机";
    if("tel".equals(key)) return "宅电";
    if("workTel".equals(key)) return "工作电话";
    if("email".equals(key)) return "电子邮件";
    if("address".equals(key)) return "地址";
    if("organization".equals(key)) return "所属机构";
    return "";
    
  }
  
  @Autowired
  private IMapperFactory mapperFactory;
  
  public String toString(final UIEmployee data) {
    java.util.ArrayList<String> values = com.google.common.collect.Lists.newArrayList(
    mapperFactory.getStringMapper().toString(data.getEid()),
    mapperFactory.getStringMapper().toString(data.getName()),
    mapperFactory.getStringMapper().toString(data.getMobil()),
    mapperFactory.getStringMapper().toString(data.getTel()),
    mapperFactory.getStringMapper().toString(data.getWorkTel()),
    mapperFactory.getStringMapper().toString(data.getEmail()),
    mapperFactory.getStringMapper().toString(data.getAddress()),
    organizationMapper.toString(data.getOrganization(),data)
    					);
    
    return org.eclipse.xtext.xbase.lib.IterableExtensions.join(values,",");
  }
  
  public UIEmployee fromString(final String data, final IValidationResultAcceptor acceptor) {
    UIEmployee result = new UIEmployee();
    String[] values = data.split(",");
    for(int i=0;i<values.length;i++){
    	switch(i){
    		case 0:
    			result.setEid(
    				mapperFactory.getStringMapper().fromString(
    					values[i].trim(),new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("eid",acceptor)
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
    			result.setMobil(
    				mapperFactory.getStringMapper().fromString(
    					values[i].trim(),new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("mobil",acceptor)
    				)
    			);
    			break;
    		case 3:
    			result.setTel(
    				mapperFactory.getStringMapper().fromString(
    					values[i].trim(),new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("tel",acceptor)
    				)
    			);
    			break;
    		case 4:
    			result.setWorkTel(
    				mapperFactory.getStringMapper().fromString(
    					values[i].trim(),new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("workTel",acceptor)
    				)
    			);
    			break;
    		case 5:
    			result.setEmail(
    				mapperFactory.getStringMapper().fromString(
    					values[i].trim(),new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("email",acceptor)
    				)
    			);
    			break;
    		case 6:
    			result.setAddress(
    				mapperFactory.getStringMapper().fromString(
    					values[i].trim(),new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("address",acceptor)
    				)
    			);
    			break;
    		case 7:
    			result.setOrganization(
    				organizationMapper.fromString(
    					values[i].trim(),result,new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("organization",acceptor)
    				)
    			);
    			break;
    	}
    }
    return result;
  }
}
