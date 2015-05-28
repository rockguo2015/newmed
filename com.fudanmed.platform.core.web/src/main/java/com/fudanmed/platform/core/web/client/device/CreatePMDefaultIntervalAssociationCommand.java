package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMDeviceTypeEntryProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMDefaultIntervalAssociationPresenter;
import com.fudanmed.platform.core.web.client.device.CreatePMDefaultIntervalAssociationCommandServiceAsync;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreatePMDefaultIntervalAssociationCommand extends BaseContextAwareSingleObjectCommand<RCDeviceTypeProxy> implements IContextConsumer<RCDeviceTypeProxy> {
  @Inject
  protected CreatePMDefaultIntervalAssociationCommandServiceAsync _service;
  
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "新建PM计划";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.CreatePMDefaultIntervalAssociationCommand";
  }
  
  public void execute(final RCDeviceTypeProxy value) {
    final Procedure1<RCPMDeviceTypeEntryProxy> _function = new Procedure1<RCPMDeviceTypeEntryProxy>() {
        public void apply(final RCPMDeviceTypeEntryProxy it) {
          CreateOrUpdatePMDefaultIntervalAssociationPresenter _get = CreatePMDefaultIntervalAssociationCommand.this.createOrUpdatePMDefaultIntervalAssociationPresenter.get();
          final Procedure1<CreateOrUpdatePMDefaultIntervalAssociationPresenter> _function = new Procedure1<CreateOrUpdatePMDefaultIntervalAssociationPresenter>() {
              public void apply(final CreateOrUpdatePMDefaultIntervalAssociationPresenter it) {
                it.popup(it);
              }
            };
          _get.setup4Create(it, new IPresenterInitiazerNotifier<CreateOrUpdatePMDefaultIntervalAssociationPresenter>() {
              public void done(CreateOrUpdatePMDefaultIntervalAssociationPresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    AsyncCallback<RCPMDeviceTypeEntryProxy> _onSuccess = this.<RCPMDeviceTypeEntryProxy>onSuccess(_function);
    _service.getRCPMDeviceTypeEntry(value, _onSuccess);
  }
  
  @Inject
  private Provider<CreateOrUpdatePMDefaultIntervalAssociationPresenter> createOrUpdatePMDefaultIntervalAssociationPresenter;
}
