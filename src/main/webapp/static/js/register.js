$(".register-btn").click(function () {
    var account = $(".account").val();
    var name = $(".name").val();
    var password = $(".password").val();
    var role_id = $(".role").val();
    var repeat_password = $(".repeat-password").val();
    if (password !== '' && password === repeat_password) {
        $.post("/user/register", {account: account, password: password, name: name, role: role_id}, function (res) {
            if (res.code === 200) {
                window.location.href = "http://localhost:8080/";
            } else {
                alert("注册失败");
            }
        })
    } else {
        alert("请检查密码");
    }
});