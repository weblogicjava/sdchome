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

function createTree(tableObj) {
	var listInfo = tableObj.list;
	var pagerInfo = tableObj.pager;

	ls_currentPage = pagerInfo.pageNumber ;
	
	var firstMenu = [] ;	
	var secondMenu = new Array() ;	
	var tree_data_3 ;
	var tree_data_3_eval = "tree_data_3={" ;
	
	for (var i = 0; i < listInfo.length; i++) {
		var entity = listInfo[i] ;
		if(entity.parentmenuid=='0'){
			firstMenu[i] = entity ;
			tree_data_3_eval += entity.menuid+":{name:'"+entity.menulabel+"&nbsp;&nbsp;',type:'folder','icon-class':'blue'}," ;
		}else{
			secondMenu[i] = entity ;
		}
		
		//$("#TBODY").append(trHtml);
	}
	tree_data_3_eval = tree_data_3_eval.substring(0,tree_data_3_eval.length-1);
	tree_data_3_eval += "}" ;
	eval(tree_data_3_eval);
	
	var ace_icon = ace.vars['icon'];
	var tree_data_3_add_eval = "" ;
	for(var i=0;i<firstMenu.length;i++){
		var tmpMenu = firstMenu[i] ; 
		if(tmpMenu==null || tmpMenu=="" ||tmpMenu==undefined){
			continue ;
		}
		tree_data_3_add_eval = "tree_data_3['"+tmpMenu.menuid+"']['additionalParameters'] = {'children' : {" ;
		var execute = false ;
		for(var j=0;j<listInfo.length;j++){
			var entity = listInfo[j] ;
			if(entity.parentmenuid==tmpMenu.menuid){
				execute = true ;
				tree_data_3_add_eval += '\''+entity.menuid+'\' : {name: \'<i class=\"'+ace_icon+' fa fa-leaf green\"></i> '+entity.menulabel+'\', type: \'item\', \'icon-class\':\'blue\'},' ;
			}
		}
		tree_data_3_add_eval = tree_data_3_add_eval.substring(0,tree_data_3_add_eval.length-1);
		tree_data_3_add_eval += "}}" ;
		if(execute){
			eval(tree_data_3_add_eval);
		}
	}
	
	return tree_data_3 ;
	
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
			var treeDataSource2 = new DataSourceTree({data: tree_data_3});
			
			var tree = $('#tree2').ace_tree({ 
				dataSource: treeDataSource2 ,
				loadingHTML:'<div class="tree-loading"><i class="ace-icon fa fa-refresh fa-spin blue"></i></div>',
				'open-icon' : 'ace-icon fa fa-folder-open',
				'close-icon' : 'ace-icon fa fa-folder',
				'selectable' : true,
				'selected-icon' : null,
				'unselected-icon' : null
			});
			
			$("div[class='tree-folder']").each(function(){ 
				
			});
			
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