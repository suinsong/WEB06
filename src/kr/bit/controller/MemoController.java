package kr.bit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemoDAO;

import kr.bit.model.MemoVO;

public class MemoController { // pojo형태<---인터페이스 상속 ㄴㄴ

	
	//mList.mo ----- ▼
	//@RequestMapping("mList.mo")
	public String memoList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MemoDAO dao = new MemoDAO();
		List<MemoVO> list = dao.memoList();
		request.setAttribute("list", list);

		String nextPage = "/WEB-INF/memo/memoList.jsp";
		return nextPage;

	}
	
	//mInsert.mo ----- ▼
	//@RequestMapping("mInsert.mo")
	public String memoInsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String mname = request.getParameter("mname");
		String mcontent = request.getParameter("mcontent");
		MemoVO vo = new MemoVO();
		vo.setMname(mname);
		vo.setMcontent(mcontent);

		MemoDAO dao = new MemoDAO();
		int cnt = dao.memoInsert(vo);
		String nextPage = null;
		if (cnt > 0) {
			nextPage = "redirect:mList.mo"; // redirect
			// response.sendRedirect("mList.mo");

		}
		return nextPage;
	}

}
