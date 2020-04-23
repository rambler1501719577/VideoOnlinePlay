var Base = function () {
    var element = null;
    var form = null;
    var table = null;
    var layer = null;
    var loadUserAndMenu = function () {
        $.get("/user/current", function (res) {
            if (res.code === 200) {
                $("#user-name-span").text(res.data.name);
                $("#user-header-img").attr('src', res.data.header);
            } else {
                window.location.href = "http://localhost:8080/";
            }
        });
        $.get("/menu/list", function (res) {
            if (res.data) {
                var container = $("#dynamic-menu");
                var menu_data = res.data;
                for (var i = 0; i < menu_data.length; i++) {
                    var dd = $("<dd><a href='" + menu_data[i].url + "'>" + menu_data[i].name + "</a></dd>")
                    container.append(dd);
                }
            }
        })
    };
    var bindEventListener = function () {
        $(".quit-btn").click(function () {
            $.post('/user/quit', {}, function (res) {
                window.location.href = "http://localhost:8080/";
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
            loadUserAndMenu();
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