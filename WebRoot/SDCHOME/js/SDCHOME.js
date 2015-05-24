
function userimg(userid){
	var imgSrc = "#" ;
	$.ajax({
		async:false ,
        url : _SDCACTION_+"/UserPicturesInfo/img", 
        data : {uid:userid,d:new Date().getTime()},
        success : function (res) {
        	imgSrc = JSON.parse(res) ;
        },
        fail : function(res) {
            alert("系统错误?!");
        }
    });
	return imgSrc.toString() ;
}