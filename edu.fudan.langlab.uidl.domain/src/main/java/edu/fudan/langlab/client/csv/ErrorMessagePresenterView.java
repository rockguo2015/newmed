package edu.fudan.langlab.client.csv;

import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;
import edu.fudan.langlab.client.csv.ErrorMessageView;
import edu.fudan.langlab.shared.csv.UIErrorItem;
import java.util.Collection;

@ImplementedBy(value = ErrorMessageView.class)
public interface ErrorMessagePresenterView extends Viewer {
  public abstract void showErrorItems(final Collection<UIErrorItem> results);
}
