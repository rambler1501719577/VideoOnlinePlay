var IndexPage = function () {
    /**
     * 获取课程
     * @param id 生成列表的dom节点名
     * @param classifyName 分类的名称
     */
    var getCourse = function (id, classifyName) {
        $.post('/course/getCourse', {classifyName: classifyName}, function (response) {
            var result = response.data;
            if (result && result.length > 0) {
                var container = $("#" + id);
                for (var i = 0; i < result.length; i++) {
                    var a = $("<a href='/page/detail?id=" + result[i].id + "' class='video-part layui-col-md2' target='_blank'></a>");
                    var img = $("<div class='cover' style='background-image: url("+result[i].coverImage+");'></div>");
                    var description = $("<div class='video-description'><p>" + result[i].description + "</p></div>")
                    a.append(img);
                    a.append(description);
                    container.append(a);
                }
            }
        })
    };

    return {
        init: function () {
            getCourse('part1', '工程结算');
            getCourse('part2', '抵债资产');
            getCourse('part3', '库存现金');
            getCourse('part4', '利息支出');

        }
    }
}();
$(document).ready(function () {
    IndexPage.init();
});