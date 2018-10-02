<?php
/**
 * Created by:
 * User: Steven
 * Date: 9/11/2018
 */
$data = new PostData();
$posts= $data->getPostData(1000);
?>
<div class="row">
  <div class="col-md-3">
    <div >
      <?php render_sidemenu(); ?>
    </div>
  </div>
  <div class="col-md-9" id="posts">
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

