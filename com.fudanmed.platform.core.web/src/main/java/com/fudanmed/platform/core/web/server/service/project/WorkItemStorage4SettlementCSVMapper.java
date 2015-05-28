package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.web.server.service.project.WorkItemStorage4SettlementCSVMapperBrand;
import com.fudanmed.platform.core.web.server.service.project.WorkItemStorage4SettlementCSVMapperProductSpec;
import com.fudanmed.platform.core.web.server.service.project.WorkItemStorage4SettlementCSVMapperUnit;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemStorage4Settlement;
import edu.fudan.langlab.csv.server.mapper.ICSVMapper;
import edu.fudan.langlab.csv.server.mapper.IMapperFactory;
import edu.fudan.langlab.csv.shared.IValidationResultAcceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.project.WorkItemStorage4SettlementCSVMapper")
public class WorkItemStorage4SettlementCSVMapper implements ICSVMapper<UIWorkItemStorage4Settlement> {
  @Autowired
  private WorkItemStorage4SettlementCSVMapperUnit unitMapper;
  
  @Autowired
  private WorkItemStorage4SettlementCSVMapperBrand brandMapper;
  
  @Autowired
  private WorkItemStorage4SettlementCSVMapperProductSpec productSpecMapper;
  
  public String toHeader() {
    java.util.ArrayList<String> headers = com.google.common.collect.Lists.newArrayList("报修单号","物品名称","入库批号","条码","规格型号","品牌","单价","数量","计量单位","金额" );
    return org.eclipse.xtext.xbase.lib.IterableExtensions.join(headers,",");
  }
  
  public String getTitle4Key(final String key) {
    if("repairTaskSid".equals(key)) return "报修单号";
    if("productSpec".equals(key)) return "物品名称";
    if("sid".equals(key)) return "入库批号";
    if("productSid".equals(key)) return "条码";
    if("typeDesc".equals(key)) return "规格型号";
    if("brand".equals(key)) return "品牌";
    if("price".equals(key)) return "单价";
    if("quantity".equals(key)) return "数量";
    if("unit".equals(key)) return "计量单位";
    if("amount".equals(key)) return "金额";
    return "";
    
  }
  
  @Autowired
  private IMapperFactory mapperFactory;
  
  public String toString(final UIWorkItemStorage4Settlement data) {
    java.util.ArrayList<String> values = com.google.common.collect.Lists.newArrayList(
    mapperFactory.getStringMapper().toString(data.getRepairTaskSid()),
    productSpecMapper.toString(data.getProductSpec(),data),
    mapperFactory.getStringMapper().toString(data.getSid()),
    mapperFactory.getStringMapper().toString(data.getProductSid()),
    mapperFactory.getStringMapper().toString(data.getTypeDesc()),
    brandMapper.toString(data.getBrand(),data),
    mapperFactory.getDoubleMapper().toString(data.getPrice()),
    mapperFactory.getIntegerMapper().toString(data.getQuantity()),
    unitMapper.toString(data.getUnit(),data),
    mapperFactory.getDoubleMapper().toString(data.getAmount())
    					);
    
    return org.eclipse.xtext.xbase.lib.IterableExtensions.join(values,",");
  }
  
  public UIWorkItemStorage4Settlement fromString(final String data, final IValidationResultAcceptor acceptor) {
    UIWorkItemStorage4Settlement result = new UIWorkItemStorage4Settlement();
    String[] values = data.split(",");
    for(int i=0;i<values.length;i++){
    	switch(i){
    		case 0:
    			result.setRepairTaskSid(
    				mapperFactory.getStringMapper().fromString(
    					values[i].trim(),new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("repairTaskSid",acceptor)
    				)
    			);
    			break;
    		case 1:
    			result.setProductSpec(
    				productSpecMapper.fromString(
    					values[i].trim(),result,new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("productSpec",acceptor)
    				)
    			);
    			break;
    		case 2:
    			result.setSid(
    				mapperFactory.getStringMapper().fromString(
    					values[i].trim(),new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("sid",acceptor)
    				)
    			);
    			break;
    		case 3:
    			result.setProductSid(
    				mapperFactory.getStringMapper().fromString(
    					values[i].trim(),new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("productSid",acceptor)
    				)
    			);
    			break;
    		case 4:
    			result.setTypeDesc(
    				mapperFactory.getStringMapper().fromString(
    					values[i].trim(),new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("typeDesc",acceptor)
    				)
    			);
    			break;
    		case 5:
    			result.setBrand(
    				brandMapper.fromString(
    					values[i].trim(),result,new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("brand",acceptor)
    				)
    			);
    			break;
    		case 6:
    			result.setPrice(
    				mapperFactory.getDoubleMapper().fromString(
    					values[i].trim(),new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("price",acceptor)
    				)
    			);
    			break;
    		case 7:
    			result.setQuantity(
    				mapperFactory.getIntegerMapper().fromString(
    					values[i].trim(),new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("quantity",acceptor)
    				)
    			);
    			break;
    		case 8:
    			result.setUnit(
    				unitMapper.fromString(
    					values[i].trim(),result,new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("unit",acceptor)
    				)
    			);
    			break;
    		case 9:
    			result.setAmount(
    				mapperFactory.getDoubleMapper().fromString(
    					values[i].trim(),new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("amount",acceptor)
    				)
    			);
    			break;
    	}
    }
    return result;
  }
}
