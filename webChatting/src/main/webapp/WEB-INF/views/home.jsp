<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=utf-8" %>
<html>
<head>
<title>웹 채팅 프로그램</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/default.css"></c:url>" >
	<link rel="stylesheet" type="text/css" href='<c:url value="/css/semantic.css"></c:url>' >
	<script src="<c:url value="/js/jquery-3.3.1.min.js"></c:url>"></script>
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
			<div class="ui middle aligned divided list">
				<div class="item">
					<div class="content">
						<a id="chat_id1">하남시 맛집 공유해요</a>
					</div>
				</div>
				<div class="item">
					<div class="content">
						<a id="">스프링 프레임워크 스터디 채팅방입니다.</a>
					</div>
				</div>
				<div class="item">
					<div class="content">
						<a>리액트js 스터디 채팅방입니다.</a>
					</div>
				</div>
				<div class="item">
					<div class="content">
						<a>ES6 스터디 채팅방입니다.</a>
					</div>
				</div>
				<div class="item">
					<div class="content">
						<a>반응형웹 스터디 채팅방입니다.</a>
					</div>
				</div>
				<div class="item">
					<div class="content">
						<a>머신 러닝 스터디 채팅방입니다.</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<footer>
	</footer>
	<form action="ui form">
		<div class="ui modal">
	  	<i class="window close icon"></i>
		  <div id="modal_header" class="chat modal header">
		    채팅방 만들기
		  </div>
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
		  	<input type="text" name="nickName" maxlength="30" placeholder="닉네임을 입력하세요.">
		  </div>
		  <div class="ui fluid input">
		  	<input id="modal_title" type="text" name="title" maxlength="30" placeholder="채팅방 제목을 입력하세요.">
		  </div>
		  <div class="actions">
		    <button id="modal_submit" class="ui primary button">
		      만들기
		    </button>
		  </div>
		</div>
	</form>
	<script>
		const modalHeader = document.getElementById("modal_header");
		const modalTitle = document.getElementById("modal_title");

		const modalSubmit = document.getElementById("modal_submit");
		modalSubmit.addEventListener('click', (event) => {
			const flag = $(modalSubmit).data('id');
			if(flag === 'make') {
				// 채팅방 개설 액션 실행
			} else {
				// 채팅방 참여 액션 실행
			}
		});
		
		const makeChat = document.getElementById("makeChatBtn");
		makeChat.addEventListener('click', (event) => {
			$(modalHeader).text('채팅방 개설');
			$(modalSubmit).text('만들기');
			$(modalSubmit).data('id', 'make');
			$(modalTitle).show();
			$(".ui.modal").modal('show');
		});
		
		const joinChat = document.getElementById("chat_id1");
		joinChat.addEventListener('click', (event) => {
			$(modalHeader).text('채팅방 참여');
			$(modalSubmit).text('참여하기');
			$(modalSubmit).data('id', 'join');
			$(modalTitle).hide();
			$(".ui.modal").modal('show');
		});
	</script>
</body>
</html>