mui.init({
	swipeBack : true
// 启用右滑关闭功能
});

var html = "";
mui.ajax(baseURL + 'getWrong.do', {
	data : {},
	dataType : 'json',// 服务器返回json格式数据
	type : 'get',// HTTP请求类型
	success : function(su) {
		if (su.code === 0) {
			if(su.data != null){
				for (var i = 0; i < su.data.length; i++) {
					if(su.data[i].q_type == 0){
						var options = su.data[i].q_option.split("\|");
						html += "<div class='mui-content' id='"+ su.data[i].id +"'>"
							+ "<div class='mui-card'>"
							+"<div class='mui-card-header'>"
							+"<span id='subject'>"+ su.data[i].q_title +"</span>"
							+"<a onclick='delWrong("+ su.data[i].id +")'>删除</a></div>"
							+ "<div class='mui-card-header' id='options'><ul class='mui-table-view'>";
						for(var o = 0; o < options.length; o++){
							html +=  "<li class='mui-table-view-cell'>"+ options[o] +"</li>";
						}
						html += "</ul></div><div class='mui-card-header' id='answer'>答案："+ su.data[i].q_answer +"</div>"	
							+ "<div class='mui-card-footer' id = 'analysis'>"+ su.data[i].q_analysis +"</div>"
							+"</div></div>";
					}else{
						html += "<div class='mui-content'>"
							+ "<div class='mui-card'>"
							+"<div class='mui-card-header'>"
							+"<span id='subject'>"+ su.data[i].q_title +"</span>"
							+"<a onclick='delWrong()'>删除</a></div>"
							+"<div class='mui-card-header' id='answer'>答案："+ su.data[i].q_answer +"</div>"	
							+"<div class='mui-card-footer' id='analysis'>解析："+ su.data[i].q_analysis +"</div>"
							+"</div></div>";
					}
				}
				document.getElementById("cc").innerHTML = html;
			}
		} else {
			//alert(su.msg);
		}
	},
	error : function(xhr, type, errorThrown) {
		alert("fail");
		// 异常处理；
		console.log(type);
	}
});
function delWrong(id){
	mui.ajax(baseURL + 'delWrong.do', {
		data : {
			id : id
		},
		dataType : 'json',// 服务器返回json格式数据
		type : 'get',// HTTP请求类型
		success : function(su) {
			if (su.code === 0) {
				var parent = document.getElementById("cc");
				var child = document.getElementById(id);
				parent.removeChild(child);
			} else {
				alert(su.msg);
			}
		},
		error : function(xhr, type, errorThrown) {
			alert("fail");
			// 异常处理；
			console.log(type);
		}
	});
}




