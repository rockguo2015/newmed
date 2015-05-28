package com.fudanmed.platform.core.web.client.tree;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy;
import com.fudanmed.platform.core.web.shared.device.UIDeviceTypeCategory;
import com.google.common.base.Objects;
import edu.fudan.langlab.gxt.shared.component.treegrid.ITreeGridContentProvider;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class DeviceTypeCategoryTreeContentProvider implements ITreeGridContentProvider<UIDeviceTypeCategory> {
  private Collection<UIDeviceTypeCategory> elements = new Function0<Collection<UIDeviceTypeCategory>>() {
    public Collection<UIDeviceTypeCategory> apply() {
      ArrayList<UIDeviceTypeCategory> _newArrayList = CollectionLiterals.<UIDeviceTypeCategory>newArrayList();
      return _newArrayList;
    }
  }.apply();
  
  public DeviceTypeCategoryTreeContentProvider(final Collection<UIDeviceTypeCategory> elements) {
    this.elements = elements;
  }
  
  public Iterable<UIDeviceTypeCategory> getChildren(final UIDeviceTypeCategory parent) {
    final Function1<UIDeviceTypeCategory,Boolean> _function = new Function1<UIDeviceTypeCategory,Boolean>() {
        public Boolean apply(final UIDeviceTypeCategory it) {
          RCDeviceTypeCategoryProxy _parent = it.getParent();
          Long _id = _parent==null?(Long)null:_parent.getId();
          Long _id_1 = parent.getId();
          boolean _equals = Objects.equal(_id, _id_1);
          return Boolean.valueOf(_equals);
        }
      };
    Iterable<UIDeviceTypeCategory> _filter = IterableExtensions.<UIDeviceTypeCategory>filter(this.elements, _function);
    return _filter;
  }
  
  public Iterable<UIDeviceTypeCategory> getRootElements() {
    final Function1<UIDeviceTypeCategory,Boolean> _function = new Function1<UIDeviceTypeCategory,Boolean>() {
        public Boolean apply(final UIDeviceTypeCategory it) {
          RCDeviceTypeCategoryProxy _parent = it.getParent();
          boolean _equals = Objects.equal(_parent, null);
          return Boolean.valueOf(_equals);
        }
      };
    Iterable<UIDeviceTypeCategory> _filter = IterableExtensions.<UIDeviceTypeCategory>filter(this.elements, _function);
    return _filter;
  }
}
