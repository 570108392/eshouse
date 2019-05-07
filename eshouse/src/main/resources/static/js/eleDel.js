/*
 * @Author: https://github.com/WangEn
 * @Author: https://gitee.com/lovetime/
 * @Date:   2018-03-27
 * @lastModify 2018-3-28
 * +----------------------------------------------------------------------
 * | WeAdmin 表格table中多个删除等操作公用js
 * | 有改用时直接复制到对应页面也不影响使用
 * +----------------------------------------------------------------------
 */
layui.extend({
	admin: '{/}../../static/js/admin'
});
layui.use(['laydate', 'jquery', 'admin','table'], function() {
	var laydate = layui.laydate,
		$ = layui.jquery,
        table = layui.table;
		admin = layui.admin;
	//执行一个laydate实例 即开始时间
	laydate.render({
		elem: '#start' //指定元素
	});
	//执行一个laydate实例 即结束时间
	laydate.render({
		elem: '#end' //指定元素
	});


	/*用户-停用*/
	window.member_stop = function (obj, id) {
		layer.confirm('确认要停用吗？', function(index) {
			if($(obj).attr('title') == '启用') {

				//发异步把用户状态进行更改
				$(obj).attr('title', '停用')
				$(obj).find('i').html('&#xe62f;');

				$(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已停用');
				layer.msg('已停用!', {
					icon: 5,
					time: 1000
				});

			} else {
				$(obj).attr('title', '启用')
				$(obj).find('i').html('&#xe601;');

				$(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
				layer.msg('已启用!', {
					icon: 5,
					time: 1000
				});
			}
		});
	}

	/*用户-删除*/
	window.member_del = function (obj, id) {
		layer.confirm('确认要删除吗？', function(index) {
			//发异步删除数据
			$(obj).parents("tr").remove();
			layer.msg('已删除!', {
				icon: 1,
				time: 1000
			});
		});
	}

	window.delAll = function (tableName,delUrl) {
        var checkStatus = table.checkStatus(tableName),
			data = checkStatus.data;
        $.ajax({
            url:delUrl,
            type:'post',//method请求方式，get或者post
            dataType:'json',//预期服务器返回的数据类型
            contentType: "application/json;charset=UTF-8",
            data:JSON.stringify(data),
            success:function(data){//res为相应体,function为回调函数
                if(data.status==200){
                    layer.alert(data.t,{icon:1});
                }else{
                    layer.alert(data.msg,{icon: 5});
                };
               table.reload(tableName,{page: {curr: 1 }});
            },
            error:function(){
                layer.alert("删除用户失败",{icon: 5});
                table.reload(tableName,{page: {curr: 1 }});
            }
        });
	}
});