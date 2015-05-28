package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.common.ServerSideTimeServiceAsync;
import com.fudanmed.platform.core.web.client.project.WorkItemMisDispatchingDataForm;
import com.fudanmed.platform.core.web.client.project.WorkItemMisDispatchingPresenterView;
import com.fudanmed.platform.core.web.shared.project.WorkItemMisDispatchingData;
import com.google.gwt.editor.client.HasEditorErrors;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
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

public class WorkItemMisDispatchingView extends ErrorNotifierViewer implements WorkItemMisDispatchingPresenterView, IHasSize, IHasTitle {
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
  private WorkItemMisDispatchingDataForm form;
  
  @Inject
  private ServerSideTimeServiceAsync timeService;
  
  public void initialize() {
    
    VerticalLayoutContainer _VLayout = this.widgets.VLayout();
    final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
        public void apply(final VerticalLayoutContainer it) {
          Widget _asWidget = WorkItemMisDispatchingView.this.form.asWidget();
          final Procedure1<Widget> _function = new Procedure1<Widget>() {
              public void apply(final Widget it) {
                final Procedure1<Date> _function = new Procedure1<Date>() {
                    public void apply(final Date it) {
                      Date _trimDate = DateUtil.trimDate(it);
                      WorkItemMisDispatchingView.this.form.finishDate.setValue(_trimDate);
                      WorkItemMisDispatchingView.this.form.finishTime.setValue(it);
                    }
                  };
                AsyncCallback<Date> _onSuccess = WorkItemMisDispatchingView.this.<Date>onSuccess(_function);
                WorkItemMisDispatchingView.this.timeService.getTime(_onSuccess);
                FieldLabel _asWidget = WorkItemMisDispatchingView.this.form.alsoReport.asWidget();
                final Procedure1<FieldLabel> _function_1 = new Procedure1<FieldLabel>() {
                    public void apply(final FieldLabel it) {
                      it.disable();
                    }
                  };
                ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget, _function_1);
                FieldLabel _asWidget_1 = WorkItemMisDispatchingView.this.form.reportComment.asWidget();
                final Procedure1<FieldLabel> _function_2 = new Procedure1<FieldLabel>() {
                    public void apply(final FieldLabel it) {
                      it.disable();
                    }
                  };
                ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget_1, _function_2);
              }
            };
          Widget _doubleArrow = ObjectExtensions.<Widget>operator_doubleArrow(_asWidget, _function);
          int _minus = (-1);
          VerticalLayoutData _VLayoutData = WorkItemMisDispatchingView.this.widgets.VLayoutData(1, _minus, 10);
          it.add(_doubleArrow, _VLayoutData);
        }
      };
    VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
    ClientUi.operator_add(this, _doubleArrow);
  }
  
  public WorkItemMisDispatchingData getValue() {
    WorkItemMisDispatchingData _value = this.form.getValue();
    return _value;
  }
  
  public HasEditorErrors mapField(final String errorKey) {
    HasEditorErrors _mapToErrorEditor = Validations.mapToErrorEditor(this.form, errorKey);
    return _mapToErrorEditor;
  }
  
  public void clearErrors() {
    Validations.clearErrors(this.form);
  }
  
  public Size getSize() {
    Size _size = new Size(400, 360);
    return _size;
  }
  
  public String getTitle() {
    return "\u5DE5\u5355\u4E32\u5355";
  }
  
  public void setComment(final String comment) {
    this.form.comment.setValue(comment);
  }
  
  public void canReport() {
    FieldLabel _asWidget = this.form.alsoReport.asWidget();
    final Procedure1<FieldLabel> _function = new Procedure1<FieldLabel>() {
        public void apply(final FieldLabel it) {
          WorkItemMisDispatchingView.this.form.alsoReport.setValue(Boolean.valueOf(true));
          it.enable();
        }
      };
    ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget, _function);
    FieldLabel _asWidget_1 = this.form.reportComment.asWidget();
    final Procedure1<FieldLabel> _function_1 = new Procedure1<FieldLabel>() {
        public void apply(final FieldLabel it) {
          it.enable();
        }
      };
    ObjectExtensions.<FieldLabel>operator_doubleArrow(_asWidget_1, _function_1);
  }
}
