package com.fudanmed.platform.core.web.server.service.device;

import com.fudanmed.platform.core.web.server.service.device.DeviceCSVMapperAcquireType;
import com.fudanmed.platform.core.web.server.service.device.DeviceCSVMapperDeviceIndicator;
import com.fudanmed.platform.core.web.server.service.device.DeviceCSVMapperDeviceType;
import com.fudanmed.platform.core.web.server.service.device.DeviceCSVMapperOwner;
import com.fudanmed.platform.core.web.server.service.device.DeviceCSVMapperProductor;
import com.fudanmed.platform.core.web.server.service.device.DeviceCSVMapperSupplier;
import com.fudanmed.platform.core.web.server.service.device.DeviceCSVMapperUsageType;
import com.fudanmed.platform.core.web.shared.device.UIDevice;
import edu.fudan.langlab.csv.server.mapper.ICSVMapper;
import edu.fudan.langlab.csv.server.mapper.IMapperFactory;
import edu.fudan.langlab.csv.shared.IValidationResultAcceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.device.DeviceCSVMapper")
public class DeviceCSVMapper implements ICSVMapper<UIDevice> {
  @Autowired
  private DeviceCSVMapperProductor productorMapper;
  
  @Autowired
  private DeviceCSVMapperSupplier supplierMapper;
  
  @Autowired
  private DeviceCSVMapperDeviceType deviceTypeMapper;
  
  @Autowired
  private DeviceCSVMapperDeviceIndicator deviceIndicatorMapper;
  
  @Autowired
  private DeviceCSVMapperUsageType usageTypeMapper;
  
  @Autowired
  private DeviceCSVMapperAcquireType acquireTypeMapper;
  
  @Autowired
  private DeviceCSVMapperOwner ownerMapper;
  
  public String toHeader() {
    java.util.ArrayList<String> headers = com.google.common.collect.Lists.newArrayList("设备编号","设备名称","规格型号","安装地点","服务区域","生产厂商","供应厂商","设备类型","设备标识","使用情况","增置方式","购买时间","资产原值","出厂时间","资产净值","资产负责人","折旧年限","净残率","使用部门","备注" );
    return org.eclipse.xtext.xbase.lib.IterableExtensions.join(headers,",");
  }
  
  public String getTitle4Key(final String key) {
    if("sid".equals(key)) return "设备编号";
    if("name".equals(key)) return "设备名称";
    if("specification".equals(key)) return "规格型号";
    if("locationName".equals(key)) return "安装地点";
    if("serviceLocationName".equals(key)) return "服务区域";
    if("productor".equals(key)) return "生产厂商";
    if("supplier".equals(key)) return "供应厂商";
    if("deviceType".equals(key)) return "设备类型";
    if("deviceIndicator".equals(key)) return "设备标识";
    if("usageType".equals(key)) return "使用情况";
    if("acquireType".equals(key)) return "增置方式";
    if("buyTime".equals(key)) return "购买时间";
    if("buyPrice".equals(key)) return "资产原值";
    if("outStockTime".equals(key)) return "出厂时间";
    if("netPrice".equals(key)) return "资产净值";
    if("owner".equals(key)) return "资产负责人";
    if("depreciationYears".equals(key)) return "折旧年限";
    if("netLeaveRate".equals(key)) return "净残率";
    if("ownerDepartmentName".equals(key)) return "使用部门";
    if("comment".equals(key)) return "备注";
    return "";
    
  }
  
  @Autowired
  private IMapperFactory mapperFactory;
  
  public String toString(final UIDevice data) {
    java.util.ArrayList<String> values = com.google.common.collect.Lists.newArrayList(
    mapperFactory.getStringMapper().toString(data.getSid()),
    mapperFactory.getStringMapper().toString(data.getName()),
    mapperFactory.getStringMapper().toString(data.getSpecification()),
    mapperFactory.getStringMapper().toString(data.getLocationName()),
    mapperFactory.getStringMapper().toString(data.getServiceLocationName()),
    productorMapper.toString(data.getProductor(),data),
    supplierMapper.toString(data.getSupplier(),data),
    deviceTypeMapper.toString(data.getDeviceType(),data),
    deviceIndicatorMapper.toString(data.getDeviceIndicator(),data),
    usageTypeMapper.toString(data.getUsageType(),data),
    acquireTypeMapper.toString(data.getAcquireType(),data),
    mapperFactory.getDateMapper().toString(data.getBuyTime()),
    mapperFactory.getDoubleMapper().toString(data.getBuyPrice()),
    mapperFactory.getDateMapper().toString(data.getOutStockTime()),
    mapperFactory.getDoubleMapper().toString(data.getNetPrice()),
    ownerMapper.toString(data.getOwner(),data),
    mapperFactory.getIntegerMapper().toString(data.getDepreciationYears()),
    mapperFactory.getDoubleMapper().toString(data.getNetLeaveRate()),
    mapperFactory.getStringMapper().toString(data.getOwnerDepartmentName()),
    mapperFactory.getStringMapper().toString(data.getComment())
    					);
    
    return org.eclipse.xtext.xbase.lib.IterableExtensions.join(values,",");
  }
  
  public UIDevice fromString(final String data, final IValidationResultAcceptor acceptor) {
    UIDevice result = new UIDevice();
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
    			result.setSpecification(
    				mapperFactory.getStringMapper().fromString(
    					values[i].trim(),new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("specification",acceptor)
    				)
    			);
    			break;
    		case 3:
    			result.setLocationName(
    				mapperFactory.getStringMapper().fromString(
    					values[i].trim(),new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("locationName",acceptor)
    				)
    			);
    			break;
    		case 4:
    			result.setServiceLocationName(
    				mapperFactory.getStringMapper().fromString(
    					values[i].trim(),new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("serviceLocationName",acceptor)
    				)
    			);
    			break;
    		case 5:
    			result.setProductor(
    				productorMapper.fromString(
    					values[i].trim(),result,new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("productor",acceptor)
    				)
    			);
    			break;
    		case 6:
    			result.setSupplier(
    				supplierMapper.fromString(
    					values[i].trim(),result,new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("supplier",acceptor)
    				)
    			);
    			break;
    		case 7:
    			result.setDeviceType(
    				deviceTypeMapper.fromString(
    					values[i].trim(),result,new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("deviceType",acceptor)
    				)
    			);
    			break;
    		case 8:
    			result.setDeviceIndicator(
    				deviceIndicatorMapper.fromString(
    					values[i].trim(),result,new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("deviceIndicator",acceptor)
    				)
    			);
    			break;
    		case 9:
    			result.setUsageType(
    				usageTypeMapper.fromString(
    					values[i].trim(),result,new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("usageType",acceptor)
    				)
    			);
    			break;
    		case 10:
    			result.setAcquireType(
    				acquireTypeMapper.fromString(
    					values[i].trim(),result,new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("acquireType",acceptor)
    				)
    			);
    			break;
    		case 11:
    			result.setBuyTime(
    				mapperFactory.getDateMapper().fromString(
    					values[i].trim(),new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("buyTime",acceptor)
    				)
    			);
    			break;
    		case 12:
    			result.setBuyPrice(
    				mapperFactory.getDoubleMapper().fromString(
    					values[i].trim(),new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("buyPrice",acceptor)
    				)
    			);
    			break;
    		case 13:
    			result.setOutStockTime(
    				mapperFactory.getDateMapper().fromString(
    					values[i].trim(),new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("outStockTime",acceptor)
    				)
    			);
    			break;
    		case 14:
    			result.setNetPrice(
    				mapperFactory.getDoubleMapper().fromString(
    					values[i].trim(),new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("netPrice",acceptor)
    				)
    			);
    			break;
    		case 15:
    			result.setOwner(
    				ownerMapper.fromString(
    					values[i].trim(),result,new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("owner",acceptor)
    				)
    			);
    			break;
    		case 16:
    			result.setDepreciationYears(
    				mapperFactory.getIntegerMapper().fromString(
    					values[i].trim(),new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("depreciationYears",acceptor)
    				)
    			);
    			break;
    		case 17:
    			result.setNetLeaveRate(
    				mapperFactory.getDoubleMapper().fromString(
    					values[i].trim(),new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("netLeaveRate",acceptor)
    				)
    			);
    			break;
    		case 18:
    			result.setOwnerDepartmentName(
    				mapperFactory.getStringMapper().fromString(
    					values[i].trim(),new edu.fudan.langlab.csv.shared.DefaultFieldValidationResultAcceptor("ownerDepartmentName",acceptor)
    				)
    			);
    			break;
    		case 19:
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
