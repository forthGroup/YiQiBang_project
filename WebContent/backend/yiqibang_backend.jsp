<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>后台管理界面</title>
    <link rel="stylesheet" href="../css/manage.css">
    <link rel="stylesheet" href="../bootstrap/dist/css/bootstrap.min.css">
    <script src="../JQuery/jquery-3.2.1.min.js"></script>
    <script src="../bootstrap/dist/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../js/backend.js"></script>
    
    <!-- eEditor -->
	<!-- 配置文件 -->
	<script type="text/javascript" src="../JQuery/uEditer/ueditor.config.js"></script>
	<!-- 编辑器源码文件 -->
	<script type="text/javascript" src="../JQuery/uEditer/ueditor.all.js"></script>
    <script>
        $(function () {
            $(".manage_left div table tr").click(function () {
                $(".manage_left div table tr").css("background","#BB9A34");
                $(this).css("background","#A77C1E");

                $(".manage_right>div").css("display","none");
                $(".manage_right>div").eq($(this).index()).show();

                $(".manage_left div:first-child table tr td:nth-child(3)").css("display","none");
                $(".manage_left div:first-child table tr td:nth-child(3)").eq($(this).index()).show();
            });


            $(".manage_right1 div:first-child div:first-child div").click(function () {
                $(".manage_right1 div:first-child div:first-child div").css("background","#c9d66d");
                $(this).css("background","#4fb133");

                $(".userMessage1>thead").css("display","none");
                $(".userMessage1>thead").eq($(this).index()).show();
            });
     
        })
        
        function addNewsBtn(){
        	$("#addNewsModal").modal('show');
        }
        
    </script>
</head>
<body>
    <div class="header">
        <div class="header_left">
            <div><a href=""><img src="../img/public/touxiang.png"></a></div>
            <div><a href="">刘老师</a></div>
        </div>
        <div class="header_right">
            <a href="">注销</a>
        </div>
    </div>
    <div class="manage">
        <div class="manage_left">
            <div>
                <table cellpadding="0" cellspacing="0">
                    <tr>
                        <td><img src="../img/public/yonghuguanli.png"></td>
                        <td>用户管理</td>
                    </tr>
                    <tr>
                        <td><img src="../img/public/xinwenguuanli.png"></td>
                        <td>新闻管理</td>
                    </tr>
                    <tr>
                        <td><img src="../img/public/pinglunguanli.png"></td>
                        <td>评论管理</td>
                    </tr>
                    <tr>
                        <td><img src="../img/public/xinwenpachong.png"></td>
                        <td>新闻爬虫</td>
                    </tr>
                    <tr>
                        <td><img src="../img/public/xinwenguanlfenlei.png"></td>
                        <td>新闻分类管理</td>
                    </tr>
                </table>
            </div>
            <div><img src="../img/public/logo.png"></div>
        </div>
        <div class="manage_right">
            <div class="manage_right1">
                <div>
                    <div>
                        <div>会员</div>
                        <div>管理员</div>
                    </div>
                    <div class="input-group">
                        <input type="text" placeholder="昵称/用户名/手机/备注">
                        <button class="btn glyphicon glyphicon-search"id="search"></button>
                    </div>
                    <div>
                        <button class="btn" type="button" id="addUser" onclick="addUsersBtn()"><span class="glyphicon glyphicon-plus-sign"></span>添加</button>
                    </div>
                </div>
                <div class="userMessage">
                    <table cellpadding="5px" cellspacing="0" class="userMessage1">
                        <thead class="member_information">
                            <th>序号</th>
                            <th>用户名</th>
                            <th>昵称</th>
                            <th>性别</th>
                            <th>生日</th>
                            <th>地址</th>
                            <th>手机号码</th>
                            <th>状态</th>
                            <th>创建时间</th>
                            <th>修改时间</th>
                            <th>登录时间</th>
                            <th>头像</th>
                            <th>备注</th>
                            <th>设为管理员</th>
                            <th>操作</th>
                        </thead>

                        <thead class="manager_information">
                            <th>序号</th>
                            <th>级别</th>
                            <th>状态</th>
                            <th>用户名</th>
                            <th>添加时间</th>
                            <th>操作</th>
                        </thead>

                        <tbody>

                        </tbody>
                    </table>
                </div>
            </div>

            <div class="manage_right2">
                <div>
                    <div class="input-group">
                        <input type="text" placeholder="输入搜索内容">
                        <button class="btn glyphicon glyphicon-search" id="search"></button>
                    </div>
                    <div>
                        <button class="btn" type="button" onclick="addNewsBtn()"><span class="glyphicon glyphicon-plus-sign"></span>添加</button>
                    </div>
                </div>
                <div class="userMessage">
                    <table cellpadding="5px" cellspacing="0">
                        <thead>
                        	<tr>
                        		<th>序号</th>
								<th>类型</th>
								<th>标题</th>
								<th>来源</th>
								<th>作者</th>
								<th>内容</th>
								<th>时间</th>
								<th>评论</th>
								<th>浏览</th>
								<th>是否热点</th>
								<th>是否被举报</th>
								<th>操作</th>
                        	</tr>
                        </thead>
                        <tbody id="newsList_body">

                        </tbody>
                    </table>
                </div>
            </div>

            <div class="manage_right3">
                <div>
                    <div class="input-group">
                        <input type="text" placeholder="输入搜索内容">
                        <button class="btn glyphicon glyphicon-search"id="search"></button>
                    </div>
                    <div>
                        <button class="btn" type="button"><span class="glyphicon glyphicon-plus-sign"></span>添加</button>
                    </div>
                </div>
                <div class="userMessage">
                    <table cellpadding="5px" cellspacing="0">
                        <thead>
                        	<tr>
		                        <th>序号</th>
		                        <th>评论新闻</th>
		                        <th>评论用户</th>
		                        <th>类型</th>
		                        <th>评分</th>
		                        <th>评论内容</th>
		                        <th>状态</th>
		                        <th>是否删除</th>
		                        <th>评论时间</th>
		                        <th>操作</th>
		                    </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>
                </div>
            </div>

            <div class="manage_right4">
                <div>
                    <div class="input-group">
                        <input type="text" placeholder="输入搜索内容" id="searchTv">
                        <button class="btn glyphicon glyphicon-search" id="search"></button>
                    </div>
                    <div>
                        <button class="btn" type="button"><span class="glyphicon glyphicon-plus-sign"></span>添加</button>
                    </div>
                </div>
                <div class="userMessage">
                    <table cellpadding="5px" cellspacing="0">
                        <thead>
                        <th>序号</th>
                        <th>类型</th>
                        <th>标题</th>
                        <th>时间</th>
                        <th>审核</th>
                        <th>操作</th>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>
                </div>
            </div>

            <div class="manage_right5">
                <div>
                    <div class="input-group">
                        <input type="text" placeholder="输入搜索内容">
                        <button class="btn glyphicon glyphicon-search" id="search"></button>
                    </div>
                    <div>
                        <button class="btn" type="button"><span class="glyphicon glyphicon-plus-sign"></span>添加</button>
                    </div>
                </div>
                <div class="userMessage">
                    <table cellpadding="5px" cellspacing="0">
                        <thead>
                        <th>序号</th>
                        <th>名称</th>
                        <th>创建时间</th>
                        <th>操作</th>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    
    <!-- Modal -->
	<div class="modal fade" id="addNewsModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">

					<h4 class="modal-title" id="myModalLabel">添加新闻</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="addNewsForm"
						action="/YiQiBang_project/NewsServlet?action=adminInsertNews"
						method="post">
						<div class="form-group">
							<label class="col-sm-2 control-label">类型</label>
							<div class="col-sm-8">
								<select id="typeid" name="typeid" class="form-control">
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">标题</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="title" name="title"
									placeholder="标题" value="马蓉首现身">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">来源</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="source"
									name="source" placeholder="来源" value="风行工作室">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">作者</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="author"
									name="author" placeholder="作者" value="小卓伟">
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">内容</label>
							<div class="col-sm-9">
								<div>
									<script id="editor" type="text/plain"></script>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">是否为热点</label>
							<div class="col-sm-8">
								<label class="radio-inline"> <input type="radio"
									name="ifHot" id="yes" value="true" checked>是
								</label> <label class="radio-inline"> <input type="radio"
									name="ifHot" id="no" value="false"> 否
								</label>

							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary"
						onclick="addNewsSure()">确定</button>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$("#myModal").modal('show');

	//实例化编辑器
	var ue = UE.getEditor('editor', {
		//focus时自动清空初始化时的内容
		autoClearinitialContent : true,
		//关闭字数统计
		wordCount : false,
		//关闭elementPath
		elementPathEnabled : false,
		//默认的编辑区域高度
		initialFrameWidth : 700,
		initialFrameHeight : 300
	//更多其他参数，请参考ueditor.config.js中的配置项
	});
	//添加新闻按钮点击事件
	function addNewsSure() {
		var title = $("#title").val();
		var source = $('#source').val();
		var author = $("#author").val();
		var content = ue.getContent();
		var type = $("#typeid").val();
		var modal_title = $("#myModalLabel").text();
		var ifHot = $("#yes").prop("checked") ? true : false;
		if (title == "" || source == "" || author == "" || content == "") {
			alert("请输入内容");
			return;
		}
		var data = {
				title : title,
				typeid : type,
				content : content,
				source : source,
				author : author,
				ifHot : ifHot
			}
		if (modal_title == "修改新闻") {
			data.newsid=$("#newsid").val();
			data.action="adminUpdateNews";
		} else {
			data.action ="adminInsertNews";
		}
		$.ajax({
			url : "/YiQiBang_project/NewsServlet",
			data : data,
			type : "post",
			timeout : 5000,
			beforesend : function() {
				$('#myModal').modal('show');
			},
			success : function(data) {
				console.log(data);
				var jsData = JSON.parse(data);
				if (jsData.retCode == 0) {
					location.reload();
				}
			},
			error : function(e) {
				alert("上传失败");
			},
			complete : function() {
				$('#myModal').modal('hide');
				$("#addNewsModal").modal('hide');
			}
		});
	}
</script>


</html>