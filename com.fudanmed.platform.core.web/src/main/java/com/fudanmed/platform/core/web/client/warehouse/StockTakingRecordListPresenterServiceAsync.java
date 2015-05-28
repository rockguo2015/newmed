package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCStockTakingRecordProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingRecordCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingRecordItem;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import java.util.Collection;

public interface StockTakingRecordListPresenterServiceAsync {
  public abstract void filter(final UIStockTakingRecordCriteria uicriteria, final AsyncCallback<IPagedResult<UIStockTakingRecord>> callback);
  
  public abstract void delete(final RCStockTakingRecordProxy value, final AsyncCallback<Void> callback);
  
  public abstract void loadDetails(final RCStockTakingRecordProxy parent, final AsyncCallback<Collection<UIStockTakingRecordItem>> callback);
  
  public abstract void loadStockTakingRecordInfo(final RCStockTakingRecordProxy record, final AsyncCallback<UIStockTakingRecord> callback);
}
