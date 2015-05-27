package edu.fudan.langlab.domain.updater.impl;

import edu.fudan.langlab.domain.updater.IUpgrader;
import edu.fudan.langlab.domain.updater.UpgradeExecutor;
import edu.fudan.mylang.pf.BaseService;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("edu.fudan.langlab.domain.updater.UpgradeExecutor")
public class UpgradeExecutorImpl extends BaseService implements UpgradeExecutor {
  @Autowired
  private Collection<IUpgrader> upgraders;
  
  public void execute() {
    final Procedure1<IUpgrader> _function = new Procedure1<IUpgrader>() {
        public void apply(final IUpgrader it) {
          it.doUpgrade();
        }
      };
    IterableExtensions.<IUpgrader>forEach(this.upgraders, _function);
  }
}
