$(document).ready(function(){
//update user reading activity
	$('#bookList').on('change','input:checkbox',function(){
		console.log("checkbox clicked");
		  var clickedBook = this;
		  if(confirm("Are you really done reading?")){
			  $.ajax({                                      
	    	      url: '/reading-monitor/addActivity?bookId='+$(this).val(),              
	    	      type: "get",
	    	      success: function(result){
	    	    	  console.log(result);
	    	    	  if(result === "true"){
	    	    		  console.log("disabling");
	    	    		  $(clickedBook).attr("disabled", true);
	    	    	  }
	    	      }
			  });
		}
	});
});