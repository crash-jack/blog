package com.blog.article.utils;

import java.io.*;

public class Chaifen {
	/**
	 * ��������,ֱ�ӵ��þ�̬����start��ִ�в��� ����: rows Ϊ������һ���ļ� int ���� sourceFilePath ΪԴ�ļ�·�� String
	 * ���� targetDirectoryPath Ϊ�ļ��ָ���ŵ�Ŀ��Ŀ¼ String ����
	 * ---�ָ����ļ���Ϊ������(��0��ʼ)��'_'��Դ�ļ���,����Դ�ļ���Ϊtest.txt,��ָ���ļ���Ϊ0_test.txt,�Դ�����
	 */
	public static void start(int rows, String sourceFilePath, String targetDirectoryPath) {
		File sourceFile = new File(sourceFilePath);
		File targetFile = new File(targetDirectoryPath);
		if (!sourceFile.exists() || rows <= 0 || sourceFile.isDirectory()) {
			System.out.println("Դ�ļ������ڻ��������˴��������");
			return;
		}
		if (targetFile.exists()) {
			if (!targetFile.isDirectory()) {
				System.out.println("Ŀ���ļ��д���,����һ���ļ���");
				return;
			}
		} else {
			targetFile.mkdirs();
		}
		try {
			BufferedReader br = new BufferedReader(new FileReader(sourceFile));
			BufferedWriter bw = null;
			String str = "";
			String tempData = br.readLine();
			int i = 1, s = 0;
			while (tempData != null) {
				str += tempData + "\r\n";
				if (i % rows == 0) {
					bw = new BufferedWriter(new FileWriter(
							new File(targetFile.getAbsolutePath() + "/" + s + "_" + sourceFile.getName())));
					bw.write(str);
					bw.close();
					str = "";
					s += 1;
				}
				i++;
				tempData = br.readLine();
			}
			if ((i - 1) % rows != 0) {
				bw = new BufferedWriter(
						new FileWriter(new File(targetFile.getAbsolutePath() + "/" + s + "_" + sourceFile.getName())));
				bw.write(str);
				bw.close();
				br.close();
				s += 1;
			}
			System.out.println("�ļ��ָ����,���ָ����" + s + "���ļ�");
		} catch (Exception e) {
		}
	}
	// ����

	public static void main(String args[]) {
		Chaifen.start(999, "C:/Users/Administrator/Desktop/��/�ֵ�/˫ƴ.txt", "C:/Users/Administrator/Desktop/��/�ֵ�/999shaungpin");
	}

}
/*
 * �Ѵ�������£���ǰ�Ĵ����������պ÷��������»���һ���հ��ļ������ڲ��������������
 */