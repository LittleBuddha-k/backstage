//打开对话框(添加修改)
function openSaveDialog(title,url,width,height) {
    var auto = true;//是否使用响应式，使用百分比时，应设置为false
    if (width.indexOf("%") >= 0 || height.indexOf("%") >= 0) {
        auto = false;
    }
    top.layer.open({
        type: 2,
        area: [width, height],
        title: title,
        auto: auto,
        maxmin: true, //开启最大化最小化按钮
        content: url,
        btn: ['确定', '关闭'],
        yes: function (index, layero) {
            var iframeWin = layero.find('iframe')[0]; //得到弹出的窗口对象，执行窗口内iframe页的方法：iframeWin.method();
            iframeWin.contentWindow.save();//调用保存事件，在 弹出页内，需要定义save方法。处理保存事件。
        },
        cancel: function (index) {
        }
    });
};

function downloadFile(url, name) {
    var $a = $("<a></a>").attr("href", url).attr("download", name);
    $a[0].click();
}

//时间格式化
function dateTimeFormat(time){
    if(typeof(time)=="undefined"){
        return "";
    }
    var oDate = new Date(time),
        oYear = oDate.getFullYear(),
        oMonth = oDate.getMonth()+1,
        oDay = oDate.getDate(),
        oHour = oDate.getHours(),
        oMin = oDate.getMinutes(),
        oSen = oDate.getSeconds(),
        oTime = oYear +'-'+ addZero(oMonth) +'-'+ addZero(oDay) +' '+ addZero(oHour) +':'+ addZero(oMin) +':'+addZero(oSen);//最后拼接时间

    return oTime;
};

//补0操作,当时间数据小于10的时候，给该数据前面加一个0
function addZero(num){
    if(parseInt(num) < 10){
        num = '0'+num;
    }
    return num;
};

