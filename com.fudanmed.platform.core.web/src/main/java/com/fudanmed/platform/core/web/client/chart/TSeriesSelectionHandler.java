package com.fudanmed.platform.core.web.client.chart;

import com.sencha.gxt.chart.client.chart.event.SeriesSelectionEvent;
import com.sencha.gxt.chart.client.chart.event.SeriesSelectionEvent.SeriesSelectionHandler;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class TSeriesSelectionHandler<T extends Object> implements SeriesSelectionHandler<T> {
  private Procedure1<? super T> listener;
  
  public TSeriesSelectionHandler(final Procedure1<? super T> listener) {
    this.listener = listener;
  }
  
  public void onSeriesSelection(final SeriesSelectionEvent<T> event) {
    T _item = event.getItem();
    this.listener.apply(_item);
  }
}
