package edu.fudan.mylang.pf;

import edu.fudan.mylang.pf.IModelObject;

public interface IHasHierarchy extends IModelObject {
	
	Iterable<IHasHierarchy> getHierarchyChildren();

	IHasHierarchy getHierarchyParent();
	
	void setHierarchyParent(IHasHierarchy newParent);
	
	String getFullIdPath();
	
	IHasHierarchy setFullIdPath(String idPath);
	
}
