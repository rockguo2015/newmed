package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCFaultTypeProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.common.ServerSideTimeServiceAsync;
import com.fudanmed.platform.core.web.client.project.CreateOrUpdateWorkItemTaskPresenterView;
import com.fudanmed.platform.core.web.client.project.WorkItemTaskForm;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemTask;
import com.google.common.base.Objects;
import com.google.gwt.editor.client.HasEditorErrors;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.IHasSize;
import com.uniquesoft.gwt.client.common.widgets.IHasTitle;
import com.uniquesoft.gwt.client.common.widgets.Size;
import com.uniquesoft.gwt.shared.DateUtil;
import edu.fudan.langlab.gxt.client.component.form.Validations;
import edu.fudan.langlab.gxt.client.validation.ErrorNotifierViewer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateOrUpdateWorkItemTaskView extends ErrorNotifierViewer implements CreateOrUpdateWorkItemTaskPresenterView, IHasSize, IHasTitle {
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
  private WorkItemTaskForm form;
  
  @Inject
  private ServerSideTimeServiceAsync timeService;
  
  public void initialize() {
    
    VerticalLayoutContainer _VLayout = this.widgets.VLayout();
    final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
        public void apply(final VerticalLayoutContainer it) {
          Widget _asWidget = CreateOrUpdateWorkItemTaskView.this.form.asWidget();
          final Procedure1<Widget> _function = new Procedure1<Widget>() {
              public void apply(final Widget it) {
                final Procedure1<Date> _function = new Procedure1<Date>() {
                    public void apply(final Date it) {
                      Date _trimDate = DateUtil.trimDate(it);
                      CreateOrUpdateWorkItemTaskView.this.form.date.setValue(_trimDate);
                      CreateOrUpdateWorkItemTaskView.this.form.time.setValue(it);
                    }
                  };
                AsyncCallback<Date> _onSuccess = CreateOrUpdateWorkItemTaskView.this.<Date>onSuccess(_function);
                CreateOrUpdateWorkItemTaskView.this.timeService.getTime(_onSuccess);
              }
            };
          Widget _doubleArrow = ObjectExtensions.<Widget>operator_doubleArrow(_asWidget, _function);
          int _minus = (-1);
          VerticalLayoutData _VLayoutData = CreateOrUpdateWorkItemTaskView.this.widgets.VLayoutData(1, _minus, 10);
          it.add(_doubleArrow, _VLayoutData);
        }
      };
    VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
    ClientUi.operator_add(this, _doubleArrow);
  }
  
  public UIWorkItemTask getValue() {
    UIWorkItemTask _value = this.form.getValue();
    return _value;
  }
  
  public HasEditorErrors mapField(final String errorKey) {
    HasEditorErrors _mapToErrorEditor = Validations.mapToErrorEditor(this.form, errorKey);
    return _mapToErrorEditor;
  }
  
  public void clearErrors() {
    Validations.clearErrors(this.form);
  }
  
  public void setValue(final UIWorkItemTask value) {
    this.form.setValue(value);
  }
  
  public Size getSize() {
    Size _size = new Size(540, 400);
    return _size;
  }
  
  public String getTitle() {
    return "\u5DE5\u5355\u6D3E\u5DE5";
  }
  
  public void setDefaultValues(final RCEmployeeProxy operator, final RCFaultTypeProxy faultType, final String faultDescription, final RCOrganizationProxy team, final Procedure1<? super Void> p) {
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          boolean _notEquals = (!Objects.equal(operator, null));
          if (_notEquals) {
            CreateOrUpdateWorkItemTaskView.this.form.operator.setValue(operator);
          }
          boolean _notEquals_1 = (!Objects.equal(faultType, null));
          if (_notEquals_1) {
            CreateOrUpdateWorkItemTaskView.this.form.faultType.setValue(faultType);
          }
          boolean _notEquals_2 = (!Objects.equal(faultDescription, null));
          if (_notEquals_2) {
            CreateOrUpdateWorkItemTaskView.this.form.faultDescription.setValue(faultDescription);
          }
          p.apply(null);
        }
      };
    this.form.workersContentProvider.load(team, _function);
  }
}
