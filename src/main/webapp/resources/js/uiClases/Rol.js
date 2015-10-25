var Rol = new Class({
    Extends: Render,
    initialize: function(name){
        this.name = name;
        this.type="rol";
        this.breadcrumb='Administracion';
        this.descripcion="Desde aqui gestiones las Administracion";
    },
    getTitleExport:function(){
		
		return "Rol"
	},
    orderFromList:function() {
		var selectList = $('#from option');
		
		selectList.sort(function(a,b){
		    a = a.value;
		    b = b.value;
		
		    return a-b;
		});
		
		$('#from').html(selectList);
    },
    orderToList:function() {
		var selectList = $('#to option');
		
		selectList.sort(function(a,b){
		    a = a.value;
		    b = b.value;
		
		    return a-b;
		});
		
		$('#to').html(selectList);
    },
    bindAddEvents:function() {

    	var self=this;
    	this.parent();
    	$("#allToRight").click(function() {
			self.moveAll('from', 'to');
			self.orderToList();
		});
    	$("#allToLeft").click(function() {
    		self.moveAll('to', 'from')
    		self.orderFromList();
		});
    	$("#selectedToLeft").click(function() {
    		self.moveSelected('to', 'from')
    		self.orderFromList();
		});
    	$("#selectedToRight").click(function() {
    		self.moveSelected('from', 'to')
			self.orderToList();
		});
    	$(".circle_ok").click(function() {
    		$('#to option').prop('selected', true);
		});
    
    },

    bindUpdateEvents:function() {

    	var self=this;
    	this.parent();
    	
    	$("#allToRightEdit").click(function() {
			self.moveAll('editFrom', 'editTo');
			self.orderEditToList();
		});
    	$("#allToLeftEdit").click(function() {
    		self.moveAll('editTo', 'editFrom')
    		self.orderEditFromList();
		});
    	$("#selectedToLeftEdit").click(function() {
    		self.moveSelected('editTo', 'editFrom')
    		self.orderEditFromList();
		});
    	$("#selectedToRightEdit").click(function() {
    		self.moveSelected('editFrom', 'editTo')
    		self.orderEditToList();
		});
    	
    	$(".circle_ok").click(function() {
    		$('#editTo option').prop('selected', true);
		});
    
    	
    },    
    orderEditFromList:function() {
		var selectList = $('#editFrom option');
		
		selectList.sort(function(a,b){
		    a = a.value;
		    b = b.value;
		
		    return a-b;
		});
		
		$('#editFrom').html(selectList);
    },
    orderEditToList:function() {
		var selectList = $('#editTo option');
		
		selectList.sort(function(a,b){
		    a = a.value;
		    b = b.value;
		
		    return a-b;
		});
		
		$('#editTo').html(selectList);
    },
    moveAll:function(from,to) {
    	$('#'+from+' option').remove().appendTo('#'+to); 
    },
    moveSelected:function(from,to) {
    	 $('#'+from+' option:selected').remove().appendTo('#'+to); 
    },
    
    cleanCombos:function(formToFind) {
    	
    },
  
    
    
    createValidation:function(){
        $(".contFormNew").validate({
    		rules: {
    			nombre: "required"
    		},
    		messages: {
    			nombre: "Por favor ingresa un nombre de Rol"
    		}
    	});
    	
    	
    },
    createUpdateValidation:function(){
        //this.setDefaultValidationStyleForUpdate();
    	
    	
    	
        $(".contFormEdit").validate({
    		rules: {
    			nombre: "required"
    		},
    		messages: {
    			nombre: "Por favor ingresa un nombre de Rol"
    		}
    	});
    	
    	
    }


});

rolRender=new Rol();