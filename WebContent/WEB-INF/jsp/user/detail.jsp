<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/fmt.tld" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/spring-form.tld" prefix="form" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<%@ page import="edu.flst.backlog.bo.Job" %>

<t:page title="user">
	<jsp:body>
		<form:form cssClass="form-horizontal" role="form" modelAttribute="userForm" action="/BacklogWeb/user${userForm.action}" method="POST">
			<form:hidden path="id"/>
			<form:hidden path="action"/>
			
			<div class="form-group">
				<form:label path="firstName" cssClass="col-sm-2 control-label">First name :</form:label>
				<div class="col-sm-6">
					<form:input cssClass="form-control" path="firstName" /> 
					<form:errors path="firstName" cssStyle="color:red;"/>
				</div>
			</div>
			<div class="form-group">
				<form:label path="lastName" cssClass="col-sm-2 control-label">Last name :</form:label>
				<div class="col-sm-6">
					<form:input cssClass="form-control" path="lastName" /> 
					<form:errors path="lastName" cssStyle="color:red;"/>
				</div>
			</div>
			<c:set var="jobs" value="<%=Job.values()%>"/>
			<div class="form-group">
				<form:label path="job" cssClass="col-sm-2 control-label">Job :</form:label>
				<div class="col-sm-6">
					<form:select path="job" cssClass="form-control" >
						<form:options items="${jobs}" cssClass="form-control"/>
					</form:select>
				</div>
				
			</div>
			<div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			    	<input type="submit" class="btn btn-default" />
			    </div>
		    </div>
		</form:form>
	</jsp:body>
</t:page>