package com.web.chat.domain;

import java.util.Date;

public class UserHistory {

	private long historyId;
	private long roomId;
	private String nickName;
	private Date joinDate;

	public UserHistory() { }

	public UserHistory(Builder builder) {
		this.historyId = builder.historyId;
		this.roomId = builder.roomId;
		this.nickName = builder.nickName;
		this.joinDate = builder.joinDate;
	}

	public static class Builder {
		private long historyId;
		private long roomId;
		private String nickName;
		private Date joinDate;
		
		public Builder historyId(long historyId) {
			this.historyId = historyId;
			return this;
		}
		
		public Builder roomId(long roomId) {
			this.roomId = roomId;
			return this;
		}

		public Builder nickName(String nickName) {
			this.nickName = nickName;
			return this;
		}

		public Builder joinDate(Date joinDate) {
			this.joinDate = joinDate;
			return this;
		}
		
		public UserHistory build() {
			return new UserHistory(this);
		}
	}

	public long getHistoryId() {
		return historyId;
	}

	public void setHistoryId(long historyId) {
		this.historyId = historyId;
	}

	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
}
