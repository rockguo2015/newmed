package com.fudanmed.platform.core.web.client.tree;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckCategoryProxy;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverPatientCheckCategory;
import com.google.common.base.Objects;
import edu.fudan.langlab.gxt.shared.component.treegrid.ITreeGridContentProvider;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class DeliverPatientCheckCategoryTreeContentProvider implements ITreeGridContentProvider<UIDeliverPatientCheckCategory> {
  private Collection<UIDeliverPatientCheckCategory> elements = new Function0<Collection<UIDeliverPatientCheckCategory>>() {
    public Collection<UIDeliverPatientCheckCategory> apply() {
      ArrayList<UIDeliverPatientCheckCategory> _newArrayList = CollectionLiterals.<UIDeliverPatientCheckCategory>newArrayList();
      return _newArrayList;
    }
  }.apply();
  
  public DeliverPatientCheckCategoryTreeContentProvider(final Collection<UIDeliverPatientCheckCategory> elements) {
    this.elements = elements;
  }
  
  public Iterable<UIDeliverPatientCheckCategory> getChildren(final UIDeliverPatientCheckCategory parent) {
    final Function1<UIDeliverPatientCheckCategory,Boolean> _function = new Function1<UIDeliverPatientCheckCategory,Boolean>() {
        public Boolean apply(final UIDeliverPatientCheckCategory it) {
          DLDeliverPatientCheckCategoryProxy _parentCategory = it.getParentCategory();
          boolean _equals = Objects.equal(_parentCategory, parent);
          return Boolean.valueOf(_equals);
        }
      };
    Iterable<UIDeliverPatientCheckCategory> _filter = IterableExtensions.<UIDeliverPatientCheckCategory>filter(this.elements, _function);
    return _filter;
  }
  
  public Iterable<UIDeliverPatientCheckCategory> getRootElements() {
    final Function1<UIDeliverPatientCheckCategory,Boolean> _function = new Function1<UIDeliverPatientCheckCategory,Boolean>() {
        public Boolean apply(final UIDeliverPatientCheckCategory it) {
          DLDeliverPatientCheckCategoryProxy _parentCategory = it.getParentCategory();
          boolean _equals = Objects.equal(_parentCategory, null);
          return Boolean.valueOf(_equals);
        }
      };
    Iterable<UIDeliverPatientCheckCategory> _filter = IterableExtensions.<UIDeliverPatientCheckCategory>filter(this.elements, _function);
    return _filter;
  }
}
