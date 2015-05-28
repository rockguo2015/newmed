package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCTransferRecordProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UITransferRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UITransferRecordCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UITransferRecordItem;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.warehouse.TransferRecordListPresenterService")
public interface TransferRecordListPresenterService extends RemoteService {
  public abstract String generatePrintContents(final RCTransferRecordProxy record) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract IPagedResult<UITransferRecord> filter(final UITransferRecordCriteria uicriteria) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void delete(final RCTransferRecordProxy value) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract Collection<UITransferRecordItem> loadDetails(final RCTransferRecordProxy parent) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
