<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/fmt.tld" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/spring-form.tld" prefix="form" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:page title="components">
	<jsp:body>
		<t:componentList components="${components}">
		</t:componentList>
	</jsp:body>
</t:page>