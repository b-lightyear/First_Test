<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/include/layout.jsp"%>
	<div class="container-fluid px-4">
		<h3 class="mt-4">공지글 수정</h3>
		
		<!-- method='post' : 노출되지 않게 처리 -->
		<form method='post' enctype="multipart/form-data" action='update.no'>
			<input type='hidden' name='id' value='${dto.id}'>
			<table class='table'>
				<tr>
					<th class='w-px140'>제목</th>
					<td><input type='text' name='title' value='${dto.title}' class='chk' title='제목'></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name='content' class='chk' title='내용'>${dto.content}</textarea></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td><input type='file' name='file' id='attach-file'>
					<span id='filename'>${dto.filename}</span>
					<a id='delete-file'>
					<!-- 첨부파일 유무에 따라서 아이콘 표시  style='display:${dto.filename == null ? "none" : "inline"}-->
					<i class="font-r fa-solid fa-trash-can"></i></a>
					</td>
				</tr>
			</table>
			<input type='hidden' name='filename'>
		</form>
		<div class='btnSet'>
			<a class='btn-empty' href='javascript:history.go(-1)'>취소</a>
			<!-- <a class='btn-fill' onclick='if( emptyCheck() ) $("form").submit()'>작성</a> -->
			<a class='btn-fill' onclick='save()'>작성</a>
			<!-- 	<a class='btn-empty' href='list.no'>취소</a> -->
		</div>
	</div>
	
	<!-- 스크립트를 통해서 첨부파일 아이콘 표시 -->
	<script>
		function save() {
			if( emptyCheck() ) {
				var name = $('#filename').text();
				$('[name=filename]').val(name);
				$("form").submit();
			}
		}
	
		if( ${dto.filename!=null} )
			$('#delete-file').css('display', 'inline');
		</script>

	<%@ include file="/include/footer.jsp"%>
</body>
</html>