package edu.fudan.langlab.uidl.domain.app.client.workbench;

import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Presenter;
import com.uniquesoft.gwt.client.common.Viewer;
import edu.fudan.langlab.uidl.domain.app.client.workbench.FramedView;

@ImplementedBy(value = FramedView.class)
public interface FramedPresenterView extends Viewer {
  public abstract void setContentPresenter(final String theTitle, final Presenter p);
}
