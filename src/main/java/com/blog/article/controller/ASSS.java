package com.blog.article.controller;

import java.util.ArrayList;
import java.util.List;

import com.blog.article.model.CommonApi;

public class ASSS {  

    
    /** 
    * by zbb
    * @title: get
    * @Description: 数组拼接
    * @param list  接受结果的空list
    * @param str  数组
    * @param num  拼接次数
    * void      
    * @throws 
    */
    public static void get(List<String> list,String[] str,int num){
    	if(list.size()==0){
    		for (int i = 0; i < str.length; i++) {
    			list.add(i, str[i]);
    		}
    	}else{
    		List<String> par = new ArrayList<String>();
    		par.addAll(list);
    		list.clear();
    		for (int i = 0; i < str.length; i++) {
				for (int j = 0; j < par.size(); j++) {
					list.add(str[i]+par.get(j));
				}
			}
    	}
    	if(list.get(0).length()<num){
    		get(list,str,num);
    	}
    }
    
    
    /** 
     * by zbb
     * @title: get
     * @Description: 数组拼接
     * @param list  接受结果的空list
     * @param str  list
     * @param num  拼接次数
     * void      
     * @throws 
     */
    public static void get(List<String> list,List<String> str,int num){
    	if(list.size()==0){
    		for (int i = 0; i < str.size(); i++) {
    			list.add(i, str.get(i));
    		}
    	}else{
    		List<String> par = new ArrayList<String>();
    		par.addAll(list);
    		list.clear();
    		for (int i = 0; i < str.size(); i++) {
				for (int j = 0; j < par.size(); j++) {
					list.add(str.get(i)+par.get(j));
				}
			}
    	}
    	if(list.get(0).length()<num){
    		get(list,str,num);
    	}
    }
    
    public static List<String> pinying(){
    	List<String> list = new ArrayList<String>();
    	String [] shengmu= CommonApi.shengmu;
    	String [] yunmu =CommonApi.yunmu;
    	for (int i = 0; i < shengmu.length; i++) {
    		for (int j = 0; j < yunmu.length; j++) {
    			list.add(shengmu[i]+yunmu[j]);
    		}
		}
    	return list;
    }
    
 
    public static void main(String[] args) {  
    	List<String> list = new ArrayList<String>();
    	List<String> list2 = new ArrayList<String>();
  
//    	pinying(list);
//    	get(list2,numberSequence);
    	get(list2,list,4);
    	for (int i = 0; i < list2.size(); i++) {
			System.out.println(list2.get(i).toLowerCase());
		}
    }  
}  