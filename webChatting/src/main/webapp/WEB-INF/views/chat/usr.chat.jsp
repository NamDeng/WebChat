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
					<h1 class="title">${room.title }</h1>
					<button id="quitBtn" class="ui secondary button">나가기</button>
				</div>
			</header>
			<div>
				<div class="chat join div">
					<div class="ui middle aligned divided list">
					<c:choose>
						<c:when test="${not empty userList }">
							<c:forEach var="user" items="${userList }">
								<div class="item">
							    <img class="ui avatar image" src='<c:url value="/images/avatar/avatar${user.avatarType }.jpeg"></c:url>'>
							    <div class="content">
							    	${user.nickName }
							    </div>
							  </div>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<div class="item">
							    <div class="content">
							      	참여자가 없습니다.
							    </div>
							  </div>
						</c:otherwise>
					</c:choose>
				</div>
				</div>
				<div class="chat read div">
					<div class="ui form">
					  <div class="field">
					    <textarea id="chatView" rows="30" readonly></textarea>
					  </div>
					</div>
					<div class="chat input div">
						<div class="ui form">
							<div class="chat whisper div">
								<div class="field">
							    <div class="ui fluid multiple search selection dropdown">
							      <input type="hidden" name="receipt">
							      <i class="dropdown icon"></i>
							      <div class="default text">Saved Contacts</div>
							      <div class="menu">
							        <div class="item">
							          <img class="ui mini avatar image" src="<c:url value="/images/avatar/avatar1.jpeg"></c:url>">
							          Jenny Hess
							        </div>
							        <div class="item">
							        	<img class="ui mini avatar image" src="<c:url value="/images/avatar/avatar2.jpeg"></c:url>">
							          Elliot Fu
							        </div>
							        <div class="item">
							        	<img class="ui mini avatar image" src="<c:url value="/images/avatar/avatar3.jpeg"></c:url>">
							          Stevie Feliciano
							        </div>
							        <div class="item">
							        	<img class="ui mini avatar image" src="<c:url value="/images/avatar/avatar4.jpeg"></c:url>">
							          Christian
							        </div>
							        <div class="item">
							        	<img class="ui mini avatar image" src="<c:url value="/images/avatar/avatar5.jpeg"></c:url>">
							          Matt
							        </div>
							        <div class="item">
							        	<img class="ui mini avatar image" src="<c:url value="/images/avatar/avatar6.jpeg"></c:url>">
							          Justen Kitsune
							        </div>
							      </div>
							    </div>
							  </div>
							</div>
							<div class="chat text div">
								<div class="field">
							    <input type="text" id="message" name="message" placeholder="상대방에게 전달할 텍스트를 입력하세요." onkeydown="pressEnterKey();">
							  </div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<footer>
	</footer>
	<script>
		const chatView = document.getElementById("chatView");
		const message = document.getElementById("message");
		const socket = new SockJS("<c:url value="/chat/websocket"/>");
		socket.onopen = function() {
			chatView.value = '${currentUser.nickName}님 환영합니다.\n';
			
			socket.send(JSON.stringify({roomId:${room.roomId}, type:'join', historyId:${currentUser.historyId}}));
			socket.onmessage = function(e) {
				chatView.value = chatView.value + '\n' + e.data;
			};
		}
		socket.onclose = function() {
			chatView.value = '\n연결이 끊겼습니다.';
			quitChatRoom(${room.roomId}, ${currentUser.historyId}});
		};

		function pressEnterKey(){
			if(event.keyCode == 13) {
				if(message.value != null && message.value != '') {
					sendMessage();
				}
			}
		}
		
		function sendMessage(){
			socket.send(JSON.stringify({roomId:${room.roomId}, type:'send', message:'[${currentUser.nickName}] : ' + message.value}));
			message.value = '';
		}
		
		function quitChatRoom() {
			
		}
	</script>
</body>
</html>