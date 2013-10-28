//Diese Script muss mit APache ausgeführt werden ( Windows -> XAMPP )


<?php
header('Access-Control-Allow-Origin: *'); //Momentan ist der Zugriff von überall erlaubt !!!!
//Diese Abfrage muss noch mit JSP realisiert werden!!

$passwort = $_GET['q'];
$sicherheitszahl = 0;
$sicherheitszahl = strlen($passwort);

if (preg_match("/[a-z]+/", $passwort)) {
    $sicherheitszahl = $sicherheitszahl + 5;
}

if (preg_match("/[A-Z]+/", $passwort)) {
    $sicherheitszahl = $sicherheitszahl + 5;
}

if (preg_match("/[0-9]+/", $passwort)) {
    $sicherheitszahl = $sicherheitszahl + 5;
}

if (preg_match("/[.,;:-_ #'+*~!§$%&\/\(\)\[\]\{\}\\=?<>\|]+/", $passwort)) {
    $sicherheitszahl = $sicherheitszahl + 5;
   
}

if ($sicherheitszahl <= 18 ) {
    echo 'unsicher ('.$sicherheitszahl.' Punkte)';

}

elseif ($sicherheitszahl <= 25) {
    echo 'sicher ('.$sicherheitszahl.' Punkte)';

}

elseif ($sicherheitszahl > 25) {
    echo 'sehr sicher ('.$sicherheitszahl.' Punkte)';

}

?>