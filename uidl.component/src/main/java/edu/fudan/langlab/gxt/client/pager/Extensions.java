package edu.fudan.langlab.gxt.client.pager;

import com.uniquesoft.gwt.client.common.widgets.ObjectListView;
import com.uniquesoft.gwt.client.common.widgets.pager.IPager;
import edu.fudan.langlab.gxt.client.pager.GXTPager;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class Extensions {
  public static <T extends Object> IPager<T> createPager(final ObjectListView<T> objectListView) {
    GXTPager<T> _gXTPager = new GXTPager<T>(objectListView);
    final Procedure1<GXTPager<T>> _function = new Procedure1<GXTPager<T>>() {
        public void apply(final GXTPager<T> it) {
          it.setActivePage(1);
          it.setPageSize(30);
        }
      };
    GXTPager<T> _doubleArrow = ObjectExtensions.<GXTPager<T>>operator_doubleArrow(_gXTPager, _function);
    return _doubleArrow;
  }
}
