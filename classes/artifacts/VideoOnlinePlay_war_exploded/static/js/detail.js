var Detail = function() {
	var initEvent = function() {
		$("#comment-btn").click(function(){
			console.log(1);
		})
	}
	return {
		init:initEvent
	}
}();
$(document).ready(function() {
	Detail.init();
})
