var pageNum = 0;
var pageSize = 5;
var pages;
$(function () {
    $.ajax({
        url: "./",
        type: "get",
        dataType: "json",
        data: {
            "pageNum": pageNum
        },
        success: function (data) {
            parseJson(data)
            loadPage();
        }
    });
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
function loadPage() {
    $('ul.pagination').jqPaginator({
        totalPages: pages,
        pageSize: pageSize,
        onPageChange: function (num, type) {
            if (type == "change") {
                pageNum = num;
                $.ajax({
                    url: "./",
                    type: "get",
                    dataType: "json",
                    data: {
                        "pageNum": pageNum
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
    for (var i in data){
        if (i == "applys") {
            var html = "";
            for (var j in data[i]) {
                console.log(data[i][j]);
                html += "<tr>";
                html += "<td style='text-align: center;vertical-align: middle'><input type='checkbox' value='" + data[i][j]["applyId"] + "'></td>";
                html += "<td style='vertical-align: middle'>" + data[i][j]["applyId"] + "</td>";
                html += "<td style='vertical-align: middle'>" + data[i][j]["user"]["userNickname"] + "</td>";
                html += "<td style='vertical-align: middle'>" + data[i][j]["applyTitle"] + "</td>";
                html += "<td style='vertical-align: middle'>" + data[i][j]["applyDate"] + "</td>";
                html += "<td style='vertical-align: middle'><button deptId='" + data[i][j]["applyId"] + "'type='button' class='btn btn-default glyphicon glyphicon-pencil edit'>修改</button>"
                html += "</tr>";
            }
            $("#koko~tr").remove();
            $(html).insertAfter("#koko");
        } else if (i == "pages") {
            pages = data["pages"]
        }
    }
}
