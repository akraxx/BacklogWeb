<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/fmt.tld" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/spring-form.tld" prefix="form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:page title="backlog">
	<jsp:body>
		<h1>Backlog <a href="/BacklogWeb/backlog/edit.do"><span class="glyphicon glyphicon-edit"></span></a>
		</h1>
		<div class="panel-group" id="accordion">
			<div class="panel panel-default">
			  <div class="panel-heading">
			    <h4 class="panel-title">
			      <a data-toggle="collapse" data-parent="#accordion"
							href="#collapseZero" class="accordion-toggle">
			        Backlog description
			      </a>
			    </h4>
			  </div>
			  <div id="collapseZero" class="panel-collapse collapse in">
			    <div class="panel-body">
					<h2>Owner : ${backlog.owner.lastName}</h2>
					<h2>Description : ${backlog.description}</h2>
				</div>
			</div>
			</div>
			<div class="panel panel-default">
			  <div class="panel-heading">
			    <h4 class="panel-title">
			      <a data-toggle="collapse" data-parent="#accordion"
							href="#collapseOne" class="accordion-toggle">
			        Stories
			      </a>
			    </h4>
			  </div>
			  <div id="collapseOne" class="panel-collapse collapse">
			    <div class="panel-body">
					<t:storiesList stories="${stories}">
					</t:storiesList>
				</div>
			</div>
			</div>
			<div class="panel panel-default">
			    <div class="panel-heading">
			      <h4 class="panel-title">
			        <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" class="accordion-toggle">
			          Users
			        </a>
			      </h4>
			    </div>
			    <div id="collapseTwo" class="panel-collapse collapse">
			      <div class="panel-body">
		
					<t:usersList users="${users}">
					</t:usersList>
					</div>
				</div>
			</div>
			<div class="panel panel-default">
			    <div class="panel-heading">
			      <h4 class="panel-title">
			        <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree" class="accordion-toggle">
			          Components
			        </a>
			      </h4>
			    </div>
			    <div id="collapseThree" class="panel-collapse collapse">
			      <div class="panel-body">
		
					<t:componentList components="${components}">
					</t:componentList>
					</div>
				</div>
			</div>
		</div>
	</jsp:body>
</t:page>