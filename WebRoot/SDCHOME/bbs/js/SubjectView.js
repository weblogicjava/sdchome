var editor;
var commentEditor ;

$(function () {
	
	KindEditor.ready(function(K) {
		editor = K.create('textarea[name="content"]', {
			cssPath : _SDCBASE_+'/plugins/kindeditor/plugins/code/prettify.css',
			uploadJson : _SDCBASE_+'/plugins/kindeditor/jsp/upload_json.jsp',
			fileManagerJson : _SDCBASE_+'/plugins/kindeditor/jsp/file_manager_json.jsp',
			allowFileManager : true
		});
		commentEditor = K.create('textarea[name="commentEdit"]', {
			cssPath : _SDCBASE_+'/plugins/kindeditor/plugins/code/prettify.css',
			uploadJson : _SDCBASE_+'/plugins/kindeditor/jsp/upload_json.jsp',
			fileManagerJson : _SDCBASE_+'/plugins/kindeditor/jsp/file_manager_json.jsp',
			allowFileManager : true
		});
	});
		        	
	$.ajax({
		async:false ,
        url : _SDCACTION_+"/SubjectBase/select", 
        data : {subjectid:ls_subjectid},
        success : function (res) {
        	if(res==null){
        		//$("#subjectRet").html("未找到信息");
        	}else{
        		res = JSON.parse(res);
            	$("#v_title").html(res.title);
            	$("#v_content").html(res.content);
        	}
        	
        },
        fail : function(res) {
            alert("系统错误?!");
        }
    });
	
	getCommentsList(1);
	
	$("#CommentForm").submit(function() {
		$("#content").val(editor.html());
		$.ajax({
			url : _SDCACTION_+"/SubjectComments/add",
			data : $("#CommentForm").serialize(),
			type:"POST",
			success : function(res) {
				res = JSON.parse(res);
				if (res.errorCode == "SUCCESS") {
					window.top.location = _SDCBASE_+"/SDCHOME/bbs/SubjectView.jsp?subjectid="+ls_subjectid+"";
				} 
			},
			fail : function(res) {
				alert("系统错误?!");
			}
		});
	});
	
});

function EditComment(commentid){
	commentEditor.html($("#COMMENT_CON_"+commentid).html());
	$("#ModelSaveBtn").click(function(){
		$.ajax({
			url : _SDCACTION_+"/SubjectComments/update",
			data : {
				commentid : commentid ,
				content : commentEditor.html()
			},
			type:"POST",
			success : function(res) {
				$("#COMMENT_CON_"+commentid).html(commentEditor.html()) ;
				$("#modal-form").modal("hide");
			},
			fail : function(res) {
				alert("系统错误?!");
			}
		});
	});
	$("#modal-form").modal("show");
}

function DeleteComment(commentid){
	bootbox.dialog({
		message: "<span class='bigger-110'>是否确认删除该评论信息？</span>",
		buttons: {
			"success" :
			 {
				"label" : "<i class='ace-icon fa fa-check'></i> 确认删除",
				"className" : "btn-sm btn-success",
				"callback": function() {
					$.ajax({
		    			type : "POST",
		    			url : _SDCACTION_+"/SubjectComments/delete",
		    			data : {
		    				commentid:commentid
		    			},
		    			success : function(res) {
		    				getCommentsList(ls_currentPage);
		    			},
		    			fail : function(res) {
		    				alert("系统错误?!");
		    			}
		    		});
				}
			},
			"button" :
			{
				"label" : "取消删除",
				"className" : "btn-sm"
			}
		}
	});
}

function getCommentsList(pageNum) {
	$.ajax({
		type : "POST",
		url : _SDCACTION_+"/SubjectComments/list",
		data : {
			page : pageNum,
			rows : 10,
			subjectid:ls_subjectid
		},
		success : function(res) {
			//$("#subjectCommentListInfo").html(res);
			createTable(JSON.parse(res));
		},
		fail : function(res) {
			alert("系统错误?!");
		}
	});
}
	        
var ls_currentPage = 1 ; 
function createTable(tableObj) {
	var listInfo = tableObj.list;
	var pagerInfo = tableObj.pager;

	ls_currentPage = pagerInfo.pageNumber ;
	
	var tableHtml = "<table>";
	tableHtml += "<tr><td>";
	for (var i = 0; i < listInfo.length; i++) {
		var infoTmp = listInfo[i] ;
		
		var commentHtml = '<div class="clear"></div>\
			<div class="commentItem">\
			<div class="commentItemOP">';
		if(infoTmp.isCurrentUser=="1"){
			commentHtml += '<div class="hidden-sm hidden-xs action-buttons">\
				<a class="blue" href="javascript:EditComment(\''+infoTmp.commentid+'\');" role="button" data-toggle="modal"><i class="ace-icon fa fa-pencil bigger-130"></i></a>\
				<a class="red" href="javascript:DeleteComment(\''+infoTmp.commentid+'\');">\
					<i class="ace-icon fa fa-trash-o bigger-130"></i>\
				</a>\
			</div>';
		}else{
			commentHtml += "&nbsp;&nbsp;" ;
		}		
		commentHtml += '</div>\
			<div class="commentItemH">\
				<span class="profile-picture" style="margin-left:auto;margin-right:auto">';
				
		commentHtml += '<img class="editable img-responsive" src="';
		commentHtml += infoTmp.authorpic ;
		commentHtml += '" width="50px" height="50px"/>\
				</span>\
			</div>\
			<div class="commentItemC">\
				<div class="commentItemCT">';
		commentHtml += infoTmp.authorname+'&nbsp;&nbsp;&nbsp;&nbsp;'+infoTmp.writeDate ;		
		if(infoTmp.isViewerIsAuthor=="1"){
			commentHtml += '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:ReplyComment(\''+infoTmp.commentid+'\')">[回复该评论]</a>';
		}
		commentHtml += '</div>\
				<div id="COMMENT_CON_'+infoTmp.commentid+'">%CONTENT%</div>\
				<div id="comment2comment_'+infoTmp.commentid+'">\
				</div>\
			</div>\
		</div>\
		<div class="clear"></div>';
			    			
		var tmpHtml = commentHtml.replace("%CONTENT%", infoTmp.content) ;
		tableHtml += tmpHtml ;
	}
	tableHtml += '<div class="hr hr-12 dotted"></div>';
	tableHtml += "</td></tr>";
	
	tableHtml += "<tr>";
	var pageStr = "<a href='javascript:void(0);return;' onclick='getCommentsList(1)'>首页</a> &nbsp;&nbsp;" ;
	pageStr += "<a href='javascript:void(0);return;' onclick='getCommentsList("+((pagerInfo.pageNumber-1)>0?(pagerInfo.pageNumber-1):1)+")'>上一页</a> &nbsp;&nbsp; " ;
	pageStr += "<a href='javascript:void(0);return;' onclick='getCommentsList("+((pagerInfo.pageNumber+1)>pagerInfo.pageCount?pagerInfo.pageNumber:(pagerInfo.pageNumber+1))+")'>下一页</a> &nbsp;&nbsp;" ;
	pageStr += "<a href='javascript:void(0);return;' onclick='getCommentsList("+pagerInfo.pageCount+")'>尾页</a> &nbsp;&nbsp;" ;
	tableHtml += "<td>共"+pagerInfo.recordCount+"条数据&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;第"+pagerInfo.pageNumber+"页/共"+pagerInfo.pageCount+"页&nbsp;&nbsp;&nbsp;&nbsp;"+pageStr+"</td>" ;
	tableHtml += "</tr>";

	tableHtml += "</table>";
	if(pagerInfo.recordCount==0){
		$("#tablePanel").html("<div style='text-align:center'>暂无评论信息！</div>");
	}else{
		$("#tablePanel").html(tableHtml);
	}
	
	comments2comment();
	
}

function ReplyComment(commentid){
	var htmlReply = '<div>\
				<textarea id="REPLY_'+commentid+'" class="autosize-transition form-control"></textarea>\
				<button class="btn btn-xs btn-info" onclick="PostReply(\''+commentid+'\')">\
					<i class="ace-icon fa fa-floppy-o bigger-110"></i>\
					保存回复\
					<i class="ace-icon fa fa-arrow-right icon-on-right"></i>\
					<div class="clear"></div>\
				</button>\
			</div>';
	
	if($("#REPLY_"+commentid)!=null){
		$("#comment2comment_"+commentid).prepend(htmlReply);
	}
	
}

function PostReply(commentid){
	$.ajax({
		url : _SDCACTION_+"/SubjectComments/add",
		data : {
			subjectid : commentid ,
			content : $("#REPLY_"+commentid).val()
		},
		type:"POST",
		success : function(res) {
			GetComments2comment(commentid);
		},
		fail : function(res) {
			alert("系统错误?!");
		}
	});
}

function comments2comment(){
	$("div[id*='comment2comment_']").each(function(){
		var cid = $(this).attr("id") ;
		GetComments2comment(cid.split("_")[1]);
	});
}

function GetComments2comment(commentid){
	
	$.ajax({
		type : "POST",
		url : _SDCACTION_+"/SubjectComments/list",
		data : {
			page : 1,
			rows : 1000,
			subjectid:commentid
		},
		success : function(res) {
			//$("#subjectCommentListInfo").html(res);
			HtmlComments2comment(commentid ,JSON.parse(res));
		},
		fail : function(res) {
			alert("系统错误?!");
		}
	});
	
}

function HtmlComments2comment(commentid , tableObj){
	var listInfo = tableObj.list ;
	$("#comment2comment_"+commentid).html("&nbsp;&nbsp;");
	for(var i=0;i<listInfo.length;i++){
		var infoTmp = listInfo[i] ;
		var commentHtml = '<div class="clear"></div>\
			<div class="commentItem">\
			<div class="commentItemOP">';
		if(infoTmp.isCurrentUser=="1"){
			commentHtml += '<div class="hidden-sm hidden-xs action-buttons">\
				<a class="red" href="javascript:DeleteComment(\''+infoTmp.commentid+'\')">\
					<i class="ace-icon fa fa-trash-o bigger-130"></i>\
				</a>\
			</div>';
		}else{
			commentHtml += "&nbsp;&nbsp;" ;
		}
		commentHtml += '</div>\
			<div class="commentItemH">\
				<span class="profile-picture" style="margin-left:auto;margin-right:auto">';
				
		commentHtml += '<img class="editable img-responsive" src="'+infoTmp.authorpic+'" width="50px" height="50px"/>\
				</span>\
			</div>\
			<div class="commentItemC2">\
				<div class="commentItemCT">'+infoTmp.authorname+'&nbsp;&nbsp;&nbsp;&nbsp;'+infoTmp.writeDate+'</div>\
				<div>%CONTENT%</div>\
			</div>\
		</div>\
		<div class="clear"></div>';
		
		var tmpHtml = commentHtml.replace("%CONTENT%", infoTmp.content) ;
		$("#comment2comment_"+commentid).append(tmpHtml);
	}
}