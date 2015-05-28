package com.fudanmed.platform.core.web.server.service.warehouse;

import com.fudanmed.platform.core.web.server.service.warehouse.ProductSpecificationCSVMapperBrandType;
import com.fudanmed.platform.core.web.server.service.warehouse.ProductSpecificationCSVMapperDefaultSupplier;
import com.fudanmed.platform.core.web.server.service.warehouse.ProductSpecificationCSVMapperProductType;
import com.fudanmed.platform.core.web.server.service.warehouse.ProductSpecificationCSVMapperUnit;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import edu.fudan.langlab.csv.server.mapper.ICSVMapper;
import edu.fudan.langlab.csv.server.mapper.IMapperFactory;
import edu.fudan.langlab.csv.shared.IValidationResultAcceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.warehouse.ProductSpecificationCSVMapper")
public class ProductSpecificationCSVMapper implements ICSVMapper<UIProductSpecification> {
  @Autowired
  private ProductSpecificationCSVMapperBrandType brandTypeMapper;
  
  @Autowired
  private ProductSpecificationCSVMapperUnit unitMapper;
  
  @Autowired
  private ProductSpecificationCSVMapperProductType productTypeMapper;
  
  @Autowired
  private ProductSpecificationCSVMapperDefaultSupplier defaultSupplierMapper;
  
  public String toHeader() {
    java.util.ArrayList<String> headers = com.google.common.collect.Lists.newArrayList("条码","物品名称","规格型号","单位","物品类别","默认供应商","物品编号","品牌","参考单价","保质期(天)","最小库存","最大库存" );
    return org.eclipse.xtext.xbase.lib.IterableExtensions.join(headers,",");
  }
  
  public String getTitle4Key(final String key) {
    if("sid".equals(key)) return "条码";
    if("name".equals(key)) return "物品名称";
    if("typeDesc".equals(key)) return "规格型号";
    if("unit".equals(key)) return "单位";
    if("productType".equals(key)) return "物品类别";
    if("defaultSupplier".equals(key)) return "默认供应商";
    if("materialId".equals(key)) return "物品编号";
    if("brandType".equals(key)) return "品牌";
    if("referencePrice".equals(key)) return "参考单价";
    if("shelfLife".equals(key)) return "保质期(天)";
    if("lowerStorage".equals(key)) return "最小库存";
    if("upperStorage".equals(key)) return "最大库存";
    return "";
    
  }
  
  @Autowired
  private IMapperFactory mapperFactory;
  
  public String toString(final UIProductSpecification data) {
    java.util.ArrayList<String> values = com.google.common.collect.Lists.newArrayList(
    mapperFactory.getStringMapper().toString(data.getSid()),
    mapperFactory.getStringMapper().toString(data.getName()),
    mapperFactory.getStringMapper().toString(data.getTypeDesc()),
    unitMapper.toString(data.getUnit(),data),
    productTypeMapper.toString(data.getProductType(),data),
    defaultSupplierMapper.toString(data.getDefaultSupplier(),data),
    mapperFactory.getStringMapper().toString(data.getMaterialId()),
    brandTypeMapper.toString(data.getBrandType(),data),
    mapperFactory.getDoubleMapper().toString(data.getReferencePrice()),
    mapperFactory.getIntegerMapper().toString(data.getShelfLife()),
    mapperFactory.getIntegerMapper().toString(data.getLowerStorage()),
    mapperFactory.getIntegerMapper().toString(data.getUpperStorage())
    					);
    
    return org.eclipse.xtext.xbase.lib.IterableExtensions.join(values,",");
  }
  
  public UIProductSpecification fromString(final String data, final IValidationResultAcceptor acceptor) {
    UIProductSpecification result = new UIProductSpecification();
    String[] values = data.split(",");
    for(int i=0;i<values.length;i++){
    	switch(i){
    		case 0:
    			result.setSid(
    				mapperFactory.getStringMapper().fromString(
    					values[i].trim(),new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("sid",acceptor)
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
    			result.setTypeDesc(
    				mapperFactory.getStringMapper().fromString(
    					values[i].trim(),new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("typeDesc",acceptor)
    				)
    			);
    			break;
    		case 3:
    			result.setUnit(
    				unitMapper.fromString(
    					values[i].trim(),result,new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("unit",acceptor)
    				)
    			);
    			break;
    		case 4:
    			result.setProductType(
    				productTypeMapper.fromString(
    					values[i].trim(),result,new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("productType",acceptor)
    				)
    			);
    			break;
    		case 5:
    			result.setDefaultSupplier(
    				defaultSupplierMapper.fromString(
    					values[i].trim(),result,new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("defaultSupplier",acceptor)
    				)
    			);
    			break;
    		case 6:
    			result.setMaterialId(
    				mapperFactory.getStringMapper().fromString(
    					values[i].trim(),new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("materialId",acceptor)
    				)
    			);
    			break;
    		case 7:
    			result.setBrandType(
    				brandTypeMapper.fromString(
    					values[i].trim(),result,new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("brandType",acceptor)
    				)
    			);
    			break;
    		case 8:
    			result.setReferencePrice(
    				mapperFactory.getDoubleMapper().fromString(
    					values[i].trim(),new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("referencePrice",acceptor)
    				)
    			);
    			break;
    		case 9:
    			result.setShelfLife(
    				mapperFactory.getIntegerMapper().fromString(
    					values[i].trim(),new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("shelfLife",acceptor)
    				)
    			);
    			break;
    		case 10:
    			result.setLowerStorage(
    				mapperFactory.getIntegerMapper().fromString(
    					values[i].trim(),new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("lowerStorage",acceptor)
    				)
    			);
    			break;
    		case 11:
    			result.setUpperStorage(
    				mapperFactory.getIntegerMapper().fromString(
    					values[i].trim(),new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("upperStorage",acceptor)
    				)
    			);
    			break;
    	}
    }
    return result;
  }
}
