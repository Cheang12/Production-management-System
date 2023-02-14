package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GroupCodeDAOImpl;
import model.GroupCodeVO;
import model.ProductDAOImpl;
import model.ProductVO;


@WebServlet("/productServl")
public class NoUsedProductServlet2 extends HttpServlet {//받는 대상이 전부 처리하면 됨 이름에 구애받지 않음.
	private static final long serialVersionUID = 1L;
       

    public NoUsedProductServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAOImpl pImpl = new ProductDAOImpl();
		GroupCodeDAOImpl gImpl = new GroupCodeDAOImpl();
		String path = "/error.jsp";
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		System.out.println(uri);
		int lastIndex = uri.lastIndexOf("/");
		System.out.println(lastIndex);
		String newPath = uri.substring(lastIndex+1);
		System.out.println(newPath);
		
		if (newPath.equals("input")) { //입력에 대한 처리
			path = "/productInput.jsp";
			System.out.println(path);
			ArrayList<GroupCodeVO> glist = gImpl.searchGroupCodeVO();
			System.out.println(glist);
			request.setAttribute("glist", glist);
			
			String flag = request.getParameter("flag");
			System.out.println("flag :"+flag);
			if (flag != null) {
				String code = request.getParameter("code");
				String pname = request.getParameter("pname");
				int cost = Integer.parseInt(request.getParameter("cost"));
				int pnum = Integer.parseInt(request.getParameter("pnum"));
				int jnum = Integer.parseInt(request.getParameter("jnum"));
				int sale = Integer.parseInt(request.getParameter("sale"));
				String gcode = request.getParameter("gcode");
				
				ProductVO vo = new ProductVO();
				vo.setCode(code);
				vo.setPname(pname);
				vo.setCost(cost);
				vo.setPnum(pnum);
				vo.setJnum(jnum);
				vo.setSale(sale);
				vo.setGcode(gcode);
				
				pImpl.insertProduct(vo);
			}
		}else if(newPath.equals("list")) {//조회에 대한 처리
			path = "/productList.jsp";
			ArrayList<GroupCodeVO> glist = gImpl.searchGroupCodeVO();
			System.out.println(glist);
			
			request.setAttribute("glist", glist);
			
			String flag = request.getParameter("flag");
			System.out.println("flag : "+flag);
			if (flag != null) {
				String action = request.getParameter("action");
				System.out.println("action : "+action);
				if (action.equals("search")) {
					String code = request.getParameter("code");
					ProductVO vo= pImpl.searchProduct(code);
					request.setAttribute("plist", vo);
					path = "/productListResult.jsp";
				}
			}else{ //조회없이 수정이나 삭제를 바로 누르면 view에서 팝업창이 뜨게?(제품 조회 후 수정 혹은 삭제를 할 수 있습니다.) 지금은 그냥 자기자신에게로 돌아옴(사용자 입장에서는 아무일도 일어나지 않음)
				
			}
			System.out.println(path);
		}else if(newPath.equals("listResult")){//조회 후 결과에 대한 처리(수정, 삭제)
			String action = request.getParameter("action");
			
			if (action.equals("update")) {
				path = "/productServlet/list";
				String code = request.getParameter("code");
				String pname = request.getParameter("pname");
				int cost = Integer.parseInt(request.getParameter("cost"));
				int pnum = Integer.parseInt(request.getParameter("pnum"));
				int jnum = Integer.parseInt(request.getParameter("jnum"));
				int sale = Integer.parseInt(request.getParameter("sale"));
				String gcode = request.getParameter("gcode");
				System.out.println(gcode);
				
				ProductVO vo = new ProductVO();
				vo.setCode(code);
				vo.setPname(pname);
				vo.setCost(cost);
				vo.setPnum(pnum);
				vo.setJnum(jnum);
				vo.setSale(sale);
				vo.setGcode(gcode);
				
				pImpl.updateProduct(vo);
			}
			
			
		}else if(newPath.equals("first")) {
//			path = "/productList.jsp";
//			System.out.println(path);
		}else if(newPath.equals("rank")) {
//			path = "/productList.jsp";
//			System.out.println(path);
		}else if(newPath.equals("group")) {
//			path = "/productList.jsp";
//			System.out.println(path);
		}else if(newPath.equals("main")) {
			path = "/main.jsp";
			System.out.println(path);
		}

		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
