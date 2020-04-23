var Detail = function () {
    var getIdByParam = function () {
        var url = location.href;
        var allParam = url.split("?")[1];
        return allParam.split("=")[1];
    };
    var initEvent = function () {
        $(".attend").click(function () {
            $.post('/course/attend', {id: getIdByParam()}, function (response) {
                if (response.code === 200) {
                    alert("报名成功")
                } else {
                    alert(response.message);
                }
            })
        })
    };

    var getDetailInfo = function () {
        var id = getIdByParam();
        $.post("/course/detail", {id: id}, function (response) {
            $("#video-player").attr("src", response.data.playSrc);
            $("#video-title").text(response.data.name);
        })
    };
    var getComment = function () {
        var id = getIdByParam();
        $.post("/comment/list", {courseId: id}, function (response) {
            var result = response.data;
            if (result != null) {
                var container = $("#commentContainer");
                for (var i = 0; i < result.length; i++) {
                    var li = $("<li></li>");
                    var div = $("<div class='wenda-listcon mod-qa-list post-row clearfix'></div>");
                    var header = $("<div class='headslider qa-medias l'><a class='media' href='' target='_blank'><img src='" + result[i].header + "' alt='' width='40px' height='40px'></a></div>")
                    var content = $("<div class='wendaslider qa-content'>" +
                        "<a href='' target='_blank'>" + result[i].name + "</a>" +
                        "<p>" + result[i].content + "</p>" +
                        "<span class='r timeago'>" + result[i].time + "</span>" +
                        "</div>");
                    div.append(header);
                    div.append(content);
                    li.append(div);
                    container.append(li);
                }
            }
        });
    };
    return {
        init: function () {
            initEvent();
            getDetailInfo();
            getComment();
        }
    }
}();
$(document).ready(function () {
    Detail.init();
});
