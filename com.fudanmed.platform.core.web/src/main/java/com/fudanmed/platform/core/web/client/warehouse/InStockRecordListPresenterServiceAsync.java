package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCInStockRecordProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIInStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIInStockRecordCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIInStockRecordItem;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import java.util.Collection;

public interface InStockRecordListPresenterServiceAsync {
  public abstract void generatePrintContent(final RCInStockRecordProxy inStockRecord, final AsyncCallback<String> callback);
  
  public abstract void filter(final UIInStockRecordCriteria uicriteria, final AsyncCallback<IPagedResult<UIInStockRecord>> callback);
  
  public abstract void delete(final RCInStockRecordProxy value, final AsyncCallback<Void> callback);
  
  public abstract void loadDetails(final RCInStockRecordProxy parent, final AsyncCallback<Collection<UIInStockRecordItem>> callback);
  
  public abstract void loadInStockRecordInfo(final RCInStockRecordProxy record, final AsyncCallback<UIInStockRecord> callback);
}
