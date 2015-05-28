package com.fudanmed.platform.core.web.shared.project;

import com.fudanmed.platform.core.web.shared.project.UIGroupTaskActionType;
import com.fudanmed.platform.core.web.shared.project.UIGroupTaskStatus;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskActionType;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatus;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemTaskActionType;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemTaskStatus;
import com.google.common.base.Objects;

@SuppressWarnings("all")
public class StatusValidator {
  public static boolean canExecute(final UIWorkItemTaskStatus state, final UIWorkItemTaskActionType action) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(state,UIWorkItemTaskStatus.processing)) {
        _matched=true;
        boolean _or = false;
        boolean _or_1 = false;
        boolean _or_2 = false;
        boolean _or_3 = false;
        boolean _equals = Objects.equal(action, UIWorkItemTaskActionType.pend);
        if (_equals) {
          _or_3 = true;
        } else {
          boolean _equals_1 = Objects.equal(action, UIWorkItemTaskActionType.misDispatching);
          _or_3 = (_equals || _equals_1);
        }
        if (_or_3) {
          _or_2 = true;
        } else {
          boolean _equals_2 = Objects.equal(action, UIWorkItemTaskActionType.oursource);
          _or_2 = (_or_3 || _equals_2);
        }
        if (_or_2) {
          _or_1 = true;
        } else {
          boolean _equals_3 = Objects.equal(action, UIWorkItemTaskActionType.followup);
          _or_1 = (_or_2 || _equals_3);
        }
        if (_or_1) {
          _or = true;
        } else {
          boolean _equals_4 = Objects.equal(action, UIWorkItemTaskActionType.finish);
          _or = (_or_1 || _equals_4);
        }
        _switchResult = _or;
      }
    }
    if (!_matched) {
      if (Objects.equal(state,UIWorkItemTaskStatus.pending)) {
        _matched=true;
        boolean _equals_5 = Objects.equal(action, UIWorkItemTaskActionType.cancelPend);
        _switchResult = _equals_5;
      }
    }
    if (!_matched) {
      if (Objects.equal(state,UIWorkItemTaskStatus.outsourcing)) {
        _matched=true;
        boolean _equals_6 = Objects.equal(action, UIWorkItemTaskActionType.finishOutsource);
        _switchResult = _equals_6;
      }
    }
    if (!_matched) {
      if (Objects.equal(state,UIWorkItemTaskStatus.followuping)) {
        _matched=true;
        boolean _equals_7 = Objects.equal(action, UIWorkItemTaskActionType.finish);
        _switchResult = _equals_7;
      }
    }
    if (!_matched) {
      _switchResult = false;
    }
    return _switchResult;
  }
  
  public static boolean canExecute(final UIGroupTaskStatus state, final UIGroupTaskActionType action) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(state,UIGroupTaskStatus.newCreated)) {
        _matched=true;
        boolean _or = false;
        boolean _equals = Objects.equal(action, UIGroupTaskActionType.reportMisdispatch);
        if (_equals) {
          _or = true;
        } else {
          boolean _equals_1 = Objects.equal(action, UIGroupTaskActionType.createTask);
          _or = (_equals || _equals_1);
        }
        _switchResult = _or;
      }
    }
    if (!_matched) {
      if (Objects.equal(state,UIGroupTaskStatus.wait4TeamOwnerProcess)) {
        _matched=true;
        boolean _or_1 = false;
        boolean _equals_2 = Objects.equal(action, UIGroupTaskActionType.reportFinish);
        if (_equals_2) {
          _or_1 = true;
        } else {
          boolean _equals_3 = Objects.equal(action, UIGroupTaskActionType.createTask);
          _or_1 = (_equals_2 || _equals_3);
        }
        _switchResult = _or_1;
      }
    }
    if (!_matched) {
      if (Objects.equal(state,UIGroupTaskStatus.wait4TasksFinish)) {
        _matched=true;
        boolean _equals_4 = Objects.equal(action, UIGroupTaskActionType.createTask);
        _switchResult = _equals_4;
      }
    }
    if (!_matched) {
      _switchResult = false;
    }
    return _switchResult;
  }
  
  public static boolean canExecute(final UIRepairTaskStatus state, final UIRepairTaskActionType action) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(state,UIRepairTaskStatus.wait4SchedulerProcess)) {
        _matched=true;
        boolean _or = false;
        boolean _equals = Objects.equal(action, UIRepairTaskActionType.update);
        if (_equals) {
          _or = true;
        } else {
          boolean _equals_1 = Objects.equal(action, UIRepairTaskActionType.createGroupTask);
          _or = (_equals || _equals_1);
        }
        _switchResult = _or;
      }
    }
    if (!_matched) {
      if (Objects.equal(state,UIRepairTaskStatus.wait4Close)) {
        _matched=true;
        boolean _or_1 = false;
        boolean _or_2 = false;
        boolean _equals_2 = Objects.equal(action, UIRepairTaskActionType.close);
        if (_equals_2) {
          _or_2 = true;
        } else {
          boolean _equals_3 = Objects.equal(action, UIRepairTaskActionType.createGroupTask);
          _or_2 = (_equals_2 || _equals_3);
        }
        if (_or_2) {
          _or_1 = true;
        } else {
          boolean _equals_4 = Objects.equal(action, UIRepairTaskActionType.cancel);
          _or_1 = (_or_2 || _equals_4);
        }
        _switchResult = _or_1;
      }
    }
    if (!_matched) {
      if (Objects.equal(state,UIRepairTaskStatus.scheduled)) {
        _matched=true;
        boolean _equals_5 = Objects.equal(action, UIRepairTaskActionType.cancel);
        _switchResult = _equals_5;
      }
    }
    if (!_matched) {
      if (Objects.equal(state,UIRepairTaskStatus.newCreated)) {
        _matched=true;
        boolean _or_3 = false;
        boolean _or_4 = false;
        boolean _or_5 = false;
        boolean _equals_6 = Objects.equal(action, UIRepairTaskActionType.delete);
        if (_equals_6) {
          _or_5 = true;
        } else {
          boolean _equals_7 = Objects.equal(action, UIRepairTaskActionType.cancel);
          _or_5 = (_equals_6 || _equals_7);
        }
        if (_or_5) {
          _or_4 = true;
        } else {
          boolean _equals_8 = Objects.equal(action, UIRepairTaskActionType.update);
          _or_4 = (_or_5 || _equals_8);
        }
        if (_or_4) {
          _or_3 = true;
        } else {
          boolean _equals_9 = Objects.equal(action, UIRepairTaskActionType.createGroupTask);
          _or_3 = (_or_4 || _equals_9);
        }
        _switchResult = _or_3;
      }
    }
    if (!_matched) {
      _switchResult = false;
    }
    return _switchResult;
  }
}
