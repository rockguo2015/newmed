package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.web.client.organization.ChangePasswdDataForm;
import com.fudanmed.platform.core.web.client.organization.ChangePasswdPresenterView;
import com.fudanmed.platform.core.web.shared.organization.UIChangePasswdData;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.IHasSize;
import com.uniquesoft.gwt.client.common.widgets.IHasTitle;
import com.uniquesoft.gwt.client.common.widgets.Size;
import edu.fudan.langlab.gxt.client.component.form.FormViewerImpl;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;

public class ChangePasswdView extends FormViewerImpl<UIChangePasswdData> implements ChangePasswdPresenterView, IHasTitle, IHasSize {
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
  private ChangePasswdDataForm form;
  
  public ChangePasswdDataForm doGetFormComponent() {
    return form;
  }
  
  public String getTitle() {
    return "修改密码";
  }
  
  public Size getSize() {
    return new com.uniquesoft.gwt.client.common.widgets.Size(250,200);
  }
  
  public void initialize() {
    
    Widget _asWidget = this.form.asWidget();
    ClientUi.operator_add(this, _asWidget);
  }
}
