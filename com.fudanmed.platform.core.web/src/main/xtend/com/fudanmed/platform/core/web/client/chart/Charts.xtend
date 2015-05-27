package com.fudanmed.platform.core.web.client.chart

import com.sencha.gxt.chart.client.chart.Chart
import com.sencha.gxt.chart.client.chart.Chart$Position
import com.sencha.gxt.chart.client.chart.Legend
import com.sencha.gxt.chart.client.chart.axis.CategoryAxis
import com.sencha.gxt.chart.client.chart.axis.NumericAxis
import com.sencha.gxt.chart.client.chart.series.BarSeries
import com.sencha.gxt.chart.client.chart.series.PieSeries
import com.sencha.gxt.chart.client.chart.series.Series$LabelPosition
import com.sencha.gxt.chart.client.chart.series.SeriesLabelConfig
import com.sencha.gxt.chart.client.draw.Gradient
import com.sencha.gxt.chart.client.draw.RGB
import com.sencha.gxt.chart.client.draw.sprite.TextSprite
import com.sencha.gxt.chart.client.draw.sprite.TextSprite$TextAnchor
import com.sencha.gxt.chart.client.draw.sprite.TextSprite$TextBaseline
import com.sencha.gxt.core.client.ValueProvider
import com.sencha.gxt.data.shared.ListStore
import edu.fudan.langlab.gxt.client.component.KeyProvider
import java.util.Collection
import com.sencha.gxt.chart.client.chart.event.SeriesSelectionEvent$SeriesSelectionHandler
import com.sencha.gxt.chart.client.chart.event.SeriesSelectionEvent

class PieChart<T>{
	protected ListStore<T> store = new ListStore<T>(new KeyProvider<T>()) 
	private Chart<T> chart = null
	private PieSeries<T> series = new PieSeries<T>();	
	def void setObjects(Collection<T> objects){
		store.clear
		store.addAll(objects)
		chart.redrawChart()
	}
	def asWidget(){
		if(chart!=null) return chart;
		chart = new Chart<T>()
		chart.setStore(store)
   		chart.setAnimated(true);
   		
		val TextSprite textConfig = new TextSprite();
	    textConfig.setFont("Arial");
	    textConfig.setFontSize(14);
	    textConfig.setTextBaseline(TextSprite$TextBaseline::MIDDLE);
	    textConfig.setTextAnchor(TextSprite$TextAnchor::MIDDLE);
	    textConfig.setFill(new RGB("#333"));
	    val SeriesLabelConfig<T> labelConfig = new SeriesLabelConfig<T>();
	    labelConfig.setLabelPosition(Series$LabelPosition::START);
	    labelConfig.setLabelContrast(true);   	
	    labelConfig.setSpriteConfig(textConfig);
	    labelConfig.setValueProvider(categoryAxisProvider)[it]
//	    labelConfig.setValueProvider(categoryAxisProvider)[it]
	    series.setAngleField(numberAxisProvider)
	    series.setHighlighting(true)
	    series.setLabelConfig(labelConfig);
	    newArrayList(
	    	new RGB("#94ae0a"), new RGB("#115fa6"), new RGB("#a61120"), new RGB("#ff8809"), new RGB("#ffd13e"),
        	new RGB("#a61187"), new RGB("#24ad9a"), new RGB("#a66111")).forEach[
        		series.addColor(it)
        	]
	    series.legendLabelProvider = [T it|
	    	val p = (new PercentLabelProvider<T>(store,categoryAxisProvider,numberAxisProvider))
	    	p.getValue(it)
	    ]
		val Legend<T> legend = new Legend<T>();
	    legend.setPosition(Chart$Position::LEFT);
	    legend.setItemHighlighting(true);
//	    legend.setItemHiding(true);
	    chart.setLegend(legend);	    
	    chart.addSeries(series);
	    chart
   	}
   	
	def highlight(T index){
		series.drawSeries();
		series.highlight(store.indexOf(index))
		chart.redrawChart
	}	
	
	private ValueProvider<T,String> categoryAxisProvider
	private ValueProvider<T,? extends Number> numberAxisProvider
	
	def setNumberProvider((T)=>Number p){
		this.numberAxisProvider = new ProvideWrapper(p)
	}
		
	def setCategoryProvider((T)=>String p){
		this.categoryAxisProvider = new ProvideWrapper(p)
	}
	def addValueSelectedListener((T)=>void listener){
		series.addSeriesSelectionHandler(new TSeriesSelectionHandler<T>(listener))
	}
}

class PercentLabelProvider<T> implements ValueProvider<T,String>{
	private ListStore<T> store
	private ValueProvider<T,String> labelProvider
	private ValueProvider<T,? extends Number> valueProvider
	new(ListStore<T> store, ValueProvider<T,String> labelProvider, ValueProvider<T,? extends Number> valueProvider){
		this.store = store
		this.labelProvider = labelProvider
		this.valueProvider = valueProvider
	}

	override getPath() {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
	override getValue(T value) {
		//TODO performance improvement
		val totalScore = store.all.map[T it|valueProvider.getValue(it)].reduce[Number n1,Number n2|n1.doubleValue+n2.doubleValue].doubleValue
		val p = if(totalScore==0d) 0 else (valueProvider.getValue(value).doubleValue / totalScore * 100 + 0.5).intValue  
		labelProvider.getValue(value)  + "[" + valueProvider.getValue(value).toString +"/"+ p.toString + "%]"
	}
	
	override setValue(T object, String value) {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
}

class ColumnChart<T> {
	private String xTitle
	private String yTitle
	private Chart<T> chart = null
	private BarSeries<T> bar = null
	new(String xTitle, String yTitle){
		this.xTitle = xTitle
		this.yTitle = yTitle
	}
	protected ListStore<T> store = new ListStore<T>(new KeyProvider<T>()) 
	
	def void setObjects(Collection<T> objects){
		store.clear
		store.addAll(objects)
		chart.redrawChart()
	}
	
	def asWidget(){
		if(chart!=null) return chart;
		chart = new Chart<T>()
		chart.setStore(store)
   		chart.setAnimated(true);
   		val Gradient background = new Gradient("backgroundGradient", 0);
    	background.addStop(0, new RGB("#ffffff"));
    	background.addStop(100, new RGB("#eaf1f8"));
    	chart.addGradient(background);
    	chart.setBackground(background);
		
		new NumericAxis<T>()=>[
			position = Position::LEFT
			fields += numberAxisProvider
			titleConfig = new TextSprite(xTitle)
			displayGrid = true
			chart.addAxis(it)
		]
		
		new CategoryAxis<T,String>()=>[
			position = Position::BOTTOM
			field = categoryAxisProvider
			titleConfig = new TextSprite(yTitle)		
			chart.addAxis(it)
		]
		
		bar = new BarSeries<T>()=>[
			YAxisPosition = Position::LEFT
			addYField(numberAxisProvider)
    		addColor(new RGB(148,174,10));
    		column = true
    		val SeriesLabelConfig<T> config = new SeriesLabelConfig<T>();	
    		config.setLabelPosition(Series$LabelPosition::END);	
    		setLabelConfig(config)
    			
			chart.addSeries(it)
		]
				
		return chart
	}
	
	def addValueSelectedListener((T)=>void listener){
		bar.addSeriesSelectionHandler(new TSeriesSelectionHandler<T>(listener))
	}
	
	private ValueProvider<T,String> categoryAxisProvider
	private ValueProvider<T,? extends Number> numberAxisProvider
	
	def setNumberProvider((T)=>Number p){
		this.numberAxisProvider = new ProvideWrapper(p)
	}
		
	def setCategoryProvider((T)=>String p){
		this.categoryAxisProvider = new ProvideWrapper(p)
	}
	
	def highlight(T index){
		bar.drawSeries();
		bar.highlight(store.indexOf(index))
		chart.redrawChart
	}	
}

class ProvideWrapper<T,V> implements ValueProvider<T, V>{
	(T)=>V provider
	new((T)=>V provider){
		this.provider = provider
	}

	override getPath() {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
	override getValue(T object) {
		provider.apply(object)
	}
	
	override setValue(T object, V value) {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	

	
}

class BarChart<T> {
	private String xTitle
	private String yTitle
	private Chart<T> chart = null
	private BarSeries<T> bar = null
	
	new(String xTitle, String yTitle){
		this.xTitle = xTitle
		this.yTitle = yTitle
	}
	protected ListStore<T> store = new ListStore<T>(new KeyProvider<T>()) 
	
	def void setObjects(Collection<T> objects){
		store.clear
		store.addAll(objects)
		chart.redrawChart()
	}
	
	def asWidget(){
		if(chart!=null) return chart;
		chart = new Chart<T>()
		chart.setStore(store)
   	   	chart.setAnimated(true);
   		
   		val Gradient background = new Gradient("backgroundGradient", 0);
    	background.addStop(0, new RGB("#ffffff"));
    	background.addStop(100, new RGB("#eaf1f8"));
    	chart.addGradient(background);
    	chart.setBackground(background);
		
		new NumericAxis<T>()=>[
			position = Position::BOTTOM
			fields += numberAxisProvider
			titleConfig = new TextSprite(xTitle)
			displayGrid = true
			chart.addAxis(it)
		]
		
		new CategoryAxis<T,String>()=>[
			position = Position::LEFT
			field = categoryAxisProvider
			titleConfig = new TextSprite(yTitle)		
			chart.addAxis(it)
		]
		
		bar = new BarSeries<T>()=>[
			YAxisPosition = Position::BOTTOM
			addYField(numberAxisProvider)
    		addColor(new RGB(148,174,10));
    		val SeriesLabelConfig<T> config = new SeriesLabelConfig<T>();	
    		config.setLabelPosition(Series$LabelPosition::END);	
    		setLabelConfig(config)
			chart.addSeries(it)
		]
		return chart
	}
	def addValueSelectedListener((T)=>void listener){
		bar.addSeriesSelectionHandler(new TSeriesSelectionHandler<T>(listener))
	}
	
	private ValueProvider<T,String> categoryAxisProvider
	private ValueProvider<T,? extends Number> numberAxisProvider
	
	def setNumberProvider((T)=>Number p){
		this.numberAxisProvider = new ProvideWrapper(p)
	}
		
	def setCategoryProvider((T)=>String p){
		this.categoryAxisProvider = new ProvideWrapper(p)
	}
	def highlight(T index){
		bar.drawSeries();
		bar.highlight(store.indexOf(index));
		chart.redrawChart
	}	
}

class TSeriesSelectionHandler<T> implements SeriesSelectionHandler<T> {
	(T)=>void listener
	new((T)=>void listener){
		this.listener = listener
	}
	override onSeriesSelection(SeriesSelectionEvent<T> event) {
		listener.apply(event.item)
	}
}
