function GetQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null;
}
document.getElementById("back").onclick = function(){
	for (var i = 0; i < 20; i++) {
		localStorage.removeItem("paper" + i);
	}
	localStorage.removeItem("paperId");
	top.location.href = baseURL + "index.html";
}
mui.init({
	swipeBack : true
// 启用右滑关闭功能
});
var arr = new Array;
var language = GetQueryString("langu");
// 拿数据
mui.ajax(baseURL + 'getPaper.do', {
	data : {
		language : language,
		type:1
	},
	dataType : 'json',// 服务器返回json格式数据
	type : 'get',// HTTP请求类型
	success : function(su) {
		if (su.code === 0) {
			localStorage.setItem("paperId", su.data.id);
			for (var i = 0; i < su.data.paper.length; i++) {
				if(su.data.paper[i].q_type == 0){
					var paper = {
							id:su.data.paper[i].id,
							q_type:su.data.paper[i].q_type,
							q_language:su.data.paper[i].q_language,
							q_title:su.data.paper[i].q_title,
							q_option:su.data.paper[i].q_option,
							q_answer:su.data.paper[i].q_answer,
							q_analysis:su.data.paper[i].q_analysis
						};	
					localStorage.setItem("paper" + i,JSON.stringify(paper));
				}else{
					/*
					 * var paper = { id:su.data.paper[i].id,
					 * q_type:su.data.paper[i].q_type,
					 * q_language:su.data.paper[i].q_language,
					 * q_title:su.data.paper[i].q_title,
					 * q_answer:su.data.paper[i].q_answer,
					 * q_analysis:su.data.paper[i].q_analysis };
					 */
				}
			}
			show(0);
		} else {
			alert(su.msg);
		}
	},
	error : function(xhr, type, errorThrown) {
		console.log(type);
	}
});
var errorList = "";
var score = 0;
var index = 0;
function change(answ,answer,id){
	if(answ != answer){
		errorList += id + "|";
	}else{
		score += 5;
	}
	if(index == 9){
		var html = "";
		for(var i = 0; i < 10; i++){
			var paper = JSON.parse(localStorage.getItem("paper" + i));
			if(paper.q_type == 0){
				html += "<div class='mui-content'><div class='mui-card'>"
						+"<div class='mui-card-header'>"+ paper.q_title +"</div>"
				html += "<ul class='mui-table-view' style='width:100%;'>";
				var options = paper.q_option.split("\|");
				for(var o = 0; o < options.length; o++){
					if(options[o].split("\.")[0] == paper.q_answer){
						html +=  "<li class='mui-table-view-cell' style='width:100%;background-color:#ff0000')>"+ options[o] +"</li>";
					}else{
						html +=  "<li class='mui-table-view-cell' style='width:100%;')>"+ options[o] +"</li>";
					}
				}
				html += "</ul><div class='mui-card-footer'>"+ paper.q_analysis +"</div></div></div>";
			}
		}
		document.getElementById("cc").innerHTML = html;
		document.getElementById("head").innerHTML = "<span>查看答案</span>";
		
	}else{
		index++;
		show(index);
	}
}
document.getElementById("finish").onclick = function(){
	errorList = errorList.substring(0,errorList.length - 1);
	var id = localStorage.getItem("paperId");
	mui.ajax(baseURL + 'getWorkMsg.do', {
		data : {
			id : id,
			score : score,
			idList : errorList
		},
		dataType : 'json',// 服务器返回json格式数据
		type : 'post',// HTTP请求类型
		success : function(su) {
			if (su.code === 0) {
				mui.alert("交卷成功","提示","确定",function(){
					top.location.href = baseURL + "index.html";},'div');
			} else {
				alert(su.msg);
			}
		},
		error : function(xhr, type, errorThrown) {
			console.log(type);
		}
	});
}
function show(i){
	var paper = JSON.parse(localStorage.getItem("paper" + i));
	document.getElementById("title").innerHTML = paper.q_title;
	if(paper.q_type == 0){
		var html = "<ul class='mui-table-view' style='width:100%;'>";
		var options = paper.q_option.split("\|");
		for(var o = 0; o < options.length; o++){
			html +=  "<li class='mui-table-view-cell' style='width:100%;' onclick=change('"+ options[o].split("\.")[0] +"','"+ paper.q_answer +"','"+ paper.id +"')>"+ options[o] +"</li>";
		}
		document.getElementById("options").innerHTML = html + "</ul>";
	}
	document.getElementById("load").style.display = "none";
	document.getElementById("cc").style.display = "block";
}
