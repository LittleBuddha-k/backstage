$(document).ready(function () {
    layui.use(['form', 'table'], function () {
        var $ = layui.jquery,
            form = layui.form,
            table = layui.table;

        //第一个实例
        table.render({
            elem: '#summaryConsiderBomDetailsTableList',
            toolbar: '#toolbar',
            url: '/backstage/manager/summaryConsiderBomDetails/data', //数据接口
            method: 'post',
            page: true, //开启分页
            cols: [
                [
                    {type: "checkbox", width: 50},
                    {field: 'testing', width: 120, title: '检测', sort: true},
                    {field: 'serialNumber', width: 120, title: '序号', sort: true},
                    {field: 'blueIslandMaterielNumber', width: 120, title: '蓝岸料号', sort: true},
                    {field: 'supplierMaterielNumber', width: 120, title: '供应商料号编码', sort: true},
                    {field: 'description', width: 120, title: '描述', sort: true},
                    {field: 'supplier', width: 120, title: '供应商', sort: true},
                    {field: 'dosageOfPlus', width: 120, title: 'plus用量', sort: true},
                    {field: 'dosageOfLite', width: 120, title: 'lite用量', sort: true},
                    {field: 'supplierGoodProducts', width: 120, title: '厂商来料良品', sort: true},
                    {field: 'supplierBadProducts', width: 120, title: '厂商来料不良', sort: true},
                    {field: 'supplierReturnGoods', width: 120, title: '厂商退料', sort: true},
                    {field: 'outWarehouse', width: 120, title: '其他出库', sort: true},
                    {field: 'delivery', width: 120, title: '交货数量汇总', sort: true},
                    {field: 'theoreticallyUsefully', width: 120, title: '理论可用数量汇总', sort: true},
                    {field: 'actuallyUsefully', width: 120, title: '可用套数', sort: true},
                    {field: 'orderAmount', width: 120, title: '下单数量', sort: true},
                    {field: 'unpaidAmount', width: 120, title: '订单未交', sort: true},
                    {field: 'replies', width: 120, title: '交期回复', sort: true},
                    {title: '操作', minWidth: 150, toolbar: '#summaryConsiderBomDetailsTableBar', align: "center"}
                ]
            ]
        });

        /**
         * toolbar监听事件
         */
        table.on('toolbar(summaryConsiderBomDetailsTableFilter)', function (obj) {
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
                    , content: '/backstage/manager/summaryConsiderBomDetails/form/add'//跳转到想要的界面，这里是我自己项目的跳转界面
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
                var checkStatus = table.checkStatus('summaryConsiderBomDetailsTableList')
                    , data = checkStatus.data;
                layer.alert(JSON.stringify(data));
            } else if (obj.event === 'exportFile') {  // 监听导出操作
                downloadFile('/backstage/manager/summaryConsiderBomDetails/export')
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
                        downloadFile('/backstage/manager/summaryConsiderBomDetails/import/template');
                    },
                    btn2: function (index, layero) {
                        var iframeWin = layero.find('iframe')[0]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
                        iframeWin.contentWindow.importExcel('/backstage/manager/summaryConsiderBomDetails/import', function (data) {
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
        table.on('checkbox(summaryConsiderBomDetailsTableFilter)', function (obj) {
            console.log(obj)
        });

        table.on('tool(summaryConsiderBomDetailsTableFilter)', function (obj) {
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