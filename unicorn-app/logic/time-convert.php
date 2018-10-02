<?php
/**
 * Created by:
 * User: Steven
 * Date: 9/11/2018
 */
function getTimeSincePostet($postet){
	$now = date("Y-m-d H:i:s");
	$time= strtotime($now)-strtotime($postet);
	if ($time <=60) {
		return "less then 1 min";
	}elseif ($time >=60 && $time <= 120) {
		return "less then 2 min";
	}elseif ($time >=120 && $time <= 180) {
		return "less then 3 min";
	}elseif ($time >=180 && $time <= 240) {
		return "less then 4 min";
	}elseif ($time >=240 && $time <= 300) {
		return "less then 5 min";
	}elseif ($time > 6000) {
		return "10 minutes ago";
	}elseif ($time > 1800) {
		return "30 minutes ago";
	}elseif ($time >3600) {
		return "less then 2 min";
	}
	
}

?>