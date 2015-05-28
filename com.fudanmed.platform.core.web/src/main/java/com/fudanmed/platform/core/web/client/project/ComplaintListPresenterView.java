package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.ComplaintListView;
import com.fudanmed.platform.core.web.shared.project.UIComplaint;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;
import java.util.Collection;

@ImplementedBy(value = ComplaintListView.class)
public interface ComplaintListPresenterView extends Viewer {
  public abstract void setResults(final Collection<UIComplaint> results);
}
