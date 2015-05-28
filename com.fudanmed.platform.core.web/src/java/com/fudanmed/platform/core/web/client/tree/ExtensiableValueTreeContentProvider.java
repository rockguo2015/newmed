package com.fudanmed.platform.core.web.client.tree;

import com.fudanmed.platform.core.web.shared.device.UIAttributeSlot;
import com.google.common.base.Objects;
import edu.fudan.langlab.gxt.shared.component.treegrid.ITreeGridContentProvider;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class ExtensiableValueTreeContentProvider implements ITreeGridContentProvider<UIAttributeSlot> {
  private Collection<UIAttributeSlot> slots;
  
  public ExtensiableValueTreeContentProvider(final Collection<UIAttributeSlot> slots) {
    this.slots = slots;
  }
  
  public Iterable<UIAttributeSlot> getChildren(final UIAttributeSlot parent) {
    final Function1<UIAttributeSlot,Boolean> _function = new Function1<UIAttributeSlot,Boolean>() {
        public Boolean apply(final UIAttributeSlot it) {
          UIAttributeSlot _parentSlot = it.getParentSlot();
          boolean _equals = Objects.equal(_parentSlot, parent);
          return Boolean.valueOf(_equals);
        }
      };
    Iterable<UIAttributeSlot> _filter = IterableExtensions.<UIAttributeSlot>filter(this.slots, _function);
    return _filter;
  }
  
  public Iterable<UIAttributeSlot> getRootElements() {
    final Function1<UIAttributeSlot,Boolean> _function = new Function1<UIAttributeSlot,Boolean>() {
        public Boolean apply(final UIAttributeSlot it) {
          UIAttributeSlot _parentSlot = it.getParentSlot();
          boolean _equals = Objects.equal(_parentSlot, null);
          return Boolean.valueOf(_equals);
        }
      };
    Iterable<UIAttributeSlot> _filter = IterableExtensions.<UIAttributeSlot>filter(this.slots, _function);
    return _filter;
  }
}
