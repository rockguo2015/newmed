package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.web.client.organization.EmployeeUploaderPresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.command.BaseSimpleCommand;
import edu.fudan.langlab.gxt.client.dialog.DialogPresenterExtensions;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;

public class ImportEmployeeCommand extends BaseSimpleCommand {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "导入";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.ImportEmployeeCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute() {
    EmployeeUploaderPresenter _get = this.employeeUploaderPresenter.get();
    DialogPresenterExtensions.asDialog(_get, "\u5458\u5DE5\u4FE1\u606F\u5BFC\u5165");
  }
  
  @Inject
  private Provider<EmployeeUploaderPresenter> employeeUploaderPresenter;
}
