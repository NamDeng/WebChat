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
					<button id="quitBtn" class="ui secondary button">나가기</button>
				</div>
			</header>
			<div>
				<div class="chat join div">
					<div class="ui middle aligned divided list">
				  <div class="item">
				    <img class="ui avatar image" src='<c:url value="/images/avatar/girl.jpeg"></c:url>'>
				    <div class="content">
				      Lena
				    </div>
				  </div>
				  <div class="item">
				    <img class="ui avatar image" src='<c:url value="/images/avatar/girl2.jpeg"></c:url>'>
				    <div class="content">
				      Lindsay
				    </div>
				  </div>
				  <div class="item">
				    <img class="ui avatar image" src='<c:url value="/images/avatar/man.jpeg"></c:url>'>
				    <div class="content">
				      Mark
				    </div>
				  </div>
				  <div class="item">
				    <img class="ui avatar image" src='<c:url value="/images/avatar/man2.jpeg"></c:url>'>
				    <div class="content">
				      Molly
				    </div>
				  </div>
				</div>
				</div>
				<div class="chat read div">
					<div class="ui form">
					  <div class="field">
					    <textarea readonly></textarea>
					  </div>
					</div>
					<div class="chat input div">
						<form class="ui form">
							<div class="chat whisper div">
								<div class="field">
							    <div class="ui fluid multiple search selection dropdown">
							      <input type="hidden" name="receipt">
							      <i class="dropdown icon"></i>
							      <div class="default text">Saved Contacts</div>
							      <div class="menu">
							        <div class="item" data-value="jenny" data-text="Jenny">
							          <img class="ui mini avatar image" src="<c:url value="/images/avatar/girl.jpeg"></c:url>">
							          Jenny Hess
							        </div>
							        <div class="item" data-value="elliot" data-text="Elliot">
							        	<img class="ui mini avatar image" src="<c:url value="/images/avatar/girl2.jpeg"></c:url>">
							          Elliot Fu
							        </div>
							        <div class="item" data-value="stevie" data-text="Stevie">
							        	<img class="ui mini avatar image" src="<c:url value="/images/avatar/man.jpeg"></c:url>">
							          Stevie Feliciano
							        </div>
							        <div class="item" data-value="christian" data-text="Christian">
							        	<img class="ui mini avatar image" src="<c:url value="/images/avatar/man2.jpeg"></c:url>">
							          Christian
							        </div>
							        <div class="item" data-value="matt" data-text="Matt">
							        	<img class="ui mini avatar image" src="<c:url value="/images/avatar/man3.jpeg"></c:url>">
							          Matt
							        </div>
							        <div class="item" data-value="justen" data-text="Justen">
							        	<img class="ui mini avatar image" src="<c:url value="/images/avatar/man4.jpeg"></c:url>">
							          Justen Kitsune
							        </div>
							      </div>
							    </div>
							  </div>
							</div>
							<div class="chat text div">
								<div class="field">
							    <input type="text" name="chat_text" placeholder="상대방에게 전달할 텍스트를 입력하세요.">
							  </div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<footer>
	</footer>
	<script>
		const quit = document.getElementById("quitBtn");
		quit.addEventListener('click', (event) => {

		});
	</script>
</body>
</html>