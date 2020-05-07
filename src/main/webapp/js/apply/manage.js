var pageNum = 0;
var pageSize = 5;
var pages;
$(function () {
    $("#checkAll").click(function () {
        if ($(this).prop("checked") == true) {
            $("#koko~tr>td>input[type=checkbox]").prop("checked", true);
            return;
        }
        $("#koko~tr>td>input[type=checkbox]").prop("checked", false);
    })
    $("#add").click(function () {
        location.href = "add";
    })
    $("#delete").click(function () {
        if ($("#koko~tr>td>input[type=checkbox]:checked").length > 0) {
            if (confirm("确定删除所选中的部门?")) {
                let array = [];
                $("#koko~tr>td>input[type=checkbox]:checked").each(function () {
                    array.push($(this).val());
                })
                let deptIds = array.toString();

                $.ajax({
                    url: "./",
                    type: "post",
                    data: {
                        "_method": "DELETE",
                        "deptIds": deptIds,
                    },
                    success:function (data) {
                        if (data["success"] >= 1) {
                            alert("删除了" + data["success"] + "条数据");
                            location.reload();
                        } else {
                            alert("删除失败,请联系系统管理员查看服务器日志");
                        }

                    }
                })
            }
        } else {
            alert("还没选呢~")
        }
    })
})
