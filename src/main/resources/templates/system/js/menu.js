$(document).ready(function () {
    layui.use(['table', 'treetable'], function () {
        var $ = layui.jquery;
        var table = layui.table;
        var treetable = layui.treetable;

        //menu树形表格
        treetable.render({
            treeColIndex: 1,
            treeSpid: -1,
            treeIdName: 'id',
            treePidName: 'parentId',
            elem: '#menuTableList',
            url: '/backstage/system/menu/data',
            toolbar: '#toolbar',
            page: false,
            cols: [
                [
                    {
                        type: "numbers",
                        width: 50
                    },
                    {
                        field: 'title',
                        width: 200,
                        title: '菜单名字',
                        sort: true
                    },
                    {
                        field: 'icon',
                        width: 150,
                        title: '图标',
                        sort: true
                    },
                    {
                        field: 'href',
                        width: 150,
                        title: '路径',
                        sort: true
                    },
                    {
                        field: 'target',
                        width: 200,
                        title: '目标',
                        sort: true
                    },
                    {
                        field: 'hasChildren',
                        width: 150,
                        title: '是否有子节',
                        sort: true
                    },
                    {
                        field: 'sort',
                        width: 150,
                        title: '排序',
                        sort: true
                    },
                    {
                        field: 'parent.id',
                        width: 150,
                        title: '父节点',
                        sort: true,
                        templet: function (menu) {
                            return menu.parent.id;
                        }
                    },
                    {
                        field: 'parentIds',
                        width: 150,
                        title: '所有父节点',
                        sort: true
                    },
                    {
                        field: 'showFlag',
                        width: 150,
                        title: '是否展示',
                        sort: true
                    },
                    {
                        field: 'type',
                        width: 150,
                        title: '类型',
                        sort: true
                    },
                    {
                        field: 'permission',
                        width: 150,
                        title: '权限标识',
                        sort: true
                    },
                    {
                        templet: '#menuTableBar',
                        width: 400,
                        align: 'center',
                        title: '操作'}
                ]
            ],
            done: function () {

            }
        });

        //监听工具条
        table.on('tool(menuTableList)', function (obj) {
            var data = obj.data;
            var layEvent = obj.event;

            if (layEvent === 'addChild') {
                layer.msg('删除' + data.id);
            } else if (layEvent === 'edit') {
                layer.msg('修改' + data.id);
            }
        });
    });
})

$("#add").click(function () {
    openSaveDialog("菜单表单","/backstage/system/menu/form/add","60%","60%")
})