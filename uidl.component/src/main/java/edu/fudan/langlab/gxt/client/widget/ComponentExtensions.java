package edu.fudan.langlab.gxt.client.widget;

import com.sencha.gxt.data.shared.Store;
import com.sencha.gxt.widget.core.client.form.StoreFilterField;
import edu.fudan.langlab.gxt.client.widget.IHasStoreComponent;
import edu.fudan.langlab.gxt.client.widget.StoreFilterFieldAdaptor;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.Functions.Function4;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class ComponentExtensions {
  public static <T extends Object> StoreFilterField<T> createFilter(final IHasStoreComponent<T> component, final Function4<? super Store<T>,? super T,? super T,? super String,? extends Boolean> m) {
    StoreFilterField<T> _create = StoreFilterFieldAdaptor.<T>create(m);
    final Procedure1<StoreFilterField<T>> _function = new Procedure1<StoreFilterField<T>>() {
        public void apply(final StoreFilterField<T> it) {
          Store<T> _store = component.getStore();
          it.bind(_store);
        }
      };
    StoreFilterField<T> _doubleArrow = ObjectExtensions.<StoreFilterField<T>>operator_doubleArrow(_create, _function);
    return _doubleArrow;
  }
  
  public static <T extends Object> StoreFilterField<T> createFilter(final IHasStoreComponent<T> component, final Function2<? super T,? super String,? extends Boolean> m) {
    StoreFilterField<T> _create = StoreFilterFieldAdaptor.<T>create(m);
    final Procedure1<StoreFilterField<T>> _function = new Procedure1<StoreFilterField<T>>() {
        public void apply(final StoreFilterField<T> it) {
          Store<T> _store = component.getStore();
          it.bind(_store);
        }
      };
    StoreFilterField<T> _doubleArrow = ObjectExtensions.<StoreFilterField<T>>operator_doubleArrow(_create, _function);
    return _doubleArrow;
  }
}
