var CambiarClave = new Class({
    Extends: Render,
    initialize: function(name){
        this.name = name;
        this.type="cambiarClave";
        this.breadcrumb='CambiarClave';
        this.descripcion="Desde aqui gest";
    },
    getTitleExport:function(){
		
		return "CambiarClave"
	},
    createValidation:function(){
        //this.setDefaultValidationStyle();
    	
        $(".contFormNew").validate({
    		rules: {
    			username:"required",
    			password: "required",
    			nuevaPassword: "required",
    			validaPassword: "required",
    		},
    		messages: {
    			username: "Por favor ingrese su Nombre de Usuario",
    			password: "Por favor ingrese su clave actual",
    			nuevaPassword: "Por favor ingrese una clave nueva",
    			validaPassword: "Por favor repita la nueva clave"
    		}
    	});
    	
    	
    },
	onSaved : function(data) {
		console.log("Cambio clave",data)
		if (data.valido==true){
			this.hideAltaForm();
			this.showCambioMessage();
			window.location = '#';
		}else{
			this.showErrorMessage(data.descripcion);
		}
		
		// console.log("VA",$($(".pagination").find('li')[1]).trigger('click')
		// )

	},
	showCambioMessage : function() {
		$.jGrowl("Nueva clave actualizada.", {
			theme : 'success'
		});
	},
	
    createUpdateValidation:function(){
        //this.setDefaultValidationStyleForUpdate();
    	
        $(".contFormEdit").validate({
    		rules: {
    			username:"required",
    			password: "required",
    			nuevaPassword: "required",
    			validaPassword: "required",
    		},
    		messages: {
    			username: "Por favor ingrese su Nombre de Usuario",
    			password: "Por favor ingrese su clave actual",
    			nuevaPassword: "Por favor ingrese una clave nueva",
    			validaPassword: "Por favor repita la nueva clave"
    		}
    	});
    	
    	
    }



});

cambiarClaveRender=new CambiarClave();