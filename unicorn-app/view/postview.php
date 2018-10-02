<?php

/**
 * Created by:
 * User: Steven
 * Date: 9/11/2018
 */
class Postview
{
  
  function __construct()
  {
  }
  public function renderPosts($post,$id){
    ?>
    <div class="post post-inactive postid-<?php echo $post->getid(); ?>" id="<?php echo $id; ?>">
      <div class="post-image">
        <img src="<?php echo $post->getimage(); ?>">
      </div>
      <div class="row">
        <div class="col-sm-2 post-user"><?php echo $post->getauthor(); ?></div>
        <div class="col-sm-7"></div>
        <div class="col-sm-3 post-time"><?php echo getTimeSincePostet($post->gettime()); ?></div>
      </div>
      <div class="post-text">
        <p>
          <?php echo $post->gettext(); ?>
        </p>
      </div>
      <hr>
      <div class="row">
        <div class="col-md-4"><button class="btn post-btn">Like</button></div>
        <div class="col-md-4"></div>
        <div class="col-md-4"><button class="btn post-btn" id="show-comments" onclick="$('.comments-<?php echo $post->getid(); ?>').toggle();$(this).toggleClass('active');">View comments</button></div>
      </div>
      <hr>
      <div class="comments comments-<?php echo $post->getid(); ?>">
        <?php 
          $comment_field = new CommentForm($post->getid());
          foreach ($post->getcomments() as $comment) { ?>
            <div class="comment" id="<?php echo $comment->gettext(); ?>">
              <div class="row">
                <div class="col-sm-2 comment-user"><?php echo $comment->getauthor(); ?></div>
                <div class="col-sm-8"></div>
                <div class="col-sm-3 comment-time"><?php echo $comment->gettime(); ?></div>
              </div>
              <div class="comment-text">
                <?php echo $comment->gettext(); ?>
              </div>
            </div>
        <?php }
         ?>
      </div>
    </div>
    <?php
  }
}

?>