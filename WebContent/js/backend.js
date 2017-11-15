
$(function() {
		getPageAllNews(1);
		getAllTypes();
		getPageCounts();
		$("#pageBtn li").click(function(){
			if($(this).index()==0){//前一页
				alert($(this).find("span").text());
			}else if($(this).index()==6){//后一页
				alert($(this).find("span").text());
			}else{//点击某一页
				$(this).siblings().removeClass("active");
				$(this).addClass("active");
			}
		});
	});
	
	function getPageCounts(){
		
	}


function getPageAllNews(pagenum) {
		$('#myModal').modal('show');
		$.getJSON("/YiQiBang_project/NewsServlet", {
			action : "adminGetAllNewsByPage",
			pageNum:pagenum
		}, function(data) {
			showNewsData(data);
		});
	}

function showNewsData(data) {
		if (data.retMsg) {
			$("#newsList_body").html("");
			var newslist = data.retData;
			for (var i = 0; i < newslist.length; i++) {
				var news = newslist[i];
				$("#newsList_body")
						.append(
								'<tr align="center" class="news_tr">' + '<td>'
										+ (i + 1)
										+ '</td>'
										+ '<td id="type'+i+'"></td>'
										+ '<td title="'+news.nTitle+'">'
										+ news.nTitle
										+ '</td>'
										+ '<td>'
										+ news.nSource
										+ '</td>'
										+ '<td>'
										+ news.nAuthor
										+ '</td>'
										+ '<td id="content'+i+'">'
										+ '<div>'
										+ news.nContent
										+ '</div>'
										+ '</td>'
										+ '<td>'
										+ getStrDate(news.nCreatetime.time)
										+ '</td>'
										+ '<td>'
										+ news.nCommcount
										+ '</td>'
										+ '<td>'
										+ news.nReadcount
										+ '</td>'
										+ '<td>'
										+ (news.nIfhot ? "是" : "否")
										+ '</td>'
										+ '<td>'
										+ (news.nIfreport ? "是" : "否")
										+ '</td>'
										+ '<td class="icon_row">'
										+ '<div class="row">'
										+ '<div class="col-md-6 text-center">'
										+ '<span class="glyphicon glyphicon-cog cofigBtn" id="configBtn'+i+'" ></span>'
										+ '</div>'
										+ '<div class="col-md-6 text-center">'
										+ '<span class="glyphicon glyphicon-trash" id="deleteBtn'
										+ i + '" onclick="deleteNew(' + news.id
										+ ')"></span>' + '</div>' + '</div>'
										+ '</td>' + '</tr>');
				$("#content" + i).attr("title", $("#content" + i).text());
				getTypeById(news.tTId, i);
			}
			$(".cofigBtn").each(function(index) {
				$("#configBtn" + index).click(function() {
					var news = newslist[index];
					//1.把模态框放出来
					$("#addNewsModal").modal('show');
					//2.将模态框里面显示的数据变成news对象里面的数据
					$("#myModalLabel").text("修改新闻");//修改模态框标题
					$("#addNewsModal #typeid").val(news.tTId);
					$("#addNewsModal #title").val(news.nTitle);
					$("#addNewsModal #source").val(news.nSource);
					$("#addNewsModal #author").val(news.nAuthor);
					$("#newsid").val(news.id);
					//3.修改确定按钮 事件
					var ue = UE.getEditor('editor',{ 
						initialFrameWidth : 700,
                		initialFrameHeight : 300
					});
					ue.setContent(news.nContent);
					console.log(news);
					if (news.nIfhot) {
						$("#yes").attr("checked", true);
						$("#no").removeAttr("checked");
					} else {
						$("#yes").removeAttr("checked");
						$("#no").attr("checked", true);
					}

				});
			});

			$('#myModal').modal('hide');
		}
	}
/*根据id删除新闻*/
function deleteNew(newsId) {
	$.ajax({
		url : "/YiQiBang_project/NewsServlet",//请求url地址
		data : { //请求参数对象
			action : "adminDeleteNewsById",
			id : newsId
		},
		timeout : 5000,//请求超时时间，以ms为单位
		type : "post",//请求方式
		beforesend : function() { //请求开始发送之前的回掉方法
			$('#myModal').modal('show');
		},
		success : function(data) {//请求成功回掉函数
			var objData = JSON.parse(data);
			if (objData.retCode == 0) {
				location.reload();
			}

		},
		error : function(e) {//请求失败回掉函数
			alert("类型获取异常" + e);
		},
		complete : function() {//请求完成时候的回调函数
			$('#myModal').modal('hide');
		}
	});
}

/*根据类型id获取类型*/
function getTypeById(typeId, index) {
	$.ajax({
		url : "/YiQiBang_project/TypeServlet",//请求url地址
		data : { //请求参数对象
			action : "adminGetTypeById",
			id : typeId
		},
		timeout : 5000,//请求超时时间，以ms为单位
		type : "get",//请求方式
		beforesend : function() { //请求开始发送之前的回掉方法
			$('#myModal').modal('show');
		},
		success : function(data) {//请求成功回掉函数
			var objData = JSON.parse(data);//将字符串对象转化为js的Object对象
			if (objData.retCode == 0) {
				$("#type" + index).text(objData.retData.tName);
			}
		},
		error : function(e) {//请求失败回掉函数
			alert("类型获取异常" + e);
		},
		complete : function() {//请求完成时候的回调函数
			$('#myModal').modal('hide');
		}
	});
}
/**
 * 获取所有类型
 */
function getAllTypes() {
	$.ajax({
		url : "/YiQiBang_project/TypeServlet",
		data : {
			action : "adminGetAllTypes"
		},
		type : "get",
		timeout : 5000,
		beforesend : function() {
			$('#myModal').modal('show');
		},
		success : function(data) {
			var jsData = JSON.parse(data);
			$("#typeid").html("");
			for (var i = 0; i < jsData.retData.length; i++) {
				var type = jsData.retData[i];
				$("#typeid").append(
						'<option value="'+type.id+'">' + type.tName
								+ '</option>');
			}
		},
		error : function(e) {
			//alert("上传失败");
		},
		complete : function() {
			$('#myModal').modal('hide');
		}
	});
}

function searchNewsByLike() {
	var searchTv = $("#searchTv").val();
	if (searchTv == "") {
		getAllNews();
	} else {
		$.ajax({
			url : "/YiQiBang_project/NewsServlet",
			data : {
				action : "adminGetNewsByLike",
				likeStr : searchTv
			},
			type : "get",
			timeout : 5000,
			beforesend : function() {
				$('#myModal').modal('show');
			},
			success : function(data) {
				var datas = JSON.parse(data);
				showNewsData(datas);
			},
			error : function(e) {
				alert("上传失败");
			},
			complete : function() {
				$('#myModal').modal('hide');
			}
		});
	}

}

