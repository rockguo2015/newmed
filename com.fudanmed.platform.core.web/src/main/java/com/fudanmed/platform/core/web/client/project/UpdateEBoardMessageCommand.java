package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.common.proxy.RCEBoardMessageProxy;
import com.fudanmed.platform.core.web.client.project.CreateOrUpdateEBoardMessagePresenter;
import com.fudanmed.platform.core.web.client.project.UpdateEBoardMessageCommandServiceAsync;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseSimpleCommand;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class UpdateEBoardMessageCommand extends BaseSimpleCommand {
  @Inject
  protected UpdateEBoardMessageCommandServiceAsync _service;
  
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "通知信息维护";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.UpdateEBoardMessageCommand";
  }
  
  public void execute() {
    final Procedure1<RCEBoardMessageProxy> _function = new Procedure1<RCEBoardMessageProxy>() {
        public void apply(final RCEBoardMessageProxy it) {
          CreateOrUpdateEBoardMessagePresenter _get = UpdateEBoardMessageCommand.this.createOrUpdateEBoardMessagePresenter.get();
          final Procedure1<CreateOrUpdateEBoardMessagePresenter> _function = new Procedure1<CreateOrUpdateEBoardMessagePresenter>() {
              public void apply(final CreateOrUpdateEBoardMessagePresenter it) {
                it.popup(it);
              }
            };
          _get.setup4Update(it, new IPresenterInitiazerNotifier<CreateOrUpdateEBoardMessagePresenter>() {
              public void done(CreateOrUpdateEBoardMessagePresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    AsyncCallback<RCEBoardMessageProxy> _onSuccess = this.<RCEBoardMessageProxy>onSuccess(_function);
    _service.loadEBoardMessage(_onSuccess);
  }
  
  @Inject
  private Provider<CreateOrUpdateEBoardMessagePresenter> createOrUpdateEBoardMessagePresenter;
}
