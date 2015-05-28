package com.fudanmed.platform.core.web.client.tree;

import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition;
import com.google.common.base.Objects;
import edu.fudan.langlab.gxt.shared.component.treegrid.ITreeGridContentProvider;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class OnsitePositionTreeContentProvider implements ITreeGridContentProvider<UIOnsitePosition> {
  private Collection<UIOnsitePosition> positions = new Function0<Collection<UIOnsitePosition>>() {
    public Collection<UIOnsitePosition> apply() {
      ArrayList<UIOnsitePosition> _newArrayList = CollectionLiterals.<UIOnsitePosition>newArrayList();
      return _newArrayList;
    }
  }.apply();
  
  public OnsitePositionTreeContentProvider(final Collection<UIOnsitePosition> positions) {
    this.positions = positions;
  }
  
  public Iterable<UIOnsitePosition> getChildren(final UIOnsitePosition parent) {
    final Function1<UIOnsitePosition,Boolean> _function = new Function1<UIOnsitePosition,Boolean>() {
        public Boolean apply(final UIOnsitePosition it) {
          RCOnsitePositionProxy _parent = it.getParent();
          Long _id = _parent==null?(Long)null:_parent.getId();
          Long _id_1 = parent.getId();
          boolean _equals = Objects.equal(_id, _id_1);
          return Boolean.valueOf(_equals);
        }
      };
    Iterable<UIOnsitePosition> _filter = IterableExtensions.<UIOnsitePosition>filter(this.positions, _function);
    return _filter;
  }
  
  public Iterable<UIOnsitePosition> getRootElements() {
    final Function1<UIOnsitePosition,Boolean> _function = new Function1<UIOnsitePosition,Boolean>() {
        public Boolean apply(final UIOnsitePosition it) {
          RCOnsitePositionProxy _parent = it.getParent();
          boolean _equals = Objects.equal(_parent, null);
          return Boolean.valueOf(_equals);
        }
      };
    Iterable<UIOnsitePosition> _filter = IterableExtensions.<UIOnsitePosition>filter(this.positions, _function);
    return _filter;
  }
}
