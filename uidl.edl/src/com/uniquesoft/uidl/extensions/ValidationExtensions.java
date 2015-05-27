package com.uniquesoft.uidl.extensions;

import com.google.common.base.Objects;
import com.uniquesoft.gwt.shared.GWTEntity;
import edu.fudan.mylang.pf.IModelObject;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

@SuppressWarnings("all")
public class ValidationExtensions {
  public static <T extends GWTEntity> boolean isUnique(final T uientity, final Function1<? super T,? extends IModelObject> valueFinder) {
    boolean _xblockexpression = false;
    {
      IModelObject result = valueFinder.apply(uientity);
      boolean _xifexpression = false;
      Long _id = uientity.getId();
      boolean _equals = Objects.equal(_id, null);
      if (_equals) {
        boolean _equals_1 = Objects.equal(result, null);
        _xifexpression = _equals_1;
      } else {
        boolean _or = false;
        boolean _equals_2 = Objects.equal(result, null);
        if (_equals_2) {
          _or = true;
        } else {
          Long _id_1 = result.getId();
          Long _id_2 = uientity.getId();
          boolean _equals_3 = Objects.equal(_id_1, _id_2);
          _or = (_equals_2 || _equals_3);
        }
        _xifexpression = _or;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
}
