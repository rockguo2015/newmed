package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.InHospitalLocationQueryListView;
import com.fudanmed.platform.core.web.shared.deliver.UIInHospitalLocation;
import com.fudanmed.platform.core.web.shared.deliver.UIInHospitalLocationCriteria;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.shared.command.IContextProvider;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

@ImplementedBy(value = InHospitalLocationQueryListView.class)
public interface InHospitalLocationQueryListPresenterView extends Viewer, IContextProvider<UIInHospitalLocation> {
  public abstract void showResults(final IPagedResult<UIInHospitalLocation> results);
  
  public abstract void refresh();
  
  public abstract void filterRequest(final RequestHandler1<UIInHospitalLocationCriteria> requestHandler);
  
  public abstract ActionContext<UIInHospitalLocation> getActionContext();
}
