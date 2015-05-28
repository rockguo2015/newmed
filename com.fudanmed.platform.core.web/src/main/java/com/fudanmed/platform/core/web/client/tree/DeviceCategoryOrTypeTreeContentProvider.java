package com.fudanmed.platform.core.web.client.tree;

import com.fudanmed.platform.core.web.shared.device.UIDeviceCategoryAndType;
import com.google.common.base.Objects;
import edu.fudan.langlab.gxt.shared.component.treegrid.ITreeGridContentProvider;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class DeviceCategoryOrTypeTreeContentProvider implements ITreeGridContentProvider<UIDeviceCategoryAndType> {
  private Collection<UIDeviceCategoryAndType> elements = new Function0<Collection<UIDeviceCategoryAndType>>() {
    public Collection<UIDeviceCategoryAndType> apply() {
      ArrayList<UIDeviceCategoryAndType> _newArrayList = CollectionLiterals.<UIDeviceCategoryAndType>newArrayList();
      return _newArrayList;
    }
  }.apply();
  
  public DeviceCategoryOrTypeTreeContentProvider(final Collection<UIDeviceCategoryAndType> elements) {
    this.elements = elements;
  }
  
  public Iterable<UIDeviceCategoryAndType> getChildren(final UIDeviceCategoryAndType parent) {
    final Function1<UIDeviceCategoryAndType,Boolean> _function = new Function1<UIDeviceCategoryAndType,Boolean>() {
        public Boolean apply(final UIDeviceCategoryAndType it) {
          UIDeviceCategoryAndType _parent = it.getParent();
          boolean _equals = Objects.equal(_parent, parent);
          return Boolean.valueOf(_equals);
        }
      };
    Iterable<UIDeviceCategoryAndType> _filter = IterableExtensions.<UIDeviceCategoryAndType>filter(this.elements, _function);
    return _filter;
  }
  
  public Iterable<UIDeviceCategoryAndType> getRootElements() {
    final Function1<UIDeviceCategoryAndType,Boolean> _function = new Function1<UIDeviceCategoryAndType,Boolean>() {
        public Boolean apply(final UIDeviceCategoryAndType it) {
          UIDeviceCategoryAndType _parent = it.getParent();
          boolean _equals = Objects.equal(_parent, null);
          return Boolean.valueOf(_equals);
        }
      };
    Iterable<UIDeviceCategoryAndType> _filter = IterableExtensions.<UIDeviceCategoryAndType>filter(this.elements, _function);
    return _filter;
  }
}
