/*记住密码功能实现逻辑*/
			window.onload = function(){
				if(localStorage.getItem("user") != null){
					var user = JSON.parse(localStorage.getItem("user"));
					document.getElementById('account').value = user.account;
					document.getElementById("passwd").value = user.password;
				}
			}
			/*登录按钮触发事件*/
			document.getElementById("loginButton").addEventListener('tap', function() {
				var account = document.getElementById('account').value;
				var password = document.getElementById('passwd').value;
				if(account == null || account == ""){
					mui.alert("用户名不能为空","提示","确定",null,'div');
					return;
				}
				if(password == null || password == ""){
					mui.alert("密码不能为空","提示","确定",null,'div');
					return;
				}
				mui.ajax(baseURL+'login.do',{
					data:{
						account: account,
						password: password,
					},
					dataType:'json',//服务器返回json格式数据
					type:'post',//HTTP请求类型
					success:function(su){
						if(su.code === 0){
							var user = {
								account:account,
								password:password
							};						
							localStorage.setItem("user",JSON.stringify(user));
							localStorage.setItem("loginSign",account);
							mui.toast("登录成功",{ duration:'long', type:'div' });
							window.location.href = baseURL + "index.html";
							
						}else{
							mui.alert(su.msg,"提示","确定",null,'div');
						}
					},
					error:function(xhr,type,errorThrown){
						//异常处理；
						console.log(type);
					}
				});
			});