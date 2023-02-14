package model;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
//		DAO daoBase = new DAOBase();
		ProductVO pvo = new ProductVO();
//		GroupCodeVO gvo = new GroupCodeVO();
		ProductDAOImpl pImpl = new ProductDAOImpl();
		GroupCodeDAOImpl gImpl = new GroupCodeDAOImpl();
		
//		daoBase.getConn();
//		daoBase.closeConn();
//		ArrayList<GroupCodeVO> list = gImpl.searchGroupCodeVO();
//		System.out.println(list);
//		for (GroupCodeVO vo : list) {
//			System.out.println(vo.getGcode());
//			System.out.println(vo.getGname());
//		}
		
//		pvo.setCode("aaa");
//		pvo.setPname("aaaa");
//		pvo.setCost(123);
//		pvo.setPnum(100);
//		pvo.setJnum(100);
//		pvo.setSale(1000);
//		pvo.setGcode("A");
//		pImpl.insertProduct(pvo);
		
//		ArrayList<ProductVO> pList = pImpl.searchProduct("A01");
//		System.out.println(pList);
		
//		pvo.setCode("ccc");
//		pvo.setPname("냉장고");
//		pvo.setCost(999);
//		pvo.setPnum(999);
//		pvo.setJnum(999);
//		pvo.setSale(999);
//		pvo.setGcode("C");
//		pImpl.updateProduct(pvo);
		pImpl.deleteProduct("aaa");
		

	}

}
