let socket;

        function initializeWebSocket() {
            let userName = document.getElementById("userName").value;
            let roomId = document.getElementById("roomId").value.toString();
            socket = new WebSocket("ws://localhost:8080/websocketEndpoint/${roomId}/${username}");

            socket.onopen = function(event) {
                console.log("Connected to WebSocket server.");
                let userName = document.getElementById("userName").value;
                let roomId = document.getElementById("roomId").value.toString();
                socket.send("Admin:"+roomId+":"+userName+" joined the chat.");
            };

            socket.onmessage = function(event) {
                let chatWindow = document.getElementById("chat-window");
                data = event.data;
                let user = data.split(":")[0];
                let msg = data.split(":")[1];
                chatWindow.innerHTML += "<p><strong>" + user + "</strong>: " + msg + "</p>";
                chatWindow.scrollTop = chatWindow.scrollHeight; // Auto-scroll to the bottom
            };

            socket.onclose = function(event) {
                let userName = document.getElementById("userName").value;
                let roomId = document.getElementById("roomId").value.toString();
                socket.send("Admin:"+ roomId + ":" + userName + " left the chat.");
            };

            socket.onerror = function(event) {
                console.error("WebSocket error: ", event);
            };
        }

        function sendMessage() {
            let messageInput = document.getElementById("message-input");
            let message = messageInput.value;
            let userName = document.getElementById("userName").value;
            let roomId = document.getElementById("roomId").value.toString();
            if (message.trim() !== "") {
                socket.send(userName + ":" + roomId + ":" + message);

                messageInput.value = "";
            }
        }

        function changeRoom(element){
            String roomName = element.innerText;
            document.getElementById("changeRoomForm").getElementById("roomName").innerText = roomName;
            document.getElementById("changeRoomForm").submit();
        }

        window.onbeforeunload = function() {
            let userName = document.getElementById("userName").value;
            let roomId = document.getElementById("roomId").value.toString();

            if (socket && socket.readyState === WebSocket.OPEN) {
                socket.send("Admin:" + roomId + ":" + userName + " left the chat.");
            }

            // Allow the WebSocket to close naturally
            socket.close();
        };

        window.onload = initializeWebSocket;