package edu.fudan.langlab.uidl.domain.app.client;

import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

import com.google.gwt.resources.client.ImageResource;

public class WorkbenchCategoryImpl implements WorkbenchPartCategory {

	private String categoryId;
	private String categoryName;
	private ImageResource image;
	private Function0<Boolean> isVisiable;
	public WorkbenchCategoryImpl(String id, String name, ImageResource image){
		this.categoryId = id;
		this.categoryName = name;
		this.image = image;
	}
	public WorkbenchCategoryImpl(String id, String name){
		this.categoryId = id;
		this.categoryName = name;
		this.image = null;
	}
	
	@Override
	public String getCategoryId() {
		return categoryId;
	}

	@Override
	public String getCategoryName() {
		return categoryName;
	}
	
	@Override
	public ImageResource getImage() {
		return image;
	}
	@Override
	public Boolean isVisable() {
		if(isVisiable==null) return true;
		return isVisiable.apply();
	}
	
	public void setVisiableStrategy(Function0<Boolean> isVisiable){
		this.isVisiable = isVisiable;
	}
}
