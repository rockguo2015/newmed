package edu.fudan.langlab.uidl.domain.code.client.web;

import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;
import edu.fudan.langlab.uidl.domain.code.client.web.CreateOrUpdateCodeView;
import edu.fudan.langlab.uidl.domain.code.shared.web.UICode;

@ImplementedBy(value = CreateOrUpdateCodeView.class)
public interface CreateOrUpdateCodePresenterView extends ViewerWithValidation {
  public abstract UICode getValue();
  
  public abstract void setValue(final UICode Code);
}
