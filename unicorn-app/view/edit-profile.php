<?php
/**
 * Created by:
 * User: Steven
 * Date: 9/11/2018
 */
?>
<h1>Edit Profile of <?php echo $user->getFirstname()." ".$user->getLastname();?></h1>
<div class="edit">
	<form method="update" action="">
		<div class="row">
			<div class="col-md-6">
				<label for="firstname">Firstname: </label>
				<input type="text" name="firstname" class="form-control firstname" placeholder="firstname" value="<?php echo $user->getFirstname();?>">
			</div>
			<div class="col-md-6">
				<label for="lastname">Lastname: </label>
				<input type="text" name="lastname" class="form-control lastname" placeholder="lastname" value="<?php echo $user->getLastname();?>">
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<label for="email">E-Mail: </label>
				<input type="email" name="email" class="form-control email" placeholder="example@gmail.com" value="<?php echo $user->getEmail();?>">
			</div>
			<div class="col-md-6">
				<label for="bdate">Birthday: </label>
				<input type="date" name="bdate" class="form-control bdate" value="<?php echo $user->getBirthday();?>">
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<label for="bio">Bio: </label>
				<textarea name="bio" class="form-control bio" placeholder="Tell something about you" ><?php echo $user->getBio();?></textarea>
			</div>
		</div>
		<input type="submit" name="submit">
	</form>
</div>