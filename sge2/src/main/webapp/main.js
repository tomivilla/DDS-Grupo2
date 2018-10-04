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
			// Dummy AJAX request (Replace this with your AJAX code)
		  // If you don't want to use AJAX, remove this
  	  dummy_submit_form($(this));
		
		  // Cancel the normal submission.
		  // If you don't want to use AJAX, remove this
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
              // Dummy AJAX request (Replace this with your AJAX code)
            // If you don't want to use AJAX, remove this
          dummy_submit_form_adm($(this));
          
            // Cancel the normal submission.
            // If you don't want to use AJAX, remove this
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
  
  function form_success($form)
  {
	  $form.find('[type=submit]').addClass('success').html(options['btn-success']);
      $form.find('.login-form-main-message').addClass('show success').html(options['msg-success']);
      setTimeout(function() {
        window.location.href = "clientes.html";
      }, 2000);
  }

  function form_failed($form)
  {
  	$form.find('[type=submit]').addClass('error').html(options['btn-error']);
  	$form.find('.login-form-main-message').addClass('show error').html(options['msg-error']);
  }

	// Dummy Submit Form (Remove this)
	//----------------------------------------------
	// This is just a dummy form submission. You should use your AJAX function or remove this function if you are not using AJAX.
  function dummy_submit_form($form)
  {
  	if($form.valid())
  	{
  		form_loading($form);
  		
  		setTimeout(function() {
            if (lg_username.value != "ERROR") {
                form_success($form);
            }else{
                form_failed($form);
            }
  		}, 2000);
  	}
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
