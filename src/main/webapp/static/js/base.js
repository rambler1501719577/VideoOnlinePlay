var Base = function () {
    var element = null;
    var form = null;
    var table = null;
    var layer = null;
    var loadUser = function () {
        $.get("/VideoOnlinePlay/user/current", function (res) {
            if (res.code === 200) {
                $(".current-user").text(res.data.name);
            } else {
                window.location.href = "http://localhost:8080/VideoOnlinePlay";
            }
        });
    };
    var bindEventListener = function () {
        $(".quit-btn").click(function () {
            $.post('/VideoOnlinePlay/user/quit', {}, function (res) {
                window.location.href = "http://localhost:8080/VideoOnlinePlay";
            });
        });
    };
    var openPage = function (aim) {
        var container = $(".layui-body");
        container.text("");
        container.load(aim, function (res) {
            form.render();
        })
    };
    var loadDefaultPage = function (aim) {
        openPage(aim);
        $("#my-menu>li>a[data-aim=" + aim + "]").addClass("layui-this");
    };
    var init = function () {
        layui.use(['element', 'form', 'table', 'layer'], function () {
            element = layui.element;
            form = layui.form;
            table = layui.table;
            layer = layui.layer;
            loadUser();
            bindEventListener();
        });
    };
    return {
        init: init,
        form: form,
        element: element,
        table: table,
        layer: layer,
        openPage: function (aim) {
            openPage(aim);
        }
    }
}();

$(document).ready(function () {
    Base.init();
});