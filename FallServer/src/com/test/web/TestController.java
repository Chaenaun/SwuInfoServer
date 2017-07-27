package com.test.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.web.bean.BoardBean;
import com.test.web.bean.MemberBean;
import com.test.web.bean.TestBean;
import com.test.web.dao.BoardDao;
import com.test.web.dao.MemberDao;

@Controller
public class TestController {
	
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private BoardDao boardDao;

	@RequestMapping("test/test1")
	public String index(String id, String pw) {
		
		System.out.println("id : " +id+"pw :"+pw);
		
		return "test1";
	}
	
	
	
	@RequestMapping("test/hello")
	public String test2(TestBean tBean) {
		
		System.out.println("id : " +tBean.getId()+", "+ "pw :"+tBean.getPw()+", "+ "addr :"+tBean.getAddr());
		
		MemberBean memberBean = memberDao.selectMember();
		System.out.println("USER_ID : " + memberBean.getUserId());
		System.out.println("USER_PW : " + memberBean.getUserPw());
		System.out.println("Name : " + memberBean.getName());
		
		/*
		BoardBean boardBean = boardDao.selectBoard(tBean);
		System.out.println("ID : " + boardBean.getUserId());
		System.out.println("TITLE : " + boardBean.getTitle());
		System.out.println("CONTENT : " + boardBean.getContent());
		System.out.println("REG_DATE : " + boardBean.getRegData());
		*/
		
		return "test1";
	}
	
	@RequestMapping("test/test3")
	public String test3(TestBean tBean) {
		
		
		return "test1";
		
	}
}
