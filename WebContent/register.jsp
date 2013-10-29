<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>
<head>

<meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
<title>Registrierung</title>
<link rel="stylesheet" type="text/css" href="style.css">
<script src="commonscripts.js" type="text/javascript"></script>

<script src="jquery-1.9.1.js" type="text/javascript"></script>
<script src="jquery-ui-1.10.3.js" type="text/javascript"></script>

<script type="text/javascript">
	document.addEventListener('DOMContentLoaded', init, false);
	function init() {
		var sec_pwfield_IsVisible = false;
		
		var pw_typingTimer = null;
		var pw_doneTypingInterval = 1000;

		$('#register_password_field').keyup(
				function() {
					checkPWEqual();
					
					if (pw_typingTimer != null) clearTimeout(pw_typingTimer);
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
		
		$('#register_email_field').keyup(
                function() {
                    checkEmail();
                });
		
		$('#register_password_field_check').hide();

		function pw_doneTyping() {
			checkpw($('#register_password_field').val());
		}
	};
	
	function checkPWEqual() {
		var pw1 = $('#register_password_field').val();
		var pw2 = $('#register_password_field_check').val();
		
		if (pw1 === "" && pw2 === "") {
			$('#register_password_field').removeClass('inputbox_validate_unsuccessfull');
            
            $('#register_password_field_check').removeClass('inputbox_validate_unsuccessfull');
		} else if (pw1 === pw2) {
            $('#register_password_field').removeClass('inputbox_validate_unsuccessfull');
            $('#register_password_field').addClass('inputbox_validate_successfull');
            
            $('#register_password_field_check').removeClass('inputbox_validate_unsuccessfull');
            $('#register_password_field_check').addClass('inputbox_validate_successfull');
			return true;
		} else {
            $('#register_password_field').removeClass('inputbox_validate_successfull');
            $('#register_password_field').addClass('inputbox_validate_unsuccessfull');
            
            $('#register_password_field_check').removeClass('inputbox_validate_successfull');
            $('#register_password_field_check').addClass('inputbox_validate_unsuccessfull');
            return false;
		}
	}

	function checkpw(inhalt) {
		var url = "testpw.jsp?pw=" + inhalt;

		if (inhalt === "") {
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
				}
			};
		}
	}
	
	function checkEmail() {
		var mailstr = $('#register_email_field').val();
		var rex = new RegExp("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
		if (mailstr === "") {
			$('#register_email_field').removeClass('inputbox_validate_unsuccessfull');
            $('#register_email_field').removeClass('inputbox_validate_successfull');
		} else if (rex.test(mailstr)) {
			$('#register_email_field').removeClass('inputbox_validate_unsuccessfull');
			$('#register_email_field').addClass('inputbox_validate_successfull');
			return true;
		} else {
			$('#register_email_field').removeClass('inputbox_validate_successfull');
			$('#register_email_field').addClass('inputbox_validate_unsuccessfull');
			return false;
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
	
	function allFieldsFilled() {
		var ret = true;
		
		if ($('#register_forename_field').val() === "") {
			$('#register_forename_field').css("border-color", "red");
			ret = false;
		} else {
			$('#register_forename_field').css("border-color", "#DDD");
		}
		
		if ($('#register_lastname_field').val() === "") {
            $('#register_lastname_field').css("border-color", "red");
            ret = false;
        } else {
            $('#register_lastname_field').css("border-color", "#DDD");
        }
		
		if ($('#register_nickname_field').val() === "") {
            $('#register_nickname_field').css("border-color", "red");
            ret = false;
        } else {
            $('#register_nickname_field').css("border-color", "#DDD");
        }
        
		if ($('#register_address_field').val() === "") {
            $('#register_address_field').css("border-color", "red");
            ret = false;
        } else {
            $('#register_address_field').css("border-color", "#DDD");
        }
        
		if ($('#register_university_field').find(":selected").text() === "Hochschule") {
            $('#register_university_field').css("border-color", "red");
            ret = false;
        } else {
            $('#register_university_field').css("border-color", "#DDD");
        }
        
		if ($('#register_branch_field').val() === "") {
            $('#register_branch_field').css("border-color", "red");
            ret = false;
        } else {
            $('#register_branch_field').css("border-color", "#DDD");
        }
        
		if ($('#register_email_field').val() === "") {
            $('#register_email_field').css("border-color", "red");
            ret = false;
        } else {
            $('#register_email_field').css("border-color", "#DDD");
        }
        
		if ($('#register_password_field').val() === "") {
            $('#register_password_field').css("border-color", "red");
            ret = false;
        } else {
            $('#register_password_field').css("border-color", "#DDD");
        }
        
		if ($('#register_password_field_check').val() === "") {
            $('#register_password_field_check').css("border-color", "red");
            ret = false;
        } else {
            $('#register_password_field_check').css("border-color", "#DDD");
        }
        

		return ret;
	}

	function validateData() {
		var ret = true;
		
		if (!checkPWEqual()) {
			shakeContentBox("#contentbox_register");
			ret = false;
		}

		if (!checkEmail()) {
			shakeContentBox("#contentbox_register");
			ret = false;
		}

		if (!allFieldsFilled()) {
			shakeContentBox("#contentbox_register");
			ret = false;
		}

		return ret;
	}
</script>
</head>
<body class="standard_body">
	<div class="contentbox" id="contentbox_register">
		<h1 class="contentbox_title">studyTrade</h1>
		<form action="./index.jsp" method="GET" onsubmit="return validateData()">
			<input name="forname" placeholder="Vorname" type="text" class="inputbox_textfield" id="register_forename_field">
			<br>
			<input name="surname" placeholder="Nachname" type="text" class="inputbox_textfield" id="register_lastname_field">
			<br>
			<input name="nickname" placeholder="Nickname" type="text" class="inputbox_textfield" id="register_nickname_field">
			<br>
			<input name="address" placeholder="Wohnort" type="text" class="inputbox_textfield" id="register_address_field">
			<br>
			<select name="university" class="inputbox_selectionfield" id="register_university_field">
				<option value="h0" disabled selected>Hochschule</option>
				<option value="h1">Hochschule 1</option>
				<option value="h2">Hochschule 2</option>
				<option value="h3">Hochschule 3</option>
				<option value="h4">Hochschule 4</option>
				<option value="h5">Hochschule 5</option>
			</select>
			<br>
			<input name="branch" placeholder="Studienrichtung" type="text" class="inputbox_textfield" id="register_branch_field">
			<br>
			<input name="email" placeholder="E-Mail" type="text" class="inputbox_textfield" id="register_email_field">
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
