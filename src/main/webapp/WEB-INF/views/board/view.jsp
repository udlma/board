<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Forms</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">Basic Form Elements</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-6">
							<form role="form">
								<div class="form-group">
									<label>Title</label> <input class="form-control"
										value="${vo.title }" readonly="readonly">

								</div>
								<div class="form-group">
									<label>Writer</label> <input class="form-control"
										value="${vo.writer }" readonly="readonly">
								</div>


								<div class="form-group">
									<label>Content area</label>
									<textarea class="form-control" rows="3" readonly="readonly">${vo.content}</textarea>
								</div>

							</form>
							<c:if test="${param.type == null }">
								<a href="/board/list?page=${param.page }"><button>Back</button></a>
							</c:if>
							<c:if test="${param.type != null }">
								<a
									href="/board/list?page=${param.page }&type=${param.type }&keyword=${param.keyword }"><button>Back</button></a>
							</c:if>
							<c:if test="${param.type == null and vo.writer eq userName}">
								<a href="/board/update?page=${param.page }&bno=${param.bno}"><button>Update</button></a>
							</c:if>
							<c:if test="${param.type != null and vo.writer eq userName}">
								<a
									href="/board/update?page=${param.page }&bno=${param.bno}&type=${param.type }&keyword=${param.keyword }"><button>Update</button></a>
							</c:if>
							<c:if test="${vo.writer eq userName}">
							<a href="/board/delete?page=${param.page }&bno=${param.bno}"><button>Delete</button></a>
							</c:if>						
						</div>
						<div>
							replyer<input type="text" name="replyer" id="replyer" readonly="readonly" value="${userName }">
							replytext<input type="text" name="replytext" id="reply">
							<button id="replyBtn" data-type="reply">+</button>
						</div>

						<div>
							<ul class="replyList">

							</ul>
						</div>
						<div>
							<ul class="pagination">
							</ul>
						</div>

						<!-- /.col-lg-6 (nested) -->
					</div>
					<!-- /.row (nested) -->
				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
</div>
<!-- /#page-wrapper -->

</div>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>

<script>

var page = 1;
var bno = ${param.bno};
var replyList = $(".replyList");
var replyBtn = $("#replyBtn");
var reply = $("#reply");
var replyer = $("#replyer");
var rno = null;
var replyBtnData = null;
var pagination = $(".pagination");
var csrftoken = "${_csrf.token}";



$(document).ready(function () {
	
	getAllList(page);
	
});


replyBtn.on("click", function (e) {
	replyBtnData = replyBtn.attr("data-type");
	
	setCSRF(csrftoken);
	
	if(replyBtnData === 'reply'){
		$.ajax({
			
			url : "/reply/new",
			type : "post",
			dataType : "text",
			data : JSON.stringify({
				bno : bno,
				replyer : replyer.val(),
				replytext : reply.val()
			}),
			headers : {
				"Content-Type" : "application/json",
			},
			success : function (result) {
				if(result == "success"){
					alert("reply success");
					getAllList(page);
					reply.val("");
				}
			}
		});
		
	}else if(replyBtnData === 'update'){
		$.ajax({
			url : "/reply/"+$(e.target).attr("data-rno"),
			type : "put",
			dataType : "text",
			data : JSON.stringify({
				replytext : reply.val()
			}),
			headers : {
				"Content-Type" : "application/json"
			},
			success : function (result) {
				if(result == "success"){
					alert("reply update success");
					getAllList(page);
					reply.val("");
					replyBtn.html("+");
					replyBtn.attr("data-type", "reply");
				}
			}
		});
	}
});

	

replyList.on("click", "button", function (e) {
	
	var button = $(this).html();
	
	rno = $(e.target).parent().attr("data-rno");
	
	if(button === 'x'){
		$.ajax({
			url : "/reply/"+rno,
			type : "delete",
			dataType : "text",
			headers : {
				"Content-Type" : "application/json"
			},
			success : function (result) {
				if(result == "success"){
					alert("reply delete success");
					getAllList(page);
				}
			}	
		});
	}else if(button === 'u'){
		$.getJSON("/reply/"+rno, function (data) {
			reply.val(data.replytext);
			replyer.val(data.replyer);
			replyBtn.html("u");
			replyBtn.attr("data-type", "update");
			replyBtn.attr("data-rno", data.rno);
		});
	}
});

pagination.on("click", "a", function (e) {
	
	e.preventDefault();
	console.log(this);
	page = $(e.target).attr("href");
	getAllList(page);
	
});



function getAllList(page) {
	
	var str = "";
	
	$.getJSON("/reply/"+bno+"/"+page, function (data) {
		
		$(data.list).each(function (e) {
			
			str += "<li data-rno='"+this.rno+"'>"+this.replyer+":"+this.replytext;
			
			if(this.replyer == "${userName}"){
				str	+="<button>x</button><button>u</button></li>";
			}
		});
		
		replyList.html(str);
		paging(data.pm);
		
	});
	
}

function paging(pm) {
	
	var str2 = "";
	
	if(pm.prev){
		str2 += "<li><a href='"+(pm.start-1)+"'>prev</a></li>";
	}
	for(var i=pm.start; i <= pm.end; i++){
		str2 += "<li><a href='"+i+"'>"+i+"</a></li>";
	}
	if(pm.next){
		str2 += "<li><a href='"+(pm.end+1)+"'>next</a></li>";
	}
	
	pagination.html(str2);
	
	
}

function setCSRF(tokenValue){

	$.ajaxSetup({
			headers: { 'X-CSRF-TOKEN' : tokenValue}
		   });
	}


</script>


<script>

if(${value eq 'usuccess'}){
	
	alert("modify success");
	
}

</script>

<%@ include file="/WEB-INF/views/includes/footer.jsp"%>