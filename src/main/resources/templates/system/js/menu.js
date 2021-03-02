$(document).ready(function () {
    layui.use(['table', 'treetable'], function () {
        var $ = layui.jquery;
        var table = layui.table;
        var treetable = layui.treetable;

        //menu树形表格
        layer.load(2);
        treetable.render({
            treeColIndex: 1,
            treeSpid: -1,
            treeIdName: 'authorityId',
            treePidName: 'parentId',
            elem: '#menuTableList',
            url: '/backstage/layui/api/menus.json',
            page: false,
            cols: [
                [
                    {
                        type: "checkbox",
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
                        field: 'parent',
                        width: 150,
                        title: '父节点',
                        sort: true
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
                        title: '操作',
                        minWidth: 150,
                        toolbar: '#menuTableBar',
                        align: "center"
                    }
            ]
            ],
            done: function () {
                layer.closeAll('loading');
            }
        });
    });

})