package edu.fudan.langlab.uidl.domain.app.client.workbench;

import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Presenter;
import com.uniquesoft.gwt.client.common.Viewer;
import edu.fudan.langlab.uidl.domain.app.client.workbench.ApplicationWorkbenchView;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@ImplementedBy(value = ApplicationWorkbenchView.class)
public interface ApplicationWorkbenchPresenterView extends Viewer {
  public abstract void showPresenter(final Presenter presenter, final Procedure1<? super Void> init);
  
  public abstract void showActivatedPresenter(final Presenter presenter);
  
  public abstract void popPresenter(final Presenter presenter, final Procedure1<? super Void> init);
  
  public abstract void popActivatedPresenter(final Presenter presenter);
  
  public abstract void showSctivatedPresenterWithHeader(final Presenter presenter, final String header);
}
