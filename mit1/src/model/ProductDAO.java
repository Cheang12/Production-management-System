package model;

import java.util.ArrayList;

public interface ProductDAO {
	
	void insertProduct(ProductVO vo);
	ProductVO searchProduct(String code);
	void updateProduct(ProductVO vo);
	void deleteProduct(String code);
	ArrayList<ProductVO> searchFirst();
	ArrayList<ProductVO> searchRank();
	ArrayList<ProductVO> searchGroup();

	
	
	
}
