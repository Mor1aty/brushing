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
		type:0
	},
	dataType : 'json',// 服务器返回json格式数据
	type : 'get',// HTTP请求类型
	success : function(su) {
		if (su.code === 0) {
			console.log(su.data);
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
var index = 0;
function change(type){
	if(type == 0){
		if(index == 0){
			mui.alert("没有上一题","提示","确定",null,'div');
		}else{
			index--;
			show(index);
		}
	}else{
		if(index == 9){
			mui.alert("没有下一题","提示","确定",null,'div');
		}else{
			index++;
			show(index);
		}
	}
}
function show(i){
	document.getElementById("final").style.display = "none";
	var paper = JSON.parse(localStorage.getItem("paper" + i));
	document.getElementById("title").innerHTML = paper.q_title;
	document.getElementById("answer").innerHTML = "答案：" + paper.q_answer;
	document.getElementById("analysis").innerHTML = "解析：" + paper.q_analysis;
	if(paper.q_type == 0){
		var html = "<ul class='mui-table-view' style='width:100%;'>";
		var options = paper.q_option.split("\|");
		for(var o = 0; o < options.length; o++){
			html +=  "<li class='mui-table-view-cell' style='width:100%;' onclick='showAnswer()'>"+ options[o] +"</li>";
		}
		document.getElementById("options").innerHTML = html + "</ul>";
	}
	document.getElementById("load").style.display = "none";
	document.getElementById("cc").style.display = "block";
}
function showAnswer(){
	document.getElementById("final").style.display = "block";
}