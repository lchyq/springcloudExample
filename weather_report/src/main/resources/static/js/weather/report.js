/*
* 下拉列表触发事件
* */
$(function () {
    $("#selectId").CHANGE(function () {
        var cityId = $("#selectId").val();
        var url = '/report/cityId/'+cityId;
        Window.location.href = url;
    })
});