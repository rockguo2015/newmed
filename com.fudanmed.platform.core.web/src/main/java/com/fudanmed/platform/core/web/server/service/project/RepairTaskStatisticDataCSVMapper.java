package com.fudanmed.platform.core.web.server.service.project;

import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatisticData;
import edu.fudan.langlab.csv.server.mapper.ICSVMapper;
import edu.fudan.langlab.csv.server.mapper.IMapperFactory;
import edu.fudan.langlab.csv.shared.IValidationResultAcceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("com.fudanmed.platform.core.web.server.service.project.RepairTaskStatisticDataCSVMapper")
public class RepairTaskStatisticDataCSVMapper implements ICSVMapper<UIRepairTaskStatisticData> {
  public String toHeader() {
    java.util.ArrayList<String> headers = com.google.common.collect.Lists.newArrayList("报修部门","报修人","报修来源","报修地址","接报人","报修单号","报修时间","维修状态","紧急度","维修班组","维修人员","维修大类","维修类别","报修内容","派工时间","完成时间","材料结算状态","用户评价","评价人","评价时间" );
    return org.eclipse.xtext.xbase.lib.IterableExtensions.join(headers,",");
  }
  
  public String getTitle4Key(final String key) {
    if("reportOrgFullPath".equals(key)) return "报修部门";
    if("reporterName".equals(key)) return "报修人";
    if("faultReportSource".equals(key)) return "报修来源";
    if("location".equals(key)) return "报修地址";
    if("operator".equals(key)) return "接报人";
    if("reportSid".equals(key)) return "报修单号";
    if("reportTime".equals(key)) return "报修时间";
    if("status".equals(key)) return "维修状态";
    if("faultEmergencyLevel".equals(key)) return "紧急度";
    if("teams".equals(key)) return "维修班组";
    if("workers".equals(key)) return "维修人员";
    if("mType".equals(key)) return "维修大类";
    if("faultType".equals(key)) return "维修类别";
    if("comment".equals(key)) return "报修内容";
    if("dispatchTime".equals(key)) return "派工时间";
    if("finishTime".equals(key)) return "完成时间";
    if("hasSettlement".equals(key)) return "材料结算状态";
    if("evaluateComment".equals(key)) return "用户评价";
    if("evaluater".equals(key)) return "评价人";
    if("evaluateTime".equals(key)) return "评价时间";
    return "";
    
  }
  
  @Autowired
  private IMapperFactory mapperFactory;
  
  public String toString(final UIRepairTaskStatisticData data) {
    java.util.ArrayList<String> values = com.google.common.collect.Lists.newArrayList(
    mapperFactory.getStringMapper().toString(data.getReportOrgFullPath()),
    mapperFactory.getStringMapper().toString(data.getReporterName()),
    mapperFactory.getNamedEntityMapper().toString(data.getFaultReportSource()),
    mapperFactory.getStringMapper().toString(data.getLocation()),
    mapperFactory.getNamedEntityMapper().toString(data.getOperator()),
    mapperFactory.getStringMapper().toString(data.getReportSid()),
    mapperFactory.getDateMapper().toString(data.getReportTime()),
    mapperFactory.getEnumMapper(com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatus.class).toString(data.getStatus()),
    mapperFactory.getNamedEntityMapper().toString(data.getFaultEmergencyLevel()),
    mapperFactory.getCollectionMapper().toString(data.getTeams()),
    mapperFactory.getCollectionMapper().toString(data.getWorkers()),
    mapperFactory.getNamedEntityMapper().toString(data.getMType()),
    mapperFactory.getNamedEntityMapper().toString(data.getFaultType()),
    mapperFactory.getStringMapper().toString(data.getComment()),
    mapperFactory.getDateMapper().toString(data.getDispatchTime()),
    mapperFactory.getDateMapper().toString(data.getFinishTime()),
    mapperFactory.getStringMapper().toString(data.getHasSettlement()),
    mapperFactory.getStringMapper().toString(data.getEvaluateComment()),
    mapperFactory.getNamedEntityMapper().toString(data.getEvaluater()),
    mapperFactory.getDateMapper().toString(data.getEvaluateTime())
    					);
    
    return org.eclipse.xtext.xbase.lib.IterableExtensions.join(values,",");
  }
  
  public UIRepairTaskStatisticData fromString(final String data, final IValidationResultAcceptor acceptor) {
    UIRepairTaskStatisticData result = new UIRepairTaskStatisticData();
    String[] values = data.split(",");
    for(int i=0;i<values.length;i++){
    	switch(i){
    	}
    }
    return result;
  }
}
