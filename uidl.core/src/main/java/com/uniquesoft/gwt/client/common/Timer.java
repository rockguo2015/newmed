package com.uniquesoft.gwt.client.common;

import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * Set a time for a process, when the time has passed, execute the process
 */
@SuppressWarnings("all")
public class Timer extends com.google.gwt.user.client.Timer {
  private Procedure1<? super Void> process;
  
  public void run() {
    this.process.apply(null);
  }
  
  public Procedure1<? super Void> setProcess(final Procedure1<? super Void> process) {
    Procedure1<? super Void> _process = this.process = process;
    return _process;
  }
}
