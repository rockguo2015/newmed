package com.fudanmed.platform.core.web.server.service.template

import com.fudanmed.platform.core.common.RCSystemParameter
import com.fudanmed.platform.core.device.pm.RCPMWorkItemWorkerAssignment
import java.text.SimpleDateFormat

import static com.fudanmed.platform.core.web.server.service.template.PMWorkItemTemplate.*

class PMWorkItemTemplate {
	def static nullsafe(String s){
		if(s==null)"&nbsp;"else s
	}
	def static nullsafe(Double s){
		if(s==null)"&nbsp;"else s.toString
	}
	def static nullsafe(Integer s){
		if(s==null)"&nbsp;"else s.toString
	}
	
	
	def static String template(RCPMWorkItemWorkerAssignment record, RCSystemParameter parameter) {
		'''
<html> 
<head> 
<title>PM任务单</title> 
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

<h2 style="width:21cm;text-align:center;font-family:Arial,Microsoft YaHei,SimHei,SimSun;" >«parameter.orgName»设备PM任务单</h2>
<table> 
<tr> 
<td width="11%" class="tdlabel tdleft tdbottom">任务单号:</td>
<td width="15%" class="tdcontent">«record.workitem.sid»</td> 
<td width="11%" class="tdlabel tdleft tdbottom">派发日期:</td> 
<td width="20%" class="tdcontent">« new SimpleDateFormat("yyyy-MM-dd").format(record.assignDate)»</td> 
<td width="11%" class="tdlabel tdleft tdbottom">配合班组:</td> 
<td width="31%" class="tdcontent">«record.workitem.team.entityName»</td> 
</tr> 
<tr> 
<td class="tdlabel tdleft tdbottom">执行日期:</td>
<td class="tdcontent">« new SimpleDateFormat("yyyy-MM-dd").format(record.assignDate)»</td> 
<td class="tdlabel tdleft tdbottom">服务提供商:</td> 
<td class="tdcontent">«nullsafe(record.workitem.supplier?.entityName)»</td> 
<td class="tdlabel tdleft tdbottom">维保人员:</td> 
<td class="tdcontent">«record.workers.map[entityName].join(',')»</td> 
</tr> 
<tr> 
<td class="tdlabel tdleft tdbottom">维保任务说明:</td>
<td colspan=5 class="tdcontent">«record.workitem.description»</td> 
</tr> 
<tr> 
<td class="tdlabel tdleft tdbottom">派工说明:</td>
<td colspan=5 class="tdcontent">«record.comment»</td> 
</tr> 
</table>

<table  class="tableLL">

<thead>
<tr>
<th width="12%" >设备编号</td>
<th width="10%" >设备名称</td>  
<th width="10%" >规格型号</td>
<th width="26%" >安装地点</td> 
<th width="10%" >设备类型</td> 
<th width="10%" >维保类别</td> 
<th width="12%" >PM计划日期</td>
<th width="10%" >维保周期</td>  
</tr> 
</thead>
<tbody>

«FOR item:record.getWorkItemPlanAssignments»
<tr>
<td>«item.plan.spec.device.sid»</td> 
<td>«item.plan.spec.device.entityName»</td>
<td>«item.plan.spec.device.specification»</td> 
<td>«nullsafe(item.plan.spec.device.location?.entityName)»</td> 
<td>«item.plan.spec.device.deviceType.entityName»</td> 
<td>«item.plan.spec.pmType.entityName»</td> 
<td>« new SimpleDateFormat("yyyy-MM-dd").format(item.plan.planDate)»</td> 
<td>«item.plan.spec.intervalInDays»</td> 
</tr> 
«ENDFOR»

</toby>
</table>

<table> 

<tr> 
<td width="11%" >&nbsp;</td>
<td width="23%" >&nbsp;</td> 
<td width="11%" >&nbsp;</td> 
<td width="22%" >&nbsp;</td> 
<td width="11%" >&nbsp;</td> 
<td width="22%" >&nbsp;</td> 
</tr> 
<tr> 
<td  class="tdlabel tdleft tdbottom">完工说明:</td>
<td colspan=3 class="tdcontent">&nbsp;</td> 
<td class="tdlabel tdleft tdbottom">完成时间:</td> 
<td class="tdcontent">&nbsp;</td> 
</tr> 
<tr> 
<td colspan=6 >&nbsp;</td> 
</tr> 
<tr> 
<td class="tdlabel tdleft tdbottom">维保人员：</td>
<td class="tdcontent">&nbsp;</td> 
<td class="tdlabel tdleft tdbottom">班组长:</td> 
<td class="tdcontent">&nbsp;</td> 
<td class="tdlabel tdleft tdbottom">维保主管:</td> 
<td class="tdcontent">&nbsp;</td> 
</tr> 

</table>
<body>
</html>








</body> 
</html>
		
		'''
	}
	
}