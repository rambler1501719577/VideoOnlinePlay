<div class="mark-container" style="padding:0.5rem 0 2rem 2rem">
    <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
        <ul class="layui-tab-title">
            <#if role.name == "学院管理员">
                <li class="layui-this">学院评分</li>
            </#if>
            <#if role.name == "学校管理员">
                <li class="layui-this">学校评分</li>
            </#if>
            <li>最终成绩</li>
        </ul>
        <div class="layui-tab-content">
            <#if role.name == "学院管理员">
                <div class="layui-tab-item layui-show">
                    <table id="apartment" lay-filter="apartment"></table>
                </div>
            </#if>
            <#if role.name == "学校管理员">
                <div class="layui-tab-item layui-show">
                    <table id="school" lay-filter="school"></table>
                </div>
            </#if>
            <div class="layui-tab-item">
                <table id="score" lay-filter="score"></table>
            </div>
        </div>
    </div>
</div>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="detail">评分</a>
</script>
<script>
    layui.use(['element', 'table'], function () {
        var element = layui.element;
        var table = layui.table;
        table.render({
            elem: '#apartment'
            , height: 580
            , url: '/VideoOnlinePlay/check/list/' //数据接口
            , page: true //开启分页
            , cols: [[ //表头
                {field: 'name', title: '姓名', width: 80}
                , {field: 'sex', title: '性别', width: 80, sort: true}
                , {field: 'politics', title: '政治面貌', width: 100}
                , {field: 'graduate', title: '毕业学校', width: 110}
                , {field: 'major', title: '大学专业', width: 100}
                , {field: 'unit', title: '单位', width: 180}
                , {field: 'telephone', title: '联系方式', width: 150}
                , {field: 'teacherName', title: '指导老师', width: 150}
                , {field: 'teacherProfessional', title: '指导老师职称', width: 150}
                , {fixed: 'right', width: 70, align: 'center', toolbar: '#barDemo'}
            ]]
        });
        table.on('tool(apartment)', function (obj) {
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）
            if (layEvent === 'detail') {
                $.get("/VideoOnlinePlay/score", {applyId: data.id}, function (res) {
                    layui.use('layer', function () {
                        var layer = layui.layer;
                        layer.open({
                            type: 1,
                            content: res, //这里content是一个普通的String
                            area: ['1000px', '500px']
                        });
                    });
                });
            }
        });
        table.render({
            elem: '#school'
            , height: 580
            , url: '/VideoOnlinePlay/check/list/' //数据接口
            , page: true //开启分页
            , cols: [[ //表头
                {field: 'name', title: '姓名', width: 80}
                , {field: 'sex', title: '性别', width: 80, sort: true}
                , {field: 'politics', title: '政治面貌', width: 100}
                , {field: 'graduate', title: '毕业学校', width: 110}
                , {field: 'major', title: '大学专业', width: 100}
                , {field: 'unit', title: '单位', width: 180}
                , {field: 'telephone', title: '联系方式', width: 150}
                , {field: 'teacherName', title: '指导老师', width: 150}
                , {field: 'teacherProfessional', title: '指导老师职称', width: 150}
                , {fixed: 'right', width: 70, align: 'center', toolbar: '#barDemo'}
            ]]
        });
        table.on('tool(school)', function (obj) {
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）
            if (layEvent === 'detail') {
                $.get("/VideoOnlinePlay/score", {applyId: data.id}, function (res) {
                    layui.use('layer', function () {
                        var layer = layui.layer;
                        layer.open({
                            type: 1,
                            content: res, //这里content是一个普通的String
                            area: ['1000px', '500px']
                        });
                    });
                });
            }
        });
        table.render({
            elem: '#score'
            , height: 400
            , url: '/VideoOnlinePlay/check/score/' //数据接口
            , page: true //开启分页
            , cols: [[ //表头
                {field: 'name', title: '姓名', width: 150}
                , {field: 'score', title: '分数', width: 150, sort: true}
            ]]
        });
    });

</script>