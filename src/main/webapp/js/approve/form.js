$(function () {
    loadPageForAddOrEdit();
})

function loadPageForAddOrEdit() {
    let applyId = sessionStorage.getItem("applyId");
    if (applyId != null) {
        $("#applyPid").val(applyId);
        $.ajax({
            url: "../apply/"+applyId,
            type: "get",
            success: function (data) {
                console.log(data);
                $("#applyTitle").html(data["applyTitle"])
                $("#applyComment").html(data["applyComment"]);
                $("#applyDate").html(data["applyDate"]);
                $("#userNickname").html(data["user"]["userNickname"]);
                if (data["applyStatus"]==0){
                    $("#applyStatus").html("待审批");
                }else if (data["applyStatus"]==1){
                    $("#applyStatus").html("需上级审批");
                }
            }
        })
        $("button[type=button]").click(approve);
    }
}


function approve() {
        $.ajax({
            url: "./",
            type: "post",
            data: {
                "applyPid":$("#applyPid").val(),
                "approveComment":$("#approveComment").val(),
                "approveStatus":$("input[name=approveStatus]:checked").val(),
            },
            success: function (data) {
                if (data["success"]==2){
                    alert("审批完成");
                    location.href="manage";
                }
            }
        })
    return false;
}
