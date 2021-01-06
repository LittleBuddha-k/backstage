$(document).ready(function () {
    layui.use(['form', 'table'], function () {
        var $ = layui.jquery,
            form = layui.form,
            table = layui.table;

        //第一个实例
        table.render({
            elem: '#balanceDetailsTableList',
            toolbar: '#toolbar',
            url: '/backstage/manager/balanceDetails/data', //数据接口
            method: 'post',
            page: true, //开启分页
            cols: [
                [
                    {type: "checkbox", width: 50},
                    {field: 'serialNumber', width: 80, title: '序号', sort: true},
                    {field: 'testing', width: 80, title: '检测'},
                    {field: 'texy', width: 80, title: 'TEXY', sort: true},
                    {field: 'blueIslandMaterielNumber', width: 80, title: '蓝岸料号'},
                    {field: 'chineseName', title: '中文名称', minWidth: 150},
                    {field: 'supplier', width: 80, title: '供应商', sort: true},
                    {field: 'mFourHost', width: 80, title: 'M4主机', sort: true},
                    {field: 'mFourGoHost', width: 80, title: 'M4GO主机'},
                    {field: 'mFourFrontHousingAssembly', width: 135, title: 'M4前壳组件', sort: true},
                    {field: 'mFourRearHousingAssembly', width: 135, title: 'M4后壳组件', sort: true},
                    {field: 'mFourPackage', width: 135, title: 'M4包装', sort: true},
                    {field: 'mFourOrange', width: 135, title: 'M4 Orange', sort: true},
                    {field: 'mFourSFR', width: 135, title: 'M4-SFR', sort: true},
                    {field: 'mFourBYT', width: 135, title: 'M4-BYT', sort: true},
                    {field: 'mFourGoPackage', width: 135, title: 'M4 go包装', sort: true},
                    {field: 'mFourFrontHousingAssemblySecond', width: 135, title: '前壳组件', sort: true},
                    {field: 'mFourMainBoardPackage', width: 135, title: '主板包装', sort: true},
                    {field: 'mFourGoMainBoardPackage', width: 135, title: 'm4GO主板包装', sort: true},
                    {field: 'smallBoardPackaging', width: 135, title: '小板包装', sort: true},
                    {field: 'batteryPackaging', width: 135, title: '电池包装', sort: true},
                    {field: 'intoOperation', width: 135, title: '已投产', sort: true},
                    {field: 'notIntoOperation', width: 135, title: '未投产', sort: true},
                    {field: 'lackOfMaterial', width: 135, title: '欠料', sort: true},
                    {field: 'lackOfMaterialGroup', width: 135, title: '欠料（Group）', sort: true},
                    {field: 'newJersey', width: 135, title: '新泽森', sort: true},
                    {field: 'blueIsland', width: 135, title: '蓝岸', sort: true},
                    {field: 'difference', width: 135, title: '差异', sort: true},
                    {title: '操作', minWidth: 150, toolbar: '#balanceDetailsTableBar', align: "center"}
                ]
            ]
        });

        /**
         * toolbar监听事件
         */
        table.on('toolbar(balanceDetailsTableFilter)', function (obj) {
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
                    , content: '/backstage/manager/balanceDetails/form/add'//跳转到想要的界面，这里是我自己项目的跳转界面
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
                var checkStatus = table.checkStatus('balanceDetailsTableList')
                    , data = checkStatus.data;
                layer.alert(JSON.stringify(data));
            } else if (obj.event === 'exportFile') {  // 监听导出操作
                downloadFile('/backstage/manager/balanceDetails/export')
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
                        downloadFile('/backstage/manager/balanceDetails/import/template');
                    },
                    btn2: function (index, layero) {
                        var iframeWin = layero.find('iframe')[0]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
                        iframeWin.contentWindow.importExcel('/backstage/manager/balanceDetails/import', function (data) {
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
        table.on('checkbox(balanceDetailsTableFilter)', function (obj) {
            console.log(obj)
        });

        table.on('tool(balanceDetailsTableFilter)', function (obj) {
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