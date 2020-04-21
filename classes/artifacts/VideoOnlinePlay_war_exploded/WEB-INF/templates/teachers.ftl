<div class="access-container" style="padding: 1.3rem 2rem">
    <h1 style="display:inline">教师信息</h1>
    <#if role.name=="学校管理员">
        <form class="layui-form" style="float:right;width:20%">
            <select name="city" lay-verify="apartment">
                <option value="">请选择学院</option>
                <option value="建筑学院">建筑学院</option>
                <option value="计算机学院">计算机学院</option>
                <option value="数学学院">数学学院</option>
            </select>
        </form>
    </#if>
    <table id="teachers" lay-filter="teachers"></table>
</div>

<script>
    layui.use(['table', 'form'], function () {
        var table = layui.table;
        var form = layui.form;
        var teacher_table = table.render({
            elem: '#teachers'
            , height: 480
            , url: '/VideoOnlinePlay/apply/VideoOnlinePlays/' //数据接口
            , page: true //开启分页
            , id: 'teacher_table'
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
            ]]
        });
        table.on('tool(teachers)', function (obj) {
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）
            if (layEvent === 'detail') {
                $.get("/VideoOnlinePlay/apply/detail", {id: data.id}, function (res) {
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
        form.on('select()', function (data) {
            console.log(data.value); //得到被选中的值
            teacher_table.reload({
                where: { //设定异步数据接口的额外参数，任意设
                    apartment: data.value
                }
                , page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
        });
    });

</script>