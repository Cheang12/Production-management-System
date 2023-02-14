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
//추가하고 싶은것 : 1. 제품코드는 수정이 불가능합니다. 2. 이전과 동일한 데이터입니다. 수정할 데이터를 입력해주세요. 3. 중복된 코드입니다. 다른 코드를 ~ 4. 없는 제품코드입니다. 5. 조회 수정 시 int 들어갈 곳에 null 들어가면 나오는 예외 해결

@WebServlet("/productServlet/*")
public class ProductServlet extends HttpServlet {//받는 대상이 전부 처리하면 됨 이름에 구애받지 않음.
	private static final long serialVersionUID = 1L;
       

    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		}else if(newPath.equals("list")) {//조회&수정에 대한 처리
			path = "/productList.jsp";
			ArrayList<GroupCodeVO> glist = gImpl.searchGroupCodeVO();
			System.out.println(glist);
			request.setAttribute("glist", glist);
			
			String flag = request.getParameter("flag");
			if (flag != null) {
				String action = request.getParameter("action"); //어느 버튼을 눌렀는지 확인 action으로 보낸 값이 없으므로 null point exception 발생함. 귀찮으니까 그냥 플래그 사용할래 action으로 값을 처리하는 순간은 최초 접속 당시가 아닌 submit을 수행한 순간이어야 하므로 flag가 필요함. 
				System.out.println("action : "+action);
				if (action.equals("search")) {//조회에 대한 처리
					String code = request.getParameter("code");
					ProductVO vo = pImpl.searchProduct(code);
					request.setAttribute("pdata", vo);
					path = "/productList.jsp";
				}else if (action.equals("update")) {//수정에 대한 처리
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
					path = "/productList.jsp";
				}else if (action.equals("delete")) {//삭제에 대한 처리
					String code = request.getParameter("code");
					pImpl.deleteProduct(code);
					
					path = "/productList.jsp";
				}
			}
				
	
			System.out.println(path);
		}else if(newPath.equals("first")) {
			ArrayList<ProductVO> list = pImpl.searchFirst();
			request.setAttribute("list", list);
			
			path = "/productFirst.jsp";
			System.out.println(path);
		}else if(newPath.equals("rank")) {
			ArrayList<ProductVO> list = pImpl.searchRank();
			request.setAttribute("list", list);
			
			path = "/productSalesRank.jsp";
			System.out.println(path);
		}else if(newPath.equals("group")) {
			ArrayList<ProductVO> list = pImpl.searchGroup();
			request.setAttribute("list", list);
			
			ArrayList<GroupCodeVO> glist = gImpl.searchGroupCodeVO();
			System.out.println(glist);
			request.setAttribute("glist", glist);
			
			path = "/productGroup.jsp";
			System.out.println(path);
		}else if(newPath.equals("main")) {
			path = "/main.jsp";
			System.out.println(path);
		}

		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
