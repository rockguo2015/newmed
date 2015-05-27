package com.fudanmed.platform.core.web.client.names

import com.fudanmed.platform.core.web.shared.device.UIDevice
import com.fudanmed.platform.core.web.shared.project.UIFaultType
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecificationSummary
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorage
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummary
import com.uniquesoft.gwt.shared.GWTNamedEntity
import com.fudanmed.platform.core.web.shared.project.UIWorker
import com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition

class ObjectNameService extends edu.fudan.langlab.uidl.domain.app.client.names.ObjectNameService{
	
	def dispatch internalGetId(UIWorker o){
		o.id.toString
	}

	def dispatch String internalGetName(UIWorker o){
		o.name
	}
	def dispatch internalGetId(UIFaultType o){
		o.id.toString
	}

	def dispatch String internalGetName(UIFaultType o){
		o.name
	}
	def dispatch internalGetId(UIProductWarehouseStorage o){
		o.id.toString
	}
	def dispatch String internalGetName(UIProductWarehouseStorage o){
		o.name + " 条码编号:" + o.productSpecsSid + " 规格型号：" + o.typeDesc + " 生产批号：" + o.sid 
	}
	def dispatch internalGetId(UIProductSpecificationSummary o){
		o.productSpec.id.toString
	}
	def dispatch String internalGetName(UIProductSpecificationSummary o){
		o.productSpec.name + " 条码编号:" + o.sid + " 规格型号：" + o.typeDesc 
	}
	def dispatch internalGetId(UIProductWarehouseStorageSummary o){
		o.id.toString
	}
	def dispatch String internalGetName(UIProductWarehouseStorageSummary o){
		o.name + " 条码编号:" + o.productSpecsSid + " 规格型号：" + o.typeDesc 
	}
	def dispatch internalGetId(UIProductSpecification o){
		o.id.toString
	}
	def dispatch String internalGetName(UIProductSpecification o){
		o.name + "("+o.materialId+")"
	}
	def dispatch internalGetId(UIDevice o){
		o.id.toString
	}
	def dispatch String internalGetName(UIDevice o){
		o.sid + "名称:"+o.name
	}
	def dispatch internalGetId(UIOnsitePosition o){
		o.id.toString
	}
	def dispatch String internalGetName(UIOnsitePosition o){
		o.fullPath
	}
	override dispatch internalGetId(GWTNamedEntity o){
		o.id.toString
	}
	override dispatch String internalGetName(GWTNamedEntity o){
		o.name
	}
	
	
		
}