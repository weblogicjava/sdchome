var ls_currentPage = 1 ; 
function createTable(tableObj) {
	var listInfo = tableObj.list;
	var pagerInfo = tableObj.pager;

	ls_currentPage = pagerInfo.pageNumber ;
	
	var tableHtml = "<table>";
	for (var i = 0; i < listInfo.length; i++) {
		var entity = listInfo[i] ;
		var color = ( i % 2 ) == 0 ? "rowOdd" : "rowEven" ;
		var trHtml = '<tr class="'+color+'" onmouseover="this.className=\'rowFocus\'" onmouseout="this.className=\''+color+'\'">\
			<td>&nbsp;</td>\
			<td id="name'+i+'">'+entity.menulabel+'</td>\
			<td id="state'+i+'">'+((entity.menusrc==undefined)?"&nbsp;":entity.menusrc) +'</td>\
			<td id="health'+i+'">'+entity.levelidx+'</td>\
			<td id="type'+i+'">'+((entity.fillstr100==undefined)?"&nbsp;":entity.fillstr100)+'</td>\
			<td id="deploymentOrder'+i+'"> 查看 | 修改 | 删除 </td>\
		</tr>' ;
		$("#TBODY").append(trHtml);
	}
	
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
		url : ADMIN_ACTION+"/ptmenu/list",
		data : {
			page : pageNum,
			rows : 99999999
		},
		success : function(res) {
			//$("#subjectListInfo").html(res);
			//alert(res);
			//alert(JSON.parse(res));
			createTable(JSON.parse(res));
		},
		fail : function(res) {
			alert("系统错误?!");
		}
	});
}

function createTree(tableObj) {
	var listInfo = tableObj.list;
	var pagerInfo = tableObj.pager;

	var zNodes ="[	{ id:0, pId:-1, name:\"系统菜单管理\", open:true}," ;
	
	for (var i = 0; i < listInfo.length; i++) {
		var entity = listInfo[i] ;
		
		zNodes += "{id:'"+entity.menuid+"',pId:'"+entity.parentmenuid+"',name:'"+entity.menulabel+"'";
		
		zNodes[i+1].id=entity.menuid;
		zNodes[i+1].pId=entity.parentmenuid;
		zNodes[i+1].name=entity.menulabel;
		if(entity.parentmenuid=='0'){
			zNodes += ", open:true" ;
		}
		zNodes += "}," ;
	}
	
	zNodes = zNodes.substring(0,zNodes.length-1);
	
	zNodes += "]" ;
	
	var nodes  ; 
	eval("nodes = "+zNodes);
	
	return nodes ;
	
}


function getTree(){
	
	$.ajax({
		type : "POST",
		url : ADMIN_ACTION+"/ptmenu/list",
		data : {
			page : 1,
			rows : 99999999
		},
		success : function(res) {
			//$("#subjectListInfo").html(res);
			var tree_data_3 = createTree(JSON.parse(res));
			
			$.fn.zTree.init($("#treeDemo"), setting, tree_data_3);
			$("#selectAll").bind("click", selectAll);
		},
		fail : function(res) {
			alert("系统错误?!");
		}
	});
	
}
$(function() {
	//alert('ready');
	getTable(1);
	getTree();
	
});

var setting = {
	view: {
		addHoverDom: addHoverDom,
		removeHoverDom: removeHoverDom,
		selectedMulti: false
	},
	edit: {
		enable: true,
		editNameSelectAll: true,
		showRemoveBtn: showRemoveBtn,
		showRenameBtn: showRenameBtn
	},
	data: {
		simpleData: {
			enable: true
		}
	},
	callback: {
		beforeDrag: beforeDrag,
		beforeEditName: beforeEditName,
		beforeRemove: beforeRemove,
		beforeRename: beforeRename,
		onRemove: onRemove,
		onRename: onRename
	}
};

var zNodes =[
	{ id:0, pId:-1, name:"系统菜单管理", open:true},
	{ id:1, pId:0, name:"父节点 1", open:true},
	{ id:11, pId:1, name:"叶子节点 1-1"},
	{ id:12, pId:1, name:"叶子节点 1-2"},
	{ id:13, pId:1, name:"叶子节点 1-3"},
	{ id:2, pId:0, name:"父节点 2", open:true},
	{ id:21, pId:2, name:"叶子节点 2-1"},
	{ id:22, pId:2, name:"叶子节点 2-2"},
	{ id:23, pId:2, name:"叶子节点 2-3"},
	{ id:3, pId:0, name:"父节点 3", open:true},
	{ id:31, pId:3, name:"叶子节点 3-1"},
	{ id:32, pId:3, name:"叶子节点 3-2"},
	{ id:33, pId:3, name:"叶子节点 3-3"}
];
var log, className = "dark";
function beforeDrag(treeId, treeNodes) {
	return false;
}
function beforeEditName(treeId, treeNode) {
	className = (className === "dark" ? "":"dark");
	//showLog("[ "+getTime()+" beforeEditName ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
	var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	zTree.selectNode(treeNode);
	return confirm("进入节点 -- " + treeNode.name + " 的编辑状态吗？");
}
function beforeRemove(treeId, treeNode) {
	className = (className === "dark" ? "":"dark");
	//showLog("[ "+getTime()+" beforeRemove ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
	var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	zTree.selectNode(treeNode);
	return confirm("确认删除 菜单 -- " + treeNode.name + " 吗？");
}
function onRemove(e, treeId, treeNode) {
	//showLog("[ "+getTime()+" onRemove ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
	$.ajax({
		type : "POST",
		url : ADMIN_ACTION+"/ptmenu/delete",
		data : {
			menuid : treeNode.id
		},
		success : function(res) {
			//
		},
		fail : function(res) {
			alert("系统错误?!");
		}
	});	
}
function beforeRename(treeId, treeNode, newName, isCancel) {
	className = (className === "dark" ? "":"dark");
	//showLog((isCancel ? "<span style='color:red'>":"") + "[ "+getTime()+" beforeRename ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name + (isCancel ? "</span>":""));
	if (newName.length == 0) {
		alert("节点名称不能为空.");
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		setTimeout(function(){zTree.editName(treeNode)}, 10);
		return false;
	}
	return true;
}
function onRename(e, treeId, treeNode, isCancel) {
	//showLog((isCancel ? "<span style='color:red'>":"") + "[ "+getTime()+" onRename ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name + (isCancel ? "</span>":""));
}
function showRemoveBtn(treeId, treeNode) {
	return (treeNode.id!=0 && !treeNode.isParent);
}
function showRenameBtn(treeId, treeNode) {
	return (treeNode.id!=0) ;
}
function getTime() {
	var now= new Date(),
	h=now.getHours(),
	m=now.getMinutes(),
	s=now.getSeconds(),
	ms=now.getMilliseconds();
	return (h+":"+m+":"+s+ " " +ms);
}

var newCount = 1;
function addHoverDom(treeId, treeNode) {
	if(treeNode.level==1){ 
		return false ;
	}
	
	var sObj = $("#" + treeNode.tId + "_span");
	if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
	var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
		+ "' title='add node' onfocus='this.blur();'></span>";
	sObj.after(addStr);
	var btn = $("#addBtn_"+treeNode.tId);
	if (btn) btn.bind("click", function(){
		
			var modal = $("#modelform");
			modal.modal("show").on("hidden", function(){
				modal.remove();
			});
			modal.find("button[id='saveMenuBtn']").click(function(){
				alert(1);
				$.ajax({
					type : "POST",
					url : ADMIN_ACTION+"/ptmenu/addType",
					data : {
						parentmenuid : treeNode.id,
						menulabel : $("input[id='menu_name']").val(),
						levelidx : $("input[id='menu_index']").val(),
						menusrc : $("input[id='menu_src']").val()
					},
					success : function(res) {
						
						if(res){
							var menu = JSON.parse(res) ;
							var zTree = $.fn.zTree.getZTreeObj("treeDemo");
							zTree.addNodes(treeNode, {id:menu.menuid, pId:menu.parentmenuid, name:menu.menulabel});
							modal.find("button[class='close']").click();
							modal.escape();
						}
						
					},
					fail : function(res) {
						alert("系统错误?!");
					}
				});	
				
			});
			
	});
};
function removeHoverDom(treeId, treeNode) {
	$("#addBtn_"+treeNode.tId).unbind().remove();
};
function selectAll() {
	var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	zTree.setting.edit.editNameSelectAll =  $("#selectAll").attr("checked");
}
	
