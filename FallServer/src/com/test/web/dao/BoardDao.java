package com.test.web.dao;

import java.util.List;

import com.test.web.bean.BoardBean;

public interface BoardDao {

	public BoardBean selectBoard(BoardBean bbean);
	public List<BoardBean> selectBoardList();

	//회원가입 정보 받는
	public int insertBoard(BoardBean bbean);

	//회원정보 수정
	public int updateBoard(BoardBean bbean);

	//회원정보 삭제
	public int deleteBoard(BoardBean bbean);
}
