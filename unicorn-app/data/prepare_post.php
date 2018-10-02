<?php

/**
 * Created by:
 * User: Steven
 * Date: 9/11/2018
 */
class PostData
{
	function __construct()
	{
		
	}

	function getPostData($count){
		$posts =[];
		$author="username";
		$time=date("Y-m-d H:i:s", time() - 3600);
		$text ="Pellentesque commodo eros a enim. Praesent congue erat at massa. Nunc egestas, augue at pellentesque laoreet, felis eros vehicula leo, at malesuada velit leo quis pede. Integer tincidunt. Donec interdum, metus et hendrerit aliquet, dolor diam sagittis ligula, eget egestas libero turpis vel mi.";
		$image="./img/DSC_0005.jpg";
		for ($i=0; $i < $count; $i++) { 
			$id = $i;
			$posts[] = new Post($id, $author, $time, $text, $image, $this->getComments());
		}
		return $posts;
	}

	function getComments(){
		$comments=[];
		$author="username";
		$time=date("Y-m-d H:i:s", time() - 1800);
		$text ="Nam pretium turpis et arcu. Praesent metus tellus, elementum eu, semper a, adipiscing nec, purus. Phasellus nec sem in justo pellentesque facilisis. Ut leo. Ut non enim eleifend felis pretium feugiat.";
		for ($i=0; $i < 5; $i++) { 
			$id = $i;
			$comments[] = new Comment($id, $author, $time, $text);
		}
		return $comments;
	}
	
}

?>