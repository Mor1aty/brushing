window.onload = function(){
	document.getElementById('iFrame').src = "iframeHTML/main.html";
	document.getElementById('submit').style.display = "none";
	document.getElementsByClassName('mui-title')[0].innerText = "神农刷题";
}
removeAll();
function removeAll(){
	for (var i = 0; i < 20; i++) {
		if(localStorage.getItem("paper" + i) != null){
			localStorage.removeItem("paper" + i);
		}
	}
	if(localStorage.getItem("paperId") != null){
		localStorage.removeItem("paperId");
	}
}
//返回禁用
mui.back=function () {  
    var btnArray = ['否', '是'];  
    mui.confirm('是否退出应用', '神农刷题', btnArray, function(e) {  
              if (e.index == 1) { 
            	  removeAll();
            	  localStorage.removeItem("loginSign");
            	  plus.runtime.quit();  
                }  
        },'div')  
}
var loginSign = JSON.parse(localStorage.getItem("loginSign"));
if (loginSign == null) {
	window.location.href = baseURL + "login.html";
}
// 实现侧滑菜单滚动
$("#left-menu").on('tap', function(event) {
	mui('.mui-off-canvas-wrap').offCanvas('show');
});
window.onload = function() {
	mui('#offCanvasSideScroll').scroll();
	mui('#offCanvasContentScroll').scroll();
}
mui.init({
	swipeBack: false //启用右滑关闭功能
});
// 侧边栏导航实现逻辑（代码待优化）
document.getElementById("back-btn").addEventListener('tap', function() {
	document.getElementById('iFrame').src = "iframeHTML/main.html";
	document.getElementById('submit').style.display = "none";
	document.getElementsByClassName('mui-title')[0].innerText = "神农刷题";
	mui('.mui-off-canvas-wrap').offCanvas().toggle();
});
document.getElementsByClassName('mui-table-view-cell')[0].addEventListener('tap', function(){
			document.getElementById('iFrame').src = "iframeHTML/userinfo.html";
			document.getElementById('submit').style.display = "none";
			document.getElementsByClassName('mui-title')[0].innerText = "个人信息";
			mui('.mui-off-canvas-wrap').offCanvas().toggle();
		});
document.getElementsByClassName('mui-table-view-cell')[1].addEventListener(
		'tap', function() {
			document.getElementById('iFrame').src = "iframeHTML/asForUs.html";
			document.getElementById('submit').style.display = "none";
			document.getElementsByClassName('mui-title')[0].innerText = "关于我们";
			mui('.mui-off-canvas-wrap').offCanvas().toggle();
		});
document.getElementsByClassName('mui-table-view-cell')[2].addEventListener(
		'tap', function() {
			document.getElementById('iFrame').src = "iframeHTML/feedback.html";
			document.getElementsByClassName('mui-title')[0].innerText = "问题反馈";
			document.getElementById('submit').style.display = "inline";
			mui('.mui-off-canvas-wrap').offCanvas().toggle();
		});
document.getElementsByClassName('mui-table-view-cell')[3]
		.addEventListener('tap',function() {
					document.getElementById('iFrame').src = "iframeHTML/errorBack.html";
					document.getElementsByClassName('mui-title')[0].innerText = "错题练习";
					document.getElementById('submit').style.display = "none";
					mui('.mui-off-canvas-wrap').offCanvas().toggle();
		});
		
		//问题反馈发送
		function submit(){
				mui.alert("感谢您的反馈，管理员审核结果会以QQ\邮件通知到您，希望我们一起让神农刷题变得更好！","提示","确定",function(){
					document.getElementById('iFrame').src = "iframeHTML/main.html";
					document.getElementById('submit').style.display = "none";
					document.getElementsByClassName('mui-title')[0].innerText = "神农刷题";
				},'div');
			}