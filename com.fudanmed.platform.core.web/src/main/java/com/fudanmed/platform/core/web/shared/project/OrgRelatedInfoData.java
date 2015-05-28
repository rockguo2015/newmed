package com.fudanmed.platform.core.web.shared.project;

import com.fudanmed.platform.core.web.shared.organization.UIEmployee;
import com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import java.util.Collection;

public class OrgRelatedInfoData implements IsSerializable {
  private Collection<UIOnsitePosition> pos = com.google.common.collect.Lists.newArrayList();
  
  public Collection<UIOnsitePosition> getPos() {
    return this.pos;
  }
  
  public void setPos(final Collection<UIOnsitePosition> pos) {
    this.pos = pos;
  }
  
  public final static String P_Pos = "pos";
  
  public static IObjectFieldAccessor<OrgRelatedInfoData,Collection<UIOnsitePosition>> PosAccessor = new IObjectFieldAccessor<OrgRelatedInfoData,Collection<UIOnsitePosition>>(){
    				public java.util.Collection<com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition> getValue(OrgRelatedInfoData object){
    					return object.getPos();
    				}
    				public void setValue(OrgRelatedInfoData object,java.util.Collection<com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition> value){
    					object.setPos(value);
    				}
    			};
  
  private Collection<UIEmployee> workers = com.google.common.collect.Lists.newArrayList();
  
  public Collection<UIEmployee> getWorkers() {
    return this.workers;
  }
  
  public void setWorkers(final Collection<UIEmployee> workers) {
    this.workers = workers;
  }
  
  public final static String P_Workers = "workers";
  
  public static IObjectFieldAccessor<OrgRelatedInfoData,Collection<UIEmployee>> WorkersAccessor = new IObjectFieldAccessor<OrgRelatedInfoData,Collection<UIEmployee>>(){
    				public java.util.Collection<com.fudanmed.platform.core.web.shared.organization.UIEmployee> getValue(OrgRelatedInfoData object){
    					return object.getWorkers();
    				}
    				public void setValue(OrgRelatedInfoData object,java.util.Collection<com.fudanmed.platform.core.web.shared.organization.UIEmployee> value){
    					object.setWorkers(value);
    				}
    			};
  
  private Collection<UIRepairTask> historyTasks = com.google.common.collect.Lists.newArrayList();
  
  public Collection<UIRepairTask> getHistoryTasks() {
    return this.historyTasks;
  }
  
  public void setHistoryTasks(final Collection<UIRepairTask> historyTasks) {
    this.historyTasks = historyTasks;
  }
  
  public final static String P_HistoryTasks = "historyTasks";
  
  public static IObjectFieldAccessor<OrgRelatedInfoData,Collection<UIRepairTask>> HistoryTasksAccessor = new IObjectFieldAccessor<OrgRelatedInfoData,Collection<UIRepairTask>>(){
    				public java.util.Collection<com.fudanmed.platform.core.web.shared.project.UIRepairTask> getValue(OrgRelatedInfoData object){
    					return object.getHistoryTasks();
    				}
    				public void setValue(OrgRelatedInfoData object,java.util.Collection<com.fudanmed.platform.core.web.shared.project.UIRepairTask> value){
    					object.setHistoryTasks(value);
    				}
    			};
}
