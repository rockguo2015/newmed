package edu.fudan.langlab.gxt.client.widget.ScoreField;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.sencha.gxt.cell.core.client.form.ValueBaseInputCell;
import com.sencha.gxt.core.client.dom.XElement;

public class ScoreFieldCell extends ValueBaseInputCell<Integer> {
	private int score;
	private int max;
	protected ScoreFieldAppearance appearance;

	public interface ScoreFieldAppearance extends ValueBaseFieldAppearance {
		/**
		 * Change the color of stars according to score
		 * @param parent
		 * @param score
		 */
		void onSelect(XElement parent, int score);
		
		/**
		 * Initialize the stars, default is unselected
		 * @param sb
		 * @param stars
		 */
		void initStars(SafeHtmlBuilder sb, int maxStars, int stars);
	}

	public ScoreFieldCell(int max) {
		this(GWT.<ScoreFieldAppearance> create(ScoreFieldAppearance.class), max);
	}

	public ScoreFieldCell(ScoreFieldAppearance appearance, int max) {
		super(appearance);
		this.appearance = appearance;
		this.score = 0;
		this.max = max;
	}

	public int getScore() {
		return score;
	}

	@Override
	public void render(Context context, Integer value, SafeHtmlBuilder sb) {
		sb.appendHtmlConstant("<div>");
		this.appearance.initStars(sb, this.max, this.score);
		sb.appendHtmlConstant("</div>");
	}

	@Override
	public void setValue(com.google.gwt.cell.client.Cell.Context context,
			Element parent, Integer value) {
		score = value;
		super.setValue(context, parent, value);
	}
	
	@Override
	protected void onClick(XElement parent, NativeEvent event) {
		try{
		Element element = event.getEventTarget().cast();
		this.score=Integer.parseInt(element.getId());
		this.appearance.onSelect(parent, score);
		}catch(Exception e){
			//DO NOTHING
		}
	}

}
