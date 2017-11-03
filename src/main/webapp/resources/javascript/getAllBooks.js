$(document).ready(function(){
	//get all books
	$("#bookListLink").on('click',function(){
		console.log("clicked booklist link");
		$("#reportContainer").hide();
		$("#bookContainer").show();
		$.ajax({
			url:ctx+'/allBooks',
			success: function(response){
				var topicList = $.map(response, function(item,key){
					var topicItem = $('<li></li>');
					topicItem.append('<p>'+item.name+'</p>');
					var bookList = $.map(item.bookList, function(book,index){
						console.log(book.name);
						var bookItem = $('<li class="book" id="book-'+book.id+'"></li>');
						bookItem.append('<p> id : '+book.id+'</p>');
						bookItem.append('<p> name : '+book.name+'</p>');
						bookItem.append('<p> author : '+book.author+'</p>');
						bookItem.append('<p> Done Reading : ?</p><input type="checkbox" name="read" id="checkbox-'+book.id+'" value='+book.id+'>');
						return bookItem;
					});
					var list = $('<ul></ul>');
					topicItem.append(list.html(bookList));
					return topicItem;
				});
				$('#bookList').html(topicList);
			}	
		});
	});
});