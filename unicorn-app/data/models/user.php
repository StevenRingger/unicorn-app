<?php
/**
 * Created by:
 * User: Steven
 * Date: 9/11/2018
 */
class User
{
	private $id;
	private $firstname;
	private $lastname;
	private $email;
	private $birthday;
	private $bio;
	private $coins;

	function __construct($id,$firstname,$lastname,$email,$birthday,$bio, $coins)
	{
		$this->id = $id;
		$this->firstname = $firstname;
		$this->lastname = $lastname;
		$this->email = $email;
		$this->birthday = $birthday;
		$this->bio = $bio;
		$this->coins = $coins;
	}
	public function setId($id): void{$this->id = $id;}
    public function getId(){return $this->id;}

    public function setFirstname($firstname): void{$this->firstname = $firstname;}
    public function getFirstname(){return $this->firstname;}

    public function setLastname($lastname): void{$this->lastname = $lastname;}
    public function getLastname(){return $this->lastname;}

    public function setEmail($email): void{$this->email = $email;}
    public function getEmail(){return $this->email;}

    public function setBirthday($birthday): void{$this->birthday = $birthday;}
    public function getBirthday(){return $this->birthday;}

    public function setBio($bio): void{$this->bio = $bio;}
    public function getBio(){return $this->bio;}

    public function setCoins($coins): void{$this->coins = $coins;}
    public function getCoins(){return $this->coins;}
}


?>