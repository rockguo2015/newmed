package com.uniquesoft.gwt.client.common.async;

import com.google.common.base.Objects;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * This class is used to make sure all the components in the view has initialized.
 * The components can initialize asynchronously. When all the components have finished to
 * get the necessary data, the view continue to display them.
 */
@SuppressWarnings("all")
public class InitializerManager {
  public static void initialize(final Collection<? extends IInitializerSupport> initializerSupports, final IPostInitializeAction postAction) {
    int _size = initializerSupports.size();
    boolean _equals = (_size == 0);
    if (_equals) {
      boolean _notEquals = (!Objects.equal(postAction, null));
      if (_notEquals) {
        postAction.initializeFinished(null);
      }
    } else {
      final Collection<IInitializerSupport> initializing = CollectionLiterals.<IInitializerSupport>newHashSet();
      final Procedure1<IInitializerSupport> _function = new Procedure1<IInitializerSupport>() {
          public void apply(final IInitializerSupport it) {
            initializing.add(it);
          }
        };
      IterableExtensions.forEach(initializerSupports, _function);
      final Procedure1<IInitializerSupport> _function_1 = new Procedure1<IInitializerSupport>() {
          public void apply(final IInitializerSupport initializerSupport) {
            final Procedure1<Void> _function = new Procedure1<Void>() {
                public void apply(final Void it) {
                  initializing.remove(initializerSupport);
                  boolean _isEmpty = initializing.isEmpty();
                  if (_isEmpty) {
                    postAction.initializeFinished(null);
                  }
                }
              };
            initializerSupport.initialize(new IPostInitializeAction() {
                public void initializeFinished(Void v) {
                  _function.apply(v);
                }
            });
          }
        };
      IterableExtensions.forEach(initializerSupports, _function_1);
    }
  }
}
