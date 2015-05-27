package com.fudanmed.platform.core.web.server.service.template

import com.fudanmed.platform.core.web.shared.project.UIRepairTask
import java.text.SimpleDateFormat
import java.util.Collection
import static extension com.uniquesoft.gwt.shared.extensions.StringExtensions.*
class EBoardTemplate {
	def static template(Integer curPage, Integer totalPage,String message,Collection<UIRepairTask> tasks){
		'''

<table width="1024px" align="center" id="Table1" border="0" cellspacing="0" cellpadding="0" bgcolor=black>
<tr height="73" >
   <td width="974px" align="left" colspan=2 style="color:#ffffff; font-size:200%;"><IMG  src="images/eboard/logo.png">上海复旦医院后勤服务有限公司</td>
</tr>
<tr height="35">
	<td width="974px"  align="center" background="images/eboard/green.jpg"  valign="middle" colspan=2 style="color:#ffffff; font-size:120%;"><B> 当前报修项目实时状态</B></td>
</tr>
<tr height="400">
<td width="974px" id ="right" colspan=2 style="padding-left:5px;" valign='top'>
    <TABLE  width="100%" border="0" cellspacing="0" cellpadding="0">
		<TR>
	          <TD width="100%" align="center" valign="top"><div  style="margin:2px；align:left;width:95%;height:95%;text-align:left">
	          		<TABLE width="100%" align="center"  style="font-size:15px;"
	                        border="0" >
						<tr style="font-size:150%;font-weight:bold;color:red">
							<th width="15%" style="border-bottom:#00ff00 dotted thin;text-align:left;">报修时间</th>
							<th width="19%" style="border-bottom:#00ff00 dotted thin;text-align:left;">报修科室</th>
							<th width="8%" style="border-bottom:#00ff00 dotted thin;text-align:left;">状态</th>
							<th width="15%" style="border-bottom:#00ff00 dotted thin;text-align:left;">维修班组</th>
							<th width="11%" style="border-bottom:#00ff00 dotted thin;text-align:left;">维修人</th>
							<th width="18%" style="border-bottom:#00ff00 dotted thin;text-align:left;">报修内容</th>
							<th width="14%" style="border-bottom:#00ff00 dotted thin;font-size:80%;color:#dddddd">第«curPage»页共«totalPage»页</th>
						</tr>
						«FOR task:tasks»
						«IF task.isTimeOut»
                        <TR style="color:orange;font-size:125%">
                        «ELSE»
                        <TR style="color:white;font-size:125%">
                        «ENDIF»
                          <TD height="40" style="border-bottom:#00ff00 dotted thin;text-align:left;">
                          	«new SimpleDateFormat("yyyy-MM-dd HH:mm").format(task.reportTime)»
                          </TD>
                          <TD height="40" style="border-bottom:#00ff00 dotted thin;text-align:left;">
                          	«task.reportOrg?.name?.abbreviate(14)»
                          </TD>
                          <TD height="40" style="border-bottom:#00ff00 dotted thin;text-align:left;">
                          	«task.status»
                          </TD>
                          <TD height="40" style="border-bottom:#00ff00 dotted thin;text-align:left;">
                          	«task.activeTeam?.name»
                          </TD>
                          <TD height="40" style="border-bottom:#00ff00 dotted thin;text-align:left;">
                          	«task.abbtActiveWorkers»
                          </TD>
                          <TD height="40" style="border-bottom:#00ff00 dotted thin;text-align:left;" colspan=2>
                          	«task.comment.abbreviate(20)»
                          </TD>
                        </TR>
						«ENDFOR»
							
	            	</TABLE>
	                      
			</TD>
	    </TR>
    </TABLE>
</td>
</tr>
<tr height="242">
<td width="300px" id ="left">
      <TABLE  width="100%" border="0" cellspacing="0" cellpadding="0">
        <TR>
           <TD width="100%" height="32" align="center" >
           		<div  style="padding-top: 5px;width:280px;background-image:url(images/eboard/bj_green.jpg);" ><b style="font-size:120%">重要通知</b></div>
           </TD>
        </TR>
	<TR>
          <TD width="100%" height="312" align="center" id="TD1"  valign="top" >
          <marquee direction='up' scrollamount='1' scrolldelay='10' width='280' height='130' style="padding:3px;color:orange">
          «message»
          </marquee>
          </TD>
        </TR>
      </TABLE>                
</td>
<td width="760px" id ="right" style="padding-left:5px;">
    <TABLE  width="100%" border="0" cellspacing="0" cellpadding="0">
		<TR>
	          <TD width="100%" height="139" align="center" ><IMG height="108" src="images/eboard/left.jpg"><IMG src="images/eboard/ban.jpg"></TD>                
	    </TR>
    </TABLE>
</td>
</tr>
</table>		
		'''.toString
	}
}