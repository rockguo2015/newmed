package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateOutStockRecordView;
import com.fudanmed.platform.core.web.shared.warehouse.UIOutStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummary;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.RequestHandler2;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@ImplementedBy(value = CreateOrUpdateOutStockRecordView.class)
public interface CreateOrUpdateOutStockRecordPresenterView extends ViewerWithValidation {
  public abstract UIOutStockRecord getValue();
  
  public abstract void setValue(final UIOutStockRecord value);
  
  public abstract void setSourceWarehouseContext(final RCEmployeeProxy employee, final Procedure1<? super Void> notifier);
  
  public abstract void setSelectedOrganization(final RCOrganizationProxy newOrg);
  
  public abstract void teamChanged(final RequestHandler1<RCMaintenanceTeamProxy> requestHandler);
  
  public abstract void productSidEntered(final RequestHandler2<String,RCWarehouseProxy> requestHandler);
  
  public abstract void setProductSummary(final UIProductWarehouseStorageSummary productSummary);
  
  public abstract void postInitialize();
}
