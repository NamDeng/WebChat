<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=utf-8" %>
<html>
<head>
<title>웹 채팅 프로그램</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/default.css"></c:url>" >
	<link rel="stylesheet" type="text/css" href='<c:url value="/css/semantic.css"></c:url>' >
	<script src="<c:url value="/js/jquery-3.3.1.min.js"></c:url>"></script>
	<script src="<c:url value="/js/sockjs.min.js"></c:url>"></script>
	<script src="<c:url value="/js/semantic.js"></c:url>"></script>
</head>
<body>
	<div class="ui container">
		<div id="wrap">
			<header>
				<div id="header-div">
					<h1 class="title">웹 채팅 프로그램</h1>
					<button id="makeChatBtn" class="ui secondary button">채팅방 개설</button>
				</div>
			</header>
			<div id="contentArea" class="ui middle aligned divided list">
			<c:choose>
				<c:when test="${not empty roomList}">
					<c:forEach var="list" items="${roomList}">
						<div class="item">
							<div class="content">
								<a id="chat_id${list.roomId }" onclick="showModal(this);">${list.title}</a>
							</div>
						</div>		
					</c:forEach>
				</c:when>
				<c:otherwise>
					<div class="item">
						<div class="content">
							<a>개설된 채팅방이 없습니다.</a>
						</div>
					</div>	
				</c:otherwise>
			</c:choose>
			</div>
		</div>
	</div>
	<footer>
	</footer>
	<div class="ui modal">
	 	<i class="window close icon"></i>
		<div id="modal_header" class="chat modal header">
		채팅방 만들기
		</div>
			<form name="makeFrm" class="ui form" action="/chat/room" method="post">
			  <div class="image content">
			  	<div>
			  		<div class="ui medium image">
				    	<div class="avatar">
				    		<img src='<c:url value="/images/avatar/girl.jpeg"></c:url>'>
				    		<input type="radio" name="avatar">
				    	</div>
				      	<div class="avatar">
				      		<img src='<c:url value="/images/avatar/girl2.jpeg"></c:url>'>
				    		<input type="radio" name="avatar">
				    	</div>
				    	<div class="avatar">
				    		<img src='<c:url value="/images/avatar/man.jpeg"></c:url>'>
				    		<input type="radio" name="avatar">
				    	</div>
				    	<div class="avatar">
				    		<img src='<c:url value="/images/avatar/man2.jpeg"></c:url>'>
				    		<input type="radio" name="avatar">
				    	</div>
				    	<div class="avatar">
				    		<img src='<c:url value="/images/avatar/man3.jpeg"></c:url>'>
				    		<input type="radio" name="avatar">
				    	</div>
				    	<div class="avatar">
				    		<img src='<c:url value="/images/avatar/man4.jpeg"></c:url>'>
				    		<input type="radio" name="avatar">
				    	</div>
			   	 </div>
			   	 <div class="ui radio checkbox">
					 	<input type="radio" name="avatar">
				   </div>
			  	</div>
			  </div>
		  <div class="ui fluid input">
		  	<input id="nickName" type="text" name="nickName" maxlength="30" placeholder="닉네임을 입력하세요.">
		  </div>
		  <div class="ui fluid input">
		  	<input id="title" type="text" name="title" maxlength="30" placeholder="채팅방 제목을 입력하세요.">
		  </div>
		  <div class="actions">
		    <button id="modal_submit" class="ui primary button">
		       만들기
		    </button>
		  </div>
		</form>
	</div>
	<script>
		const modalHeader = document.getElementById("modal_header");
		const title = document.getElementById("title");

		const modalSubmit = document.getElementById("modal_submit");
		modalSubmit.addEventListener('click', (e) => {
			const flag = $(modalSubmit).data('id');
			/* if(validateForm(flag) === false) {
				return false;
			} */
			
			if(flag === 'make') {
				// 채팅방 개설 액션 실행
				document.makeFrm.submit();
			} else {
				// 채팅방 참여 액션 실행
			}
		});
		
		const makeChat = document.getElementById("makeChatBtn");
		makeChat.addEventListener('click', (e) => {
			$(modalHeader).text('채팅방 개설');
			$(modalSubmit).text('만들기');
			$(modalSubmit).data('id', 'make');
			$(title).show();
			$(".ui.modal").modal('show');
		});
		
		function showModal(p){
			console.log(p);
			$(modalHeader).text('채팅방 참여');
			$(modalSubmit).text('참여하기');
			$(modalSubmit).data('id', 'join');
			$(title).hide();
			$(".ui.modal").modal('show');
		}
		
		function validateForm(flag) {
			const avatar = $('radio[name="avatar"]:checked').length; 
			const title = document.getElementById("title");
			const nickName = document.getElementById("nickName");
			
			if(avatar < 1) {
				alert("아바타를 선택해 주세요.");
				return false;
			} 
			
			if(title == '' || title == null) {
				alert("닉네임을 입력해주세요.");
				return false;
			} 
			
			if(flag === 'make') {
				if(title == '' || title == null) {
					alert("채팅방 제목을 입력해주세요.");
					return false;
				}
			}
		}
	</script>
</body>
</html>