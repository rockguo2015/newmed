package edu.fudan.langlab.uidl.domain.app.client.security;

import com.google.gwt.editor.client.HasEditorErrors;
import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.IHasSize;
import com.uniquesoft.gwt.client.common.widgets.IHasTitle;
import com.uniquesoft.gwt.client.common.widgets.Size;
import edu.fudan.langlab.domain.security.proxy.RoleProxy;
import edu.fudan.langlab.gxt.client.component.form.Validations;
import edu.fudan.langlab.gxt.client.validation.ErrorNotifierViewer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import edu.fudan.langlab.uidl.domain.app.client.security.SelectRoles4UserPresenterView;
import edu.fudan.langlab.uidl.domain.app.client.security.UserRolesForm;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIUserRoles;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class SelectRoles4UserView extends ErrorNotifierViewer implements SelectRoles4UserPresenterView, IHasSize, IHasTitle {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(form),
    	new com.uniquesoft.gwt.client.common.async.IPostInitializeAction(){
    
    	public void initializeFinished(Void v) {
    		initialize();
    		postInitialize.initializeFinished(null);
    	}
    });
    
  }
  
  @Inject
  private Securities securities;
  
  @Inject
  private EventBus eventBus;
  
  @Inject
  private UserRolesForm form;
  
  public void initialize() {
    
    FieldLabel _asWidget = this.form.roles.asWidget();
    final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
        public void apply(final FieldLabel it) {
          it.setWidth("400");
          it.setHeight("230");
        }
      };
    FieldLabel _doubleArrow = ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget, _function);
    ClientUi.operator_add(this, _doubleArrow);
  }
  
  public UIUserRoles getValue() {
    UIUserRoles _value = this.form.getValue();
    return _value;
  }
  
  public HasEditorErrors mapField(final String errorKey) {
    HasEditorErrors _mapToErrorEditor = Validations.mapToErrorEditor(this.form, errorKey);
    return _mapToErrorEditor;
  }
  
  public void clearErrors() {
    Validations.clearErrors(this.form);
  }
  
  public void setRoles(final Collection<RoleProxy> roles) {
    this.form.roles.setValue(roles);
  }
  
  public Size getSize() {
    Size _size = new Size(420, 350);
    return _size;
  }
  
  public String getTitle() {
    return "\u7528\u6237\u89D2\u8272\u8BBE\u7F6E";
  }
}
