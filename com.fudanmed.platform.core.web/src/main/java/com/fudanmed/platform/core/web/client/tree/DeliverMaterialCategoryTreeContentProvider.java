package com.fudanmed.platform.core.web.client.tree;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialCategoryProxy;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverMaterialCategory;
import com.google.common.base.Objects;
import edu.fudan.langlab.gxt.shared.component.treegrid.ITreeGridContentProvider;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class DeliverMaterialCategoryTreeContentProvider implements ITreeGridContentProvider<UIDeliverMaterialCategory> {
  private Collection<UIDeliverMaterialCategory> elements = new Function0<Collection<UIDeliverMaterialCategory>>() {
    public Collection<UIDeliverMaterialCategory> apply() {
      ArrayList<UIDeliverMaterialCategory> _newArrayList = CollectionLiterals.<UIDeliverMaterialCategory>newArrayList();
      return _newArrayList;
    }
  }.apply();
  
  public DeliverMaterialCategoryTreeContentProvider(final Collection<UIDeliverMaterialCategory> elements) {
    this.elements = elements;
  }
  
  public Iterable<UIDeliverMaterialCategory> getChildren(final UIDeliverMaterialCategory parent) {
    final Function1<UIDeliverMaterialCategory,Boolean> _function = new Function1<UIDeliverMaterialCategory,Boolean>() {
        public Boolean apply(final UIDeliverMaterialCategory it) {
          DLDeliverMaterialCategoryProxy _parentCategory = it.getParentCategory();
          boolean _equals = Objects.equal(_parentCategory, parent);
          return Boolean.valueOf(_equals);
        }
      };
    Iterable<UIDeliverMaterialCategory> _filter = IterableExtensions.<UIDeliverMaterialCategory>filter(this.elements, _function);
    return _filter;
  }
  
  public Iterable<UIDeliverMaterialCategory> getRootElements() {
    final Function1<UIDeliverMaterialCategory,Boolean> _function = new Function1<UIDeliverMaterialCategory,Boolean>() {
        public Boolean apply(final UIDeliverMaterialCategory it) {
          DLDeliverMaterialCategoryProxy _parentCategory = it.getParentCategory();
          boolean _equals = Objects.equal(_parentCategory, null);
          return Boolean.valueOf(_equals);
        }
      };
    Iterable<UIDeliverMaterialCategory> _filter = IterableExtensions.<UIDeliverMaterialCategory>filter(this.elements, _function);
    return _filter;
  }
}
