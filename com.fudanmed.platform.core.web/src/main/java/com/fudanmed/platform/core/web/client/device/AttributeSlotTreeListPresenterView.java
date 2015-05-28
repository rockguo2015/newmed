package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.AttributeSlotTreeListView;
import com.fudanmed.platform.core.web.client.device.IValueEditor;
import com.fudanmed.platform.core.web.shared.device.UIAttributeSlot;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import java.util.Collection;

@ImplementedBy(value = AttributeSlotTreeListView.class)
public interface AttributeSlotTreeListPresenterView extends Viewer {
  public abstract void setResults(final Collection<UIAttributeSlot> results);
  
  public abstract void editSlotValueRequest(final RequestHandler1<UIAttributeSlot> requestHandler);
  
  public abstract void activateEditor(final IValueEditor editor);
  
  public abstract void deactivateEditor();
  
  public abstract ActionContext<UIAttributeSlot> getActionContext();
  
  public abstract void addSlot(final UIAttributeSlot slot, final UIAttributeSlot parent);
  
  public abstract void updateSlot(final UIAttributeSlot slot);
}
