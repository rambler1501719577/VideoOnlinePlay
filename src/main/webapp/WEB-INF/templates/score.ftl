<div class="access-container" style="padding: 1rem 2rem">
    <h1 style="margin:0 0 1rem 0;font-size: 1.6rem">培养过程</h1>
    <input type="hidden" value="${score.id}" class="id">
    <ul class="layui-timeline">
        <li class="layui-timeline-item">
            <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
            <div class="layui-timeline-content layui-text">
                <h3 class="layui-timeline-title">${apply.comeTime} 提交培养申请</h3>
                <p style="line-height: 2rem;font-size: 15px;">
                    教师评价: ${apply.teachingOption}
                </p>
            </div>
        </li>
        <#list list as activity>
            <li class="layui-timeline-item" style="margin-top: 15px">
                <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                <div class="layui-timeline-content layui-text">
                    <h3 class="layui-timeline-title">${activity.time} 参加主题为 "${activity.topic}" 的学习活动</h3>
                    <p style="line-height: 2rem;font-size: 15px;">${activity.content}</p>
                </div>
            </li>
        </#list>
    </ul>
    <#if score.status == 1 && role.name == "学院管理员">
        <div class="layui-inline">
            <label style="width: 100px" class="layui-form-label">学院评定成绩:</label>
            <div class="layui-input-inline" style="width: 100px;">
                <input type="text" value="" class="layui-input score1">
            </div>
        </div>
        <button class="layui-btn save" style="display: block;float: right">保存</button>
        <script>
            $(".save").click(function () {
                $.post("/VideoOnlinePlay/check/update", {
                    score1: $(".score1").val(),
                    id: $(".id").val(),
                    status: 2
                }, function (res) {
                    alert(res.message);
                    parent.layer.closeAll();
                    Base.openPage("mark");
                })
            });
        </script>
    </#if>

    <#if score.status == 2 && role.name == "学校管理员">
        <div class="layui-inline">
            <label style="width: 100px" class="layui-form-label">学院评定成绩:</label>
            <div class="layui-input-inline" style="width: 100px;">
                <input type="text" value="${score.score1}" class="layui-input score1" disabled>
            </div>
        </div>
        <div class="layui-inline">
            <label style="width: 100px" class="layui-form-label">学校评定成绩:</label>
            <div class="layui-input-inline" style="width: 100px;">
                <input type="text" class="layui-input score2">
            </div>
        </div>
        <button class="layui-btn save" style="display: block;float: right">保存</button>
        <script>
            $(".save").click(function () {
                $.post("/VideoOnlinePlay/check/update", {
                    score2: $(".score2").val(),
                    id: $(".id").val(),
                    status: 3
                }, function (res) {
                    parent.layer.closeAll();
                    Base.openPage("mark");
                })
            });

        </script>
    </#if>
</div>