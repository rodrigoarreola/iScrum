<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>
<% String nombre = (String) request.getSession().getAttribute("user1");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <meta charset="utf-8">
        <title>Dashboard</title>
		<link rel="stylesheet" type="text/css" href="css/materialize.css">
	    <script href="js/materialize.js"></script>
        <link rel="stylesheet" type="text/css" href="css/dashboard.css">
        <link rel="stylesheet" type="text/css" href="css/flexboxgrid.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>
    <body>

	<div class="row">
		<div class="col s6 m6">
			<div class="card blue-grey darken-1">
				<div class="card-content white-text">
					<span class="card-title centered">Product Backlog</span>
					<table class="centered">
						<thead>
				            <tr>
				                <th><h5>Detalles</h5></th>
				                <th><h5>Borrar</h5></th>
				            </tr>
					    </thead>

				        <tbody>
				        <c:forEach var="x" items="${FormaListadoRequisitos.requisito}">
				            <tr>
												<c:if test = "${x.nombre =='backlog'}">
													<td align="center"><c:out value="${x.descripcion}"/></td>
													<td align="center"> <a href='solicitarEliminarRequisito.do?descripcion=<c:out value="${x.descripcion}"/>'>
														X
			                    </a></td>
					                <%-- <td align="center"><c:out value="${x.nombre}"/></td> --%>
												</c:if>
				            </tr>
				        </c:forEach>
					    </tbody>
					</table>
				</div>
			</div>
		</div>

		<div class="col s6 m6">
			<div class="card blue-grey darken-1">
				<div class="card-content white-text">
					<span class="card-title centered">To Do</span>
					<table class="centered">
						<thead>
				            <tr>
				                <th><h5>Detalles</h5></th>
				                <th><h5>Borrar</h5></th>
				            </tr>
					    </thead>

				        <tbody>
				        <c:forEach var="x" items="${FormaListadoRequisitos.requisito}">
				            <tr>
											<c:if test = "${x.nombre =='todo'}">
												<td align="center"><c:out value="${x.descripcion}"/></td>

												<td align="center">
													<td align="center"> <a href='solicitarEliminarRequisito.do?descripcion=<c:out value="${x.descripcion}"/>'>
														X
			                    </a></td>
												</td>

												<%-- <td align="center"><c:out value="${x.nombre}"/></td> --%>
											</c:if>
				            </tr>
				        </c:forEach>
					    </tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col s6 m6">
			<div class="card blue-grey darken-1">
				<div class="card-content white-text">
					<span class="card-title centered">In Progress</span>
					<table class="centered">
						<thead>
				            <tr>
				                <th><h5>Detalles</h5></th>
				                <th><h5>Borrar</h5></th>
				            </tr>
					    </thead>

				        <tbody>
				        <c:forEach var="x" items="${FormaListadoRequisitos.requisito}">
				            <tr>
											<c:if test = "${x.nombre =='inprogress'}">
												<td align="center"><c:out value="${x.descripcion}"/></td>
												<td align="center"> <a href='solicitarEliminarRequisito.do?descripcion=<c:out value="${x.descripcion}"/>'>
													X
												</a></td>
												<%-- <td align="center"><c:out value="${x.nombre}"/></td> --%>
											</c:if>
				            </tr>
				        </c:forEach>
					    </tbody>
					</table>
				</div>
			</div>
		</div>

		<div class="col s6 m6">
			<div class="card blue-grey darken-1">
				<div class="card-content white-text">
					<span class="card-title centered">Done</span>
					<table class="centered">
						<thead>
				            <tr>
				                <th><h5>Detalles</h5></th>
				                <th><h5>Borrar</h5></th>
				            </tr>
					    </thead>

				        <tbody>
				        <c:forEach var="x" items="${FormaListadoRequisitos.requisito}">
				            <tr>
											<c:if test = "${x.nombre =='done'}">
												<td align="center"><c:out value="${x.descripcion}"/></td>
												<td align="center"> <a href='solicitarEliminarRequisito.do?descripcion=<c:out value="${x.descripcion}"/>'>
													X
												</a></td>
												<%-- <td align="center"><c:out value="${x.nombre}"/></td> --%>
											</c:if>
				            </tr>
				        </c:forEach>
					    </tbody>
					</table>
				</div>
			</div>
		</div>
	</div>





    </body>
</html>
