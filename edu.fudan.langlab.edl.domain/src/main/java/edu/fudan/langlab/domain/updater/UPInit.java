package edu.fudan.langlab.domain.updater;

import edu.fudan.langlab.domain.updater.IUpgrader;
import edu.fudan.langlab.domain.updater.UpdateServie;
import edu.fudan.mylang.pf.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UPInit")
public class UPInit extends BaseService implements IUpgrader {
  @Autowired
  private UpdateServie updateService;
  
  public void doUpgrade() {
    updateService.upgraderCommited("V_0_0", "V_0_0");
  }
}
