package com.test.web.dao;

import java.util.List;

import com.test.web.bean.MemberBean;

public interface MemberDao {
	
	public MemberBean selectMember(MemberBean mbean);
	public List<MemberBean> selectMemberList();
	
	//회원가입 정보 받는
	public int insertMember(MemberBean mbean);
	
	//회원정보 수정
	public int updateMember(MemberBean mbean);
	
	//회원정보 삭제
	public int deleteMember(MemberBean mbean);
	
	//회원 로그인 정보 조회
	public MemberBean loginProc(MemberBean bean);
		
}
