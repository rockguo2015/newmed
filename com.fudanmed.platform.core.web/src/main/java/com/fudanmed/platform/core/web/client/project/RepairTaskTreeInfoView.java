package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.device.PictureListPresenter;
import com.fudanmed.platform.core.web.client.device.PictureListPresenterView;
import com.fudanmed.platform.core.web.client.project.ComplaintListPresenter;
import com.fudanmed.platform.core.web.client.project.ComplaintListPresenterView;
import com.fudanmed.platform.core.web.client.project.GeneralTaskTreeList;
import com.fudanmed.platform.core.web.client.project.RepairTaskDetailInfoPresenter;
import com.fudanmed.platform.core.web.client.project.RepairTaskDetailInfoPresenterView;
import com.fudanmed.platform.core.web.client.project.RepairTaskTreeInfoPresenterView;
import com.fudanmed.platform.core.web.client.project.ShowRepairEvaluatePresenter;
import com.fudanmed.platform.core.web.client.project.ShowRepairEvaluatePresenterView;
import com.fudanmed.platform.core.web.client.tree.GeneralTaskTreeContentProvider;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemStorageListPresenter;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemStorageListPresenterView;
import com.fudanmed.platform.core.web.shared.project.UIGeneralTask;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.form.FieldSet;
import com.sencha.gxt.widget.core.client.form.TextArea;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.IHasSize;
import com.uniquesoft.gwt.client.common.widgets.IHasTitle;
import com.uniquesoft.gwt.client.common.widgets.ObjectListView.SelectEntityListener;
import com.uniquesoft.gwt.client.common.widgets.Size;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.component.treegrid.SGrid;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.TabPanel;
import edu.fudan.langlab.security.client.Securities;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class RepairTaskTreeInfoView extends GWTAbstractView implements RepairTaskTreeInfoPresenterView, IHasSize, IHasTitle {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(treeList),
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
  
  private RepairTaskDetailInfoPresenter repairTaskDetailInfoPresenter;
  
  public void setRepairTaskDetailInfoPresenter(final RepairTaskDetailInfoPresenter repairTaskDetailInfoPresenter) {
    this.repairTaskDetailInfoPresenter = repairTaskDetailInfoPresenter;
  }
  
  private WorkItemStorageListPresenter workItemStorageListPresenter;
  
  public void setWorkItemStorageListPresenter(final WorkItemStorageListPresenter workItemStorageListPresenter) {
    this.workItemStorageListPresenter = workItemStorageListPresenter;
  }
  
  private ShowRepairEvaluatePresenter showRepairEvaluatePresenter;
  
  public void setShowRepairEvaluatePresenter(final ShowRepairEvaluatePresenter showRepairEvaluatePresenter) {
    this.showRepairEvaluatePresenter = showRepairEvaluatePresenter;
  }
  
  private ComplaintListPresenter complaintListPresenter;
  
  public void setComplaintListPresenter(final ComplaintListPresenter complaintListPresenter) {
    this.complaintListPresenter = complaintListPresenter;
  }
  
  private PictureListPresenter workitemPictureListPresenter;
  
  public void setWorkitemPictureListPresenter(final PictureListPresenter workitemPictureListPresenter) {
    this.workitemPictureListPresenter = workitemPictureListPresenter;
  }
  
  private Widget con;
  
  @Inject
  private GeneralTaskTreeList treeList;
  
  private TextArea comment;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    TabPanel _TabPanel = this.widgets.TabPanel();
    final Procedure1<TabPanel> _function = new Procedure1<TabPanel>() {
        public void apply(final TabPanel it) {
          RepairTaskDetailInfoPresenterView _view = RepairTaskTreeInfoView.this.repairTaskDetailInfoPresenter.getView();
          Widget _asWidget = _view.asWidget();
          it.add(_asWidget, "\u62A5\u4FEE\u4FE1\u606F");
          WorkItemStorageListPresenterView _view_1 = RepairTaskTreeInfoView.this.workItemStorageListPresenter.getView();
          Widget _asWidget_1 = _view_1.asWidget();
          it.add(_asWidget_1, "\u7528\u6599\u4FE1\u606F");
          HorizontalLayoutContainer _HLayout = RepairTaskTreeInfoView.this.widgets.HLayout();
          final Procedure1<HorizontalLayoutContainer> _function = new Procedure1<HorizontalLayoutContainer>() {
              public void apply(final HorizontalLayoutContainer it) {
                SGrid<UIGeneralTask> _asWidget = RepairTaskTreeInfoView.this.treeList.asWidget();
                HorizontalLayoutData _HLayoutData = RepairTaskTreeInfoView.this.widgets.HLayoutData(0.7, 1);
                it.add(_asWidget, _HLayoutData);
                FieldSet _FieldSet = RepairTaskTreeInfoView.this.widgets.FieldSet("\u7EF4\u4FEE\u8BF4\u660E");
                final Procedure1<FieldSet> _function = new Procedure1<FieldSet>() {
                    public void apply(final FieldSet it) {
                      VerticalLayoutContainer _VLayout = RepairTaskTreeInfoView.this.widgets.VLayout();
                      final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
                          public void apply(final VerticalLayoutContainer it) {
                            TextArea _textArea = new TextArea();
                            TextArea _comment = RepairTaskTreeInfoView.this.comment = _textArea;
                            VerticalLayoutData _VLayoutData = RepairTaskTreeInfoView.this.widgets.VLayoutData(1, 1);
                            it.add(_comment, _VLayoutData);
                          }
                        };
                      VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
                      it.setWidget(_doubleArrow);
                    }
                  };
                FieldSet _doubleArrow = ObjectExtensions.<FieldSet>operator_doubleArrow(_FieldSet, _function);
                HorizontalLayoutData _HLayoutData_1 = RepairTaskTreeInfoView.this.widgets.HLayoutData(0.3, 1);
                it.add(_doubleArrow, _HLayoutData_1);
              }
            };
          HorizontalLayoutContainer _doubleArrow = ObjectExtensions.<HorizontalLayoutContainer>operator_doubleArrow(_HLayout, _function);
          it.add(_doubleArrow, "\u7EF4\u4FEE\u4FE1\u606F");
          ComplaintListPresenterView _view_2 = RepairTaskTreeInfoView.this.complaintListPresenter.getView();
          Widget _asWidget_2 = _view_2.asWidget();
          it.add(_asWidget_2, "\u6295\u8BC9\u4FE1\u606F");
          ShowRepairEvaluatePresenterView _view_3 = RepairTaskTreeInfoView.this.showRepairEvaluatePresenter.getView();
          Widget _asWidget_3 = _view_3.asWidget();
          it.add(_asWidget_3, "\u8BC4\u4EF7\u4FE1\u606F");
          PictureListPresenterView _view_4 = RepairTaskTreeInfoView.this.workitemPictureListPresenter.getView();
          Widget _asWidget_4 = _view_4.asWidget();
          it.add(_asWidget_4, "\u5DE5\u5355\u56FE\u7247");
          final Procedure1<UIGeneralTask> _function_1 = new Procedure1<UIGeneralTask>() {
              public void apply(final UIGeneralTask it) {
                showCommentRequestRequestHandler.execute(it);
                
              }
            };
          RepairTaskTreeInfoView.this.treeList.addSelectEntityListener(new SelectEntityListener<UIGeneralTask>() {
              public void objectSelected(UIGeneralTask selected) {
                _function_1.apply(selected);
              }
          });
        }
      };
    TabPanel _doubleArrow = ObjectExtensions.<TabPanel>operator_doubleArrow(_TabPanel, _function);
    this.con = _doubleArrow;
  }
  
  public Size getSize() {
    Size _size = new Size(800, 400);
    return _size;
  }
  
  public String getTitle() {
    return "\u62A5\u4FEE\u5355\u8BE6\u60C5";
  }
  
  public void setResults(final Collection<UIGeneralTask> results) {
    
    final Function1<UIGeneralTask,Date> _function = new Function1<UIGeneralTask,Date>() {
        public Date apply(final UIGeneralTask it) {
          Date _dateTime = it.getDateTime();
          return _dateTime;
        }
      };
    List<UIGeneralTask> _sortBy = IterableExtensions.<UIGeneralTask, Date>sortBy(results, _function);
    List<UIGeneralTask> _reverse = ListExtensions.<UIGeneralTask>reverse(_sortBy);
    GeneralTaskTreeContentProvider _generalTaskTreeContentProvider = new GeneralTaskTreeContentProvider(_reverse);
    this.treeList.setContentProvider(_generalTaskTreeContentProvider);
  }
  
  public void showComment(final String comment) {
    
    this.comment.setValue(comment);
  }
  
  private RequestHandler1<UIGeneralTask> showCommentRequestRequestHandler;
  
  public void showCommentRequest(final RequestHandler1<UIGeneralTask> requestHandler) {
    this.showCommentRequestRequestHandler = requestHandler;
  }
}
