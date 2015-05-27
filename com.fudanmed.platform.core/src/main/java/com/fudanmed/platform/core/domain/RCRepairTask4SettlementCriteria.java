package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCMaintenanceTeam;
import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.RCRepairTask;
import com.fudanmed.platform.core.domain.RCRepairTaskStatus;
import com.fudanmed.platform.core.domain.impl.RCRepairTask4SettlementCriteriaImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;
import java.util.Date;

@QueryImplementation(implementBy = RCRepairTask4SettlementCriteriaImpl.class)
public interface RCRepairTask4SettlementCriteria extends IPagedCriteria<RCRepairTask> {
  public abstract Boolean getHasMadeSettlement();
  
  public abstract RCRepairTask4SettlementCriteria setHasMadeSettlement(final Boolean hasMadeSettlement);
  
  public abstract RCRepairTaskStatus getCloseStatus();
  
  public abstract RCRepairTask4SettlementCriteria setCloseStatus(final RCRepairTaskStatus closeStatus);
  
  public abstract Date getFinishDateFrom();
  
  public abstract RCRepairTask4SettlementCriteria setFinishDateFrom(final Date finishDateFrom);
  
  public abstract Date getFinishDateTo();
  
  public abstract RCRepairTask4SettlementCriteria setFinishDateTo(final Date finishDateTo);
  
  public abstract RCMaintenanceTeam getTeam();
  
  public abstract RCRepairTask4SettlementCriteria setTeam(final RCMaintenanceTeam team);
  
  public abstract RCOrganization getReportOrg();
  
  public abstract RCRepairTask4SettlementCriteria setReportOrg(final RCOrganization reportOrg);
}
