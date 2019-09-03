package com.lch.board.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data//get,set
@Alias("board")//생성자
public class BoardVo {
	private int i;
	private String title;
	private String content;
	private String pw;
	private String r_datetime;
}
