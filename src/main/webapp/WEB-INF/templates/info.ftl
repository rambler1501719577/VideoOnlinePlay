<div class="user-info-container" style="padding:2rem 2.5rem 1.5rem 0">
    <form class="layui-form" lay-filter="info-form">
        <div>
            <input type="hidden" value="${user.id}" class="layui-input id">
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">帐号</label>
            <div class="layui-input-block">
                <input type="text" disabled value="${user.account}" required placeholder=""
                       autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-block">
                <input type="text" value="${user.name}" required class="layui-input name">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">年龄</label>
            <div class="layui-input-block">
                <input type="text" value="${user.age}"
                       class="layui-input age">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <#if user.sex == '男'>
                    <input type="radio" class="sex" value="男" title="男" checked>
                    <input type="radio" class="sex" value="女" title="女">
                </#if>
                <#if user.sex == '女'>
                    <input type="radio" class="sex" value="男" title="男">
                    <input type="radio" class="sex" value="女" title="女" checked>
                </#if>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">毕业大学</label>
            <div class="layui-input-block">
                <input type="text" value="${user.graduate}" name="title"
                       class="layui-input graduate">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">专业</label>
            <div class="layui-input-block">
                <input type="text" value="${user.major}" class="layui-input major">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">联系方式</label>
            <div class="layui-input-block">
                <input type="text" name="title" value="${user.telephone}" class="layui-input telephone">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">邮箱</label>
            <div class="layui-input-block">
                <input type="text" value="${user.mail}" class="layui-input mail">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="button" class="layui-btn" id="save-btn">保存</button>
            </div>
        </div>
    </form>
</div>
<script>
    $("#save-btn").click(function () {
        var params = {
            id: $(".id").val(),
            name: $(".name").val(),
            age: $(".age").val(),
            sex: $(".sex").val(),
            graduate: $(".graduate").val(),
            major: $(".major").val(),
            telephone: $(".telephone").val(),
            mail: $(".mail").val()
        };
        $.post("/VideoOnlinePlay/user/update", params, function (res) {
            alert(res.message);
        })
    });
</script>
