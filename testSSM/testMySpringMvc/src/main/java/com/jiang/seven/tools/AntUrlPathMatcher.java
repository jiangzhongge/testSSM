package com.jiang.seven.tools;

import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

public class AntUrlPathMatcher implements UrlMatcher {

	private boolean requiresLowerCaseUrl;
	
	private PathMatcher pathMatcher; 
	
	public AntUrlPathMatcher()   { 
	    this(true);
	} 
	
	public AntUrlPathMatcher(boolean requiresLowerCaseUrl)  { 

	     this.requiresLowerCaseUrl = true;
	     this.pathMatcher = new AntPathMatcher(); 
	     this.requiresLowerCaseUrl = requiresLowerCaseUrl;

	}
	
	@Override
	public Object compile(String paramString) {
		if(this.requiresLowerCaseUrl){ 
			return paramString.toLowerCase();  
		}  
		return paramString;  

	}

	@Override
	public boolean pathMatchesUrl(Object path, String url) {
		if(("/**".equals(path)) || ("**".equals(path))){
			return true;    
		} 
		return this.pathMatcher.match((String)path,url); 
	}

	@Override
	public String getUniversalMatchPattern() {
		// TODO Auto-generated method stub
		return "/**";
	}

	@Override
	public boolean requiresLowerCaseUrl() {
		// TODO Auto-generated method stub
		return this.requiresLowerCaseUrl;
	}
	
	public String toString() {  
		return super.getClass().getName() + "[requiresLowerCase='"+
				this.requiresLowerCaseUrl + "']"; 
	}

}
