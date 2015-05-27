package com.uniquesoft.gwt.client.common.widgets.component;

import com.uniquesoft.gwt.client.common.widgets.baregwt.component.detail.GWTDetailViewConfig;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.form.GWTFormConfig;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid.GWTGridConfig;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid.GWTListGridConfig;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.propertydetail.GWTPropertyDetailViewConfig;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.vgrid.GWTVGridConfig;


/**
 * Make the UIDL language support the component type. When create a new component type,
 * register it here.
 *
 */
public interface ComponentTypeFactory {

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
	 * @return Create a GWT detail View, listed as Detailview in UIDL, this component is similar as GWTForm
	 */
	GWTDetailViewConfig asGWTDetailView();

	/**
	 * @return Create a new GWT detail View, listed as GWTPropertyDetailView in UIDL, this component works like ListGrid
	 */
	GWTPropertyDetailViewConfig asGWTPropertyDetailView();
}
