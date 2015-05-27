package com.fudanmed.platform.core.web.server.service.template

import com.fudanmed.platform.core.domain.RCSettlement
import java.text.SimpleDateFormat
import static extension com.uniquesoft.gwt.shared.extensions.Collections3.*
import com.fudanmed.platform.core.common.RCSystemParameter

class SettlementTemplate {

	def static String settlementTemplate(RCSettlement settlement, RCSystemParameter parameter){
		'''
		<html> 
		<head> 
		<title>结算单</title> 
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
		<h2 style="width:21cm;text-align:center;font-family:Arial,Microsoft YaHei,SimHei,SimSun;" >«parameter.orgName»维修服务单结算</h2>
		
		<table> 
		<tr> 
		<td width="11%" class="tdlabel tdleft tdbottom">结算单号:</td>
		<td width="15%" class="tdcontent">«settlement.sid»</td> 
		<td width="11%" class="tdlabel tdleft tdbottom">开始时间:</td> 
		<td width="20%" class="tdcontent">« new SimpleDateFormat("yyyy-MM-dd").format(settlement.fromDate)»</td> 
		<td width="11%" class="tdlabel tdleft tdbottom">结束时间:</td> 
		<td width="31%" class="tdcontent">« new SimpleDateFormat("yyyy-MM-dd").format(settlement.toDate)»</td> 
		</tr> 
		
		</table>
		
		<table  class="tableLL">
		
		<thead>
		<tr>
		<th width="10%" >服务单号</td>
		<th width="14%" >使用部门</td>  
		<th width="10%" >维修班组</td>
		<th width="10%" >材料名称</td> 
		<th width="10%" >规格</td> 
		<th width="5%" >单位</td> 
		<th width="8%" >单价（元）</td> 
		<th width="8%" >数量</td> 
		<th width="15%" >物品批号</td> 
		</tr> 
		</thead>
		<tbody>
		
		
		«FOR repairReportItem:settlement.allItems»
		«var storageSize = repairReportItem.storage.size»
		
		«FOR item:repairReportItem.storage.iteratorWithIndex»
		<tr>
		«IF item.index==0»
		<td rowspan=«storageSize»>«repairReportItem.reportSid»</td> 
		<td rowspan=«storageSize» >«repairReportItem.reportOrg.entityName»</td>
		«ENDIF»
		<td>«item.value.workItem.groupTask.team.entityName»</td> 
		<td>«item.value.productEntry.entityName»</td> 
		<td>«item.value.productEntry.productSpec.typeDesc»</td> 
		<td>«item.value.productEntry.productSpec.unit.entityName»</td> 
		<td class="tdright">«item.value.productEntry.price»</td> 
		<td class="tdright">«item.value.quantity»</td> 
		<td>«item.value.productEntry.sid»</td> 
		
		</tr> 
		«ENDFOR»
		«ENDFOR»
		<tr>
		<th colspan= 6>总结算金额</th> 
		<th colspan= 3>«settlement.totalAmount»元</th> 
		</tr> 
		</toby>
		</table>
		<table>
		<tr> 
		<td width="40%" class="tdlabel tdleft tdbottom">&nbsp;</td>
		<td width="12%" class="tdlabel tdleft tdbottom">工程负责人:</td> 
		<td width="18%" class="tdcontent">&nbsp;</td> 
		<td width="12%" class="tdlabel tdleft tdbottom">院方签字:</td> 
		<td width="18%" class="tdcontent">&nbsp;</td>  
		</tr> 
		</table>
		</body> 
		</html>
				
		'''
	}
	
}