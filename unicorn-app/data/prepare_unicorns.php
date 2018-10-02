<?php

/**
 * Created by:
 * User: Steven
 * Date: 9/11/2018
 */
class CreateUnicorns
{
	
	function __construct()
	{
	}
	public function returnUnicorns(){
		$unicorns=[];
		for ($i=0; $i < 10; $i++) { 
			if ($i=1||$i=3||$i=4||$i=7||$i=9) {
				$unicorns[] = new Unicorn($i,"fluff","./img/unicorns/unicorn_2.png",$i*250);
			}else{
				$unicorns[] =  new Unicorn($i,"pinky","./img/unicorns/unicorn_1.png",$i*200);
			}
		}
		return $unicorns;
	}
}

?>