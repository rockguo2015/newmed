package edu.fudan.langlab.uidl.domain.app.shared.security;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
import edu.fudan.langlab.domain.security.proxy.RoleProxy;
import java.util.Collection;

public class UIUserRoles implements IsSerializable {
  private Collection<RoleProxy> roles = com.google.common.collect.Lists.newArrayList();
  
  public Collection<RoleProxy> getRoles() {
    return this.roles;
  }
  
  public void setRoles(final Collection<RoleProxy> roles) {
    this.roles = roles;
  }
  
  public final static String P_Roles = "roles";
  
  public static IObjectFieldAccessor<UIUserRoles,Collection<RoleProxy>> RolesAccessor = new IObjectFieldAccessor<UIUserRoles,Collection<RoleProxy>>(){
    				public java.util.Collection<edu.fudan.langlab.domain.security.proxy.RoleProxy> getValue(UIUserRoles object){
    					return object.getRoles();
    				}
    				public void setValue(UIUserRoles object,java.util.Collection<edu.fudan.langlab.domain.security.proxy.RoleProxy> value){
    					object.setRoles(value);
    				}
    			};
}
