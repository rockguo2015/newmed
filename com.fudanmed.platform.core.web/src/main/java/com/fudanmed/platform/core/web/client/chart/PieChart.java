package com.fudanmed.platform.core.web.client.chart;

import com.fudanmed.platform.core.web.client.chart.PercentLabelProvider;
import com.fudanmed.platform.core.web.client.chart.ProvideWrapper;
import com.fudanmed.platform.core.web.client.chart.TSeriesSelectionHandler;
import com.google.common.base.Objects;
import com.google.gwt.event.shared.HandlerRegistration;
import com.sencha.gxt.chart.client.chart.Chart;
import com.sencha.gxt.chart.client.chart.Chart.Position;
import com.sencha.gxt.chart.client.chart.Legend;
import com.sencha.gxt.chart.client.chart.series.PieSeries;
import com.sencha.gxt.chart.client.chart.series.Series.LabelPosition;
import com.sencha.gxt.chart.client.chart.series.SeriesLabelConfig;
import com.sencha.gxt.chart.client.draw.RGB;
import com.sencha.gxt.chart.client.draw.sprite.TextSprite;
import com.sencha.gxt.chart.client.draw.sprite.TextSprite.TextAnchor;
import com.sencha.gxt.chart.client.draw.sprite.TextSprite.TextBaseline;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ListStore;
import edu.fudan.langlab.gxt.client.component.KeyProvider;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class PieChart<T extends Object> {
  protected ListStore store = new Function0<ListStore>() {
    public ListStore apply() {
      KeyProvider<T> _keyProvider = new KeyProvider<T>();
      ListStore<T> _listStore = new ListStore<T>(_keyProvider);
      return _listStore;
    }
  }.apply();
  
  private Chart<T> chart = null;
  
  private PieSeries series = new Function0<PieSeries>() {
    public PieSeries apply() {
      PieSeries<T> _pieSeries = new PieSeries<T>();
      return _pieSeries;
    }
  }.apply();
  
  public void setObjects(final Collection<T> objects) {
    this.store.clear();
    this.store.addAll(objects);
    this.chart.redrawChart();
  }
  
  public Chart<T> asWidget() {
    Chart<T> _xblockexpression = null;
    {
      boolean _notEquals = (!Objects.equal(this.chart, null));
      if (_notEquals) {
        return this.chart;
      }
      Chart<T> _chart = new Chart<T>();
      this.chart = _chart;
      this.chart.setStore(this.store);
      this.chart.setAnimated(true);
      TextSprite _textSprite = new TextSprite();
      final TextSprite textConfig = _textSprite;
      textConfig.setFont("Arial");
      textConfig.setFontSize(14);
      textConfig.setTextBaseline(TextBaseline.MIDDLE);
      textConfig.setTextAnchor(TextAnchor.MIDDLE);
      RGB _rGB = new RGB("#333");
      textConfig.setFill(_rGB);
      SeriesLabelConfig<T> _seriesLabelConfig = new SeriesLabelConfig<T>();
      final SeriesLabelConfig<T> labelConfig = _seriesLabelConfig;
      labelConfig.setLabelPosition(LabelPosition.START);
      labelConfig.setLabelContrast(true);
      labelConfig.setSpriteConfig(textConfig);
      final Function1<String,String> _function = new Function1<String,String>() {
          public String apply(final String it) {
            return it;
          }
        };
      labelConfig.<String>setValueProvider(this.categoryAxisProvider, new LabelProvider<String>() {
          public String getLabel(String item) {
            return _function.apply(item);
          }
      });
      this.series.setAngleField(this.numberAxisProvider);
      this.series.setHighlighting(true);
      this.series.setLabelConfig(labelConfig);
      RGB _rGB_1 = new RGB("#94ae0a");
      RGB _rGB_2 = new RGB("#115fa6");
      RGB _rGB_3 = new RGB("#a61120");
      RGB _rGB_4 = new RGB("#ff8809");
      RGB _rGB_5 = new RGB("#ffd13e");
      RGB _rGB_6 = new RGB("#a61187");
      RGB _rGB_7 = new RGB("#24ad9a");
      RGB _rGB_8 = new RGB("#a66111");
      ArrayList<RGB> _newArrayList = CollectionLiterals.<RGB>newArrayList(_rGB_1, _rGB_2, _rGB_3, _rGB_4, _rGB_5, _rGB_6, _rGB_7, _rGB_8);
      final Procedure1<RGB> _function_1 = new Procedure1<RGB>() {
          public void apply(final RGB it) {
            PieChart.this.series.addColor(it);
          }
        };
      IterableExtensions.<RGB>forEach(_newArrayList, _function_1);
      final Function1<T,String> _function_2 = new Function1<T,String>() {
          public String apply(final T it) {
            String _xblockexpression = null;
            {
              PercentLabelProvider<T> _percentLabelProvider = new PercentLabelProvider<T>(PieChart.this.store, PieChart.this.categoryAxisProvider, PieChart.this.numberAxisProvider);
              final PercentLabelProvider<T> p = _percentLabelProvider;
              String _value = p.getValue(it);
              _xblockexpression = (_value);
            }
            return _xblockexpression;
          }
        };
      this.series.setLegendLabelProvider(new LabelProvider<T>() {
          public String getLabel(T item) {
            return _function_2.apply(item);
          }
      });
      Legend<T> _legend = new Legend<T>();
      final Legend<T> legend = _legend;
      legend.setPosition(Position.LEFT);
      legend.setItemHighlighting(true);
      this.chart.setLegend(legend);
      this.chart.addSeries(this.series);
      _xblockexpression = (this.chart);
    }
    return _xblockexpression;
  }
  
  public void highlight(final T index) {
    this.series.drawSeries();
    int _indexOf = this.store.indexOf(index);
    this.series.highlight(_indexOf);
    this.chart.redrawChart();
  }
  
  private ValueProvider<T,String> categoryAxisProvider;
  
  private ValueProvider<T,? extends Number> numberAxisProvider;
  
  public ValueProvider<T,? extends Number> setNumberProvider(final Function1<? super T,? extends Number> p) {
    ProvideWrapper<T,Number> _provideWrapper = new ProvideWrapper<T,Number>(p);
    ValueProvider<T,? extends Number> _numberAxisProvider = this.numberAxisProvider = _provideWrapper;
    return _numberAxisProvider;
  }
  
  public ValueProvider<T,String> setCategoryProvider(final Function1<? super T,? extends String> p) {
    ProvideWrapper<T,String> _provideWrapper = new ProvideWrapper<T,String>(p);
    ValueProvider<T,String> _categoryAxisProvider = this.categoryAxisProvider = _provideWrapper;
    return _categoryAxisProvider;
  }
  
  public HandlerRegistration addValueSelectedListener(final Procedure1<? super T> listener) {
    TSeriesSelectionHandler<T> _tSeriesSelectionHandler = new TSeriesSelectionHandler<T>(listener);
    HandlerRegistration _addSeriesSelectionHandler = this.series.addSeriesSelectionHandler(_tSeriesSelectionHandler);
    return _addSeriesSelectionHandler;
  }
}
