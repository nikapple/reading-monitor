$(document).ready(function(){
//display activity Form
	$("#activityFormLink").on('click',function(){
		console.log("clicked activity form link");
		$("#bookContainer").hide();
		$("#reportContainer").show();
	});
	
	//submit activity form
	$('#activityForm').on('submit',function(event){
		event.preventDefault();
		//Remove all errors
	    $('input').next().remove();
	    console.log("submitting form");
		$.ajax({
			url:$('#activityForm').attr('action'),
			type : 'GET',
			data: $(this).serialize(),
			success:function(response){
				console.log(response);
			}
		});
	});
});