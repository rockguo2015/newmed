package com.uniquesoft.gwt.client.common.widgets.baregwt.component.propertydetail.factory.item;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.user.cellview.client.CellWidget;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer;

public abstract class AbstractPropertyDetailItem<T> extends PropertyDetailItem implements IValueViewer<T> {
        
    public AbstractPropertyDetailItem(String id, String title){
        widget = new CellWidget<String>(new TextCell());
        setTitle(title);
    }

}
