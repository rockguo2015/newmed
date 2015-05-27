package edu.fudan.mylang.common;

import com.google.common.base.Objects;
import edu.fudan.mylang.common.ObjectExtensions2;
import edu.fudan.mylang.pf.IHasHierarchy;
import java.util.ArrayList;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class HierarchyExtensions {
  public static String getIdPath(final IHasHierarchy node) {
    String _xifexpression = null;
    boolean _equals = Objects.equal(node, null);
    if (_equals) {
      _xifexpression = null;
    } else {
      Long _id = node.getId();
      String _plus = ("[" + _id);
      String _plus_1 = (_plus + "]");
      _xifexpression = _plus_1;
    }
    return _xifexpression;
  }
  
  public static IHasHierarchy updateFullIdPath(final IHasHierarchy node) {
    final Function1<IHasHierarchy,IHasHierarchy> _function = new Function1<IHasHierarchy,IHasHierarchy>() {
        public IHasHierarchy apply(final IHasHierarchy it) {
          IHasHierarchy _hierarchyParent = it.getHierarchyParent();
          return _hierarchyParent;
        }
      };
    final Function1<IHasHierarchy,String> _function_1 = new Function1<IHasHierarchy,String>() {
        public String apply(final IHasHierarchy it) {
          String _idPath = HierarchyExtensions.getIdPath(it);
          return _idPath;
        }
      };
    ArrayList<String> _buildPath = ObjectExtensions2.<IHasHierarchy>buildPath(node, _function, _function_1);
    String _join = IterableExtensions.join(_buildPath);
    IHasHierarchy _setFullIdPath = node.setFullIdPath(_join);
    return _setFullIdPath;
  }
  
  public static String getFullNamePath(final IHasHierarchy node, final Function1<? super IHasHierarchy,? extends String> nameProvider) {
    String _fullNamePath = HierarchyExtensions.getFullNamePath(node, nameProvider, " ");
    return _fullNamePath;
  }
  
  public static String getFullNamePath(final IHasHierarchy node, final Function1<? super IHasHierarchy,? extends String> nameProvider, final String seperator) {
    final Function1<IHasHierarchy,IHasHierarchy> _function = new Function1<IHasHierarchy,IHasHierarchy>() {
        public IHasHierarchy apply(final IHasHierarchy it) {
          IHasHierarchy _hierarchyParent = it.getHierarchyParent();
          return _hierarchyParent;
        }
      };
    final Function1<IHasHierarchy,String> _function_1 = new Function1<IHasHierarchy,String>() {
        public String apply(final IHasHierarchy it) {
          String _apply = nameProvider.apply(it);
          return _apply;
        }
      };
    ArrayList<String> _buildPath = ObjectExtensions2.<IHasHierarchy>buildPath(node, _function, _function_1);
    String _join = IterableExtensions.join(_buildPath, seperator);
    return _join;
  }
  
  public static Boolean isChildren(final IHasHierarchy node, final IHasHierarchy testNode) {
    String _fullIdPath = testNode.getFullIdPath();
    String _idPath = HierarchyExtensions.getIdPath(node);
    boolean _contains = _fullIdPath.contains(_idPath);
    return Boolean.valueOf(_contains);
  }
  
  public static void changeParent(final IHasHierarchy node, final IHasHierarchy newParent) {
    node.setHierarchyParent(newParent);
    final Function1<IHasHierarchy,Iterable<IHasHierarchy>> _function = new Function1<IHasHierarchy,Iterable<IHasHierarchy>>() {
        public Iterable<IHasHierarchy> apply(final IHasHierarchy it) {
          Iterable<IHasHierarchy> _hierarchyChildren = it.getHierarchyChildren();
          return _hierarchyChildren;
        }
      };
    final Procedure1<IHasHierarchy> _function_1 = new Procedure1<IHasHierarchy>() {
        public void apply(final IHasHierarchy it) {
          HierarchyExtensions.updateFullIdPath(it);
        }
      };
    ObjectExtensions2.<IHasHierarchy>visit(node, _function, _function_1);
  }
}
