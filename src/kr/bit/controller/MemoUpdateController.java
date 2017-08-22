package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemoMybatisDAO;
import kr.bit.model.MemoVO;

public class MemoUpdateController implements Controller {

	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ������ �Ѿ�� �Ķ���͸� ����(vo)

		request.setCharacterEncoding("euc-kr");
		int mnum = Integer.parseInt(request.getParameter("mnum"));
		String mcontent = request.getParameter("mcontent");

		MemoVO vo = new MemoVO();
		vo.setMnum(mnum);
		vo.setMcontent(mcontent);

		MemoMybatisDAO  dao = new MemoMybatisDAO ();
		int cnt = dao.memoUpdate(vo);
		String nextPage = null;

		if (cnt > 0) {
			// response.sendRedirect("mList.mo");

			nextPage = "redirect:mList.mo";
		}
		return nextPage;
	}

}
