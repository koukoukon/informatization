var pageNum = 1;
var pageSize = 5;
var total;
$(function () {
    $.ajaxSetup({
        type: "post",
        dataType: "json",
    });
    $.ajax({
        url: "list",
        data: {
            "pageNum": pageNum,
            "pageSize": pageSize
        },
        success: function (data) {
            parseJson(data);
            loadPage();
        }
    })
    $("#checkAll").click(function () {
        if ($(this).prop("checked") == true) {
            $("#koko~tr>td>input[type=checkbox]").prop("checked", true);
            return;
        }
        $("#koko~tr>td>input[type=checkbox]").prop("checked", false);
    })
    $("#delete").click(function () {
        if ($("#koko~tr>td>input[type=checkbox]:checked").length > 0) {
            if (confirm("确定删除用户?")) {
                let array = [];
                $("#koko~tr>td>input[type=checkbox]:checked").each(function () {
                    array.push($(this).val());
                })
                let userIds = array.toString();

                $.ajax({
                    url: "delete",
                    data: {
                        "userIds": userIds
                    },
                    success: function (data) {
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
    $("#add").click(function () {
        location.href = "add";
    })
    $(document).on("click", ".edit", function () {
        let userId = $(this).attr("userId");
        sessionStorage.setItem("userId", userId);
        location.href = "edit";
    })


})

function loadPage() {
    $('ul.pagination').jqPaginator({
        totalCounts: total,
        pageSize: pageSize,
        onPageChange: function (num, type) {
            if (type == "change") {
                pageNum = num;
                $.ajax({
                    url: "list",
                    data: {
                        "pageNum": pageNum,
                        "pageSize": pageSize
                    },
                    success: function (data) {
                        parseJson(data);
                    }
                });
            }
        }
    });
}

function parseJson(data) {
    for (var i in data) {
        if (i == "users") {
            var html = "";
            for (var j in data[i]) {
                html += "<tr>";
                html += "<td style='text-align: center;vertical-align: middle'><input type='checkbox' value='" + data[i][j]["userId"] + "'></td>";
                html += "<td style='vertical-align: middle'>" + data[i][j]["userId"] + "</td>";
                html += "<td style='vertical-align: middle'>" + data[i][j]["userName"] + "</td>";
                html += "<td style='vertical-align: middle'>" + data[i][j]["userGender"] + "</td>";
                html += "<td style='vertical-align: middle'>" + data[i][j]["userPhone"] + "</td>";
                html += "<td style='vertical-align: middle'>" + data[i][j]["userNickname"] + "</td>";
                html += "<td style='vertical-align: middle'>" + data[i][j]["department"]["departmentName"] + "</td>";
                html += "<td style='vertical-align: middle'><button userId='" + data[i][j]["userId"] + "'type='button' class='btn btn-default glyphicon glyphicon-pencil edit'>修改</button>"
                html += "</tr>";
            }
            $("#koko~tr").remove();
            $(html).insertAfter("#koko");
        }
    }
    total = data["total"];
}