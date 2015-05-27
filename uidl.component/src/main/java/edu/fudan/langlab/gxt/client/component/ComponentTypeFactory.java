package edu.fudan.langlab.gxt.client.component;

import com.uniquesoft.gwt.client.common.widgets.baregwt.component.detail.GWTDetailViewConfig;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.form.GWTFormConfig;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid.GWTGridConfig;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid.GWTListGridConfig;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.propertydetail.GWTPropertyDetailViewConfig;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.vgrid.GWTVGridConfig;

import edu.fudan.langlab.gxt.client.component.form.GXTFormConfig;
import edu.fudan.langlab.gxt.client.component.grid.GXTGrid4LargeDataConfig;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridConfig;
import edu.fudan.langlab.gxt.client.component.listview.GXTListViewConfig;
import edu.fudan.langlab.gxt.client.component.propertyview.GXTPropertyViewConfig;
import edu.fudan.langlab.gxt.client.component.treegrid.GXTTreeGridConfig;

/**
 * Make the UIDL language support the component type. When create a new
 * component type, register it here.
 * 
 */
public interface ComponentTypeFactory {

	GXTGridConfig asGXTGrid();

	GXTGrid4LargeDataConfig asGXTGrid4LargeData();

	GXTFormConfig asGXTForm();

	GXTTreeGridConfig asGXTTreeGrid();

	GXTListViewConfig asGXTListView();

	GXTPropertyViewConfig asGXTPropertyView();

	/**
	 * @return Create GWT Form component, listed as GWTForm in UIDL
	 */
	GWTFormConfig asGWTForm();

	/**
	 * @return Create GWT Grid component, listed as GWTGrid in UIDL
	 */
	GWTGridConfig asGWTGrid();

	/**
	 * @return Create GWT Grid component, listed as GWTGrid in UIDL
	 */
	GWTListGridConfig asGWTListGrid();

	/**
	 * @return Create GWT vertical Grid, listed ad VGrid in UIDL
	 */
	GWTVGridConfig asVGrid();

	/**
	 * @return Create a GWT detail View, listed as Detailview in UIDL, this
	 *         component is similar as GWTForm
	 */
	GWTDetailViewConfig asGWTDetailView();

	/**
	 * @return Create a new GWT detail View, listed as GWTPropertyDetailView in
	 *         UIDL, this component works like ListGrid
	 */
	GWTPropertyDetailViewConfig asGWTPropertyDetailView();
}
