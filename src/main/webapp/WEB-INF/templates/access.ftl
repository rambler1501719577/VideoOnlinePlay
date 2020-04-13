<div class="access-container" style="padding: 1rem 2rem">
    <h1 style="margin:0 0 1rem 0;font-size: 1.6rem">培养过程</h1>
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
    <#if isOk == true>
        <button style="float:right;margin-top:1rem;margin-left:1rem" type="button" class="layui-btn"
                id="apply-pass-btn">提交综合考核
        </button>
        <script>
            $("#apply-pass-btn").click(function () {
                $.post("/VideoOnlinePlay/check/add", {}, function (res) {
                    alert(res.message);
                })
            })
        </script>
    </#if>
    <#if isOk == false>
        <button style="float:right;margin-top:1rem;margin-left:1rem" type="button" class="layui-btn"
                id="apply-pass-btn">未满一年无法进行考核
        </button>
    </#if>

</div>