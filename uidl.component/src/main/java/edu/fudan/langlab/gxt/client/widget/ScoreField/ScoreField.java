package edu.fudan.langlab.gxt.client.widget.ScoreField;

import com.sencha.gxt.widget.core.client.form.ValueBaseField;

public class ScoreField extends ValueBaseField<Integer>{
	public ScoreField(int max){
		super(new ScoreFieldCell(max));
	}
	
	public Integer getValue(){
		return ((ScoreFieldCell)this.getCell()).getScore();
	}
}
