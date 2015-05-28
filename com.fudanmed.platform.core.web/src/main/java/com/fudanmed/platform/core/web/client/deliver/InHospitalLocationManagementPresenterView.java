package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.InHospitalLocationManagementView;
import com.fudanmed.platform.core.web.client.deliver.InHospitalLocationQueryListPresenter;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;

@ImplementedBy(value = InHospitalLocationManagementView.class)
public interface InHospitalLocationManagementPresenterView extends Viewer {
  public abstract void setQueryListPresenter(final InHospitalLocationQueryListPresenter queryListPresenter);
}
