<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ attribute name="id" required="true" %>
<%@ attribute name="label" required="false" %>
<%@ attribute name="value" required="false" %>
<%@ attribute name="enabled" required="false" %>

<c:if test="${not empty label }">
	<label for="${id}">${label}</label>
</c:if>

<c:choose>
	<c:when test="${enabled == false}">
		<input type="text" id="${id}" name="${id}" value="${value}" readonly />
	</c:when>
	<c:otherwise>
		<input type="text" id="${id}" name="${id}" value="${value}"/>
	</c:otherwise>
</c:choose>
