package edu.fudan.mylang.pf.util

class PathBuilder {
	
	def static <T> buildPath(T t, (T)=>T parentCalculator,(T)=>String pathNodeBuilder){
		val result = newArrayList(pathNodeBuilder.apply(t))
		var curRoot = parentCalculator.apply(t)
		while(curRoot!=null){
			result.add(pathNodeBuilder.apply(curRoot))
			curRoot = parentCalculator.apply(curRoot)
		}
		result
	}
	
	def static <T> visit(T t,(T)=>Iterable<T> getChildren, (T)=>void visitor){
		visitor.apply(t)
		getChildren.apply(t)?.forEach[
			visit(it,getChildren,visitor)
		]
	}
	
}