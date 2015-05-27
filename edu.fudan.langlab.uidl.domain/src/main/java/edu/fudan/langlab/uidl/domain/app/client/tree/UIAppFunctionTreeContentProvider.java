package edu.fudan.langlab.uidl.domain.app.client.tree;

import com.google.common.base.Objects;
import edu.fudan.langlab.gxt.shared.component.treegrid.ITreeContentProvider;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIAppFunction;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class UIAppFunctionTreeContentProvider implements ITreeContentProvider<UIAppFunction> {
  public Iterable<UIAppFunction> getChildren(final UIAppFunction parent, final Iterable<UIAppFunction> functions) {
    final Function1<UIAppFunction,Boolean> _function = new Function1<UIAppFunction,Boolean>() {
        public Boolean apply(final UIAppFunction it) {
          String _parentFunctionId = it.getParentFunctionId();
          String _functionId = parent.getFunctionId();
          boolean _equals = Objects.equal(_parentFunctionId, _functionId);
          return Boolean.valueOf(_equals);
        }
      };
    Iterable<UIAppFunction> _filter = IterableExtensions.<UIAppFunction>filter(functions, _function);
    return _filter;
  }
  
  public Iterable<UIAppFunction> getRootElements(final Iterable<UIAppFunction> functions) {
    final Function1<UIAppFunction,Boolean> _function = new Function1<UIAppFunction,Boolean>() {
        public Boolean apply(final UIAppFunction it) {
          String _parentFunctionId = it.getParentFunctionId();
          boolean _equals = Objects.equal(_parentFunctionId, null);
          return Boolean.valueOf(_equals);
        }
      };
    Iterable<UIAppFunction> _filter = IterableExtensions.<UIAppFunction>filter(functions, _function);
    return _filter;
  }
}
