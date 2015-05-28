package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCTransferRecordProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UITransferRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UITransferRecordCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UITransferRecordItem;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import java.util.Collection;

public interface TransferRecordListPresenterServiceAsync {
  public abstract void generatePrintContents(final RCTransferRecordProxy record, final AsyncCallback<String> callback);
  
  public abstract void filter(final UITransferRecordCriteria uicriteria, final AsyncCallback<IPagedResult<UITransferRecord>> callback);
  
  public abstract void delete(final RCTransferRecordProxy value, final AsyncCallback<Void> callback);
  
  public abstract void loadDetails(final RCTransferRecordProxy parent, final AsyncCallback<Collection<UITransferRecordItem>> callback);
}
