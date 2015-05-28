package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.web.server.service.warehouse.StockTakingItemCSVMapperBrand;
import com.fudanmed.platform.core.web.server.service.warehouse.StockTakingItemCSVMapperUnit;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingItem;
import edu.fudan.langlab.csv.server.mapper.ICSVMapper;
import edu.fudan.langlab.csv.server.mapper.IMapperFactory;
import edu.fudan.langlab.csv.shared.IValidationResultAcceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.warehouse.StockTakingItemCSVMapper")
public class StockTakingItemCSVMapper implements ICSVMapper<UIStockTakingItem> {
  @Autowired
  private StockTakingItemCSVMapperUnit unitMapper;
  
  @Autowired
  private StockTakingItemCSVMapperBrand brandMapper;
  
  public String toHeader() {
    java.util.ArrayList<String> headers = com.google.common.collect.Lists.newArrayList("条码","物品编号","品牌","物品名称","规格型号","库存数量","计量单位","实盘数量","异动原因" );
    return org.eclipse.xtext.xbase.lib.IterableExtensions.join(headers,",");
  }
  
  public String getTitle4Key(final String key) {
    if("productSpecsSid".equals(key)) return "条码";
    if("materialId".equals(key)) return "物品编号";
    if("brand".equals(key)) return "品牌";
    if("name".equals(key)) return "物品名称";
    if("typeDesc".equals(key)) return "规格型号";
    if("realQuantity".equals(key)) return "库存数量";
    if("unit".equals(key)) return "计量单位";
    if("quantity".equals(key)) return "实盘数量";
    if("comment".equals(key)) return "异动原因";
    return "";
    
  }
  
  @Autowired
  private IMapperFactory mapperFactory;
  
  public String toString(final UIStockTakingItem data) {
    java.util.ArrayList<String> values = com.google.common.collect.Lists.newArrayList(
    mapperFactory.getStringMapper().toString(data.getProductSpecsSid()),
    mapperFactory.getStringMapper().toString(data.getMaterialId()),
    brandMapper.toString(data.getBrand(),data),
    mapperFactory.getStringMapper().toString(data.getName()),
    mapperFactory.getStringMapper().toString(data.getTypeDesc()),
    mapperFactory.getIntegerMapper().toString(data.getRealQuantity()),
    unitMapper.toString(data.getUnit(),data),
    mapperFactory.getIntegerMapper().toString(data.getQuantity()),
    mapperFactory.getStringMapper().toString(data.getComment())
    					);
    
    return org.eclipse.xtext.xbase.lib.IterableExtensions.join(values,",");
  }
  
  public UIStockTakingItem fromString(final String data, final IValidationResultAcceptor acceptor) {
    UIStockTakingItem result = new UIStockTakingItem();
    String[] values = data.split(",");
    for(int i=0;i<values.length;i++){
    	switch(i){
    		case 0:
    			result.setProductSpecsSid(
    				mapperFactory.getStringMapper().fromString(
    					values[i].trim(),new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("productSpecsSid",acceptor)
    				)
    			);
    			break;
    		case 1:
    			result.setMaterialId(
    				mapperFactory.getStringMapper().fromString(
    					values[i].trim(),new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("materialId",acceptor)
    				)
    			);
    			break;
    		case 2:
    			result.setBrand(
    				brandMapper.fromString(
    					values[i].trim(),result,new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("brand",acceptor)
    				)
    			);
    			break;
    		case 3:
    			result.setName(
    				mapperFactory.getStringMapper().fromString(
    					values[i].trim(),new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("name",acceptor)
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
    			result.setRealQuantity(
    				mapperFactory.getIntegerMapper().fromString(
    					values[i].trim(),new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("realQuantity",acceptor)
    				)
    			);
    			break;
    		case 6:
    			result.setUnit(
    				unitMapper.fromString(
    					values[i].trim(),result,new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("unit",acceptor)
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
    			result.setComment(
    				mapperFactory.getStringMapper().fromString(
    					values[i].trim(),new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("comment",acceptor)
    				)
    			);
    			break;
    	}
    }
    return result;
  }
}
