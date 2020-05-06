var userName = "";
var userPassword = "";
var userPassword2 = "";
var userNickname = "";
var userGender = "";
var userEmail = "";
var userPhone = "";
var departmentPid = "";
$(function () {
    $.ajaxSetup({
        type: "post",
        dataType: "json"
    })
    loadDepartment();
    loadPageForAddOrEdit();
})
function loadPageForAddOrEdit() {
    //如果当前地址栏结尾不是edit则
    if (!location.href.endsWith("edit")){
        sessionStorage.removeItem("userId");
    }
    let userId = sessionStorage.getItem("userId");

    if (userId != null) {
        $("ol>li.active").html("编辑用户");
        $("button[type=submit]").html("确认编辑")
        $.ajax({
            url: userId,
            type: "get",
            success: function (data) {
                $("#userId").val(data["userId"]);
                $("#userName").val(data["userName"]);
                $("#userPassword").val(data["userPassword"]);
                $("#userPassword2").val(data["userPassword"]);
                $("#userNickname").val(data["userNickname"]);
                if (data["userGender"] == "男") {
                    $("#male").prop("checked", true);
                } else {
                    $("#female").prop("checked", true);
                }
                $("#userEmail").val(data["userEmail"]);
                $("#userPhone").val(data["userPhone"]);
                $("select[name=departmentPid]").val(data["departmentPid"]);
            }
        })
        $("button[type=submit]").click(editUser);
    } else {
        $("button[type=submit]").click(addUser);
    }
}

function loadDepartment() {
    $.ajax({
        url: "../dept",
        type:"get",
        success: function (data) {
            let html = "";
            for (var i in data) {
                html += "<option value='" + data[i]["departmentId"] + "'>" + data[i]["departmentName"] + "</option>"
            }
            $("select.form-control").append(html);
        }
    })
}

function addUser() {
    userName = $("#userName").val();
    userPassword = $("#userPassword").val();
    userPassword2 = $("#userPassword2").val();
    userNickname = $("#userNickname").val();
    userGender = $("input[name=userGender]:checked").val();
    userEmail = $("#userEmail").val();
    userPhone = $("#userPhone").val();
    departmentPid = $("select[name=departmentPid]").val();
    if (checkAll()) {
        $.ajax({
            url: "add",
            data: {
                "userName": userName,
                "userPassword": userPassword,
                "userNickname": userNickname,
                "userGender": userGender,
                "userEmail": userEmail,
                "userPhone": userPhone,
                "departmentPid": departmentPid
            },
            success: function (data) {
                switch (data["success"]) {
                    case -1:
                        alert("用户名重复");
                        break;
                    case 0:
                        alert("添加用户失败,请联系系统管理员查看日志");
                        break;
                    case 1:
                        alert("添加用户成功");
                        location.href = "manage";
                        break;
                }
            }
        })
    }
    return false;
}
function editUser() {
    let userId = $("#userId").val();
    userName = $("#userName").val();
    userPassword = $("#userPassword").val();
    userPassword2 = $("#userPassword2").val();
    userNickname = $("#userNickname").val();
    userGender = $("input[name=userGender]:checked").val();
    userEmail = $("#userEmail").val();
    userPhone = $("#userPhone").val();
    departmentPid = $("select[name=departmentPid]").val();
    if (checkAll()) {
        $.ajax({
            url: "edit",
            data: {
                "userId":userId,
                "userName": userName,
                "userPassword": userPassword,
                "userNickname": userNickname,
                "userGender": userGender,
                "userEmail": userEmail,
                "userPhone": userPhone,
                "departmentPid": departmentPid
            },
            success: function (data) {
                switch (data["success"]) {
                    case -1:
                        alert("用户名重复");
                        break;
                    case 0:
                        alert("编辑用户信息失败,请联系系统管理员查看日志");
                        break;
                    case 1:
                        alert("编辑用户信息成功");
                        location.href = "manage";
                        break;
                }
            }
        })
    }
    return false;
}


function checkAll() {
    if (checkUserName() && checkUserPassword() && checkUserPassword2() && checkUserNickname() && checkUserEmail() && checkUserPhone()) {
        return true;
    }
    return false;
}

function checkUserName() {
    let flag = false;
    if (userName.length == 0) {
        $("#userNameMessage").html("请输入用户名");
        $("#userNameMessage").removeClass("message");
        $("#userNameMessage").addClass("error");
        flag = false;
    } else {
        $("#userNameMessage").html("注:用户登录账号,只允许英文字母开头+数字");
        $("#userNameMessage").removeClass("error");
        $("#userNameMessage").addClass("message");
        flag = true;
    }
    return flag;
}

function checkUserPassword() {
    let flag = false;
    if (userPassword.length == 0) {
        $("#userPasswordMessage").html("请输入密码");
        $("#userPasswordMessage").addClass("error");
        flag = false;
    } else {
        $("#userPasswordMessage").html("");
        $("#userPasswordMessage").removeClass("error");
        flag = true;
    }
    return flag;
}

function checkUserPassword2() {
    let flag = false;
    if (userPassword2.length == 0) {
        $("#userPasswordMessage2").html("请再次输入密码");
        $("#userPasswordMessage2").addClass("error");
        flag = false;
    } else {
        $("#userPasswordMessage2").html("");
        $("#userPasswordMessage2").removeClass("error");
        flag = checkUserPassword3();
    }
    return flag;
}

function checkUserNickname() {
    let flag = false;
    if (userNickname.length == 0) {
        $("#userNicknameMessage").html("请输入昵称");
        $("#userNicknameMessage").addClass("error");
        flag = false;
    } else {
        $("#userNicknameMessage").html("");
        $("#userNicknameMessage").removeClass("error");
        flag = true;
    }
    return flag;
}

function checkUserEmail() {
    let flag = false;
    if (userEmail.length == 0) {
        $("#userEmailMessage").html("请输入邮箱地址");
        $("#userEmailMessage").addClass("error");
        flag = false;
    } else {
        $("#userEmailMessage").html("");
        $("#userEmailMessage").removeClass("error");
        flag = true;
    }
    return flag;
}

function checkUserPhone() {
    let flag = false;
    if (userPhone.length == 0) {
        $("#userPhoneMessage").html("请输入手机号码");
        $("#userPhoneMessage").addClass("error");
        flag = false;
    } else {
        $("#userPhoneMessage").html("");
        $("#userPhoneMessage").removeClass("error");
        flag = true;
    }
    return flag;
}

function checkUserPassword3() {
    let flag = false;
    if (userPassword != userPassword2) {
        $("#userPasswordMessage2").html("两次输入的密码不一致");
        $("#userPasswordMessage2").addClass("error");
        flag = false;
    } else {
        $("#userPasswordMessage2").html("");
        $("#userPasswordMessage2").removeClass("error");
        flag = true;
    }
    return flag;
}