
mui.init({
				swipeBack:true //启用右滑关闭功能
			});
			//全局变量声明
			var grade,noteID,wrongID; //分数，套题记录id，错题ID
			var choice,choiceAnswer,completion,completionInit,completionAnswerInit,completionAnswer;
			var language = GetQueryString("langu"); //用户输入的语言，本地存储
			var content = document.getElementsByClassName('mui-content')[0]; //页面内容
			console.log(language + "123");
			mui.ajax(baseURL+'getPaper.do',{
					data:{
					},
					dataType:'json',//服务器返回json格式数据
					type:'get',//HTTP请求类型
					success:function(su){
						if(su.code === 0){
							noteID = su.data.id;
							var ht = '';
							for(var i=0; i<su.data.paper.length; i++){
								if(su.data.paper[i].q_type == 0){
									var options = su.data.paper[i].q_option.spilt("|");
									var htt = '';
									for(var j=0; j<options.length; j++){
										htt += "<div class='mui-input-row mui-radio mui-left'><label class='option'>"
											+ options[j]
											+ "</label><input name='"
											+ su.data.paper[i].q_answer
											+ '" value="'
											+ j
											+ '" type="radio" class="optionRa" onclick="raClick('
											+ su.data.paper[i].q_id
											+ ');"></div>';
									}
									var httt = "正确答案：" + su.data.paper[i].q_answer + "（注：" + su.data.paper[i].q_analysis + "）";
									ht += '<div class="choose"><h5 class="mui-content-padded" id="title">'
										+ i + '、'
										+ su.data.paper[i].title
										+ '</h5><form class="form">'
										+ htt
										+ '<div class="answer">'
										+ httt
										+ '</div></div>';
								}
								else
								{
									var httt = "正确答案：" + su.data.paper[i].q_answer + "（注：" + su.data.paper[i].q_analysis + "）";
									ht += "<div class='Non-choose'><h5 class='mui-content-padded' id='title1'>"
										+ i + "、"
										+ su.data.paper[i].title
										+ "</h5><form class='form1'>"
										+ "<textarea name='"
										+ su.data.paper[i].q_answer
										+ 'onkeypress="displayResult('
										+ su.data.paper[i].q_id
										+ ');" id="textArea" rows="5" placeholder="在此处填写答案..." autofocus="autofocus"></textarea>'
										+ '</form><div class="answer">'
										+ httt
										+ '</div></div>';
								}
							}
							content.innerHTML = ht;
						}else{
							alert(su.msg);
						}
					},
					error:function(xhr,type,errorThrown){
						alert("fail");
						//异常处理；
						console.log(type);
					}
				});
				
				/*选择题处理逻辑*/
				function raClick(id){
					var ans;
					switch(this.value){
						case "0": ans = "A";
							break;
						case "1": ans = "B";
							break;
						case "2": ans = "C";
							break;
						case "3": ans = "D";
							break;
						case "4": ans = "E";
							break;
					}
					choice += id + "|";
					choiceAnswer += ans + "|";
				}
				
				/*填空及问答处理逻辑*/
				function displayResult(idd){
					var x;
					if(window.event)
						{
						x=event.keyCode;
						}
					else if(event.which) 
						{
						x=event.which;
						}
					keychar=String.fromCharCode(x);
					completionInit += idd + "|";
					completionAnswerInit += this.value + "|";
				}
				
				/*交卷处理逻辑*/
				var finish = document.getElementById('finish');
				finish.addEventListener('tap',function(){
					var array1 = completionInit.split("|");
					var array2 = completionAnswerInit.split("|");
					for(var j=0; j<array1.length; j++){
						if(j<5){
							completion += array1[j]+'|';
							completionAnswer += array2[j]+'|';
						}
						else{
							saq += array1[j]+'|';
							saqAnswer += array2[j]+'|';
						}
					}
					alert("考试完成",function(){
						mui.ajax(baseURL+'subPaper',{
								data:{
									choice: choice,
									choiceAnswer: choiceAnswer,
									completion: completion,
									completionAnswer: completionAnswer,
									saq: asq,
									saqAnswer: saqAnswer,
									id: storeData.examID
								},
								dataType:'json',//服务器返回json格式数据
								type:'post',//HTTP请求类型
								success:function(succ){
									if(succ.code != 0){
										alert(su.msg);
									}
								},
								error:function(xhr,type,errorThrown){
									alert("fail");
									//异常处理；
									console.log(type);
								}
							});
					});
				})