package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemoMybatisDAO;
import kr.bit.model.MemoVO;


public class MemoContentController implements Controller{

	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int mnum= Integer.parseInt(request.getParameter("mnum"));
		MemoMybatisDAO dao = new MemoMybatisDAO();
		MemoVO vo = dao.memoContent(mnum);
		request.setAttribute("vo", vo);
		
		
//		RequestDispatcher rd= request.getRequestDispatcher("memo/memoContent.jsp");
//		rd.forward(request, response);
		
		String nextPage = "/WEB-INF/memo/memoContent.jsp";
		return nextPage;
		
	}

}
