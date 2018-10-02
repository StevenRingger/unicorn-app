<?php
/**
 * Created by:
 * User: Steven
 * Date: 9/11/2018
 */
$data = new PostData();
$posts= $data->getPostData(100);
?>
<div class="user-header"><div class="profile-img"><img src=""></div></div>
<div class="user-nav-bar">
	
	<div class="user-name"><?php echo $user->getFirstname() ." ".$user->getLastname(); ?></div>
</div>
<div class="user-content">
	<div class="row">
	  <div class="col-md-3">
	    <div >
	      <?php 
	      	render_usersidemenu(); 
	      	render_user_unicorns($user->getId());
	      ?>
	    </div>
	  </div>
	  <div class="col-md-9" id="posts">
	  	<h2>My Posts</h2>
	    <?php
	    $post_field = new PostForm();
	    $id = 0;
	    foreach ($posts as $post){ 
	      $displayposts->renderPosts($post,$id);
	    $id++;
	    }
	    ?>
	  </div>
	</div>
</div>