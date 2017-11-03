$(document).ready(function(){
	console.log("exec JS");
			$('#regForm').on('submit',function(event){
				event.preventDefault();
				//Remove all errors
			    $('input').next().remove();
				console.log("submitting form");
				$.ajax(
						{
							url:$('#regForm').attr('action'),
							type : 'POST',
							dataType:'json',
							data: $(this).serialize(),
							success: function(response){
								if(response.validated){
									console.log("ajax success");
									 $('#resultContainer pre code').text("Successful Registration, User ID is : "+JSON.stringify(response.userId));
						               $('#resultContainer').show();
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