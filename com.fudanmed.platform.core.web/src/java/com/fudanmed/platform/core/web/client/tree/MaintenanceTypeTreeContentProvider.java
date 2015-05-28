package com.fudanmed.platform.core.web.client.tree;

import com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy;
import com.fudanmed.platform.core.web.shared.project.UIMaintenamceType;
import com.google.common.base.Objects;
import edu.fudan.langlab.gxt.shared.component.treegrid.ITreeGridContentProvider;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class MaintenanceTypeTreeContentProvider implements ITreeGridContentProvider<UIMaintenamceType> {
  private Collection<UIMaintenamceType> elements = new Function0<Collection<UIMaintenamceType>>() {
    public Collection<UIMaintenamceType> apply() {
      ArrayList<UIMaintenamceType> _newArrayList = CollectionLiterals.<UIMaintenamceType>newArrayList();
      return _newArrayList;
    }
  }.apply();
  
  public MaintenanceTypeTreeContentProvider(final Collection<UIMaintenamceType> elements) {
    this.elements = elements;
  }
  
  public Iterable<UIMaintenamceType> getChildren(final UIMaintenamceType parent) {
    final Function1<UIMaintenamceType,Boolean> _function = new Function1<UIMaintenamceType,Boolean>() {
        public Boolean apply(final UIMaintenamceType it) {
          RCMaintenamceTypeProxy _parent = it.getParent();
          Long _id = _parent==null?(Long)null:_parent.getId();
          Long _id_1 = parent.getId();
          boolean _equals = Objects.equal(_id, _id_1);
          return Boolean.valueOf(_equals);
        }
      };
    Iterable<UIMaintenamceType> _filter = IterableExtensions.<UIMaintenamceType>filter(this.elements, _function);
    return _filter;
  }
  
  public Iterable<UIMaintenamceType> getRootElements() {
    final Function1<UIMaintenamceType,Boolean> _function = new Function1<UIMaintenamceType,Boolean>() {
        public Boolean apply(final UIMaintenamceType it) {
          RCMaintenamceTypeProxy _parent = it.getParent();
          boolean _equals = Objects.equal(_parent, null);
          return Boolean.valueOf(_equals);
        }
      };
    Iterable<UIMaintenamceType> _filter = IterableExtensions.<UIMaintenamceType>filter(this.elements, _function);
    return _filter;
  }
}
