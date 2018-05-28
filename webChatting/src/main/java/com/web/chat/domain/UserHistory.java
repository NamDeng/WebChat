package com.web.chat.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserHistory {
	private long historyId;
	private long roomId;
	private int avatarType;
	private String nickName;
	private Date joinDate;
}
