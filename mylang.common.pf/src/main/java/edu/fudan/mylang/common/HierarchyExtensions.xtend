package edu.fudan.mylang.common

import edu.fudan.mylang.pf.IHasHierarchy
import static extension edu.fudan.mylang.common.ObjectExtensions2.*


class HierarchyExtensions {
	
	def public static getIdPath(IHasHierarchy node){
		if(node==null) null
		else '['+node.^id+']'
	}

	def static updateFullIdPath( IHasHierarchy node){
		node.setFullIdPath(node.buildPath([getHierarchyParent],[getIdPath(it)]).^join())
	}

	def static String getFullNamePath(IHasHierarchy node,  (IHasHierarchy)=>String nameProvider){
		getFullNamePath(node,nameProvider," ")
	}
	
	def static String getFullNamePath( IHasHierarchy node , (IHasHierarchy)=>String nameProvider,  String seperator){
		node.buildPath([getHierarchyParent],[nameProvider.apply(it)]).^join(seperator)
	}
	
	def static Boolean isChildren( IHasHierarchy node,  IHasHierarchy testNode){
		testNode.fullIdPath.contains(getIdPath(node))
	}
	
	def static changeParent(IHasHierarchy node, IHasHierarchy newParent){
		node.setHierarchyParent(newParent)
		node.visit([getHierarchyChildren()],[updateFullIdPath(it)])
	}
	
}