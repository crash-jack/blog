package com.blog.article.utils;

import java.util.ArrayList;

public class Timer {
	private long interval; // ��ʱ��ʱ�䣬��λ ms
	private String expiryAction; // Ŀ�����
	private int timerId; // ��ʱ��Id
	private long waitTime; // ��ʱ���ȴ�ʱ��
	// ���캯��

	public Timer() {
		this.waitTime = 0;
	}

	// ��Ӷ�ʱ��
	public int StartTimer(long interval, String expiryAction, int id) {
		this.interval = interval;
		this.expiryAction = expiryAction;
		this.timerId = id;
		return timerId;
	}

	// ȡ����ʱ��
	public void StopTimer(int timerId, ArrayList<Timer> timer) {
		timer.remove(timerId);
	}

	// ��ʱ�����
	public void PerTickBookkeeping() {
		if (this.interval > this.waitTime)
			this.waitTime += 10;
		else {
			System.out.println("��ʱ��" + this.timerId + ":" + this.expiryAction);
			this.waitTime = 0;
		}
	}

	public long getInterval() {
		return interval;
	}

	public void setInterval(long interval) {
		this.interval = interval;
	}

	public String getExpiryAction() {
		return expiryAction;
	}

	public void setExpiryAction(String expiryAction) {
		this.expiryAction = expiryAction;
	}

	public int getTimerId() {
		return timerId;
	}

	public void setTimerId(int timerId) {
		this.timerId = timerId;
	}

	public long getWaitTime() {
		return waitTime;
	}

	public void setWaitTime(long waitTime) {
		this.waitTime = waitTime;
	}
}