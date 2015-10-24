<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>




<div class="contListadoCheque modal hide fade" id="modal-simple"
	style="width: 85%; margin-top: -30px; margin-left: -40%;">
	<div class="innerLR">

	<div class="widget">

				<!-- Widget heading -->
				<div class="widget-head">
					<h4 class="heading">Cheques no disponibles en chequera</h4>
				</div>
				<!-- // Widget heading END -->

				<div class="widget-body">

					<div class="row-fluid">


		
						<!-- Table -->
						<table id="configurationTableCheques"
							class="dynamicTable table table-striped table-bordered table-condensed">
				
							<!-- Table heading -->
							<thead>
								<tr>
									<th class="span1" style="width: 64px;">Numero Cheque</th>
									<th class="width: 180px;" >Beneficiario</th>
									<th style="width: 90px;">Fecha Emision</th>
									<th style="width: 90px;">Fecha Vencimiento</th>
									<th class="span1">Estado</th>
									<th >Motivo</th>
									<th class="span1">Importe</th>
								</tr>
							</thead>
							<!-- // Table heading END -->
				
							<!-- Table body -->
							<tbody>
				
								<c:forEach var="cheque" items="${cheques}" varStatus="loopStatus">
									<tr>
										<td>${cheque.numero}</td>
										<td>${cheque.beneficiario}</td>
										<td>${cheque.fechaIngreso}</td>
										<td>${cheque.fechaVencimiento}</td>
										<td>${cheque.estado}</td>
										<td style="word-break: break-all;">${cheque.motivo}</td>
										<td>${cheque.importeValor}</td>
				
				
									</tr>
				
								</c:forEach>
				
							</tbody>
							<!-- // Table body END -->
				
						</table>
						<!-- // Table END -->
					</div>
				</div>

			</div>
	</div>
</div>

