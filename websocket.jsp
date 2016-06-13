<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.1/sockjs.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	
	<input type="text" id="message" />
	<input type="button" value="전송" onclick="messageSend();" />
	<input type="button" value="종료" onclick="disconnect();" />
	<div id="console"></div>
	<div>
		<canvas id="myCanvas" width="500" height="500"
			style="border: 1px solid #d3d3d3;">
	</canvas>
	</div>
	<script>
		window.onload = function(e) {
			
			var _canvas = document.querySelector("#myCanvas")
			var _fifi = document.querySelector("#fifi");
			var _context = _canvas.getContext("2d");
			
			var tool = new tool_pencil();
			
			_canvas.addEventListener('mousedown', ev_canvas, false);
			_canvas.addEventListener('mousemove', ev_canvas, false);
			_canvas.addEventListener('mouseup', ev_canvas, false);
			
			function tool_pencil(){
				var tool = this;
				this.started = false;
				
				this.mousedown = function(ev){
					_context.beginPath();
					_context.moveTo(ev._x, ev._y);
					tool.started = true;
				}
				this.mousemove = function (ev)
		        {
		            if (tool.started)
		            {
		                _context.lineTo(ev._x, ev._y);
		          		_fifi.value = ev._x+", "+ev._y;
		          		var location = {key:'location', x: ev._x, y:ev._y};
		          		stompclient.send("/stomp",{},JSON.stringify(location));
		                _context.stroke();
		            }
		        };
		        this.mouseup = function (ev)
		        {
		          if (tool.started)
		          {
		                tool.mousemove(ev);
		                tool.started = false;
		          }
		        };
			}
			// Canvas요소 내의 좌표를 결정 한다.
		    function ev_canvas (ev)
		    {
		        if (ev.layerX || ev.layerX == 0)
		        { // Firefox 브라우저
		          ev._x = ev.layerX;
		          ev._y = ev.layerY;
		        }
		        else if (ev.offsetX || ev.offsetX == 0)
		        { // Opera 브라우저
		          ev._x = ev.offsetX;
		          ev._y = ev.offsetY;
		        }
		 
		        // tool의 이벤트 핸들러를 호출한다.
		        var func = tool[ev.type];
		       
		        if (func)
		        {
		            func(ev);
		        }
		    }
			var socket
			if(navigator.platform !='Win32'){
			socket= new WebSocket('ws://192.168.0.3:8080/myapp/stomp');
			}else{ socket = new WebSocket('ws://localhost:8080/myapp/stomp');}
			var stompclient = Stomp.over(socket);
			stompclient.connect({}, function(frame) {
				$('#console').append('connected: ' + frame + '<br>');
				stompclient.subscribe('/topic/stomp', function(message) {
					var msg = JSON.parse(message.body);
					if(msg.key=='location'){
						document.querySelector('#console').innerHTML = msg.x+", "+msg.y;
						_context.lineTo(msg.x, msg.y);
						_context.stroke();
					}else{
					$('#console').append(message.body + '<br>');
					}
				});
			});

			function disconnect() {
				if (stompclient != null) {
					stompclient.disconnect();
				}
				$('console').append('Disconnected <br>');

			}
			function messageSend() {
				stompclient.send("/stomp", {}, $('#message').val());
			}
		}
	</script>
	<!-- 
	<script>
		var socket = new WebSocket('ws://localhost:8080/myapp/stomp');
		var stompclient = Stomp.over(socket);
		stompclient.connect({}, function(frame) {
			$('#console').append('connected: ' + frame + '<br>');
			stompclient.subscribe('/topic/stomp', function(message) {
				var msg = JSON.parse(message.body);
				if(msg.key=='location'){
					document.querySelector('#console').innerHTML = msg.x+", "+msg.y;
					_context.lineTo(msg.x, msg.y);
					_context.stroke();
				}else{
				$('#console').append(message.body + '<br>');
				}
			});
		});

		function disconnect() {
			if (stompclient != null) {
				stompclient.disconnect();
			}
			$('console').append('Disconnected <br>');

		}
		function messageSend() {
			stompclient.send("/stomp", {}, $('#message').val());
		}
	</script>-->
	<div>
		<textarea rows="1" cols="7" id="fifi"></textarea>
	</div>
</body>
</html>