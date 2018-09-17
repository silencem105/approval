package com.cn.majj;

public class Child extends Parent {
	

	public String educateChild() {
		return "ºÃºÃÑ§Ï°";

	} 
@Override
    public  String  educateChild(String name){ 
		String s=name;
		return s;

	}


public  String  educateChild(String name, int i){
	String s=name;
	return s;

}

public  short educateChild(short s){
	short name=s;
	return name;

}

public  int educateChild(float a,int b){
	int number=b;
	return number;

}

public  boolean  educateChild(boolean b){
	boolean s=b;
	return s;

}
}
