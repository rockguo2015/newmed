package com.uniquesoft.gwt.shared.extensions

class StringExtensions {
	def static nullsafe(String value){
		if(value==null) "" else value
	}
	
	def static asRightAlignText(String value){
		"<span style='text-align:right'>"+value+"</span>"
	}
	
    def static String abbreviate(String str, int maxWidth) {
        return abbreviate(str, 0, maxWidth);
    }
    
    def static String abbreviate(String str, int _offset, int maxWidth) {
    	var offset = _offset
    	
        if (str == null) {
            return null;
        }
        if (maxWidth < 4) {
            throw new IllegalArgumentException("Minimum abbreviation width is 4");
        }
        if (str.length() <= maxWidth) {
            return str;
        }
        if (offset > str.length()) {
            offset = str.length();
        }
        if ((str.length() - offset) < (maxWidth - 3)) {
            offset = str.length() - (maxWidth - 3);
        }
        if (offset <= 4) {
            return str.substring(0, maxWidth - 3) + "...";
        }
        if (maxWidth < 7) {
            throw new IllegalArgumentException("Minimum abbreviation width with offset is 7");
        }
        if ((offset + (maxWidth - 3)) < str.length()) {
            return "..." + abbreviate(str.substring(offset), maxWidth - 3);
        }
        return "..." + str.substring(str.length() - (maxWidth - 3));
    }	
}