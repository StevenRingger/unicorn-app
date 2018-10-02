<?php

/**
 * Created by:
 * User: Steven
 * Date: 9/11/2018
 */
class Unicorn
{
	private $id;
	private $name;
	private $image;
	private $price;

	function __construct($id,$name,$image,$price)
	{
		$this->id=$id;
		$this->name=$name;
		$this->image=$image;
		$this->price=$price;
	}

	public function setId($id):void{$this->id=$id;}
	public function getId(){return $this->id;}

	public function setName($name):void{$this->name=$name;}
	public function getName(){return $this->name;}

	public function setImage($image):void{$this->image=$image;}
	public function getImage(){return $this->image;}

	public function setPrice($price):void{$this->price=$price;}
	public function getPrice(){return $this->price;}
}

?>