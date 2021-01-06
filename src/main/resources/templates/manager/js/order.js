$(document).ready(function () {
    layui.use(['form', 'table'], function () {
        var $ = layui.jquery,
            form = layui.form,
            table = layui.table;

        //第一个实例
        table.render({
            elem: '#orderTableList',
            toolbar: '#toolbar',
            url: '/backstage/manager/order/data', //数据接口
            method: 'post',
            page: true, //开启分页
            cols: [
                [
                    {type: "checkbox", width: 50},
                    {field: 'newOrderNumber', width: 80, title: '新订单号', sort: true},
                    {field: 'orderNumber', width: 80, title: '订单编号'},
                    {field: 'supplier', width: 80, title: '供应商', sort: true},
                    {field: 'projectName', width: 80, title: '项目名'},
                    {field: 'materielNumber', title: '蓝岸料号', minWidth: 150},
                    {field: 'materielNumberSort', width: 80, title: '蓝岸料号格式', sort: true},
                    {field: 'materielName', width: 80, title: '物料名称', sort: true},
                    {field: 'specifications', width: 80, title: '规格'},
                    {field: 'description', width: 135, title: '描述', sort: true},
                    {field: 'brand', width: 135, title: '品牌', sort: true},
                    {field: 'unit', width: 135, title: '单位', sort: true},
                    {field: 'orderAmount', width: 135, title: '下单数量', sort: true},
                    {field: 'unitPrice', width: 135, title: '单价', sort: true},
                    {field: 'currency', width: 135, title: '币种', sort: true},
                    {field: 'totalAmount', width: 135, title: '总金额', sort: true},
                    {field: 'orderDate', width: 135, title: '下单日期', sort: true},
                    {field: 'deliveryDate', width: 135, title: '交期', sort: true},
                    {field: 'deliveredAmount', width: 135, title: '已交货数量', sort: true},
                    {field: 'inWarehousingDate', width: 135, title: '入库日期', sort: true},
                    {field: 'undeliveredAmount', width: 135, title: '未交货数量', sort: true},
                    {field: 'firstPartyRemarks', width: 135, title: '备注', sort: true},
                    {field: 'reconciledAmount', width: 135, title: '已对帐数量', sort: true},
                    {field: 'noReconciliation', width: 135, title: '未对帐数量', sort: true},
                    {field: 'paymentStatus', width: 135, title: '付款情况', sort: true},
                    {field: 'paymentWay', width: 135, title: '付款方式', sort: true},
                    {field: 'theCorrespondingHuman.name', width: 135, title: '对应人', sort: true},
                    {field: 'secondPartyRemarks', width: 135, title: '备注', sort: true},
                    {title: '操作', minWidth: 150, toolbar: '#orderTableBar', align: "center"}
                ]
            ]
        });

        /**
         * toolbar监听事件
         */
        table.on('toolbar(orderTableFilter)', function (obj) {
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
                    , content: '/backstage/manager/order/form/add'//跳转到想要的界面，这里是我自己项目的跳转界面
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
                var checkStatus = table.checkStatus('orderTableList')
                    , data = checkStatus.data;
                layer.alert(JSON.stringify(data));
            } else if (obj.event === 'exportFile') {  // 监听导出操作
                downloadFile('/backstage/manager/order/export')
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
                        downloadFile('/backstage/manager/order/import/template');
                    },
                    btn2: function (index, layero) {
                        var iframeWin = layero.find('iframe')[0]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
                        iframeWin.contentWindow.importExcel('/backstage/manager/order/import', function (data) {
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
        table.on('checkbox(orderTableFilter)', function (obj) {
            console.log(obj)
        });

        table.on('tool(orderTableFilter)', function (obj) {
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