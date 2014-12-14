<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@attribute name="stories" required="true" type="java.util.List"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/fmt.tld" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/spring-form.tld" prefix="form" %>

<table class="table table-hover table-condensed">
	<thead>
		<tr>
			<th>Label</th>
			<th>Comment</th>
			<th>Status</th>
			<th>User</th>
			<th>Component</th>
			<th>Created on</th>
			<th>Last modification</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${stories}" var="story">
			<tr>
				<td>${story.label}</td>
				<td>${story.comment}</td>
				<td>${story.status}</td>
				<td><a href="/BacklogWeb/user/${story.user.id}/edit.do">${story.user.lastName}</a></td>
				<td><a href="/BacklogWeb/component/${story.component.id}/edit.do">${story.component.label}</a></td>
				<td><fmt:formatDate value="${story.createdDate}" pattern="dd/MM/yyyy HH:mm:ss"/></td>
				<td><fmt:formatDate value="${story.modifiedDate}" pattern="dd/MM/yyyy HH:mm:ss"/></td>
				<td><a href="/BacklogWeb/story/${story.id}/edit.do"><span class="glyphicon glyphicon-edit"></span></a></td>
				<td><a href="/BacklogWeb/story/${story.id}/delete.do"><span class="glyphicon glyphicon-remove"></span></a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
