package com.fudanmed.platform.core.web.shared.organization;

import com.uniquesoft.gwt.shared.datatype.IUIDLEnum;

public enum UIStandardColor implements IUIDLEnum<UIStandardColor> {
  aqua,

  black,

  blue,

  fuchsia,

  gray,

  green,

  orange,

  purple,

  red,

  yellow;
  
  public String toString() {
    switch(this){
    case red:
    	return "红";
    case blue:
    	return "蓝";
    case gray:
    	return "灰";
    case green:
    	return "绿";
    case orange:
    	return "桔黄";
    case purple:
    	return "紫";
    case aqua:
    	return "天蓝";
    case fuchsia:
    	return "品红";
    case yellow:
    	return "黄";
    case black:
    	return "黑";
    	default:
    		return name();
    }
  }
  
  public UIStandardColor fromString(final String value) {
    if( "红".equals(value))
    	return red;
    if( "蓝".equals(value))
    	return blue;
    if( "灰".equals(value))
    	return gray;
    if( "绿".equals(value))
    	return green;
    if( "桔黄".equals(value))
    	return orange;
    if( "紫".equals(value))
    	return purple;
    if( "天蓝".equals(value))
    	return aqua;
    if( "品红".equals(value))
    	return fuchsia;
    if( "黄".equals(value))
    	return yellow;
    if( "黑".equals(value))
    	return black;
    	return null;			
    
  }
}
