<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
	<h1> For Example</h1>
	</header>
	<main>
			<!-- JSP 태그를 활용해서 1 + 2 + 3 + 4 + ... = 55 -->
		<p> 1에서 10까지 합은? 
		
		<%
			int i, sum = 0;
			int count = 10;
			for(i = 1; i <= count; i++) {
				if(i < count) {
					%>
					<%=(i + " + ")%>
					<%
				} else {
					out.println(i + " = ");
				}
				sum += i;	
			}	
			%>
		<%=sum%>
		 </p>
		
	</main>

</body>
</html>