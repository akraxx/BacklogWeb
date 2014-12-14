<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@attribute name="components" required="true" type="java.util.List"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/fmt.tld" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/spring-form.tld" prefix="form" %>

<table class="table table-hover table-condensed">
	<thead>
		<tr>
			<th>Label</th>
			<th>Owner</th>
			<th>Description</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${components}" var="component">
			<tr>
				<td>${component.label}</td>
				<td><a href="/BacklogWeb/user/${component.owner.id}/edit.do">${component.owner.lastName}</a></td>
				<td>${component.description}</td>
				<td><a href="/BacklogWeb/component/${component.id}/edit.do"><span class="glyphicon glyphicon-edit"></span></a></td>
				<td><a href="/BacklogWeb/component/${component.id}/delete.do"><span class="glyphicon glyphicon-remove"></span></a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
