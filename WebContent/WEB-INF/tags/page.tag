<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="scripts" fragment="true"%>
<%@attribute name="title" required="true"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Backlog - ${title}</title>
<link rel="stylesheet" type="text/css"
	href="/BacklogWeb/css/bootstrap.min.css" media="all" />
<link rel="stylesheet" type="text/css"
	href="/BacklogWeb/css/bootstrap-theme.min.css" media="all" />
<script type="text/javascript" src="/BacklogWeb/js/jquery.min.js"></script>
<script type="text/javascript" src="/BacklogWeb/js/jquery.updater.js"></script>
<script type="text/javascript" src="/BacklogWeb/js/bootstrap.min.js"></script>
</head>
<body>
	<div id="pageheader">
		<nav class="navbar navbar-default" role="navigation">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/BacklogWeb/"><span class="glyphicon glyphicon-home"></span> HOME</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Backlog <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="/BacklogWeb/backlog/show.do">Show</a></li>
							<li><a href="/BacklogWeb/backlog/edit.do">Edit</a></li>
						</ul>
					</li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Stories <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="/BacklogWeb/story/create.do">Add</a></li>
							<li><a href="/BacklogWeb/story/list.do">List</a></li>
						</ul>
					</li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Components <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="/BacklogWeb/component/create.do">Add</a></li>
							<li><a href="/BacklogWeb/component/list.do">List</a></li>
						</ul>
					</li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Users <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="/BacklogWeb/user/create.do">Add</a></li>
							<li><a href="/BacklogWeb/user/list.do">List</a></li>
						</ul>
					</li>
				</ul>
				
			</div>
			<!-- /.navbar-collapse -->
		</nav>
	</div>
	<div id="body">
		<div class="row">
			<div class="col-md-9">
				<jsp:doBody />
			</div>
			<div class="col-md-3">
				<ul class="nav nav-pills nav-stacked">
		
				  <li class="dropdown">
				    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
				      Backlog <span class="caret"></span>
				    </a>
				    <ul class="dropdown-menu">
						<li><a href="/BacklogWeb/backlog/show.do">Show</a></li>
						<li><a href="/BacklogWeb/backlog/edit.do">Edit</a></li>
				    </ul>
				  </li>
				  <li class="dropdown">
				    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
				      Stories <span class="caret"></span>
				    </a>
				    <ul class="dropdown-menu">
						<li><a href="/BacklogWeb/story/create.do">Add</a></li>
						<li><a href="/BacklogWeb/story/list.do">List</a></li>
				    </ul>
				  </li>
				  <li class="dropdown">
				    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
				      Components <span class="caret"></span>
				    </a>
				    <ul class="dropdown-menu">
						<li><a href="/BacklogWeb/component/create.do">Add</a></li>
						<li><a href="/BacklogWeb/component/list.do">List</a></li>
				    </ul>
				  </li>
				  <li class="dropdown">
				    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
				      Users <span class="caret"></span>
				    </a>
				    <ul class="dropdown-menu">
						<li><a href="/BacklogWeb/user/create.do">Add</a></li>
						<li><a href="/BacklogWeb/user/list.do">List</a></li>
				    </ul>
				  </li>
				
				</ul>
			</div>
		</div>
	</div>

	<div id="pagescripts">
		<jsp:invoke fragment="scripts" />
	</div>

</body>
</html>