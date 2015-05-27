package com.fudanmed.platform.core.web.server.service.template

import com.fudanmed.platform.core.warehouse.RCStockTakingList
import java.text.SimpleDateFormat
import static extension com.uniquesoft.gwt.shared.extensions.Collections3.*
import com.fudanmed.platform.core.common.RCSystemParameter

class StockTakingTemplate {
	
	def static String template(RCStockTakingList stockTaking, RCSystemParameter parameter){
	'''
<html> 
<head> 
<title>盘点单</title> 
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
  width:22cm;/*只有这个和报修单设置的不同*/
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

<h2 style="width:21cm;text-align:center;font-family:Arial,Microsoft YaHei,SimHei,SimSun;" >«parameter.orgName»工程仓库盘点单</h2>
<table> 
<tr> 
<td width="10%" class="tdlabel tdleft tdbottom">盘点单号:</td>
<td width="25%" class="tdcontent">«stockTaking.stockTakingRecord?.sid»</td> 
<td width="10%" class="tdlabel tdleft tdbottom">盘点仓库:</td> 
<td width="25%" class="tdcontent">«stockTaking.warehouse.entityName»</td> 
<td width="10%" class="tdlabel tdleft tdbottom">盘点时间:</td> 
<td width="20%" class="tdcontent">« new SimpleDateFormat("yyyy-MM-dd").format(stockTaking.date)»</td> 
</tr> 

</table>

<table  class="tableLL">

<thead>
<tr>
<th width="15%" >材料名称</td>
<th width="20%" >条码</td>  
<th width="10%" >规格</td>
<th width="10%" >单位</td> 
<th width="10%" class="tdright">账载数</td> 
<th width="10%" >实盘数</td> 
<th width="10%" >差异</td> 
<th width="15%" >备注</td> 
</tr> 
</thead>
<tbody>
«FOR item:stockTaking.items»
<tr>
<td>«item.productSpec.entityName»</td> 
<td>«item.productSpec.sid»</td> 
<td>«item.productSpec.typeDesc»</td> 
<td>«item.productSpec.unit?.entityName»</td> 
<td class="tdright">«item.realQuantity»</td> 
<td>&nbsp;</td> 
<td>&nbsp;</td> 
<td>&nbsp;</td> 
</tr>  
«ENDFOR»
</toby>
</table>




<table>
<tr> 
<td width="40%" class="tdlabel tdleft tdbottom">&nbsp;</td>
<td width="12%" class="tdlabel tdleft tdbottom">盘点员:</td> 
<td width="18%" class="tdcontent">&nbsp;</td> 
<td width="12%" class="tdlabel tdleft tdbottom">仓库管理员:</td> 
<td width="18%" class="tdcontent">&nbsp;</td>  
</tr> 
</table>







</body> 
</html>
	
	'''	
	}
	
}