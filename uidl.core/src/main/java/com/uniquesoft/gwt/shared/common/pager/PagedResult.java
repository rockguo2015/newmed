package com.uniquesoft.gwt.shared.common.pager;

import java.util.Collection;
import java.util.Iterator;

/**
 * 
 *
 * @param <V> thetype of the records that will be paged
 */
public class PagedResult<V> implements IPagedResult<V> {

	private long totalRecords;
	private Collection<V> results;
	private int page;
	
	public PagedResult(){
		
	}

	/**
	 * init the class, set the initial information about established page
	 * @param page the established page number
	 * @param totalRecords the total records number in this page
	 * @param results All the records in established page
	 */
	public PagedResult( int page, long totalRecords, Collection<V> results) {
		this.totalRecords = totalRecords;
		this.page = page;
		this.results = results;
	}

	/* (non-Javadoc)
	 * @see com.uniquesoft.gwt.shared.common.pager.IPagedResult#getResult()
	 */
	@Override
	public Collection<V> getResult() {
		return results;
	}

	/* (non-Javadoc)
	 * @see com.uniquesoft.gwt.shared.common.pager.IPagedResult#getTotalRecords()
	 */
	@Override
	public long getTotalRecords() {
		return totalRecords;
	}

	/* (non-Javadoc)
	 * @see com.uniquesoft.gwt.shared.common.pager.IPagedResult#getPage()
	 */
	@Override
	public int getPage() {
		return page;
	}

	public boolean add(V e) {
		return results.add(e);
	}

	public boolean addAll(Collection<? extends V> c) {
		return results.addAll(c);
	}

	public void clear() {
		results.clear();
	}

	public boolean contains(Object o) {
		return results.contains(o);
	}

	public boolean containsAll(Collection<?> c) {
		return results.containsAll(c);
	}

	public boolean equals(Object o) {
		return results.equals(o);
	}

	public int hashCode() {
		return results.hashCode();
	}

	public boolean isEmpty() {
		return results.isEmpty();
	}

	public Iterator<V> iterator() {
		return results.iterator();
	}

	public boolean remove(Object o) {
		return results.remove(o);
	}

	public boolean removeAll(Collection<?> c) {
		return results.removeAll(c);
	}

	public boolean retainAll(Collection<?> c) {
		return results.retainAll(c);
	}

	public int size() {
		return results.size();
	}

	public Object[] toArray() {
		return results.toArray();
	}

	public <T> T[] toArray(T[] a) {
		return results.toArray(a);
	}
	
	
}
