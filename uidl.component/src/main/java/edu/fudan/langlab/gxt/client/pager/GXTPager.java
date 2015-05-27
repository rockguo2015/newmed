package edu.fudan.langlab.gxt.client.pager;

import java.util.Collection;

import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import com.google.common.collect.Lists;
import com.google.gwt.core.client.Callback;
import com.sencha.gxt.data.shared.loader.DataProxy;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.sencha.gxt.data.shared.loader.PagingLoadResultBean;
import com.sencha.gxt.data.shared.loader.PagingLoader;
import com.sencha.gxt.widget.core.client.toolbar.PagingToolBar;
import com.uniquesoft.gwt.client.common.widgets.ObjectListView;
import com.uniquesoft.gwt.client.common.widgets.pager.IPager;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

public class GXTPager<V> implements IPager<V> {

	private PagingToolBar toolbar = new PagingToolBar(30);
	protected ObjectListView<V> objectListView;
	protected Callback<PagingLoadResult<V>, Throwable> callback;

	public GXTPager(final ObjectListView<V> objectListView) {
		this.objectListView = objectListView;

		final PagingLoader<PagingLoadConfig, PagingLoadResult<V>> loader = new PagingLoader<PagingLoadConfig, PagingLoadResult<V>>(
				new DataProxy<PagingLoadConfig, PagingLoadResult<V>>() {

					@Override
					public void load(
							final PagingLoadConfig loadConfig,
							final Callback<PagingLoadResult<V>, Throwable> callback) {
						int targetPage = loadConfig.getOffset()
								/ loadConfig.getLimit() + 1;
						GXTPager.this.callback = callback;

						gotoPageHandler.gotoPage(targetPage,
								loadConfig.getLimit());
					}
				});
		toolbar.bind(loader);
	}

	@Override
	public void pageLoaded(Collection<V> result, int activePage,
			long totalRecords) {
		objectListView.setObjects(result);
		int offset = (int) (activePage - 1) * getPageSize();
		if (callback != null)
			callback.onSuccess(new PagingLoadResultBean<V>(Lists
					.newArrayList(result), (int) totalRecords, offset));
		if(uicallback!=null){
			uicallback.apply(null);
			uicallback = null;
		}
	}

	@Override
	public void pageLoaded(IPagedResult<V> result) {
		pageLoaded(result.getResult(), result.getPage(),
				result.getTotalRecords());

	}

	GotoPageHandler gotoPageHandler;

	@Override
	public void setPagerHandler(GotoPageHandler handler) {
		gotoPageHandler = handler;
	}

	@Override
	public void refresh() {
		toolbar.refresh();

	}

	@Override
	public void setPageSize(int recordsPerPage) {
		toolbar.setPageSize(recordsPerPage);
	}

	@Override
	public int getPageSize() {
		return toolbar.getPageSize();
	}

	@Override
	public int getActivePage() {
		return toolbar.getActivePage();
	}

	@Override
	public PagingToolBar asWidget() {
		return toolbar;
	}

	@Override
	public void setActivePage(int activePage) {
		toolbar.setActivePage(activePage);

	}

	@Override
	public void gotoPage(int page) {
		toolbar.setActivePage(page);
		toolbar.refresh();
		
	}
	Procedure1<? super Void> uicallback;
	@Override
	public void gotoPage(int page, Procedure1<? super Void> uicallback) {
		this.uicallback = uicallback;
		toolbar.setActivePage(page);
		toolbar.refresh();
		
	}
}
