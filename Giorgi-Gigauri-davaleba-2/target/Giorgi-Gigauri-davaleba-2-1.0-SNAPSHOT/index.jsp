<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ChatBot</title>
</head>
<body>

<textarea id="messageTextArea" rows="10" cols="50"></textarea>
<br>

<form>
    <input id="textMessage" type="text">
    <input onclick="sendMessage();" value="Send Message" type="button">
</form>

<script>
    const webSocket = new WebSocket("ws://localhost:8081/Giorgi_Gigauri_davaleba_2_war_exploded/weatherBot");
    const messageTextArea = document.getElementById("messageTextArea");
    webSocket.onopen = function () {
        processOpen();
    };
    webSocket.onmessage = function (message) {
        processMessage(message);
    };
    webSocket.onclose = function () {
        processClose();
    };
    webSocket.onerror = function () {
        processError();
    };
    function processOpen() {
        messageTextArea.value += ">> წარმატებით დაუკავშირდა."+"\n";
    }

    function processMessage(message) {
        messageTextArea.value += "სერვერი >>  " + message.data +"\n";
        messageTextArea.scrollTop = messageTextArea.scrollHeight;
    }

    function sendMessage() {
        webSocket.send(textMessage.value);
        messageTextArea.value += "შენ >>  " + textMessage.value+"\n";
        messageTextArea.scrollTop = messageTextArea.scrollHeight;
    }

    function processClose() {
        messageTextArea.value += ">> სერვერთან კავშირი დასრულდა...";
    }

    function processError() {
        messageTextArea.value += ">> სერვერის შეცდომა";
    }
</script>
</body>
</html>