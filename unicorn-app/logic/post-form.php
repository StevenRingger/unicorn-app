<?php
/**
 * Created by:
 * User: Steven
 * Date: 9/11/2018
 */
class PostForm
{
  
  function __construct()
  {
    ?>
    <script type="text/javascript">
      $('.show-img').click(function(){
        
      });
      function validateForm() {
        
    }
    </script>
    <form class="post-form" method="post" action="" onsubmit="return validateForm()" name="addCocktail" enctype="multipart/form-data">
      <input type="hidden" name="userid" value="">
      <input type="hidden" name="time" value="">
        <div class="post-image" id="post-image-upload">
          <img id="image-field"/>
        </div>
        <input type="button" class="btn" value="Bild hochladen" onclick="document.getElementById('file').click();" />
        <input type="file"  name="fileToUpload" style="display:none;" id="file" class="fileToUpload" onchange="document.getElementById('image-field').src=window.URL.createObjectURL(this.files[0]); $('#post-image-upload').toggle();">
      
      
      <textarea name="post-text" rows="3" placeholder="Write something...."></textarea>
      <input type="submit" name="submit" class="btn" value="Post">
    </form>

    <?php
  }
}

?>