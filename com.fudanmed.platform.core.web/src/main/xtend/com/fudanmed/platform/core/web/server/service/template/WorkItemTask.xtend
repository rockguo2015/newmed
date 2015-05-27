package com.fudanmed.platform.core.web.server.service.template

import com.fudanmed.platform.core.domain.RCWorkItemTask
import com.fudanmed.platform.core.warehouse.RCWorkItemOutStockRecord
import java.text.SimpleDateFormat

import static com.fudanmed.platform.core.web.server.service.template.Template.*
import com.fudanmed.platform.core.common.RCSystemParameter

//«»			
class Template {
	
	def static nullsafe(String s){
		if(s==null)"&nbsp;"else s
	}
	
	def static String workItem(RCWorkItemTask workItemTask, RCSystemParameter parameter){
		'''
			<html> 
			<head> 
			<title>worksheet</title> 
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
			
			.tddiv
			{
			border:2px solid #000000;
			}
			
			.divLL/*绝对定位*/
			{
			position:absolute;
			left:7.3cm;
			top:5.6cm;
			width:15cm;
			height:4cm;
			}
			.tableLL
			{
			 width:100%;
			 border:2px solid #000000;
			 border-collapse:collapse;
			 }
			
			.tableLL th
			{
			  border:2px solid #000000;
			 
			  padding-top:3px;
			  padding-bottom:3px;
			 }
			
			.tableLL td
			{
			 border:2px solid #000000;
			 padding:3px 7px 2px 7px;
			 font-size: 10pt;
			 }
			
			
			
			
			
			</style> 
			
			</head> 
			
			<body > 
			
			<h2 style="width:21cm;text-align:center;font-family:Arial,Microsoft YaHei,SimHei,SimSun;">«parameter.orgName»维修服务单</h2>
			<table> 
			<tr> 
			<td width="11%" class="tdlabel tdleft tdbottom">报修单号:</td><!--就是工单号以下是报修单-->
			<td width="15%" class="tdcontent">«workItemTask.groupTask.repairTask.reportSid»</td> 
			<td width="11%" class="tdlabel tdleft tdbottom">报修时间:</td> 
			<td width="20%" class="tdcontent">« new SimpleDateFormat("yyyy-MM-dd HH:mm").format(workItemTask.groupTask.repairTask.reportTime)»</td> 
			<td width="11%" class="tdlabel tdleft tdbottom">报修科室:</td> 
			<td width="31%" class="tdcontent">«nullsafe(workItemTask.groupTask.repairTask.reportOrg?.entityName)»</td> <!--科室+报修地点-->
			</tr> 
			
			<tr> 
			<td class="tdlabel tdleft tdbottom">调度人员:</td> 
			<td class="tdcontent">«workItemTask.groupTask.operator.entityName»</td> 
			<td class="tdlabel tdleft tdbottom">维修班组:</td> 
			<td class="tdcontent">«nullsafe(workItemTask.groupTask.team?.entityName)»</td> 
			<td class="tdlabel tdleft tdbottom">维修人员:</td> 
			<td class="tdcontent">«FOR p:workItemTask.workers SEPARATOR ','»«p.entityName»«ENDFOR»</td> 
			</tr> 
			<tr>
			<td  class="tdlabel tdleft tdbottom">报修来源:</td> 
			<td  class="tdcontent">«nullsafe(workItemTask.groupTask.repairTask.faultReportSource?.entityName)»</td> 
			<td  class="tdlabel tdleft tdbottom">报修人:</td> 
			<td  class="tdcontent">«nullsafe(workItemTask.groupTask.repairTask.reporterName)+'&nbsp;'+nullsafe(workItemTask.groupTask.repairTask.reporterPhone)»</td> <!--科室+报修地点-->
			<td  class="tdlabel tdleft tdbottom">报修地点:</td> 
			<td  class="tdcontent">«nullsafe(workItemTask.groupTask.repairTask.location)»</td> <!--科室+报修地点-->
			</tr>
			</table>
			
			<table> 
			<tr> 
			<td width="11%" class="tdlabel tdleft tdtop" rowspan=3>报修类别:</td>
			<td width="19%" class="tddiv tdleft tdtop"rowspan=3>
				«nullsafe(workItemTask.groupTask.repairTask.faultType?.entityName)»«if(workItemTask.groupTask.repairTask.faultType.needAudit)"(需审批)"else""»
			</td> 
			<td class="tdlabel tdcenter tdtop"width="38%">材料使用</td> 
			<td width="15%" class="tdlabel tdright tdtop">仓管员：</td> 
			<td width="22%" class="tdcontent">&nbsp;</td> 
			</tr> 
			<tr> <td colspan=3>&nbsp;</td> </tr> 
			<tr> <td colspan=3>&nbsp;</td> </tr> 
			<tr> 
			<td  class="tdlabel tdleft tdtop" rowspan=5>报修内容:</td>
			<td  class="tddiv tdleft tdtop"rowspan=5>«nullsafe(workItemTask.groupTask.repairTask.comment)»</td> 
			<td>&nbsp;</td>			
			</tr> 
			<tr > <td colspan=3>&nbsp;</td> </tr> 
			<tr> <td colspan=3>&nbsp;</td> </tr> 
			<tr> <td colspan=3>&nbsp;</td> </tr> 
			<tr> <td colspan=3>&nbsp;</td> </tr> 
			<table>
			
			<table> 
			<tr> 
			<td width="11%" class="tdlabel tdright tdbottom">工单编号：</td> 
			<td width="19%" class="tdcontent">«nullsafe(workItemTask.sid)»</td> 
			<td width="15%" class="tdlabel tdleft tdbottom">到达时间:</td>
			<td width="19%" class="tdcontent">&nbsp;</td> 
			<td width="15%" class="tdlabel tdleft tdbottom">完成时间:</td> 
			<td width="22%" class="tdcontent">&nbsp;</td> 
			</tr> 
			<tr> 
			<td class="tdlabel tdleft tdtop" rowspan=5>院方意见：</td>
			<td class="tddiv tdright tdbottom" rowspan=5>签字：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> 
			<td class="tdlabel tdtop">&nbsp;</td> 
			<td class="tdlabel tdright tdbottom" >维修内容:&nbsp;&nbsp;</td> 
			<td class="tddiv tdleft tdtop" rowspan=5 colspan=2>&nbsp;</td>
			</tr> 
			<tr> 
			<td>&nbsp;</td> 
			<td>&nbsp;</td> 
			</tr> 
			
			<tr> 
			<td>&nbsp;</td> 
			<td>&nbsp;</td> 
			</tr> 
			<tr> 
			<td  width class="tdlabel tdleft tdbottom">工程部负责人:</td> 
			<td class="tdcontent">&nbsp;</td>
			</tr> 
			</table> 
			
			
			<div class="divLL">
			<table  class="tableLL">
			<tr>
			<th width="23%" >材料名称</td> 
			<th width="28%" >规格</td> 
			<th width="9%" >数量</td> 
			<th width="8%" >单位</td> 
			<th width="15%" >单价(元)</td> 
			<th width="17%" >金额(元)</td> 
			</tr> 
			
			<tr>
			<td>&nbsp;</td> 
			<td>&nbsp;</td> 
			<td>&nbsp;</td> 
			<td>&nbsp;</td> 
			<td>&nbsp;</td> 
			<td>&nbsp;</td> 
			</tr> 
			<tr>
			<td>&nbsp;</td> 
			<td>&nbsp;</td> 
			<td>&nbsp;</td> 
			<td>&nbsp;</td> 
			<td>&nbsp;</td> 
			<td>&nbsp;</td> 
			</tr> 
			<tr>
			<td>&nbsp;</td> 
			<td>&nbsp;</td> 
			<td>&nbsp;</td> 
			<td>&nbsp;</td> 
			<td>&nbsp;</td> 
			<td>&nbsp;</td> 
			</tr> 
			<tr>
			<td>&nbsp;</td> 
			<td>&nbsp;</td> 
			<td>&nbsp;</td> 
			<td>&nbsp;</td> 
			<td>&nbsp;</td> 
			<td>&nbsp;</td> 
			</tr> 
			<tr>
			<td>&nbsp;</td> 
			<td>&nbsp;</td> 
			<td>&nbsp;</td> 
			<td>&nbsp;</td> 
			<td>&nbsp;</td> 
			<td>&nbsp;</td> 
			</tr> 
			<tr>
			<th colspan= 5>费用合计</th> 
			<th>&nbsp;</th> 
			</tr> 
			</table>
			
			
			</div>
			
			</body> 
			</html>
					
		'''
	}
	def static String workItem1(  RCWorkItemTask workItemTask, RCSystemParameter parameter) {
		'''
			<html> 
			<head> 
			<title>worksheet</title> 
			<meta http-equiv="Content-Type" content="text/html; charset=gb2312"> 
			
			<style> 
			
			
			td{
			/*font-family: "宋体";*/ 
			font-size: 10pt; 
			padding-bottom:10px;
			}
			
			.tdlabeltop 
			{ 
			border-style:none; 
			text-align:left;
			vertical-align:top;
			padding:5px;
			font-weight:bold;
			} 
			.tdlabelbottom 
			{ 
			border-style:none; 
			text-align:left;
			vertical-align:bottom;
			padding:5px;
			font-weight:bold;
			} 
			.tdcontent
			{
			border-style:none;
			border-bottom:1px solid #000000;
			text-align:center;
			vertical-align:bottom;
			padding:5px;
			}
			.tddivtop
			{
			border:1px solid #000000;
			text-align:left;
			vertical-align:top;
			padding:5px;
			margin:5px;
			}
			
			.tdlabelbottomright 
			{ 
			border-style:none; 
			text-align:right;
			vertical-align:bottom;
			padding:5px;
			font-weight:bold;
			} 
			
			.tddivbottom
			{
			border:1px solid #000000;
			text-align:right;
			vertical-align:bottom;
			padding:5px;
			margin:5px;
			}
			
			</style> 
			
			</head> 
			
			<body > 
			
			<center><h2>«parameter.orgName»维修服务单</h2></center>
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
			<td class="tdlabelbottom">调度人员:</td> 
			<td class="tdcontent">«workItemTask.groupTask.operator.entityName»</td> 
			<td class="tdlabelbottom">报修人:</td> 
			<td class="tdcontent">«nullsafe(workItemTask.groupTask.repairTask.reporter?.entityName)»</td> 
			<td class="tdlabelbottom">联系电话:</td> 
			<td class="tdcontent">«nullsafe(workItemTask.groupTask.repairTask.reporter?.phone)»</td> 
			</tr> 
			
			<tr> 
			<td class="tdlabelbottom">报修地点:</td> 
			<td colspan=5 class="tdcontent">«nullsafe(workItemTask.groupTask.repairTask.location)»</td> 
			</tr> 
			
			<tr> 
				<td  colspan=6 width="100%"> 
					<table width="100%" cellpadding="0" cellspacing="0" >
					<tr height="150px"> 
						<td width="15%" class="tdlabeltop">报修类别:</td> 
						<td width="30%" class="tddivtop">«nullsafe(workItemTask.groupTask.repairTask.faultType?.entityName)»</td>
						<td width="15%" class="tdlabeltop" >报修内容:</td> 
						<td width="40%" class="tddivtop" >«nullsafe(workItemTask.groupTask.repairTask.comment)»</td>
					</tr>
					</table>
				</td>
			</tr>
			
			<tr> 
				<td class="tdlabelbottom">工单号:</td> 
				<td class="tdcontent">«nullsafe(workItemTask.sid)»</td> 
				<td class="tdlabelbottom">维修班组:</td> 
				<td class="tdcontent">«nullsafe(workItemTask.groupTask.team?.entityName)»</td> 
				<td class="tdlabelbottom">到达时间:</td> 
				<td class="tdcontent">&nbsp;</td> 
			</tr> 
			
			<tr> 
				<td class="tdlabelbottom">维修人员:</td> 
				<td colspan="3" class="tdcontent">«FOR p:workItemTask.workers SEPARATOR ','»«p.entityName»«ENDFOR»</td> 
				<td class="tdlabelbottom">完成时间:</td> 
				<td class="tdcontent">&nbsp;</td> 
			</tr> 
			<tr> 
				<td class="tdlabeltop">维修说明:</td> 
				<td class="tddivtop" colspan=5 height="120px">&nbsp;</td> 
			</tr> 
			<tr> 
				<td class="tdlabeltop">院方意见:</td> 
				<td class="tddivbottom" colspan=5 height="120px">签字：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> 
			</tr> 
			<tr> 
				<td class="tdlabelbottom" colspan=6>&nbsp;</td> 
			</tr>  
			<tr> 
				<td class="tdlabelbottom" colspan=3>&nbsp;</td> 
				<td class="tdlabelbottomright"colspan=2 >工程部负责人:</td> 
				<td class="tdcontent">&nbsp;</td>
			</tr>  
			</table>
			
			</body> 
			</html>

		'''.toString
	}
	
	def static String workItemOutStockFit(RCWorkItemOutStockRecord record){
		
		val p1 = '''
			<html> 
			<head> 
			<title> </title> 
			<meta http-equiv="Content-Type" content="text/html; charset=gb2312"> 
			
			
			<style> 
			
			table
			  {
			    border:0px solid black;
			    width:22cm;
			    
			    border-spacing:0px 7px;
			
			  }
			
			td,th{
			font-size: 12pt; 
			font-family:Arial,Microsoft YaHei,SimHei,SimSun;;
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
			
			.tddiv
			{
			border:1px solid #aaaaaa;
			}
			
			.divLL/*绝对定位*/
			{
			position:absolute;
			left:7.3cm;
			top:6.4cm;
			width:15cm;
			height:4cm;
			}
			.tableLL
			{
			 width:100%;
			 border:0px solid #000000;
			 border-collapse:collapse;
			 }
			
			.tableLL th
			{
			  border:0px solid #000000;
			  font-weight:bold;
			  padding-top:3px;
			  padding-bottom:3px;
			 }
			
			.tableLL td
			{
			  border:0px solid #000000;
			  padding:3px 7px 2px 7px;
			
			
			 }
			</style> 
			
			</head> 
			
			<body > 
			
			
			
			<div class="divLL">
			<table  class="tableLL">
	
			«FOR item:record.items»
			<tr>
			<td width="23%" class="tdleft">«nullsafe(item.recordItem.productEntry.productSpec.entityName)»</td> 
			<td width="28%"class="tdcenter">«nullsafe(item.recordItem.productEntry.productSpec.typeDesc)»</td> 
			<td width="9%"class="tdright">«nullsafe(item.recordItem.quantity.toString)»</td> 
			<td width="8%"class="tdcenter">«nullsafe(item.recordItem.productEntry.productSpec.unit?.entityName)»</td> 
			<td width="15%"class="tdright">«nullsafe(item.recordItem.productEntry.price.toString)»</td> 
			<td width="17%"class="tdright">«nullsafe((item.recordItem.totalAmount).toString)»</td> 
			</tr> 
			«ENDFOR»
	'''
	var p2 = ""
	var i = record.items.size
	while(i < 5){
		p2 = p2 + 
			'
			<tr>
			<td width="23%" class="tdleft">&nbsp;</td> 
			<td width="28%"class="tdcenter">&nbsp;</td> 
			<td width="9%"class="tdright">&nbsp;</td> 
			<td width="8%"class="tdcenter">&nbsp;</td> 
			<td width="15%"class="tdright">&nbsp;</td> 
			<td width="17%"class="tdright">&nbsp;</td> 
			</tr> 
			'
		i = i + 1
	}
	val p3 ='''
			<tr>
			<th colspan=5>&nbsp;</th> 
			<td class="tdright">«nullsafe((record.totalAmount).toString)»</td> 
			 
			</tr> 
			</table>
			
			
			</div>
			
			</body> 
			</html>
		'''
		
		p1.toString+p2.toString+p3.toString
	}
	
	def static String workItemOutStock(RCWorkItemOutStockRecord record, RCSystemParameter parameter) {
		val workItemTask = record.workItem
		'''
			<html> 
			<head> 
			<title>领料单</title> 
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
			
			<center><h2 style="width:21cm;text-align:center;font-family:Arial,Microsoft YaHei,SimHei,SimSun;" >«parameter.orgName»维修服务单-领料单</h2></center>
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