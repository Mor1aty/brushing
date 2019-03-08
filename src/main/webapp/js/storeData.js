//var baseURL = "http://39.105.114.238:8080/brushing/";
//var baseURL = "http://210.47.163.67:8080/brushing/";
var baseURL = "http://localhost:8080/brushing/";
//var baseURL = "http://210.47.163.67/tomcat/brushing/";
var storeData = {
}
/*单选框获取值*/
function getRadioRes(className){
	var rdsObj=document.getElementsByClassName(className);
	var checkVal=null;
	for(var i=0; i<rdsObj.length; i++){
		if(rdsObj[i].checked){
			checkVal = rdsObj[i].value;
		}
	}
	if(checkVal==null){
		mui.toast("请选择");
		return;
	}
	mui.toast(checkVal);
	return(checkVal);
}
