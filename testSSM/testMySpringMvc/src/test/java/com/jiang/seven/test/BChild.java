package com.jiang.seven.test;

public class BChild extends AFather{
	
	public String a = "BC--a";
	
	private String b = "BC--b";
	
    
	static{                                               
		System.out.println("static ...B..");               
	}                                                     
	    
	private static void getStaticM(){                     
		System.out.println("staticM ..B...");              
	}                                                     
    
	
	public void getAA(){
		System.out.println(a);
	}
	
	public void getBB() {
		System.out.println(b);
	}
	
	public String getAA(String s){
		System.out.println(s);
		return s;
	}
	
	
	public static void main(String[] args) {
		new AFather();
		System.out.println("````````````````");
		AFather aFather = new BChild();
		System.out.println("=========================");
		new BChild();
		BChild bChild = (BChild) aFather;
		System.out.println("+++++++++++++++++++++++++");
		AFather aaFather = new AFather("aaa","ccc");
//		BChild bbBChild = (BChild) aaFather;   不可以的
		System.out.println(aFather.a +"====public==="+bChild.a+"===="+aaFather.a+"===="+bChild.b+"==="+aaFather.getB()+"=="+aaFather.getA());
//		System.out.println(aFather.b +"====private==="+bChild.b);   aFather.b 报错
		
		System.out.println("-------------------------------------");
		bChild.getStaticM();
//		aaFather.getStaticM();
		aFather.getAA();
		bChild.getAA();
		aFather.getBB();
		bChild.getBB();
	}
	
}
