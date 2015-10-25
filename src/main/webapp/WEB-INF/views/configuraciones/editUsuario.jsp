<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="contEdit modal hide fade" id="modal-simple">
			<div class="innerLR">

	<!-- Form -->
			<form:form commandName="Usuario" class="contFormEdit form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">
			<form:input path ="id" class="span12" id="id" name="id" type="hidden"/>
			<form:input class="span12" id="id" path="validaPassword" value="T" type="hidden"/>
			<form:input class="span12" id="id" path="validaRol" value="T" type="hidden"/>
			<form:input class="span12" id="id" path="estado" value="T" type="hidden"/>
			

		<!-- Widget -->
		<div class="widget">

			<!-- Widget heading -->
			<div class="widget-head">
				<h4 class="heading">Complete los datos</h4>
			</div>
			<!-- // Widget heading END -->

			<div class="widget-body">

				<!-- Row -->
				<div class="row-fluid">

					<!-- Column -->
					<div class="span10">
						<div class="control-group">
							<label class="control-label" for="firstname">Nombre Usuario</label>
							<div class="controls"><form:input class="span10" id="nombre" path="username" type="text" maxlength="100"/></div>
						</div>

						<div class="control-group">
							<label class="control-label" for="firstname">Email</label>
							<div class="controls"><form:input class="span10" id="email" path="email" type="text" maxlength="100"/></div>
						</div>	
						<div class="control-group">
								<label class="control-label">Rol</label>
								<div class="controls">
									<form:select class='contAdministracionCombo selectpicker span10'  path ='idRole' multiple="false">
										<form:options items="${rolesDeUsuario}" itemValue="id" itemLabel="nombre" />
									</form:select>
								</div>
						</div>								
						<div class="control-group">
							<label class="control-label" for="firstname">Password</label>
							<div class="controls"><form:input class="span10" id="password" path="password" type="text" maxlength="100"/></div>
						</div>	
					</div>
				</div>

				<hr class="separator">

				<hr class="separator">

				<!-- Form actions -->
				<div class="form-actions">
					<button type="submit" class="btn btn-icon btn-primary glyphicons circle_ok"><i></i>Guardar</button>
					<button type="button" class="btn btn-icon btn-default glyphicons circle_remove contCancelEdit"><i></i>Cancelar</button>
				</div>
				<!-- // Form actions END -->

			</div>
		</div>
		<!-- // Widget END -->

			</form:form>	
	<!-- // Form END -->

</div>
</div>

