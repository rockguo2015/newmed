package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.web.shared.project.UIWorkItemStockRecordStatisticsData;
import edu.fudan.langlab.csv.server.mapper.ICSVMapper;
import edu.fudan.langlab.csv.server.mapper.IMapperFactory;
import edu.fudan.langlab.csv.shared.IValidationResultAcceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.project.WorkItemStockRecordStatisticsDataCSVMapper")
public class WorkItemStockRecordStatisticsDataCSVMapper implements ICSVMapper<UIWorkItemStockRecordStatisticsData> {
  public String toHeader() {
    java.util.ArrayList<String> headers = com.google.common.collect.Lists.newArrayList("维修班组","物品编号","物品名称","规格型号","计量单位","单价","数量","金额","报修科室","领料时间","报修单号","工单编号","领退料单号" );
    return org.eclipse.xtext.xbase.lib.IterableExtensions.join(headers,",");
  }
  
  public String getTitle4Key(final String key) {
    if("team".equals(key)) return "维修班组";
    if("materialId".equals(key)) return "物品编号";
    if("name".equals(key)) return "物品名称";
    if("typeDesc".equals(key)) return "规格型号";
    if("unit".equals(key)) return "计量单位";
    if("price".equals(key)) return "单价";
    if("quantity".equals(key)) return "数量";
    if("amount".equals(key)) return "金额";
    if("reportOrg".equals(key)) return "报修科室";
    if("date".equals(key)) return "领料时间";
    if("reportSid".equals(key)) return "报修单号";
    if("workItemSid".equals(key)) return "工单编号";
    if("inoutStockSid".equals(key)) return "领退料单号";
    return "";
    
  }
  
  @Autowired
  private IMapperFactory mapperFactory;
  
  public String toString(final UIWorkItemStockRecordStatisticsData data) {
    java.util.ArrayList<String> values = com.google.common.collect.Lists.newArrayList(
    mapperFactory.getNamedEntityMapper().toString(data.getTeam()),
    mapperFactory.getStringMapper().toString(data.getMaterialId()),
    mapperFactory.getStringMapper().toString(data.getName()),
    mapperFactory.getStringMapper().toString(data.getTypeDesc()),
    mapperFactory.getNamedEntityMapper().toString(data.getUnit()),
    mapperFactory.getDoubleMapper().toString(data.getPrice()),
    mapperFactory.getIntegerMapper().toString(data.getQuantity()),
    mapperFactory.getDoubleMapper().toString(data.getAmount()),
    mapperFactory.getNamedEntityMapper().toString(data.getReportOrg()),
    mapperFactory.getDateMapper().toString(data.getDate()),
    mapperFactory.getStringMapper().toString(data.getReportSid()),
    mapperFactory.getStringMapper().toString(data.getWorkItemSid()),
    mapperFactory.getStringMapper().toString(data.getInoutStockSid())
    					);
    
    return org.eclipse.xtext.xbase.lib.IterableExtensions.join(values,",");
  }
  
  public UIWorkItemStockRecordStatisticsData fromString(final String data, final IValidationResultAcceptor acceptor) {
    UIWorkItemStockRecordStatisticsData result = new UIWorkItemStockRecordStatisticsData();
    String[] values = data.split(",");
    for(int i=0;i<values.length;i++){
    	switch(i){
    	}
    }
    return result;
  }
}
