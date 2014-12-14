<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@attribute name="users" required="true" type="java.util.List"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/fmt.tld" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/spring-form.tld" prefix="form" %>

<table class="table table-hover table-condensed">
	<thead>
		<tr>
			<th>First name</th>
			<th>Last name</th>
			<th>Job</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.firstName}</td>
				<td>${user.lastName}</td>
				<td>${user.job}</td>
				<td><a href="/BacklogWeb/user/${user.id}/edit.do"><span class="glyphicon glyphicon-edit"></span></a></td>
				<td><a href="/BacklogWeb/user/${user.id}/delete.do"><span class="glyphicon glyphicon-remove"></span></a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>