package edu.fudan.langlab.security.client;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.security.client.ISecurityManager;
import edu.fudan.langlab.security.shared.FunctionIdentifier;
import edu.fudan.langlab.security.shared.IFunctionIdentifier;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Singleton
@SuppressWarnings("all")
public class Securities implements IInitializerSupport {
  @Inject
  private ISecurityManager securityManager;
  
  public void check(final IFunctionIdentifier id, final Procedure1<? super Void> initializer) {
    boolean _canAccess = this.securityManager.canAccess(id);
    if (_canAccess) {
      initializer.apply(null);
    }
  }
  
  public void check(final String id, final Procedure1<? super Void> initializer) {
    FunctionIdentifier _functionIdentifier = new FunctionIdentifier(id);
    boolean _canAccess = this.securityManager.canAccess(_functionIdentifier);
    if (_canAccess) {
      initializer.apply(null);
    }
  }
  
  public void check(final boolean requireCheck, final String id, final Procedure1<? super Void> initializer) {
    boolean _not = (!requireCheck);
    if (_not) {
      initializer.apply(null);
    } else {
      FunctionIdentifier _functionIdentifier = new FunctionIdentifier(id);
      boolean _canAccess = this.securityManager.canAccess(_functionIdentifier);
      if (_canAccess) {
        initializer.apply(null);
      }
    }
  }
  
  public void setAsSuperuser() {
    this.securityManager.setAsSuperuser();
  }
  
  public void registValidFunction(final IFunctionIdentifier fi) {
    this.securityManager.addFunctionIdentifier(fi);
  }
  
  public void initialize(final IPostInitializeAction postInitialize) {
    postInitialize.initializeFinished(null);
  }
}
