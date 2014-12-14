<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/fmt.tld" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/spring-form.tld" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:page title="home">
	<jsp:attribute name="scripts">
		<script type="text/javascript">
			$("#latestStories").smartupdater({
				url : 'story/latest.do',
				minTimeout: 1000 // 1 seconds
				}, function (data) {
					$("#latestStories").html(data);
					var now = new Date();
					$("#updateTime").html(now.toString());
				}
			);
		</script>
	</jsp:attribute>
	
	<jsp:body>
		<h2>Backlog</h2>
		<ul>
			<li><a href="/BacklogWeb/backlog/show.do">Afficher le backlog</a></li>
		</ul>
		<h2>
			Latests modified stories : (updated at <b><span id="updateTime">loading...</span></b>)
		</h2>
		<div id="latestStories">
			loading ... <br>
		</div>
	</jsp:body>
	
</t:page>
