<!DOCTYPE html>

<html>
<head>

<meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
<title>Registrierung</title>
<link rel="stylesheet" type="text/css" href="style.css">

<script src="jquery-1.9.1.js" type="text/javascript"></script>
<script src="jquery-ui-1.10.3.js" type="text/javascript"></script>


<script type="text/javascript">
	document.addEventListener('DOMContentLoaded', init, false);
	function init() {
		var sec_pwfield_IsVisible = false;
		
		var pw_typingTimer;
		var pw_doneTypingInterval = 1000;

		$('#register_password_field').keyup(
				function() {
					checkPWEqual();
					
					clearTimeout(pw_typingTimer);
					pw_typingTimer = setTimeout(pw_doneTyping, pw_doneTypingInterval);
				});
		
		$('#register_password_field').keydown(
                function() {
                	if (sec_pwfield_IsVisible) return;
                	
                	$('#register_password_field_check').slideDown(600);
                	
                	var heightbefore = $('#contentbox_register').css("height");
                	heightbefore = heightbefore.substring(0, 3);
                	heightbefore = ( parseInt(heightbefore) + 25) + 'px';
                	$('#contentbox_register').animate({height:heightbefore}, 600);
                	
                	sec_pwfield_IsVisible = true;
                });
		
		$('#register_password_field_check').keyup(
                function() {
                	checkPWEqual();
                });
		
		$('#register_password_field_check').hide();

		function pw_doneTyping() {
			checkpw($('#register_password_field').val());
		}
	};
	
	function checkPWEqual() {
		var pw1 = $('#register_password_field').val();
		var pw2 = $('#register_password_field_check').val();
		
		if (pw1 == pw2) {
			$('#register_password_field').animate({"border-color":"green"}, 150);
			$('#register_password_field_check').animate({"border-color":"green"}, 150);
		} else {
			$('#register_password_field').animate({"border-color":"red"}, 150);
            $('#register_password_field_check').animate({"border-color":"red"}, 150);
		}
	}

	function checkpw(inhalt) {
		var url = "testpw.jsp?pw=" + inhalt;

		if (inhalt == "") {
			changePWMeter(0);
			return;
		} else {
			var xmlhttp;

			xmlhttp = new XMLHttpRequest();
			xmlhttp.open("GET", url, true);
			xmlhttp.send();
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					// ALL OK
					var perc = parseInt($.trim(xmlhttp.responseText));
					changePWMeter(perc);
				} else {
					// SOME THING WONG
					$("#only 4 testing").html(url);
				}
			}
		}
	}
	
	function changePWMeter(perc) {
		var newwidth = perc + "%";
        $('#pw_meter_innerspan').animate({width:newwidth}, 400);
        
        $('.pw_meter').removeClass('pw_meter_orange');
        $('.pw_meter').removeClass('pw_meter_red');
        
        if (perc < 33) {
            $('.pw_meter').addClass('pw_meter_red');
        } else if (perc < 66) {
            $('.pw_meter').addClass('pw_meter_orange');
        } else {
            // Add No Class ==> Green
        }
	}
</script>
</head>
<body class="standard_body">
	<div class="contentbox" id="contentbox_register">
		<h1 class="contentbox_title">studyTrade</h1>
		<form action="./register.jsp" method="GET">
			<input name="forname" placeholder="Vorname" type="text" class="inputbox_textfield">
			<br>
			<input name="surname" placeholder="Nachname" type="text" class="inputbox_textfield">
			<br>
			<input name="nickname" placeholder="Nickname" type="text" class="inputbox_textfield">
			<br>
			<input name="address" placeholder="Wohnort" type="text" class="inputbox_textfield">
			<br>
			<select name="university" class="inputbox_selectionfield">
				<option value="hochschule" disabled selected>Hochschule</option>
				<option value="hochschule 1">Hochschule 1</option>
				<option value="hochschule 2">Hochschule 2</option>
				<option value="hochschule 3">Hochschule 3</option>
				<option value="hochschule 4">Hochschule 4</option>
				<option value="hochschule 5">Hochschule 5</option>
			</select>
			<br>
			<input name="branch" placeholder="Studienrichtung" type="text" class="inputbox_textfield">
			<br>
			<input name="email" placeholder="E-Mail" type="text" class="inputbox_textfield">
			<br>
			<input name="password" type="password" placeholder="Passwort" class="inputbox_textfield" id="register_password_field"/>
			<br>
			<input name="password_check" type="password" placeholder="Passwort" class="inputbox_textfield" id="register_password_field_check"/>
			<div class="pw_meter pw_meter_orange">
                <span style="width: 0%" id="pw_meter_innerspan"></span>
            </div>
			<br>
			<input value="Registrierung" name="register" type="submit" class="standard_content_button">
			<br>
			<br>
		</form>
	</div>
</body>

</html>
