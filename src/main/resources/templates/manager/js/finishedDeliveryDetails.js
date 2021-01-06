$(document).ready(function () {
    layui.use(['form', 'table'], function () {
        var $ = layui.jquery,
            form = layui.form,
            table = layui.table;

        //第一个实例
        table.render({
            elem: '#finishedDeliveryDetailsTableList',
            toolbar: '#toolbar',
            url: '/backstage/manager/finishedDeliveryDetails/data', //数据接口
            method: 'post',
            page: true, //开启分页
            cols: [
                [
                    {type: "checkbox", width: 50},
                    {field: 'deliveryDate', width: 120, title: '出库日期', sort: true},
                    {field: 'specification', width: 120, title: '规格型号', sort: true},
                    {field: 'blueIslandFinishedProductCode', width: 120, title: '蓝岸完品编码', sort: true},
                    {field: 'productName', width: 120, title: '产品名称', sort: true},
                    {field: 'orderNumberForJierong', width: 120, title: '给捷荣加工的订单号', sort: true},
                    {field: 'jierongDeliveryOrderNumber', width: 120, title: '捷容送货单号', sort: true},
                    {field: 'shipmentAmount', width: 120, title: '出货数量', sort: true},
                    {field: 'shipmentAddress', width: 120, title: '出货地址', sort: true},
                    {field: 'receiver', width: 120, title: '接货人', sort: true},
                    {field: 'remarks', width: 120, title: '备注', sort: true},
                    {title: '操作', minWidth: 150, toolbar: '#finishedDeliveryDetailsTableBar', align: "center"}
                ]
            ]
        });

        /**
         * toolbar监听事件
         */
        table.on('toolbar(finishedDeliveryDetailsTableFilter)', function (obj) {
            if (obj.event === 'add') {  // 监听添加操作
                //示范一个公告层
                layer.open({
                    type: 2//0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层)
                    , title: false //不显示标题栏
                    , closeBtn: false
                    , area: ['80%', '60%']//定义宽高
                    , shade: 0.8//遮幕
                    , id: 'LAY_layuipro' //设定一个id，防止重复弹出
                    , btn: ['确定', '取消']
                    , btnAlign: 'c'//按钮排列：居中对齐
                    , moveType: 1 //拖拽模式，0或者1
                    , content: '/backstage/manager/finishedDeliveryDetails/form/add'//跳转到想要的界面，这里是我自己项目的跳转界面
                    ,
                    btn1: function () {
                        alert("确定")
                    }
                    ,
                    btn2: function () {
                        alert("取消")
                    }

                })
            } else if (obj.event === 'delete') {  // 监听删除操作
                var checkStatus = table.checkStatus('finishedDeliveryDetailsTableList')
                    , data = checkStatus.data;
                layer.alert(JSON.stringify(data));
            } else if (obj.event === 'exportFile') {  // 监听导出操作
                downloadFile('/backstage/manager/finishedDeliveryDetails/export')
            } else if (obj.event === 'importFile') {  // 监听导入操作
                //弹出一个小框框，选择文件
                layer.open({
                    type: 2,
                    area: ['60%', '50%'],
                    auto: true,
                    title: "导入数据",
                    content: "/backstage/common/importHtml",
                    btn: ['下载模板', '确定', '关闭'],
                    btn1: function (index, layero) {
                        downloadFile('/backstage/manager/finishedDeliveryDetails/import/template');
                    },
                    btn2: function (index, layero) {
                        var iframeWin = layero.find('iframe')[0]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
                        iframeWin.contentWindow.importExcel('/backstage/manager/finishedDeliveryDetails/import', function (data) {
                            if (data.success) {
                                layer.success(data.msg);
                                refresh();
                            } else {
                                layer.error(data.msg);
                            }
                            layer.close(index);
                        });//调用保存事件
                        return false;
                    },

                    btn3: function (index) {
                        layer.close(index);
                    }
                });
            }
        });

        //表格数据工具栏监听器
        table.on('checkbox(finishedDeliveryDetailsTableFilter)', function (obj) {
            console.log(obj)
        });

        table.on('tool(finishedDeliveryDetailsTableFilter)', function (obj) {
            var data = obj.data;
            if (obj.event === 'follow') {

                var index = layer.open({
                    title: '追踪信息',
                    type: 2,
                    shade: 0.2,
                    maxmin: true,
                    shadeClose: true,
                    area: ['100%', '100%'],
                    content: '/backstage/page/table/edit.html',
                });
                $(window).on("resize", function () {
                    layer.full(index);
                });
                return false;
            } else if (obj.event === 'details') {
                layer.confirm('查看详情操作', function (index) {
                    obj.del();
                    layer.close(index);
                });
            }
        });
    });

    layui.use('laydate', function () {
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#deliveryDate', //指定元素
            type: 'datetime'
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#inComingMaterielDate', //指定元素
            type: 'datetime'
        });
    });
})