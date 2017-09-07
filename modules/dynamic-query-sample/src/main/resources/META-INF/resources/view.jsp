<%@ page import="com.liferay.portal.kernel.model.Group" %>
<%@ page import="java.util.List" %>
<%@ include file="/init.jsp" %>


<%
	List<Group> sites = (List<Group>) request.getAttribute("sites");
%>

<c:forEach var="site" items="${sites}">
	<h2><a href="/web${site.friendlyURL}">${site.getName(locale)}</a></h2>
</c:forEach>