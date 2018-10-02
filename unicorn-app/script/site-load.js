var last=10;
$( document ).ready(function() {
  renderContent();
});

function renderContent(){
  for (var i = 0; i < last; i++) {
    $("#"+i).removeClass("post-inactive");
  }
}

function loadMore(){
    last = last+10;
    for (var y = 0; y < last; y++) {
      $("#"+y).removeClass("post-inactive");
    }
  }

$(window).scroll(function() {
 if($(window).scrollTop() + $(window).height() > $(document).height() - 100) {
     loadMore();
   }
});