<div class="apply-info-container" style="padding:2rem">
    <form class="layui-form layui-form-pane apply-form">
        <input type="hidden" value="${apply.id}" class="hidden_id">
        <!-- 第一行 -->
        <div class="layui-row">
            <div class="layui-col-xs3">
                <div class="layui-form-item">
                    <label class="layui-form-label">姓名</label>
                    <div class="layui-input-block">
                        <input value="${apply.name}" disabled type="text" class="layui-input name">
                    </div>
                </div>
            </div>
            <div class="layui-col-xs3">
                <div class="layui-form-item">
                    <label class="layui-form-label">性别</label>
                    <div class="layui-input-block">
                        <input value="${apply.sex}" disabled type="text" class="layui-input name">
                    </div>
                </div>
            </div>
            <div class="layui-col-xs3">
                <div class="layui-form-item">
                    <label class="layui-form-label">民族</label>
                    <div class="layui-input-block">
                        <input type="text" class="layui-input nation" value="${apply.nation}" disabled>
                    </div>
                </div>
            </div>
            <div class="layui-col-xs3">
                <div class="layui-form-item">
                    <label class="layui-form-label">出生年月</label>
                    <div class="layui-input-block">
                        <input type="text" class="layui-input birthday" value="${apply.birthday}" disabled>
                    </div>
                </div>
            </div>
        </div>

        <!-- 第二行 -->
        <div class="layui-row">
            <div class="layui-col-xs3">
                <div class="layui-form-item">
                    <label class="layui-form-label">政治面貌</label>
                    <div class="layui-input-block">
                        <input type="text" class="layui-input politics" value="${apply.politics}" disabled>
                    </div>
                </div>
            </div>
            <div class="layui-col-xs3">
                <div class="layui-form-item">
                    <label class="layui-form-label">职称</label>
                    <div class="layui-input-block">
                        <input type="text" class="layui-input professional" value="${apply.professional}" disabled>
                    </div>
                </div>
            </div>
            <div class="layui-col-xs6">
                <div class="layui-form-item">
                    <label class="layui-form-label">所在单位</label>
                    <div class="layui-input-block">
                        <input type="text" class="layui-input unit" value="${apply.unit}" disabled>
                    </div>
                </div>
            </div>
        </div>

        <!-- 第三行 -->
        <div class="layui-row">
            <div class="layui-col-xs4">
                <div class="layui-form-item">
                    <label class="layui-form-label">联系电话</label>
                    <div class="layui-input-block">
                        <input type="text" class="layui-input telephone" value="${apply.telephone}" disabled>
                    </div>
                </div>
            </div>
            <div class="layui-col-xs4">
                <div class="layui-form-item">
                    <label class="layui-form-label">QQ/微信</label>
                    <div class="layui-input-block">
                        <input type="text" class="layui-input we-chat" value="${apply.weChat}" disabled>
                    </div>
                </div>
            </div>
            <div class="layui-col-xs4">
                <div class="layui-form-item">
                    <label class="layui-form-label">E-mail</label>
                    <div class="layui-input-block">
                        <input type="text" class="layui-input mail" value="${apply.mail}" disabled>
                    </div>
                </div>
            </div>
        </div>

        <!-- 第四行 -->
        <div class="layui-row">
            <div class="layui-col-xs4">
                <div class="layui-form-item">
                    <label class="layui-form-label">毕业学校</label>
                    <div class="layui-input-block">
                        <input type="text" class="layui-input graduate" value="${apply.graduate}" disabled>
                    </div>
                </div>
            </div>
            <div class="layui-col-xs4">
                <div class="layui-form-item">
                    <label class="layui-form-label">专业学科</label>
                    <div class="layui-input-block">
                        <input type="text" class="layui-input major" value="${apply.major}" disabled>
                    </div>
                </div>
            </div>
            <div class="layui-col-xs4">
                <div class="layui-form-item">
                    <label class="layui-form-label">学历/学位</label>
                    <div class="layui-input-block">
                        <input type="text" class="layui-input degree" value="${apply.degree}" disabled>
                    </div>
                </div>
            </div>
        </div>

        <!-- 第五行 -->
        <div class="layui-row">
            <div class="layui-col-xs7">
                <div class="layui-form-item">
                    <label class="layui-form-label">来校工作时间</label>
                    <div class="layui-input-block">
                        <input type="text" class="layui-input come-time" value="${apply.comeTime}" disabled>
                    </div>
                </div>
            </div>
            <div class="layui-col-xs5">
                <div class="layui-form-item">
                    <label class="layui-form-label">培养起止时间</label>
                    <div class="layui-input-block">
                        <input type="text" class="layui-input train-time" value="${apply.trainTime}" disabled>
                    </div>
                </div>
            </div>
        </div>

        <!-- 第六行 -->
        <div class="layui-row">
            <div class="layui-col-xs3">
                <div class="layui-form-item">
                    <label class="layui-form-label">指导教师姓名</label>
                    <div class="layui-input-block">
                        <input type="text" class="layui-input teacher-name" value="${apply.teacherName}" disabled>
                    </div>
                </div>
            </div>
            <div class="layui-col-xs3">
                <div class="layui-form-item">
                    <label class="layui-form-label">指导教师性别</label>
                    <div class="layui-input-block">
                        <input type="text" class="layui-input teacher-sex" value="${apply.teacherSex}" disabled>
                    </div>
                </div>
            </div>
            <div class="layui-col-xs3">
                <div class="layui-form-item">
                    <label class="layui-form-label">指导教师年龄</label>
                    <div class="layui-input-block">
                        <input type="text" class="layui-input teacher-age" value="${apply.teacherAge}" disabled>
                    </div>
                </div>
            </div>
            <div class="layui-col-xs3">
                <div class="layui-form-item">
                    <label class="layui-form-label">指导教师职称</label>
                    <div class="layui-input-block">
                        <input type="text" class="layui-input teacher-professional" value="${apply.teacherProfessional}"
                               disabled>
                    </div>
                </div>
            </div>
        </div>

        <!-- 第七行 -->
        <div class="layui-row">
            <div class="layui-col-xs12">
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">培养计划</label>
                    <div class="layui-input-block">
                        <textarea name="desc"
                                  placeholder="(由指导教师、被指导教师根据《烟台大学青年教师助教培养实施办法（试行）》的要求共商制订培养计划，内容包括培养目标、培养内容、主要措施等)"
                                  class="layui-textarea train-plan" value="" disabled>${apply.trainPlan}</textarea>
                    </div>
                </div>
            </div>
        </div>
        <!-- 第八行 -->
        <div class="layui-row">
            <div class="layui-col-xs12">
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">教研室意见</label>
                    <div class="layui-input-block">
                        <textarea name="desc" placeholder="请输入内容" class="layui-textarea teaching-option" value=""
                                  disabled>${apply.teachingOption}</textarea>
                    </div>
                </div>
            </div>
        </div>
        <!-- 第九行 -->
        <div class="layui-row">
            <div class="layui-col-xs12">
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">教学单位意见</label>
                    <div class="layui-input-block">
                        <textarea name="desc" placeholder="请输入内容" class="layui-textarea unit-option" value=""
                                  disabled>${apply.unitOption}</textarea>
                    </div>
                </div>
            </div>
        </div>
        <!-- 第十行 -->
        <div class="layui-row">
            <div class="layui-col-xs12" style="border-bottom: 1px solid #e6e6e6">
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">教务处意见</label>
                    <div class="layui-input-block">
                        <textarea name="desc" placeholder="请输入内容" class="layui-textarea office-option" value=""
                                  disabled>${apply.officeOption}</textarea>
                    </div>
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button style="float:right;margin-top:1rem;margin-left:1rem" type="button" class="layui-btn"
                        id="apply-pass-btn">通过
                </button>
                <button style="float:right;margin-top:1rem" type="button" class="layui-btn layui-btn-danger"
                        id="apply-refuse-btn">驳回
                </button>
            </div>
        </div>
    </form>
</div>
<script>
    layui.use('layer', function () {
        var layer = layui.layer;
        $("#apply-pass-btn").click(function () {
            $.post("/VideoOnlinePlay/apply/update", {id: $(".hidden_id").val(), status: 1}, function (res) {
                alert(res.message);
                Base.openPage('approval');
                layer.closeAll();
            })
        });
        $("#apply-refuse-btn").click(function () {
            $.post("/VideoOnlinePlay/apply/update", {id: $(".hidden_id").val(), status: 2}, function (res) {
                alert(res.message);
                Base.openPage('approval');
                layer.closeAll();
            })
        });
    });
</script>
