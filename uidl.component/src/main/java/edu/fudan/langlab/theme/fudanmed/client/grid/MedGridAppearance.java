package edu.fudan.langlab.theme.fudanmed.client.grid;

import com.google.gwt.core.client.GWT;
import com.sencha.gxt.theme.base.client.grid.GridBaseAppearance;

public class MedGridAppearance extends GridBaseAppearance {

  public interface MedGridStyle extends GridStyle {
    
  }
  
  public interface MedGridResources extends GridResources  {
    
    @Source({"com/sencha/gxt/theme/base/client/grid/Grid.css", "MedGrid.css"})
    @Override
    MedGridStyle css();
  }
  
  
  public MedGridAppearance() {
    this(GWT.<MedGridResources> create(MedGridResources.class));
  }

  public MedGridAppearance(MedGridResources resources) {
    super(resources);
  }
}
