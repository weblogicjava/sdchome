$(function() {
	$("#loginSubmitBtn").click(function() {
		$.ajax({
			url : _SDCACTION_+"/Security/login",
			data : $("#loginForm").serialize(),
			success : function(res) {
				res = JSON.parse(res);
				if (res.errorCode == "SUCCESS") {
					if(res.nextMove!=null){
						window.location = res.nextMove ;
					}else{
						window.location = _SDCBASE_+"/SDCHOME/bbs/SubjectList.jsp";
					}
				} else {
					$("#loginRet").html(res.errorMsg);
				}
			},
			fail : function(res) {
				alert("系统错误?!");
			}
		});
		return false;
	});
	
	$("#registBtn").click(function () {
        $.ajax({
            url : _SDCACTION_+"/UserInfo/add", 
            data : $("#registerForm").serialize(),
            success : function (res) {
            	res = JSON.parse(res);
            	if(res.errorCode=="SUCCESS"){
            		window.location = _SDCBASE_+"/SDCHOME/index.jsp?type=login" ;
            	}else{
            		$("#registRet").html(res.errorMsg);
            	}
            },
            fail : function(res) {
                alert("系统错误?!");
            }
        });
        return false;
    });
	
});