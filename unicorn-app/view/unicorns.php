<?php
/**
 * Created by:
 * User: Steven
 * Date: 9/11/2018
 */

function render_user_unicorns($id){
    $unicorndata = new CreateUnicorns();
    $unicorns = $unicorndata->returnUnicorns();
	echo '<div class="unicorns">';
		foreach ($unicorns as $unicorn) {
			echo '<div class="unicorn-img">
				<img src="./img/unicorns/unicorn_2.png">
			</div>';
		}
		?>
	</div>

	<?php
}
?>