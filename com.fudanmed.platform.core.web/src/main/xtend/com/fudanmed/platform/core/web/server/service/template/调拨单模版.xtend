package com.fudanmed.platform.core.web.server.service.template

import com.fudanmed.platform.core.web.server.service.warehouse.TransferRecordItemMapper
import com.fudanmed.platform.core.warehouse.RCTransferRecord
import com.fudanmed.platform.core.common.RCSystemParameter
import java.text.SimpleDateFormat

class TransferTemplate {
	def static String template(RCTransferRecord value, RCSystemParameter parameter, TransferRecordItemMapper itemMapper){
'''
<html> 
<head> 
<title>调拨单</title> 
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

<h2 style="width:21cm;text-align:center;font-family:Arial,Microsoft YaHei,SimHei,SimSun;" >«parameter.orgName»调拨单</h2>
<table> 
<tr> 
<td width="11%" class="tdlabel tdleft tdbottom">调拨单号:</td>
<td width="15%" class="tdcontent">«value.sid»</td> 
<td width="11%" class="tdlabel tdleft tdbottom">调拨时间:</td> 
<td width="20%" class="tdcontent">«new SimpleDateFormat("yyyy-MM-dd").format(value.date)»</td> 
<td width="11%" class="tdlabel tdleft tdbottom">调入仓库:</td> 
<td width="31%" class="tdcontent">«value.targetStore.entityName»</td> 
</tr> 
<tr> 
<td width="11%" class="tdlabel tdleft tdbottom">调出仓库:</td>
<td width="15%" class="tdcontent">«value.sourceStore.entityName»</td> 
<td width="11%" class="tdlabel tdleft tdbottom">操作员:</td> 
<td width="20%" class="tdcontent">«value.operator.entityName»</td> 
<td width="11%" class="tdlabel tdleft tdbottom">备注:</td> 
</tr> 

</table>

<table  class="tableLL">

<thead>
<tr>
<th width="15%" >入库批号</td>
<th width="14%" >条码</td>  
<th width="10%" >物品编号</td>
<th width="10%" >物品</td> 
<th width="10%" >规格型号</td> 
<th width="10%" >品牌</td> 
<th width="8%" >单价（元）</td> 
<th width="8%" >数量</td> 
<th width="5%" >单位</td> 

</tr> 
</thead>
<tbody>

«FOR record:value.items.map[itemMapper.transform(it)]»
<tr>
<td>«record.sid»</td> 
<td>«record.productSid»</td>
<td>«record.materialId»</td> 
<td>«record.productEntry.name»</td> 
<td>«record.typeDesc»</td> 
<td>«record.brand.name»</td> 
<td class="tdright">«record.price»</td> 
<td class="tdright">«record.quantity»</td> 
<td>«record.unit.name»</td> 
</tr> 
«ENDFOR»
<tr>
<td>&nbsp;</td> 
<td>&nbsp;</td> 
<td>&nbsp;</td> 
<td>&nbsp;</td> 
<td>&nbsp;</td> 
<td>&nbsp;</td> 
<td>&nbsp;</td> 
<td>&nbsp;</td> 
<td>&nbsp;</td>
</tr> <tr>
<td>&nbsp;</td> 
<td>&nbsp;</td> 
<td>&nbsp;</td> 
<td>&nbsp;</td> 
<td>&nbsp;</td> 
<td>&nbsp;</td> 
<td>&nbsp;</td> 
<td>&nbsp;</td> 
<td>&nbsp;</td>
</tr> 
</toby>
</table>




<table>
<tr> 
<td width="30%" class="tdlabel tdleft tdbottom">&nbsp;</td>
<td width="17%" class="tdlabel tdleft tdbottom">调出仓库仓管员:</td> 
<td width="18%" class="tdcontent">&nbsp;</td> 
<td width="17%" class="tdlabel tdleft tdbottom">调入仓库仓管员:</td> 
<td width="18%" class="tdcontent">&nbsp;</td>  
</tr> 
</table>







</body> 
</html>

'''.toString		
	}
}