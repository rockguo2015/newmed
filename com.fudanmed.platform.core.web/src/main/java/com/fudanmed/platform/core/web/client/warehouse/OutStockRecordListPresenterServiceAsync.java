package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCOutStockRecordProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIOutStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIOutStockRecordCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIOutStockRecordItem;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import java.util.Collection;

public interface OutStockRecordListPresenterServiceAsync {
  public abstract void generatePrintContents(final RCOutStockRecordProxy record, final AsyncCallback<String> callback);
  
  public abstract void filter(final UIOutStockRecordCriteria uicriteria, final AsyncCallback<IPagedResult<UIOutStockRecord>> callback);
  
  public abstract void delete(final RCOutStockRecordProxy value, final AsyncCallback<Void> callback);
  
  public abstract void loadDetails(final RCOutStockRecordProxy parent, final AsyncCallback<Collection<UIOutStockRecordItem>> callback);
  
  public abstract void loadOutStockRecordInfo(final RCOutStockRecordProxy record, final AsyncCallback<UIOutStockRecord> callback);
}
