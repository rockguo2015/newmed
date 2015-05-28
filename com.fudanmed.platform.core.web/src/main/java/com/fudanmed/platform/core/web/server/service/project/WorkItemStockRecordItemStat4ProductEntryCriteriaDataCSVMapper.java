package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.web.shared.project.UIWorkItemStockRecordItemStat4ProductEntryCriteriaData;
import edu.fudan.langlab.csv.server.mapper.ICSVMapper;
import edu.fudan.langlab.csv.server.mapper.IMapperFactory;
import edu.fudan.langlab.csv.shared.IValidationResultAcceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.project.WorkItemStockRecordItemStat4ProductEntryCriteriaDataCSVMapper")
public class WorkItemStockRecordItemStat4ProductEntryCriteriaDataCSVMapper implements ICSVMapper<UIWorkItemStockRecordItemStat4ProductEntryCriteriaData> {
  public String toHeader() {
    java.util.ArrayList<String> headers = com.google.common.collect.Lists.newArrayList("物品名称","规格型号","数量","单位" );
    return org.eclipse.xtext.xbase.lib.IterableExtensions.join(headers,",");
  }
  
  public String getTitle4Key(final String key) {
    if("productEntry".equals(key)) return "物品名称";
    if("typeDesc".equals(key)) return "规格型号";
    if("cnt".equals(key)) return "数量";
    if("unit".equals(key)) return "单位";
    return "";
    
  }
  
  @Autowired
  private IMapperFactory mapperFactory;
  
  public String toString(final UIWorkItemStockRecordItemStat4ProductEntryCriteriaData data) {
    java.util.ArrayList<String> values = com.google.common.collect.Lists.newArrayList(
    mapperFactory.getNamedEntityMapper().toString(data.getProductEntry()),
    mapperFactory.getStringMapper().toString(data.getTypeDesc()),
    mapperFactory.getLongMapper().toString(data.getCnt()),
    mapperFactory.getStringMapper().toString(data.getUnit())
    					);
    
    return org.eclipse.xtext.xbase.lib.IterableExtensions.join(values,",");
  }
  
  public UIWorkItemStockRecordItemStat4ProductEntryCriteriaData fromString(final String data, final IValidationResultAcceptor acceptor) {
    UIWorkItemStockRecordItemStat4ProductEntryCriteriaData result = new UIWorkItemStockRecordItemStat4ProductEntryCriteriaData();
    String[] values = data.split(",");
    for(int i=0;i<values.length;i++){
    	switch(i){
    	}
    }
    return result;
  }
}
