package com.fudanmed.platform.core.web.server.service.template

import com.fudanmed.platform.core.warehouse.RCWorkItemReturnStockRecord
import com.fudanmed.platform.core.common.RCSystemParameter
import java.text.SimpleDateFormat

class WorkOrderReturnTemplate {
	
	def static nullsafe(String s){
		if(s==null)"&nbsp;"else s
	}
	def static nullsafe(Double s){
		if(s==null)"&nbsp;"else s.toString
	}
	def static nullsafe(Integer s){
		if(s==null)"&nbsp;"else s.toString
	}
	
	
	def static String template(RCWorkItemReturnStockRecord record, RCSystemParameter parameter) {
		val workItemTask = record.workItem
		'''
			<html> 
			<head> 
			<title>退料单</title> 
			<meta http-equiv="Content-Type" content="text/html; charset=gb2312"> 
			 
			
<style> 

table
  {
    border:0px solid black;
    width:22cm;

    border-spacing:0px 7px;

  }


td,th{
color:#000000;
font-size: 12pt; 
font-family:Arial,Microsoft YaHei,SimHei,SimSun;
height:0.5cm;
padding-left:2px;
}

.tdlabel 
{ 
border-style:none; 
font-weight:bold;
}
.tdleft
{
text-align:left;
} 

.tdright
{
text-align:right;
} 

.tdcenter
{
text-align:center;
}
.tdtop 
{ 
vertical-align:top;
} 
.tdbottom 
{ 
vertical-align:bottom;
} 


.tdcontent
{
border-style:none;
border-bottom:1px solid #000000;
text-align:center;
vertical-align:bottom;
}

thead
{
   display:table-header-group;
}


.tableLL
{
  width:22cm;
 border:1px solid #000000;
 border-collapse:collapse;

 }

.tableLL th
{
  border:1px solid #000000;
 
  padding-top:3px;
  padding-bottom:3px;
 }

.tableLL td
{
 border:1px solid #000000;
 padding:3px 7px 2px 7px;
font-size: 10pt;

 }



</style> 
			
			</head> 
			
			<body > 
			
			<center><h2>«parameter.orgName»维修服务单-退料单</h2></center>
			<table width="100%" border="0" align="center" > 
			<!--以下是报修单-->
			<tr> 
			<td width="15%" class="tdlabelbottom">报修单号:</td> 
			<td width="15%" class="tdcontent">«workItemTask.groupTask.repairTask.reportSid»</td> 
			<td width="15%" class="tdlabelbottom">报修时间:</td> 
			<td width="20%" class="tdcontent">« new SimpleDateFormat("yyyy-MM-dd HH:mm").format(workItemTask.groupTask.repairTask.reportTime)»</td> 
			<td width="15%" class="tdlabelbottom">报修科室:</td> 
			<td width="20%" class="tdcontent">«nullsafe(workItemTask.groupTask.repairTask.reportOrg?.entityName)»</td> 
			</tr> 
						
			<tr> 
			<td width="15%" class="tdlabelbottom">报修地点:</td> 
			<td width="85%" colspan=3 class="tdcontent">«nullsafe(workItemTask.groupTask.repairTask.location)»</td> 
			<td width="15%" class="tdlabelbottom">报修人:</td> 
			<td width="20%" class="tdcontent">«nullsafe(workItemTask.groupTask.repairTask.reporterName)+'&nbsp;'+nullsafe(workItemTask.groupTask.repairTask.reporterPhone)»</td> 
			</tr> 
			
			
			<!--以下是工单-->
			<tr> 
			<td class="tdlabelbottom">工单号:</td> 
			<td class="tdcontent">«nullsafe(workItemTask.sid)»</td> 
			<td class="tdlabelbottom">维修班组:</td> 
			<td class="tdcontent">«nullsafe(workItemTask.groupTask.team?.entityName)»</td> 
			<td class="tdlabelbottom">维修人员:</td> 
			<td class="tdcontent">«FOR p:workItemTask.workers SEPARATOR ','»«p.entityName»«ENDFOR»</td> 
			</tr> 
			 			 
			<!--以下是领料单-->
			<tr> 
			<td class="tdlabelbottom">领料单号:</td> 
			<td class="tdcontent">«nullsafe(record.sid)»</td> 
			<td class="tdlabelbottom">仓保员:</td> 
			<td class="tdcontent">«nullsafe(record.operator.entityName)»</td> 
			<td class="tdlabelbottom">备注:</td> 
			<td class="tdcontent">&nbsp;</td> 
			</tr> 
			<table width="100%" border="0" align="center" > 
			
			
			<table  class="tableLL">
			<tr>
			<th width="25%" >材料名称</td> 
			<th width="15%" >规格</td> 
			<th width="18%" >批次</td> 
			<th width="8%" >数量</td> 
			<th width="8%" >单位</td> 
			<th width="12%">单价（元）</td> 
			<th width="12%">金额（元）</td> 
			</tr> 

			«FOR item:record.items»
			<tr>
			<td>«nullsafe(item.recordItem.productEntry.productSpec.entityName)»</td> 
			<td>«nullsafe(item.recordItem.productEntry.productSpec.typeDesc)»</td> 
			<td>«nullsafe(item.recordItem.productEntry.sid)»</td> 
			<td>«nullsafe(item.recordItem.quantity.toString)»</td> 
			<td>«nullsafe(item.recordItem.productEntry.productSpec.unit?.entityName)»</td> 
			<td class="tdright">«nullsafe(item.recordItem.productEntry.price.toString)»</td> 
			<td class="tdright">«nullsafe((item.recordItem.totalAmount).toString)»</td> 
			</tr> 
			«ENDFOR»
			<tr>
			<th colspan=6>费用合计</th> 
			<th class="tdright">«nullsafe(record.totalAmount.toString)»</th> 
			</tr> 
			
			</table>

			
			<p>&nbsp;</p>
			<!--以下是确认-->
			<table width="100%" border="0" align="center" > 
			<tr> 
			<td width="25%" class="tdlabelbottom">&nbsp</td> 
			<td width="15%"class="tdlabelbottom">院方签字:</td> 
			<td width="20%" class="tdcontent">&nbsp;</td> 
			<td width="20%" class="tdlabelbottom">工程部负责人：</td> 
			<td width="20%" class="tdcontent">&nbsp</td> 
			</tr>  
			</table>
			
			</body> 
			</html>
		'''.toString
	}	
}