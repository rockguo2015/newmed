package edu.fudan.langlab.gxt.client.widget;

import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.uniquesoft.gwt.client.common.widgets.pager.IPager;
import com.uniquesoft.gwt.client.common.widgets.pager.IPager.GotoPageHandler;
import com.uniquesoft.gwt.shared.common.pager.IPagedCriteria;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.pager.GXTPager;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

@SuppressWarnings("all")
public class PagedList<T extends Object, C extends IPagedCriteria> {
  private final GXTGridComponent<T> gridComponent;
  
  private final IPager pager;
  
  private final ContentPanel content;
  
  private final Function1<? super Void,? extends C> criteriaProvider;
  
  public static <T extends Object, C extends IPagedCriteria> PagedList<T,C> asPagedList(final GXTGridComponent<T> gridComponent, final Function1<? super Void,? extends C> criteriaProvider, final Procedure1<? super IPagedCriteria> notifier) {
    PagedList<T,C> _pagedList = new PagedList<T,C>(gridComponent, criteriaProvider, notifier);
    return _pagedList;
  }
  
  public PagedList(final GXTGridComponent gridComponent, final Function1<? super Void,? extends C> criteriaProvider, final Procedure1<? super IPagedCriteria> notifier) {
    this.gridComponent = gridComponent;
    this.criteriaProvider = criteriaProvider;
    GXTPager<T> _gXTPager = new GXTPager<T>(gridComponent);
    final Procedure1<GXTPager<T>> _function = new Procedure1<GXTPager<T>>() {
        public void apply(final GXTPager<T> it) {
          it.setActivePage(1);
          it.setPageSize(30);
          final Procedure2<Integer,Integer> _function = new Procedure2<Integer,Integer>() {
              public void apply(final Integer pageNum, final Integer recordsPerPage) {
                IPagedCriteria _criteria = PagedList.this.getCriteria();
                final Procedure1<IPagedCriteria> _function = new Procedure1<IPagedCriteria>() {
                    public void apply(final IPagedCriteria c) {
                      c.setPage(Integer.valueOf(pageNum));
                      c.setPageSize(Integer.valueOf(recordsPerPage));
                    }
                  };
                IPagedCriteria _doubleArrow = ObjectExtensions.<IPagedCriteria>operator_doubleArrow(_criteria, _function);
                notifier.apply(
                  ((IPagedCriteria) _doubleArrow));
              }
            };
          it.setPagerHandler(new GotoPageHandler() {
              public void gotoPage(int pageNum,int recordsPerPage) {
                _function.apply(pageNum,recordsPerPage);
              }
          });
        }
      };
    GXTPager<T> _doubleArrow = ObjectExtensions.<GXTPager<T>>operator_doubleArrow(_gXTPager, _function);
    this.pager = _doubleArrow;
    ContentPanel _contentPanel = new ContentPanel();
    final Procedure1<ContentPanel> _function_1 = new Procedure1<ContentPanel>() {
        public void apply(final ContentPanel it) {
          it.setHeaderVisible(false);
          VerticalLayoutContainer _verticalLayoutContainer = new VerticalLayoutContainer();
          final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
              public void apply(final VerticalLayoutContainer it) {
                SGroupingGrid _asWidget = gridComponent.asWidget();
                VerticalLayoutData _verticalLayoutData = new VerticalLayoutData(1, 1);
                it.add(_asWidget, _verticalLayoutData);
                Widget _asWidget_1 = PagedList.this.pager.asWidget();
                it.add(_asWidget_1);
              }
            };
          VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_verticalLayoutContainer, _function);
          it.setWidget(_doubleArrow);
        }
      };
    ContentPanel _doubleArrow_1 = ObjectExtensions.<ContentPanel>operator_doubleArrow(_contentPanel, _function_1);
    this.content = _doubleArrow_1;
    gridComponent.keepSelection();
  }
  
  public IPager getPager() {
    return this.pager;
  }
  
  public ContentPanel asWidget() {
    return this.content;
  }
  
  public C getCriteria() {
    C _xblockexpression = null;
    {
      final C criteria = this.criteriaProvider.apply(null);
      int _activePage = this.pager.getActivePage();
      int _minus = (-1);
      boolean _equals = (_activePage == _minus);
      if (_equals) {
        criteria.setPage(Integer.valueOf(1));
      } else {
        int _activePage_1 = this.pager.getActivePage();
        criteria.setPage(Integer.valueOf(_activePage_1));
      }
      int _pageSize = this.pager.getPageSize();
      criteria.setPageSize(Integer.valueOf(_pageSize));
      _xblockexpression = (criteria);
    }
    return _xblockexpression;
  }
  
  public void setResults(final IPagedResult<T> results) {
    this.pager.pageLoaded(results);
  }
  
  public void refresh(final Procedure1<? super Void> callback) {
    int _activePage = this.pager.getActivePage();
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          callback.apply(null);
        }
      };
    this.pager.gotoPage(_activePage, _function);
  }
  
  public void refresh() {
    int _activePage = this.pager.getActivePage();
    this.pager.gotoPage(_activePage);
  }
  
  public void reveal(final Object item) {
    this.gridComponent.reveal(item);
  }
}
