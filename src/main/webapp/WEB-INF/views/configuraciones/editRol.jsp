<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<STYLE TYPE="text/css">
.flecha{
	
}

.flecha a{
	margin: 4px 12px;
}

.glyphicons i:before {
  font: 19px/1em 'Glyphicons' !important;
  color: #B12C2C !important;
}

</STYLE>

<div class="contEdit modal hide fade" id="modal-simple">
			<div class="innerLR">


	<!-- Form -->
	<form:form commandName="Rol" class="contFormEdit form-horizontal" style="margin-bottom: 0;" id="editValidateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">
		<form:input path ="id" class="span12" id="id" name="id" type="hidden"/>
		<!-- Widget -->
		<div class="widget">

			<!-- Widget heading -->
			<div class="widget-head header-popup">
				<h4 class="heading">Complete los datos</h4>
			</div>
			<!-- // Widget heading END -->

			<div class="widget-body">


				<div class="row-fluid">

					<div class="span12">

						<div class="control-group">
							<label class="control-label" for="firstname">Nombre Rol</label>
							<div class="controls">
								<form:input path ="nombre" class="span10" name="nombre" type="text" maxlength="100"/>
							</div>
						</div>

						<div class="control-group">
							<label class="control-label" for="firstname" >Descripcion</label>
							<div class="controls">
								<form:textarea maxlength="100" name="descripcion" path="descripcion" rows="4" cols="100" class="span12" style="margin: 0px; width: 322px; height: 121px;resize:none"></form:textarea></div>
						</div>

						<div class="control-group">	
												
							<div class="span5">			
									<form:select class='contOpcionesNoSelectCombo selectpicker span10'  path ='opcionesTodas' multiple="true" id="editFrom" size="10">
										<form:options items="${opcionesSistemaTodas}" itemValue="id" itemLabel="nombre" />
									</form:select>							
							</div>
							<div class="span1 flecha" href="#" style="text-align:center">			
						        <a id="allToRightEdit" href="#" class="glyphicons no-js circle_arrow_right"><i></i></a><br/> 
						        <a id="selectedToRightEdit" href="#" class="glyphicons no-js right_arrow"><i></i></a><br/> 
						        <a id="selectedToLeftEdit" href="#" class="glyphicons no-js left_arrow"><i></i></a> 
						        <a id="allToLeftEdit" href="#" class="glyphicons no-js circle_arrow_left"><i></i></a><br/> 
						        
							</div>
						 	<div class="span5">
									<form:select class='contOpcionesSelectCombo selectpicker span10'  path ='opcionesSeleccionadas' multiple="true" id="editTo" size="10">
										<form:options items="${Rol.opcionesSeleccionadasTodo}" itemValue="id" itemLabel="nombre" />
									</form:select>							
							</div>								
																
						</div>	
						<div class="control-group">
							<label class="control-label">Estado</label>
							<div class="controls">
													<form:select path ='estado' name="estado" class="selectpicker span6">
													    <form:option value="F" label="Inactivo"/>
														<form:option value="T" label="Activo"/>
													</form:select>
												</div>
							</div>
							
						</div>
						<hr class="separator">


						<!-- Form actions -->
						<div class="form-actions">
							<button type="submit" class="btn btn-icon btn-primary glyphicons circle_ok"><i></i>Guardar</button>
							<button type="button" class="btn btn-icon btn-default glyphicons circle_remove contCancelEdit"><i></i>Cancelar</button>
						</div>								
						
					</div>

			</div>
		</div>
		<!-- // Widget END -->
		</div>
			</form:form>	

</div>
</div>

