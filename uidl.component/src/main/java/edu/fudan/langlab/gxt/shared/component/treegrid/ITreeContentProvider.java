package edu.fudan.langlab.gxt.shared.component.treegrid;

public interface ITreeContentProvider<M> {
	
	Iterable<M> getRootElements(Iterable<M> allElements);

	Iterable<M> getChildren(M parent, Iterable<M> allElements);

}
