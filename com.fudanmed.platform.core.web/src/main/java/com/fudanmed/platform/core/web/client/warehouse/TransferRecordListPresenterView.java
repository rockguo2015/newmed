package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCTransferRecordProxy;
import com.fudanmed.platform.core.web.client.warehouse.TransferRecordListView;
import com.fudanmed.platform.core.web.shared.warehouse.UITransferRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UITransferRecordCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UITransferRecordItem;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import java.util.Collection;

@ImplementedBy(value = TransferRecordListView.class)
public interface TransferRecordListPresenterView extends Viewer {
  public abstract void showResults(final IPagedResult<UITransferRecord> results);
  
  public abstract void showDetails(final Collection<UITransferRecordItem> details);
  
  public abstract void refresh();
  
  public abstract void transferRequest(final RequestHandler requestHandler);
  
  public abstract void filterRequest(final RequestHandler1<UITransferRecordCriteria> requestHandler);
  
  public abstract void showDetailRequest(final RequestHandler1<RCTransferRecordProxy> requestHandler);
  
  public abstract void print(final RequestHandler1<RCTransferRecordProxy> requestHandler);
}
