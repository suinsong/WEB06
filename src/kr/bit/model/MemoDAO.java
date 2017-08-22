package kr.bit.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemoDAO {// JDBC <---->DB <-----myBatis

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
 
	public Connection getConnect() {
		String url = "jdbc:mysql://127.0.0.1:3306/mysql";
		String user = "root";
		String password = "!BitCom0228";

		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			conn = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;

	}

	public List<MemoVO> memoList() {
		String sql = " select * from memo order by mnum desc ";
		conn = getConnect();
		List<MemoVO> list = new ArrayList<MemoVO>();
		try {

			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				int mnum = rs.getInt("mnum");
				String mname = rs.getString("mname");
				String mcontent = rs.getString("mcontent");
				Date mday = rs.getDate("mday");

				MemoVO vo = new MemoVO(mnum, mname, mcontent, mday);
				list.add(vo);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}

	public int memoInsert(MemoVO vo) {
		String sql = " insert into memo(mname, mcontent) values( ? , ? )";
		conn = getConnect();
		int cnt = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getMname());
			ps.setString(2, vo.getMcontent());

			cnt = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;

	}

	public int memoDelete(int mnum) {
		String sql = "delete from memo where mnum=? ";
		conn = getConnect();
		int cnt = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mnum);
			cnt = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;

	}

	public MemoVO memoContent(int mnum) {
		String sql = " select * from memo where mnum=? ";
		conn = getConnect();
		MemoVO vo = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mnum);
			rs = ps.executeQuery();
			if (rs.next()) {
				mnum = rs.getInt("mnum");
				String mname = rs.getString("mname");
				String mcontent = rs.getString("mcontent");
				Date mday = rs.getDate("mday");

				vo = new MemoVO(mnum, mname, mcontent, mday);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return vo;
	}

	public int memoUpdate(MemoVO vo) {
		String sql = "update memo set mcontent=?  where mnum=?";
		conn = getConnect();
		int cnt = 0;

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getMcontent());
			ps.setInt(2, vo.getMnum());

			cnt = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}
}
