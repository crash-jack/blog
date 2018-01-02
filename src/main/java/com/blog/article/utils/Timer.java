package com.blog.article.utils;

import java.util.ArrayList;

public class Timer {
	private long interval; // 定时器时间，单位 ms
	private String expiryAction; // 目标操作
	private int timerId; // 定时器Id
	private long waitTime; // 定时器等待时间
	// 构造函数

	public Timer() {
		this.waitTime = 0;
	}

	// 添加定时器
	public int StartTimer(long interval, String expiryAction, int id) {
		this.interval = interval;
		this.expiryAction = expiryAction;
		this.timerId = id;
		return timerId;
	}

	// 取消定时器
	public void StopTimer(int timerId, ArrayList<Timer> timer) {
		timer.remove(timerId);
	}

	// 定时器检查
	public void PerTickBookkeeping() {
		if (this.interval > this.waitTime)
			this.waitTime += 10;
		else {
			System.out.println("定时器" + this.timerId + ":" + this.expiryAction);
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