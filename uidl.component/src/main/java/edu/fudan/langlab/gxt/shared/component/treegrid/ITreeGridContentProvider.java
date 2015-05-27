package edu.fudan.langlab.gxt.shared.component.treegrid;


public interface ITreeGridContentProvider<M> {


	Iterable<M> getRootElements();

	Iterable<M> getChildren(M parent);
}
