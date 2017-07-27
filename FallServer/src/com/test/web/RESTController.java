package com.test.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.web.bean.BoardBean;
import com.test.web.bean.MemberBean;
import com.test.web.dao.BoardDao;
import com.test.web.dao.MemberDao;

@Controller
public class RESTController {

	@Autowired
	private MemberDao memberDao;
	@Autowired
	private BoardDao boardDao;

	//DB -> Bean -> Json
	@RequestMapping("/rest/selectMember")
	@ResponseBody
	public Map<String, Object> selectMember(MemberBean mbean) {

		Map<String, Object> resMap = new HashMap<String, Object>();

		try {
			MemberBean mBean = memberDao.selectMember(mbean);

			resMap.put("result", "ok");
			resMap.put("memberBean", mBean);


		} catch (Exception e) {
			e.printStackTrace();
			resMap.put("result", "fail");
		}
		return resMap;
	}
	
	//DB -> Bean -> Json
		@RequestMapping("/rest/selectboard")
		@ResponseBody
		public Map<String, Object> selectboard(BoardBean bbean) {

			Map<String, Object> resMap = new HashMap<String, Object>();

			try {
				BoardBean bBean = boardDao.selectBoard(bbean);

				resMap.put("result", "ok");
				resMap.put("BoardBean", bBean);


			} catch (Exception e) {
				e.printStackTrace();
				resMap.put("result", "fail");
			}
			return resMap;
		}

	//DB -> Bean -> Json
	@RequestMapping("/rest/selectMemberList")
	@ResponseBody
	public Map<String, Object> selectMemberList() {

		Map<String, Object> resMap = new HashMap<String, Object>();

		try {
			List<MemberBean> list = memberDao.selectMemberList();

			resMap.put("result", "ok");
			resMap.put("memberList", list);


		} catch (Exception e) {
			e.printStackTrace();
			resMap.put("result", "fail");
		}
		return resMap;
	}

	//DB -> Bean -> Json
	@RequestMapping("/rest/selectBoardList")
	@ResponseBody
	public Map<String, Object> selectBoardList() {

		Map<String, Object> resMap = new HashMap<String, Object>();

		try {
			List<BoardBean> list = boardDao.selectBoardList();

			resMap.put("result", "ok");
			resMap.put("boardList", list);


		} catch (Exception e) {
			e.printStackTrace();
			resMap.put("result", "fail");
		}
		return resMap;
	}
	
	
	
	@RequestMapping("/rest/insertMember")
	@ResponseBody
	public Map<String, Object> insertMember(MemberBean mBean) {

		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("result", "fail");

		try {
			
			int resVal = memberDao.insertMember(mBean);

			if(resVal > 0) {
			resMap.put("result", "ok");
			}

		}
		catch (DuplicateKeyException dke) {
			resMap.put("resultMsg", "이미 존재하는 USER_ID입니다.");
		}
		
		catch (Exception e) {
			e.printStackTrace();
			resMap.put("resultMsg", e.getMessage());
		}
		return resMap;
	}
	
	@RequestMapping("/rest/insertBoard")
	@ResponseBody
	public Map<String, Object> insertBoard(BoardBean bBean) {

		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("result", "fail");

		try {
			
			int resVal = boardDao.insertBoard(bBean);

			if(resVal > 0) {
			resMap.put("result", "ok");
			}

		}
		catch (DuplicateKeyException dke) {
			resMap.put("resultMsg", "이미 존재하는 USER_ID입니다.");
		}
		
		catch (Exception e) {
			e.printStackTrace();
			resMap.put("resultMsg", e.getMessage());
		}
		return resMap;
	}
	
	
	@RequestMapping("/rest/updateMember")
	@ResponseBody
	public Map<String, Object> updateMember(MemberBean mBean) {

		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("result", "fail");

		try {
			
			int resVal = memberDao.updateMember(mBean);

			if(resVal > 0) { //성공하면 1이 넘어온다.
			resMap.put("result", "ok");
			}
			else {
				resMap.put("resultMsg", "존재하지 않는 USER_ID입니다,");
			}

		}
		
		catch (Exception e) {
			e.printStackTrace();
			resMap.put("resultMsg", e.getMessage());
		}
		return resMap;
	}
	
	
	@RequestMapping("/rest/updateBoard")
	@ResponseBody
	public Map<String, Object> updateBoard(BoardBean bBean) {

		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("result", "fail");

		try {
			
			int resVal = boardDao.updateBoard(bBean);

			if(resVal > 0) { //성공하면 1이 넘어온다.
			resMap.put("result", "업데이트 성공~");
			}
			else {
				resMap.put("resultMsg", "존재하지 않는 USER_ID입니다,");
			}

		}
		
		catch (Exception e) {
			e.printStackTrace();
			resMap.put("resultMsg", e.getMessage());
		}
		return resMap;
	}
	
	
	
	
	@RequestMapping("/rest/deleteMember")
	@ResponseBody
	public Map<String, Object> deleteMember(MemberBean mBean) {

		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("result", "fail");

		try {
			
			int resVal = memberDao.deleteMember(mBean);

			if(resVal > 0) { //성공하면 1이 넘어온다.
			resMap.put("result", "삭제 성공~");
			}
			else {
				resMap.put("resultMsg", "존재하지 않는 USER_ID입니다,");
			}

		}
		
		catch (Exception e) {
			e.printStackTrace();
			resMap.put("resultMsg", e.getMessage());
		}
		return resMap;
	}
	
	@RequestMapping("/rest/deleteBoard")
	@ResponseBody
	public Map<String, Object> deleteBoard(BoardBean bBean) {

		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("result", "fail");

		try {
			
			int resVal = boardDao.deleteBoard(bBean);

			if(resVal > 0) { //성공하면 1이 넘어온다.
			resMap.put("result", "삭제 성공~");
			}
			else {
				resMap.put("resultMsg", "존재하지 않는 USER_ID입니다,");
			}

		}
		
		catch (Exception e) {
			e.printStackTrace();
			resMap.put("resultMsg", e.getMessage());
		}
		return resMap;
	}
	
	
}
