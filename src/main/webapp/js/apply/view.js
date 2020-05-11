var applyId;
$(function () {
    loadPageForAddOrEdit();
    loadApproveRecord();
})

function loadPageForAddOrEdit() {
    applyId = sessionStorage.getItem("applyId");
    if (applyId != null) {
        $("#applyPid").val(applyId);
        $.ajax({
            url: applyId,
            type: "get",
            success: function (data) {
                $("#applyTitle").html(data["applyTitle"])
                $("#applyComment").html(data["applyComment"]);
                $("#applyDate").html(data["applyDate"]);
                $("#userNickname").html(data["user"]["userNickname"]);
                if (data["applyStatus"] == 0) {
                    $("#applyStatus").html("待审批");
                } else if (data["applyStatus"] == 1) {
                    $("#applyStatus").html("需上级审批");
                }else if (data["applyStatus"] == -1){
                    $("#applyStatus").html("已同意");
                }
            }
        })
        $("button[type=button]").click(approve);
    }
}

function loadApproveRecord() {
    $.ajax({
        url: "../approve",
        type: "get",
        data: {
            "applyPid": applyId
        },
        success: function (data) {
            if (data!=null){
                console.log(data);
                let html = "";
                for (var i in data){
                    html += "<tr>";
                    html += "<td style='vertical-align: middle;text-align: center'>" + data[i]["approveComment"] + "</td>";
                    html += "<td style='vertical-align: middle'>" + data[i]["approveDate"] + "</td>";
                    html += "<td style='vertical-align: middle'>" + data[i]["user"]["userNickname"] + "</td>";
                    html += "<td style='vertical-align: middle'>" + data[i]["approveStatus"] + "</td>";
                    html += "</tr>";
                }
                $(html).insertAfter("#koko");
            }
        }
    })
}


function approve() {
    $.ajax({
        url: "./",
        type: "post",
        data: {
            "applyPid": $("#applyPid").val(),
            "approveComment": $("#approveComment").val(),
            "approveStatus": $("input[name=approveStatus]:checked").val(),
        },
        success: function (data) {
            if (data["success"] == 2) {
                alert("审批完成");
                location.href = "manage";
            }
        }
    })
    return false;
}
