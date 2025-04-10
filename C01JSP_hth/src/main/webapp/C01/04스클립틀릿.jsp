<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	java.util.Scanner sc = new java.util.Scanner(System.in);
	System.out.print("행 열 입력 : ");
	int row = sc.nextInt();
	int col = sc.nextInt();
	System.out.printf("행 : %d 열 : %d\n",row,col);

%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>

	<table class=table>
		<tbody>
				<%
				//tr태그 생성 반복
				for(int i=0;i<row;i++)
				{
				%>
					<tr>
							<%
							for(int j=0;j<col;j++)
							{
							%>
								<td><%=i+":"+j %></td>	
							<%
							}
							%>	
					</tr>
				<%
				}
				%>	
		</tbody>
	</table>

</body>
</html>