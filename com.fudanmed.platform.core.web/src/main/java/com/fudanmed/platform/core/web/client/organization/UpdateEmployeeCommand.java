package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.web.client.organization.CreateOrUpdateEmployeePresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class UpdateEmployeeCommand extends BaseContextAwareSingleObjectCommand<RCEmployeeProxy> implements IContextConsumer<RCEmployeeProxy> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "修改";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.UpdateEmployeeCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute(final RCEmployeeProxy value) {
    CreateOrUpdateEmployeePresenter _get = this.updatePresenter.get();
    final Procedure1<CreateOrUpdateEmployeePresenter> _function = new Procedure1<CreateOrUpdateEmployeePresenter>() {
        public void apply(final CreateOrUpdateEmployeePresenter it) {
          it.popup(it);
        }
      };
    _get.setup4Update(value, _function);
  }
  
  @Inject
  private Provider<CreateOrUpdateEmployeePresenter> updatePresenter;
}
