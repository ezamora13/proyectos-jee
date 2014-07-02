<%
	session.invalidate();
	//response.sendRedirect(request.getContextPath() + "/pages/public/login.jsp");
	response.sendRedirect(request.getContextPath() + "/pages/public/login.xhtml");
%>
