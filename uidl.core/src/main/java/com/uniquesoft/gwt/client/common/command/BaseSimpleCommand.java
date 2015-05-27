package com.uniquesoft.gwt.client.common.command;

import com.uniquesoft.gwt.client.common.command.BaseCommand;

@SuppressWarnings("all")
public abstract class BaseSimpleCommand extends BaseCommand {
  public abstract void execute();
  
  public boolean checkEnable() {
    return true;
  }
}
