<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<style>
	
	.modal {z-index: 2}
	.modal-backdrop {z-index: 1 !important}
</style>
<div class="contFormCuenta modal hide fade" id="modal-simple" style="width:45%" >
			<div class="innerLR">

<form:form commandName="EstructuraContenido" class="contFormNew form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">

	
<table class="table table-bordered table-striped" id="tableCuenta" style="width: 100%;">
																	<thead style="display: block; "> 
																		<tr>
																			<th width="18px"></th>
																			<th style="display:none"></th>
																			<th class="center" style="display:none">Id</th>
																			<th class="center span5" >Cuenta</th>
																			<th class="center span4" >Entidad</th>
																			<th class="center span3">Moneda</th>
																		</tr>
																	</thead>
																	<tbody id="contCuentasBody" style=" overflow: auto; display: block; height: 250px;">
																	<!--		<tr>
																				<th width="18px"></th>
																				<th style="display:none"></th>
																				<th class="center" style="display:none">Id</th>
																				<th class="center span5" >Cuenta</th>
																				<th class="center span4" >Entidad</th>
																				<th class="center span3">Moneda</th>
																			</tr>
																	-->
														<c:forEach var="cuenta" items="${EstructuraContenido.contenidoCuentas}" varStatus="loopStatus">   
														 				<tr>
																			<td width="18px"><a href="#" class="contDelete"><img style="max-width:20px;height:20;display:inline;float:right;margin-top:0.1cm;" src="resources/images/delete.jpeg"></a></td>
               																 <td class="contId" style="display:none">${cuenta.id}</td>
               																 <td class="center span5">${cuenta.cuentaNombre}</td>
               																 <td class="center span4">${cuenta.entidadNombre}</td>
               																 <td class="center span3">${cuenta.moneda.nombre}</td>
               														 </tr>
               								
        															</c:forEach>
        																					 <tr>
																			<td ><a href="#" class="contDelete"><img style="max-width:20px;height:20;display:inline;float:right;margin-top:0.1cm;" src="resources/images/delete.jpeg"></a></td>

               																 <td class="contId" style="display:none"></td>
               																 <td><form:select class='contCuentaCombo  ' placeholder="Seleccione un valor"  path ='id'>
																						<option></option> 
																					<form:options items="${cuentas}" itemValue="id" itemLabel="nombre" />
																			</form:select></td>
               																 <td><select class='contEntidadCombo' id="entidadCombo" name="entidadCombo" class="" placeholder="Seleccione un valor" style="
    width: 150px;"
">
																		</select></td>
               																 <td><select  class='contMonedaCombo' id="monedaCombo" name="monedaCombo" class="" placeholder="Seleccione un valor" style="
    width: 150px;"
">
																		</select></td>
               														 </tr>
																	</tbody>
																	
																</table>

      			</form:form>	
      			<hr class="separator">

				<!-- Form actions -->
				<div class="form-actions">
					<button type="submit" class="btn btn-icon btn-primary glyphicons circle_ok contGuardar"><i></i>Guardar</button>
					<button type="button" class="btn btn-icon btn-default glyphicons circle_remove"><i></i>Cancelar</button>
				</div>
      
</div>
</div>

