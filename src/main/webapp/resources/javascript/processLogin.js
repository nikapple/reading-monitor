$(document).ready(function(){		
	$('#loginForm').on('submit',function(event){
		event.preventDefault();
		//Remove all errors
	    $('input').next().remove();
		console.log("submitting form");
		$.ajax({
			url:$('#loginForm').attr('action'),
			type : 'POST',
			dataType:'json',
			data: $(this).serialize(),
			success: function(response){
				console.log(response);
				if(response.validated){
					console.log("ajax success");
					window.location.replace(ctx+"/userHome/"+response.userName);
				}
				else{
					console.log("ajax failure");
					 $.each(response.errorMessages,function(key,value){
			  	            $('input[name='+key+']').after('<span class="error">'+value+'</span>');
			              });
				}
			}
		});
	});
});