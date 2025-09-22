package jp.co.sss.crud.filter;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jp.co.sss.crud.bean.EmployeeBean;

@Component
public class AccountCheckFilter extends HttpFilter {

	@Override
	public void doFilter(
			HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//リクエストURLを送信
		String requestURL = request.getRequestURI();
		if (requestURL.indexOf("/html/") != -1 ||
				requestURL.indexOf("/css/") != -1 ||
				requestURL.indexOf("img/") != -1 ||
				requestURL.indexOf("/js/") != -1) {
			chain.doFilter(request, response);
		}
		if (requestURL.endsWith("/delete/check") ||
				requestURL.endsWith("/regist/input")) {

		
			HttpSession session = request.getSession();

			EmployeeBean authority = (EmployeeBean) session.getAttribute("loginUser");

			if (authority.getAuthority() == 1 || authority == null) {
				session.invalidate();
				response.sendRedirect("/spring_crud/");
				
				return;
				
			} else {
				chain.doFilter(request, response);//フィルターの中を通れる記述
			}
		}else {
			chain.doFilter(request, response);
		}
	}
}
