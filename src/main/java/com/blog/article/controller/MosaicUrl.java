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
	* @param type 1 ���� 2 ��ĸ 3 ƴ�� 4��ĸ
	* @param number
	* @param houzhui
	* void      
	* @throws 
	*/
	public static void getUrl(int type, int number, String houzhui) {
		System.out.println("******************************");
		System.out.println("����ʱ�䣺"+DateFormat.DateToString(new Date()));
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
			//��ĸ
			ASSS.get(list, CommonApi.shengmu, number);
		}
		System.out.println("���ɽ���,����"+list.size()+"������,ʱ�䣺"+DateFormat.DateToString(new Date()));
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			urlList.add(sb.append(list.get(i)).append(".").append(houzhui).toString());
			sb.delete(0, sb.length());
		}
		
		//��ȡ���� ��ʼ��ѯ�Ƿ����
		//������ѯ 500��һ��
		
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
			System.out.println(m.getUrl() +"****״̬��"+m.getCode());
		}
		
		System.out.println("�ܹ���"+resultList.size()+"������,��ѯ��ʱ�䣺"+DateFormat.DateToString(new Date()));
		
		System.out.println("��������Ϊ������Щ");
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
