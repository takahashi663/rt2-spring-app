package jp.co.sss.crud.filter;

//@Component
/*public class LoginCheckFilter extends HttpFilter {
	@Override
	public void doFilter(
			HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//リクエストURLを送信
		String requestURL = request.getRequestURI();
		if (requestURL.indexOf("/html/") != -1 ||
				requestURL.indexOf("/css/") != -1||
				requestURL.indexOf("img/") != -1 ||
				requestURL.indexOf("/js/") != -1 ||
				requestURL.endsWith("/") ||
				requestURL.endsWith("/login")) {
			chain.doFilter(request, response);

		} else {
			HttpSession session = request.getSession();

			EmployeeBean userId = (EmployeeBean) session.getAttribute("loginUser");

			if (userId == null) {
				response.sendRedirect("/spring_crud/");
				return;

			} else {
				chain.doFilter(request, response);
			}
		}
	}
}
*/