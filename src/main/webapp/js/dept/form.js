var departmentNum;
$(function () {
    loadPageForAddOrEdit();
    $("#departmentNum").change(changeDeptNum);
})

function loadPageForAddOrEdit() {
    //如果当前地址栏结尾不是edit则
    if (!location.href.endsWith("edit")) {
        sessionStorage.removeItem("deptId");
    }
    let deptId = sessionStorage.getItem("deptId");

    if (deptId != null) {
        $("ol>li.active").html("编辑部门");
        $("button[type=submit]").html("确认编辑")
        $.ajax({
            url: deptId,
            type: "get",
            success: function (data) {
                $("#departmentId").val(data["departmentId"]);
                $("#departmentName").val(data["departmentName"]);
                $("#departmentComment").val(data["departmentComment"]);
                $("#departmentNum").val(data["departmentNum"]);
                departmentNum = data["departmentNum"];
            }
        })
        $("button[type=button]").click(editDept);
    } else {
        $("button[type=button]").click(addDept);
    }
}


function addDept() {
    let departmentName = $("#departmentName").val();
    let departmentComment = $("#departmentComment").val();
    let departmentNum = $("#departmentNum").val();
    if (changeDeptNum){
        $.ajax({
            url: "./",
            type: "post",
            data: {
                "departmentName": departmentName,
                "departmentComment": departmentComment,
                "departmentNum": departmentNum
            },
            success: function (data) {
                switch (data["success"]) {
                    case -1:
                        alert("部门名称或部门编号重复");
                        break;
                    case 0:
                        alert("添加部门失败,请联系系统管理员查看日志");
                        break;
                    case 1:
                        alert("添加部门成功");
                        location.href = "manage";
                        break;
                }
            }
        })
    }
    return false;
}

function editDept() {
    if (changeDeptNum){

        $.ajax({
            url: "./",
            type: "post",
            data: {
                "_method": "PUT",
                "departmentId": $("#departmentId").val(),
                "departmentName": $("#departmentName").val(),
                "departmentComment": $("#departmentComment").val(),
                "departmentNum": $("#departmentNum").val()
            },
            success: function (data) {
                switch (data["success"]) {
                    case -1:
                        alert("部门名称或部门编号重复");
                        break;
                    case 0:
                        alert("编辑部门失败,请联系系统管理员查看日志");
                        break;
                    case 1:
                        alert("编辑部门成功");
                        location.href = "manage";
                        break;
                }
            }
        })
    }
    return false;
}
function changeDeptNum() {
    let flag = false;
    if ($(this).val()==departmentNum){
        $("#departmentNumMessage").removeClass("error");
        $("#departmentNumMessage").addClass("message");
        $("#departmentNumMessage").html("");
        flag = true;
    }else {
        $.ajax({
            url:"countNum",
            type:"get",
            dataType:"json",
            data:{
                "departmentNum":$(this).val()
            },
            success:function (data) {
                if (data["success"]==0){
                    $("#departmentNumMessage").removeClass("error");
                    $("#departmentNumMessage").addClass("message");
                    $("#departmentNumMessage").html("");
                    flag = true;
                }else if (data["success"]>0){
                    $("#departmentNumMessage").removeClass("message");
                    $("#departmentNumMessage").addClass("error");
                    $("#departmentNumMessage").html("部门编号重复,请更换");
                    flag = false;
                }
            }
        })
    }
    return flag;
}
