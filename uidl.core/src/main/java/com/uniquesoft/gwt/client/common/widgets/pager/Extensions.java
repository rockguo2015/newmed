package com.uniquesoft.gwt.client.common.widgets.pager;

import com.uniquesoft.gwt.client.common.widgets.pager.IPager;
import com.uniquesoft.gwt.shared.common.pager.IPagedCriteria;

@SuppressWarnings("all")
public class Extensions {
  public static <T extends IPagedCriteria> T withPagerInfo(final T pagedCriteria, final IPager pager) {
    T _xblockexpression = null;
    {
      int _activePage = pager.getActivePage();
      int _minus = (-1);
      boolean _equals = (_activePage == _minus);
      if (_equals) {
        pagedCriteria.setPage(Integer.valueOf(1));
      } else {
        int _activePage_1 = pager.getActivePage();
        pagedCriteria.setPage(Integer.valueOf(_activePage_1));
      }
      int _pageSize = pager.getPageSize();
      pagedCriteria.setPageSize(Integer.valueOf(_pageSize));
      _xblockexpression = (pagedCriteria);
    }
    return _xblockexpression;
  }
}
