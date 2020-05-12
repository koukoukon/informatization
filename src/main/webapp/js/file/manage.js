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
    for (var i in data) {

        if (i == "userFiles") {
            var html = "";
            for (var j in data[i]) {
                html += "<tr>";
                html += "<td style='text-align: center;vertical-align: middle'><input type='checkbox' value='" + data[i][j]["userFileId"] + "'></td>";
                html += "<td style='vertical-align: middle'>" + data[i][j]["userFileId"] + "</td>";
                html += "<td style='vertical-align: middle'>" + data[i][j]["userFileName"] + "</td>";
                html += "<td style='vertical-align: middle'>" + data[i][j]["userFileTitle"] + "</td>";
                html += "<td style='vertical-align: middle'>" + data[i][j]["userFileComment"] + "</td>";
                html += "<td style='vertical-align: middle'>" + data[i][j]["userFileDate"] + "</td>";
                html += "<td style='vertical-align: middle'>" + data[i][j]["user"]["userNickname"] + "</td>";
                html += "<td style='vertical-align: middle'>" + data[i][j]["department"]["departmentName"] + "</td>";
                html += "<td style='vertical-align: middle'><button userFileId='" + data[i][j]["userFileId"] + "'type='button' class='btn btn-default glyphicon glyphicon-pencil edit'>编辑</button>"
                html += "</tr>";
            }
            $("#koko~tr").remove();
            $(html).insertAfter("#koko");
        } else if (i == "pages") {
            pages = data["pages"]
        }
    }
}