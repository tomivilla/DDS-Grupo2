jQuery(function($) {
    "use strict";
	
	// Options for Message
	//----------------------------------------------
  var options = {
	  'btn-loading': '<i class="fa fa-spinner fa-pulse"></i>',
	  'btn-success': '<i class="fa fa-check"></i>',
	  'btn-error': '<i class="fa fa-remove"></i>',
	  'msg-success': 'Bienvenido! Redireccionando...',
	  'msg-error': 'Fallo al loguear! Por favor, verifique los datos introducidos',
	  'useAJAX': true,
  };

	// Login Form CLIENTES
	//----------------------------------------------
	// Validation
  $("#login-form").validate({
  	rules: {
      lg_username: {
        required: true,
        minlength: 4
      },
      lg_password: {
        required: true,
        minlength: 4
      }
    },
    messages: {
        lg_username:{
            required: "Este campo es obligatorio",
            minlength: "Mínimo de 3 caracteres"
        },
        lg_password:{
            required: "Este campo es obligatorio",
            minlength: "Mínimo 3 caracteres"
        }
    },
  	errorClass: "form-invalid"
  });
  
	// Form Submission
  $("#login-form").submit(function() {
  	remove_loading($(this));
		
		if(options['useAJAX'] == true)
		{
			
  	  login_submit($(this),false);
		
  	  return false;
		}
  });

  // Login Form ADMINISTRADORES
	//----------------------------------------------
	// Validation
    $("#login-form-1").validate({
        rules: {
        lg_username_adm: {
          required: true,
          minlength: 4
        },
        lg_password_adm: {
          required: true,
          minlength: 4
        }
      },
      messages: {
          lg_username_adm:{
              required: "Este campo es obligatorio",
              minlength: "Mínimo de 3 caracteres"
          },
          lg_password_adm:{
              required: "Este campo es obligatorio",
              minlength: "Mínimo 3 caracteres"
          }
      },
        errorClass: "form-invalid"
    });
    
      // Form Submission
    $("#login-form-1").submit(function() {
        remove_loading($(this));
          
          if(options['useAJAX'] == true)
          {
            
            login_submit($(this),true);
          
          return false;
          }
    });

	// Loading
	//----------------------------------------------
  function remove_loading($form)
  {
  	$form.find('[type=submit]').removeClass('error success');
  	$form.find('.login-form-main-message').removeClass('show error success').html('');
  }

  function form_loading($form)
  {
    $form.find('[type=submit]').addClass('clicked').html(options['btn-loading']);
  }
  
  function form_success($form,adm)
  {
	  $form.find('[type=submit]').addClass('success').html(options['btn-success']);
      $form.find('.login-form-main-message').addClass('show success').html(options['msg-success']);
      setTimeout(function() {
        if (adm) {
          window.location.href = "admins.html";
        }else{
          window.location.href = "clientes.html";
        }
      }, 2000);
  }

  function form_failed($form)
  {
  	$form.find('[type=submit]').addClass('error').html(options['btn-error']);
  	$form.find('.login-form-main-message').addClass('show error').html(options['msg-error']);
  }

 function login_submit($form,adm)
  {
  	if($form.valid())
  	{
  		form_loading($form);
  		
          
          var login = call_login(adm);

          if (login) {
              form_success($form,adm);
          }else{
              form_failed($form);
          }
  		
  	}
  }

  function call_login(adm) {
  
  var estado = false;
  
  if (adm) {
    var usuario = {
      username: lg_username_adm.value,
      password: lg_password_adm.value,
      admin : adm
    }
  } else {
    var usuario = {
      username: lg_username.value,
      password: lg_password.value,
      admin : adm
    }
    
  }

  var ruta = window.location.origin+"/sge2/api/login";
  
  $.ajax({ type:"POST",
    async: false,
    url: ruta,
    data: JSON.stringify(usuario),
    dataType:"json",
    contentType: "application/json",
    accept:"json",
    cache: false,
    error: function(jqXHR, textStatus, errorThrown){
      estado = false;
    },
    success: function(data){
      sessionStorage.setItem("data", JSON.stringify(data));
      estado = true;
    }
  });
  
  return estado;
  }

  function dummy_submit_form_adm($form)
  {
  	if($form.valid())
  	{
  		form_loading($form);
  		
  		setTimeout(function() {
            if (lg_username_adm.value != "ERROR") {
                form_success($form);
            }else{
                form_failed($form);
            }
  		}, 2000);
  	}
  }

  
});
