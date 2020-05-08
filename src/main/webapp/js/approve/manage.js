var pageNum = 0;
var pageSize = 5;
var pages;
$(function () {
    $.ajax({
        url: "../apply",
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
    $(document).on("click", ".edit", function () {
        let applyId = $(this).attr("applyId");
        sessionStorage.setItem("applyId", applyId);
        location.href = "edit";
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
                    url: "../apply",
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
                html += "<tr>";
                html += "<td style='vertical-align: middle'>" + data[i][j]["applyId"] + "</td>";
                html += "<td style='vertical-align: middle'>" + data[i][j]["user"]["userNickname"] + "</td>";
                html += "<td style='vertical-align: middle'>" + data[i][j]["applyTitle"] + "</td>";
                html += "<td style='vertical-align: middle'>" + data[i][j]["applyDate"] + "</td>";
                html += "<td style='vertical-align: middle'><button applyId='" + data[i][j]["applyId"] + "'type='button' class='btn btn-default glyphicon glyphicon-pencil edit'>审批</button>"
                html += "</tr>";
            }
            $("#koko~tr").remove();
            $(html).insertAfter("#koko");
        } else if (i == "pages") {
            pages = data["pages"]
        }
    }
}
