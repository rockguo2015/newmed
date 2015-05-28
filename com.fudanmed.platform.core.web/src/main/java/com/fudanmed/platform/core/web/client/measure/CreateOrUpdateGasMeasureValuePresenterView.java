package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.web.client.measure.CreateOrUpdateGasMeasureValueView;
import com.fudanmed.platform.core.web.shared.measure.UIGasMeasureValue;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.FormViewer;

@ImplementedBy(value = CreateOrUpdateGasMeasureValueView.class)
public interface CreateOrUpdateGasMeasureValuePresenterView extends FormViewer<UIGasMeasureValue> {
}
