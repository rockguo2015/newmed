package com.fudanmed.platform.core.domain.rest;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCWorkItemTask;
import com.fudanmed.platform.core.domain.RCWorkItemTaskStatus;
import com.fudanmed.platform.core.domain.rest.LoginResult;
import com.fudanmed.platform.core.domain.rest.MeasureInstrument;
import com.fudanmed.platform.core.domain.rest.MeasureInstrumentType;
import com.fudanmed.platform.core.domain.rest.MeasureValueSubmitInfo;
import com.fudanmed.platform.core.domain.rest.WorkItemBreifInfo;
import com.fudanmed.platform.core.domain.rest.WorkItemFinishInfo;
import com.fudanmed.platform.core.domain.rest.WorkItemInfo;
import com.fudanmed.platform.core.domain.rest.WorkItemReportInfo;
import com.fudanmed.platform.core.measure.RCMeasureDevice;
import edu.fudan.mylang.pf.IBaseService;
import java.util.Collection;
import java.util.Date;

public interface RestService extends IBaseService {
  public abstract LoginResult login(final String userid, final String passwd);
  
  public abstract Boolean modifyPasswd(final String userid, final String oldPasswd, final String newPasswd);
  
  /**
   * 本月已完成的工单数
   */
  public abstract Integer finishedCount(final RCEmployee employee, final Date startDate, final Date endDate);
  
  /**
   * 本月已完成的工单
   */
  public abstract Collection<WorkItemBreifInfo> getFinishedWorkItem(final RCEmployee employee, final Date startDate, final Date endDate, final Integer startNumber, final Integer endNumber);
  
  /**
   * 当前未完成的工单数
   */
  public abstract Integer getProcessingCount(final RCEmployee employee);
  
  /**
   * 当前未完成的工单
   */
  public abstract Collection<WorkItemBreifInfo> getProcessingWorkItem(final RCEmployee employee, final Integer startNumber, final Integer endNumber);
  
  /**
   * 获取指定状态的工单信息
   */
  public abstract Collection<WorkItemBreifInfo> getWorkItem4Status(final RCEmployee employee, final RCWorkItemTaskStatus status, final Integer startNumber, final Integer endNumber);
  
  /**
   * 获取工单详情
   */
  public abstract WorkItemInfo getWorkItemDetail(final RCWorkItemTask workItem);
  
  /**
   * 提交文件，系统返回一个文件标识
   */
  public abstract String submitPhoto(final Byte[] bytes);
  
  /**
   * 挂起
   */
  public abstract void pend(final RCWorkItemTask workitem, final WorkItemReportInfo info);
  
  /**
   * 结束挂起
   */
  public abstract void cancelPend(final RCWorkItemTask workitem, final WorkItemFinishInfo info);
  
  /**
   * 需外协
   */
  public abstract void outsource(final RCWorkItemTask workitem, final WorkItemReportInfo info);
  
  /**
   * 完成外协
   */
  public abstract void finishOutsource(final RCWorkItemTask workitem, final WorkItemFinishInfo info);
  
  /**
   * 工单串单
   */
  public abstract void misDispatching(final RCWorkItemTask workitem, final WorkItemReportInfo info);
  
  /**
   * 工单跟进
   */
  public abstract void followup(final RCWorkItemTask workitem, final WorkItemReportInfo info);
  
  /**
   * 工单完工
   */
  public abstract void finish(final RCWorkItemTask workitem, final WorkItemFinishInfo info);
  
  /**
   * 获取指定类型的计量设备
   */
  public abstract Collection<MeasureInstrument> getMeasureInstruments(final MeasureInstrumentType type);
  
  /**
   * 提交指定设备的本次读数
   */
  public abstract void submitMeasureResult(final RCMeasureDevice sid, final MeasureValueSubmitInfo info);
}
