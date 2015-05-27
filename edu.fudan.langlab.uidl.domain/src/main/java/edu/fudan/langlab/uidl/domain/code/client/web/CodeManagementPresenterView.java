package edu.fudan.langlab.uidl.domain.code.client.web;

import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import edu.fudan.langlab.domain.code.proxy.CodeProxy;
import edu.fudan.langlab.uidl.domain.code.client.web.CodeManagementView;
import edu.fudan.langlab.uidl.domain.code.shared.web.UICode;
import edu.fudan.langlab.uidl.domain.code.shared.web.UICodeCriteria;
import edu.fudan.langlab.uidl.domain.code.shared.web.UICodeType;
import java.util.Collection;

@ImplementedBy(value = CodeManagementView.class)
public interface CodeManagementPresenterView extends Viewer {
  public abstract void showResults(final Collection<UICode> results);
  
  public abstract void refresh();
  
  public abstract void showFirst();
  
  public abstract void createRequest(final RequestHandler1<UICodeType> requestHandler);
  
  public abstract void deleteRequest(final RequestHandler1<CodeProxy> requestHandler);
  
  public abstract void modifyRequest(final RequestHandler1<CodeProxy> requestHandler);
  
  public abstract void filterRequest(final RequestHandler1<UICodeCriteria> requestHandler);
}
