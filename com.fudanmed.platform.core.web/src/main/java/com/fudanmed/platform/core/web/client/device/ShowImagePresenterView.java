package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.ShowImageView;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;

@ImplementedBy(value = ShowImageView.class)
public interface ShowImagePresenterView extends Viewer {
  public abstract void setUrl(final String imgUrl);
}
