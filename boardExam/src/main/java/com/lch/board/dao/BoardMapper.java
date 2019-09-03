package com.lch.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.lch.board.model.BoardVo;

@Mapper
@Repository//dao 역할
public interface BoardMapper {
	List<BoardVo> getBoardList();

	void insertBoard(BoardVo vo);
	void deleteBoard(int i);
	BoardVo getBoard(BoardVo param);
	void modBoard(BoardVo vo);
}
