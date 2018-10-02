<?php

/**
 * Created by:
 * User: Steven
 * Date: 9/11/2018
 */
class Post
{
	private $id;
	private $author;
	private $time;
	private $text;
	private $image;
	private $comments;
	function __construct($id,$author,$time,$text, $image, $comments)
	{
		$this->id=$id;
		$this->author=$author;
		$this->time=$time;
		$this->text=$text;
		$this->image=$image;
		$this->comments=$comments;
	}
	public function setid($id): void{$this->id = $id;}
    public function getid(){return $this->id;}

    public function setauthor($author): void{$this->author = $author;}
    public function getauthor(){return $this->author;}

    public function settime($time): void{$this->time = $time;}
    public function gettime(){return $this->time;}

    public function settext($text): void{$this->text = $text;}
    public function gettext(){return $this->text;}

    public function setimage($image): void{$this->image = $image;}
    public function getimage(){return $this->image;}

    public function setcomments($comments): void{$this->comments = $comments;}
    public function getcomments(){return $this->comments;}
}

?>