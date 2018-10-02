<?php
/**
 * Created by:
 * User: Steven
 * Date: 9/11/2018
 */
class CommentForm
{
	
	function __construct($id)
	{
		?>

		<form class="comment-form">
			<input type="hidden" name="postid" value="<?php echo $id; ?>">
			<input type="hidden" name="userid" value="">
			<input type="hidden" name="time" value="">
			<textarea name="comment-text" rows="3" placeholder="Write a comment...."></textarea>
			<input type="submit" name="submit" value="Comment">
		</form>

		<?php
	}
}

?>