<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<tags:template titulo="Lista de Provas">
	<h1>Lista de Prova</h1>
	
	<table class="table">
		<tr>
			<th>Assunto</th>
			<th>Nota máxima</th>
			<th>Data</th>
			<th>Disciplina</th>
			<th>Realizado</th>
			<th>Tipo</th>
		</tr>
		<c:forEach items="${lista}" var="p">
			<tr>
				<td>${p.assunto}</td>
				<td>${p.notaMaxima}</td>
				<td>
					<fmt:formatDate value="${p.data.time}" pattern="dd/MM/yyyy"/>
				</td>
				<td>${p.disciplina.nome}</td>
				<td>${p.realizado?"Sim":"Não"}</td>
				<td>${p.tipo.label }</td>
			</tr>
		</c:forEach>
	</table>
</tags:template>