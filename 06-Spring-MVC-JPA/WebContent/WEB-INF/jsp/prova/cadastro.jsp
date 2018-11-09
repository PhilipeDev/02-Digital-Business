<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<tags:template titulo="Cadastro de Prova">
	<h1>Cadastro de Prova</h1>

	<c:if test="${not empty msg}">
		<div class="alert alert-success">${msg}</div>
	</c:if>

	<c:url value="/prova/cadastrar" var="acao" />
	<form:form action="${acao}" method="post" commandName="prova">
		<div class="form-group">
			<form:label path="assunto">Assunto</form:label>
			<form:input path="assunto" cssClass="form-control" />
			<form:errors path="assunto" cssStyle="color:red" />
		</div>
		<div class="form-group">
			<form:label path="notaMaxima">Nota máxima</form:label>
			<form:input path="notaMaxima" cssClass="form-control" />
			<form:errors path="notaMaxima" cssStyle="color:red" />
		</div>
		<div class="form-group">
			<form:label path="data">Data</form:label>
			<form:input path="data" cssClass="form-control" />
			<form:errors path="data" cssStyle="color:red" />
		</div>
		<div class="form-group">
			<form:label path="disciplina"></form:label>
			<form:select path="disciplina.codigo" cssClass="form-control" >
			<form:options items="${churros}" itemLabel="nome" itemValue="codigo" />
			</form:select>
			<form:errors path="disciplina" cssStyle="color:red" />
		</div>
		<div class="form-group">
			<form:label path="tipo">Tipo</form:label>
			<form:select path="tipo" cssClass="form-control">
				<form:options items="${tipos }" itemLabel="label" />
			</form:select>
		</div>
		<div class="form-group">
			<form:checkbox path="realizado" />
			<form:label path="realizado">Realizado</form:label>
		</div>
		<input type="submit" value="Cadastrar" class="btn btn-primary">
	</form:form>
</tags:template>