$(document).ready(function () {
    layui.use(['form', 'table'], function () {
        var $ = layui.jquery,
            form = layui.form,
            table = layui.table;

        //第一个实例
        table.render({
            elem: '#twoColorBallTableList',
            toolbar: '#toolbar',
            defaultToolbar: ['filter', 'print', {
                title: '提示' //标题
                , layEvent: 'LAYTABLE_TIPS' //事件名，用于 toolbar 事件中使用
                , icon: 'layui-icon-tips' //图标类名
            }],
            url: '/backstage/luckyLottery/twoColorBall/data', //数据接口
            method: 'post',
            request: {
                pageName: 'pageNumber', //页码的参数名称，默认：page
                limitName: 'pageSize' //每页数据量的参数名，默认：limit
            },
            page: true, //开启分页
            cols: [
                [
                    {
                        type: "checkbox",
                        width: 50
                    },
                    {
                        field: 'issueNumber',
                        width: 200,
                        title: '期號',
                        sort: true
                    },
                    {
                        field: 'redOne',
                        width: 150,
                        title: '一號紅球',
                        sort: true
                    },
                    {
                        field: 'redTwo',
                        width: 150,
                        title: '二號紅球',
                        sort: true
                    },
                    {
                        field: 'redThree',
                        width: 200,
                        title: '三號紅球',
                        sort: true
                    },
                    {
                        field: 'redFour',
                        width: 150,
                        title: '四號紅球',
                        sort: true
                    },
                    {
                        field: 'redFive',
                        width: 150,
                        title: '五號紅球',
                        sort: true
                    },
                    {
                        field: 'redSix',
                        width: 150,
                        title: '六號紅球',
                        sort: true
                    },
                    {
                        field: 'blueBall',
                        width: 150,
                        title: '蓝球',
                        sort: true
                    },
                    {
                        field: 'happySunday',
                        width: 150,
                        title: '歡樂星期天',
                        sort: true
                    },
                    {
                        field: 'bonusPool',
                        width: 150,
                        title: '獎池獎金',
                        sort: true
                    },
                    {
                        field: 'firstPrizeWinningCount',
                        width: 150,
                        title: '中奖数',
                        sort: true
                    },
                    {
                        field: 'firstPrizeBonus',
                        width: 150,
                        title: '奖金',
                        sort: true
                    },
                    {
                        field: 'secondPrizeWinningCount',
                        width: 150,
                        title: '中奖数',
                        sort: true
                    },
                    {
                        field: 'secondPrizeBonus',
                        width: 150,
                        title: '奖金',
                        sort: true
                    },
                    {
                        field: 'totalBetsMoney',
                        width: 150,
                        title: '縂投注額',
                        sort: true
                    },
                    {
                        field: 'drawDate',
                        width: 150,
                        title: '開獎日期',
                        sort: true,
                        templet: function (twoColorBall) {
                            return dateTimeFormat(twoColorBall.drawDate);
                        }
                    },
                    {
                        title: '操作',
                        minWidth: 150,
                        toolbar: '#twoColorBallTableBar',
                        align: "center"
                    }
                ]
            ]
        });

        /**
         * toolbar监听事件
         */
        table.on('toolbar(twoColorBallTableFilter)', function (obj) {
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
                    , content: '/backstage/luckyLottery/twoColorBall/form/add'//跳转到想要的界面，这里是我自己项目的跳转界面
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
                var checkStatus = table.checkStatus('twoColorBallTableList')
                    , data = checkStatus.data;
                layer.alert(JSON.stringify(data));
            } else if (obj.event === 'exportFile') {  // 监听导出操作
                downloadFile('/backstage/luckyLottery/twoColorBall/export')
            } else if (obj.event === 'importFile') {  // 监听导入操作
                //弹出一个小框框，选择文件
                layer.open({
                    type: 2,
                    area: ['60%', '50%'],
                    auto: true,
                    title: "导入数据",
                    content: "/backstage/base/importHtml",
                    btn: ['下载模板', '确定', '关闭'],
                    btn1: function (index, layero) {
                        downloadFile('/backstage/luckyLottery/twoColorBall/import/template');
                    },
                    btn2: function (index, layero) {
                        var iframeWin = layero.find('iframe')[0]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
                        iframeWin.contentWindow.importExcel('/backstage/luckyLottery/twoColorBall/import', function (data) {
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
        table.on('checkbox(twoColorBallTableFilter)', function (obj) {
            console.log(obj)
        });

        table.on('tool(twoColorBallTableFilter)', function (obj) {
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

        // 监听搜索操作
        form.on('submit(data-search-btn)', function (data) {
            var result = JSON.stringify(data.field);
            layer.alert(result, {
                title: '最终的搜索信息'
            });
            //执行搜索重载
            table.reload('currentTableId', {
                page: {
                    curr: 1
                }
                , where: {
                    searchParams: result
                }
            }, 'data');

            return false;
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