<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="heading-buttons">
	<h3></h3>
	<div class="clearfix"></div>
</div>
<div class="innerLR">

	<!-- Widget -->
	<div class="widget contNew">

		<!-- Widget heading -->
		<div class="widget-head">
			<h4 class="heading">Cambio de Clave</h4>
		</div>

		<!-- // Widget heading END -->

		<div class="widget-body span7">

			<!-- Form -->
			<form:form commandName="Usuario" class="contFormNew form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">
		
				<!-- Widget -->
				<div class="widget contNew">
		
					<!-- Widget heading -->
					<div class="widget-head header-popup">
						<h4 class="heading"></h4>
					</div>
					<!-- // Widget heading END -->
		
					<div class="widget-body ">
		
						<!-- Row -->
						<div class="row-fluid">
		
							<!-- Column -->
							<div class="span10">
								<div class="control-group">
									<label class="control-label" for="firstname">Usuario</label>
									<div class="controls"><input class="span12" id="username" name="username" type="text" maxlength="100"></div>
								</div>
								<div class="control-group">
									<label class="control-label" for="firstname">Clave Actual</label>
									<div class="controls"><input class="span12" id="password" name="password" type="password" maxlength="100"></div>
								</div>
								<div class="control-group">
									<label class="control-label" for="firstname">Nueva Clave</label>
									<div class="controls"><input class="span12" id="nuevaPassword" name="nuevaPassword" type="password" maxlength="100"></div>
								</div>
								<div class="control-group">
									<label class="control-label" for="firstname">Repetir Nueva Clave </label>
									<div class="controls"><input class="span12" id="validaPassword" name="validaPassword" type="password" maxlength="100"></div>
								</div>
		
							</div>
							<!-- // Column END -->
		
							<!-- Column -->
		
							<!-- // Column END -->
		
						</div>
						<!-- // Row END -->
		
						<hr class="separator">
		
						<!-- Row -->
		
		
						<!-- // Row END -->
		
						<hr class="separator">
		
						<!-- Form actions -->
						<div class="form-actions">
							<button type="submit" class="btn btn-icon btn-primary glyphicons circle_ok"><i></i>Cambiar Clave</button>
						</div>
						<!-- // Form actions END -->
		
					</div>
				</div>
				<!-- // Widget END -->
		
			</form:form>	

		</div>
	</div>

</div>
