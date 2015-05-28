package com.fudanmed.platform.core.web.shared.project;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class EBoardResult implements IsSerializable {
  private Integer totalPage;
  
  public Integer getTotalPage() {
    return this.totalPage;
  }
  
  public void setTotalPage(final Integer totalPage) {
    this.totalPage = totalPage;
  }
  
  public final static String P_TotalPage = "totalPage";
  
  public static IObjectFieldAccessor<EBoardResult,Integer> TotalPageAccessor = new IObjectFieldAccessor<EBoardResult,Integer>(){
    				public Integer getValue(EBoardResult object){
    					return object.getTotalPage();
    				}
    				public void setValue(EBoardResult object,Integer value){
    					object.setTotalPage(value);
    				}
    			};
  
  private Integer curPage;
  
  public Integer getCurPage() {
    return this.curPage;
  }
  
  public void setCurPage(final Integer curPage) {
    this.curPage = curPage;
  }
  
  public final static String P_CurPage = "curPage";
  
  public static IObjectFieldAccessor<EBoardResult,Integer> CurPageAccessor = new IObjectFieldAccessor<EBoardResult,Integer>(){
    				public Integer getValue(EBoardResult object){
    					return object.getCurPage();
    				}
    				public void setValue(EBoardResult object,Integer value){
    					object.setCurPage(value);
    				}
    			};
  
  private String contents;
  
  public String getContents() {
    return this.contents;
  }
  
  public void setContents(final String contents) {
    this.contents = contents;
  }
  
  public final static String P_Contents = "contents";
  
  public static IObjectFieldAccessor<EBoardResult,String> ContentsAccessor = new IObjectFieldAccessor<EBoardResult,String>(){
    				public String getValue(EBoardResult object){
    					return object.getContents();
    				}
    				public void setValue(EBoardResult object,String value){
    					object.setContents(value);
    				}
    			};
}
