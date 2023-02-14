package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

public class ProductDAOImpl extends DAOBase implements ProductDAO { 


	public void insertProduct(ProductVO vo) {
		getConn();
		String sql = "insert into product values (?, ?, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getCode());
			pstmt.setString(2, vo.getPname());
			pstmt.setInt(3, vo.getCost());
			pstmt.setInt(4, vo.getPnum());
			pstmt.setInt(5, vo.getJnum());
			pstmt.setInt(6, vo.getSale());
			pstmt.setString(7, vo.getGcode());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConn();
		}

	}


	public ProductVO searchProduct(String code) { //가져올 값은 1개 행 뿐이므로 굳이 리스트에 넣을 필요 없어서 객체로 반환
		getConn();
		ProductVO vo = new ProductVO();
		String sql = "select * from product where  code = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				vo.setCode(rs.getString(1));
				vo.setPname(rs.getString(2));
				vo.setCost(rs.getInt(3));
				vo.setPnum(rs.getInt(4));
				vo.setJnum(rs.getInt(5));
				vo.setSale(rs.getInt(6));
				vo.setGcode(rs.getString(7));
				System.out.println("메소드처리결과 : "+vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("몬가 문제 있음");

		}finally {
			closeConn();
		}
		
		return vo;
	}


	public void updateProduct(ProductVO vo) {//바뀐 값만 바꾸기? 전부 바꿔서 일부만 바뀐 것처럼 속이기?(일단 이거로) 
		getConn();
		String sql = "update product set pname = ? , cost = ? , pnum = ?, jnum = ?, sale = ?, gcode = ? where code = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPname());
			pstmt.setInt(2, vo.getCost());
			pstmt.setInt(3, vo.getPnum());
			pstmt.setInt(4, vo.getJnum());
			pstmt.setInt(5, vo.getSale());
			pstmt.setString(6, vo.getGcode());
			pstmt.setString(7, vo.getCode());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConn();
		}

	}


	public void deleteProduct(String code) {
		getConn();
		String sql = "delete from product where code = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConn();
		}
		

	}


	public ArrayList<ProductVO> searchFirst() {
		getConn();
		ArrayList<ProductVO> list= new ArrayList();
		String sql = "select code, pname, pnum, jnum from product where jnum < pnum*(20/100)";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setCode(rs.getString("code"));
				vo.setPname(rs.getString("pname"));
				vo.setPnum(rs.getInt("pnum"));
				vo.setJnum(rs.getInt("jnum"));
				list.add(vo);
			}
			System.out.println(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public ArrayList<ProductVO> searchRank() {
		getConn();
		ArrayList<ProductVO> list= new ArrayList();
		String sql = "select pname, sale, jnum from product order by jnum*sale desc";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setPname(rs.getString("pname"));
				System.out.println("pname : "+vo.getPname());
				vo.setSale(rs.getInt("sale"));
				System.out.println("sale : "+vo.getSale());
				vo.setJnum(rs.getInt("jnum"));
				list.add(vo);
			}
			System.out.println(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public ArrayList<ProductVO> searchGroup() {
		getConn();
		ArrayList<ProductVO> list= new ArrayList();
		String sql = "SELECT gcode, sum(jnum) FROM product group by gcode";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setGcode(rs.getString("gcode"));
				System.out.println("pname : "+vo.getGcode());
				vo.setJnum(rs.getInt("sum(jnum)"));
				System.out.println("sale : "+vo.getJnum());
				list.add(vo);
			}
			System.out.println(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
	


	

}
