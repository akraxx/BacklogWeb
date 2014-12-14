<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/fmt.tld" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/spring-form.tld" prefix="form" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:page title="component">
	<jsp:body>
		<form:form cssClass="form-horizontal" role="form" modelAttribute="componentForm" action="/BacklogWeb/component${componentForm.action}" method="POST">
			<form:hidden path="action" />
			<form:hidden path="id" />
			
			<div class="form-group">
				<form:label path="label" cssClass="col-sm-2 control-label">Label :</form:label>
				<div class="col-sm-6">
					<form:input cssClass="form-control" path="label" /> 
					<form:errors path="label" cssStyle="color:red;"/>
				</div>
			</div>
			
			<div class="form-group">
				<form:label path="description" cssClass="col-sm-2 control-label">Description :</form:label>
				<div class="col-sm-6">
					<form:input cssClass="form-control" path="description" /> 
					<form:errors path="description" cssStyle="color:red;"/>
				</div>
			</div>
			
			<div class="form-group">
				<form:label path="idOwner" cssClass="col-sm-2 control-label">Owner :</form:label>
				<div class="col-sm-6">
					<form:select path="idOwner" cssClass="form-control" >
						<form:options items="${users}" itemValue="id" itemLabel="lastName" cssClass="form-control"/>
					</form:select>
					<form:errors path="idOwner" cssStyle="color:red;"/>
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