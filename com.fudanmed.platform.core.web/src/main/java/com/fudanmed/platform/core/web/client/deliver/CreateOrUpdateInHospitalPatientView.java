package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateInHospitalPatientPresenterView;
import com.fudanmed.platform.core.web.client.deliver.InHospitalPatientForm;
import com.fudanmed.platform.core.web.client.deliver.InHospitalPatientListGrid;
import com.fudanmed.platform.core.web.shared.deliver.UIInHospitalPatient;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.action.ActionExtensions;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.IHasSize;
import com.uniquesoft.gwt.client.common.widgets.IHasTitle;
import com.uniquesoft.gwt.client.common.widgets.Size;
import edu.fudan.langlab.gxt.client.component.form.FormViewerImpl;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;

public class CreateOrUpdateInHospitalPatientView extends FormViewerImpl<UIInHospitalPatient> implements CreateOrUpdateInHospitalPatientPresenterView, IHasSize, IHasTitle {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(patientform,listGrid,form),
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
  private InHospitalPatientForm form;
  
  public InHospitalPatientForm doGetFormComponent() {
    return form;
  }
  
  public Size getSize() {
    return new com.uniquesoft.gwt.client.common.widgets.Size(400,300);
  }
  
  public String getTitle() {
    return "新增病人";
  }
  
  @Inject
  private InHospitalPatientForm patientform;
  
  @Inject
  private InHospitalPatientListGrid listGrid;
  
  public void initialize() {
    
    Widget _asWidget = this.form.asWidget();
    VerticalLayoutContainer _DialogContent = this.widgets.DialogContent(_asWidget);
    ClientUi.operator_add(this, _DialogContent);
  }
  
  public ActionContext<UIInHospitalPatient> getActionContext() {
    ActionContext<UIInHospitalPatient> _createActionContext = ActionExtensions.<UIInHospitalPatient>createActionContext(this.listGrid);
    return _createActionContext;
  }
}
