package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProductWarehouseStorageSummaryProxy;
import com.fudanmed.platform.core.web.client.warehouse.ProductStoreTransactionListPresenter;
import com.fudanmed.platform.core.web.client.warehouse.ProductStoreTransactionListPresenterView;
import com.fudanmed.platform.core.web.client.warehouse.ProductSummarySnapshotManagementPresenterView;
import com.fudanmed.platform.core.web.client.warehouse.ProductSummarySnapshotQueryListPresenter;
import com.fudanmed.platform.core.web.client.warehouse.ProductSummarySnapshotQueryListPresenterView;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSummarySnapshotCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSummarySnapshotStatCriteriaData;
import com.google.common.base.Objects;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider.SelectionChangedListener;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.widget.FramedPanel;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.gxt.client.widget.TabPanel;
import edu.fudan.langlab.security.client.Securities;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ProductSummarySnapshotManagementView extends GWTAbstractView implements ProductSummarySnapshotManagementPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    initialize();
    postInitialize.initializeFinished(null);
    
  }
  
  @Inject
  private Securities securities;
  
  @Inject
  private EventBus eventBus;
  
  private ProductSummarySnapshotQueryListPresenter queryListPresenter;
  
  public void setQueryListPresenter(final ProductSummarySnapshotQueryListPresenter queryListPresenter) {
    this.queryListPresenter = queryListPresenter;
  }
  
  private ProductStoreTransactionListPresenter productStoreTransactionListPresenter;
  
  public void setProductStoreTransactionListPresenter(final ProductStoreTransactionListPresenter productStoreTransactionListPresenter) {
    this.productStoreTransactionListPresenter = productStoreTransactionListPresenter;
  }
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    ProductSummarySnapshotQueryListPresenterView _view = this.queryListPresenter.getView();
    final ActionContext<UIProductSummarySnapshotStatCriteriaData> ac = _view.getActionContext();
    final Procedure1<Iterable<UIProductSummarySnapshotStatCriteriaData>> _function = new Procedure1<Iterable<UIProductSummarySnapshotStatCriteriaData>>() {
        public void apply(final Iterable<UIProductSummarySnapshotStatCriteriaData> selection) {
          UIProductSummarySnapshotStatCriteriaData _onlySelected = selection==null?(UIProductSummarySnapshotStatCriteriaData)null:IterableExtensions2.<UIProductSummarySnapshotStatCriteriaData>getOnlySelected(selection);
          boolean _notEquals = (!Objects.equal(_onlySelected, null));
          if (_notEquals) {
            UIProductSummarySnapshotStatCriteriaData _onlySelected_1 = IterableExtensions2.<UIProductSummarySnapshotStatCriteriaData>getOnlySelected(selection);
            RCProductWarehouseStorageSummaryProxy _storageSummary = _onlySelected_1.getStorageSummary();
            ProductSummarySnapshotQueryListPresenterView _view = ProductSummarySnapshotManagementView.this.queryListPresenter.getView();
            UIProductSummarySnapshotCriteria _criteria = _view.getCriteria();
            Date _dateFrom = _criteria.getDateFrom();
            ProductSummarySnapshotQueryListPresenterView _view_1 = ProductSummarySnapshotManagementView.this.queryListPresenter.getView();
            UIProductSummarySnapshotCriteria _criteria_1 = _view_1.getCriteria();
            Date _dateTo = _criteria_1.getDateTo();
            ProductSummarySnapshotManagementView.this.productStoreTransactionListPresenter.setProductStorage4Summary(_storageSummary, _dateFrom, _dateTo);
          } else {
            ProductSummarySnapshotManagementView.this.productStoreTransactionListPresenter.reset();
          }
        }
      };
    ac.addSelectionChangedListener(new SelectionChangedListener<UIProductSummarySnapshotStatCriteriaData>() {
        public void selectionChanged(Iterable<UIProductSummarySnapshotStatCriteriaData> selections) {
          _function.apply(selections);
        }
    });
    FramedPanel _FramedPanel = this.widgets.FramedPanel("\u5E93\u5B58\u53D8\u52A8\u67E5\u8BE2");
    final Procedure1<FramedPanel> _function_1 = new Procedure1<FramedPanel>() {
        public void apply(final FramedPanel it) {
          VerticalLayoutContainer _VLayout = ProductSummarySnapshotManagementView.this.widgets.VLayout();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                ProductSummarySnapshotQueryListPresenterView _view = ProductSummarySnapshotManagementView.this.queryListPresenter.getView();
                Widget _asWidget = _view.asWidget();
                VerticalLayoutData _VLayoutData = ProductSummarySnapshotManagementView.this.widgets.VLayoutData(1, 0.7);
                it.add(_asWidget, _VLayoutData);
                TabPanel _TabPanel = ProductSummarySnapshotManagementView.this.widgets.TabPanel();
                final Procedure1<TabPanel> _function = new Procedure1<TabPanel>() {
                    public void apply(final TabPanel it) {
                      ProductStoreTransactionListPresenterView _view = ProductSummarySnapshotManagementView.this.productStoreTransactionListPresenter.getView();
                      Widget _asWidget = _view.asWidget();
                      it.add(_asWidget, "\u5E93\u5B58\u53D8\u52A8\u660E\u7EC6");
                    }
                  };
                TabPanel _doubleArrow = ObjectExtensions.<TabPanel>operator_doubleArrow(_TabPanel, _function);
                VerticalLayoutData _VLayoutData_1 = ProductSummarySnapshotManagementView.this.widgets.VLayoutData(1, 0.3);
                it.add(_doubleArrow, _VLayoutData_1);
              }
            };
          VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
          it.setWidget(_doubleArrow);
        }
      };
    FramedPanel _doubleArrow = ObjectExtensions.<FramedPanel>operator_doubleArrow(_FramedPanel, _function_1);
    this.con = _doubleArrow;
  }
}
