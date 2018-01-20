package com.blog.article.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.blog.article.model.CommonApi;
import com.blog.article.model.Pinying;
import com.blog.article.model.SelectResultModel;
import com.blog.article.utils.DateFormat;
import com.blog.article.utils.HttpClick;

public class MosaicUrl {


	/** 
	* by zbb
	* @title: getUrl
	* @Description: TODO
	* @param type 1 数字 2 字母 3 拼音 4声母
	* @param number
	* @param houzhui
	* void      
	* @throws 
	*/
	public static void getUrl(int type, int number, String houzhui) {
		System.out.println("******************************");
		System.out.println("进入时间："+DateFormat.DateToString(new Date()));
		List<SelectResultModel> resultList = new ArrayList<SelectResultModel>();
		List<String> list = new ArrayList<String>();
		List<String> urlList = new ArrayList<String>();
		if (type == 1) {
			ASSS.get(list, CommonApi.shuzi, number);
		} else if (type == 2) {
			ASSS.get(list, CommonApi.zimu, number);
		} else if (type == 3) {
			ASSS.get(list, Pinying.pinying, number);
		} else if(type ==4) {
			//声母
			ASSS.get(list, CommonApi.shengmu, number);
		}
		System.out.println("生成结束,共有"+list.size()+"条数据,时间："+DateFormat.DateToString(new Date()));
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			urlList.add(sb.append(list.get(i)).append(".").append(houzhui).toString());
			sb.delete(0, sb.length());
		}
		
		//获取完结果 开始查询是否存在
		//分批查询 500条一段
		
		for (int i = 0; i < urlList.size(); i++) {
			String resultStr =HttpClick.httpURLConectionGET(CommonApi.URL+urlList.get(i),i);
			SelectResultModel m = new SelectResultModel();
			m.setUrl(urlList.get(i));
			m.setCode(isUsed(resultStr));
			if("210".equals(m.getCode())) {
				m.setFlag(true);
			}else {
				m.setFlag(false);
			}
			resultList.add(m);
			System.out.println(m.getUrl() +"****状态："+m.getCode());
		}
		
		System.out.println("总共有"+resultList.size()+"个可用,查询玩时间："+DateFormat.DateToString(new Date()));
		
		System.out.println("可用数据为以下这些");
		for (int i = 0; i < resultList.size(); i++) {
			if(resultList.get(i).getFlag()) {
				System.out.println(resultList.get(i).getUrl());
			}
		}
	}
	
	public static String isUsed(String resultStr) {
		int i =resultStr.indexOf("<original>");
		String code= resultStr.substring(i+10, i+13);
		return code;
	}

	
	public static void main(String[] args) {
		getUrl(2,2,"games");
		System.out.println("******************************");
	}
}
