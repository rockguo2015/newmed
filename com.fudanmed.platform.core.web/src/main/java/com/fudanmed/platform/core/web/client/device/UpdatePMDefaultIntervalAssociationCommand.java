package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMDefaultIntervalAssociationProxy;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMDefaultIntervalAssociationPresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class UpdatePMDefaultIntervalAssociationCommand extends BaseContextAwareSingleObjectCommand<RCPMDefaultIntervalAssociationProxy> implements IContextConsumer<RCPMDefaultIntervalAssociationProxy> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "修改PM计划";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.UpdatePMDefaultIntervalAssociationCommand";
  }
  
  public void execute(final RCPMDefaultIntervalAssociationProxy value) {
    CreateOrUpdatePMDefaultIntervalAssociationPresenter _get = this.createOrUpdatePMDefaultIntervalAssociationPresenter.get();
    final Procedure1<CreateOrUpdatePMDefaultIntervalAssociationPresenter> _function = new Procedure1<CreateOrUpdatePMDefaultIntervalAssociationPresenter>() {
        public void apply(final CreateOrUpdatePMDefaultIntervalAssociationPresenter it) {
          it.popup(it);
        }
      };
    _get.setup4Update(value, new IPresenterInitiazerNotifier<CreateOrUpdatePMDefaultIntervalAssociationPresenter>() {
        public void done(CreateOrUpdatePMDefaultIntervalAssociationPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<CreateOrUpdatePMDefaultIntervalAssociationPresenter> createOrUpdatePMDefaultIntervalAssociationPresenter;
}
