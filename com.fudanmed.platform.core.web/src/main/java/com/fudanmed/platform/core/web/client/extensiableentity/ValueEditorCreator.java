package com.fudanmed.platform.core.web.client.extensiableentity;

import com.fudanmed.platform.core.web.client.device.NumberValueEditorPresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;

@SuppressWarnings("all")
public class ValueEditorCreator {
  @Inject
  private Provider<NumberValueEditorPresenter> numberValueEditorPresenter;
  
  public NumberValueEditorPresenter getNumberValueEditorPresenter() {
    NumberValueEditorPresenter _get = this.numberValueEditorPresenter.get();
    return _get;
  }
}
