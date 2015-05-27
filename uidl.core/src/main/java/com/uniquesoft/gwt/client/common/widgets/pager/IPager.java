package com.uniquesoft.gwt.client.common.widgets.pager;

import java.util.Collection;

import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import com.google.gwt.user.client.ui.Widget;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

/**
 * 
 * @author ztiange
 * 
 */
public interface IPager<V> {

	public interface GotoPageHandler {
		void gotoPage(int pageNum, int recordsPerPage);
	}

	public void pageLoaded(Collection<V> result, int pageNum, long totalRecords);

	public void pageLoaded(IPagedResult<V> result);

	void setPagerHandler(GotoPageHandler handler);

	void refresh();

	void gotoPage(int page);

	void gotoPage(int page, final Procedure1<? super Void> callback);

	void setPageSize(int recordsPerPage);

	int getPageSize();

	int getActivePage();

	void setActivePage(int activePage);

	Widget asWidget();

}
