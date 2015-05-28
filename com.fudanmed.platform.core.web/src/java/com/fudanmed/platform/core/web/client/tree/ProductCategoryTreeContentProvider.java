package com.fudanmed.platform.core.web.client.tree;

import com.fudanmed.platform.core.warehouse.proxy.RCProductCategoryProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductCategory;
import com.google.common.base.Objects;
import edu.fudan.langlab.gxt.shared.component.treegrid.ITreeGridContentProvider;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class ProductCategoryTreeContentProvider implements ITreeGridContentProvider<UIProductCategory> {
  private Collection<UIProductCategory> elements = new Function0<Collection<UIProductCategory>>() {
    public Collection<UIProductCategory> apply() {
      ArrayList<UIProductCategory> _newArrayList = CollectionLiterals.<UIProductCategory>newArrayList();
      return _newArrayList;
    }
  }.apply();
  
  public ProductCategoryTreeContentProvider(final Collection<UIProductCategory> elements) {
    this.elements = elements;
  }
  
  public Iterable<UIProductCategory> getChildren(final UIProductCategory parent) {
    final Function1<UIProductCategory,Boolean> _function = new Function1<UIProductCategory,Boolean>() {
        public Boolean apply(final UIProductCategory it) {
          RCProductCategoryProxy _parent = it.getParent();
          Long _id = _parent==null?(Long)null:_parent.getId();
          Long _id_1 = parent.getId();
          boolean _equals = Objects.equal(_id, _id_1);
          return Boolean.valueOf(_equals);
        }
      };
    Iterable<UIProductCategory> _filter = IterableExtensions.<UIProductCategory>filter(this.elements, _function);
    return _filter;
  }
  
  public Iterable<UIProductCategory> getRootElements() {
    final Function1<UIProductCategory,Boolean> _function = new Function1<UIProductCategory,Boolean>() {
        public Boolean apply(final UIProductCategory it) {
          RCProductCategoryProxy _parent = it.getParent();
          boolean _equals = Objects.equal(_parent, null);
          return Boolean.valueOf(_equals);
        }
      };
    Iterable<UIProductCategory> _filter = IterableExtensions.<UIProductCategory>filter(this.elements, _function);
    return _filter;
  }
}
