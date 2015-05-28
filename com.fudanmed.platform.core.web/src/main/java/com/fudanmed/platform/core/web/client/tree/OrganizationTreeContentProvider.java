package com.fudanmed.platform.core.web.client.tree;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.shared.organization.UIOrganization;
import com.google.common.base.Objects;
import edu.fudan.langlab.gxt.shared.component.treegrid.ITreeGridContentProvider;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class OrganizationTreeContentProvider implements ITreeGridContentProvider<UIOrganization> {
  private Collection<UIOrganization> organizations = new Function0<Collection<UIOrganization>>() {
    public Collection<UIOrganization> apply() {
      ArrayList<UIOrganization> _newArrayList = CollectionLiterals.<UIOrganization>newArrayList();
      return _newArrayList;
    }
  }.apply();
  
  public OrganizationTreeContentProvider(final Collection<UIOrganization> organizations) {
    this.organizations = organizations;
  }
  
  public Iterable<UIOrganization> getChildren(final UIOrganization parent) {
    final Function1<UIOrganization,Boolean> _function = new Function1<UIOrganization,Boolean>() {
        public Boolean apply(final UIOrganization it) {
          RCOrganizationProxy _parent = it.getParent();
          Long _id = _parent==null?(Long)null:_parent.getId();
          Long _id_1 = parent.getId();
          boolean _equals = Objects.equal(_id, _id_1);
          return Boolean.valueOf(_equals);
        }
      };
    Iterable<UIOrganization> _filter = IterableExtensions.<UIOrganization>filter(this.organizations, _function);
    return _filter;
  }
  
  public Iterable<UIOrganization> getRootElements() {
    final Function1<UIOrganization,Boolean> _function = new Function1<UIOrganization,Boolean>() {
        public Boolean apply(final UIOrganization it) {
          RCOrganizationProxy _parent = it.getParent();
          boolean _equals = Objects.equal(_parent, null);
          return Boolean.valueOf(_equals);
        }
      };
    Iterable<UIOrganization> _filter = IterableExtensions.<UIOrganization>filter(this.organizations, _function);
    return _filter;
  }
}
