package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class GroupCodeDAOImpl extends DAOBase implements GroupCodeDAO {

	public ArrayList<GroupCodeVO> searchGroupCodeVO() {
		ArrayList<GroupCodeVO> list = new ArrayList();
		getConn();
		String sql = "SELECT * FROM groupcode";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				GroupCodeVO vo = new GroupCodeVO();
				vo.setGcode(rs.getString("gcode"));
				vo.setGname(rs.getString("gname"));
				list.add(vo);
			}
			System.out.println(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("몬가 문제 있음");

		}finally {
			closeConn();
		}
		
		return list;
	}

}
