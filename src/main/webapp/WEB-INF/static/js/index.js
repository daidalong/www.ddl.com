$(function() {
	//getAll();
});

function get() {
	var mobile = $("#mphone").val();
	var url = "/user/get";
	var data = {}
	data.mobile = mobile;
	$.ajax({
		type : "POST",
		url : url,
		dataType : 'json',
		data : data,
		success : function(res) {

			var code = res.code;
			if (code > 0) {
				alert(res.msg);
				return false;
			}
			var data = res.data;
			var info = '';
		
			info += '<tr>';
			info += '<td>' + data.id + '</td>';
			info += '<td>' + data.name + '</td>';
			info += '<td>' + data.mobile + '</td>';
			info += '<td>' + data.dateStr + '</td>';
			info += '</tr>';

			var old = $("table").html();
			$("table").html(old + info);

		}
	});

}

function getAll() {
	var url = "/user/get-list";

	$.ajax({
		type : "POST",
		url : url,
		dataType : 'json',
		data : {},
		contentType : "application/json; charset=utf-8",
		success : function(res) {
			var code = res.code;
			if (code > 0) {
				alert(res.msg);
				return false;
			}
			var data = res.data;
			var info = '';
			info += '<tr>';
			info += '<td>ID</td>';
			info += '<td>用户名</td>';
			info += '<td>电话号</td>';
			info += '<td>创建时间</td>';
			info += '</tr>';
			for ( var i in data) {
				info += '<tr>';
				info += '<td>' + data[i].id + '</td>';
				info += '<td>' + data[i].name + '</td>';
				info += '<td>' + data[i].mobile + '</td>';
				info += '<td>' + data[i].dateStr + '</td>';
				info += '</tr>';
			}
			$("table").html(info);
		}
	});
}

function add() {
	// 参数名
	var users = [];
	// 取重复元素的值
	$(".user-span").each(function() {
		var self = $(this);
		var name = self.find("input[name='name']").val();
		var mobile = self.find("input[name='mobile']").val();
		console.log(name + "," + mobile);

		var user = {};
		//user.id = 0;
		user.name = name;
		user.mobile = mobile;
		//user.createTime = null;

		users.push(user);
	});

	console.log(users);

	var url = "/user/add-list";

	$.ajax({
		type : "POST",
		url : url,
		dataType : 'json',
		data : users,
		contentType : "application/json; charset=utf-8",
		success : function(res) {
			var msg = res.msg;
			alert(msg);
			console.log(res);
		}
	});
}
 
function empty() {
	var url = "";
	var data = {};

	$.ajax({
		type : "POST",
		url : url,
		dataType : 'json',
		data : JSON.stringify(data),
		contentType : "application/json; charset=utf-8",
		success : function(res) {

		}
	});
}