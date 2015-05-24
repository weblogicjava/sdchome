var ls_currentPage = 1 ; 
function createTable(tableObj) {
	var listInfo = tableObj.list;
	var pagerInfo = tableObj.pager;

	ls_currentPage = pagerInfo.pageNumber ;
	
	var tableHtml = "<table>";
	for (var i = 0; i < listInfo.length; i++) {
		var infoTmp = listInfo[i] ;
		tableHtml += "<tr>";
		tableHtml += "<td>"+infoTmp.subjectid+"</td>" ;
		tableHtml += "<td>"+infoTmp.authorid+"</td>" ;
		tableHtml += "<td>"+infoTmp.title+"</td>" ;
		tableHtml += "<td>"+infoTmp.writeDate+"</td>" ;
		tableHtml += "<td>"+infoTmp.lastMdate+"</td>" ;
		tableHtml += "<td>"+infoTmp.level+"</td>" ;
		tableHtml += "<td>"+infoTmp.state+"</td>" ;
		tableHtml += "<td>"+infoTmp.clickcount+"</td>" ;
		tableHtml += "<td>"+infoTmp.recommcount+"</td>" ;
		tableHtml += "<td>"+infoTmp.lovecount+"</td>" ;
		tableHtml += "<td><a href='"+_SDCBASE_+"/SDCHOME/bbs/SubjectView.jsp?subjectid="+infoTmp.subjectid+"' target='_blank'>VIEW</a>" ;
		tableHtml += "| <a href='javascript:void(0);return;' onclick='deleteData("+infoTmp.subjectid+")'>DEL</a>" ;
		tableHtml += "| <a href='"+_SDCACTION_+"/SubjectBase/get2edit?subjectid="+infoTmp.subjectid+"' target='_top'>UPDATE</a>" ;
		tableHtml += "</td>" ;
		tableHtml += "</tr>";
	}
	tableHtml += "<tr>";
	var pageStr = "<a href='javascript:void(0);return;' onclick='getTable(1)'>首页</a>" ;
	pageStr += "<a href='javascript:void(0);return;' onclick='getTable("+((pagerInfo.pageNumber-1)>0?(pagerInfo.pageNumber-1):1)+")'>上一页</a> " ;
	pageStr += "<a href='javascript:void(0);return;' onclick='getTable("+((pagerInfo.pageNumber+1)>pagerInfo.pageCount?pagerInfo.pageNumber:(pagerInfo.pageNumber+1))+")'>下一页</a> " ;
	pageStr += "<a href='javascript:void(0);return;' onclick='getTable("+pagerInfo.pageCount+")'>尾页</a> " ;
	tableHtml += "<td colspan='13'>共"+pagerInfo.recordCount+"条数据&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;第"+pagerInfo.pageNumber+"页/共"+pagerInfo.pageCount+"页&nbsp;&nbsp;&nbsp;&nbsp;"+pageStr+"</td>" ;
	tableHtml += "</tr>";

	tableHtml += "</table>";
	$("#tablePanel").html(tableHtml);
}

function deleteData(sid) {
	$.ajax({
		type : "POST",
		url : _SDCACTION_+"/SubjectBase/delete",
		data : {
			subjectid : sid
		},
		success : function(res) {
			if(res){
				getTable(ls_currentPage);
			}
		},
		fail : function(res) {
			alert("系统错误?!");
		}
	});
	
}

function getTable(pageNum) {
	$.ajax({
		type : "POST",
		url : _SDCACTION_+"/SubjectBase/list",
		data : {
			page : pageNum,
			rows : 10
		},
		success : function(res) {
			//$("#subjectListInfo").html(res);
			createTable(JSON.parse(res));
		},
		fail : function(res) {
			alert("系统错误?!");
		}
	});
}
$(function() {
	getTable(1);
});