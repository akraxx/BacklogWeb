<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/fmt.tld" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/spring-form.tld" prefix="form" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<%@ page import="edu.flst.backlog.bo.Status" %>

<t:page title="story">
	<jsp:body>
		<form:form cssClass="form-horizontal" role="form"  modelAttribute="storyForm" action="/BacklogWeb/story${storyForm.action}" method="POST">
			<form:hidden path="id" />
			<form:hidden path="action" />
			<form:hidden path="createdDate" />
			<form:hidden path="modifiedDate" />
			
			<div class="form-group">
				<form:label path="label" cssClass="col-sm-2 control-label">Label :</form:label>
				<div class="col-sm-6">
					<form:input cssClass="form-control" path="label" /> 
					<form:errors path="label" cssStyle="color:red;"/>
				</div>
			</div>
			
			<div class="form-group">
				<form:label path="comment" cssClass="col-sm-2 control-label">Comment :</form:label>
				<div class="col-sm-6">
					<form:input cssClass="form-control" path="comment" /> 
					<form:errors path="comment" cssStyle="color:red;"/>
				</div>
			</div>

			<c:set var="statuses" value="<%=Status.values()%>"/>			
			<div class="form-group">
				<form:label path="status" cssClass="col-sm-2 control-label">Status :</form:label>
				<div class="col-sm-6">
					<form:select path="status" cssClass="form-control" >
						<form:options items="${statuses}" cssClass="form-control"/>
					</form:select>
					<form:errors path="status" cssStyle="color:red;"/>
				</div>
			</div>
			
			<div class="form-group">
				<form:label path="idUser" cssClass="col-sm-2 control-label">User :</form:label>
				<div class="col-sm-6">
					<form:select path="idUser" cssClass="form-control" >
						<form:options items="${users}" itemValue="id" itemLabel="lastName" cssClass="form-control"/>
					</form:select>
					<form:errors path="idUser" cssStyle="color:red;"/>
				</div>
			</div>
			
			<div class="form-group">
				<form:label path="idComponent" cssClass="col-sm-2 control-label">Component :</form:label>
				<div class="col-sm-6">
					<form:select path="idComponent" cssClass="form-control" >
						<form:options items="${components}" itemValue="id" itemLabel="label" cssClass="form-control"/>
					</form:select>
					<form:errors path="idComponent" cssStyle="color:red;"/>
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