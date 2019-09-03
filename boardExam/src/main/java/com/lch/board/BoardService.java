package com.lch.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lch.board.dao.BoardMapper;
import com.lch.board.model.BoardVo;

@Service
public class BoardService {
	@Autowired
	private BoardMapper mapper;
	
	List<BoardVo> getBoardList(){
		return mapper.getBoardList();
	}
	
	public BoardVo getBoard(BoardVo param) {
		return mapper.getBoard(param);
	}
	
	public void insertBoard(BoardVo vo) {
		mapper.insertBoard(vo);
	}
	
	public void deleteBoard(int i) {
		mapper.deleteBoard(i);
	}
	
	public void modBoard(BoardVo vo) {
		mapper.modBoard(vo);
	}
	
	
}
