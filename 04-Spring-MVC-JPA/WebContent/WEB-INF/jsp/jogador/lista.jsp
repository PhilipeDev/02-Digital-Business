<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<tags:template titulo="Lista de Jogadores">
	
	<h1>Lista de Jogadores</h1>
	
	<c:if test="${not empty msg }">
		<div class="alert alert-success">
			${msg }
		</div>
	</c:if>
	
	<table class="table">
		<tr>
			<th>Código</th>
			<th>Nome</th>
			<th>Ativo</th>
			<th>Data Nascimento</th>
			<th></th>
		</tr>
		<c:forEach var="j" items="${jogadores }">
			<tr>
				<td>${j.codigo }</td>
				<td>${j.nome }</td>
				<td>${j.ativo }</td>
				<td>
					<fmt:formatDate value="${j.dataNascimento.time }"
						pattern="dd/MM/yyyy"/>
				</td>
				<td>
					<button onclick="codigoJogador2.value = ${j.codigo}" type="button" class="btn btn-outline-primary btn-sm" data-toggle="modal" data-target="#modalAtivacao">
						${j.ativo?"Desativar Jogador":"Ativar Jogador" }
					</button>
					<a class="btn btn-info btn-sm" href="<c:url value="/jogador/editar/${j.codigo }"/>">Editar</a>
					<!-- Button trigger modal -->
					<button onclick="codigoJogador.value = ${j.codigo}" type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#exampleModal">
					  Excluir
					</button>
				</td>
			</tr>
		</c:forEach>
	</table>
	
<!-- Modal -->
<div class="modal fade" id="modalAtivacao" tabindex="-1" role="dialog" aria-labelledby="modalAtivacaoLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="modalAtivacaoLabel">Ativação</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        Deseja realmente ativar o Jogador?
      </div>
      <div class="modal-footer">
      	<form action="<c:url value="/jogador/ativar"/>" method="post">
      		<input type="hidden" name="codigo" id="codigoJogador2">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
	        <button type="submit" class="btn btn-success">Ativar</button>
        </form>
      </div>
    </div>
  </div>
</div>


<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Confirmação</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        Deseja realmente apagar o jogador?
      </div>
      <div class="modal-footer">
      	<form action="<c:url value="/jogador/excluir"/>" method="post">
      		<input type="hidden" name="codigo" id="codigoJogador">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
	        <button type="submit" class="btn btn-danger">Excluir</button>
        </form>
      </div>
    </div>
  </div>
</div>
	
</tags:template>





