package com.uniquesoft.gwt.client.common.widgets.contentprovider;

import com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentLoadedCallback;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class ConfigurableContentUpdatedCallback implements ContentLoadedCallback {
  public static ContentLoadedCallback onContentUpdated(final Procedure1<? super Void> onContentUpdated) {
    ConfigurableContentUpdatedCallback _configurableContentUpdatedCallback = new ConfigurableContentUpdatedCallback();
    ConfigurableContentUpdatedCallback x = _configurableContentUpdatedCallback;
    x.onContentUpdatedDo(onContentUpdated);
    return x;
  }
  
  private Procedure1<? super Void> onContentUpdated;
  
  public void onContentUpdatedDo(final Procedure1<? super Void> action) {
    this.onContentUpdated = action;
  }
  
  public void contentLoaded() {
    this.onContentUpdated.apply(null);
  }
}
