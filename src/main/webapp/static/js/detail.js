var Detail = function() {
	var initEvent = function() {
		$("#comment-btn").click(function(){
			console.log(1);
		})
	};
	var getDetailInfo = function(){
		var url = location.href;
		var allParam = url.split("?")[1];
		var id = allParam.split("=")[1];
		alert(id);
		$.post("/course/detail",{id:id},function (response) {
			$("#video-player").attr("src",response.data.playSrc);
		})
	};
	return {
		init:function () {
			initEvent();
			getDetailInfo();
		}
	}
}();
$(document).ready(function() {
	Detail.init();
});
