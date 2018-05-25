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
			<div id="contentArea" class="ui middle aligned divided list">
			<c:choose>
				<c:when test="${not empty roomList}">
					<c:forEach var="list" items="${roomList}">
						<div class="item">
							<div class="content">
								<a id="chat_id${list.roomId }" onclick="showJoinModal(${list.roomId });">${list.title}</a>
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
	<div id="joinModal" class="ui modal">
	 	<i class="window close icon"></i>
		<div class="chat modal header">
		채팅방 참여
		</div>
			<form name="joinFrm" class="ui form" method="post">
			  <div class="image content">
			  	<div>
			  		<div class="ui medium image">
				    	<div class="avatar">
				    		<img src='<c:url value="/images/avatar/avatar1.jpeg"></c:url>'>
				    		<input type="radio" name="avatar" checked="checked" value="1">
				    	</div>
				      	<div class="avatar">
				      		<img src='<c:url value="/images/avatar/avatar2.jpeg"></c:url>'>
				    		<input type="radio" name="avatar" value="2">
				    	</div>
				    	<div class="avatar">
				    		<img src='<c:url value="/images/avatar/avatar3.jpeg"></c:url>'>
				    		<input type="radio" name="avatar" value="3">
				    	</div>
				    	<div class="avatar">
				    		<img src='<c:url value="/images/avatar/avatar4.jpeg"></c:url>'>
				    		<input type="radio" name="avatar" value="4">
				    	</div>
				    	<div class="avatar">
				    		<img src='<c:url value="/images/avatar/avatar5.jpeg"></c:url>'>
				    		<input type="radio" name="avatar" value="5">
				    	</div>
				    	<div class="avatar">
				    		<img src='<c:url value="/images/avatar/avatar6.jpeg"></c:url>'>
				    		<input type="radio" name="avatar" value="6">
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
		  <div class="actions">
		    <button id="joinBtn" class="ui primary button">
		       참여하기
		    </button>
		  </div>
		</form>
	</div>
	<div id="makeModal" class="ui modal">
	 	<i class="window close icon"></i>
		<div class="chat modal header">
		채팅방 만들기
		</div>
			<form name="makeFrm" class="ui form" action="/chat/room" method="post">
			  <div class="image content">
			  	<div>
			  		<div class="ui medium image">
				    	<div class="avatar">
				    		<img src='<c:url value="/images/avatar/avatar1.jpeg"></c:url>'>
				    		<input type="radio" name="avatar" value="1" checked="checked" >
				    	</div>
				      	<div class="avatar">
				      		<img src='<c:url value="/images/avatar/avatar2.jpeg"></c:url>'>
				    		<input type="radio" name="avatar" value="2">
				    	</div>
				    	<div class="avatar">
				    		<img src='<c:url value="/images/avatar/avatar3.jpeg"></c:url>'>
				    		<input type="radio" name="avatar" value="3">
				    	</div>
				    	<div class="avatar">
				    		<img src='<c:url value="/images/avatar/avatar4.jpeg"></c:url>'>
				    		<input type="radio" name="avatar" value="4">
				    	</div>
				    	<div class="avatar">
				    		<img src='<c:url value="/images/avatar/avatar5.jpeg"></c:url>'>
				    		<input type="radio" name="avatar" value="5">
				    	</div>
				    	<div class="avatar">
				    		<img src='<c:url value="/images/avatar/avatar6.jpeg"></c:url>'>
				    		<input type="radio" name="avatar" value="6">
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
		  	<input type="text" name="title" maxlength="30" placeholder="채팅방 제목을 입력하세요.">
		  </div>
		  <div class="actions">
		    <button id="makeBtn" class="ui primary button">
		       만들기
		    </button>
		  </div>
		</form>
	</div>
	<script>
		const joinModal = document.getElementById("joinModal")
		const make = document.getElementById("makeBtn");
		make.addEventListener('click', (e) => {
				document.makeFrm.submit();
		});
		
		const join = document.getElementById("joinBtn");
		join.addEventListener('click', (e) => {
				document.joinFrm.action = "/chat/room/" + joinModal.dataset.id; 
				document.joinFrm.submit();
		});
		
		const makeChat = document.getElementById("makeChatBtn");
		makeChat.addEventListener('click', (e) => {
			$(document.getElementById("makeModal")).modal('show');
		});
		
		function showJoinModal(roomId){
			joinModal.dataset.id = roomId;

			$(joinModal).modal('show');
		}
	</script>
</body>
</html>