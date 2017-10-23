<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Reading List</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
      $(document).ready(function(){
    	  $('[name="read"]').click(function(){
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
    	  	$('[name="borrow"]').click(function(){
    		  var clickedBook = this;
    		  if(confirm("Borrowing This?")){
    			  $.ajax({                                      
    	    	      url: '/reading-monitor/borrowBook?bookId='+$(this).val(),              
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
      </script>
</head>
<body>
	<h1>My Daily Reading List</h1>
	<a href="logout">Logout</a>
	<table>
		<tr>
			<th>Topic Name</th>
		</tr>
		<c:forEach items="${topicList}" var="topic">
			<tr>
				<th><c:out value="${topic.name}" /></th>
				<td>
					<table>
						<tr>
							<th>Book ID</th>
							<th>Name</th>
							<th>Author</th>
							<th>Done Reading?</th>
							<th>Borrow</th>
						</tr>
						<c:forEach items="${topic.bookList}" var="book">
							<tr>
								<td><c:out value="${book.id}" /></td>
								<td><c:out value="${book.name}" /></td>
								<td><c:out value="${book.author}" /></td>
								<td><input type="checkbox" name="read" id="${book.id}"
									value="${book.id}"><br></td>
								<td><input type="checkbox" name="borrow" id="${book.id}"
									value="${book.id}"><br></td>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>