$(document).ready(function () {
    layui.use(['form', 'table'], function () {
        var $ = layui.jquery,
            form = layui.form,
            table = layui.table;

        table.render({
            elem: '#deliveryPlanTableList',
            cols: [
                [
                    {
                        type: "checkbox",
                        width: 50
                    },
                    {
                        field: 'deliveryDate',
                        width: 80,
                        title: '交货日期',
                        sort: true
                    },
                    {
                        field: 'deliveryAmount',
                        width: 120,
                        title: '交货数量',
                        sort: true
                    },
                    {
                        field: 'cumulativeDeliveryAmount',
                        width: 120,
                        title: '累计交货数量',
                        sort: true
                    },
                    {
                        field: 'inComingMaterielDate',
                        width: 120,
                        title: '进料日期',
                        sort: true
                    },
                    {
                        field: 'giftBoxAmount',
                        width: 120,
                        title: '礼盒配套数',
                        sort: true
                    },
                    {
                        field: 'cumulativeGiftBoxAmount',
                        width: 120,
                        title: '累计礼盒配套数',
                        sort: true
                    },
                    {
                        field: 'cartonAmount',
                        width: 120,
                        title: '纸箱数',
                        sort: true
                    },
                    {
                        field: 'paperSeparatorAmount',
                        width: 120,
                        title: '纸隔板数',
                        sort: true
                    },
                    {
                        field: 'cumulativePaperSeparatorAmount',
                        width: 120,
                        title: '累计纸隔板数',
                        sort: true
                    },
                    {
                        field: 'deliveryType',
                        width: 120,
                        title: '交货类型',
                        sort: true
                    },
                    {
                        title: '操作',
                        minWidth: 150,
                        toolbar: '#deliveryPlanTableBar',
                        align: "center"
                    }
                ]
            ],
            url: '/backstage/manager/deliveryPlan/data',
            method: 'post',
            contentType: 'application/json',
            where: {
                deliveryAmount: ,
                cumulativeDeliveryAmount: 123,
                giftBoxAmount: 123,
                cumulativeGiftBoxAmount: 123,
                cartonAmount: 123,
                paperSeparatorAmount: 123,
                cumulativePaperSeparatorAmount: 123,
                deliveryType: 123,
            },
            toolbar: '#toolbar',//添加表格工具栏模板
            defaultToolbar: ['filter', 'exports', 'print', {
                title: '提示',
                layEvent: 'LAYTABLE_TIPS',
                icon: 'layui-icon-tips'
            }],
            done: function(){

            },
            page: true,//开启分页,
            limit: 10,
            limits: [10, 15, 20, 25, 50, 100],
            title: '交货计划表格',
            text: {
                none: '暂无相关数据' //默认：无数据。
            },
            skin: 'line'
        });

        // 监听搜索操作
        form.on('submit(data-search-btn)', function (data) {
            //执行搜索重载
            table.reload('deliveryPlanTableList', {
                url: '/backstage/manager/deliveryPlan/data',
                where: //设定异步数据接口的额外参数，任意设
                    {
                        deliveryAmount:$("#deliveryAmount").val()
                    }
                , page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
        });

        /**
         * toolbar监听事件
         */
        table.on('toolbar(currentTableFilter)', function (obj) {
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
                    , content: '/backstage/manager/deliveryPlan/form/add'//跳转到想要的界面，这里是我自己项目的跳转界面
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
                var checkStatus = table.checkStatus('deliveryPlanTableList')
                    , data = checkStatus.data;
                layer.alert(JSON.stringify(data));
            } else if (obj.event === 'exportFile') {  // 监听导出操作
                downloadFile('/backstage/manager/deliveryPlan/export')
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
                        downloadFile('/backstage/manager/deliveryPlan/import/template');
                    },
                    btn2: function (index, layero) {
                        var iframeWin = layero.find('iframe')[0]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
                        iframeWin.contentWindow.importExcel('/backstage/manager/deliveryPlan/import', function (data) {
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
        table.on('checkbox(currentTableFilter)', function (obj) {
            console.log(obj)
        });

        table.on('tool(currentTableFilter)', function (obj) {
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