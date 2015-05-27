package edu.fudan.mylang.common;

import java.util.ArrayList;

import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import com.google.common.base.Objects;

import edu.fudan.mylang.pf.util.PathBuilder;

@SuppressWarnings("all")
public class ObjectExtensions2 {
  public static <T extends Object> T with(final T obj, final Procedure1<? super T> init) {
      init.apply(obj);
      return obj;
  }
  
  public static <T extends Object> T withDefault(final T obj, final Function1<Void,T> creator){
	  if(obj==null) return creator.apply(null);
	  else return obj;
  }
  
  public static <T extends Object> ArrayList<String> buildPath(final T t, final Function1<? super T,? extends T> parentCalculator, final Function1<? super T,? extends String> pathNodeBuilder) {
	    ArrayList<String> _xblockexpression = null;
	    {
	      String _apply = pathNodeBuilder.apply(t);
	      final ArrayList<String> result = CollectionLiterals.<String>newArrayList(_apply);
	      T curRoot = parentCalculator.apply(t);
	      boolean _notEquals = (!Objects.equal(curRoot, null));
	      boolean _while = _notEquals;
	      while (_while) {
	        {
	          String _apply_1 = pathNodeBuilder.apply(curRoot);
	          result.add(_apply_1);
	          T _apply_2 = parentCalculator.apply(curRoot);
	          curRoot = _apply_2;
	        }
	        boolean _notEquals_1 = (!Objects.equal(curRoot, null));
	        _while = _notEquals_1;
	      }
	      _xblockexpression = (result);
	    }
	    return _xblockexpression;
	  }
	  
	  public static <T extends Object> void visit(final T t, final Function1<? super T,? extends Iterable<T>> getChildren, final Procedure1<? super T> visitor) {
	    visitor.apply(t);
	    Iterable<T> _apply = getChildren.apply(t);
	    final Procedure1<T> _function = new Procedure1<T>() {
	        public void apply(final T it) {
	          PathBuilder.<T>visit(it, getChildren, visitor);
	        }
	      };
	    if (_apply!=null) IterableExtensions.<T>forEach(_apply, _function);
	  } 
}
