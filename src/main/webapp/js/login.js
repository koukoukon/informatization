$(function () {
    $("#login_but1").click(function () {
        var username = $("#username").val();
        var password = $("#password").val();
        if (username.length == 0) {
            $("p.l_message").html("用户名不能为空");
            return false;
        }
        if (password.length == 0) {
            $("p.l_message").html("密码不能为空");
            return false;
        }
        $.ajax({
            url: "login",
            type: "post",
            dataType: "json",
            data: {
                "username": username,
                "password": password
            },
            success: function (data) {
                console.log(data);
                switch (data["status"]) {
                    case -1:
                        $("p.l_message").html("用户名或密码错误");
                        break;
                    case 1:
                        $("p.l_message").html("登录成功");
                        setTimeout(function () {
                            location.href = "admin/index";
                        }, 250)
                        break;
                }
            }
        })
        return false;
    })

})