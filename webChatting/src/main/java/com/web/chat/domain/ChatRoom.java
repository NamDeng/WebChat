package com.web.chat.domain;

import java.util.Date;

public class ChatRoom {

	private long roomId;
	private String title;
	private int userCount;
	private Date regDate;
	private Date updateDate;

	public ChatRoom() {}

	public ChatRoom(Builder builder) {
		this.roomId = builder.roomId;
		this.title = builder.title;
		this.userCount = builder.userCount;
		this.regDate = builder.regDate;
		this.updateDate = builder.updateDate;
	}

	public static class Builder {
		private long roomId;
		private String title;
		private int userCount;
		private Date regDate;
		private Date updateDate;

		public Builder roomId(long roomId) {
			this.roomId = roomId;
			return this;
		}

		public Builder title(String title) {
			this.title = title;
			return this;
		}

		public Builder userCount(int userCount) {
			this.userCount = userCount;
			return this;
		}

		public Builder regDate(Date regDate) {
			this.regDate = regDate;
			return this;
		}

		public Builder updateDate(Date updateDate) {
			this.updateDate = updateDate;
			return this;
		}

		public ChatRoom build() {
			return new ChatRoom(this);
		}
	}

	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getUserCount() {
		return userCount;
	}

	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
