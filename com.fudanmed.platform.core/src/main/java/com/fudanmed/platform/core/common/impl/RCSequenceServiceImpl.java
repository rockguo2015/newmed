package com.fudanmed.platform.core.common.impl;

import com.fudanmed.platform.core.common.RCSequenceConfig;
import com.fudanmed.platform.core.common.RCSequenceService;
import com.fudanmed.platform.core.common.impl.RCSequenceConfigImpl;
import edu.fudan.mylang.common.ObjectExtensions2;
import edu.fudan.mylang.pf.BaseService;
import edu.fudan.mylang.pf.IGenericQuery;
import edu.fudan.mylang.utils.DateUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.springframework.stereotype.Service;

@Service("com.fudanmed.platform.core.common.RCSequenceService")
public class RCSequenceServiceImpl extends BaseService implements RCSequenceService {
  public String getNextInStockSequence() {
    String _xblockexpression = null;
    {
      final RCSequenceConfig config = this.computeConfig();
      Integer _inStockSequence = config.getInStockSequence();
      int _plus = ((_inStockSequence).intValue() + 1);
      config.setInStockSequence(Integer.valueOf(_plus));
      SimpleDateFormat _simpleDateFormat = new SimpleDateFormat(
        "yyyyMMdd");
      final SimpleDateFormat format = _simpleDateFormat;
      Date _sequenceDate = config.getSequenceDate();
      String _format = format.format(_sequenceDate);
      String _plus_1 = ("RK" + _format);
      Integer _inStockSequence_1 = config.getInStockSequence();
      String _format_1 = String.format("%03d", _inStockSequence_1);
      String _plus_2 = (_plus_1 + _format_1);
      _xblockexpression = (_plus_2);
    }
    return _xblockexpression;
  }
  
  public String getNextOutStockSequence() {
    String _xblockexpression = null;
    {
      final RCSequenceConfig config = this.computeConfig();
      Integer _outStockSequence = config.getOutStockSequence();
      int _plus = ((_outStockSequence).intValue() + 1);
      config.setOutStockSequence(Integer.valueOf(_plus));
      SimpleDateFormat _simpleDateFormat = new SimpleDateFormat(
        "yyyyMMdd");
      final SimpleDateFormat format = _simpleDateFormat;
      Date _sequenceDate = config.getSequenceDate();
      String _format = format.format(_sequenceDate);
      String _plus_1 = ("CK" + _format);
      Integer _outStockSequence_1 = config.getOutStockSequence();
      String _format_1 = String.format("%03d", _outStockSequence_1);
      String _plus_2 = (_plus_1 + _format_1);
      _xblockexpression = (_plus_2);
    }
    return _xblockexpression;
  }
  
  public String getNextStockTakingSequence() {
    String _xblockexpression = null;
    {
      final RCSequenceConfig config = this.computeConfig();
      Integer _stockTakingSequence = config.getStockTakingSequence();
      int _plus = ((_stockTakingSequence).intValue() + 1);
      config.setStockTakingSequence(Integer.valueOf(_plus));
      SimpleDateFormat _simpleDateFormat = new SimpleDateFormat(
        "yyyyMMdd");
      final SimpleDateFormat format = _simpleDateFormat;
      Date _sequenceDate = config.getSequenceDate();
      String _format = format.format(_sequenceDate);
      String _plus_1 = ("PD" + _format);
      Integer _stockTakingSequence_1 = config.getStockTakingSequence();
      String _format_1 = String.format("%03d", _stockTakingSequence_1);
      String _plus_2 = (_plus_1 + _format_1);
      _xblockexpression = (_plus_2);
    }
    return _xblockexpression;
  }
  
  public String getNextWorkItemTaskSequence() {
    String _xblockexpression = null;
    {
      final RCSequenceConfig config = this.computeConfig();
      Integer _workItemTaskSequence = config.getWorkItemTaskSequence();
      int _plus = ((_workItemTaskSequence).intValue() + 1);
      config.setWorkItemTaskSequence(Integer.valueOf(_plus));
      SimpleDateFormat _simpleDateFormat = new SimpleDateFormat(
        "yyyyMMdd");
      final SimpleDateFormat format = _simpleDateFormat;
      Date _sequenceDate = config.getSequenceDate();
      String _format = format.format(_sequenceDate);
      String _plus_1 = ("GD" + _format);
      Integer _workItemTaskSequence_1 = config.getWorkItemTaskSequence();
      String _format_1 = String.format("%03d", _workItemTaskSequence_1);
      String _plus_2 = (_plus_1 + _format_1);
      _xblockexpression = (_plus_2);
    }
    return _xblockexpression;
  }
  
  public String getNextRepairTaskSequence() {
    String _xblockexpression = null;
    {
      final RCSequenceConfig config = this.computeConfig();
      Integer _repairTaskSequence = config.getRepairTaskSequence();
      int _plus = ((_repairTaskSequence).intValue() + 1);
      config.setRepairTaskSequence(Integer.valueOf(_plus));
      SimpleDateFormat _simpleDateFormat = new SimpleDateFormat(
        "yyyyMMdd");
      final SimpleDateFormat format = _simpleDateFormat;
      Date _sequenceDate = config.getSequenceDate();
      String _format = format.format(_sequenceDate);
      String _plus_1 = ("BX" + _format);
      Integer _repairTaskSequence_1 = config.getRepairTaskSequence();
      String _format_1 = String.format("%03d", _repairTaskSequence_1);
      String _plus_2 = (_plus_1 + _format_1);
      _xblockexpression = (_plus_2);
    }
    return _xblockexpression;
  }
  
  public String getNextWorkitemOutStockSequence() {
    String _xblockexpression = null;
    {
      final RCSequenceConfig config = this.computeConfig();
      Integer _workitemOutStockSequence = config.getWorkitemOutStockSequence();
      int _plus = ((_workitemOutStockSequence).intValue() + 1);
      config.setWorkitemOutStockSequence(Integer.valueOf(_plus));
      SimpleDateFormat _simpleDateFormat = new SimpleDateFormat(
        "yyyyMMdd");
      final SimpleDateFormat format = _simpleDateFormat;
      Date _sequenceDate = config.getSequenceDate();
      String _format = format.format(_sequenceDate);
      String _plus_1 = ("LL" + _format);
      Integer _workitemOutStockSequence_1 = config.getWorkitemOutStockSequence();
      String _format_1 = String.format("%03d", _workitemOutStockSequence_1);
      String _plus_2 = (_plus_1 + _format_1);
      _xblockexpression = (_plus_2);
    }
    return _xblockexpression;
  }
  
  public String getNextWorkitemReturnStockSequence() {
    String _xblockexpression = null;
    {
      final RCSequenceConfig config = this.computeConfig();
      Integer _workitemReturnStockSequence = config.getWorkitemReturnStockSequence();
      int _plus = ((_workitemReturnStockSequence).intValue() + 1);
      config.setWorkitemReturnStockSequence(Integer.valueOf(_plus));
      SimpleDateFormat _simpleDateFormat = new SimpleDateFormat(
        "yyyyMMdd");
      final SimpleDateFormat format = _simpleDateFormat;
      Date _sequenceDate = config.getSequenceDate();
      String _format = format.format(_sequenceDate);
      String _plus_1 = ("TL" + _format);
      Integer _workitemReturnStockSequence_1 = config.getWorkitemReturnStockSequence();
      String _format_1 = String.format("%03d", _workitemReturnStockSequence_1);
      String _plus_2 = (_plus_1 + _format_1);
      _xblockexpression = (_plus_2);
    }
    return _xblockexpression;
  }
  
  public String getNextTransferSequence() {
    String _xblockexpression = null;
    {
      final RCSequenceConfig config = this.computeConfig();
      Integer _transferSequence = config.getTransferSequence();
      int _plus = ((_transferSequence).intValue() + 1);
      config.setTransferSequence(Integer.valueOf(_plus));
      SimpleDateFormat _simpleDateFormat = new SimpleDateFormat(
        "yyyyMMdd");
      final SimpleDateFormat format = _simpleDateFormat;
      Date _sequenceDate = config.getSequenceDate();
      String _format = format.format(_sequenceDate);
      String _plus_1 = ("DB" + _format);
      Integer _transferSequence_1 = config.getTransferSequence();
      String _format_1 = String.format("%03d", _transferSequence_1);
      String _plus_2 = (_plus_1 + _format_1);
      _xblockexpression = (_plus_2);
    }
    return _xblockexpression;
  }
  
  public String getNextSettlementSequence() {
    String _xblockexpression = null;
    {
      final RCSequenceConfig config = this.computeConfig();
      Integer _settlementSequence = config.getSettlementSequence();
      int _plus = ((_settlementSequence).intValue() + 1);
      config.setSettlementSequence(Integer.valueOf(_plus));
      SimpleDateFormat _simpleDateFormat = new SimpleDateFormat(
        "yyyyMMdd");
      final SimpleDateFormat format = _simpleDateFormat;
      Date _sequenceDate = config.getSequenceDate();
      String _format = format.format(_sequenceDate);
      String _plus_1 = ("JS" + _format);
      Integer _settlementSequence_1 = config.getSettlementSequence();
      String _format_1 = String.format("%03d", _settlementSequence_1);
      String _plus_2 = (_plus_1 + _format_1);
      _xblockexpression = (_plus_2);
    }
    return _xblockexpression;
  }
  
  public String getNextPMWorkItemSequence() {
    String _xblockexpression = null;
    {
      final RCSequenceConfig config = this.computeConfig();
      Integer _pmWorkItemSequence = config.getPmWorkItemSequence();
      int _plus = ((_pmWorkItemSequence).intValue() + 1);
      config.setPmWorkItemSequence(Integer.valueOf(_plus));
      SimpleDateFormat _simpleDateFormat = new SimpleDateFormat(
        "yyyyMMdd");
      final SimpleDateFormat format = _simpleDateFormat;
      Date _sequenceDate = config.getSequenceDate();
      String _format = format.format(_sequenceDate);
      String _plus_1 = ("PM" + _format);
      Integer _pmWorkItemSequence_1 = config.getPmWorkItemSequence();
      String _format_1 = String.format("%03d", _pmWorkItemSequence_1);
      String _plus_2 = (_plus_1 + _format_1);
      _xblockexpression = (_plus_2);
    }
    return _xblockexpression;
  }
  
  public String getNextCenterilzedTaskSequence() {
    String _xblockexpression = null;
    {
      final RCSequenceConfig config = this.computeConfig();
      Integer _centerilzedTaskSequence = config.getCenterilzedTaskSequence();
      int _plus = ((_centerilzedTaskSequence).intValue() + 1);
      config.setCenterilzedTaskSequence(Integer.valueOf(_plus));
      SimpleDateFormat _simpleDateFormat = new SimpleDateFormat(
        "yyyyMMdd");
      final SimpleDateFormat format = _simpleDateFormat;
      Date _sequenceDate = config.getSequenceDate();
      String _format = format.format(_sequenceDate);
      String _plus_1 = ("PM" + _format);
      Integer _centerilzedTaskSequence_1 = config.getCenterilzedTaskSequence();
      String _format_1 = String.format("%03d", _centerilzedTaskSequence_1);
      String _plus_2 = (_plus_1 + _format_1);
      _xblockexpression = (_plus_2);
    }
    return _xblockexpression;
  }
  
  public RCSequenceConfig computeConfig() {
    RCSequenceConfig _xblockexpression = null;
    {
      Date today = DateUtil.today();IGenericQuery<RCSequenceConfig> query=getObjectFactory().createGenericQuery(RCSequenceConfig.class,"select config from com.fudanmed.platform.core.common.impl.RCSequenceConfigImpl as config   where  config.active = 1      ");
      RCSequenceConfig _uniqueResult = query.uniqueResult();
      final Function1<Void,RCSequenceConfig> _function = new Function1<Void,RCSequenceConfig>() {
          public RCSequenceConfig apply(final Void it) {RCSequenceConfig rCSequenceConfig=RCSequenceConfigImpl.create(getObjectFactory());
            return rCSequenceConfig;
          }
        };
      RCSequenceConfig config = ObjectExtensions2.<RCSequenceConfig>withDefault(_uniqueResult, _function);
      Date _sequenceDate = config.getSequenceDate();
      boolean _equals = today.equals(_sequenceDate);
      boolean _not = (!_equals);
      if (_not) {
        config.setSequenceDate(today);
        config.setInStockSequence(Integer.valueOf(0));
        config.setOutStockSequence(Integer.valueOf(0));
        config.setStockTakingSequence(Integer.valueOf(0));
        config.setWorkItemTaskSequence(Integer.valueOf(0));
        config.setWorkitemOutStockSequence(Integer.valueOf(0));
        config.setTransferSequence(Integer.valueOf(0));
        config.setWorkitemReturnStockSequence(Integer.valueOf(0));
        config.setRepairTaskSequence(Integer.valueOf(0));
        config.setSettlementSequence(Integer.valueOf(0));
        config.setPmWorkItemSequence(Integer.valueOf(0));
        config.setCenterilzedTaskSequence(Integer.valueOf(0));
      }
      _xblockexpression = (config);
    }
    return _xblockexpression;
  }
}
