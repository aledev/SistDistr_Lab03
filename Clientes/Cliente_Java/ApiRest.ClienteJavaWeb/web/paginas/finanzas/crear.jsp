<%-- 
    Document   : nuevo
    Created on : 10-05-2016, 11:27:19
    Author     : aialiagam
--%>

<%@page import="dto.FinanzaDTO"%>
<%@page import="dto.UsuarioDTO"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8" import="java.util.*"%>
<%@taglib prefix="mp" tagdir="/WEB-INF/tags" %>

<mp:home-master>
    <jsp:attribute name="pageTitle">
      Lab03 - Crear Finanza
    </jsp:attribute>
    <jsp:attribute name="userName">
      ${sessionScope.currentUser.GetUserName()}
    </jsp:attribute>
    <jsp:attribute name="pageSubtitle">
      Lab03 - Crear Finanza
    </jsp:attribute>
     <jsp:attribute name="breadcrumb">
         <ul class="breadcrumb">
             <li>Home</li> <li>Mantenedores</li> <li>Finanzas</li> <li>Crear</li>
         </ul>
    </jsp:attribute>
    <jsp:body>
        <form id="formNuevaFinanza" action="FinanzaController" method="post">
        <input type="hidden" name="action" value="guardarNuevo">
        
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Datos de la Finanza</h3>
            </div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-xs-12 col-md-8">
                         <div class="form-group">
                             <label class="control-label col-sm-2" for="nombrePersona">Nombre Persona:</label>
                             <div class="col-sm-10">
                                 <input type="text" class="form-control" id="txtNombre" name="nombrePersona" 
                                     required="required" placeholder="Nombre Persona" maxlength="100">
                             </div>  
                         </div>
                    </div>
                    <div class="col-xs-6 col-md-4">
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-md-8">
                         <div class="form-group">
                             <label class="control-label col-sm-2" for="fchMovimiento">Fch. Movimiento:</label>
                             <div class="col-sm-10">
                                 <input type="date" class="form-control" id="txtFchMovimiento" name="fchMovimiento" 
                                 required="required" placeholder="Fecha Movimiento">
                             </div>
                         </div>
                    </div>
                    <div class="col-xs-6 col-md-4">
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-md-8">
                         <div class="form-group">
                             <label class="control-label col-sm-2" for="saldoMovimiento">Saldo Movimiento:</label>
                             <div class="col-sm-10">
                                 <input type="number" class="form-control" id="txtSaldoMovimiento" name="saldoMovimiento" 
                                       required="required" placeholder="Saldo Movimiento">
                             </div>
                         </div>
                    </div>
                    <div class="col-xs-6 col-md-4">
                    </div>
                </div>
                <br/>
                <div class="row">
                    <div class="col-xs-6 col-md-4">
                    </div>
                    <div class="col-xs-6 col-md-4">
                        <input type="submit" value="Guardar" class="btn btn-success"> &nbsp;
                        <input type="button" value="Volver" class="btn btn-default" onclick="javacript:location.href = 'FinanzaController?action=lista'"
                               formnovalidate="formnovalidate">
                    </div>
                    <div class="col-xs-6 col-md-4">
                    </div>
                </div>
            </div>
        </div>
        </form>
    </jsp:body>
</mp:home-master>