<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ attribute name="id" required="true" %>
<%@ attribute name="label" required="false" %>
<%@ attribute name="values" required="true" %>

<c:if test="${not empty label }">
	<label for="${id}">${label}</label>
</c:if>

<select name="${id}" id="${id }">
	<% 
		String[] options = values.split(",");
	
	%>
	
	<c:forEach var="option" items="${options}" varStatus="count">
		<c:choose>
			<c:when test="${count == 1}">
				<option selected value="${option}" >${option}</option>
			</c:when>
			<c:otherwise>
				<option value="${option}" >${option}</option>				
			</c:otherwise>
		</c:choose>
	</c:forEach>
</select>