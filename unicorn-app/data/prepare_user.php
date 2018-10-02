<?php
/**
 * Created by:
 * User: Steven
 * Date: 9/11/2018
 */
class CreateUser
{
	
	function __construct()
	{
	}
	public function returnUser(){
		$user = new User(1,"Heinz","Heinzer","heinz@heinzer.com","1992-10-15","this is some text",10000);
		return $user;
	}
}