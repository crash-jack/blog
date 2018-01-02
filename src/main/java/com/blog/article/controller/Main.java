package com.blog.article.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.blog.article.dao.DomainMapper;
import com.blog.article.model.CommonApi;
import com.blog.article.model.Pinying;
import com.blog.article.utils.HttpClick;

public class Main {

	
	public static void main(String[] args) {
		 MosaicUrl.getUrl(4,4,"cc");
		 System.out.println("******************************");
//		 System.out.println(HttpClick.httpURLConectionGET(CommonApi.URL+"muying.name",1));
	}
	
	
	public void getThree() {
		String[] arr = Pinying.pinying;
		List<String> arr1   = new ArrayList<String>() ;
		List<String> arr2   = new ArrayList<String>() ;
		List<String> arr3   = new ArrayList<String>() ;
		int num1=0,num2=0,num3 =0;
		for (int i = 0; i < arr.length; i++) {
			switch (arr[i].charAt(0)) {
			case 'g':
				arr1.add(arr[i]);
				num1++;
				break;
			case 'j':
				arr2.add(arr[i]);
				num2++;
				break;
			case 'b':
				arr3.add(arr[i]);
				num3++;
				break;
			default:
				break;
			}
		}
		
		for (int i = 0; i < arr1.size(); i++) {
			for (int j = 0; j < arr2.size(); j++) {
				for (int j2 = 0; j2 < arr3.size(); j2++) {
					System.out.println(arr1.get(i)+arr2.get(j)+arr3.get(j2));
				}
			}
		}
	}
}
