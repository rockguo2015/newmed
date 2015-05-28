package com.fudanmed.platform.core.web.client.tree;

import com.fudanmed.platform.core.web.shared.project.UIGeneralTask;
import com.google.common.base.Objects;
import edu.fudan.langlab.gxt.shared.component.treegrid.ITreeGridContentProvider;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class GeneralTaskTreeContentProvider implements ITreeGridContentProvider<UIGeneralTask> {
  private Collection<UIGeneralTask> tasks;
  
  public GeneralTaskTreeContentProvider(final Collection<UIGeneralTask> tasks) {
    this.tasks = tasks;
  }
  
  public Iterable<UIGeneralTask> getChildren(final UIGeneralTask parent) {
    final Function1<UIGeneralTask,Boolean> _function = new Function1<UIGeneralTask,Boolean>() {
        public Boolean apply(final UIGeneralTask it) {
          boolean _and = false;
          Integer _parent = it.getParent();
          boolean _notEquals = (!Objects.equal(_parent, null));
          if (!_notEquals) {
            _and = false;
          } else {
            Integer _parent_1 = it.getParent();
            int _hashCode = parent.hashCode();
            boolean _equals = ((_parent_1).intValue() == _hashCode);
            _and = (_notEquals && _equals);
          }
          return Boolean.valueOf(_and);
        }
      };
    Iterable<UIGeneralTask> _filter = IterableExtensions.<UIGeneralTask>filter(this.tasks, _function);
    return _filter;
  }
  
  public Iterable<UIGeneralTask> getRootElements() {
    final Function1<UIGeneralTask,Boolean> _function = new Function1<UIGeneralTask,Boolean>() {
        public Boolean apply(final UIGeneralTask it) {
          Integer _parent = it.getParent();
          boolean _equals = Objects.equal(_parent, null);
          return Boolean.valueOf(_equals);
        }
      };
    Iterable<UIGeneralTask> _filter = IterableExtensions.<UIGeneralTask>filter(this.tasks, _function);
    return _filter;
  }
}
