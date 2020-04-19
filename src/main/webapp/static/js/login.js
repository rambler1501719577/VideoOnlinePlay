$(".login-btn").click(function () {
    var account = $(".account").val();
    var password = $(".password").val();
    $.post("user/validate", {account: account, password: password}, function (res) {
        if (res.code === 200) {
            window.location.href = "http://localhost:8080/";
        } else {
            alert("登录失败");
        }
    })
});
